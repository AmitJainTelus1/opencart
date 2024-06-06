package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"sanity", "master"})
	public void verify_login()
	{
		logger.info("**** staring TC_002_LoginTest *****");
		logger.debug("capturing application debug logs...");
		
		try
		{
		// Home Page - 
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account link");
		hp.clickLogin();;
		logger.info("Clicked on Login link in MyAccount");
		
		// Login Page -
        LoginPage lp = new LoginPage(driver);
        logger.info("Entered Valid email and password");
        lp.setEmail(p.getProperty("email"));
        lp.setPassword(p.getProperty("password"));
        lp.clickLogin(); // login button 
        logger.info("Clicked on login button");
        
        // My Account Page - 
        MyAccountPage mac = new MyAccountPage(driver);
        boolean tgtPage = mac.isMyAccountPageExists();
        
        Assert.assertEquals(tgtPage, true,"Login failed");
        
		/*
		 * if(tgtPage==true) { logger.info("Login test passed....");
		 * Assert.assertTrue(true); } else { logger.error("Login test failed....");
		 * Assert.fail(); }
		 */
		}
		catch(Exception e)
		{
			// Assert.fail();
			Assert.fail("An exception occurred: " + e.getMessage());
		}
        
        logger.info("**** Finished TC_002_LoginTest *****");
	}

}
