package Generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println("==========Test Execution Started===========");
		
		//create a @Test in extent Reports
		test = report.createTest(MethodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println("==========Test Execution passed===========");
		
		//Log the status as PASS in extent Reports
		test.log(Status.PASS,MethodName+"==========Test Execution passed===========");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName + " Test Execution failed");
		
		//Log the status as FAIL in extent Reports
		test.log(Status.FAIL,MethodName+"==========Test Execution failed===========");

		Selenium_Utiity sutil = new Selenium_Utiity();
		JavaUtility jutil = new JavaUtility();

		String screenshotName = MethodName + "-" + jutil.getDate();

		try {
			String path = sutil.screenshot(TestNG_Base_Class.sDriver, screenshotName);
			
			//attach the screenshot to extent reports
			test.addScreenCaptureFromPath(path);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName + " Test Execution skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getAllTestMethods());
		System.out.println("==========Test suite started==========");
		
		//configuration of extent reports
		ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setReportName("vtiger Execution Report");
		rep.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base platform", "windows");
		report.setSystemInfo("Base url", "https://localhost:8888");
		report.setSystemInfo("Reporter Name", "Diptalok");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("==========Test suite ended==========");
		
		//Generate the extent report
		report.flush();

	}

}
