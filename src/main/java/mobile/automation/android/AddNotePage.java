package mobile.automation.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddNotePage extends AbstractPage {
	@FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")
	private ExtendedWebElement skipTutorial;
	@FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/img_add")
	private ExtendedWebElement addNote;

	@FindBy(xpath = "//android.widget.TextView[@text='Text']")
	private ExtendedWebElement addTextNote;

	@FindBy(xpath = "//android.widget.TextView@text='Checklist']")
	private ExtendedWebElement addChecklist;

	@FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/note_list")
	private ExtendedWebElement addNoteScreen;

	public AddNotePage(WebDriver driver) {
		super(driver);
	}

	public void selectAddNote() {
		addNote.click();
	}

	public void selectAddTextNote() {
		addTextNote.click();
	}

	public void createTextNote() {
		addNote.click();
		addTextNote.click();
	}

	public void selectAddChecklist() {
		addChecklist.click();
	}

	public void selectSkipTutorial() {
		skipTutorial.click();
	}
	@Override
	public boolean isPageOpened() {
		return addNoteScreen.isElementPresent();
	}
}
