package opencart_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class openCaart_MyLoginAccoutPage extends openCart_basePageObject{
	
	public openCaart_MyLoginAccoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div/h2[1]") WebElement myaaocutimg;
	@FindBy(xpath="//a[starts-with(@class,'list-group') and text()='Logout']") WebElement logout;
	
	public boolean imgpresent() {
		
		try {
		return myaaocutimg.isDisplayed();
		}catch(Exception e) {
			return (false);
		}
	}
	
	public void logoutclick() {
		logout.click();
	}

}
