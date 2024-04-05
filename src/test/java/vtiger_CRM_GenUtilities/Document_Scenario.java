package vtiger_CRM_GenUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import DocumentModule_FrameWork.DocumentPage;
import DocumentModule_FrameWork.Fetch_Data;
import DocumentModule_FrameWork.Home_page;
import DocumentModule_FrameWork.LogINpage;
import DocumentModule_FrameWork.Utilities;

public class Document_Scenario {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		LogINpage log = new LogINpage(driver);
		Fetch_Data fd = new Fetch_Data();
		String URL = fd.read_prop("url");
		String USER = fd.read_prop("username");
		String PASS = fd.read_prop("password");
		Utilities ut = new Utilities();
		ut.app(driver, URL);
		ut.max(driver);
		ut.iwait(driver);
		log.logintoApp(USER,PASS);
		Home_page hp = new Home_page(driver);
		hp.getDocument().click();
		DocumentPage dp = new DocumentPage(driver);
		/*dp.getAddDoc().click();
		String val = fd.read_Excel("Sheet1", 1, 2);
		dp.getTitle().sendKeys(val);
		ut.iframe(driver, 0);
		dp.getNote().sendKeys(val);
		ut.pframe(driver);
		dp.getSave().click();*/
		dp.getaddFLD().click();
		dp.getFoldname().sendKeys(fd.read_Excel("Sheet1", 1, 2));
		dp.getSave_fld().click();
		
	}

}
