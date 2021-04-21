package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Verify_Position_with_Preview extends Common_Methods {
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
  public void openProposal() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1151;editor=true");
	  
	  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
	  int x1 = img_location.getX();
	  int y1 = img_location.getY();
	  System.out.println("X1 "+x1);
	  System.out.println("Y1 "+y1);
	  
	  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
	  int x2 = txt_location.getX();
	  int y2 = txt_location.getY();
	  System.out.println("X2 "+x2);
	  System.out.println("Y2 "+y2);
	  
	  Thread.sleep(2000);
	  driver.get("http://beta1.freshproposals.net/home/viewproposal/1151/preview/proposals");
	  Point img_locationP = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
	  int x3 = img_locationP.getX();
	  int y3 = img_locationP.getY();
	  System.out.println("X3 "+x3);
	  System.out.println("Y3 "+y3);
	  
	  Point txt_locationP = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
	  int x4 = txt_locationP.getX();
	  int y4 = txt_locationP.getY();
	  System.out.println("X4 "+x4);
	  System.out.println("Y4 "+y4);
	  
	  int first = x1-x2;
	  int second = y1-y2;
	  int third = x3-x4;
	  int fourth = y3-y4;
	  
	  System.out.println("Editor X (x1-x2) "+first);
	  System.out.println("Preview X (x3-x4) "+third);
	  System.out.println("Editor Y (y1-y2) "+second);
	  System.out.println("Preview Y (y3-y4) "+fourth);
	  

	  
	  
	  
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
  }