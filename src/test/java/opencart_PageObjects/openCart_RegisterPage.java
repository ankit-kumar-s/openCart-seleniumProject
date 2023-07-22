package opencart_PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class openCart_RegisterPage extends openCart_basePageObject {
	
	public openCart_RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "input-firstname") WebElement txt_firstName;
	@FindBy(id="input-lastname") WebElement txt_lastName;
	@FindBy(id="input-email") WebElement txt_email;
	@FindBy(id="input-password") WebElement txt_password;
	@FindBy(xpath="//input[@name='agree']") WebElement policy_chckbox;
	@FindBy(xpath = "//button[@type='submit']") WebElement continue_button;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setfirstname(String firstname) {
		txt_firstName.sendKeys(firstname);
	}
	
	public void setlstname(String lastname) {
		txt_lastName.sendKeys(lastname);
	}
	
	public void setemail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void setpassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void setpolicycheckbox() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",policy_chckbox);
	}
	
	public void setcontinuebutton() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", continue_button);
		js.executeScript("arguments[0].click();", continue_button);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	public String getconfirmatinmsg() {
		try {
		return msgConfirmation.getText();
		}catch (Exception e) {
			return e.getMessage();
		}
	}

}
