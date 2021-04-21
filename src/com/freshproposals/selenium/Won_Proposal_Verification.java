package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class Won_Proposal_Verification extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	String Get_Won;
	String Verify_Won;
	
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
	 public void SetUnmPwd(String unm, String pwd){
      login(unm, pwd, driver);
	 }
  
  @Test(priority = 1)
  public void Dashboard_Get_Won_Value() throws InterruptedException {
	  Thread.sleep(10000);
	  Get_Won = driver.findElement(By.xpath("//body/app-root[1]/app-home[1]/div[1]/div[6]/div[1]/app-dashboard[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/p[1]")).getText();
	  System.out.println("Before Won "+Get_Won);
  }
  
  @Test(priority = 2)
  public void proposalMethods() throws InterruptedException {
	 Thread.sleep(5000);
	 driver.get("https://beta.freshproposals.net/home/proposals/editProposal;proposalId=20769;editor=true");
	 Thread.sleep(5000);
  }
		
  @Test(priority = 3)
  public void nextbutton() throws InterruptedException {
	  sendNextButton(driver);
 }
  
  @Test(priority = 4)
  public void Send_and_Copy() throws InterruptedException {										
	  //link
	  Thread.sleep(7000);
	    driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
	    Thread.sleep(3000);
	    //get coy text
	    String copy_text = driver.findElement(By.xpath("//div[@class='card-body ng-star-inserted']//input")).getAttribute("value");
	    System.out.println(copy_text);
	    Thread.sleep(2000);
	    //new window
	    ((JavascriptExecutor)driver).executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.get(copy_text);
  }
  
  @Test(priority = 5)
  public void accept() throws InterruptedException {
	  Thread.sleep(7000);
	  driver.findElement(By.xpath("//button[contains(text(),'Accept')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//body/ngb-modal-window[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("Vishal");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//body/ngb-modal-window[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/input[1]")).sendKeys("Manager");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@class='form-check-input']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
 
  }
  
  @Test(priority = 6)
  public void Dashboard_Verify_Won_Value() throws InterruptedException {
	  Thread.sleep(7000);
	  driver.get("https://beta.freshproposals.net/home/dashboard");
	  Verify_Won = driver.findElement(By.xpath("//body/app-root[1]/app-home[1]/div[1]/div[6]/div[1]/app-dashboard[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/p[1]")).getText();
	  System.out.println("After Won "+Verify_Won);
	  //String Verify_Won_plus = Get_Won + 1;
	  
	  Assert.assertNotEquals(Get_Won, Verify_Won);
	  
  }
	
@AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.quit();
  
}
}


