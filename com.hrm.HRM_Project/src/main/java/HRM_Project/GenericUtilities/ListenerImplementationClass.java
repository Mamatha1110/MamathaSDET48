package HRM_Project.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot takesScreenshot = (TakesScreenshot)BaseClass.sDriver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String localDateTime = LocalDateTime.now().toString().replace(":", "_");
		File dst = new File("./screenShot/"+testName+"_"+localDateTime+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

}
