package com.training.pom;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC004POM {

	WebDriver driver;

	public RETC004POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}



	@FindBy(xpath="//input[@name='agent_title']")
	WebElement we_agenttitle;

	@FindBy(xpath="//input[@id='phone']")
	WebElement we_ph;

	@FindBy(xpath="//button[@value='Submit']")
	WebElement we_savebtn;



	public void sendAgentTitle(String agenttitle)
	{
		we_agenttitle.clear();
		we_agenttitle.sendKeys(agenttitle);

	}

	public void sendPhoneNumber(String ph)
	{
		we_ph.clear();
		we_ph.sendKeys(ph);

	}


	public void onClickSave()
	{
		we_savebtn.click();

	}

}
