package sn.objis.livraison4.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import sn.objis.livraison4.domaine.Professeur;
import sn.objis.livraison4.utils.MaConnection;


/**
 * La classe 'ProfesseurEmp' fourni une implementation de interface
 * 'IDaoProfesseur ' qui etend l'interface 'IDaoGenerique'.
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 * @see IDaoProfesseur
 */

public class ProfesseurEmp implements IDaoProfesseur {
	/**
	 * Creation d'une instance de connexion pour acceder à la base de donnees
	 */
	Connection con = MaConnection.getInstanceConnection();
	Logger logger = Logger.getLogger("InfoLogging");
	private static final String FAILEDE = "failed"; 
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet ;
	public void create(Professeur t) {
	
		try {
			String sql = "INSERT INTO professeur VALUES(?,?,?,?,?,?,?)";
		    preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, t.getNom());
			preparedStatement.setString(3, t.getPrenom());
			preparedStatement.setString(4, t.getAdresse());
			preparedStatement.setString(5, t.getTel());
			preparedStatement.setString(6, t.getIdentifiantProfesseur());
			preparedStatement.setString(7, t.getDiplome());
			preparedStatement.executeUpdate();
			logger.info("Insertion r�ussit");
		} catch (SQLException e1) {
			logger.info("Erreur � l'insertion");
			
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.info(FAILEDE);
			}
		}

	}


	public void update(Professeur t) {
		try {
			String sql = "UPDATE professeur SET nom=?,prenom=?" + "WHERE identifiantProfesseur=?";
		    preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, t.getNom());
			preparedStatement.setString(2, t.getPrenom());
			preparedStatement.setString(3, t.getIdentifiantProfesseur());
			preparedStatement.executeUpdate();
			logger.info("Modification effectu�");
		} catch (SQLException e1) {
			logger.info("Erreur de mise a jour");
			
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.info(FAILEDE);
			}	
		}

	}


	public List<Professeur> read() {
		List<Professeur> list = new ArrayList<Professeur>();
		try {
			String sql = "SELECT * FROM professeur";
			 statement = con.createStatement();
			 resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Professeur prof = new Professeur();
				prof.setNom(resultSet.getString("nom"));
				prof.setPrenom(resultSet.getString("prenom"));
				prof.setAdresse(resultSet.getString("adresse"));
				prof.setTel(resultSet.getString("tel"));
				prof.setIdentifiantProfesseur(resultSet.getString("identifiantProfesseur"));
				prof.setDiplome(resultSet.getString("diplome"));
				list.add(prof);
			}
		} catch (SQLException e) {
			
			logger.info(FAILEDE);
		}finally {
			try {
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				logger.info(FAILEDE);
			}
		}
		return list;
	}

	public void delete(Professeur t) {
		try {
			String sql = "delete from  professeur where identifiantProfesseur=?";
		 preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, t.getIdentifiantProfesseur());
			preparedStatement.executeUpdate();
			logger.info("success");

		} catch (SQLException e) {
			logger.info(FAILEDE);
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.info(FAILEDE);
			}
		}

	}


	public Professeur findByIdentifiantProfesseur(String identifiantProfesseur) {
		Professeur prof = null;
		try {
			String sql = "Select * From professeur where identifiantProfesseur=?";
		    preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, identifiantProfesseur);
		    resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String nomRecup = resultSet.getString("nom");
				String prenomRecup = resultSet.getString("prenom");
				String adresseRecup = resultSet.getString("adresse");
				String telRecup = resultSet.getString("tel");
				String matRecup = resultSet.getString("identifiantProfesseur");
				String diplome = resultSet.getString("diplome");
				prof = new Professeur(nomRecup, prenomRecup, adresseRecup, telRecup, matRecup, diplome);
			}
			if (prof != null) {
				logger.info("success");
			}

		} catch (SQLException ex) {
			logger.info(FAILEDE);
		}finally {
		try {
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			logger.info(FAILEDE);
		}
		}
		return prof;
	}
}
