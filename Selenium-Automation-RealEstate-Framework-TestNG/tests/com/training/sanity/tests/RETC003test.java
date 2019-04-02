package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC005POM;
import com.training.pom.RETC004POM;
import com.training.pom.RETC003POM;
import com.training.pom.RETC001POM;
import com.training.pom.RETC002POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC003test {
	
	private WebDriver driver;
	private String baseUrl,email,uname,pwd,fname,lname;
	RETC001POM loginobj;
	RETC002POM userloginobj;
	RETC003POM retc003obj;
	private static Properties properties;
	private ScreenShot screenShot;
	private String expectedtitle="My Profile – Real Estate";
	String fileName="RETC003";

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
	    retc003obj=new RETC003POM(driver);
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
	public void recoverPwd()
	{
		String expectedtext="A confirmation link has been sent to your email address.";
		//Clicking on  lost Password link
		retc003obj.clicklostpwd();
		//Entering email
		retc003obj.sendemail(email);
		//Entering on Reset button
		retc003obj.clickReset();
		//Capturing Screenshot
		screenShot.captureScreenShot(fileName);		
		String actualtext=driver.findElement(By.xpath("//p[contains(text(),'The email could not be sent.')]")).getText();
		//Validating the message after password reset 
		Assert.assertEquals(actualtext,expectedtext);
		
	}
}
