package gui.automation.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FBHomePage extends AbstractPage {
	@FindBy(id = "email")

	ExtendedWebElement emailField;

	@FindBy(id = "pass")
	ExtendedWebElement passwordField;

	@FindBy(css = "button[name=\"login\"]")
	ExtendedWebElement loginBtn;

	@FindBy(id = "error_box")
	ExtendedWebElement errorBox;

	public FBHomePage(WebDriver driver) {
		super(driver);
	}

	public void login(String email, String password) {
		emailField.type(email);
		passwordField.type(password);
		loginBtn.click();
	}

	public String getErrorText() {
		return errorBox.getText();
	}
}
