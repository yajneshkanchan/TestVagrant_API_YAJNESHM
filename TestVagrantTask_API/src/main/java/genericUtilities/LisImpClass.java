package genericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class LisImpClass implements ITestListener{
	public void onTestFailure(ITestResult result) {
		Java_utility jlib = new Java_utility();
		String testName = result.getMethod().getMethodName();
		System.out.println(testName+"==========execute==========");
		EventFiringWebDriver eDriver = new EventFiringWebDriver(Base_class.sdriver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshot/"+testName+jlib.getSystemDate()+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}