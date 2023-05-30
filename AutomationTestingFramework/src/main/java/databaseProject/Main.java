package databaseProject;

import databaseProject.db.dao.StudentDao;
import databaseProject.db.dao.implementation.StudentDaoImpl;
import databaseProject.db.model.Student;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException {

		StudentDao studentDao = new StudentDaoImpl();
		//get all users
		System.out.println("------------------READ------------------");
		List<Student> studentList = (List<Student>) studentDao.getAll();
		studentList.forEach(System.out::println);

		//update first user
		System.out.println("------------------UPDATE------------------");
		Student firstStudent = studentList.get(0);
		firstStudent.getBuilder().withPrenume("Ioan").build();
		studentDao.update(firstStudent);
		studentDao.getAll().forEach(System.out::println);

		//delete first student by Id
		System.out.println("------------------DELETE------------------");
		studentDao.deleteById(firstStudent.getId());
		studentDao.getAll().forEach(System.out::println);

		// add (back)
		System.out.println("------------------ADD------------------");
		studentDao.add(firstStudent);
		studentDao.getAll().forEach(System.out::println);

//		// CUSTOM
//		studentDao.updateDateForAllUsers("2022-02-02");
//		System.out.println(studentList);
	}
}
