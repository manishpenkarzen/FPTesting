package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Image_DragDrop_Position_Template extends Common_Methods {
 
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
  public void openExistTemplate() throws InterruptedException {
  Thread.sleep(3000);
  driver.get("https://beta.freshproposals.net/home/templates/editTemplate/905");
	}
  
  @Test(priority = 2)
  public void Get_Position() throws InterruptedException {
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
	 Point img_location = driver.findElement(By.xpath("//div[@class='resizers']//img")).getLocation();
	 int editor_x = img_location.getX();
	 int editor_y = img_location.getY();
	 System.out.println("Before Drag and Drop X "+editor_x);
	 System.out.println("Before Drag and Drop Y "+editor_y);
	 
	  Thread.sleep(2000);
	  driver.get("https://beta.freshproposals.net/home/templates/editTemplate/905/true;InEditTemplate=true");
	  Point preview_img_location = driver.findElement(By.xpath("//div[@class='resizers']//img")).getLocation();
	  int preview_x = preview_img_location.getX();
	  int preview_y = preview_img_location.getY();
	  System.out.println("In Preview Before Drag and Drop X "+preview_x);
	  System.out.println("In Preview Before Drag and Drop Y "+preview_y);
	  Thread.sleep(1000);
	  
	  Assert.assertEquals(editor_x, preview_x);
	  Assert.assertEquals(editor_y, preview_y);
	 
	  
  }
  
  @Test(priority = 3)
   public void DragDrop() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.get("https://beta.freshproposals.net/home/templates/editTemplate/905");
	  Actions action = new Actions(driver);
	  WebElement source = driver.findElement(By.xpath("//div[@class='resizers']//img"));
	  WebElement des = driver.findElement(By.xpath("//div[@id='sectionPage_4678page1']"));
	  action.clickAndHold(source).moveToElement(des, 220, 80).release().build().perform();
  }
  
  @Test(priority = 4)
   public void DragDrop_Get_Position() throws InterruptedException {
	  Thread.sleep(3000);
	  Point after_img_location =  driver.findElement(By.xpath("//div[@class='resizers']//img")).getLocation();
	  int after_editor_x = after_img_location.getX();
	  int after_editor_y = after_img_location.getY();
	  System.out.println("After Drag and Drop X "+after_editor_x);
	  System.out.println("After Drag and Drop Y "+after_editor_y);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
 
	  Thread.sleep(2000);
	  driver.get("https://beta.freshproposals.net/home/templates/editTemplate/905/true;InEditTemplate=true");
	  Point after_preview_img_location = driver.findElement(By.xpath("//div[@class='resizers']//img")).getLocation();
	  int after_preview_x = after_preview_img_location.getX();
	  int after_preview_y = after_preview_img_location.getY();
	  System.out.println("In Preview After Drag and Drop X "+after_preview_x);
	  System.out.println("In Preview After Drag and Drop Y "+after_preview_y);
	  
	  Assert.assertEquals(after_editor_x, after_preview_x);
	  Assert.assertEquals(after_editor_y, after_preview_y);
	  
	 }
  
  @Test(priority = 5)
   public void Reset() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.get("https://beta.freshproposals.net/home/templates/editTemplate/905");
	  Actions action = new Actions(driver);
	  WebElement source = driver.findElement(By.xpath("//div[@class='resizers']//img"));
	  WebElement des = driver.findElement(By.xpath("//div[@id='sectionPage_4678page1']"));
	  action.clickAndHold(source).moveToElement(des, -222, -80).release().build().perform();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[@class='resizers']//img")).click();
	  Point img_location = driver.findElement(By.xpath("//div[@class='resizers']//img")).getLocation();
	  int editor_x = img_location.getX();
	  int editor_y = img_location.getY();
	  System.out.println("Before Drag and Drop X "+editor_x);
	  System.out.println("Before Drag and Drop Y "+editor_y);
	  
	  
	 }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
  }
}
