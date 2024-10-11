package alltests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import commontests.BaseTest;
import objectsrepository.CheckoutPageObjects;
import objectsrepository.LoginPageObjects;
import objectsrepository.ProductAddingPageObjects;

public class ModifiedTest extends BaseTest{

	@Test
	public void loginTest() throws IOException
	{
		String extecteditem = "MacBook";
		//login page part
		
		//L.launchurl("https://naveenautomationlabs.com/opencart/");
		L.login("leoganapathy5691@gmail.com", "9629850709");
		L.gohome();
	
	}
	
	@Test
	public void shoppingTest() throws InterruptedException, IOException
	{
		String extecteditem = "MacBook";
		//login page part
		
		//L.launchurl("https://naveenautomationlabs.com/opencart/");
		L.login("leoganapathy5691@gmail.com", "9629850709");
		ProductAddingPageObjects P= L.gohome();
		
		//product adding page 
		P.productsearch("MacBook");
		P.productSelection(extecteditem);
		CheckoutPageObjects C = P.continueandproceed();
		
	
		//Checkout Page
		C.checkfields("Raja", "trainer", "1st main, abc streeet", "whitefield", "560066");
		C.dropdowns();
		C.finalbuttons();
		
		
	}

	
	

}
