package gui.automation.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import gui.automation.components.FilterOptions;
import gui.automation.components.PriceFilterModal;
import gui.automation.components.ProductCard;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends AbstractPage {
	@FindBy(css = "[data-test='resultsHeading']")
	private ExtendedWebElement resultsHeading;

	@FindBy(css = "[data-test='@web/site-top-of-funnel/ProductCardWrapper']")
	private List<ProductCard> productCards;

	@FindBy(xpath = "//div[@data-test='product-grid']//section/div/div")
	private ProductCard productCard;

	@FindBy(css = "[data-test='default-facets-filmstrip']")
	private FilterOptions filterOptions;

	@FindBy(css = "[data-test='@web/OverlayModal']")
	private PriceFilterModal priceFilterModal;

	@FindBy(css = "[data-test='@web/OverlayModal']")
	private ExtendedWebElement priceModal;

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
		setUiLoadedMarker(resultsHeading);
	}

	public List<ProductCard> getProductCards() {
		return productCards;
	}

	public ProductCard getProductCard() {
		return productCard;
	}

	public FilterOptions getFilterOptions() {
		return filterOptions;
	}

	public PriceFilterModal getPriceFilterModal() {
		return priceFilterModal;
	}
}


