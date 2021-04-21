package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Enter;

public class Gmail_Testing extends Common_Methods{
	WebDriver driver;
	WebDriverWait wait;
	String unm;
	String pwd;
	
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
	  public void ExtendsMethods() throws InterruptedException {
		  systemTemplate(driver, wait);
		  generateProposalButton(driver, wait);
		  proposalName(driver, wait);
		  client(driver, wait);
		  scrollWindow(driver);
		  calender(driver, wait);
		  sendNextButton(driver);
		  
	  }
	 
	 @Test(priority = 2,enabled = false)
	 public void Gmail_login() {
		 driver.get("https://mail.google.com/mail/u/0/#inbox");
         
		 wait.until(ExpectedConditions.elementToBeClickable(By.name("identifier"))).sendKeys("iamjonathanross@gmail.com");
	     String actual_name = driver.findElement(By.name("identifier")).getAttribute("value");
	     String expected_name = "iamjonathanross@gmail.com";
	     Assert.assertEquals(actual_name, expected_name);
	        
		 driver.findElement(By.id("identifierNext")).click();
			 
		 wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys("Jonathanross@123");
		 String actual_password = driver.findElement(By.name("password")).getAttribute("value");
		 String expected_password = "Jonathanross@123";
		 Assert.assertEquals(actual_password, expected_password);
		 driver.findElement(By.id("passwordNext")).click();
	 }
	 
	 @Test(priority = 3,enabled = false)
	 public void Search() throws InterruptedException {
		 Thread.sleep(2000);
		 //driver.findElement(By.name("q")).sendKeys("Selenium Subject" + Keys.ENTER);
		 Thread.sleep(2000);
		 //driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/table[1]/tbody[1]/tr[1]")).click();
		 driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("View Our Business Proposal")).click();
		 Thread.sleep(2000);
	 }
	 
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
		 quitBrowser(driver);
	  }
	  
}
