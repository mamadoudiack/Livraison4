package sn.objis.testDao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sn.objis.LIV4SERVER.doa.ProfesseurEmp;
import sn.objis.LIV4SERVER.domaine.Professeur;

/**
 * La classe 'TestProfesseurDao' permet de tester les differentes methodes de la
 * classe 'ProfesseurEmp'
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 */
public class TestProfesseurDao {
	Professeur prof = new Professeur("sene", "moussa", "ngaye", "787654345", "prof1212", "bac2");

	/**
	 * Declaration d'une variable de type ProfesseurEmp
	 */
	ProfesseurEmp professeurEmp;

	/**
	 * cette methode sera executee avant le lancement des tests
	 */
	@Before
	public void init() {
		professeurEmp = new ProfesseurEmp();
	}

	/**
	 * cette methode permet de tester la methode Create
	 */
	@Test
	public void testCreate() {
		professeurEmp.create(prof);
	}

	/**
	 * cette methode permet de tester la methode Update
	 */
	@Test
	public void testUpdate() {
		professeurEmp.update(prof);
	}

	/**
	 * cette methode permet de tester la methode Read
	 */
	@Test
	public void testRead() {
		List<Professeur> list = new ArrayList<>();
		list = professeurEmp.read();
		Assert.assertNotNull(list);
	}

	/**
	 * cette methode permet de tester la methode Delete
	 */
	@Test
	public void testDelete() {
		professeurEmp.delete(prof);
	}

	@Test
	/**
	 * cette methode permet de tester la methode IdentifiantProfesseur
	 */
	public void testFindByIdentifiantProfesseur() {
		Professeur prof;
		String idprof = "ID-PROF-2018-1";
		prof = professeurEmp.findByIdentifiantProfesseur(idprof);
		Assert.assertNotNull(prof);
	}

}
