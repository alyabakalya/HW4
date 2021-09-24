import java.sql.*;
import org.javatuples.Pair;
import org.junit.*;
import Constants.SQLqueries;
import Pages.*;
import RetrieveDataFromDataBase.RetrieveDataFromDataBase;
import SetupManager.WebDriverSetupManager;

public class TestJOINQuery {

	@Before
	public void executeBeforeTest() {
		WebDriverSetupManager.setupDriver();
	}

	@Test
	public void testJOINQuery() throws SQLException {
		HomePage homePage = new HomePage();
		SearchResultsPage searchResultsPage = new SearchResultsPage();

		PageNavigation.openPage(WebDriverSetupManager.getDriver(), "https://www.bookdepository.com/");
		homePage.enterSearchTerm("English");
		homePage.clickOnSearchButton();

		for (Pair<String, String> expectedDBOutput : RetrieveDataFromDataBase.retrieveDataFromDBWithJOIN(
				SQLqueries.SELECT_BOOK_TITLE_AND_AUTHOR, "title", "fullname")) {
			boolean isBookFound = false;
			for (Pair<String, String> actualDBOutput : searchResultsPage.storeSearchResultsTitleAndAuthor()) {
				if (actualDBOutput.equals(expectedDBOutput)) {
					isBookFound = true;
					break;
				}
			}
			Assert.assertTrue(isBookFound);
		}
	}

	@After
	public void executeAfterTest() {
		WebDriverSetupManager.quitDriver();
	}
}