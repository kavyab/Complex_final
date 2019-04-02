package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC001POM;
import com.training.pom.RETC002POM;
import com.training.pom.RETC031POM;
import com.training.pom.RETC034POM;
import com.training.pom.RETC035POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC034test {
	
	WebDriver driver;
	
	static Properties properties;
	ScreenShot screenshot;
	private String baseUrl,user,userspwd,searchtext,contactname,contactemail,contactsubject,contactmsg;
	RETC031POM retc031;
	RETC002POM retc002;
	RETC001POM retc001;
	RETC034POM retc034;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
	    retc031=new RETC031POM(driver);
	    retc001=new RETC001POM(driver);
	    retc002=new RETC002POM(driver);
	    retc034=new RETC034POM(driver);
		//getting parameters from properties file
	    baseUrl = properties.getProperty("baseURL");
	    user=properties.getProperty("User");
	    userspwd=properties.getProperty("Userspwd");
	    searchtext=properties.getProperty("Searchtext");
	    contactname=properties.getProperty("Contactname");
	    contactemail=properties.getProperty("Contactemail");
	    contactsubject=properties.getProperty("Contactsubject");
	    contactmsg=properties.getProperty("Contactmsg"); 
	    		
		screenshot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Clicking on login/register tab
		retc001.clickLoginTab();
		retc002.clickLoginTab();
		retc002.sendUsername(user);
		retc002.sendPassword(userspwd);
		retc002.clickSignIn();
		
		
	}

	@Test
	public void commercialPropertySearch() throws InterruptedException
	{
		String expectedtext="There was an error trying to send your message. Please try again later.";
		retc034.clickCommercial();
		//retc034.dropDownRegion();;
		//retc034.dropDownProp();
		//Thread.sleep(15000);
		//retc034.clickSearch();
		retc034.sendSearchText(searchtext);
		retc034.searchIcon();
		retc034.clickresProp();
		//System.out.println(driver.getTitle());
	    //Thread.sleep(1000);
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(tabs);
		driver.switchTo().window(tabs.get(0));
		
		//System.out.println(driver.getTitle());
		retc034.clickDrop();
		Thread.sleep(1000);
		retc034.sendContactDetails(contactname, contactemail, contactsubject, contactmsg);
		String actualtext=driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
		assertEquals(actualtext,expectedtext);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,106)");
		screenshot.captureScreenShot("RETC034");
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
