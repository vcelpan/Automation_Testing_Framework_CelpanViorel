package databaseProject.db;

public enum AutomationTables {

	STUDENT("student");

	final String dbTableName;

	AutomationTables(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	public String getDbTableName() {
		return dbTableName;
	}
}
