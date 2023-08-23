package mobile.automation.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad" +
			".color.note:id/title']")
	private List<ExtendedWebElement> notesList;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	public List<ExtendedWebElement> getNotesList() {
		return notesList;
	}
}
