package mobile.automation.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PermissionPage extends AbstractPage {
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private ExtendedWebElement allow;

	@FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
	private ExtendedWebElement deny;

	public PermissionPage(WebDriver driver) {
		super(driver);
	}

	public void selectAllowNotifications() {
		allow.click();
	}

	public void selectDenyNotifications() {
		deny.click();
	}

	public void selectAllowAccess() {
		allow.click();
	}

	public void allowAll() {
		selectAllowNotifications();
		selectAllowAccess();
	}
}
