package vtiger_CRM_testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SC_2TN {
	
	@Test
	public static void testt() throws InterruptedException {
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
				
				
				//delete all contact
				
				for (WebElement web :driver.findElements(By.xpath("//input[@name=\"selected_id\"]")) ) {
					web.click();
				}
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				
				
				//validation
				String str = driver.findElement(By.xpath("(//td[@nowrap=\"nowrap\"])[2]")).getText();
				System.out.println(str);
				if(str.contains("No Contact Found !")) {
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}
				
				//sign out from app
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Sign Out")).click();
				
				//quit the browser
				Thread.sleep(2000);
				driver.quit();
	}

}
