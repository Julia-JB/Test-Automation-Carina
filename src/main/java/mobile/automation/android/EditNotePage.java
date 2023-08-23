package mobile.automation.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EditNotePage extends AbstractPage {

	@FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit_note")
	private ExtendedWebElement noteField;

	@FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/back_btn")
	private ExtendedWebElement saveNoteBackBtn;

	@FindBy(id="com.socialnmobile.dictapps.notepad.color.note:id/view_note")
	private ExtendedWebElement viewNote;

	@FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit_btn")
	private ExtendedWebElement editBtn;

	@FindBy(id="com.socialnmobile.dictapps.notepad.color.note:id/main_btn1")
	private ExtendedWebElement addNoteBtn;

	@FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/menu_btn")
	private ExtendedWebElement menuBtn;

	@FindBy(className = "android.widget.ListView")
	private ExtendedWebElement menuDropdown;

	@FindBy(xpath = "//*[@text='Delete']")
	private ExtendedWebElement deleteBtn;

	@FindBy(id = "android:id/button1")
	private ExtendedWebElement confirmDelete;


	public EditNotePage(WebDriver driver) {
		super(driver);
	}

	public void typeNote(String note) {
		noteField.type(note);
	}

	public void clickEditBtn() {
		editBtn.click();
	}

	public void typeAndSaveNote(String note) {
		noteField.type(note);
		saveNoteBackBtn.click();
	}

	public String getNoteText() {
		return viewNote.getText();
	}

	public void editAndSaveNote(String newNote) {
		clickEditBtn();
		typeAndSaveNote(newNote);
	}

	public void addNote() {
		addNoteBtn.click();
	}

	public void getMenu() {
		menuBtn.click();
	}

	public void deleteNote() {
		deleteBtn.click();
		confirmDelete.click();
	}

	@Override
	public boolean isPageOpened() {
		return noteField.isElementPresent();
	}

	public boolean isMenuDropdownVisible() {
		return menuDropdown.isVisible();
	}
}
