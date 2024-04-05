package EmailModule_Framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Utilities {

	public String fetch_data(String key) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Email_module\\Propertyfile.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

	public void launchApp(WebDriver driver, String URL) {
		driver.get(URL);
	}

	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void maxwind(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void mainWindow(WebDriver driver) {
		Set<String> win_ids = driver.getWindowHandles();
		for (String win_id : win_ids) {
			driver.switchTo().window(win_id);
			String title = driver.getTitle();
			if (title.equals("Adminstrator - Email - vtiger CRM 5 - Commercial Open Source CRM")) {
				break;
			}
		}
	}

	public void wait(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
	}

	public void windowhandle(WebDriver driver) {
		Set<String> win_ids = driver.getWindowHandles();
		for (String win_id : win_ids) {
			driver.switchTo().window(win_id);
			String title = driver.getTitle();
			if (title.equals("Compose Mail")) {
				break;
			}
		}
	}

	public void mouseHover(WebDriver driver, WebElement element) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(1000);
	}
}
