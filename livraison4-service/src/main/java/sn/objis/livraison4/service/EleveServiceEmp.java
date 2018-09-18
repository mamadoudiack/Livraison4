package sn.objis.livraison4.service;



import java.util.Iterator;
import java.util.List;

import sn.objis.livraison4.dao.EleveEmp;
import sn.objis.livraison4.domaine.Eleve;

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

		return daoEleve.FindByMatricule(matricule);
	}

	
	public void afficher(Eleve t) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("_____________DONNEES DE L'ELEVE______________");
		System.out.println("+Nom               : " + t.getNom());
		System.out.println("+Prenom            : " + t.getPrenom());
		System.out.println("+Adresse           : " + t.getAdresse());
		System.out.println("+Date de naissance : " + t.getDateDeNaissance());
		System.out.println("+Tel               : " + t.getTel());
		System.out.println("+Matricule         : " + t.getMatricule());
		System.out.println("+Moyenne           : " + t.getMoyenne());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
	}

	
	public void afficheListe(List<Eleve> liste) {
		Iterator<Eleve> iterator = liste.iterator();
		while (iterator.hasNext()) {
			Eleve eleve = iterator.next();
			afficher(eleve);
		}
	}

}
