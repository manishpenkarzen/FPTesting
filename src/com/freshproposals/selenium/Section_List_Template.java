package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Section_List_Template extends Common_Methods {
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
//enabled = false
  public void createtemplate() throws InterruptedException {
		Thread.sleep(10000);
		//template name
		driver.findElement(By.xpath("//img[@src='../../assets/add-section-icon.png']")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" SLTemp "+timestamp);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
//  @Test(priority = 2)
//  public void AddSection() throws InterruptedException {
//	  Thread.sleep(2000);
//	  //+
//	  driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//button[@class='btn add-sect-btn']")).click();
//	  //add new
//	  Thread.sleep(2000);
//	  driver.findElement(By.className("create-prop-temp-box")).click();
//	  //name
//	  Thread.sleep(1000);
//	  driver.findElement(By.name("name")).sendKeys(fname+" SectionName "+timestamp);
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[@type='submit']")).click();
//	  Thread.sleep(1000);
//	  //close
//	  driver.findElement(By.xpath("//img[@src='../../../assets/cancel.svg']")).click();
//	  //section name
//	  driver.findElement(By.className("sectionlist-name")).click();
//	  
//  }
  
  @Test(priority = 3)
  public void rename() throws InterruptedException {
	  //driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/754");
	  Thread.sleep(15000);
	  driver.findElement(By.xpath("//li[@class='nav-item example-box active']//a[@class='sectionlist-name'][contains(text(),'New Section')]")).click();	
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img")).click();
	  Thread.sleep(2000);
	  //rename
	  driver.findElement(By.xpath("//button[contains(text(),'Rename')]")).click();
	  Thread.sleep(1000);
	  //name change
	  driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
	  driver.findElement(By.xpath("//li[1]//input[1]")).sendKeys(fname+" SECName "+timestamp);
	  driver.findElement(By.xpath("//div[@class='rename-section']//div//img[@class='img-fluid']")).click();
	  Thread.sleep(5000);
	  //save
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(1000);
	  //back
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  //reopen
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	
	 
	 
   }
  
  @Test(priority = 4)
  public void copy() throws InterruptedException {
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img")).click();
	  driver.findElement(By.xpath(" //button[contains(text(),'Make a Copy')]")).click();
	  Thread.sleep(2000); 
	  //save
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(1000);
	  //back
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  //reopen
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	  
  }
  
  @Test(priority = 5)
  public void delete() throws InterruptedException {
	  driver.findElement(By.xpath("//img[@src='../../assets/add-icon.svg']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(" //button[@id='dropdownBasic1'] //img")).click();
	  Thread.sleep(1000);
	 
      driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
	  //ok button
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	  Thread.sleep(2000);
	//save
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(1000);
	  //back
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  //reopen
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	  
  }
  
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
 
  }
