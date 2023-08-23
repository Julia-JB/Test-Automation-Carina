package api.automation;
import com.mycompany.carina.demo.utils.ProductConstants;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zebrunner.agent.core.registrar.TestRunRegistrar.LOGGER;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class ProductTests implements IAbstractTest {
	@Test()
	public void testCreateProduct() {
		LOGGER.info("test");
		PostProductMethod api = new PostProductMethod();
		api.callAPIExpectSuccess();
		api.validateResponse();
	}

	@Test()
	public void testGetProducts() {
		GetProductsMethod api = new GetProductsMethod();
		Response response = api.callAPIExpectSuccess();
		api.validateResponseAgainstSchema("api/products/_get/rs.schema");

		int totalProducts = response.body().jsonPath().getInt("total");
		Assert.assertEquals(totalProducts, ProductConstants.TOTAL, "Number of products does not match" +
				" expected");
	}

	@Test()
	public void testGetProductById() {
		LOGGER.info("test");
		GetProductByIdMethod api = new GetProductByIdMethod();
		api.callAPIExpectSuccess()
				.then()
				.assertThat()
				.time(lessThanOrEqualTo(500L));

		api.validateResponseAgainstSchema("api/products/_get/rs-single.schema");
	}

	@Test()
	public void testGetFilteredProducts() {
		LOGGER.info("test");
	GetFilteredProducts api = new GetFilteredProducts();
	Response response = api.callAPIExpectSuccess()
			.then()
			.assertThat()
			.body("products.size()", greaterThan(0))
			.extract().response();

		int size = response.getBody().jsonPath().getList("products").size();
		LOGGER.info("Size of 'products' array in the response: " + size);
	}

	@Test
	public void testGetProductNonExistingId() {
		GetProductNonExistingId api = new GetProductNonExistingId();
		Response response = api.callAPIExpectSuccess();
		String message = response.getBody().jsonPath().getString("message");
		Assert.assertEquals(message, "Product with id '" + api.getId() + "' not found", "Message " +
				"does not match expected");
	}

	@Test
	public void testUpdateProductWithPatch() {
		UpdateProductWithPatch api = new UpdateProductWithPatch();
		Response response = api.callAPIExpectSuccess();

		String payload = api.getRequestBody();
		JSONObject payloadJson = new JSONObject(payload);
		int price = payloadJson.getInt("price");
		int actualPrice = response.getBody().jsonPath().getInt("price");

		Assert.assertEquals(price, actualPrice, "Updated price does not match expected");
		api.validateResponseAgainstSchema("api/products/_patch/rs.schema");
	}

   @Test
   public void testGetProductsCategories() {
		GetCategories api = new GetCategories();
		api.callAPIExpectSuccess();
		api.validateResponse();
   }

   @Test
   public void testGetProductsOfCategory() {
		GetProductsOfCategory api = new GetProductsOfCategory();
		Response response = api.callAPIExpectSuccess();
		api.validateResponseAgainstSchema("api/categories/rs-prodofcategory.schema");
		int productsSize = response.getBody().jsonPath().getList("products").size();
		Assert.assertTrue(productsSize > 0);
   }

   @Test
   public void testGetSpecificProperties() {
		GetSpecificProperties api = new GetSpecificProperties();
		api.callAPIExpectSuccess();
		api.validateResponseAgainstSchema("api/products/_get/rs-specprops.schema");
   }

   @Test
   public void testDeleteProduct() {
		DeleteProduct api = new DeleteProduct();
		api.callAPIExpectSuccess();
		api.validateResponseAgainstSchema("api/products/_delete/rs.schema");
   }
}
