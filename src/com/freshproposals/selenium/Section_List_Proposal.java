package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Section_List_Proposal extends Common_Methods {
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
  
  @Test(priority = 2)
  public void proposal() throws InterruptedException {
	  createProposal(driver,wait);
	  proposalName(driver,wait);
	  client(driver,wait);
	  scrollWindow(driver);
	  calender(driver,wait);
	}

  
  @Test(priority = 5)
  public void rename() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//li[@class='nav-item example-box active']//a[@class='sectionlist-name'][contains(text(),'New Section')]")).click();
	  Thread.sleep(5000);
	  //add page
	  driver.findElement(By.xpath("//li[@class='nav-item example-box active']//div[@class='add-section']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//li[@class='nav-item example-box active']//div[@class='add-section']")).click();
	  Thread.sleep(3000);
	  //driver.findElement(By.xpath("//div[@class='d-inline-block show dropdown']//button[@id='dropdownBasic1']//img")).click();
	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-template[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[2]/div[2]/div[1]/button[1]/img[1]")).click();
	  Thread.sleep(2000);
	  //rename
	  driver.findElement(By.xpath("//li[@class='nav-item example-box active']//button[@class='dropdown-item'][contains(text(),'Rename')]")).click();
	  Thread.sleep(3000);
	  //name change
	  driver.findElement(By.id("renameSection1")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-proposal[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/input[1]")).sendKeys(fname+" SECName "+timestamp);
	  driver.findElement(By.xpath("//div[@class='rename-section']//div//img[@class='img-fluid']")).click();
	  Thread.sleep(5000);
	  //save
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(1000);
	  //back
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  //reopen
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-section-icon.png']")).click();
	
	 
	 
   }
  
  @Test(priority = 6)
  public void copy() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-proposal[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-proposal[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[2]/div[1]/button[1]/img[1]")).click();
	  Thread.sleep(1000);
	
	  driver.findElement(By.xpath("//li[@class='nav-item example-box active']//button[@class='dropdown-item'][contains(text(),'Make a Copy')]")).click();
	  Thread.sleep(2000); 
	  //save
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(1000);
	  //back
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  //reopen
	  Thread.sleep(10000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-section-icon.png']")).click();
	  
  }
  
  @Test(priority = 7)
  public void delete() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-proposal[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-proposal[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[2]/div[1]/button[1]/img[1]")).click();
	  Thread.sleep(1000);
	 
      driver.findElement(By.xpath("//li[@class='nav-item example-box active']//button[@class='dropdown-item'][contains(text(),'Delete')]")).click();
	  //ok button
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@class='btn save-btn']")).click();
	  Thread.sleep(2000);
	//save
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(1000);
	  //back
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  //reopen
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-section-icon.png']")).click();
	  
  }

  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}

  
}
