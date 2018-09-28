package sn.objis.livraison4.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

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
	Logger logger = Logger.getLogger("InfoLogging");
	PreparedStatement  preparedStatement;
	Statement statement;
	ResultSet resultSet;
	PreparedStatement  pr;
	Statement st;
	ResultSet re;
	private static final String FAILED2 = "failed"; 
	/**
	 * La methode 'matEtudiant' permet de generer le matricule d'eleve de maniere
	 * automatique
	 * 
	 * @return il retourne le matricule genere
	 */
	public String matEtudiant() {

		String mat = null;
		int n = 0;
		try {

			String sql1 = "Select * From matricule";
			 st = con.createStatement();
			 re = st.executeQuery(sql1);
			while (re.next()) {
				mat = re.getString("mateleve");
				n = resultSet.getInt("nbeleve");
			}
			String sql = "Update matricule Set nbeleve=? WHERE id=?";
			pr = con.prepareStatement(sql);
			pr.setInt(1, n + 1);
			pr.setInt(2, 1);
			pr.executeUpdate();

		} catch (SQLException e) {
			logger.info(FAILED2 );
		}finally {
			try {
				st.close();
				re.close();
				pr.close();
			} catch (SQLException e) {
				logger.info(FAILED2 );
			}
		}

		return mat + n;
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
			 statement = con.createStatement();

			 resultSet =  statement.executeQuery(sql1);
			while (resultSet.next()) {
				matricule = resultSet.getString("identifiant");
				numr = resultSet.getInt("nbprof");
			}

			String sql = "Update identifiant Set nbprof=? WHERE id=?";
			preparedStatement = con.prepareStatement(sql);

			preparedStatement.setInt(1, numr + 1);
			preparedStatement.setInt(2, 1);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			logger.info(FAILED2 );
		}finally {
			try {
				statement.close();
				resultSet.close();
				preparedStatement.close();
			} catch (SQLException e) {
				logger.info(FAILED2 );
			}
		}

		return matricule + numr;
	}
}
