package vtiger_CRM_GenUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.defaultprovider.PropertyFileDefaultProvider;

import Generic_Utilities.ExcelFileUtility;
import Generic_Utilities.PropertyFileUtility;
import Generic_Utilities.Selenium_Utiity;
import POM.ContactPage;
import POM.Create_ContactPage;
import POM.DeleteContactPage;
import POM.HeaderCapturePage;
import POM.HomePage;
import POM.LoginPage;

public class pract {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		PropertyFileUtility pf = new PropertyFileUtility();
		String URL = pf.ReadDataProp("url");
		String USER = pf.ReadDataProp("username");
		String PASS = pf.ReadDataProp("password");
		ExcelFileUtility ef = new ExcelFileUtility();
		String LASTNAME = ef.ReadDataExcel("Contact", 1, 3);
		String LEAD = ef.ReadDataExcel("Contact", 4, 3);
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USER, PASS);
		HomePage hp = new HomePage(driver);
		hp.contact();
		Create_ContactPage cp = new Create_ContactPage(driver);
		cp.create();
		ContactPage c = new ContactPage(driver);
		c.lastname(LASTNAME);
		c.handleDropDown(LEAD);
		c.save();
		HeaderCapturePage hd = new HeaderCapturePage(driver);
	    hd.header();
		Selenium_Utiity su = new Selenium_Utiity();
		su.maximizeWindow(driver);
		su.window(driver);
		su.implicitWait(driver);
		for(int i =1;i<2;i++) {
			su.window(driver);
		}
		DeleteContactPage del = new DeleteContactPage(driver);
		del.checkbox();
		del.delete();
		del.alertAccept(driver);
		Thread.sleep(5000);
		hp.mouseHover(driver);
		hp.signout();
		su.quit(driver);

	}

}
