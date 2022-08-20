package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryImpclass implements IRetryAnalyzer {
	int counter=0;
	int retrylimit=4;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(counter<retrylimit) {
			counter++;
			return true;
		}
		return false;
	}
}
