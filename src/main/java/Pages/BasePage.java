package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import SetupManager.WebDriverSetupManager;


public class BasePage {
	public BasePage() {
		PageFactory.initElements(WebDriverSetupManager.getDriver(), this);
	}

	public BasePage clickElement(WebElement element) {
		element.click();
		return this;
	}

	public BasePage sendValueToInputField(WebElement element, String value) {
		element.sendKeys(value);
		return this;
	}
}
