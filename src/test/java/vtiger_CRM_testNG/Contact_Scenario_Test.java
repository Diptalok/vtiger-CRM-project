package vtiger_CRM_testNG;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.TestNG_Base_Class;
import POM.ContactPage;
import POM.Create_ContactPage;
import POM.DeleteContactPage;
import POM.HeaderCapturePage;
import POM.HomePage;

@Listeners(Generic_Utilities.ListenersImplementation.class)
public class Contact_Scenario_Test extends TestNG_Base_Class{

	@Test(groups = {"SmokeSuite","RegressionSuite"},retryAnalyzer = Generic_Utilities.RetryAnalyzerImplementation.class)
	public void Create() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.contact();
		Create_ContactPage c = new Create_ContactPage(driver);
		c.create();
		String VAL = eUtil.ReadDataExcel("Contact", 1, 3);
		ContactPage cp = new ContactPage(driver);
		cp.lastname(VAL);
		String TEXT = eUtil.ReadDataExcel("Contact", 4, 3);
		//Assert.fail();
		cp.handleDropDown(TEXT);
		cp.save();
		HeaderCapturePage hc = new HeaderCapturePage(driver);
		hc.header();
		sUtil.window(driver);
		DeleteContactPage del = new DeleteContactPage(driver);
		del.checkbox();
		del.delete();
		del.alertAccept(driver);
		Thread.sleep(3000);
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
	
	@Test
	public void sample() {
		System.out.println("second test");
	}

}
