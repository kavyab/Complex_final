package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC005POM;
import com.training.pom.RETC004POM;
import com.training.pom.RETC001POM;
import com.training.pom.RETC002POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC001test {

	private WebDriver driver;
	private String baseUrl,email,uname,pwd,fname,lname;
	RETC001POM loginobj;	
	private static Properties properties;
	private ScreenShot screenShot;
	private String expectedtext="You have successfully registered to Real Estate. We have emailed your password to the email address you entered.";
	String fileName="RETC001";

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
		//getting parameters from properties file
	    baseUrl = properties.getProperty("baseURL");
		email=properties.getProperty("Email");
		uname=properties.getProperty("Uname");
		pwd=properties.getProperty("Pwd");
		fname=properties.getProperty("Fname");
		lname=properties.getProperty("Lname");
		
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Clicking on login/register tab
		loginobj.clickLoginTab();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validateUserRegistration() throws InterruptedException {

        //Clicking on Register tab
		loginobj.clickRegisterTab();
		//Entering email
		loginobj.sendemail(email);
		//Entering first name
		loginobj.sendfname(fname);
		//Entering last name
		loginobj.sendlname(lname);
		//Clicking on register button
		loginobj.clickRegisterBtn();
		Thread.sleep(2000);
		//Capturing Screenshot 
		screenShot.captureScreenShot(fileName);
		
		String actualtext=driver.findElement(By.xpath("//div[contains(@class,'notification')]//p[1]")).getText();
				
		//Validating User registration;
		assertEquals(actualtext, expectedtext);
		
	}

	
	

	
}
