package databaseProject.db.dao.implementation;

import databaseProject.db.AutomationTables;
import databaseProject.db.dao.AbstractDao;
import databaseProject.db.dao.StudentDao;
import databaseProject.db.model.Student;
import databaseProject.managers.DatabaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends AbstractDao implements StudentDao {

	public StudentDaoImpl() throws SQLException {
		super();
	}

	@Override public List<Student> getAll() throws SQLException {
		String querry = String.format("SELECT * FROM %s", AutomationTables.STUDENT.getDbTableName());
		ResultSet resultSet = DatabaseManager.getConnection().prepareStatement(querry).executeQuery();

		List<Student> studentList = new ArrayList<>();

		while (resultSet.next()) {
			studentList.add(Student.builder()
					.fromResultSet(resultSet));
		}
		return studentList;
	}



	@Override
	public void deleteById(int id) throws SQLException {
		String query = "DELETE FROM student where id=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1,id);
		statement.executeUpdate();
	}

	@Override
	public void updateDateForAllUsers(String date) throws SQLException {
		String query = String.format("UPDATE student SET data_inregistrarii = '%s'",date);
		connection.prepareStatement(query).execute();
	}

	@Override public void update(Student firstStudent) throws SQLException {
		String queryString = "UPDATE student SET nume=?, prenume=?, gen=?, data_inregistrarii=?, nota_la_final_curs=? WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(queryString);
		statement.setString(1,firstStudent.getNume());
		statement.setString(2, firstStudent.getPrenume());
		statement.setString(3,firstStudent.getGen().toString());
		statement.setDate(4, firstStudent.getData_inregistrarii());
		statement.setInt(5,firstStudent.getNota_la_final_curs());
		statement.setInt(6,firstStudent.getId());
		statement.executeUpdate();
	}

	@Override
	public void add(Student firstStudent) throws SQLException {
		String query = "INSERT INTO student(id,nume,prenume,gen,data_inregistrarii,nota_la_final_curs) VALUES(?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1,firstStudent.getId());
		statement.setString(2,firstStudent.getNume());
		statement.setString(3, firstStudent.getPrenume());
		statement.setString(4, firstStudent.getGen().toString());
		statement.setDate(5, firstStudent.getData_inregistrarii());
		statement.setInt(6,firstStudent.getNota_la_final_curs());
		statement.executeUpdate();
	}
}
