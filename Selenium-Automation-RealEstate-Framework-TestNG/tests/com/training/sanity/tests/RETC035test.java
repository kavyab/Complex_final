package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC001POM;
import com.training.pom.RETC002POM;
import com.training.pom.RETC031POM;
import com.training.pom.RETC033POM;
import com.training.pom.RETC035POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC035test {
	WebDriver driver;
	String filename="RETC035";
	
	private static Properties properties;
	private ScreenShot screenshot;
	private String baseUrl,username,pwd,title,text,price,pricesq,address,googleaddress,latitude,longitude,status,location,possession,storage,loginname, email, fname, lname, website, userpwd;
	RETC031POM retc031;
	RETC002POM retc002;
	RETC001POM retc001;
	RETC035POM retc035;
	
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
	    retc035=new RETC035POM(driver);
		//getting parameters from properties file
	    baseUrl = properties.getProperty("baseURL");
	    username=properties.getProperty("Username");
	    pwd=properties.getProperty("Pwd");
		title=properties.getProperty("Title");
		text=properties.getProperty("Text");
		loginname=properties.getProperty("Loginname");
		email=properties.getProperty("Email");
		fname=properties.getProperty("Fname");
		lname=properties.getProperty("Lname");
		website=properties.getProperty("Website");
		userpwd=properties.getProperty("Userpwd");
		
		
		
		screenshot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Clicking on login/register tab
		retc001.clickLoginTab();
		retc002.clickLoginTab();
		retc002.sendUsername(username);
		retc002.sendPassword(pwd);
		retc002.clickSignIn();
		
		
	}
	
	@Test
	public void viewAddedUsers()
	{
		String expectedtext="KavyaImaya4";
		retc035.clickUsers();
		retc035.clickAddUser();
		retc035.sendUserData(loginname, email, fname, lname, website, userpwd);
		retc035.selectDropdown();
		retc035.clickAddBtn();
		retc035.clickAllUsers();
		retc035.addedUservalidation(loginname);
		String actualtext=driver.findElement(By.linkText(loginname)).getText();
		System.out.println(actualtext);
		assertEquals(actualtext, expectedtext);
		screenshot.captureScreenShot(filename);
		
		
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	

}
