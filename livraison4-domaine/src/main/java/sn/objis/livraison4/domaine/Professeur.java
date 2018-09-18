package sn.objis.livraison4.domaine;



/**
 * cette classe contient les propriete professeur
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @see Personne
 * 
 */
public class Professeur extends Personne {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String identifiantProfesseur;
	private String diplome;
	boolean professeurPressent;

	/**
	 * constructeur sans argument pour la classe professeur
	 */
	public Professeur() {

	}

	/**
	 * construsteur avec 6 arguments pour la classe professeur
	 * 
	 * @param nom
	 *            represente le nom du professeur
	 * @param prenom
	 *            represente le prenom du professeur
	 * @param adresse
	 *            represente l'adresse du professeur
	 * @param tel
	 *            represente le numero de telephone du professeur
	 * @param identifiantProfesseur
	 *            represente l'identifiant du professeur
	 * @param diplome
	 *            le diplome du professeur
	 */
	public Professeur(String nom, String prenom, String adresse, String tel, String identifiantProfesseur,
			String diplome) {
		super(nom, prenom, adresse, tel);
		this.identifiantProfesseur = identifiantProfesseur;
		this.diplome = diplome;
	}

	// les getters des attributs de professeur

	public String getIdentifiantProfesseur() {
		return identifiantProfesseur;
	}

	public String getDiplome() {
		return diplome;
	}

	public boolean isProfesseurPressent() {
		return professeurPressent;
	}

	// les setters des attributs de professeur
	public void setIdentifiantProfesseur(String identifiantProfesseur) {
		this.identifiantProfesseur = identifiantProfesseur;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public void setProfesseurPressent(boolean professeurPressent) {
		this.professeurPressent = professeurPressent;
	}

}
