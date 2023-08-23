package gui.automation;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.CsvDataSourceParameters;
import gui.automation.components.*;
import gui.automation.pages.FBHomePage;
import gui.automation.pages.HomePage;
import gui.automation.pages.SearchResultsPage;
import gui.automation.pages.TopDealsPage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class WebTests implements IAbstractTest, IAbstractDataProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	@Test
	public void testTopDealsOptions() {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

		PrimaryHeader header = homePage.getPrimaryHeader();
		header.selectTopDeals();
		TopDealsPage dealsPage = new TopDealsPage(getDriver());
		Assert.assertTrue(dealsPage.isPageOpened());

		int expectedDealsOptionsCount = 19;
		int actualDealsOptionsCount = dealsPage.getTopDealsLinks().size();
		LOGGER.info("Actual number of top deals options: " + actualDealsOptionsCount);

		Assert.assertEquals(actualDealsOptionsCount, expectedDealsOptionsCount, "Deals options " +
				"number does not match expected");
	}

	@Test(dataProvider = "DataProvider")
	@CsvDataSourceParameters(path = "data_source/searchQueries.csv", dsUid = "TUID", dsArgs =
			"searchQuery")
	public void testSearchURL(String searchQuery) {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

		SearchBox searchBox = homePage.getSearchBox();

		searchBox.searchItem(searchQuery);
		String actualPageURL = getDriver().getCurrentUrl();
		String expectedPageURL = "https://www.target.com/s?searchTerm=" + searchQuery.replace(" ", "+");
		Assert.assertEquals(actualPageURL, expectedPageURL, "Actual page url does not match " +
				"expected");
	}

	@Test(dataProvider = "searchQueries", dataProviderClass = SearchDataProviders.class)
	public void testSearchAutoSuggestions(String searchQuery) {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

		SearchBox searchBox = homePage.getSearchBox();

		List<String> autosuggestions = searchBox.getAutosuggestionTexts(searchQuery);
		for (String option : autosuggestions) {
			LOGGER.info("Suggested option: " + option);
			Assert.assertTrue(option.contains(searchQuery),
					"Autosuggestion text does not match search query: " +
							"Expected: " + searchQuery + ", Actual: " + option);
		}
	}

	@Test(dataProvider = "searchQueries", dataProviderClass = SearchDataProviders.class)
	public void testSearchResultsList(String searchQuery) {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

		SearchBox searchBox = homePage.getSearchBox();
		searchBox.searchItem(searchQuery);

		SearchResultsPage resultsPage = new SearchResultsPage(getDriver());
		Assert.assertTrue(resultsPage.isPageOpened(), "Search results page is not opened");
		List<ProductCard> productCards = resultsPage.getProductCards();
		Assert.assertTrue(!productCards.isEmpty(), "Product cards list is empty");
		LOGGER.info("Product cards number is: " + productCards.size());
	}

	@Test(dataProvider = "searchQueries", dataProviderClass = SearchDataProviders.class)
	public void testSearchResultsProductCard(String searchQuery) {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

		SearchBox searchBox = homePage.getSearchBox();
		searchBox.searchItem(searchQuery);

		SearchResultsPage resultsPage = new SearchResultsPage(getDriver());
		Assert.assertTrue(resultsPage.isPageOpened(), "Search results page is not opened");

		ProductCard productCard = resultsPage.getProductCard();

		productCard.assertElementPresent(productCard.getProductImage());
		productCard.assertElementPresent(productCard.getProductTitle());
		productCard.assertElementPresent(productCard.getProductBrand());
		productCard.assertElementPresent(productCard.getCurrentPrice());
	}

	@Test(dataProvider = "DataProvider")
	@CsvDataSourceParameters(path = "data_source/searchQueries.csv", dsUid = "TUID", dsArgs =
			"searchQuery")
	public void testSearchResultsPriceFilter(String searchQuery) {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

		SearchBox searchBox = homePage.getSearchBox();
		searchBox.searchItem(searchQuery);

		SearchResultsPage resultsPage = new SearchResultsPage(getDriver());
		Assert.assertTrue(resultsPage.isPageOpened(), "Search results page is not opened");

		FilterOptions filterOptions = resultsPage.getFilterOptions();
		filterOptions.clickPriceFilterBtn();

		PriceFilterModal filterModal = resultsPage.getPriceFilterModal();


		String[] priceRange = filterModal.getPriceOptionFourRange();
		int minValue = Integer.parseInt(priceRange[0].replace("$", "").trim());
		int maxValue = Integer.parseInt(priceRange[1].replace("$", "").trim());

		filterModal.checkPriceOptionFour();
		filterModal.clickApplyBtn();

		SearchResultsPage resultsPageUpdated = new SearchResultsPage(getDriver());
		Assert.assertTrue(resultsPageUpdated.isPageOpened(), "Search results page is not opened");

		List<ProductCard> productCards = resultsPageUpdated.getProductCards();
		int cardsChecked = 0;
		int maxCardsToCheck = 4;

		LOGGER.info("Price range: minimum: $" + minValue + ", maximum: $" + maxValue);
		for (ProductCard productCard : productCards) {
			ProductCard card = new ProductCard(getDriver(), productCard.getRootExtendedElement().getElement());
			double currentPrice = card.parseCurrentPrice();
			LOGGER.info("Product title: " + card.getProductTitle().getText() + " Current price: " +
					"$" + currentPrice);
			Assert.assertTrue(currentPrice >= minValue && currentPrice <= maxValue, "Price does " +
					"not match the selected range");
			cardsChecked++;
			if (cardsChecked >= maxCardsToCheck) {
				break;
			}
		}
	}
}
