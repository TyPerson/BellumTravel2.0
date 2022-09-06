package com.bellum.connect;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFacility {

	// MySQL user name
	private static final String USERNAME = "admin_pa";
	
	// Password
	private static final String PASSWORD = "@squad41@";
	
	// Path to DB, PORT, DB name
	private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1/bellumtravel";
	
	public static Connection createConnectionToMySQL() throws Exception {
		// Charge class into JVM
		Class.forName("cpm.mysql.jdbc.Driver");
		
		// Create DB connection
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}

	public static void main(String[] args) throws Exception {
		// Recover connection with DB once created
		Connection con = createConnectionToMySQL();
		
		// Check is connection is`nt null
		if(con!=null) {
			System.out.println("Connection sucessfully obtained!");
			con.close();
		}

	}

}
