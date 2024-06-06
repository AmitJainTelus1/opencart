package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(linkText = "Login")   // Login link added in step5
	WebElement linkLogin;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
	WebElement txtSearchbox;

	@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
	WebElement btnSearch;
	
	
	public void clickMyAccount() { 
		lnkMyAccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();		
	}
	
	public void clickLogin() {
		linkLogin.click();		
	}
	
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}

	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}
	
}
