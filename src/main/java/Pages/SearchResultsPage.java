package Pages;
import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;
import org.openqa.selenium.*;

import SetupManager.WebDriverSetupManager;

public class SearchResultsPage extends BasePage{

	public List<String> storeSearchResultsTitle() {
		List<String> bookList = new ArrayList<String>();

		List<WebElement> bookTitle = WebDriverSetupManager.getDriver().findElements(By.xpath("//div[@class='book-item']//h3[@class='title']"));

		for (WebElement book: bookTitle) {
			bookList.add(book.getText());
		}
		return bookList;
	}

	public List<Pair<String, String>> storeSearchResultsTitleAndAuthor() {
		List<Pair<String, String>> booksData = new ArrayList<Pair<String, String>>();

		List<WebElement> books = WebDriverSetupManager.getDriver().findElements(By.xpath("//div[@class='book-item']"));

		for (WebElement book: books) {
			Pair<String, String> bookTitleAndAuthor = new Pair<String, String>
							(book.findElement(By.xpath(".//h3[@class='title']")).getText(),
									book.findElement(By.xpath(".//p[@class='author']")).getText());
			booksData.add(bookTitleAndAuthor);
		}
		return booksData;
	}

}
