package vtiger_CRM_POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import POM.Log_InVT;

public class Log_In {


	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		File file = new File("./Fetch_Data_FW/tviger.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheetAt(0);
		String sname = sheet.getSheetName();
		Sheet sheet1 = book.getSheet(sname);
		Row row = sheet1.getRow(0);
		Cell cell = row.getCell(0);
		String URL = cell.getStringCellValue();
		driver.get(URL);
		Log_InVT log = new Log_InVT(driver);
		File file1= new File("./Fetch_Data_FW/prop.properties");
		FileInputStream fis1 = new FileInputStream(file1);
		Properties prop = new Properties();
		prop.load(fis1);
		String USER = prop.getProperty("username");
		log.getUN().sendKeys(USER);
		String PASS = prop.getProperty("password");
		log.getPW().sendKeys(PASS);
		log.getBT().click();
		String SUB = prop.getProperty("subject");
		log.getSR_CH().click();
		log.getSR_FA().click();
		log.getSR_AP().click();
		WebElement CH = log.getCH_B();
		CH.click();
		Select se = new Select(CH);
		se.selectByIndex(9);
		Thread.sleep(1000);
		se.selectByVisibleText("New Event");
		Thread.sleep(1000);
		log.getCAL().click();
		log.getCALENDAR().click();
		log.getSAVE().click();
		driver.switchTo().alert().accept();
		log.getSUB().sendKeys(SUB);
		log.getSAVE().click();
		log.getCH_ALLEVENT().click();

	}

}
