package opencart_TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart_PageObjects.openCaart_MyLoginAccoutPage;
import opencart_PageObjects.openCart_LoginPage;
import opencart_PageObjects.opencart_HomePage;

public class TC_01_opencart_logintest extends openCart_BaseTest{
	
	@Test(groups= {"sanity"})
	public void logintest() {
		try {
		
		logger.info("**Startng loginPage Test ***");
		opencart_HomePage ochp = new opencart_HomePage(driver);
		ochp.clickMyAccount();
		logger.info("Clicked login option ");
		ochp.clickLogin();
		
		logger.info("**Navigated to Login Page screen ***");
		openCart_LoginPage oclp = new openCart_LoginPage(driver);
		
		logger.info("Set Email");
		oclp.setEmail(rb.getString("email"));
		logger.info("Set password ");
		oclp.setPassword(rb.getString("password"));
		logger.info("Clicked login button");
		oclp.clicklogin();
		
		logger.info("**Navigated to MyLoginAccount Page screen ***");
		openCaart_MyLoginAccoutPage ocap = new openCaart_MyLoginAccoutPage(driver);
		boolean img =ocap.imgpresent();
		logger.info("** MyLoginAccount Page screen ***");
		Assert.assertEquals(img, true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
	}

}
