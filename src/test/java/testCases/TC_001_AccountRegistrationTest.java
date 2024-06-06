package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC_001_AccountRegistrationTest extends BaseClass {
	
		
	@Test(groups= {"regression", "master"})	
	public void verify_account_registration(){
		
	logger.info("*******staring TC_001_AccountRegistrationTest*********");		
	logger.debug("application logs started....");
	
	try
	{
    HomePage hp = new HomePage(driver);
    logger.info("Click on MyAccount link...");
    hp.clickMyAccount();
    logger.info("Click on Register link...");
    hp.clickRegister();
    
    logger.info("Entering Customer details...");
    AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
    regpage.setFirstName(randomeString().toUpperCase());
    regpage.setLastName(randomeString().toUpperCase());
    regpage.setEmail(randomeString()+"@gmail.com"); //randomly generated the email
    regpage.setTelephone(randomNumber());
    
    
    String password = randomAlphaNumeric();
    
    regpage.setPassword(password);
    regpage.setConfirmPassword(password);    
    
    regpage.clickOnPrivacyPolicy();
    regpage.clickOnContinueButton();
    logger.info("Click on Continue...");
    
    String confMsg = regpage.getConfirmationMsg();
    
    logger.info("Validating Expected message..");
    if(confMsg.equals("Your Account Has Been Created!"))
    {
    	logger.info("test passed...");
    	Assert.assertTrue(true);
    } else {
    	logger.error("test failed...");
    	Assert.fail();
    }
    
  }
	catch(Exception e)
	{
		logger.error("test failed...");
		Assert.fail();
	}
	logger.debug("application logs end....");
    logger.info("*******finished TC_001_AccountRegistrationTest*********");	
	}
	
	
}
