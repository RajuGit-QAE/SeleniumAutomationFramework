package commoncomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GlobalReports {
	
	
	public static ExtentReports reportGeneratorMethod()
	{
	
	String path = "C:\\Users\\leoga\\eclipse-workspace\\AutomationFramework\\AllReports";
	
	ExtentSparkReporter ESR = new ExtentSparkReporter(path);
	
	ESR.config().setDocumentTitle("RajaFrameworkexecutionReport");
	ESR.config().setReportName("TestResults");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(ESR);
	extent.setSystemInfo("TesterName", "RajaTrainer");
	
	
	return extent;
	}

}
