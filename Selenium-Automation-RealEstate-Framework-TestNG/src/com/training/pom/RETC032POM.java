package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC032POM {
	WebDriver driver;
	
	public RETC032POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='menu']//a[contains(text(),'New Launch')]")
	WebElement we_newlaunch;
	
	@FindBy(xpath="//ul[@id='responsive']//div[@class='wpmm-post post-667']//img[@class='attachment-wpmm_thumb size-wpmm_thumb wp-post-image']")
	WebElement we_image;
	
	@FindBy(xpath="//div[contains(@class,'col-md-12')]//button[contains(@type,'button')][contains(text(),'Next')]")
	WebElement we_arrow;
	
	@FindBy(xpath="//input[contains(@name,'your-name')]")
	WebElement we_enqname;
	
	@FindBy(xpath="//input[contains(@name,'your-email')]")
	WebElement we_enqemail;
	
	@FindBy(xpath="//input[contains(@name,'your-subject')]")
	WebElement we_enqsubject;
	
	@FindBy(xpath="//textarea[contains(@name,'your-message')]")
	WebElement we_enqmsg;
	
	@FindBy(xpath="//input[contains(@value,'Send')]")
	WebElement we_sendbtn;
	
	@FindBy(xpath="//input[@id='amount']")
	WebElement we_saleprice;
	
	@FindBy(xpath="//input[@id='downpayment']")
	WebElement we_downpayment;
	
	@FindBy(xpath="//input[@id='years']")
	WebElement we_loanterm;
	
	@FindBy(xpath="//input[@id='interest']")
	WebElement we_interest;
	
	@FindBy(xpath="//button[contains(@class,'button calc-button')]")
	WebElement we_calcbtn;
	
	public void mouseOver()
	{
		Actions act=new Actions(driver);
		act.moveToElement(we_newlaunch).perform();;
		
	}
	
	public void clickImg()
	{
		we_image.click();
	}
	
	public void clickArrow()
	{
		we_arrow.click();
	}
	
	public void sendEnquiryData(String enqname,String enqemail,String enqsubject,String enqmsg)
	{
		we_enqname.sendKeys(enqname);
		we_enqemail.sendKeys(enqemail);
		we_enqsubject.sendKeys(enqsubject);
		we_enqmsg.sendKeys(enqmsg);
		we_sendbtn.click();
	}
	
	public void sendMortgageData(String saleprice,String downpayment,String loanterm,String interest) throws InterruptedException
	{
		we_saleprice.sendKeys(saleprice);
		we_downpayment.sendKeys(downpayment);
		we_loanterm.sendKeys(loanterm);
		we_interest.sendKeys(interest);
		Thread.sleep(2000);
		we_calcbtn.click();
		Thread.sleep(2000);
	}
	
	

}
