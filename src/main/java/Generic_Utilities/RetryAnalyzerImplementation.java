package Generic_Utilities;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer{
	
	int count = 0;
	int retryCount = 3; //Manual analysis
	
    @Override
	public boolean retry(ITestResult result) {
		while(count<retryCount){
			count++;
			return true; //retry 3 times
		}
		return false; //stop retry
	}

}
