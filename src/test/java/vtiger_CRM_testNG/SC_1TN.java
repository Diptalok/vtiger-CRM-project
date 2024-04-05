package vtiger_CRM_testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SC_1TN {
    
	@Test
	public void test() throws InterruptedException {
		
		//launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//launch app
		Thread.sleep(2000);
		driver.get("http://localhost:8888");
		
		//give valid credential and log in
		Thread.sleep(2000);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.name("user_password")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to contact page
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		//give value in mandatory field and save
		Thread.sleep(2000);
		driver.findElement(By.name("lastname")).sendKeys("Sahoo");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class=\"crmButton small save\"]")).click();
		Thread.sleep(2000);
		
		//validation
		String lastname = driver.findElement(By.xpath("//span[text()=\"[ CON16 ] Sahoo  -  Contact Information\"]")).getText();
		if(lastname.contains("Sahoo")) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
		Thread.sleep(2000);
		
		//sign out from app
		driver.findElement(By.linkText("Sign Out")).click();
		
		//quit the browser
		Thread.sleep(2000);
		driver.quit();

	}

}
