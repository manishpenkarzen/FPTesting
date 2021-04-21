package com.freshproposals.selenium;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBox_Top_Properties_Template extends Common_Methods {
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
	  public void url() throws InterruptedException {
		    Thread.sleep(1000);
		    driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1367");
	    }
	  
	  @Test(priority = 2)
	  public void BU() throws InterruptedException, AWTException {
		  Thread.sleep(1000);
		  //textbox click 
		  driver.findElement(By.xpath("//div[@id='froalapage1-fpText1230201912435449']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'bold')]")).click();
		  
		  driver.findElement(By.xpath("//button[starts-with(@id,'underline')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("Freshproposals");
		  
		  String actual_text = driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).getText();
		  System.out.println(actual_text);
		  String expected_text = "Freshproposals";
		  Assert.assertEquals(actual_text, expected_text);
		  
		  String actual_bold = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//strong")).getCssValue("font-weight");
		  System.out.println(actual_bold);
		  String expected_bold = "700";
		  Assert.assertEquals(actual_bold, expected_bold);
		  
		  String actual_underline = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("text-decoration");
		  System.out.println(actual_underline);
		  String expected_underline = "underline solid rgb(51, 51, 51)";
		  Assert.assertEquals(actual_underline, expected_underline);
	    }
	  
	  @AfterTest
	  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();

}
}
