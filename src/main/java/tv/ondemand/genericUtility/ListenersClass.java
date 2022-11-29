package tv.ondemand.genericUtility;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenersClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getMethod().getMethodName());
		test.generateLog(Status.INFO, result.getName());
//		test = report.createTest("end to end test cases");
	}

	public void onTestSuccess(ITestResult result) {
//		test = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		test.generateLog(Status.FAIL, result.getMethod().getMethodName()+" - is failed");
		test.log(Status.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test.generateLog(Status.SKIP, result.getMethod().getMethodName()+" - is Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		Date date = new Date();
		String currentDate = date.toString().replace(" ", "_");
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/extentReport-"+currentDate+"/reportExtent.html");
		htmlReporter.config().setDocumentTitle("onDemand_API_report");

		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "LINUX");
		report.setSystemInfo("Reporter Name", "sohan");
		}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
