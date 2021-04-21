package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lost_Proposal_Verification extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	String Get_Lost;
	String Verify_Lost;
	
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
  public void Dashboard_Get_Lost_Value() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//span[contains(text(),'DASHBOARD')]")).click();
	  Get_Lost = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-dashboard[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/p[1]")).getText();
	  System.out.println("Before Lost "+Get_Lost);
  }
  
  @Test(priority = 2)
  public void proposalMethods() throws InterruptedException {
	 createProposal(driver,wait);
	 proposalName(driver,wait);
	 client(driver,wait);
	 scrollWindow(driver);
	 calender(driver,wait);
	 PcontentLibrary(driver);
	 sendNextButton(driver);
  }
  
  @Test(priority = 4)
  public void Send_and_Copy() throws InterruptedException {
	  //link
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
	  Thread.sleep(2000);
	  
	  String copy_text = driver.findElement(By.xpath("//div[@class='card-body ng-star-inserted']//input")).getAttribute("value");
	  System.out.println(copy_text);
	  Thread.sleep(2000);
	  
	  ((JavascriptExecutor)driver).executeScript("window.open()");
   	  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
 	  driver.switchTo().window(tabs.get(1));
 	  driver.get(copy_text);
	  Thread.sleep(7000);
	  driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
	  //ok btn
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	  //driver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/app-modal[1]/div[1]/div[2]/button[1]")).click();
	  //driver.findElement(By.cssSelector("body.modal-open:nth-child(2) ngb-modal-window.modal.fade.show.d-block.modal-holder:nth-child(15) div.modal-dialog div.modal-content app-modal:nth-child(1) div:nth-child(1) div.modal-footer > button.btn.save-btn:nth-child(1)")).click();
	  Thread.sleep(5000);
 
  }
  
  @Test(priority = 5)
  public void Dashboard_Verify_Lost_Value() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.get("http://beta1.freshproposals.net/home/dashboard");
	  Verify_Lost = driver.findElement(By.xpath("//div[@class='row']//div[1]//div[1]//div[1]//div[3]//div[2]//p[1]")).getText();
	  System.out.println("After Lost "+Verify_Lost);
	  
	  Assert.assertNotEquals(Get_Lost, Verify_Lost);
	  
	  
  }
	
@AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.quit();
}
}
