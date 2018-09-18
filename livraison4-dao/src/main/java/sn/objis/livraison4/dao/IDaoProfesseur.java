package sn.objis.livraison4.dao;



import sn.objis.livraison4.domaine.Professeur;

/**
 * L'interface 'IDaoProfesseur' c'est une interface qui etend de interface
 * generique IDaoGenerique.
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @see IDaoGenerique
 */
public interface IDaoProfesseur extends IDaoGenerique<Professeur> {
	/**
	 * La methode 'findByIdentifiantProfesseur(String identifiantProfesseur)' permet
	 * de rechercher un professeur dans une base de donnees relationnelle.
	 * 
	 * @param identifiantProfesseur
	 *            Parametre que reçoit la methode 'findByIdentifiantProfesseur'
	 * @return : il etourne le professeur trouve sinon il retourne null
	 */
	public Professeur findByIdentifiantProfesseur(String identifiantProfesseur);
}
