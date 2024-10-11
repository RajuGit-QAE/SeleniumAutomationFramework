package alltests;

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

public class EndToEndTest {
	
	@Test
	public void shoppingTest() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String extecteditem = "MacBook";
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("input-email")).sendKeys("leoganapathy5691@gmail.com");
		
		driver.findElement(By.id("input-password")).sendKeys("9629850709");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.findElement(By.xpath("//img[@title='naveenopencart']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.name("search")).sendKeys("MacBook");
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	
		
		List <WebElement> productlist = driver.findElements(By.xpath("//div[@class='caption']/h4/a"));// 3 products
		
		for (int a = 0; a<productlist.size(); a ++)// 0 1 2
		{
			if (productlist.get(a).getText().equals(extecteditem))
			{
				driver.findElements(By.xpath("//span[contains(text(),'Add to Cart')]")).get(a).click();
			}
		}
		Thread.sleep(5000);
		WebDriverWait W = new WebDriverWait(driver, Duration.ofSeconds(10));
		W.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//button[@type='button'])[5]")));
		
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		
		driver.findElement(By.xpath("//strong[normalize-space()='Checkout']")).click();
		
		driver.findElement(By.xpath("//input[@value='new']")).click();
		
		
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Raja");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("trainer");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("1st main, abc streeet");
		driver.findElement(By.id("input-payment-city")).sendKeys("whitefireld");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("560066");
		
		
		WebElement dropdown = driver.findElement(By.name("country_id"));
		Select S = new Select(dropdown);
		S.selectByValue("2");
		Thread.sleep(5000);
		
		WebElement dropdown1 = driver.findElement(By.name("zone_id"));
		Select S1 = new Select(dropdown1);
		S1.selectByVisibleText("Korce");
		
		Thread.sleep(5000);
		driver.findElement(By.id("button-payment-address")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("agree")).click();
		
		Thread.sleep(5000);
		driver.close();
		
		
		
	}

}
