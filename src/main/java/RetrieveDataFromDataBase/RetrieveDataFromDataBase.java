package RetrieveDataFromDataBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;

import SetupManager.DBConnectionManager;

public class RetrieveDataFromDataBase {

	public static List<String> retrieveDataFromDBWithSimpleQuery(String sqlQuery, String columnName) throws SQLException {
		Connection connection = DBConnectionManager.getConnectionToMySQL().getConnector();
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery(sqlQuery);

		List<String> bookTitle = new ArrayList<String>();

		while (resultSet.next()) {
			String titleText = resultSet.getString(columnName);
			bookTitle.add(titleText);
		}
		return bookTitle;
	}

	public static List<Pair<String, String>> retrieveDataFromDBWithJOIN(String sqlQuery, String columnName1, String
			columnName2) throws SQLException {
		Connection connection = DBConnectionManager.getConnectionToMySQL().getConnector();
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery(sqlQuery);

		List<Pair<String, String>> booksData = new ArrayList<Pair<String, String>>();

		while (resultSet.next()) {
			String title = resultSet.getString(columnName1);
			String author = resultSet.getString(columnName2);
			Pair<String, String> bookTitleAndAuthor = new Pair<String, String>(title, author);
			booksData.add(bookTitleAndAuthor);
		}
		return booksData;
	}
}

