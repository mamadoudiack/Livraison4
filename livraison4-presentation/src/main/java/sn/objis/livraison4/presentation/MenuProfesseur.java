package sn.objis.livraison4.presentation;



import java.util.List;
import java.util.Scanner;

import sn.objis.livraison4.domaine.Professeur;
import sn.objis.livraison4.service.MatEleveProf;
import sn.objis.livraison4.service.ProfesseurServiceEmp;


/**
 * La classe 'MenuProfesseur' permet de tester les differents services de
 * professeur
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 *
 */
public class MenuProfesseur {

	Scanner sc = new Scanner(System.in);

	ProfesseurServiceEmp professeurServiceEmp = new ProfesseurServiceEmp();
	MatEleveProf matEleveProf = new MatEleveProf();

	private void EcranMenu() {
		System.out.println("Bienvenue dans votre application Gestion scolaire veuillez faire votre choix");
		System.out.println("1:Ajouter un Professeur");
		System.out.println("2:Suprimer un Professeur");
		System.out.println("3:Modifier un Professeur");
		System.out.println("4:Afficher la liste des Professeur");
		System.out.println("5:Afficher un Professeur");
		System.out.println("6:Retourner au menu principale");
		System.out.println("7:Quitter");

	}

	private void afficherUnProfesseur() {
		Professeur prof = null;
		System.out.println("Veuillez saisir le matricule du Professeur  : ");

		String idProf = sc.nextLine();
		prof = professeurServiceEmp.rechercherParIdentifiant(idProf);
		if (prof == null) {
			System.out.println("Le Professeur n'existe pas");
		} else {
			professeurServiceEmp.afficher(prof);
		}
	}

	public void AjouterUnProfesseur() {
		Professeur prof = null;
		String mat = matEleveProf.IdprofService();
		System.out.println("Veuillez saisir le nom de du Professeur : ");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir le prenom du Professeur : ");
		String prenom = sc.nextLine();
		System.out.println("Veuillez saisir l'adresse du Professeur : ");
		String adresse = sc.nextLine();
		System.out.println("Veuillez saisir le numero de telephone du Professeur : ");
		String tel = sc.nextLine();
		System.out.println("Veuillez saisir le duplome du Professeur : ");
		String diplome = sc.nextLine();

		prof = new Professeur(nom, prenom, adresse, tel, mat, diplome);
		professeurServiceEmp.ajouter(prof);
	}

	private void supprimerProfesseur() {
		System.out.println("Veuillez saisir le matricule du Professeur a supprimer : ");
		String idprof = sc.nextLine();
		Professeur prof = professeurServiceEmp.rechercherParIdentifiant(idprof);
		if (prof != null) {
			professeurServiceEmp.supprimer(prof);
		} else {
			System.out.println("le matricule n'existe pas");
		}
	}

	private void listeProfesseur() {
		List<Professeur> listeProfesseur = professeurServiceEmp.lister();
		professeurServiceEmp.afficheListe(listeProfesseur);

	}

	private void modifierProfesseur() {
		Professeur prof = null;
		System.out.println("Veuillez saisir le matricule du Professeur a modifier : ");
		String idProf = sc.nextLine();
		prof = professeurServiceEmp.rechercherParIdentifiant(idProf);
		{
			if (prof != null) {

				System.out.println("Veuillez saisir le nouveau nom du  Professeur : ");
				prof.setNom(sc.nextLine());
				System.out.println("Veuillez saisir le nouveau prenom du  Professeur: ");
				prof.setPrenom(sc.nextLine());
				professeurServiceEmp.maj(prof);
			} else {
				System.out.println("le matricule n'existe pas");
			}
		}

	}

	public void menuCompleProfesseur() {
		int choix = 0;
		char response;
		do {
			EcranMenu();
			do {
				try {
					choix = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("entre un entier");
				}
			} while (true);

			switch (choix) {
			case 1:
				AjouterUnProfesseur();
				break;
			case 2:
				supprimerProfesseur();
				break;
			case 3:
				modifierProfesseur();
				break;
			case 4:
				listeProfesseur();
				break;
			case 5:
				afficherUnProfesseur();
				break;
			case 6:
				Application.main(null);
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("entre un nombre compris entrev1 et 7");
				menuCompleProfesseur();
			}

			System.out
					.println("pour retourner au menu principal tapez: O/o et sur n'importe quelle touche pour quitter");

			response = sc.nextLine().charAt(0);
			if (response != 'O' && response != 'o') {
				System.exit(0);
			}
		} while (response == 'O' || response == 'o');
	}

}
