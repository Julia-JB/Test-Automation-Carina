package gui.automation.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PrimaryHeader extends AbstractUIObject {
	@FindBy(xpath = "//*[@id='headerPrimary']/a[@aria-label='Target home'][1]")
	private ExtendedWebElement targetHome;

	@FindBy(xpath = "//a[@aria-label='Categories']")
	private ExtendedWebElement categoriesLink;

	@FindBy(css = "a[aria-label='Deals']")
	private ExtendedWebElement dealsLink;

	@FindBy(xpath = "//a[@aria-label='What’s New']")
	private ExtendedWebElement whatsNewLink;

	@FindBy(css = "[data-test='@web/PICKUP_AND_DELIVERY_PRIMARY_HEADER_LINK']")
	private ExtendedWebElement pikupAndDeliveryLink;

	@FindBy(css = "[data-test='deals-topDeals']")
	private ExtendedWebElement topDealsLink;

	public PrimaryHeader(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public void openHomePage() {
		targetHome.click();
	}

	public void selectTopDeals() {
		dealsLink.click();
		topDealsLink.click();
	}
}


