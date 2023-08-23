package gui.automation;

import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.core.AbstractTest;
import gui.automation.pages.FBHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends AbstractTest {

	@Test
	public void testLogin() {
		FBHomePage home = new FBHomePage(getDriver());
		home.open();
		home.assertPageOpened();
		home.login("testUser@gmail.com", "pass");

		String actualErrorText = home.getErrorText();
		System.out.println(actualErrorText);

		String expectedErrorText = "Unknown error";

		Assert.assertTrue(actualErrorText.contains(expectedErrorText), "Error message " +
				"does not match expected");
	}
}
