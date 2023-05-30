package databaseProject.db.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Student implements Model {

	private int id;
	private String nume;
	private String prenume;
	private GenEnum gen;
	private Date data_inregistrarii;
	private byte nota_la_final_curs;

	public static StudentBuilder builder() {
		return new StudentBuilder();
	}

	public StudentBuilder getBuilder() {
		return new StudentBuilder(this);
	}

	public int getId() {
		return id;
	}

	public String getNume() {
		return nume;
	}

	public String getPrenume() {
		return prenume;
	}


	public GenEnum getGen() {
		return gen;
	}

	public Date getData_inregistrarii() {
		return data_inregistrarii;
	}

	public byte getNota_la_final_curs() {
		return nota_la_final_curs;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", nume='" + nume + '\'' +
				", prenume='" + prenume + '\'' +
				", gen=" + gen +
				", data_inregistrarii=" + data_inregistrarii +
				", nota_la_final_curs=" + nota_la_final_curs +
				'}';
	}

	public static class StudentBuilder {

		private Student student;

		StudentBuilder() {
			student = new Student();
		}

		StudentBuilder(Student student) {
			this.student = student;
		}

		public StudentBuilder withId(int idNumber) {
			student.id = idNumber;
			return this;
		}

		public StudentBuilder withNume(String name) {
			student.nume = name;
			return this;
		}

		public StudentBuilder withPrenume(String lastName) {
			student.prenume = lastName;
			return this;
		}

		public StudentBuilder withGen(GenEnum gen) {
			student.gen = gen;
			return this;
		}

		public StudentBuilder withDataInregistrarii(Date data) {
			student.data_inregistrarii = data;
			return this;
		}

		public StudentBuilder withNota(byte nota) {
			student.nota_la_final_curs = nota;
			return this;
		}

		public Student fromResultSet(ResultSet resultSet) throws SQLException {
			return Student.builder()
					.withId(resultSet.getInt("id"))
					.withNume(resultSet.getString("nume"))
					.withPrenume(resultSet.getString("prenume"))
					.withGen(GenEnum.valueOf(resultSet.getString("gen")))
					.withDataInregistrarii(resultSet.getDate("data_inregistrarii"))
					.withNota(resultSet.getByte("nota_la_final_curs"))
					.build();
		}

		public Student build() {
			return student;
		}
	}
}
