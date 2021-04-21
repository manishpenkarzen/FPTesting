package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Select_Search_Tab extends Common_Methods {
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
  public void Select() throws InterruptedException {
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//input[@placeholder='Search Template']")).click();
//	 Select select = new Select(driver.findElement(By.xpath("//div[@id='content']//div[2]//div[1]//select[1]")));
//	 Thread.sleep(2000);
//	 
//	 select.selectByVisibleText("Completed");
//	 String actual_completed = select.getFirstSelectedOption().getText();
//	 String expected_completed = "Completed";
//	 Assert.assertEquals(actual_completed, expected_completed);
//	 Thread.sleep(3000);
//	 
//	 select.selectByVisibleText("Pending");
//	 String actual_pending = select.getFirstSelectedOption().getText();
//	 String expected_pending = "Pending";
//	 Assert.assertEquals(actual_pending, expected_pending);
//	 Thread.sleep(1000);
//	 
//	 select.selectByVisibleText("All");
//	 String actual_all = select.getFirstSelectedOption().getText();
//	 String expected_all = "All";
//	 Assert.assertEquals(actual_all, expected_all);
//	  
  }
  
  @Test(priority = 2)
  public void Search() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@placeholder='Search Proposals']")).sendKeys("Software Proposal");
	  String actual_search = driver.findElement(By.xpath("//input[@placeholder='Search Proposals']")).getAttribute("value");
	  String expected_search = "Software Proposal";
	  Assert.assertEquals(actual_search, expected_search);
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
  }
  
  @Test(priority = 3)
  public void Tab() throws InterruptedException {
	  Thread.sleep(7000);
	  driver.findElement(By.linkText("Design")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.linkText("Software")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.linkText("Real State")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.linkText("All")).click();
	  
  }
  
  @Test(priority = 4)
  public void Tab_change() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@placeholder='Search Proposals']")).sendKeys("All in One");
	  String actual_search = driver.findElement(By.xpath("//input[@placeholder='Search Proposals']")).getAttribute("value");
	  String expected_search = "All in One";
	  Assert.assertEquals(actual_search, expected_search);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/edit-tool-list.svg']")).click();
	  Thread.sleep(2000);
	  Select select = new Select(driver.findElement(By.name("category")));
	  select.selectByVisibleText("Marketing");
//	  String actual_marketing = select.getFirstSelectedOption().getText();
//	  System.out.println(actual_marketing);
//	  String expected_marketing = " Marketing";
//	  Assert.assertEquals(actual_marketing, expected_marketing);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  Thread.sleep(10000);
	  driver.findElement(By.linkText("Marketing")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//img[@src='../../assets/edit-pen-blue.svg']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@src='../../../../../assets/edit-tool-list.svg']")).click();
	  Thread.sleep(2000);
	  Select select2 = new Select(driver.findElement(By.name("category")));
	  select2.selectByVisibleText("Software");
//	  String actual_software = select2.getFirstSelectedOption().getText();
//	  String expected_software = "Software";
//	  Assert.assertEquals(actual_software, expected_software);
	 
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
  

}
