package sn.objis.livraison4.presentation;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

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
	Logger logger = Logger.getLogger("InfoLogging");

	private void ecranMenu() {
		logger.info("Bienvenue dans votre application Gestion scolaire veuillez faire votre choix");
		logger.info("1:Ajouter un Professeur");
		logger.info("2:Suprimer un Professeur");
		logger.info("3:Modifier un Professeur");
		logger.info("4:Afficher la liste des Professeur");
		logger.info("5:Afficher un Professeur");
		logger.info("6:Retourner au menu principale");
		logger.info("7:Quitter");

	}

	private void afficherUnProfesseur() {
		Professeur prof = null;
		logger.info("Veuillez saisir le matricule du Professeur  : ");

		String idProf = sc.nextLine();
		prof = professeurServiceEmp.rechercherParIdentifiant(idProf);
		if (prof == null) {
			logger.info("Le Professeur n'existe pas");
		} else {
			professeurServiceEmp.afficher(prof);
		}
	}

	public void ajouterUnProfesseur() {
		Professeur prof = null;
		String mat = matEleveProf.idprofService();
		logger.info("Veuillez saisir le nom de du Professeur : ");
		String nom = sc.nextLine();
		logger.info("Veuillez saisir le prenom du Professeur : ");
		String prenom = sc.nextLine();
		logger.info("Veuillez saisir l'adresse du Professeur : ");
		String adresse = sc.nextLine();
		logger.info("Veuillez saisir le numero de telephone du Professeur : ");
		String tel = sc.nextLine();
		logger.info("Veuillez saisir le duplome du Professeur : ");
		String diplome = sc.nextLine();

		prof = new Professeur(nom, prenom, adresse, tel, mat, diplome);
		professeurServiceEmp.ajouter(prof);
	}

	private void supprimerProfesseur() {
		logger.info("Veuillez saisir le matricule du Professeur a supprimer : ");
		String idprof = sc.nextLine();
		Professeur prof = professeurServiceEmp.rechercherParIdentifiant(idprof);
		if (prof != null) {
			professeurServiceEmp.supprimer(prof);
		} else {
			logger.info("le matricule n'existe pas");
		}
	}

	private void listeProfesseur() {
		List<Professeur> listeProfesseur = professeurServiceEmp.lister();
		professeurServiceEmp.afficheListe(listeProfesseur);

	}

	private void modifierProfesseur() {
		Professeur prof = null;
		logger.info("Veuillez saisir le matricule du Professeur a modifier : ");
		String idProf = sc.nextLine();
		prof = professeurServiceEmp.rechercherParIdentifiant(idProf);
			if (prof != null) {

				logger.info("Veuillez saisir le nouveau nom du  Professeur : ");
				prof.setNom(sc.nextLine());
				logger.info("Veuillez saisir le nouveau prenom du  Professeur: ");
				prof.setPrenom(sc.nextLine());
				professeurServiceEmp.maj(prof);
			} else {
				logger.info("le matricule n'existe pas");
			}
	}

	public void menuCompleProfesseur() {
		int choix = 0;
		char response;
		do {
			ecranMenu();
			do {
				try {
					choix = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					logger.info("entre un entier");
				}
			} while (true);

			switch (choix) {
			case 1:
				ajouterUnProfesseur();
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
				logger.info("entre un nombre compris entrev1 et 7");
				menuCompleProfesseur();
			}

			logger.info("pour retourner au menu principal tapez: O/o et sur n'importe quelle touche pour quitter");

			response = sc.nextLine().charAt(0);
			if (response != 'O' && response != 'o') {
				System.exit(0);
			}
		} while (response == 'O' || response == 'o');
	}

}
