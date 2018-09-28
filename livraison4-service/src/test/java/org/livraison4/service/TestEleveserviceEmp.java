package org.livraison4.service;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sn.objis.livraison4.domaine.Eleve;
import sn.objis.livraison4.service.EleveServiceEmp;

/**
 * La classe 'TestEleveserviceEmp ' permet de tester les differentes methodes de
 * la classe 'EleveserviceEmp'
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 */
public class TestEleveserviceEmp {
	Eleve eleve = new Eleve("mamadou", "diack", "thiaroye", "777777777", "mat12222", "12/12/1999", 12);
	/**
	 * Declaration d'une variable de type eleveServiceEmp
	 */
	EleveServiceEmp eleveServiceEmp;

	/**
	 * cette methode sera executee avant le lancement des tests
	 */
	@Before
	public void init() {
		eleveServiceEmp = new EleveServiceEmp();
	}

	/**
	 * cette methode permet de tester la methode Ajouter
	 */
	@Test
	public void testAjouter() {
		eleveServiceEmp.ajouter(eleve);
	}

	/**
	 * cette methode permet de tester la methode Maj
	 */
	@Test
	public void testMaj() {
		eleveServiceEmp.maj(eleve);
	}

	/**
	 * cette methode permet de tester la methode testLister
	 */
	@Test
	public void testLister() {
		List<Eleve> list = new ArrayList<Eleve>();
		list = eleveServiceEmp.lister();
		Assert.assertNotNull(list);
	}

	/**
	 * cette methode permet de tester la methode Supprimer
	 */
	@Test
	public void testSupprimer() {
		eleveServiceEmp.supprimer(eleve);
	}

	/**
	 * cette methode permet de tester la methode RechercherParMatricule
	 */
	@Test
	public void testRechercherParMatricule() {
		Eleve elev;
		String mat = "Mat-E-20183";
		elev = eleveServiceEmp.rechercherParMatricule(mat);
	}

	/**
	 * cette methode permet de tester la methode Afficher
	 */
	@Test
	public void testAfficher() {
		eleveServiceEmp.afficher(eleve);
	}

	/**
	 * cette methode permet de tester la methode AfficheListe
	 */
	@Test
	public void testAfficheListe() {
		List<Eleve> list = new ArrayList<Eleve>();
		list.add(eleve);
		list.add(eleve);
		eleveServiceEmp.afficheListe(list);
	}

}
