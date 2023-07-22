package opencart_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class openCart_LoginPage extends openCart_basePageObject {
	
	public openCart_LoginPage(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy(id ="input-email") WebElement email_txt;
	@FindBy(id="input-password") WebElement password_txt;
	@FindBy(xpath = "//button[text()='Login']") WebElement login_btn;
	
	public void setEmail(String email) {
		email_txt.clear();
		email_txt.sendKeys(email);
	}
	
	public void setPassword(String pasword) {
		password_txt.clear();
		password_txt.sendKeys(pasword);
	}
	
	public void clicklogin() {
		login_btn.click();
	}

}
