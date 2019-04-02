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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC033test {
	private WebDriver driver;
	private static Properties properties;
	private ScreenShot screenshot;
	private String baseUrl,username,pwd,title,text,price,pricesq,address,googleaddress,latitude,longitude,status,location,possession,storage;
	RETC031POM retc031;
	RETC002POM retc002;
	RETC001POM retc001;
	RETC033POM retc033;
	
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
	    retc033=new RETC033POM(driver);
		//getting parameters from properties file
	    baseUrl = properties.getProperty("baseURL");
	    username=properties.getProperty("Username");
	    pwd=properties.getProperty("Pwd");
		title=properties.getProperty("Title");
		text=properties.getProperty("Text");
		
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
	public void validateAllProp() throws InterruptedException
	{
		String expected="new launch3";
		retc033.clickProp();
		retc033.clickAdd();
		retc033.sendpropData(title,text);
		retc033.clickPublish();
		Thread.sleep(2000);
		retc033.clickAllProp();
		String actual=driver.findElement(By.xpath("//tbody//tr[1]//td[1]//strong//a[contains(text(),'new launch')]")).getText();
		System.out.println(actual);
		assertEquals(actual, expected);
		screenshot.captureScreenShot("RETC033");

}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
