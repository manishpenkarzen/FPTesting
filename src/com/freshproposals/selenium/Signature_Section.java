package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Signature_Section extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	
	
	String width = "300";
	String height = "70";
	String border_width = "10";
	String border_style = "inset";
	String corner = "30";
	String rotate = "5";
	String padding_top = "10";
	String padding_left = "10";
	String padding_bottom = "70";
	String padding_right = "10";
	
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
  public void open_Section() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.net/home/sections/editSection/6909");
	  Thread.sleep(3000);
	  driver.findElement(By.id("page1-fpSign122020154686")).click();
	  
  }
  
  
  @Test(priority = 2)
  public void width() throws InterruptedException {
	//width
	  Thread.sleep(1000);
	  driver.findElement(By.name("textWidth11")).clear();
	  driver.findElement(By.name("textWidth11")).sendKeys(width);
	  String actual_width = driver.findElement(By.name("textWidth11")).getAttribute("value");
	  Assert.assertEquals(actual_width, width);
  }
  
  @Test(priority = 3)
  public void height() throws InterruptedException {
	//height
	  Thread.sleep(1000);
	  driver.findElement(By.name("height11")).clear();
	  driver.findElement(By.name("height11")).sendKeys(height);
	  String actual_height = driver.findElement(By.name("height11")).getAttribute("value");
	  Assert.assertEquals(actual_height, height);
  }
  
  @Test(priority = 4)
  public void Save_height_width() throws InterruptedException {
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.net/home/sections/editSection/6909");
	  
 }
  
  @Test(priority = 5)
  public void reflect_width() {
	  driver.findElement(By.id("page1-fpSign122020154686")).click();
	  String actual_reflect_width = driver.findElement(By.id("page1-fpSign122020154686")).getCssValue("width");
	  String expected_reflect_width = width+"px";
	  System.out.println("Awidth "+actual_reflect_width);
	  System.out.println("Ereflect width "+expected_reflect_width);
	  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
	  
  }
  
  @Test(priority = 6)
  public void reflect_height() {
	  driver.findElement(By.id("page1-fpSign122020154686")).click();
	  String actual_reflect_height = driver.findElement(By.id("page1-fpSign122020154686")).getCssValue("height");
	  System.out.println("Aheight "+actual_reflect_height);
	  String expected_reflect_height = height+"px";
	  System.out.println("Ereflect height "+expected_reflect_height);
	  Assert.assertEquals(actual_reflect_height, expected_reflect_height);
  }
  
  @Test(priority = 7)
  public void Reset_height_width() throws InterruptedException {
  Thread.sleep(1000);
  driver.findElement(By.id("page1-fpSign122020154686")).click();
  driver.findElement(By.name("textWidth11")).clear();
  driver.findElement(By.name("textWidth11")).sendKeys("250");
  
  Thread.sleep(1000);
  driver.findElement(By.name("height11")).clear();
  driver.findElement(By.name("height11")).sendKeys("75");
 }
  
  @Test(priority = 8)
  public void corner() throws InterruptedException {
	  //corner
	  Thread.sleep(1000);
	  driver.findElement(By.name("corners")).clear();
	  driver.findElement(By.name("corners")).sendKeys(corner);
	  String actual_corner = driver.findElement(By.name("corners")).getAttribute("value");
	  Assert.assertEquals(actual_corner, corner);
  }
  
  @Test(priority = 9)
  public void rotate() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.name("rotate")).clear();
	  driver.findElement(By.name("rotate")).sendKeys(rotate);
	  String actual_rotate = driver.findElement(By.name("rotate")).getAttribute("value");
	  System.out.println(actual_rotate);
	  Assert.assertEquals(actual_rotate, rotate);
  }
  
  
  
  @Test(priority = 10)
  public void color() throws InterruptedException {
  //color   
  Thread.sleep(1000);
  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/app-signature-properties[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
  Thread.sleep(1000);
  driver.findElement(By.xpath("//input[@class='e-hex']")).clear();
  Thread.sleep(1000);
  driver.findElement(By.xpath("//input[@class='e-hex']")).sendKeys("#000000");
  Thread.sleep(2000);
  driver.findElement(By.xpath("//button[@title='Apply']")).click();
  Thread.sleep(1000);
  }
  
  @Test(priority = 11)
  public void border_width() throws InterruptedException {
	  Thread.sleep(2000);
	  //border width
	  driver.findElement(By.name("border")).click();
	  Thread.sleep(1000);

	  driver.findElement(By.name("borderWidth")).clear();
	  driver.findElement(By.name("borderWidth")).sendKeys(border_width);
	  String actual_border_width = driver.findElement(By.name("borderWidth")).getAttribute("value");
	  Assert.assertEquals(actual_border_width, border_width);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 12)
  public void border_style() throws InterruptedException {
	//border style
	  Select select = new Select(driver.findElement(By.name("borderStyle")));
	  select.selectByIndex(6);
	  String actual_border_style = select.getFirstSelectedOption().getText();
	  System.out.println(actual_border_style);
	  Assert.assertEquals(actual_border_style, border_style);
	  Thread.sleep(1000);
  }
  
  @Test(priority = 13)
  public void padding_top() throws InterruptedException, AWTException {
	  //padding
	  driver.findElement(By.name("padding")).click();
	  Thread.sleep(1000);
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);

	  driver.findElement(By.name("paddingTop")).clear();
	  driver.findElement(By.name("paddingTop")).sendKeys(padding_top);
	  String actual_padding_top = driver.findElement(By.name("paddingTop")).getAttribute("value");
	  Assert.assertEquals(actual_padding_top, padding_top);
  }
  
  @Test(priority = 14)
  public void padding_left() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingLeft")).clear();
	  driver.findElement(By.name("paddingLeft")).sendKeys(padding_left);
	  String actual_padding_left = driver.findElement(By.name("paddingLeft")).getAttribute("value");
	  Assert.assertEquals(actual_padding_left, padding_left);
  }
  
  @Test(priority = 15)
  public void pading_bottom() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingBottom")).clear();
	  driver.findElement(By.name("paddingBottom")).sendKeys(padding_bottom);
	  String actual_padding_bottom = driver.findElement(By.name("paddingBottom")).getAttribute("value");
	  Assert.assertEquals(actual_padding_bottom, padding_bottom);
  }
  
  @Test(priority = 16)
  public void padding_right() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingRight")).clear();
	  driver.findElement(By.name("paddingRight")).sendKeys(padding_right);
	  String actual_padding_right = driver.findElement(By.name("paddingRight")).getAttribute("value");
	  Assert.assertEquals(actual_padding_right, padding_right);
  }
  
