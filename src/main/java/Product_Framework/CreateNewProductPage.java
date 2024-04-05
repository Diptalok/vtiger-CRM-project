package Product_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewProductPage{
	
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")private WebElement Productname;
	
	public void ProductName(String lastname) {
		Productname.sendKeys(lastname);
	}
	
    @FindBy(name="productcategory")private WebElement Productcatagory;
	
	public void handleDropdown(String text) {
		Select se = new Select(Productcatagory);
		se.selectByVisibleText(text);
	}
	
    @FindBy(name="button")private WebElement save;
	
	public void save() {
		save.click();
	}
	
	

}
