package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class System_Template_Proposal extends Common_Methods{
	     
	   WebDriver driver;
	   String unm;
	   String pwd;
  
  @BeforeClass
  public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\FreshPraposal\\Freshproposals_Testing\\Freshproposals_Testing\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(95, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(95,TimeUnit.SECONDS);
		long start = System.currentTimeMillis();
		openURL(driver);
	
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load - "+totalTime); 
}
 
 @Test(dataProvider = "User1", priority = 0)
 public void SetUnmPwd(String unm, String pwd) {
	 login(unm, pwd, driver);
}
 
 @Test(priority = 1)
 public void first() throws InterruptedException {
	 Thread.sleep(15000);
	 driver.findElement(By.xpath("//a[contains(text(),'System')]")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.id("searchTemplates")).sendKeys("SEO Proposal");
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//img[@src='../../assets/edit-section-icon.png']")).click();
	 Thread.sleep(15000);
	 generateProposalButton(driver,wait);
	 proposalName(driver,wait);
	driver.findElement(By.className("checkround")).click();
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
