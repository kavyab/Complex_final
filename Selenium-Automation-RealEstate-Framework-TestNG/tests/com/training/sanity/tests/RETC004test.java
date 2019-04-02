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
import com.training.pom.RETC005POM;
import com.training.pom.RETC004POM;
import com.training.pom.RETC001POM;
import com.training.pom.RETC002POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC004test {
	
	private WebDriver driver;
	private String baseUrl,email,uname,pwd,fname,lname,agenttitle,ph;
	RETC001POM loginobj;
	RETC002POM userloginobj;
	RETC004POM myprofobj;
	private static Properties properties;
	private ScreenShot screenShot;
	
	String fileName="RETC004";

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginobj = new RETC001POM(driver);
		userloginobj =new RETC002POM(driver);
		myprofobj=new RETC004POM(driver);
		//getting the parameters from properties file
		baseUrl = properties.getProperty("baseURL");
		email=properties.getProperty("Email");
		uname=properties.getProperty("Uname");
		pwd=properties.getProperty("Pwd");
		fname=properties.getProperty("Fname");
		lname=properties.getProperty("Lname");
		agenttitle=properties.getProperty("Agenttitle");
		ph=properties.getProperty("Ph");
		
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //Clicking on login/register tab
		loginobj.clickLoginTab();
		//Clicking on login button
		userloginobj.clickLoginTab();
		//entering username
		userloginobj.sendUsername(uname);
		//entering password
		userloginobj.sendPassword(pwd);
		//clicking on sign in  Button
		userloginobj.clickSignIn();
		Thread.sleep(1000);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void updateProfile() throws InterruptedException
	{
		String expectedtext="Your profile has been updated.";
		//entering agent title
		myprofobj.sendAgentTitle(agenttitle);
		Thread.sleep(1000);
		//entering phone number
		myprofobj.sendPhoneNumber(ph);
		Thread.sleep(1000);
		//clicking on save button
		myprofobj.onClickSave();
		//capturing screenshot
		screenShot.captureScreenShot(fileName);
		//validating the message after update is done
	    String actualtext=driver.findElement(By.xpath("//p[contains(text(),'Your profile has been updated.')]")).getText();
	   	assertEquals(actualtext, expectedtext);
	}

}
