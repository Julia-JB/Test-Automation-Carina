package gui.automation.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {
	@FindBy(tagName = "img")
	private ExtendedWebElement productImage;

	@FindBy(css = "[data-test='product-title']")
	private ExtendedWebElement productTitle;

	@FindBy(css = "[data-test='@web/ProductCard/ProductCardBrandAndRibbonMessage/brand']")
	private ExtendedWebElement productBrand;

	@FindBy(css = "[data-test='ratings']")
	private ExtendedWebElement productRating;

	@FindBy(css="[data-test=['rating-count']")
	private ExtendedWebElement ratingCount;

	@FindBy(css = "[data-test='current-price']")
	private ExtendedWebElement currentPrice;

	@FindBy(css = "[data-test='marketplaceSoldBy']")
	private ExtendedWebElement marketPlace;

	@FindBy(css = "[data-test='LPFulfillmentSectionShippingFA_standardShippingMessage']")
	private ExtendedWebElement shippingOptions;

	@FindBy(tagName = "button")
	private ExtendedWebElement addToCartBtn;

	public ProductCard(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public double parseCurrentPrice() {
		String price = currentPrice.getText();
		String numericValueStr = price.replace("$", "");
		return Double.parseDouble(numericValueStr);
	}

	public ExtendedWebElement getProductImage() {
		return productImage;
	}

	public ExtendedWebElement getProductTitle() {
		return productTitle;
	}

	public ExtendedWebElement getProductBrand() {
		return productBrand;
	}

	public ExtendedWebElement getProductRating() {
		return productRating;
	}

	public ExtendedWebElement getRatingCount() {
		return ratingCount;
	}

	public ExtendedWebElement getCurrentPrice() {
		return currentPrice;
	}

	public ExtendedWebElement getMarketPlace() {
		return marketPlace;
	}

	public ExtendedWebElement getShippingOptions() {
		return shippingOptions;
	}

	public ExtendedWebElement getAddToCartBtn() {
		return addToCartBtn;
	}

}
