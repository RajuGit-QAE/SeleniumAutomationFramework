package objectsrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPageObjects {
	
	WebDriver driver;
	
	public CheckoutPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(xpath = "//input[@value='ne']")
	WebElement newradiobutton;
    
	@FindBy(id = "input-payment-firstname")
	WebElement firstnamefield;

	@FindBy(id = "input-payment-lastname")
	WebElement lastnamefield;
	
	@FindBy(id = "input-payment-address-1")
	WebElement addressfield;
	
	@FindBy(id = "input-payment-city")
	WebElement cityfield;
	
	@FindBy(id = "input-payment-postcode")
	WebElement postcodefield;
	
	@FindBy(id = "button-payment-address")
	WebElement continuebutton;
	
	@FindBy(name = "agree")
	WebElement checkbox;
	
	
	//action methods
	public void checkfields(String firstname, String lastname, String address, String city, String pin ) throws InterruptedException
	{
		newradiobutton.click();
		firstnamefield.sendKeys(firstname);
		lastnamefield.sendKeys(lastname);
		addressfield.sendKeys(address);
		cityfield.sendKeys(city);
		postcodefield.sendKeys(pin);
		Thread.sleep(5000);
	
		
	}
	
	public void dropdowns() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.name("country_id"));
		Select S = new Select(dropdown);
		S.selectByValue("2");
		Thread.sleep(5000);
		
		
		WebElement dropdown1 = driver.findElement(By.name("zone_id"));
		Select S1 = new Select(dropdown1);
		S1.selectByVisibleText("Korce");
		Thread.sleep(5000);
	}
	
	public void finalbuttons() throws InterruptedException
	{
		continuebutton.click();
		Thread.sleep(5000);
		checkbox.click();
		Thread.sleep(5000);
	}
}
