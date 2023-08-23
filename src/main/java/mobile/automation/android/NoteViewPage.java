package mobile.automation.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NoteViewPage extends AbstractPage {
	@FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/back_btn")
	private ExtendedWebElement backBtn;

	@FindBy(id="com.socialnmobile.dictapps.notepad.color.note:id/view_note")
	private ExtendedWebElement viewNote;

	public NoteViewPage(WebDriver driver) {
		super(driver);
	}

	public void clickBackBtn() {
		backBtn.click();
	}

	public boolean isViewNotePresent() {
		return viewNote.isElementPresent();
	}
}
