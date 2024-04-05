package Product_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage {
	public ValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    @FindBy(xpath="//*[@class=\"lvtHeaderText\"]")private WebElement headername;
	
	public void validation(String lastname) {
		String header = headername.getText();
		if(header.contains(lastname)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
	}

}
