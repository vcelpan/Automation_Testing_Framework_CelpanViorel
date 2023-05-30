package databaseProject.db.dao;

import databaseProject.db.model.Student;

import java.sql.SQLException;

public interface StudentDao extends Dao {

	void deleteById(int id) throws SQLException;

	void updateDateForAllUsers(String date) throws SQLException;

	void update(Student firstStudent) throws SQLException;

	void add(Student firstStudent) throws SQLException;
}
