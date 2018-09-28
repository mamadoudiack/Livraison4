package sn.objis.livraison4.service;



import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import sn.objis.livraison4.dao.ProfesseurEmp;
import sn.objis.livraison4.domaine.Professeur;

/**
 * La classe 'ProfesseurServiceEmp' fourni une implementation de interface
 * 'IServiceProfesseur' qui etend l'interface 'IServiceGenerique'.
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @see IServiceProfesseur
 */
public class ProfesseurServiceEmp implements IServiceProfesseur {
	/**
	 * Creation d'une instance de ProfesseurEmp
	 */
	ProfesseurEmp daoProfesseur = new ProfesseurEmp();
	Logger logger = Logger.getLogger("InfoLogging");
	
	
	public void ajouter(Professeur t) {
		daoProfesseur.create(t);

	}

	
	public void maj(Professeur t) {
		daoProfesseur.update(t);

	}

	
	public List<Professeur> lister() {

		return daoProfesseur.read();
	}

	
	public void supprimer(Professeur t) {
		daoProfesseur.delete(t);

	}

	
	public Professeur rechercherParIdentifiant(String identifiant) {

		return daoProfesseur.findByIdentifiantProfesseur(identifiant);
	}


	public void afficher(Professeur t) {
		logger.info("+++++++++++++++++++++++++++++++++++++++++++++");
		logger.info("_____________DONNEES DU PROFESSEUR__________+");
		logger.info("+Nom               : " + t.getNom());
		logger.info("+Prenom            : " + t.getPrenom());
		logger.info("+Adresse           : " + t.getAdresse());
		logger.info("+Tel               : " + t.getTel());
		logger.info("+Identifiant       : " + t.getIdentifiantProfesseur());
		logger.info("+Diplome           : " + t.getDiplome());
		logger.info("+++++++++++++++++++++++++++++++++++++++++++++");
	}

	
	public void afficheListe(List<Professeur> liste) {
		Iterator<Professeur> iterator = liste.iterator();
		while (iterator.hasNext()) {
			Professeur prof = iterator.next();
			afficher(prof);
		}
	}

}
