package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC034POM {
	
	WebDriver driver;
	
	public RETC034POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='menu']//a[contains(text(),'Commercial')]")
	WebElement we_commenu;
	
	@FindBy(xpath="//div[@class='chosen-container chosen-container-single']//a[@class='chosen-single chosen-default']")
	WebElement we_region;
	
	/*@FindBy(xpath=" //span[contains(text(),'Commercial')]")
	WebElement we_proptext;
	
	@FindBy(xpath="//div[@class='chosen-container chosen-container-single chosen-container-active chosen-with-drop']//span[contains(text(),'Commercial')] ")
	WebElement we_regtext;*/
	
	//@FindBy(xpath="//div[@id='_property_type_chosen']//a[@class='chosen-single chosen-default']")
	@FindBy(xpath ="//div[@id='_property_type_chosen']//a[@class='chosen-single chosen-default']")
	WebElement we_property;
	
	@FindBy(id="_property_type")
	WebElement we_property_new;
	
	
	
	
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	WebElement we_searchbtn;
	
	@FindBy(xpath="//div[@id='ajaxsearchlite2']//input[@placeholder='Search here for Properties..'] ")
	WebElement we_searchtxt;
	
	@FindBy(xpath="//div[@id='ajaxsearchlite2']//div[@class='promagnifier']//*[@version='1.1'] ")
	WebElement we_searchicon;
	
	@FindBy(xpath="//span[@class='overlap']")
	WebElement we_reqdelement;
	
	@FindBy(xpath="//a[@class='button fullwidth margin-top-20']")
	WebElement we_dropus;
	
	@FindBy(xpath="//input[@placeholder='Your Name']")
	WebElement we_contactname;
	
	@FindBy(xpath="//input[@placeholder='Email Address']")
	WebElement we_contactemail;
	
	@FindBy(xpath="//input[@placeholder='Subject']")
	WebElement we_contactsubject;
	
	@FindBy(xpath="//textarea[@placeholder='Message']")
	WebElement we_contactmsg;
	
	@FindBy(xpath="//input[@value='Send']")
	WebElement we_contactsend;
	
	public void clickCommercial()
	{
		we_commenu.click();
	}
	
	/*public void dropDownRegion()
	{
		we_region.click();
		
	Select region=new Select(driver.findElement(By.xpath("//ul[@class='chosen-results']//li")));
	List<WebElement> we_regions_list = region.getOptions();
    for(WebElement we:we_regions_list) {
        System.out.println(we.getAttribute("value")+":"+we.getText());
    }
    
    
		region.selectByVisibleText("Commercial");
	}
		
		/*WebElement we1= driver.findElement(By.id("_property_type_chosen"));
		
		
        we1.click();
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='chosen-results']//li"));
        for(WebElement ele : list)
        
        {
        	System.out.println(ele.getAttribute("innerHTML"));
        }
        
        Actions actions = new Actions(driver);
        actions.moveToElement(we1);
        actions.click();
        actions.sendKeys("Commercial");
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
	}*/
	
	/*public void dropDownProp()
	{
		we_property.click();
		we_proptext.click();
		
	}
		//Select prop=new Select(we_property_new);
		//prop.selectByVisibleText("Apartments");
		/*WebElement we= driver.findElement(By.id("_property_type_chosen"));
		
		
		
        we.click();
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='chosen-results']//li"));
        for(WebElement ele : list)
        
        {
        	System.out.println(ele.getAttribute("innerHTML"));
        	if(ele.getAttribute("innerHTML").contains("Apartments")) {
        		ele.click();
        		break;
        	}
        }
		
	

        Actions actions = new Actions(driver);
        actions.moveToElement(we);
        actions.click();
        actions.sendKeys("Apartments");
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
		
	}*/
	
	public void clickSearch()
	{
		we_searchbtn.click();
	}
	
	public void sendSearchText(String searchtext)
	{
		we_searchtxt.sendKeys(searchtext);
	}
	
	public void searchIcon()
	{
		we_searchicon.click();
		
	}
	
	public void clickresProp()
	{
		we_reqdelement.click();
	}
	
	public void clickDrop()
	{
		we_dropus.click();
	}
	
	public void sendContactDetails(String contactname,String contactemail,String contactsubject,String contactmsg)
	{
		we_contactname.sendKeys(contactname);
		we_contactemail.sendKeys(contactemail);
		we_contactsubject.sendKeys(contactsubject);
		we_contactmsg.sendKeys(contactmsg);
		we_contactsend.click();
		
	}
	
	
	
	
			
	

}
