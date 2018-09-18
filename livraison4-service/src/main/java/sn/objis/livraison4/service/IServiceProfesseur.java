package sn.objis.livraison4.service;


import java.util.List;

import sn.objis.livraison4.domaine.Professeur;

/**
 * L'interface 'IServiceProfesseur' c'est une interface qui etend de interface
 * generique IServiceGenerique.
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @see IServiceGenerique
 */
public interface IServiceProfesseur extends IServiceGenerique<Professeur> {
	/**
	 * La methode 'rechercherParIdentifiant(String identifiant)' permet de
	 * rechercher un eprofesseur dans une base de donnees relationnelle.elle fait
	 * appelle au methode findByIdentifiantProfesseur
	 * 
	 * @param identifiant
	 *            Parametre que reçoit la methode 'echercherParIdentifiant'
	 * @return : il etourne le professeur trouve sinon il retourne null
	 */
	public Professeur rechercherParIdentifiant(String identifiant);

	/**
	 * La methode 'afficheListe(List<Professeur> liste)' permet d'affiche une liste
	 * professeurs
	 * 
	 * @param liste
	 *            Parametre que reçoit la methode 'afficheListe'
	 */
	public void afficheListe(List<Professeur> liste);
}
