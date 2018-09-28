package org.livraison4.service;



import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import sn.objis.livraison4.service.MatEleveProf;

/**
 * La classe 'TestMatEleveProf' permet de tester les differentes methodes de la
 * classe 'MatEleveProf'
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 */
public class TestMatEleveProf {
	/**
	 * Declaration d'une variable de type MatEleveProf
	 */
	MatEleveProf matEleveProf;

	/**
	 * cette methode sera executee avant le lancement des tests
	 */
	@Before
	public void init() {
		matEleveProf = new MatEleveProf();
	}

	/**
	 * cette methode permet de tester la methode MatEtudiantService
	 */
	@ Ignore
	@Test
	public void testMatEtudiantService() {
		matEleveProf.matEtudiantService();
	}

	/**
	 * cette methode permet de tester la methode IdprofService
	 */
	@Test
	public void testIdprofService() {
		matEleveProf.idprofService();
	}

}
