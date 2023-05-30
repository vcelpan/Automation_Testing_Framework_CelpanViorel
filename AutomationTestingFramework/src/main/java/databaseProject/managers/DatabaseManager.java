package databaseProject.managers;

import Common.managers.TestDataFileReaderManager;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DatabaseManager {

	private static Connection connection;

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed())
			createConnection();
		return connection;
	}

	private static void createConnection() {
		String url = TestDataFileReaderManager.getProperty("host");
		String user = TestDataFileReaderManager.getProperty("username");
		String pwd =  TestDataFileReaderManager.getProperty("password");

		try {
			connection = DriverManager.getConnection(url, user, pwd);
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
