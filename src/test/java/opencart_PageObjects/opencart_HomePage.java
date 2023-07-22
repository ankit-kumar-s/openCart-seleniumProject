package opencart_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class opencart_HomePage extends openCart_basePageObject {
	
	public opencart_HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']") WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Register']") WebElement register;
	
	@FindBy(xpath="//li/a[text()='Login']") WebElement login;
	
	
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public void clickLogin() {
		login.click();
	}
	
	
}
