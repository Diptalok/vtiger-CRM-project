package vtiger_CRM_testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.Selenium_Utiity;
import Generic_Utilities.TestNG_Base_Class;
import Product_Framework.CreateNewProductPage;
import Product_Framework.DeletePage;
import Product_Framework.Fetch_data;
import Product_Framework.HomePage;
import Product_Framework.LoginPage;
import Product_Framework.ProductPage;
import Product_Framework.ValidationPage;

public class Product_Scenario2 extends TestNG_Base_Class{

	@Test
	public  void Add_Delete_ProductModule() throws Exception {
		
		//click on products link in homepage
		HomePage hp = new HomePage(driver);
		hp.product_click();
		hp.implicitWait(driver);
		
		//create new product by clicking add
		ProductPage pp = new ProductPage(driver);
		pp.addnewProduct();
		
		//give lastname as input and save the new product
		CreateNewProductPage cp = new CreateNewProductPage(driver);
		String LASTNAME = eUtil.ReadDataExcel("Contact", 1, 3);
		String TEXT = eUtil.ReadDataExcel("Contact", 1, 4);
		cp.ProductName(LASTNAME);
		cp.handleDropdown(TEXT);
		cp.save();
		
		//validate whether the product is created successfully or not
		ValidationPage vp = new ValidationPage(driver);
		vp.validation(LASTNAME);
		
		//navigate window twice
		sUtil.window(driver);
		
		//delete all created product
		DeletePage dp = new DeletePage(driver);
		dp.checkBox();
		dp.deleteAll();
		
		//accept alert
		sUtil.alertAccept(driver);
		Thread.sleep(5000);
		

	}

}
