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
import com.training.pom.RETC064POM;
import com.training.pom.RETC065POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC065test {

	WebDriver driver;
	ScreenShot screenshot;
	static Properties properties;
	RETC065POM retc065;
	RETC064POM retc064;
	String baseUrl,name,slug,desc,title,body;


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc065 =new RETC065POM(driver);
		retc064=new RETC064POM(driver);
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
	public void clickApartment(String uname,String pwd,String name,String slug,String desc ,String title,String body) throws InterruptedException {
		String expectedtext="Test_Kavya09";
        //sending Username
		retc064.sendUsername(uname);
		//sending Password
		retc064.sendPassword(pwd);
		//clicking on sign in
		retc064.clickSignIn();
		//clicking on post
		retc065.clickpost();
		//clicking on category
		retc065.clickcategory();
        //sending information in category
		retc065.sendInfo(name,slug,desc);
		//clicking on category button
		retc065.clickAddCat();
		//clicking on post 
		retc065.clickpost();
		//clicking on all posts
		retc065.clickAllPost();
		//clicking on addnew post
		retc065.clickAddNew();
		//sending tile&body
		retc065.sendDetails(title, body);
        //clicking on profile
		retc065.clickProf();
		//clicking on logout
		retc065.clickLogout();
		Thread.sleep(3000);
		//clicking on blog
		retc065.clickBlog();


		String actualtext=driver.findElement(By.linkText("Test_Kavya09")).getText();
		//capturing screenshot
		screenshot.captureScreenShot();
         System.out.println(actualtext);
		//Validating User registration;
		assertEquals(actualtext, expectedtext);

	}
}
