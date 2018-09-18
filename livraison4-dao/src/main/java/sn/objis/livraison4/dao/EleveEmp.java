package sn.objis.livraison4.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	
	public void create(Eleve t) {

		try {
			String sql = "INSERT INTO eleve VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, t.getNom());
			preparedStatement.setString(3, t.getPrenom());
			preparedStatement.setString(4, t.getAdresse());
			preparedStatement.setString(5, t.getTel());
			preparedStatement.setString(6, t.getMatricule());
			preparedStatement.setString(7, t.getDateDeNaissance());
			preparedStatement.setDouble(8, t.getMoyenne());
			preparedStatement.executeUpdate();
			System.out.println("Insertion r�ussit");
		} catch (SQLException e1) {
			System.out.println("Erreur � l'insertion");
			e1.printStackTrace();
		}

	}


	public void update(Eleve t) {
		try {
			String sql = "UPDATE eleve SET nom=?,prenom=?" + "WHERE matricule=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, t.getNom());
			preparedStatement.setString(2, t.getPrenom());
			preparedStatement.setString(3, t.getMatricule());
			preparedStatement.executeUpdate();
			System.out.println("Modification effectu�");
		} catch (SQLException e1) {
			System.out.println("Erreur de mise � jour");
			e1.printStackTrace();
		}

	}


	public List<Eleve> read() {
		List<Eleve> list = new ArrayList<Eleve>();
		try {
			String sql = "SELECT * FROM eleve";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
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
			e.printStackTrace();
		}
		return list;

	}

	
	public void delete(Eleve t) {

		try {
			String sql = "delete from  eleve where matricule=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMatricule());
			ps.executeUpdate();
			System.out.println("success");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed");
		}

	}


	public Eleve FindByMatricule(String numeroCarte) {
		Eleve e = null;
		try {
			String sql = "Select * From eleve where matricule=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, numeroCarte);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String nomRecup = rs.getString("nom");
				String prenomRecup = rs.getString("prenom");
				String adresseRecup = rs.getString("adresse");
				String telRecup = rs.getString("tel");
				String matRecup = rs.getString("matricule");
				String dateDeNaissanceRecup = rs.getString("dateDeNaissance");
				Double mayenneRecup = rs.getDouble("moyenne");
				e = new Eleve(nomRecup, prenomRecup, adresseRecup, telRecup, matRecup, dateDeNaissanceRecup,
						mayenneRecup);
			}
			if (e != null) {
				System.out.println("success");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;
	}

}
