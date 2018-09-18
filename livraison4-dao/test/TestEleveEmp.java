package sn.objis.testDao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sn.objis.LIV4SERVER.doa.EleveEmp;
import sn.objis.LIV4SERVER.domaine.Eleve;

/**
 * La classe 'TestEleveEmp' permet de tester les differentes methodes de la
 * classe 'EleveEmp'
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 */
public class TestEleveEmp {
	/**
	 * Declaration d'une variable de type EleveEmp
	 */
	EleveEmp eleveEmp = new EleveEmp();
	Eleve eleve = new Eleve("mamadou", "diack", "thiaroye", "777777777", "mat12222", "12/12/1999", 12);

	/**
	 * cette methode permet de tester la methode Create
	 */
	@Test
	public void testCreate() {

		eleveEmp.create(eleve);
	}

	/**
	 * cette methode permet de tester la methode Update
	 */
	@Test
	public void testUpdate() {
		eleveEmp.update(eleve);
	}

	/**
	 * cette methode permet de tester la methode Read
	 */
	@Test
	public void testRead() {
		List<Eleve> list = new ArrayList<>();
		list = eleveEmp.read();
		Assert.assertNotNull(list);

	}

	/**
	 * cette methode permet de tester la methode Delete
	 */
	@Test
	public void testDelete() {
		eleveEmp.delete(eleve);
	}

	/**
	 * cette methode permet de tester la methode FindByMatricule
	 */
	@Test
	public void testFindByMatricule() {
		Eleve elev;
		String mat = "Mat-E-20183";
		elev = eleveEmp.FindByMatricule(mat);
		Assert.assertNotNull(elev);
	}

}
