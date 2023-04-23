package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	private WebDriver pageDriver;
	
	
	public ProductsPage(WebDriver driver) {
		pageDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
