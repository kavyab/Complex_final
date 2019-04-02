package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC064POM {
	
	WebDriver driver;
	
	
	public RETC064POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@href='http://realestate.upskills.in/region/apartments-in-bangalore/']")
	WebElement we_apartment;
	
	@FindBy(xpath="//div[@class='fs-content']//div[4]//div[1]//a[1]")
	WebElement we_donec;
	
	@FindBy(xpath="//input[@name='your-name']")
	WebElement we_name;
	
	@FindBy(xpath="//input[@name='your-email']")
	WebElement we_email;
	
	@FindBy(xpath="//input[@name='your-subject']")
	WebElement we_subject;
	
	@FindBy(xpath="//textarea[@name='your-message']")
	WebElement we_mesg;
	
	@FindBy(xpath="//ul[@class='menu']//a[@class='sign-in']")
	private WebElement we_login; 
	
	
	@FindBy(xpath="//input[@value='Send']")
	WebElement we_send;
	
	@FindBy(xpath="//input[@id='user_login']")
	WebElement we_uname;

	@FindBy(xpath="//input[@id='user_pass']")
	WebElement we_pwd;

	@FindBy(xpath="//input[@value='Sign In']")
	WebElement we_signin;

	public void sendUsername(String uname)
	{
		we_uname.clear();
		we_uname.sendKeys(uname);
	}

	public void sendPassword(String pwd)
	{
		this.we_pwd.clear();
		this.we_pwd.sendKeys(pwd);
	}

    public void clickLoginTab()
    {
    	this.we_login.click();
     }
    
    public void clickSignIn()
    {
    	this.we_signin.click();

}
	
	public void clickApartment()
	{
		we_apartment.click();
	}
	
	public void clickDonec()
	{
		we_donec.click();
	}
	
	
	public void sendEnquiry(String name,String subject,String msg,String email)
	{
		we_name.sendKeys(name);
		we_email.sendKeys(email);
		we_subject.sendKeys(subject);
		we_mesg.sendKeys(msg);
		we_send.click();
		
	}

	
	}


