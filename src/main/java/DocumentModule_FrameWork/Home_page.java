package DocumentModule_FrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	public Home_page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText ="Documents") private WebElement document;
	

	public WebElement getDocument() {
		return document;
	}
	
	

}
