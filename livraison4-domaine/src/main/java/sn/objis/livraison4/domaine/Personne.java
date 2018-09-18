/**
 * 
 */
package sn.objis.livraison4.domaine;

import java.io.Serializable;

/**
 * cette classe contient les propriete de personne
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 */
public class Personne implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String tel;

	/**
	 * constructeur sans argument pour la classe personne .
	 */
	public Personne() {

	}

	/**
	 * constructeur avec 2 arguments pour la classe personne
	 * 
	 * @param nom:
	 *            represente le nom de la personne
	 * @param prenom:
	 *            represente le prenom de la personner
	 */
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * constructeur avec 4 arguments et il fait appel au constructeur a deux
	 * argument.
	 * 
	 * @param nom:
	 *            represente le nom de la personne
	 * @param prenom:
	 *            represente le prenom de la personne
	 * @param adresse:
	 *            represente l'adresse de la personne
	 * @param tel:
	 *            represente le numero de telephonr de la personne
	 */
	public Personne(String nom, String prenom, String adresse, String tel) {
		this(nom, prenom);
		this.adresse = adresse;
		this.tel = tel;
	}

	// les getters des attributs de la classe personne

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getTel() {
		return tel;
	}

	// les setters des attributs de la classe personne

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
