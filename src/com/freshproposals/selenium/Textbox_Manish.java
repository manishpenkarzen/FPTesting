package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Textbox_Manish extends Common_Methods{
	
	WebDriver driver;
    String unm;
    String pwd;
    String url = "https://beta.freshproposals.net/home/templates/editTemplate/1510";
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
		    Thread.sleep(10000);
		    driver.get(url);
	    }
	  
	  @Test(priority = 3,enabled = true)
	  public void Check_toolbar() throws InterruptedException, AWTException 
	  {
		  Thread.sleep(3000);
		    WebElement textbox_div = driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));
		    textbox_div.click();
		    textbox_div.sendKeys("1 ");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
			Thread.sleep(3000);
			 driver.get(url);
		    Thread.sleep(3000);
		    
		    textbox_div = driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));
		    textbox_div.click();
		    textbox_div.sendKeys("2 ");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		    Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
			Thread.sleep(3000);
			 driver.get(url);
		    Thread.sleep(3000);
		    
		    textbox_div = driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));
		    textbox_div.click();
		    textbox_div.sendKeys("3 ");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		    Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
			Thread.sleep(3000);
			 driver.get(url);
		    Thread.sleep(3000);
		    
		    textbox_div = driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));
		    textbox_div.click();
		    textbox_div.sendKeys("4 ");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		    Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
			Thread.sleep(3000);
			 driver.get(url);
		    Thread.sleep(3000);
		    
		    textbox_div = driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));
		    textbox_div.click();
		    textbox_div.sendKeys("5 ");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		    Thread.sleep(3000);
	  }
	  
	  @Test(priority = 2,enabled = false)
	  public void bold() throws InterruptedException, AWTException {
	  {
		    Thread.sleep(3000);
		    WebElement textbox_div = driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));
		    textbox_div.click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("I am BOLD");
		    Thread.sleep(2000);
		    
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_SHIFT);
//		    Thread.sleep(000);
		    
		    Actions actions = new Actions(driver);
		    actions.keyDown(textbox_div,Keys.CONTROL);
		    actions.sendKeys(Keys.chord("a"));
		    actions.keyUp(Keys.CONTROL);
		    
		    Action action = actions.build();
		    
		    action.perform();
		    
		    driver.findElement(By.id("bold-1")).click();
		    Thread.sleep(1000);		   
		    
		    WebElement strong_iambold = driver.findElement(By.xpath("//*[contains(text(),'I am BOLD')]"));
		    String expected_tagname = "strong";
		    String actual_tagname = strong_iambold.getTagName();
		    System.out.println("actual_tagname (for Bold): "+actual_tagname);		
		    Assert.assertEquals(expected_tagname, actual_tagname);
		    Thread.sleep(10000);
	    }	
	  }
}
