package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class X_Y_Position extends Common_Methods {
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

  	@Test (priority = 1)
  	
	public void Get_Position_Editor() throws InterruptedException {
  		
  		Thread.sleep(2000);
  		driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1325;editor=true");
  		Point img_editor = driver.findElement(By.xpath("//div[@class='resizers']//img")).getLocation();
  		//System.out.println(driver.findElement(By.xpath("//div[@id='section5816-page1-fpImage1122201911261110']//div[@class='resizers']//img")).getLocation());
  		int img_editor_x = img_editor.getX();
  		System.out.println(img_editor_x);
  		int img_editor_y = img_editor.getY();
  	    System.out.println(img_editor_y);
  	    
  	    
  	    Thread.sleep(2000);
  	    driver.get("http://beta1.freshproposals.net/home/viewproposal/1325/preview/proposals");
  	    Point img_preview = driver.findElement(By.xpath("//div[@class='resizers']//img")).getLocation();
  	    int img_preview_x = img_preview.getX();
  	    System.out.println(img_preview_x);
  	    int img_preview_y = img_preview.getY();
  	    System.out.println(img_preview_y);
  	    
  	    Assert.assertEquals(img_editor_x, img_preview_x);
  	    Assert.assertEquals(img_editor_y, img_preview_y);
  	    
      }
  	
 
      @AfterClass
  	  public void closeBrowser() throws InterruptedException {
  	  Thread.sleep(3000);
  	  driver.close();
  	}

	
}
