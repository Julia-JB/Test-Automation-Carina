package gui.automation.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopDealsPage extends AbstractPage {
	@FindBy(xpath = "//ul[@data-test='pictureNavigationFeatured']/li")
	private List<ExtendedWebElement> topDealsLinks;

	@FindBy(css = "[data-test='page-title']")
	private ExtendedWebElement pageTitle;

	public TopDealsPage(WebDriver driver) {
		super(driver);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
		setUiLoadedMarker(pageTitle);
	}

	public List<ExtendedWebElement> getTopDealsLinks() {
		return topDealsLinks;
	}

	public ExtendedWebElement getPageTitle() {
		return pageTitle;
	}
}
