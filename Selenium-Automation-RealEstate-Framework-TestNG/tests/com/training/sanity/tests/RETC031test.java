package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC001POM;
import com.training.pom.RETC002POM;
import com.training.pom.RETC031POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC031test {
	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	private static Properties properties;
	private ScreenShot screenshot;
	private String baseUrl,username,pwd,title,text,price,pricesq,address,googleaddress,latitude,longitude,status,location,possession,storage;
	RETC031POM retc031;
	RETC002POM retc002;
	RETC001POM retc001;
	
	
	
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
		//getting parameters from properties file
	    baseUrl = properties.getProperty("baseURL");
	    username=properties.getProperty("Username");
	    pwd=properties.getProperty("Pwd");
		title=properties.getProperty("Title");
		text=properties.getProperty("Text");
		price=properties.getProperty("Price");
		pricesq=properties.getProperty("Pricesq");
		address=properties.getProperty("Address");
		googleaddress=properties.getProperty("Googleaddress");
		latitude=properties.getProperty("Latitude");
		longitude=properties.getProperty("Longitude");
		status=properties.getProperty("Status");
		location=properties.getProperty("Location");
		possession=properties.getProperty("Possession");
		storage=properties.getProperty("Storage");
		
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
	public void addNewProperty() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String expectedmsg="Post published. View post";
		retc031.clickProp();
		retc031.clickAdd();
		retc031.sendData(title,text,price,pricesq);
		retc031.clickLocation();
		retc031.sendlocaddress(address,googleaddress,latitude,longitude);
		retc031.clickmaindetail();
		retc031.sendMainData(status,location,possession);
		retc031.clickDetails();
		retc031.sendStorage(storage);
		retc031.clickCenBang();
		
		//Thread.sleep(5000);
		
		js.executeScript("window.scrollBy(0,-346)");
		
	    
		retc031.clickPublish();
		
		Thread.sleep(5000);
		String actualmsg=driver.findElement(By.xpath("//p[contains(text(),'Post published')]")).getText();
		assertEquals(actualmsg,expectedmsg);
		screenshot.captureScreenShot("RETC031");
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
