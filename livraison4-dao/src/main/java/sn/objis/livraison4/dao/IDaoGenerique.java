package sn.objis.livraison4.dao;



import java.util.List;

/**
 * L'interface IDaoGenerique c'est une interface generique qui contient nos
 * méthodes générique.
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @param <T>
 *            Parametre de type generique
 * 
 */
public interface IDaoGenerique<T> {
	/**
	 * La methode 'create(T t)' generique recoit un objet de type T et l'ajouer dans
	 * une base de donnees relationnelle.
	 * 
	 * @param t
	 *            Parametre de type generique
	 */
	public void create(T t);

	/**
	 * La methode 'update()' generique permet de mettre à jour les donnees d'un
	 * objet de type T dans une base de donnees relationnelle.
	 * 
	 * @param T
	 *            Parametre de type générique
	 */

	public void update(T t);

	/**
	 * La methode 'read()' generique permet de lire des donnees dans une base de
	 * donnees relationnelle, creer une liste et l'ajouter dans cette derniere.
	 * 
	 * @return List (retourne une liste de type T)
	 */
	public List<T> read();

	/**
	 * La methode 'delete(T t)' permet de supprimer un objet de type T dans une base
	 * de donnees relationnelle.
	 * 
	 * @param T
	 *            Parametre de type generique
	 */
	public void delete(T t);
}
