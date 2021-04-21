package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ZoomLevelTestingInSectionPreview extends Common_Methods {
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
	 @Test(priority=1,dependsOnMethods = "login")
	 public void selectzoom() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/sections/editSection/5020/true");
		 driver.findElement(By.xpath("//div[@class='collapse-preview-controls roatate ng-star-inserted']")).click();
		 Thread.sleep(2000);
		WebElement ele=	driver.findElement(By.xpath("//div[@class='page-wrapper']"));

		Select level=new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
		 int[] ar = new int[]{195,235,275,314,354,394,473,552,632,711 }; 

		for(int i=0;i<10;i++) {
		level.selectByIndex(i);
		Thread.sleep(1000);
		Point point = ele.getLocation();
		 int xcord = point.getX();
		 System.out.println("Position of the webelement from left side is "+xcord +" pixels");
		
		 Assert.assertEquals(xcord,ar[i] );
		}
		

		}
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.close();
	  }
}
