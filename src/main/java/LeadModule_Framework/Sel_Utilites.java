package LeadModule_Framework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Sel_Utilites {
	
	public void launch_app(WebDriver driver,String url) {
		driver.get(url);
	}
	
	public void maximize_window(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicit_wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public String validation(String text_val,String last_name) {
		if(text_val.contains(last_name)) {
		}
		String pass = "successful";
		return pass;
	}
	
	public void dropDown(WebElement element,String value) {
		Select se = new Select(element);
		se.selectByVisibleText(value);
		
	}
	
	public void alert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
}
