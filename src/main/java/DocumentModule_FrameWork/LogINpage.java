package DocumentModule_FrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogINpage {
	@FindBy(name="user_name") private WebElement username;
	@FindBy(name="user_password") private WebElement password;
	@FindBy(id="submitButton") private WebElement logbtn;
	
	public LogINpage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void logintoApp(String user,String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		logbtn.click();
	}

}
