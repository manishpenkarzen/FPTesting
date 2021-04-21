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

public class TextBox_Duplicate_Proposal extends Common_Methods {
  
	WebDriver driver;
	WebDriverWait wait;
	String unm;
	String pwd;
	String width_value = "300";
	String text_value = "FreshProposals";
	
	
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
		 createProposal(driver,wait);
		  proposalName(driver,wait);
		  client(driver,wait);
		  scrollWindow(driver);
		  calender(driver,wait);
		  existingDataProposal1(driver,wait);
		  WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='search section']")));
		  search.click();
		  search.sendKeys("TextBox_Properties_Automation_C_L");
		  existingDaraProposal2(driver,wait);
		  Thread.sleep(5000);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resizers']"))).click();
		 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resizers']"))).sendKeys("FreshProposals");
	 }
	 
	 @Test(priority = 2)
	 public void width() throws InterruptedException {
//		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resizers']"))).click();
		 WebElement width = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='row']//div[1]//div[1]//ejs-numerictextbox[1]//span[1]//input[1]")));
		 width.clear();
		 width.sendKeys(width_value);
	}
	 
	 @Test(priority = 3)
	  public void assert_width_1() throws InterruptedException {
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resizers']"))).click();
		  String actual_reflect_width = driver.findElement(By.xpath("//div[@class='resizers']")).getCssValue("width");
		  String expected_reflect_width = width_value+"px";
		  System.out.println("Rwidth "+actual_reflect_width);
		  System.out.println("reflect width "+expected_reflect_width);
		  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
	 }
	 
	 @Test(priority = 4, enabled = false)
	  public void assert_text_1() throws InterruptedException {
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resizers']"))).click();
		  String actual_reflect_text = driver.findElement(By.xpath("//app-edit-section[2]//app-fptext[1]//div[@class='resizers']//div[@class='fr-element fr-view']//p")).getText();
		  String expected_reflect_text = text_value;
		  System.out.println("Rtext "+actual_reflect_text);
		  System.out.println("reflect text "+expected_reflect_text);
		  Assert.assertEquals(actual_reflect_text, expected_reflect_text);
	 }
	 
	 
	 @Test(priority = 5)
	 public void duplicate() throws InterruptedException{
		  Thread.sleep(1000);
		  Actions action = new Actions(driver);
		  action.contextClick(driver.findElement(By.xpath("//div[@class='resizers']"))).perform();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//li[contains(text(),'Duplicate')]")).click();
	 
	 }
	 
	 @Test(priority = 6)
	 public void DragDrop() throws InterruptedException{
		 Thread.sleep(3000);
		 Actions action = new Actions(driver);
		 WebElement source = driver.findElement(By.xpath("//app-edit-section[2]//app-fptext[2]//div[@class='resizers']"));
		 WebElement des = driver.findElement(By.xpath("//div[@class='default-rectangle borderColor']"));
		 action.clickAndHold(source).moveToElement(des, 100, 100).release().build().perform();
	 
	 }
 
	 @Test(priority = 7)
	  public void assert_width_2() throws InterruptedException {
		 driver.findElement(By.xpath("//app-edit-section[2]//app-fptext[2]//div[@class='resizers']")).click();
		  String actual_reflect_width = driver.findElement(By.xpath("//app-edit-section[2]//app-fptext[2]//div[@class='resizers']")).getCssValue("width");
		  String expected_reflect_width = width_value+"px";
		  System.out.println("Awidth2 "+actual_reflect_width);
		  System.out.println("Ereflect width2 "+expected_reflect_width);
		  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
	 }
	 
	 @Test(priority = 8, enabled = false)
	  public void assert_text_2() throws InterruptedException {
		 driver.findElement(By.xpath("//app-edit-section[2]//app-fptext[2]//div[@class='resizers']//div[@class='fr-element fr-view']//p")).click();
		  String actual_reflect_text = driver.findElement(By.xpath("//app-edit-section[2]//app-fptext[2]//div[@class='resizers']//div[@class='fr-element fr-view']//p")).getText();
		  String expected_reflect_text = text_value;
		  System.out.println("Atext2 "+actual_reflect_text);
		  System.out.println("Ereflect text2 "+expected_reflect_text);
		  Assert.assertEquals(actual_reflect_text, expected_reflect_text);
	 }
	 
	  

	@AfterClass
	  public void closeBrowser() throws InterruptedException {
	  quitBrowser(driver);
	}
}