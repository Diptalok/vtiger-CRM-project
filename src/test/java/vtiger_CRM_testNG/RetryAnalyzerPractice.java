package vtiger_CRM_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	
	@Test(retryAnalyzer=Generic_Utilities.RetryAnalyzerImplementation.class)
	public void practice() {
		Assert.fail();
		System.out.println("PASS");
	}

}
