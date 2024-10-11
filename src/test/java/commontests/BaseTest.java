package commontests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import alltests.ModifiedTest;
import objectsrepository.LoginPageObjects;

public class BaseTest {
	
	WebDriver driver;
	public LoginPageObjects L;
	
	public  WebDriver startTest() throws IOException
	{
		Properties P = new Properties();
		FileInputStream fis =new  FileInputStream("C://Users//leoga//eclipse-workspace//AutomationFramework//src//main//resources//resourcedocuments//GlobalData.properties");
		P.load(fis);
		String browserName = P.getProperty("browser");
		
		if (browserName.equals("chrome"))
		{
			 driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox"))
		{
			 driver = new FirefoxDriver();
		}
		else if (browserName.equals("edge"))
		{
			 driver = new EdgeDriver();
		}
		else
		{
			 driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	
		
		return driver;
		
	}
	
	@BeforeTest
	public void sampleTest()
	{
		System.out.println("This is starting of my Test Execution");
	}
	@BeforeMethod
	public LoginPageObjects launchTest() throws IOException
	{
		driver = startTest();
		 L = new LoginPageObjects(driver);
		L.launchurl("https://naveenautomationlabs.com/opencart/");
		return L;
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	@AfterTest
	public void sampleTestEnd()
	{
		System.out.println("This is ending of my Test Execution");
	}

}
