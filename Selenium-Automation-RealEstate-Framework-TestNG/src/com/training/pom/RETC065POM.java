package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC065POM {
	WebDriver driver;
	
	public RETC065POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Posts')]")
	WebElement we_post;
	
	@FindBy(xpath=" //a[@href='edit-tags.php?taxonomy=category']")
	WebElement we_category;
	
	@FindBy(xpath="//input[@id='tag-name']")
	WebElement we_name;
	
	@FindBy(xpath="//input[@id='tag-slug']")
	WebElement we_slug;
	
	@FindBy(xpath="//textarea[@id='tag-description']")
	WebElement we_description;
	
	@FindBy(xpath="//input[@value='Add New Category']")
	WebElement we_addnewcat;
	
	@FindBy(xpath="//a[@class='wp-first-item current']")
	WebElement we_allposts;
	
	@FindBy(xpath="//a[@class='page-title-action']")
	WebElement we_addnew;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement we_title;
	
	@FindBy(xpath="//body[@id='tinymce']")
	WebElement we_body;
	
	@FindBy(xpath="//input[@id='in-category-250']")
	WebElement we_chbx;
	
	@FindBy(xpath="//input[@id='publish']")
	WebElement we_publish;
	
	@FindBy(xpath="//a[contains(text(),'Howdy,')]")
	WebElement we_profname;
	
	@FindBy(xpath="//span[@class='hamburger-inner']")
	WebElement we_mainmenu;
	
	
	
	@FindBy(xpath="//ul[@id='responsive']//a[contains(text(),'Blog')]")
	WebElement we_blog;
	
	@FindBy(xpath="//div[@class='post-content']//a[contains(text(),'titletest')]")
	WebElement we_searchtitle;
	
	@FindBy(xpath="//a[@class='ab-item'][contains(text(),'Log Out')]")
	WebElement we_logout;
	
	public void clickpost()
	{
		we_post.click();
	}
	
	public void clickcategory()
	{
		we_category.click();
	}
	
	public void sendInfo(String name ,String slug, String desc)
	{
		we_name.sendKeys(name);
		we_slug.sendKeys(slug);
		we_description.sendKeys(desc);
		Select a=new Select(driver.findElement(By.xpath("//select[@id='parent']")));
		a.selectByValue("250");
		
	}
	
	public void clickAddCat()
	{
		we_addnewcat.click();
	}
	
	/*public void clickcatdrop()
	{
		Select a=new Select(driver.findElement(By.xpath("//select[@id='parent']")));
		a.selectByValue("250");
	}*/
	
	public void clickAllPost()
	{
		we_allposts.click();
	}
	
	public void clickAddNew()
	{
		we_addnew.click();
	}
	
	public void sendDetails(String title,String body) throws InterruptedException
	{
		we_title.sendKeys(title);
		driver.switchTo().frame("content_ifr");
		we_body.sendKeys(body);
		driver.switchTo().defaultContent();
		we_chbx.click();
		Thread.sleep(2000);
		we_publish.click();
		Thread.sleep(7000);
	}
	
	public void clickProf()
	{
		Actions act=new Actions(driver);
				act.moveToElement(we_profname).perform();
	}
	
	public void clickLogout()
	{
		we_logout.click();
	}
	
	public void clickBlog()
	{
		we_blog.click();
	}
	
	
	

}
