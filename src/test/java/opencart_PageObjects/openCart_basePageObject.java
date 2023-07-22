package opencart_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class openCart_basePageObject {
	
	public WebDriver driver;
	public openCart_basePageObject(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		}

}
