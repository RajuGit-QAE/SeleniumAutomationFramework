package objectsrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductAddingPageObjects {
	
	WebDriver driver;
	
	public ProductAddingPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "search")
	WebElement Searchbar;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement Searchutton;
	
	
	@FindBy(xpath = "//div[@class='caption']/h4/a")
	List <WebElement> productlist;
	
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	List <WebElement> buttonlist;
	
	@FindBy(xpath = "(//button[@type='button'])[5]")
	WebElement nextbutton;
	
	@FindBy(xpath = "//strong[normalize-space()='Checkout']")
	WebElement checkoutbutton;
	

	public void productsearch(String myproduct)
	{
		Searchbar.sendKeys(myproduct);
		Searchutton.click();
		
	}
	
	public void productSelection(String expectedproduct) throws InterruptedException {
		for (int a = 0; a<productlist.size(); a ++)// 0 1 2
		{
			if (productlist.get(a).getText().equals(expectedproduct))
			{
				buttonlist.get(a).click();
				Thread.sleep(5000);
			}
		}
	}
	
	public CheckoutPageObjects continueandproceed()
	{
		nextbutton.click();
		checkoutbutton.click();
		CheckoutPageObjects C = new CheckoutPageObjects(driver);
		return C;
		
		
	}
	
	
	

}
