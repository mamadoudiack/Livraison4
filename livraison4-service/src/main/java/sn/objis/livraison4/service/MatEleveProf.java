package sn.objis.livraison4.service;



import sn.objis.livraison4.dao.GestionMatriculeEtIdentifiant;

/**
 * La classe 'MatEleveProf' permet de generer des matricule de maniere
 * automatique
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 */
public class MatEleveProf {
	/**
	 * Creation d'une instance de GestionMatriculeEtIdentifiant
	 */
	private GestionMatriculeEtIdentifiant gestionMatriculeEtIdentifiant = new GestionMatriculeEtIdentifiant();

	/**
	 * La methode 'matEtudiantService' permet de generer le matricule d'eleve de
	 * maniere automatique. elle fait appelle au methode matEtudiant
	 * 
	 * @return il retourne le matricule genere
	 */
	public String matEtudiantService() {
		return gestionMatriculeEtIdentifiant.matEtudiant();
	}

	/**
	 * La methode 'IdprofService' permet de generer le matricule d'un professeure
	 * maniere automatique. elle fait appelle au methode matformateur
	 * 
	 * @return il retourne le matricule genere
	 */
	public String IdprofService() {
		return gestionMatriculeEtIdentifiant.matformateur();
	}

}
