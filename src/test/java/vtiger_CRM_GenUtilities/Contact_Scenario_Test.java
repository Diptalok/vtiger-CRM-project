package vtiger_CRM_GenUtilities;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.ExcelFileUtility;
import Generic_Utilities.PropertyFileUtility;
import Generic_Utilities.Selenium_Utiity;
import POM.ContactPage;
import POM.Create_ContactPage;
import POM.DeleteContactPage;
import POM.HeaderCapturePage;
import POM.HomePage;
import POM.LoginPage;
public class Contact_Scenario_Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		PropertyFileUtility pf = new PropertyFileUtility();
		ExcelFileUtility ef = new ExcelFileUtility();
		String URL1 = pf.ReadDataProp("url");
		driver.get(URL1);
		Selenium_Utiity su = new Selenium_Utiity();
		su.maximizeWindow(driver);
		String USER = pf.ReadDataProp("username");
		String PASS = pf.ReadDataProp("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USER, PASS);
		HomePage hp = new HomePage(driver);
		hp.contact();
		Create_ContactPage c = new Create_ContactPage(driver);
		c.create();
		String VAL = ef.ReadDataExcel("Contact", 1, 3);
		ContactPage cp = new ContactPage(driver);
		cp.lastname(VAL);
		String TEXT = ef.ReadDataExcel("Contact", 4, 3);
		cp.handleDropDown(TEXT);
		cp.save();
		HeaderCapturePage hc = new HeaderCapturePage(driver);
		hc.header();
		for(int i =1;i<2;i++) {
			su.window(driver);
		}
		DeleteContactPage del = new DeleteContactPage(driver);
		del.checkbox();
		del.delete();
		del.alertAccept(driver);
		hp.mouseHover(driver);
		hp.signout();
		/*WebElement ele = driver.findElement(By.xpath("//select[@name=\"search_field\"]"));
		su.handleDropDown(ele,3 );
		su.implicitWait(driver);
		su.handleDropDown(ele, "firstname");
		su.handleDropDown("Last Name", ele);
		su.minimizeWindow(driver);
		su.maximizeWindow(driver);
		WebElement mouact = driver.findElement(By.linkText("Dashboard"));
		su.mouseHover(driver, mouact);
		su.rightClick(driver, mouact);
		su.doubleClick(driver, mouact);
		su.screenshot(driver, "dashboard");*/

	}

}
