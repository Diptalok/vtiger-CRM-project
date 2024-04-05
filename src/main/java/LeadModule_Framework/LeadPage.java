package LeadModule_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage{
	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[contains(@title,\"Cr\")]") private WebElement add;
	@FindBy(name="lastname") private WebElement last_name;
	@FindBy(name="company") private WebElement company;
	@FindBy(xpath="//input[@type=\"submit\"]") private WebElement save;
	@FindBy(xpath="//span[.=\"[ LEA5 ] Sharma  -  Lead Information\"]") private WebElement validation;
	@FindBy(name="search_text") private WebElement searchbox;
	@FindBy(xpath="//input[@name=\"submit\"]") private WebElement search;
	@FindBy(xpath="//select[@name=\"search_field\"]") private WebElement dropdown;
	@FindBy(id="selectCurrentPageRec") private WebElement checkbox;
	@FindBy(xpath = "//input[@value=\"Delete\"]")private WebElement delete;

	public WebElement getDelete() {
		return delete;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getValidation() {
		return validation;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getLast_name() {
		return last_name;
	}

	public WebElement getAdd() {
		return add;
	}
	

}
