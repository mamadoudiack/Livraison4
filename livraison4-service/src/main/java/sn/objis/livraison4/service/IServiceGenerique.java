package sn.objis.livraison4.service;



import java.util.List;

/**
 * L'interface 'IServiceGenerique' c'est une interface generique qui contient
 * nos methodes generique.
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @param <T>
 *            Paramétre de type générique
 */
public interface IServiceGenerique<T> {
	/**
	 * La methode 'ajouter(T t)' generique recoit un objet de type T et de l'ajouer
	 * dans une base de donnees relationnelle.elle fait appelle au methode create
	 * 
	 * @param t
	 *            Parametre de type generique
	 */
	public void ajouter(T t);

	/**
	 * La methode 'maj(T t)' generique permet de mettre a jour un objetvde type T
	 * dans une base de donnees relationnelle . elle fait appelle au methode Update
	 * 
	 * @param t
	 *            Parametre de type generique
	 */
	public void maj(T t);

	/**
	 * La methode 'lister()' generique permet de lire des donnees dans une base de
	 * donnees relationnelle, creer une liste et l'ajouter dans cette derniere.elle
	 * fait appelle au methode read
	 * 
	 * @return List (retourne une liste de type T)
	 */
	public List<T> lister();

	/**
	 * La methode 'supprimer(T t)' generique permet de supprimer un objet de type T
	 * dans une base de donnees relationnelle.elle fait appelle au methode delete
	 * 
	 * @param T
	 *            Parametre de type generique
	 */
	public void supprimer(T t);

	/**
	 * La methode 'afficher(T t)' generique permet d'afficher un objet de type T
	 * 
	 * @param T
	 *            Parametre de type generique
	 */
	public void afficher(T t);

}
