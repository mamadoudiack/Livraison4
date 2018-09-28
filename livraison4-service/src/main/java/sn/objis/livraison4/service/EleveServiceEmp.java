package sn.objis.livraison4.service;



import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import sn.objis.livraison4.dao.EleveEmp;

import sn.objis.livraison4.domaine.Eleve;
import sn.objis.livraison4.utils.MaConnection;

/**
 * La classe 'EleveServiceEmp ' fourni une implementation de interface
 * 'IServiceEleve' qui etend l'interface 'IServiceGenerique'.
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @see IServiceEleve
 */

public class EleveServiceEmp implements IServiceEleve {
	/**
	 * Creation d'une instance de EleveEmp
	 */
	private EleveEmp daoEleve = new EleveEmp();
	Connection con = MaConnection.getInstanceConnection();
	Logger logger = Logger.getLogger("InfoLogging");
	

	public void ajouter(Eleve t) {
		daoEleve.create(t);

	}


	public void maj(Eleve t) {
		daoEleve.update(t);

	}

	
	public List<Eleve> lister() {

		return daoEleve.read();
	}

	
	public void supprimer(Eleve t) {
		daoEleve.delete(t);

	}

	
	public Eleve rechercherParMatricule(String matricule) {

		return daoEleve.findByMatricule(matricule);
	}

	
	public void afficher(Eleve t) {
		logger.info("+++++++++++++++++++++++++++++++++++++++++++++");
		logger.info("_____________DONNEES DE L'ELEVE______________");
		logger.info("+Nom               : " + t.getNom());
		logger.info("+Prenom            : " + t.getPrenom());
		logger.info("+Adresse           : " + t.getAdresse());
		logger.info("+Date de naissance : " + t.getDateDeNaissance());
		logger.info("+Tel               : " + t.getTel());
		logger.info("+Matricule         : " + t.getMatricule());
		logger.info("+Moyenne           : " + t.getMoyenne());
        logger.info("+++++++++++++++++++++++++++++++++++++++++++++");
	}

	
	public void afficheListe(List<Eleve> liste) {
		Iterator<Eleve> iterator = liste.iterator();
		while (iterator.hasNext()) {
			Eleve eleve = iterator.next();
			afficher(eleve);
		}
	}

}
