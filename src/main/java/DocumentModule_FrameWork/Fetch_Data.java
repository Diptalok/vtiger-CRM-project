package DocumentModule_FrameWork;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fetch_Data {
	public String read_prop(String key) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Document_module\\Propertyfile.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String read_Excel(String sname,int row,int cell) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Document_module\\excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		return book.getSheet(sname).getRow(row).getCell(cell).getStringCellValue();
	}
	
	

}
