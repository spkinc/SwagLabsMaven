package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver pageDriver;
	
	@FindBy(id="user-name")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(name="login-button")
	private WebElement loginBtn;
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement products;
	
	@FindBy(xpath="//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]")
	private WebElement msgError;
	
	public LoginPage(WebDriver driver) {
		pageDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LoginFunction(String UserNameVal, String PwdVal) throws InterruptedException {

		userName.sendKeys(UserNameVal);
		password.sendKeys(PwdVal);
		loginBtn.click();

	}
	
	public String readErrorMsg() {
		return msgError.getText();
	}
	
	public String getTitle() {
		return products.getText();
	}
}
