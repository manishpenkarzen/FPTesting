package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Analytics_Template_Scratch extends Common_Methods {
	
	WebDriver driver;
	WebDriverWait wait;
	String unm;
	String pwd;
	
	//variables
	
	String e_time = "3 m 00 s";
	String e_view = "1";
	
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
  public void createTemplate() throws InterruptedException {
	  Thread.sleep(10000);
	  driver.findElement(By.id("linkTemplates")).click();
	  driver.findElement(By.id("searchTemplates")).sendKeys("Coworking Space Proposal");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/edit-tool-list.svg']")).click();
	  
	  
	}
  
  @Test(priority = 2)
  public void proposalMethods() throws InterruptedException {
	   generateProposalButton(driver,wait);
	   proposalName(driver,wait);
	   client(driver,wait);
	   scrollWindow(driver);
	   calender(driver,wait);
	   Thread.sleep(35000);
	   sendNextButton(driver);
	   analyticsCopyLink(driver);
  }
  
  
  @Test(priority = 3)
  public void Summary() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/cancel-round.svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@class='email-template-back']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//ul[@class='nav left-navbar']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../assets/proposal-summary-icon.svg']")).click();
	  Thread.sleep(2000);
	  //driver.findElement(By.xpath("//a[@id='analyticsTab']")).click();
  }
  
  @Test(priority = 4)
  public void extendsMethods2() throws InterruptedException {
	  getSummaryData(driver);

  }
  
  @Test(priority = 5)
  public void Assert_time() throws InterruptedException {
	  Thread.sleep(2000);
	  Assert.assertEquals(time, e_time);
	  
  }
  
  @Test(priority = 6)
  public void Assert_view() throws InterruptedException {
	  Thread.sleep(2000);
	  Assert.assertEquals(view, e_view);
	  
  }
  
 
  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  quitBrowser(driver);
  }
  
  
}
