package SetupManager;
import java.sql.*;

public class DBConnectionManager {
	private final static String USERNAME = "root";
	private final static String PASSWORD = "RootPassword1@";
	private final static String CONNECTOR = "jdbc:mysql://localhost:3306/test";

	private static DBConnectionManager dbConnectionManager;
	private static Connection connection;

	private DBConnectionManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(CONNECTOR, USERNAME, PASSWORD);
		} catch (InstantiationException | IllegalAccessException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnector() {
		return connection;
	}

	public static DBConnectionManager getConnectionToMySQL() throws SQLException {
		if (dbConnectionManager == null) {
			dbConnectionManager = new DBConnectionManager();
		} else if (dbConnectionManager.getConnector().isClosed()) {
			dbConnectionManager = new DBConnectionManager();
		}
		return dbConnectionManager;
	}
}
