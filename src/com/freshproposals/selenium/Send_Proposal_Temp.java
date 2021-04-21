package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Send_Proposal_Temp extends Common_Methods{
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
  
  @Test(dataProvider = "User1", priority = 0)
	 public void SetUnmPwd(String unm, String pwd) {
     login(unm, pwd, driver);
	}
  
  @Test(priority = 1)
  public void extendsMethods() throws InterruptedException {
	   createTemplate(driver, wait);
	   //contentLibrary(driver);
	   generateProposalButton(driver,wait);
	   proposalName(driver,wait);
	   client(driver,wait);
	   scrollWindow(driver);
	   calender(driver,wait);
	   sendNextButton(driver);
	   sendEmail(driver);
	   
  }
  
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
	 quitBrowser(driver);
  }
  
  
}
