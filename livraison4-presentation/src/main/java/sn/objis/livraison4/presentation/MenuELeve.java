package sn.objis.livraison4.presentation;



import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

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
	Logger logger = Logger.getLogger("InfoLogging");
	private static final String NMATRICULE = "le matricule n'existe pas"; 
	private void ecranMenu() {
		logger.info("Bienvenue dans votre application Gestion scolaire veuillez faire votre choix");
		logger.info("1:Ajouter un eleve");
		logger.info("2:Suprimer un eleve");
		logger.info("3:Modifier un Eleve");
		logger.info("4:Afficher la liste des eleves");
		logger.info("5:Afficher un eleve");
		logger.info("6:Retourner au menu principale");
		logger.info("7:Quitter");
		
	}

	private void afficherUnEleve() {
		Eleve e = null;
		logger.info("Veuillez saisir le matricule de l'eleve  : ");
		
		String ideleve = sc.nextLine();
		e = eleveServiceEmp.rechercherParMatricule(ideleve);
		if (e == null) {
			logger.info("L'eleve n'existe pas");
		} else {
			eleveServiceEmp.afficher(e);
		}
	}

	public void ajouterUnEleve() {
		Eleve eleve = null;
		String mat = matEleveProf.matEtudiantService();
		logger.info("Veuillez saisir le nom de l'eleve : ");
		String nom = sc.nextLine();
		logger.info("Veuillez saisir le prenom de l'eleve : ");
		String prenom = sc.nextLine();
		logger.info("Veuillez saisir l'adresse de l'eleve : ");
		String adresse = sc.nextLine();
		logger.info("Veuillez saisir le numero de telephone de l'eleve : ");
		String tel = sc.nextLine();
		logger.info("Veuillez saisir la date de naissance de l'eleve : ");
		String date = sc.nextLine();
		logger.info("Veuillez saisir la moyenne de l'eleve : ");
		double moyenne = 0;
		do {

			try {

				moyenne = Double.parseDouble(sc.nextLine());
				break;
			} catch (Exception e) {
				logger.info("regarder la moyenne saisie");
			}
		} while (true);
		eleve = new Eleve(nom, prenom, adresse, tel, mat, date, moyenne);
		eleveServiceEmp.ajouter(eleve);
	}

	private void supprimerEleve() {
		logger.info("le matricule de l'eleve a supprimer : ");
		String ideleve = sc.nextLine();
		Eleve eleve = eleveServiceEmp.rechercherParMatricule(ideleve);
		if (eleve != null) {
			eleveServiceEmp.supprimer(eleve);
		} else {
			logger.info(NMATRICULE);
		}
	}

	private void listeEleve() {
		List<Eleve> listeEleve = eleveServiceEmp.lister();
		eleveServiceEmp.afficheListe(listeEleve);

	}

	private void modifierEleve() {
		Eleve eleve = null;
		logger.info("Veuillez entre le matricule de l'eleve a modifier : ");
		String ideleve = sc.nextLine();
		eleve = eleveServiceEmp.rechercherParMatricule(ideleve);
		
			if (eleve != null) {
				
				logger.info("Veuillez entre le nouveau nom de l'eleve : ");
				eleve.setNom(sc.nextLine());
				logger.info("Veuillez entre le nouveau prenom de l'eleve : ");
				eleve.setPrenom(sc.nextLine());
				eleveServiceEmp.maj(eleve);
			} else {
				logger.info(NMATRICULE);
			}
		

	}

	public void menuCompleEleve() {
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
				ajouterUnEleve();
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
				logger.info("entre un nombre compris entrev1 et 7");
				menuCompleEleve();
			}

			logger.info("pour retourner au menu principal tapez: O/o et sur n'importe quelle touche pour quitter");

			response = sc.nextLine().charAt(0);
			if (response != 'O' && response != 'o') {
				System.exit(0);
			}
		} while (response == 'O' || response == 'o');
	}

}
