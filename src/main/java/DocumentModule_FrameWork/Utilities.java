package DocumentModule_FrameWork;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utilities {
	
	public void app(WebDriver driver,String URL) {
		driver.get(URL);
	}
	public void max(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void iwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void iframe(WebDriver driver,int no) {
		driver.switchTo().frame(no);
	}
	
	public void pframe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

}
