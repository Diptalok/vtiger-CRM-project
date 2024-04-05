package LeadModule_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_page {
	
	public Admin_page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[.=\"Leads\"])[1]") private WebElement lead;

	public WebElement getLead() {
		return lead;
	}
	
	
}
