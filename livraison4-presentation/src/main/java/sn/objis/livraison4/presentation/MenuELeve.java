package sn.objis.livraison4.presentation;



import java.util.List;
import java.util.Scanner;

import sn.objis.livraison4.domaine.Eleve;
import sn.objis.livraison4.service.EleveServiceEmp;
import sn.objis.livraison4.service.MatEleveProf;


/**
 * La classe 'MenuProfesseur' permet de tester les differents services de
 * l'eleve	
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 *
 */
public class MenuELeve {
	Scanner sc = new Scanner(System.in);
	EleveServiceEmp eleveServiceEmp = new EleveServiceEmp();
	MatEleveProf matEleveProf = new MatEleveProf();

	private void EcranMenu() {
		System.out.println("Bienvenue dans votre application Gestion scolaire veuillez faire votre choix");
		System.out.println("1:Ajouter un eleve");
		System.out.println("2:Suprimer un eleve");
		System.out.println("3:Modifier un Eleve");
		System.out.println("4:Afficher la liste des eleves");
		System.out.println("5:Afficher un eleve");
		System.out.println("6:Retourner au menu principale");
		System.out.println("7:Quitter");

	}

	private void afficherUnEleve() {
		Eleve e = null;
		System.out.println("Veuillez saisir le matricule de l'eleve  : ");

		String ideleve = sc.nextLine();
		e = eleveServiceEmp.rechercherParMatricule(ideleve);
		if (e == null) {
			System.out.println("L'eleve n'existe pas");
		} else {
			eleveServiceEmp.afficher(e);
		}
	}

	public void AjouterUnEleve() {
		Eleve eleve = null;
		String mat = matEleveProf.matEtudiantService();
		System.out.println("Veuillez saisir le nom de l'eleve : ");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir le prenom de l'eleve : ");
		String prenom = sc.nextLine();
		System.out.println("Veuillez saisir l'adresse de l'eleve : ");
		String adresse = sc.nextLine();
		System.out.println("Veuillez saisir le numero de telephone de l'eleve : ");
		String tel = sc.nextLine();
		System.out.println("Veuillez saisir la date de naissance de l'eleve : ");
		String date = sc.nextLine();
		System.out.println("Veuillez saisir la moyenne de l'eleve : ");
		double moyenne = 0;
		do {

			try {

				moyenne = Double.parseDouble(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("regarder la moyenne saisie");
			}
		} while (true);
		eleve = new Eleve(nom, prenom, adresse, tel, mat, date, moyenne);
		eleveServiceEmp.ajouter(eleve);
	}

	private void supprimerEleve() {
		System.out.println("Veuillez saisir le matricule de l'eleve a supprimer : ");
		String ideleve = sc.nextLine();
		Eleve eleve = eleveServiceEmp.rechercherParMatricule(ideleve);
		if (eleve != null) {
			eleveServiceEmp.supprimer(eleve);
		} else {
			System.out.println("le matricule n'existe pas");
		}
	}

	private void listeEleve() {
		List<Eleve> listeEleve = eleveServiceEmp.lister();
		eleveServiceEmp.afficheListe(listeEleve);

	}

	private void modifierEleve() {
		Eleve eleve = null;
		System.out.println("Veuillez saisir le matricule de l'eleve a modifier : ");
		String ideleve = sc.nextLine();
		eleve = eleveServiceEmp.rechercherParMatricule(ideleve);
		{
			if (eleve != null) {
				//String mat = matEleveProf.matEtudiantService();
				System.out.println("Veuillez saisir le nouveau nom de l'eleve : ");
				eleve.setNom(sc.nextLine());
				System.out.println("Veuillez saisir le nouveau prenom de l'eleve : ");
				eleve.setPrenom(sc.nextLine());
				eleveServiceEmp.maj(eleve);
			} else {
				System.out.println("le matricule n'existe pas");
			}
		}

	}

	public void menuCompleEleve() {
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
				AjouterUnEleve();
				break;
			case 2:
				supprimerEleve();
				break;
			case 3:
				modifierEleve();
				break;
			case 4:
				listeEleve();
				break;
			case 5:
				afficherUnEleve();
				break;
			case 6:
				Application.main(null);
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("entre un nombre compris entrev1 et 7");
				menuCompleEleve();
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