//  @Test(priority = 17)
//  public void signee() throws InterruptedException {
//	  //signee
//	  Select select1 = new Select(driver.findElement(By.name("signee")));
//	  select1.selectByValue("0: Object");
//	  String actual_signee = select1.getFirstSelectedOption().getText();
//	  String expeted_signee = "Rahul Sharma";
//	  Assert.assertEquals(actual_signee, expeted_signee);
//	  //check
//	  Thread.sleep(1000);
  //}
  
  public void resize(WebElement elementToResize, int xOffset, int yOffset) {
		try {
			if (elementToResize.isDisplayed()) {
				Actions action = new Actions(driver);
				action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + elementToResize + "is not attached to the page document "	+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + elementToResize + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to resize" + elementToResize + " - "	+ e.getStackTrace());
		}
		
	}
  
  @Test(priority = 18)
  public void Save() throws InterruptedException {
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.net/home/sections/editSection/6909");
	  
 }
  
  @Test(priority = 19)
  public void reflect_corner() {
	  driver.findElement(By.id("page1-fpSign122020154686")).click();
	  String actual_reflect_corner = driver.findElement(By.id("page1-fpSign122020154686")).getCssValue("border-radius");
	  String expected_reflect_corner = corner+"px";
	  System.out.println("Acorner "+actual_reflect_corner);
	  System.out.println("Ereflect corner "+expected_reflect_corner);
	  Assert.assertEquals(actual_reflect_corner, expected_reflect_corner);
	  
  }
  
//  @Test(priority = 20)
//  public void reflect_roate() {
//	  driver.findElement(By.id("page1-fpSign115201911423648")).click();
//	  String actual_reflect_rotate = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("transform");
//	  String expected_reflect_rotate = rotate+"px";
//	  System.out.println("Arotate "+actual_reflect_rotate);
//	  System.out.println("Ereflect rotate "+expected_reflect_rotate);
//	  Assert.assertEquals(actual_reflect_rotate, expected_reflect_rotate);
//	  
//}
  
  @Test(priority = 21)
  public void reflect_border_width() throws InterruptedException {
	  driver.findElement(By.id("page1-fpSign122020154686")).click();
	  String actual_reflect_border_width = driver.findElement(By.id("page1-fpSign122020154686")).getCssValue("border-width");
	  System.out.println("A = "+actual_reflect_border_width);
	  String expected_reflect_border_width = border_width+"px";
	  System.out.println("E "+expected_reflect_border_width);
	  Assert.assertEquals(actual_reflect_border_width, expected_reflect_border_width);
	  Thread.sleep(5000);
	  
  }
  
  @Test(priority = 22)
  public void reflect_border_style() throws InterruptedException {
	  driver.findElement(By.id("page1-fpSign122020154686")).click();
	  String actual_reflect_border_style = driver.findElement(By.id("page1-fpSign122020154686")).getCssValue("border-style");
	  System.out.println("A = "+actual_reflect_border_style);
	  String expected_reflect_border_style = border_style;
	  System.out.println("E "+expected_reflect_border_style);
	  Assert.assertEquals(actual_reflect_border_style, expected_reflect_border_style);
	  Thread.sleep(5000);
	  
  }
  
  @Test(priority = 23)
  public void reflect_padding() throws InterruptedException {
	  driver.findElement(By.id("page1-fpSign122020154686")).click();
	  String actual_reflect_padding_top = driver.findElement(By.id("page1-fpSign122020154686")).getCssValue("padding-top");
	  String actual_reflect_padding_left = driver.findElement(By.id("page1-fpSign122020154686")).getCssValue("padding-left");
	  String actual_reflect_padding_bottom = driver.findElement(By.id("page1-fpSign122020154686")).getCssValue("padding-bottom");
	  String actual_reflect_padding_right = driver.findElement(By.id("page1-fpSign122020154686")).getCssValue("padding-right");
	  System.out.println("reflect_top = "+actual_reflect_padding_top);
	  System.out.println("reflect_left = "+actual_reflect_padding_left);
	  System.out.println("reflect_bottom = "+actual_reflect_padding_bottom);
	  System.out.println("reflect_right = "+actual_reflect_padding_right);
	  String expected_reflect_padding_top = padding_top+"px";
	  String expected_reflect_padding_left = padding_left+"px";
	  String expected_reflect_padding_bottom = padding_bottom+"px";
	  String expected_reflect_padding_right = padding_right+"px";
	  
	  Assert.assertEquals(actual_reflect_padding_top, expected_reflect_padding_top);
	  Assert.assertEquals(actual_reflect_padding_left, expected_reflect_padding_left);
	  Assert.assertEquals(actual_reflect_padding_bottom, expected_reflect_padding_bottom);
	  Assert.assertEquals(actual_reflect_padding_right, expected_reflect_padding_right);
	  Thread.sleep(5000);
	  
  }
  
  @Test(priority = 24)
  public void Reset_All() throws InterruptedException, AWTException {
      Thread.sleep(1000);
	   driver.findElement(By.id("page1-fpSign122020154686")).click();
	   
	  Thread.sleep(1000);
	  driver.findElement(By.name("corners")).clear();
	  driver.findElement(By.name("corners")).sendKeys("0");
	  
	  driver.findElement(By.name("rotate")).clear();
	  driver.findElement(By.name("rotate")).sendKeys("0");
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/app-signature-properties[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@class='e-hex']")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@class='e-hex']")).sendKeys("#ffffff");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@title='Apply']")).click();
	  Thread.sleep(1000);

	  
	  driver.findElement(By.name("borderWidth")).clear();
	  driver.findElement(By.name("borderWidth")).sendKeys("0");
	  
	  Select select = new Select(driver.findElement(By.name("borderStyle")));
	  select.selectByIndex(2);
	  Thread.sleep(3000);
	  driver.findElement(By.name("border")).click();

      Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  
	  driver.findElement(By.name("paddingTop")).clear();
	  driver.findElement(By.name("paddingTop")).sendKeys("0");
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingLeft")).clear();
	  driver.findElement(By.name("paddingLeft")).sendKeys("0");
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingBottom")).clear();
	  driver.findElement(By.name("paddingBottom")).sendKeys("0");
	  Thread.sleep(1000);
	  driver.findElement(By.name("paddingRight")).clear();
	  driver.findElement(By.name("paddingRight")).sendKeys("0");
	  
	  driver.findElement(By.name("padding")).click();
	  
	  Thread.sleep(1000);
	  //color   
	 
	  
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  
  }

  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
  
}
