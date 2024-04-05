package Product_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePage {
	
	public DeletePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="selectall") private WebElement checkBox;
	
	public void checkBox() {
		checkBox.click();
	}
	
    @FindBy(xpath="//input[@value=\"Delete\"]") private WebElement deleteAll;
	
	public void deleteAll() {
		deleteAll.click();
	}

}
