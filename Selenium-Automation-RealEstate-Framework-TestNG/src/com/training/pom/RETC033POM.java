package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC033POM {
	WebDriver driver;
	
	public RETC033POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//div[contains(text(),'Properties')]")
	WebElement we_propertiestab;
	
	@FindBy(xpath="//a[@href='post-new.php?post_type=property']")
	WebElement we_addnew;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement we_title;
	
	@FindBy(xpath="//textarea[@id='content']")
	WebElement we_textarea;
	
	@FindBy(xpath="//input[@id='publish']")
	WebElement we_publish;
	
	@FindBy(xpath="//div[@id='adminmenuwrap']//a[contains(text(),'All Properties')]")
	WebElement we_allprop;
	
	@FindBy(xpath="//iframe[@id='content_ifr']")
	WebElement we_textarea_iframe;
	
	public void clickProp()
	{
		we_propertiestab.click();
	}
	
	public void clickAdd()
	{
		we_addnew.click();
	}
	
	public void sendpropData(String title,String text)
	{
		we_title.sendKeys(title);
		driver.switchTo().frame(we_textarea_iframe);
		WebElement editor_body = driver.findElement(By.tagName("body"));
		editor_body.sendKeys(text);
		driver.switchTo().defaultContent();
		
		
	}
	
	public void clickPublish() throws InterruptedException
	{
		Thread.sleep(4000);
		we_publish.click();	
	}
	
	public void clickAllProp()
	{
		we_allprop.click();
	}
	
	
}
