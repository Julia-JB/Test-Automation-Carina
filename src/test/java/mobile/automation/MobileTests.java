package mobile.automation;

import com.zebrunner.carina.core.IAbstractTest;
import mobile.automation.android.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTests implements IAbstractTest {
	@Test
	public void testAddNote() {
		PermissionPage permissionPage = new PermissionPage(getDriver());
		permissionPage.selectAllowNotifications();
		permissionPage.selectAllowAccess();

		AddNotePage addNotePage = new AddNotePage(getDriver());
		addNotePage.selectSkipTutorial();
		Assert.assertTrue(addNotePage.isPageOpened(), "Add note page is not opened");
		addNotePage.createTextNote();

		EditNotePage editNotePage = new EditNotePage(getDriver());
		Assert.assertTrue(editNotePage.isPageOpened(), "Edit note page is not opened");
		String note = "Hi there! Here's the note.";
		editNotePage.typeAndSaveNote(note);
		NoteViewPage noteViewPage = new NoteViewPage(getDriver());
		Assert.assertTrue(noteViewPage.isViewNotePresent(), "The note view is not present");
	}

	@Test
	public void testEditNote() throws InterruptedException {
		PermissionPage permissionPage = new PermissionPage(getDriver());
		permissionPage.allowAll();

		AddNotePage addNotePage = new AddNotePage(getDriver());
		addNotePage.selectSkipTutorial();
		Assert.assertTrue(addNotePage.isPageOpened(), "Add note page is not opened");

		addNotePage.createTextNote();
		EditNotePage editNotePage = new EditNotePage(getDriver());
		Assert.assertTrue(editNotePage.isPageOpened(), "Edit note page is not opened");
		String note = "Hi there! Here's the note.";
		editNotePage.typeAndSaveNote(note);

		NoteViewPage noteViewPage = new NoteViewPage(getDriver());
		Assert.assertTrue(noteViewPage.isViewNotePresent(), "The note view is not present");

		String editedNote = "This note is edited!";
		editNotePage.editAndSaveNote(editedNote);

		Assert.assertEquals(editNotePage.getNoteText(), editedNote, "The note text does not " +
				"match expected");
	}

	@Test
	public void testAddMultipleNotes(){
		PermissionPage permissionPage = new PermissionPage(getDriver());
		permissionPage.allowAll();

		AddNotePage addNotePage = new AddNotePage(getDriver());
		addNotePage.selectSkipTutorial();
		Assert.assertTrue(addNotePage.isPageOpened(), "Add note page is not opened");

		addNotePage.createTextNote();
		EditNotePage editNotePage = new EditNotePage(getDriver());
		Assert.assertTrue(editNotePage.isPageOpened(), "Edit note page is not opened");
		String noteOne = "Water the plants";
		editNotePage.typeAndSaveNote(noteOne);

		NoteViewPage noteViewPage = new NoteViewPage(getDriver());
		noteViewPage.clickBackBtn();

		String noteTwo = "Feed the fish";
		editNotePage.addNote();
		addNotePage.selectAddTextNote();
		editNotePage.typeAndSaveNote(noteTwo);

		noteViewPage.clickBackBtn();

		HomePage homePage = new HomePage(getDriver());
		int numberOfNotes = homePage.getNotesList().size();

		Assert.assertEquals(numberOfNotes, 2, "The number of notes does not match expected");
	}

	@Test
	public void testDeleteNote() {
		PermissionPage permissionPage = new PermissionPage(getDriver());
		permissionPage.allowAll();

		AddNotePage addNotePage = new AddNotePage(getDriver());
		addNotePage.selectSkipTutorial();
		Assert.assertTrue(addNotePage.isPageOpened(), "Add note page is not opened");

		addNotePage.createTextNote();
		EditNotePage editNotePage = new EditNotePage(getDriver());
		Assert.assertTrue(editNotePage.isPageOpened(), "Edit note page is not opened");
		String noteOne = "Hi there! Here's the note.";
		editNotePage.typeAndSaveNote(noteOne);

		editNotePage.getMenu();
		Assert.assertTrue(editNotePage.isMenuDropdownVisible(), "Menu dropdown is not visible");

		editNotePage.deleteNote();
		Assert.assertTrue(addNotePage.isPageOpened(), "Add note page is not opened");
	}
}
