package sn.objis.livraison4.domaine;

/**
 * cette classe contient les propriete de l'eleve
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @see Personne
 */

public class Eleve extends Personne {

	private static final long serialVersionUID = 1L;
	private String matricule;
	private String dateDeNaissance;
	private double moyenne;

	/**
	 * constructeur sans argument pour la classe eleve.
	 */
	public Eleve() {
	}

	/**
	 * constructeur avec 8 arguements pour la classe eleve.
	 * 
	 * @param nom
	 *            represente le nom de l'eleve.
	 * @param prenom
	 *            represente le prenom de l'eleve.
	 * @param adresse
	 *            represente l'adresse de l'eleve.
	 * @param tel
	 *            represente le numero de telephonr de l'eleve.
	 * @param matricule
	 *            represente le matricule de l'eleve.
	 * @param dateDeNaissance
	 *            represente la date de naissance de l'eleve.
	 * @param not
	 *            represente une liste de note de l'eleve
	 * @param moyenne
	 *            represente la moyenne de l'eleve.
	 */
	public Eleve(String nom, String prenom, String adresse, String tel, String matricule, String dateDeNaissance,
			double moyenne) {
		super(nom, prenom, adresse, tel);
		this.matricule = matricule;
		this.dateDeNaissance = dateDeNaissance;

		this.moyenne = moyenne;
	}

	// les getters des attributs de l'eleve

	public String getMatricule() {
		return matricule;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public double getMoyenne() {
		return moyenne;
	}

	// les setters des attributs de l'eleve.

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	@Override
	public String toString() {
		return "Eleve [matricule=" + matricule + ", dateDeNaissance=" + dateDeNaissance + ", moyenne=" + moyenne
				+ ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + "]";
	}

}
