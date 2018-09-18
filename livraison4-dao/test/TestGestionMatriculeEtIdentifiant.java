package sn.objis.testDao;

import org.junit.Before;
import org.junit.Test;

import sn.objis.LIV4SERVER.doa.GestionMatriculeEtIdentifiant;

/**
 * La classe 'TestGestionMatriculeEtIdentifiant' permet de tester les
 * differentes methodes de la classe 'GestionMatriculeEtIdentifiant'
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 */
public class TestGestionMatriculeEtIdentifiant {

	/**
	 * Declaration d'une variable de type ProfesseurEmp
	 */
	GestionMatriculeEtIdentifiant gestionMatriculeEtIdentifiant;

	/**
	 * cette methode sera executee avant le lancement des tests
	 */
	@Before
	public void init() {
		gestionMatriculeEtIdentifiant = new GestionMatriculeEtIdentifiant();
	}

	/**
	 * cette methode permet de tester la methode MatEtudiant
	 */
	@Test
	public void testMatEtudiant() {
		gestionMatriculeEtIdentifiant.matEtudiant();
	}

	/**
	 * cette methode permet de tester la methode Matformateur
	 */
	@Test
	public void testMatformateur() {
		gestionMatriculeEtIdentifiant.matformateur();
	}

}
