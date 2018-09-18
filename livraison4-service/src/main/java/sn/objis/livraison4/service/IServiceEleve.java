package sn.objis.livraison4.service;



import java.util.List;

import sn.objis.livraison4.domaine.Eleve;

/**
 * L'interface 'IServiceEleve' c'est une interface qui etend de interface
 * generique IServiceGenerique.
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @see IServiceGenerique
 */
public interface IServiceEleve extends IServiceGenerique<Eleve> {
	/**
	 * La methode 'rechercherParMatricule(String matricule)' permet de rechercher un
	 * eleve dans une base de donnees relationnelle.elle fait appelle au methode
	 * FindByMatricule
	 * 
	 * @param matricule
	 *            Parametre que reçoit la methode 'rechercherParMatricule'
	 * @return : il etourne l'eleve trouve sinon il retourne null
	 */
	public Eleve rechercherParMatricule(String matricule);

	/**
	 * La methode 'afficheListe(List<Eleve> liste)' permet d'affiche une liste
	 * eleves
	 * 
	 * @param liste
	 *            Parametre que reçoit la methode 'afficheListe'
	 */
	public void afficheListe(List<Eleve> liste);
}
