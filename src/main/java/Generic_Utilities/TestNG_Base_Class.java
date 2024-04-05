package Generic_Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeSuite;

import POM.HomePage;
import POM.LoginPage;

public class TestNG_Base_Class {
	
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public Selenium_Utiity sUtil = new Selenium_Utiity();
	public WebDriver driver;
	
	//For Listeners
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig() {
	    System.out.println("==========DB connection successful=============");
	}
	
	//@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String Browser*/) throws IOException {
		driver = new ChromeDriver();
		
		/*if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}*/
		String URL = pUtil.ReadDataProp("url");
		
		//for listeners
	    sDriver=driver;
		
		driver.get(URL);
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver);
		System.out.println("==========Browser launch successful=========");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String USER = pUtil.ReadDataProp("username");
		String PASS = pUtil.ReadDataProp("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USER, PASS);
		System.out.println("==============log in to app successful==========");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		sUtil.explicitWait(driver, hp.getMouseHoverElement());
		hp.mouseHover(driver);
		sUtil.explicitWait(driver, hp.getSignout());
		hp.signout();
		System.out.println("======log out app successful=======");
	}
	
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		System.out.println("============closure of window successful==========");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("============DB closure successful=============");
	}
	
	
}
