package LeadModule_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage_Lead {
	
	@FindBy(name="user_name") private WebElement username;
	@FindBy(name="user_password") private WebElement password;
	@FindBy(id="submitButton") private WebElement logbtn;
	
	public LogInPage_Lead (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUser() {
		return username;
	}

	public WebElement getPass() {
		return password;
	}

	public WebElement getLogbtn() {
		return logbtn;
	}
	
	
	

}
