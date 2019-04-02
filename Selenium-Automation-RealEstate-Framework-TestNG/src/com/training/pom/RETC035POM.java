package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC035POM {
	
	WebDriver driver;
	
	public RETC035POM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Users')]")
	WebElement we_users;
	
	@FindBy(xpath="//a[@href='user-new.php']")
	WebElement we_addnew;
	
	@FindBy(xpath="//input[@id='user_login']")
	WebElement we_username;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement we_email;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement we_fname;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement we_lname;
	
	@FindBy(xpath="//input[@name='url']")
	WebElement we_website;
	
	@FindBy(xpath="//button[contains(text(),'Show password')]")
	WebElement we_showpwd;
	
	@FindBy(xpath="//input[@id='pass1-text']")
	WebElement we_userpwd;
	
	@FindBy(xpath="//select[@id='role']")
	WebElement we_rolemenu;
	
	@FindBy(xpath="//form//p//input[@type='submit']")
	WebElement we_adduser;
	
	@FindBy(xpath="//a[contains(text(),'All Users')]")
	WebElement we_allusers;
	
	@FindBy(xpath="//input[@name='pw_weak']")
	WebElement we_chbx;
	
	@FindBy(xpath="//p//input[@id='user-search-input']")
	WebElement we_asserttext;
	
	@FindBy(xpath="//input[@id='search-submit']")
	WebElement we_assertsearch;
	
	
	
	public void clickUsers()
	{
		we_users.click();
	}
	
	public void clickAddUser()
	{
		we_addnew.click();
	}
	
	public void selectDropdown()
	{
		Select we_select=new Select(we_rolemenu);
		we_select.selectByIndex(2);
	}
	
	public void sendUserData(String loginname,String email,String fname,String lname,String website,String userpwd)
	{
		we_username.sendKeys(loginname);
		we_email.sendKeys(email);
		we_fname.sendKeys(fname);
		we_lname.sendKeys(lname);
		we_website.sendKeys(website);
		we_showpwd.click();
		we_userpwd.clear();
		we_userpwd.sendKeys(userpwd);
		we_chbx.click();
		
	}
		
		
	
	
	
	public void clickAddBtn()
	{
		we_adduser.click();
	}
	
	public void clickAllUsers()
	{
		we_allusers.click();
		
	}
	
	public void addedUservalidation(String loginname)
	{
		we_asserttext.sendKeys(loginname);
		we_assertsearch.click();
	}
	
	
	

}
