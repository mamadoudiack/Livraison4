package sn.objis.livraison4.presentation;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * La classe principale 'App', point d'entree de l'application .
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 *
 */
public class Application {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("InfoLogging");
		MenuELeve menuELeve = new MenuELeve();
		MenuProfesseur menuProfesseur = new MenuProfesseur();
		Scanner sc = new Scanner(System.in);
		char response;
		do {
			logger.info("Bienvenue dans votre application Gestion scolaire veuillez faire votre choix");
			logger.info("1:Eleve");
			logger.info("2:professeur");
			logger.info("3:Quitter");

			int choix = 0;

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
				menuELeve.menuCompleEleve();
				break;
			case 2:
				menuProfesseur.menuCompleProfesseur();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				logger.info("entre un nombre compris entrev1 et 7");

			}

			logger.info("pour retourner au menu principal tapez: O/o et sur n'importe quelle touche pour quitter");
			response = sc.nextLine().charAt(0);
			if (response != 'O' && response != 'o') {
				System.exit(0);
			}
		} while (response == 'O' || response == 'o');
	}
}
