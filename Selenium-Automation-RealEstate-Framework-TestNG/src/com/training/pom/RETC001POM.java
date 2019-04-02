package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC001POM {
	

	
		private WebDriver driver; 
		
		public RETC001POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//ul[@class='menu']//a[@class='sign-in']")
		private WebElement we_login; 
		
		@FindBy(xpath="//a[@href='#tab2']")
		private WebElement we_register;
		
		@FindBy(xpath="//input[@id='email']")
		private WebElement we_email; 
		
		@FindBy(xpath="//input[@id='first-name']")
		private WebElement we_fname; 
		
		@FindBy(xpath="//input[@id='last-name']")
		private WebElement we_lname; 
		
		@FindBy(xpath="//input[@value='Register']")
		private WebElement we_registerbtn; 
		
		
		public void sendemail(String email) {
			this.we_email.clear();
			this.we_email.sendKeys(email);
		}
		
		public void sendfname(String fname) {
			this.we_fname.clear(); 
			this.we_fname.sendKeys(fname); 
		}
		
		public void sendlname(String lname) {
			this.we_lname.clear(); 
			this.we_lname.sendKeys(lname); 
		}
		
		public void clickLoginTab() {
			this.we_login.click(); 
		}
		
		public void clickRegisterTab() {
			this.we_register.click(); 
		}
		
		public void clickRegisterBtn() {
			this.we_registerbtn.click(); 
		}
	}



