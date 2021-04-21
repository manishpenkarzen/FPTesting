package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Image_Duplicate_Template extends Common_Methods {
  
	WebDriver driver;
	WebDriverWait wait;
	String unm;
	String pwd;
	String width_value = "300";
	
	
	@BeforeClass
	  public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", "E:\\FreshPraposal\\Freshproposals_Testing\\Freshproposals_Testing\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 20);   
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			openURL(driver);
		}
	  
	@Test(dataProvider = "User1", priority = 0)
	 public void SetUnmPwd(String unm, String pwd) {
     login(unm, pwd, driver);
	}
	 
	 @Test(priority = 1)
	 public void open_Template() throws InterruptedException{
		 Thread.sleep(10000);
		 createTemplate(driver, wait);
		 existingDataTemplate1(driver, wait);
		 WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='search section']")));
		 search.click();
		 search.sendKeys("Image_Duplicate_Automation");
		 existingDataTemplate2(driver, wait);
		 Thread.sleep(5000);
	 }
	 
	 @Test(priority = 2)
	 public void width() throws InterruptedException {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resizers']//img"))).click();
		 WebElement width = wait.until(ExpectedConditions.elementToBeClickable(By.name("width11")));
		 width.clear();
		 width.sendKeys(width_value);
	}
	 
	 @Test(priority = 3)
	  public void assert_width_1() throws InterruptedException {
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resizers']//img"))).click();
		  String actual_reflect_width = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("width");
		  String expected_reflect_width = width_value+"px";
		  System.out.println("Rwidth "+actual_reflect_width);
		  System.out.println("reflect width "+expected_reflect_width);
		  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
	 }
	 
	 
	 @Test(priority = 4)
	 public void duplicate() throws InterruptedException{
		  Thread.sleep(1000);
		  Actions action = new Actions(driver);
		  action.contextClick(driver.findElement(By.xpath("//div[@class='resizers']//img"))).perform();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//li[contains(text(),'Duplicate')]")).click();
	 
	 }
	 
	 @Test(priority = 5)
	 public void DragDrop() throws InterruptedException{
		 Thread.sleep(3000);
		 Actions action = new Actions(driver);
		 WebElement source = driver.findElement(By.xpath("//app-edit-section[2]//app-fpimage[2]//div[@class='resizers']//img"));
		 WebElement des = driver.findElement(By.xpath("//div[@class='default-rectangle borderColor']"));
		 action.clickAndHold(source).moveToElement(des, 100, 100).release().build().perform();
	 
	 }
 
	 @Test(priority = 6)
	  public void assert_width_2() throws InterruptedException {
		 driver.findElement(By.xpath("//app-edit-section[2]//app-fpimage[2]//div[@class='resizers']//img")).click();
		  String actual_reflect_width = driver.findElement(By.xpath("//app-edit-section[2]//app-fpimage[2]//div[@class='resizers']//img")).getCssValue("width");
		  String expected_reflect_width = width_value+"px";
		  System.out.println("Awidth2 "+actual_reflect_width);
		  System.out.println("Ereflect width2 "+expected_reflect_width);
		  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
	 }
	 
	  

	@AfterClass
	  public void closeBrowser() throws InterruptedException {
	  quitBrowser(driver);
	}
}