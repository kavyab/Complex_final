package com.training.regression.tests;

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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RETC063POM;
import com.training.pom.RETC064POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC064test {
	
	WebDriver driver;
	ScreenShot screenshot;
	static Properties properties;
	RETC064POM retc064;
	String baseUrl;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		 retc064 =new RETC064POM(driver);
		//getting parameters from properties file
	    baseUrl = properties.getProperty("baseURL");
		screenshot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Clicking on login/register tab
	    retc064.clickLoginTab();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test(dataProvider="excel-inputs",dataProviderClass=LoginDataProviders.class)
	public void clickApartment(String uname,String pwd,String name ,String email,String subject,String msg) throws InterruptedException {
        String expectedtext="There was an error trying to send your message. Please try again later.";
        //sending Username
        retc064.sendUsername(uname);
        //sending password
        retc064.sendPassword(pwd);
        //clicking on signin button
        retc064.clickSignIn();
        //Clicking Apartment tab
		retc064.clickApartment();
		//clicking donec
		retc064.clickDonec();
		//sending enquiry details
		retc064.sendEnquiry(name, subject, msg, email);
		screenshot.captureScreenShot();
		
		String actualtext=driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
				
		//Validating User registration;
		assertEquals(actualtext, expectedtext);
		
	}
	
	
	
	

	
}

