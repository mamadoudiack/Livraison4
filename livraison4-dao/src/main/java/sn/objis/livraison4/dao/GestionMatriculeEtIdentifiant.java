package sn.objis.livraison4.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sn.objis.livraison4.utils.MaConnection;

/**
 * La classe 'GestionMatriculeEtIdentifiant ' permet de generer des matricule de
 * maniere automatique
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 */
public class GestionMatriculeEtIdentifiant {
	/**
	 * Creation d'une instance de connexion pour acceder à la base de donnees
	 */
	Connection con = MaConnection.getInstanceConnection();

	/**
	 * La methode 'matEtudiant' permet de generer le matricule d'eleve de maniere
	 * automatique
	 * 
	 * @return il retourne le matricule genere
	 */
	public String matEtudiant() {

		String matricule = null;
		int numr = 0;
		try {

			String sql1 = "Select * From matricule";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql1);
			while (rs.next()) {
				matricule = rs.getString("mateleve");
				numr = rs.getInt("nbeleve");
			}
			String sql = "Update matricule Set nbeleve=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numr + 1);
			ps.setInt(2, 1);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return matricule + numr;
	}

	/**
	 * La methode 'matformateur' permet de generer le matricule d'un professeure
	 * maniere automatique
	 * 
	 * @return il retourne le matricule genere
	 */
	public String matformateur() {
		String matricule = null;
		int numr = 0;
		try {

			String sql1 = "Select * From identifiant";
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql1);
			while (rs.next()) {
				matricule = rs.getString("identifiant");
				numr = rs.getInt("nbprof");
			}

			String sql = "Update identifiant Set nbprof=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, numr + 1);
			ps.setInt(2, 1);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return matricule + numr;
	}
}
