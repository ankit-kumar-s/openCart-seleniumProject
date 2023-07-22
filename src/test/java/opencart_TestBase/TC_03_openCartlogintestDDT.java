package opencart_TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import openCart_Utilities.openCart_DataProvide;
import opencart_PageObjects.openCaart_MyLoginAccoutPage;
import opencart_PageObjects.openCart_LoginPage;
import opencart_PageObjects.opencart_HomePage;

public class TC_03_openCartlogintestDDT extends openCart_BaseTest{
	
	@Test(dataProvider = "LoginData", dataProviderClass = openCart_DataProvide.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info(" Starting TC_003_LoginDataDrivenTest ");

		try {
			opencart_HomePage hp = new opencart_HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			logger.info(" hp is done ");
			openCart_LoginPage lp = new openCart_LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clicklogin();
			logger.info(" lp is done ");
			openCaart_MyLoginAccoutPage macc=new openCaart_MyLoginAccoutPage(driver);
			boolean targetpage = macc.imgpresent();// this method is created MyAccountPage

			if (exp.equals("Valid")) {
				if (targetpage == true) {
					logger.info(" clicked logout from valid block ");
					macc.logoutclick();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetpage == true) {
					macc.logoutclick();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_003_LoginDataDrivenTest");

	}

}
