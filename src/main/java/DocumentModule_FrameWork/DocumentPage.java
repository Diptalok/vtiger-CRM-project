package DocumentModule_FrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
	
	public DocumentPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//img[@alt=\"Create Document...\"]") private WebElement addDoc;

	public WebElement getAddDoc() {
		return addDoc;
	}

	@FindBy(name ="notes_title") private WebElement title;

	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(xpath ="//input[@value=\"  Save  \"]") private WebElement save;

	public WebElement getSave() {
		return save;
	}
	
	@FindBy(xpath ="//body[@spellcheck=\"false\"]") private WebElement note;

	public WebElement getNote() {
		return note;
	}
	
	@FindBy(name ="add") private WebElement addFLD;

	public WebElement getaddFLD() {
		return addFLD;
	}
	
	@FindBy(name ="folderName") private WebElement foldname;

	public WebElement getFoldname() {
		return foldname;
	}
	
	@FindBy(xpath="//input[@name=\"save\"]") private WebElement save_fld;

	public WebElement getSave_fld() {
		return save_fld;
	}
	

}
