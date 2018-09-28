package sn.objis.livraison4.dao;



import sn.objis.livraison4.domaine.Eleve;

/**
 * L'interface 'IDaoEleve' c'est une interface qui etend de interface generique
 * IDaoGenerique.
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @see IDaoGenerique
 */
public interface IDaoEleve extends IDaoGenerique<Eleve> {

	/**
	 * La methode 'FindByMatricule(String numeroCarte)' permet de rechercher un eleve
	 * dans une base de donnees relationnelle.
	 * 
	 * @param numeroCarte
	 *            Parametre que reçoit la methode 'FindByMatricule'
	 * @return : il etourne l'eleve trouve sinon il retourne null
	 */
	public Eleve findByMatricule(String numeroCarte);
}
