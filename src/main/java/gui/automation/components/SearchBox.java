package gui.automation.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchBox extends AbstractUIObject {
	@FindBy(id = "search")
	private ExtendedWebElement searchField;

	@FindBy(css = "[data-test='@web/Search/SearchButton']")
	private ExtendedWebElement searchBtn;

	@FindBy(css="[data-test='@web/Search/SearchTypeahead/SearchTypeaheadHistoryLink'] span")
	private List<ExtendedWebElement> autosuggestions;

	public SearchBox(WebDriver driver, SearchContext searchContext){
		super(driver, searchContext);
	}

	public void searchItem(String q) {
		searchField.type(q);
		searchBtn.click();
	}


	public List<String> getAutosuggestionTexts(String q) {
		searchField.type(q);

		List<String> autosuggestionTexts = autosuggestions.stream()
				.map(ExtendedWebElement::getText)
				.collect(Collectors.toList());
		return autosuggestionTexts;
	}
}
