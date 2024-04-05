package vtiger_CRM_testNG;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import EmailModule_Framework.POM;
import EmailModule_Framework.Utilities;

public class Email_Scenario {

	@Test
	public void Switching_Window_In_Email_Module() throws Exception {
		WebDriver driver = new ChromeDriver();
		Utilities ut = new Utilities();
		String URL = ut.fetch_data("url");
		String USER = ut.fetch_data("username");
		String PASS = ut.fetch_data("password");
		String CC = ut.fetch_data("cc");
		ut.launchApp(driver, URL);
		POM pm = new POM(driver);
		pm.logintoApp(USER, PASS);
		ut.maxwind(driver);
	    ut.implicitwait(driver);
	    ut.wait(driver);
	    pm.email_click();
	    ut.wait(driver);
	    pm.compose_click();
	    ut.wait(driver);
	    ut.windowhandle(driver);
	    pm.cc_click(CC);
	    Thread.sleep(2000);
	    ut.mainWindow(driver);
	    ut.wait(driver);
	    ut.windowhandle(driver);
	    driver.close();
	    ut.wait(driver);
	    ut.mainWindow(driver);
	    ut.wait(driver);
	    pm.mouseHover(driver);
	    pm.signOut_click();
	    ut.wait(driver);
	    driver.quit();

	}

}
