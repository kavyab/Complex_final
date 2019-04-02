      package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC005POM {
	WebDriver driver;
	
	public RETC005POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(xpath="//a[@href='http://realestate.upskills.in/change-password/']")
	WebElement we_changepassword;
	
	@FindBy(xpath="//input[@name='current_pass']")
	WebElement we_currentpassword;
	
	@FindBy(xpath="//input[@name='pass1']")
	WebElement we_newpassword;
	
	@FindBy(xpath="//input[@name='pass2']")
	WebElement we_confirmpassword;
	
	@FindBy(xpath="//input[@id='wp-submit']")
	WebElement we_savebtn;
	
	public void sendcurrentpassword(String currentpassword)
	{
		
		we_currentpassword.sendKeys(currentpassword);
	}
	
	public void sendnewpassword(String newpassword)
	{
		we_newpassword.sendKeys(newpassword);
	}
	
	public void sendconfirmpwd(String confirmpassword)
	{
		we_confirmpassword.sendKeys(confirmpassword);
	}
	
	public void onClickchangePassword()
	{
		we_changepassword.click();
	}
	
	public void onClickSave()
	{
		we_savebtn.click();
	}
	
}
