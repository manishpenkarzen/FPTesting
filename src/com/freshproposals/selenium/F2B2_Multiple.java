package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class F2B2_Multiple extends Common_Methods {
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
		openURL(driver);	}
  
  @Test(dataProvider = "User1", priority = 0)
 	public void SetUnmPwd(String unm, String pwd) {
     login(unm, pwd, driver);
 }
 
 @Test(priority = 1)
 public void Backward() throws InterruptedException {
	 Thread.sleep(5000);
	 driver.get("https://beta.freshproposals.net/home/templates/editTemplate/30266");
	 Thread.sleep(2000);
	 Actions action = new Actions(driver);
	 
	 System.out.println("1");
	 String B_Backward_Text = driver.findElement(By.xpath("//div[@id='page1-fpText121620201255250mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Backward Text "+B_Backward_Text);
	 String B_Backward_Img = driver.findElement(By.xpath("//div[@id='page1-fpImage1216202012544671mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Backward Text, Img "+B_Backward_Img);
	 
	 action.contextClick(driver.findElement(By.xpath("//div[@class='fr-element fr-view']"))).perform();
	 Thread.sleep(1000);
	 //driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Send a step backward')]")).click();
	 
	 String A_Backward_Text = driver.findElement(By.xpath("//div[@id='page1-fpText121620201255250mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Backward Text "+A_Backward_Text);
	 String A_Backward_Img = driver.findElement(By.xpath("//div[@id='page1-fpImage1216202012544671mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Backward Text, Img "+A_Backward_Img);
	 
	 int text = Integer.parseInt(A_Backward_Text);
     int img = Integer.parseInt(A_Backward_Img);
     
     Assert.assertTrue(img>text);
     
	 }
 
 @Test(priority = 2)
 public void Back() throws InterruptedException {
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 
	 System.out.println("2");
	 String B_Back_Img = driver.findElement(By.xpath("//div[@id='page1-fpImage1216202012544671mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Back Img "+B_Back_Img);
	 String B_Back_Text = driver.findElement(By.xpath("//div[@id='page1-fpText121620201255250mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Back Img, Text "+B_Back_Text);
	 
	 
	 action.contextClick(driver.findElement(By.xpath("//div[@class='resizers']//img"))).perform();
	 Thread.sleep(1000);
	 //driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Send to back')]")).click();
	 
	 String A_Back_Img = driver.findElement(By.xpath("//div[@id='page1-fpImage1216202012544671mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Back Img "+A_Back_Img);
	 String A_Back_Text = driver.findElement(By.xpath("//div[@id='page1-fpText121620201255250mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Back Img, Text "+A_Back_Text);
	 
	 int text = Integer.parseInt(A_Back_Text);
     int img = Integer.parseInt(A_Back_Img);
     
     Assert.assertTrue(text>img);
	 }
 
 @Test(priority = 3)
 public void Forward() throws InterruptedException {
	 Thread.sleep(2000);
	//second page click
	 driver.findElement(By.xpath("//a[@id='sectionLink43247']")).click();
	 
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 
	 System.out.println("3");
	 String B_Forward_Sign = driver.findElement(By.xpath("//div[@id='section1216202020242471-page1-fpSign1216202020373045mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Forward Sign "+B_Forward_Sign);
	 String B_Forward_Img = driver.findElement(By.xpath("//div[@id='section1216202020242471-page1-fpImage121620202037972mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("Before Forward Sign, Img "+B_Forward_Img);
	 action.contextClick(driver.findElement(By.xpath("//div[@id='fpSign1216202020373045']"))).perform();
	 Thread.sleep(1000);
	 //driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//li[contains(text(),'Bring a step forward')]")).click();
	 
	 String A_Forward_Sign = driver.findElement(By.xpath("//div[@id='section1216202020242471-page1-fpSign1216202020373045mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Forward Sign "+A_Forward_Sign);
	 String A_Forward_Img = driver.findElement(By.xpath("//div[@id='section1216202020242471-page1-fpImage121620202037972mainDivTransformSafeStyle']")).getCssValue("z-index");
	 System.out.println("After Forward Sign, Img "+A_Forward_Img);
	 
	 int sign = Integer.parseInt(A_Forward_Sign);
     int img = Integer.parseInt(A_Forward_Img);
     
     Assert.assertTrue(sign>img);
	 
	 }
 
// @Test(priority = 4)
// public void Front() throws InterruptedException {
//	 Thread.sleep(1000);
//	 Actions action = new Actions(driver);
//	 
//	 System.out.println("4");
//	 String B_Front_Img = driver.findElement(By.xpath("//div[@id='page2-fpSign103120191444833mainDivTransformSafeStyle']")).getCssValue("z-index");
//	 System.out.println("Before Front Img "+B_Front_Img);
//	 String B_Front_Sign = driver.findElement(By.xpath("//div[@id='page2-fpImage1031201914441969mainDivTransformSafeStyle']")).getCssValue("z-index");
//	 System.out.println("Before Front Img, Sign "+B_Front_Sign);
//	 
//	 action.contextClick(driver.findElement(By.xpath("//div[@id='page2-fpImage1031201914441969']//div[@class='resizers']"))).perform();
//	 Thread.sleep(1000);
//	 //driver.findElement(By.xpath("//button[contains(text(),'Position')]")).click();
//	 Thread.sleep(1000);
//	 driver.findElement(By.xpath("//li[contains(text(),'Bring to front')]")).click();
//	 
//	 String A_Front_Img = driver.findElement(By.xpath("//div[@id='page2-fpSign103120191444833mainDivTransformSafeStyle']")).getCssValue("z-index");
//	 System.out.println("After Front Img "+A_Front_Img);
//	 String A_Front_Sign = driver.findElement(By.xpath("//div[@id='page2-fpImage1031201914441969mainDivTransformSafeStyle']")).getCssValue("z-index");
//	 System.out.println("After Front Img, Sign "+A_Front_Sign);
//	 
//	 int sign = Integer.parseInt(A_Front_Sign);
//     int img = Integer.parseInt(A_Front_Img);
//     
//     Assert.assertTrue(sign>img);
//	 
//	 
//	 }
// 

@AfterClass
public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
}
}
