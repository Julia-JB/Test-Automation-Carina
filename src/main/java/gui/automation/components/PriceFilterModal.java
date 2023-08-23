package gui.automation.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class PriceFilterModal extends AbstractUIObject {
	@FindBy(xpath = "//div[@data-test='content-wrapper']/div[4]/label")
	private ExtendedWebElement priceOptionFour;

	@FindBy(xpath="//div[@data-test='content-wrapper']/div[4]/label/input")
	private ExtendedWebElement checkboxOptionFour;

	@FindBy(xpath = "//div[@data-test='@web/OverlayModal']/div/button[2]")
	private ExtendedWebElement applyBtn;

	public PriceFilterModal(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}
	public String[] getPriceOptionFourRange() {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500));

		String priceRange = fluentWait.until(e -> {
			if (priceOptionFour.isElementPresent()) {
				return priceOptionFour.getText();
			}
			return null;
		});
		String processedPriceRange = priceRange.replaceAll("\\s*-\\s*", " - ");
		return processedPriceRange.split("\\s*[–—]\\s*");
	}

	public void checkPriceOptionFour() {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500));

		// Use FluentWait to wait until the element is clickable
		fluentWait.until(e -> {
			if (checkboxOptionFour.isClickable() && checkboxOptionFour.isPresent()) {
				return checkboxOptionFour.getElement();
			}
			return null;
		});
		checkboxOptionFour.click();
	}

	public void clickApplyBtn() {
		applyBtn.click();
	}
}
