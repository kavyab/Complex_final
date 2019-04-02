package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RETC031POM {
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public RETC031POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	WebElement we_propertiestab;
	
	@FindBy(xpath="//a[@href='post-new.php?post_type=property']")
	WebElement we_addnew;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement we_title;
	
	@FindBy(xpath="//textarea[@id='content']")
	WebElement we_textarea;
	
	@FindBy(xpath="//iframe[@id='content_ifr']")
	WebElement we_textarea_iframe;
	
	
	@FindBy(xpath="//textarea[@id='_price']")
	WebElement we_pricetext;
	
	@FindBy(xpath="//input[@id='_price_per']")
	WebElement we_pricepersq;
	
	@FindBy(xpath="//a[@id='ui-id-2']")
	WebElement we_maindetailtab;
	
	@FindBy(xpath="//input[@id='_status']")
	WebElement we_status;
	
	@FindBy(xpath="//input[@id='_location']")
	WebElement we_locationtext;
	
	@FindBy(xpath="//input[@id='_possession']")
	WebElement we_possession;
	
	@FindBy(xpath="//a[@id='ui-id-3']")
	WebElement we_loctab;
	
	@FindBy(xpath="//input[@id='_friendly_address']")
	WebElement we_address;
	
	@FindBy(xpath="//input[@id='_address']")
	WebElement we_googleadd;
	
	@FindBy(xpath="//input[@id='_geolocation_lat']")
	WebElement we_latitude;
	
	@FindBy(xpath="//input[@id='_geolocation_long']")
	WebElement we_longitude;
	
	@FindBy(xpath="//a[@id='ui-id-4']")
	WebElement we_detailtab;
	
	@FindBy(xpath="//input[@id='_storage_room']")
	WebElement we_storage;
	
	@FindBy(xpath="//input[@id='in-region-24']")
	WebElement chbx_CenBang;
	
	@FindBy(xpath="//input[@id='publish']")
	WebElement we_publish;
	
	@FindBy(xpath=" //input[@id='save-post']")
	WebElement we_draft;
	
	
	
	public void clickProp()
	{
		we_propertiestab.click();
	}
	
	public void clickAdd()
	{
		we_addnew.click();
	}
	
	public void sendData(String title,String text,String price,String pricesq)
	{
		we_title.sendKeys(title);
		
		driver.switchTo().frame(we_textarea_iframe);
		WebElement editor_body = driver.findElement(By.tagName("body"));
		editor_body.sendKeys(text);
		driver.switchTo().defaultContent();
		
		
		//we_textarea.sendKeys(text);
		we_pricetext.sendKeys(price);
		we_pricepersq.sendKeys(pricesq);
	}
	
	public void clickmaindetail()
	{
		we_maindetailtab.click();
	}
	
	public void sendMainData(String status,String location,String possession)
	{
		we_status.sendKeys(status);
		we_locationtext.sendKeys(location);
		we_possession.sendKeys(possession);
		
	}
	
	public void clickLocation()
	{
		we_loctab.click();
	}
	
	public void sendlocaddress(String address,String googleaddress,String latitude,String longitude)
	{
		we_address.sendKeys(address);
		we_googleadd.sendKeys(googleaddress);
		we_latitude.sendKeys(latitude);
		we_longitude.sendKeys(longitude);
	}
	
	public void clickDetails()
	{
		we_detailtab.click();
	}
	
	public void sendStorage(String storage)
	{
		we_storage.sendKeys(storage);
	}
	
	public void clickCenBang() throws InterruptedException
	{
		chbx_CenBang.click();
		
	}
	
	public void clickPublish() throws InterruptedException
	{
		//js.executeScript("window.scrollTo(0,"+ we_publish.getLocation().y+")");
		
		//System.out.println(we_publish.getLocation().y);
		//WebDriverWait wait=new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.elementToBeClickable(we_publish));
		
		
		we_publish.click();
		 
		
		
	}
	
	
}
