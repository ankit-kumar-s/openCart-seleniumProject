package openCart_Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import opencart_TestBase.openCart_BaseTest;

public class openCart_ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter spark ;
	public ExtentReports report;
	public ExtentTest test;
	String reportName;
	
	public void onStart (ITestContext result) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName =  "Test-Report-" + timeStamp + ".html";
		
		spark = new ExtentSparkReporter(".\\reports\\" + reportName);
		
		spark.config().setDocumentTitle("OpenCart Automation  Report");
		spark.config().setReportName("Opencart Functional test");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
	    report.attachReporter(spark);
	}
	
	public void onTestSuccess(ITestResult result) {
		test=report.createTest(result.getName());
		test.log(Status.PASS, "TestCasePassed");
	}
	
	public void onTestFailure(ITestResult result) {
		test=report.createTest(result.getName());
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		try {
			String imgPath = new openCart_BaseTest().captureScreenshot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test=report.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext result) {
		report.flush();
	}

}
