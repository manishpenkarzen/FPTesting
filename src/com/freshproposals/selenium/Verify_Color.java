package com.freshproposals.selenium;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Verify_Color extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	
	
  @BeforeClass
  public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\FreshPraposal\\Freshproposals_Testing\\Freshproposals_Testing\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		openURL(driver);
	}
  
  @Test(dataProvider = "User2", priority = 0)
	 public void SetUnmPwd(String unm, String pwd) {
     login(unm, pwd, driver);
	}
 
 @Test(priority = 1)
 public void verify_Color() throws InterruptedException {
	 Thread.sleep(5000);
	 driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1163;editor=true");
	 Thread.sleep(1000);
	if(driver.findElement(By.id("page1-fpText111320191728746mainDivTransformSafeStyle")).isSelected()) {
		System.out.println(driver.findElement(By.id("page1-fpText111320191728746mainDivTransformSafeStyle")).getCssValue("z-index"));
	}
	else {
		System.out.println(driver.findElement(By.id("page1-fpShape1113201917282362mainDivTransformSafeStyle")).getCssValue("background-color"));
	}
	 	
	
     //System.out.println(driver.findElement(By.id("page1-fpText111320191728746mainDivTransformSafeStyle")).getCssValue("z-index"));//text 400
     //System.out.println(driver.findElement(By.id("page1-fpShape1113201917282362mainDivTransformSafeStyle")).getCssValue("z-index"));//shape 401
          
 }
 
 @AfterClass
 public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
 }
 
 
}


