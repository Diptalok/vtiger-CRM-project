package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Log_InVT {
	
	public Log_InVT(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type=\"text\"]")
	private WebElement UN;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	private WebElement PW;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement BT;
	
	@FindBy (xpath = "//img[@align=\"left\"]")
	private WebElement SR_CH;
	
	@FindBy (xpath = "(//input[@value=\"Faq\"])[1]")
	private WebElement SR_FA;
	
	@FindBy (xpath = "//input[@value=\"Apply\"]")
	private WebElement SR_AP;
	
	@FindBy (xpath = "//img[@id=\"jscal_trigger_date_start\"]")
	private WebElement CAL;
	
	@FindBy (xpath = "(//td[.=\"15\"]/ancestor::div[@class=\"calendar\"]/descendant::td[.=\"5\"])[2]")
	private WebElement CALENDAR;
	
	@FindBy (xpath = "//input[@value=\"  Save\"]")
	private WebElement SAVE;
	
	@FindBy (xpath = "//input[@name=\"subject\"]")
	private WebElement SUB;
	
	@FindBy(xpath="//select[@id=\"qccombo\"]")
	private WebElement CH_B;
	
	@FindBy(xpath="//a[.=\"All Events & Todos\"]")
	private WebElement CH_ALLEVENT;

	public WebElement getCH_ALLEVENT() {
		return CH_ALLEVENT;
	}

	public WebElement getSUB() {
		return SUB;
	}

	public WebElement getSAVE() {
		return SAVE;
	}

	public WebElement getCALENDAR() {
		return CALENDAR;
	}

	public WebElement getCAL() {
		return CAL;
	}

	public WebElement getSR_AP() {
		return SR_AP;
	}
	
	public WebElement getCH_B() {
		return CH_B;
	}

	public WebElement getSR_FA() {
		return SR_FA;
	}

	public WebElement getSR_CH() {
		return SR_CH;
	}

	public WebElement getUN() {
		return UN;
	}

	public WebElement getPW() {
		return PW;
	}

	public WebElement getBT() {
		return BT;
	}

}
