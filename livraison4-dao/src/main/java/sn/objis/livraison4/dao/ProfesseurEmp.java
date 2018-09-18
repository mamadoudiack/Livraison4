package sn.objis.livraison4.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public void create(Professeur t) {
		try {
			String sql = "INSERT INTO professeur VALUES(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, t.getNom());
			preparedStatement.setString(3, t.getPrenom());
			preparedStatement.setString(4, t.getAdresse());
			preparedStatement.setString(5, t.getTel());
			preparedStatement.setString(6, t.getIdentifiantProfesseur());
			preparedStatement.setString(7, t.getDiplome());
			preparedStatement.executeUpdate();
			System.out.println("Insertion r�ussit");
		} catch (SQLException e1) {
			System.out.println("Erreur � l'insertion");
			e1.printStackTrace();
		}

	}


	public void update(Professeur t) {
		try {
			String sql = "UPDATE professeur SET nom=?,prenom=?" + "WHERE identifiantProfesseur=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, t.getNom());
			preparedStatement.setString(2, t.getPrenom());
			preparedStatement.setString(3, t.getIdentifiantProfesseur());
			preparedStatement.executeUpdate();
			System.out.println("Modification effectu�");
		} catch (SQLException e1) {
			System.out.println("Erreur de mise a jour");
			e1.printStackTrace();
		}

	}


	public List<Professeur> read() {
		List<Professeur> list = new ArrayList<Professeur>();
		try {
			String sql = "SELECT * FROM professeur";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
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
			e.printStackTrace();
		}
		return list;
	}

	public void delete(Professeur t) {
		try {
			String sql = "delete from  professeur where identifiantProfesseur=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdentifiantProfesseur());
			ps.executeUpdate();
			System.out.println("success");

		} catch (SQLException e) {
			System.out.println("failed");
		}

	}


	public Professeur findByIdentifiantProfesseur(String identifiantProfesseur) {
		Professeur prof = null;
		try {
			String sql = "Select * From professeur where identifiantProfesseur=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, identifiantProfesseur);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String nomRecup = rs.getString("nom");
				String prenomRecup = rs.getString("prenom");
				String adresseRecup = rs.getString("adresse");
				String telRecup = rs.getString("tel");
				String matRecup = rs.getString("identifiantProfesseur");
				String diplome = rs.getString("diplome");
				prof = new Professeur(nomRecup, prenomRecup, adresseRecup, telRecup, matRecup, diplome);
			}
			if (prof != null) {
				System.out.println("success");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return prof;
	}
}
