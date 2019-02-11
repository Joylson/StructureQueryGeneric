package querycreate.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QueryConnection {
	
	private final static String URL = "jdbc:postgresql://localhost:5432/query_control";
	private final static String USER = "postgres";
	private final static String PASS = "91735129";
	private final static String DRIVER = "org.postgresql.Driver";
	
	
	private static Connection connection;


	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER);
		connection = DriverManager.getConnection(URL, USER, PASS);
		
		return connection;
	}	
	
}
