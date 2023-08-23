package gui.automation.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterOptions extends AbstractUIObject {
	@FindBy(css = "[data-test='facet-pill-Price']")
	private ExtendedWebElement priceFilter;

	public FilterOptions(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

   public void clickPriceFilterBtn() {
		priceFilter.clickByJs();
   }
}
