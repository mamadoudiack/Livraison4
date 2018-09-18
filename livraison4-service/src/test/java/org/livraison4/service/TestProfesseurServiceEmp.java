package org.livraison4.service;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sn.objis.livraison4.domaine.Professeur;
import sn.objis.livraison4.service.ProfesseurServiceEmp;

/**
 * La classe 'TestProfesseurServiceEmp' permet de tester les differentes
 * methodes de la classe 'ProfesseurServiceEmp'
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 */
public class TestProfesseurServiceEmp {
	Professeur prof = new Professeur("sene", "moussa", "ngaye", "787654345", "prof1212", "bac2");
	/**
	 * Declaration d'une variable de type ProfesseurServiceEmp
	 */
	ProfesseurServiceEmp professeurServiceEmp;

	/**
	 * cette methode sera executee avant le lancement des tests
	 */
	@Before
	public void init() {
		professeurServiceEmp = new ProfesseurServiceEmp();
	}

	/**
	 * cette methode permet de tester la methode Ajouter
	 */
	@Test
	public void testAjouter() {
		professeurServiceEmp.ajouter(prof);
	}

	/**
	 * cette methode permet de tester la methode Maj
	 */
	@Test
	public void testMaj() {
		professeurServiceEmp.maj(prof);
	}

	/**
	 * cette methode permet de tester la methode Lister
	 */
	@Test
	public void testLister() {
		List<Professeur> list = new ArrayList<Professeur>();
		list = professeurServiceEmp.lister();
		Assert.assertNotNull(list);

	}

	/**
	 * cette methode permet de tester la methode Supprimer
	 */
	@Test
	public void testSupprimer() {
		professeurServiceEmp.supprimer(prof);
	}

	/**
	 * cette methode permet de tester la methode RechercherParIdentifiant
	 */
	@Test
	public void testRechercherParIdentifiant() {
		Professeur prof;
		String idprof = "ID-PROF-2018-1";
		prof = professeurServiceEmp.rechercherParIdentifiant(idprof);
		Assert.assertNotNull(prof);
	}

	/**
	 * cette methode permet de tester la methode Afficher
	 */
	@Test
	public void testAfficher() {
		professeurServiceEmp.afficher(prof);
	}

	/**
	 * cette methode permet de tester la methode AfficheListe
	 */
	@Test
	public void testAfficheListe() {
		List<Professeur> list = new ArrayList<Professeur>();
		list.add(prof);
	}

}
