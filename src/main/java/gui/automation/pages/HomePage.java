package gui.automation.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import gui.automation.components.PrimaryHeader;
import gui.automation.components.SearchBox;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

	@FindBy(id = "headerPrimary")
	private PrimaryHeader primaryHeader;

	@FindBy(xpath = "//nav[@id='headerPrimary']/div[6]")
	private SearchBox searchBox;

	public HomePage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://www.target.com/");
	}

	public PrimaryHeader getPrimaryHeader() {
		return new PrimaryHeader(getDriver(), getDriver());
	}

	public SearchBox getSearchBox() {
		return searchBox;
	}
}
