package Product_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.Selenium_Utiity;

public class HomePage extends Selenium_Utiity {
	
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Products") private WebElement product;
	
	public void product_click() {
		product.click();
	}
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]") private WebElement adminstrator;
	
	public void mouseHover(WebDriver driver) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(adminstrator).perform();;
		Thread.sleep(1000);
	}
	
    @FindBy(linkText="Sign Out") private WebElement signout;
	
	public void signOut(WebDriver driver) throws InterruptedException {
        signout.click();
	}


}
