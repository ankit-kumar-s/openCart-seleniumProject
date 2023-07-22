package opencart_TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart_PageObjects.openCart_RegisterPage;
import opencart_PageObjects.opencart_HomePage;

public class TC_01_OpenCart extends openCart_BaseTest {
	
	
	@Test(groups= {"regression"})
	public void test_account_Registration() {
		logger.info(".....TC_01_OpenCar Started...");
		opencart_HomePage ochp = new opencart_HomePage(driver);
		logger.info("Passed MyAcount");
		ochp.clickMyAccount();
		logger.info("Passed Registration");
         ochp.clickRegister();
         
     logger.info("RegisterPage");
        openCart_RegisterPage ocrp = new openCart_RegisterPage(driver);
		ocrp.setfirstname("ankit");
		ocrp.setlstname("singh");
		ocrp.setemail(randomaplha()+"@gmail.com");
		ocrp.setpassword("ankitsingh");
		ocrp.setpolicycheckbox();
		ocrp.setcontinuebutton();
		
		logger.info("Clicked on continue sucesfully");

		String exp = ocrp.getconfirmatinmsg();
		Assert.assertEquals(exp, "Your Account Has Been Created!");
		
		
		
	}

}
