package commontests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import commoncomponents.GlobalReports;

public class TestListerners extends BaseTest implements ITestListener {

	
	ExtentTest test;
	ExtentReports extent = GlobalReports.reportGeneratorMethod();
	
	
	public void onTestStart(ITestResult result) {
	test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case Passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case Failed");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	
	}
	
	

}