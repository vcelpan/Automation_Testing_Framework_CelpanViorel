package databaseProject.db.dao;

import databaseProject.managers.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDao implements Dao {

	protected Connection connection;

	public AbstractDao() throws SQLException {
		connection = DatabaseManager.getConnection();
	}
}
