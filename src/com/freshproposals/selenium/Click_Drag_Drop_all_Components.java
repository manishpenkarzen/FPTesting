package com.freshproposals.selenium;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshproposals.selenium.Common_Methods;

public class Click_Drag_Drop_all_Components extends Common_Methods {
	
	WebDriver driver;
	WebDriverWait wait;
	String unm;
	String pwd;

	
	 @BeforeClass
	  public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", "E:\\FreshPraposal\\Freshproposals_Testing\\Freshproposals_Testing\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 20);
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
	  public void openExistData() throws InterruptedException {
		  Thread.sleep(10000);
		  //driver.get("https://beta.freshproposals.net/home/proposals/editProposal;proposalId=1547;editor=true");
		  createProposal(driver,wait);
		  proposalName(driver,wait);
		  client(driver,wait);
		  scrollWindow(driver);
		  calender(driver,wait);
		 
		  Thread.sleep(5000);
	 }
	 
	 @Test(priority = 2)
	 public void dragDropTextBox(){
		 driver.findElement(By.xpath("//li[@id='Text']")).click();
	 }
	 
	 @Test(priority = 3)
	 public void deleteTextBox() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../../../assets/delete-icon.svg']")).click();
	 }
	 
	 @Test(priority = 4)
	 public void dragDropcontentTable() throws InterruptedException{
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//li[@id='ContentTableV5']")).click();
	 }
	 
	 @Test(priority = 5)
	 public void deleteContentTable() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/delete-icon.svg']")).click();
	 }
	 
	 @Test(priority = 6)
	 public void dragDropFeesTable() throws InterruptedException{
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//li[@id='Fees']")).click();
	 }
	 
	 @Test(priority = 7)
	 public void deleteFeesTable() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/delete-icon.svg']")).click();
	 }
	 
	 @Test(priority = 8)
	 public void dragDropSignature() throws InterruptedException{
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//li[@id='Signature']")).click();
	 }
	 
	 @Test(priority = 9)
	 public void deleteSignature() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/delete-icon.svg']")).click();
	 }
	 
	 @Test(priority = 10)
	 public void dragDropRectangle() throws InterruptedException{
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/square-icon.png']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//p[contains(text(),'Rectangle')]")).click();
	 }
	 
	 @Test(priority = 11)
	 public void deleteRectangle() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/delete-icon.svg']")).click();
	 }
	 
	 @Test(priority = 12)
	 public void dragDropEllipse() throws InterruptedException{
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/square-icon.png']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//p[contains(text(),'Ellipse')]")).click();
	 }
	 
	 @Test(priority = 13)
	 public void deleteEllipse() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/delete-icon.svg']")).click();
	 }
	 
	 @Test(priority = 14)
	 public void dragDropLine() throws InterruptedException{
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/square-icon.png']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//p[contains(text(),'Line')]")).click();
	 }
	 
	 @Test(priority = 15)
	 public void deleteLine() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/delete-icon.svg']")).click();
	 }
	 
	 @Test(priority = 16)
	 public void dragDropSquare() throws InterruptedException{
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/square-icon.png']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//p[contains(text(),'Square')]")).click();
	 }
	 
	 @Test(priority = 17)
	 public void deleteSquare() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/delete-icon.svg']")).click();
	 }
	 
	 @Test(priority = 18)
	 public void dragDropCircle() throws InterruptedException{
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/square-icon.png']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//p[contains(text(),'Circle')]")).click();
	 }
	 
	 @Test(priority = 19)
	 public void deleteCircle() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/delete-icon.svg']")).click();
	 }
	 
	 @Test(priority = 20)
	 public void dragDropTriangle() throws InterruptedException{
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/square-icon.png']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//p[contains(text(),'Triangle')]")).click();
	 }
	 
	 @Test(priority = 21)
	 public void deleteTriangle() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='../../assets/delete-icon.svg']")).click();
	 }
	 
	 
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
	  quitBrowser(driver);
	}
	 

	
	
	
	
	

}
