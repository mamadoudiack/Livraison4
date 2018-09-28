package sn.objis.livraison4.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import sn.objis.livraison4.domaine.Eleve;
import sn.objis.livraison4.utils.MaConnection;

/**
 * La classe 'EleveEmp' fourni une implementation de interface 'IDaoEleve' qui
 * etend l'interface 'IDaoGenerique'.
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @see IDaoEleve
 */
public class EleveEmp implements IDaoEleve {

	/**
	 * Creation d'une instance de connexion pour acceder à la base de donnees
	 */
	Connection con = MaConnection.getInstanceConnection();
	PreparedStatement  preparedStatement;
	Statement statement;
	ResultSet resultSet;
	private static final String FAILED = "failed"; 
	Logger logger = Logger.getLogger("InfoLogging");
	public void create(Eleve t) {
		
		try {
			String sql = "INSERT INTO eleve VALUES(?,?,?,?,?,?,?,?)";
			 preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, t.getNom());
			preparedStatement.setString(3, t.getPrenom());
			preparedStatement.setString(4, t.getAdresse());
			preparedStatement.setString(5, t.getTel());
			preparedStatement.setString(6, t.getMatricule());
			preparedStatement.setString(7, t.getDateDeNaissance());
			preparedStatement.setDouble(8, t.getMoyenne());
			preparedStatement.executeUpdate();
			logger.info("Insertion r�ussit");
			
		} catch (SQLException e1) {
			logger.info("Erreur � l'insertion");
			
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.info(FAILED);
			}
		}
		
	}


	public void update(Eleve t) {
		try {
			String sql = "UPDATE eleve SET nom=?,prenom=?" + "WHERE matricule=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, t.getNom());
			preparedStatement.setString(2, t.getPrenom());
			preparedStatement.setString(3, t.getMatricule());
			preparedStatement.executeUpdate();
			logger.info("Modification effectu�");
			
		} catch (SQLException e1) {
			logger.info("Erreur de mise � jour");
			
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.info(FAILED);
			}
		}

	}


	public List<Eleve> read() {
		List<Eleve> list = new ArrayList<Eleve>();
		try {
			String sql = "SELECT * FROM eleve";
			statement = con.createStatement();
			 resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Eleve e = new Eleve();
				e.setNom(resultSet.getString("nom"));
				e.setPrenom(resultSet.getString("prenom"));
				e.setAdresse(resultSet.getString("adresse"));
				e.setTel(resultSet.getString("tel"));
				e.setMatricule(resultSet.getString("matricule"));
				e.setDateDeNaissance(resultSet.getString("dateDeNaissance"));
				e.setMoyenne(resultSet.getDouble("moyenne"));
				list.add(e);
				
			}

		} catch (SQLException e) {
			
			logger.info(FAILED);
		}finally {
			try {
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				logger.info(FAILED);
			}
		}
		return list;

	}

	
	public void delete(Eleve t) {

		try {
			String sql = "delete from  eleve where matricule=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, t.getMatricule());
			preparedStatement.executeUpdate();
			logger.info("success");
            
		} catch (SQLException e) {
			
			logger.info(FAILED);
		}finally {
		   try {
			preparedStatement.close();
		} catch (SQLException e) {
			logger.info(FAILED);
		}	
		}

	}


	public Eleve findByMatricule(String numeroCarte) {
		Eleve e = null;
		try {
			String sql = "Select * From eleve where matricule=?";
			 preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, numeroCarte);
			 resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String nomRecup = resultSet.getString("nom");
				String prenomRecup = resultSet.getString("prenom");
				String adresseRecup = resultSet.getString("adresse");
				String telRecup = resultSet.getString("tel");
				String matRecup = resultSet.getString("matricule");
				String dateDeNaissanceRecup = resultSet.getString("dateDeNaissance");
				Double mayenneRecup = resultSet.getDouble("moyenne");
				e = new Eleve(nomRecup, prenomRecup, adresseRecup, telRecup, matRecup, dateDeNaissanceRecup,
						mayenneRecup);
				
			}
			if (e != null) {
				logger.info("success");
			}

		} catch (SQLException ex) {
		
			logger.info(FAILED);
		}finally {
			try {
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e1) {
				logger.info(FAILED);
			}
		}
		return e;
	}

}
