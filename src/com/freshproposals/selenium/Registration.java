package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Registration extends Common_Methods {
	WebDriver driver;
	
	String unm;
	String pwd;
  
	 @BeforeClass
	  public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", "E:\\FreshPraposal\\Freshproposals_Testing\\Freshproposals_Testing\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(95, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(95,TimeUnit.SECONDS);
			long start = System.currentTimeMillis();
			openURL(driver);

			long finish = System.currentTimeMillis();
			long totalTime = finish - start; 
			System.out.println("Total Time for page load - "+totalTime); 
		}
	  
	 @Test(priority = 1)
	  public void signUp() throws InterruptedException {
		 Thread.sleep(3000);
		 driver.findElement(By.linkText("Sign Up")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.id("email")).sendKeys("merana.amrahulkhannahai@gmail.com.@gmail.com");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 }
	 
//	 
//	 @Test(priority = 2)
//	 public void Gmail_login() throws InterruptedException {
//		 Thread.sleep(2000);
//		 driver.get("https://accounts.google.net/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
//         
//		 driver.findElement(By.name("identifier")).sendKeys("zenincloud@gmail.com");
//         String actual_name = driver.findElement(By.name("identifier")).getAttribute("value");
//         String expected_name = "zenincloud@gmail.com";
//         Assert.assertEquals(actual_name, expected_name);
//         Thread.sleep(3000);
//		 driver.findElement(By.id("identifierNext")).click();
//		 Thread.sleep(3000);
//		 driver.findElement(By.name("password")).sendKeys("ZenInCloud@123");
//		 String actual_password = driver.findElement(By.name("password")).getAttribute("value");
//		 String expected_password = "ZenInCloud@123";
//		 Assert.assertEquals(actual_password, expected_password);
//		 driver.findElement(By.id("passwordNext")).click();
//	 }
//	 
//	 @Test(priority = 3)
//	 public void Search() throws InterruptedException, AWTException {
//		 Thread.sleep(2000);
//		 driver.findElement(By.name("q")).sendKeys("Welcome to Fresh Proposals!" + Keys.ENTER);
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/table[1]/tbody[1]/tr[1]")).click();
//		 Thread.sleep(2000);
//		 driver.findElement(By.linkText("Confirm your email")).click();
//	 }
//	 
//	 @Test(priority = 4)
//	 public void form() throws InterruptedException {
//		 Thread.sleep(2000);
//		 driver.get("http://beta1.freshproposals.net/auth/signup/Confirm/zenincloud.@gmail.net/8751fdfd-65ec-49c7-ae18-46e219a62e57");
//		 Thread.sleep(3000);
//		 driver.findElement(By.id("FName")).sendKeys("Rahul");
//		 
//		 driver.findElement(By.id("Name")).sendKeys("Khanna");
//		 
//		 driver.findElement(By.id("Company Name1")).sendKeys("QWERTY");
//		 
//		 driver.findElement(By.id("ContactNumber")).sendKeys("9878676567");
//		 
//		 Select number = new Select(driver.findElement(By.id("NoOfProposals")));
//		 number.selectByVisibleText("50+");
//		 
//		 Select industry = new Select(driver.findElement(By.id("Industry")));
//		 industry.selectByVisibleText("IT Services");
//		 
//		 driver.findElement(By.id("SubDomainURL")).sendKeys("myoffc");
//		 
//		 driver.findElement(By.id("Password")).sendKeys("Rahulkhanna@123");
//		 
//		 driver.findElement(By.id("Accept")).click();
//		 Thread.sleep(5000);
//		 
//	 }
//	 
//	 @Test(dataProvider = "User1", priority = 0)
//	 public void SetUnmPwd(String unm, String pwd) {
//         login(unm, pwd, driver);
//	 }
//	 @Test(priority = 5)
//	 public void dd() throws InterruptedException {
//		 Thread.sleep(5000);
//		 
//		 driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=5861;editor=true");
//		 Thread.sleep(15000);
//		 Actions act = new Actions(driver);
//		 
//		 WebElement from = driver.findElement(By.id("Text"));
//		 WebElement to =driver.findElement(By.xpath("//div[@id='sectionPage_17144page1']//div[@class='default-rectangle']"));
//		 act.dragAndDrop(from, to).build().perform();
//		 
//	 }
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
		 quitBrowser(driver);
	}
}
