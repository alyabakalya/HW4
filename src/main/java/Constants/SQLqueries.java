package Constants;

public class SQLqueries {
	public static final String SELECT_BOOK_TITLE = "SELECT title FROM booklist";
	public static final String SELECT_BOOK_TITLE_AND_AUTHOR = "SELECT booklist.title, author.fullname FROM booklist JOIN author WHERE booklist.author = author.id";
}
