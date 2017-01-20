package glam;

import java.sql.*;
import java.util.ArrayList;

public class Database {
	static Connection cn;
	static Statement st;
	static ResultSet rs;
	static String sql;
	static ArrayList<Iscritto> iscritto = new ArrayList();
	static Iscritto iscr;
	
	public void Database() throws SQLException {
		iscritto.clear();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		// Creo la connessione al database
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/glam?user=root&password=");
		// peer � il nome del database

		sql = "SELECT * FROM iscrizioni;";
		// ________________________________query
		try {
			st = cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			rs = st.executeQuery(sql); // faccio la query su uno statement
			while (rs.next() == true) {
				iscr = new Iscritto(rs.getString("nome") +"\t" + rs.getString("data_iscrizione"), null);
				iscritto.add(iscr);
				System.out.print("fatto");
			}
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch
		
		
		cn.close(); // chiusura connessione
	}// fine main
	
	public void inserisciIscrizione(String s){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		// Creo la connessione al database
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/glam?user=root&password=");
			sql = "INSERT INTO iscrizioni(nome,data_iscrizione) VALUES ('"+s+"', NOW())";
			
			// ________________________________query
			System.out.println(sql);
			st = cn.createStatement(); 
			st.execute(sql); 
			cn.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public ArrayList<Iscritto> getIscritto() {
		// TODO Auto-generated method stub
		return iscritto;
	}
	

}
	
