package EmailModule_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM extends Utilities {
	public POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")private WebElement user;
	@FindBy(name="user_password")private WebElement pass;
	@FindBy(id="submitButton")private WebElement lgn;
	
	public void logintoApp(String USER,String PASS) {
		user.sendKeys(USER);
		pass.sendKeys(PASS);
		lgn.click();
	}
	
	@FindBy(xpath="//a[.=\"Email\"]")private WebElement email;
	
	public void email_click() {
		email.click();
	}
	
    @FindBy(linkText="Compose")private WebElement compose;
	
	public void compose_click() {
		compose.click();
	}
	
    @FindBy(id="cc_name")private WebElement cc;
	
	public void cc_click(String cc_val) {
		cc.sendKeys(cc_val);
	}
	
    @FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")private WebElement adminstrator;

	public void mouseHover(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(adminstrator).perform();
	}
	
    @FindBy(linkText="Sign Out")private WebElement signout;
	
	public void signOut_click() {
		signout.click();
	}

}
