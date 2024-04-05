package vtiger_CRM_GenUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import LeadModule_Framework.Admin_page;
import LeadModule_Framework.LeadPage;
import LeadModule_Framework.LogInPage_Lead;
import LeadModule_Framework.Read_File;
import LeadModule_Framework.Sel_Utilites;

public class Lead_Scenario {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		Read_File rf = new Read_File();
		String URL = rf.ReadPropertydata("url");
		String USER_NAME = rf.ReadPropertydata("username");
		String PASSWORD = rf.ReadPropertydata("password");
		Sel_Utilites sel = new Sel_Utilites();
		sel.launch_app(driver,URL);
		sel.maximize_window(driver);
		sel.implicit_wait(driver);
		LogInPage_Lead log = new LogInPage_Lead(driver);
		log.getUser().sendKeys(USER_NAME);
		log.getPass().sendKeys(PASSWORD);
		log.getLogbtn().click();
		Admin_page ad = new Admin_page(driver);
		ad.getLead().click();
		LeadPage lp = new LeadPage(driver);
		/*lp.getAdd().click();
		String LASTNAME = rf.ReadExcelData("Sheet1", 3, 2);
		String COMPANY = rf.ReadExcelData("Sheet1", 3, 3);
		lp.getLast_name().sendKeys(LASTNAME);
		lp.getCompany().sendKeys(COMPANY);
		lp.getSave().click();
		String text = lp.getValidation().getText();
		String RESULT = sel.validation(text, LASTNAME);
		System.out.println(RESULT);
		ad.getLead().click();
		WebElement DROP = lp.getDropdown();
		DROP.click();
		sel.dropDown(DROP, "Last Name");
		lp.getSearchbox().sendKeys(rf.ReadExcelData("Sheet1", 2, 2));
		lp.getSearch().click();
		Thread.sleep(3000);
		lp.getCheckbox().click();
		lp.getDelete().click();
		sel.alert(driver);*/
		

	}

}
