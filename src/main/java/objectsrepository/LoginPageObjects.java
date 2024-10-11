package objectsrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	WebDriver driver;
	
	public LoginPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myaccountlink;
	

	@FindBy(linkText = "Login")
	WebElement loginlink;
	
	@FindBy(id = "input-email")
	WebElement usernamefield;
	
	@FindBy(id = "input-password")
	WebElement passwordfield;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//img[@title='naveenopencart']")
	WebElement homebutton;

   // action methods
	public void launchurl(String url)
	{
		driver.get(url);
	}
	
	public void login(String username, String password)
	{
		myaccountlink.click();
		loginlink.click();
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		loginbutton.click();
	}
	public ProductAddingPageObjects gohome()
	{
		homebutton.click();
		ProductAddingPageObjects P = new ProductAddingPageObjects(driver);
		return P;
	}
	

}
