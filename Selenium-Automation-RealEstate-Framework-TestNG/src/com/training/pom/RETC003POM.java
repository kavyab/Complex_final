package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC003POM {

	WebDriver driver;
	
	public RETC003POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Lost Your Password?')]")
	WebElement we_lostpwd;
	
	@FindBy(xpath="//input[@id='user_login']")
	WebElement we_email;
	
	@FindBy(xpath="//input[@value='Reset Password']")
	WebElement we_resetbtn;
	
	public void clicklostpwd()
	{
		we_lostpwd.click();
	}
	
	public void sendemail(String email )
	{
		we_email.sendKeys(email);
	}
	
	public void clickReset()
	{
		we_resetbtn.click();
	}
}


