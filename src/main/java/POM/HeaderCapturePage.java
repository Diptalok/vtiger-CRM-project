package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderCapturePage {
	
	public HeaderCapturePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(.,\"[\")]") private WebElement header;
	
	public void header() {
		String htext = header.getText();
		if(htext.contains("Iron Man")) {
		}
	}
	
}
