package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC002POM {

	WebDriver driver;

	public RETC002POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='#tab1']")
	WebElement we_logintab;

	@FindBy(xpath="//input[@id='user_login']")
	WebElement we_uname;

	@FindBy(xpath="//input[@id='user_pass']")
	WebElement we_pwd;

	@FindBy(xpath="//input[@value='Sign In']")
	WebElement we_signin;

	public void sendUsername(String uname)
	{
		this.we_uname.clear();
		this.we_uname.sendKeys(uname);
	}

	public void sendPassword(String pwd)
	{
		this.we_pwd.clear();
		this.we_pwd.sendKeys(pwd);
	}

    public void clickLoginTab()
    {
    	this.we_logintab.click();
     }
    
    public void clickSignIn()
    {
    	this.we_signin.click();

}



}
