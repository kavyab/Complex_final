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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC063test {

	private WebDriver driver;
	private String baseUrl,email,uname,pwd,fname,lname;
	RETC063POM retc063;	
	private static Properties properties;
	private ScreenShot screenShot;
	private String expectedtext="The email address you entered is not valid.";
	String fileName="RETC061";

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		 retc063 =new RETC063POM(driver);
		//getting parameters from properties file
	    baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Clicking on login/register tab
		retc063.clickLoginTab();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test(dataProvider="excel-inputs",dataProviderClass=LoginDataProviders.class)
	public void validateIncorrectUserRegistration(String email,String fname,String lname) throws InterruptedException {

        //Clicking on Register tab
		retc063.clickRegisterTab();
		//Entering email
		retc063.sendemail(email);
		//Entering first name
		retc063.sendfname(fname);
		//Entering last name
		retc063.sendlname(lname);
		//Clicking on register button
		retc063.clickRegisterBtn();
		Thread.sleep(2000);
		//Capturing Screenshot 
		screenShot.captureScreenShot(fileName);
		
		String actualtext=driver.findElement(By.xpath("//div[@class='notification error closeable']")).getText();
				
		//Validating User registration;
		assertEquals(actualtext, expectedtext);
		
	}
	
	

	
}




