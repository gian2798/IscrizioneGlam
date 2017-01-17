package glam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	static Connection cn;
	static Statement st;
	static ResultSet rs;
	static String sql;
	
	private void Database throws SQLException () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/glam?user=root&password=");

		// SELECT Soci

		sql = "SELECT * FROM `iscrizioni`";

		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next() == true) {
				/*iscritto.add(new Iscritto(rs.getString("cf"), rs.getString("cognome"), rs.getString("nome"),
						rs.getString("indirizzo"), rs.getString("telefono"), is));
				is++;*/
			}
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		}

	}
}
