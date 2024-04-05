package vtiger_CRM_testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.Selenium_Utiity;
import Product_Framework.CreateNewProductPage;
import Product_Framework.DeletePage;
import Product_Framework.Fetch_data;
import Product_Framework.HomePage;
import Product_Framework.LoginPage;
import Product_Framework.ProductPage;
import Product_Framework.ValidationPage;

public class Product_Scenario {

	@Test
	public  void Add_Delete_ProductModule() throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		//fetch data
		Fetch_data dt = new Fetch_data();
		String URL = dt.read_prop("url");
		String USER = dt.read_prop("username");
		String PASS = dt.read_prop("password");
		
		//launch browser
		Selenium_Utiity su = new Selenium_Utiity();
		su.launchApp(driver, URL);
		su.maximizeWindow(driver);
		
		//log in to app
		LoginPage log = new LoginPage(driver);
		log.logintoApp(USER, PASS);
		
		//click on products link in homepage
		HomePage hp = new HomePage(driver);
		hp.product_click();
		hp.implicitWait(driver);
		
		//create new product by clicking add
		ProductPage pp = new ProductPage(driver);
		pp.addnewProduct();
		
		//give lastname as input and save the new product
		CreateNewProductPage cp = new CreateNewProductPage(driver);
		String LASTNAME = dt.read_Excel("Product", 1, 2);
		String TEXT = dt.read_Excel("Product", 1, 3);
		cp.ProductName(LASTNAME);
		cp.handleDropdown(TEXT);
		cp.save();
		
		//validate whether the product is created successfully or not
		ValidationPage vp = new ValidationPage(driver);
		vp.validation(LASTNAME);
		
		//navigate window twice
		su.window(driver);
		
		//delete all created product
		DeletePage dp = new DeletePage(driver);
		dp.checkBox();
		dp.deleteAll();
		
		//accept alert
		su.alertAccept(driver);
		Thread.sleep(5000);
		
		//sign out
		hp.mouseHover(driver);
		hp.signOut(driver);
		su.quit(driver);

	}

}
