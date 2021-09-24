import java.sql.SQLException;
import org.junit.*;
import Constants.SQLqueries;
import Pages.*;
import RetrieveDataFromDataBase.RetrieveDataFromDataBase;
import SetupManager.WebDriverSetupManager;

public class TestSELECTQuery {
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

		for (String expectedDBOutput : RetrieveDataFromDataBase.retrieveDataFromDBWithSimpleQuery(
				SQLqueries.SELECT_BOOK_TITLE, "title")) {
			boolean isBookFound = false;
			for (String actualDBOutput : searchResultsPage.storeSearchResultsTitle()) {
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
