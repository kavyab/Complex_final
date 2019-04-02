package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC001POM;
import com.training.pom.RETC002POM;
import com.training.pom.RETC031POM;
import com.training.pom.RETC032POM;
import com.training.pom.RETC035POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC032test {
	
	WebDriver driver;
	private static Properties properties;
	private ScreenShot screenshot;
	private String baseUrl,user,userspwd,enqname,enqemail,enqsubject,enqmsg,saleprice,downpayment,loanterm,interest;
	RETC031POM retc031;
	RETC002POM retc002;
	RETC001POM retc001;
	RETC032POM retc032;
	
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
	    retc032=new RETC032POM(driver);
		//getting parameters from properties file
	    baseUrl = properties.getProperty("baseURL");
	    user=properties.getProperty("User");
	    userspwd=properties.getProperty("Userspwd");
	    enqname=properties.getProperty("Enqname");
	    enqemail=properties.getProperty("Enqemail");
	    enqsubject=properties.getProperty("Enqsubject");
	    enqmsg=properties.getProperty("Enqmsg");
	    saleprice=properties.getProperty("Saleprice");
	    downpayment=properties.getProperty("Downpayment");
	    loanterm=properties.getProperty("Loanterm");
	    interest=properties.getProperty("Interest");
	    
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
	public void customerEnquiry() throws InterruptedException
	{
		String expected="Monthly Payment: 1667.11 Rs.";
		retc032.mouseOver();
		retc032.clickImg();
		retc032.clickArrow();
		retc032.sendEnquiryData(enqname, enqemail, enqsubject, enqmsg);
		retc032.sendMortgageData(saleprice, downpayment, loanterm, interest);
		String actual1="Monthly Payment: ";
		String actual2=driver.findElement(By.xpath("//strong[@class='calc-output']")).getText();
		String actual=actual1+actual2;
		System.out.println(actual2);
		assertEquals(actual,expected);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		screenshot.captureScreenShot("RETC032");
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	

}
