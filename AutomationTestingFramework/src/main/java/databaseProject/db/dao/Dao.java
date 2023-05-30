package databaseProject.db.dao;

import databaseProject.db.model.Model;


import java.sql.SQLException;
import java.util.List;

public interface Dao {

	List<? extends Model> getAll() throws SQLException;
}
