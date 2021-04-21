package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshproposals.selenium.Common_Methods;

public class RectangleRepositionInSection extends Common_Methods {
	//http://beta1.freshproposals.net/home/sections/editSection/6594
	WebDriver driver;
	String unm;
	String pwd;
	 SoftAssert Assert= new SoftAssert();
	 int x = 280;
	 int y = 330;
	
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
	 @Test(priority=1)
	 public void GetURL() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.get("http://beta1.freshproposals.net/home/sections/editSection/6594");
			Thread.sleep(2000);

	 }
	@Test(priority=2)
	public void Rectangleverification() throws InterruptedException {
		WebElement Rectangle = driver.findElement(By.xpath("//div[@id='page1-fpShape121920191581873']"));
		Rectangle.click();
		Thread.sleep(5000);
		Point point=Rectangle.getLocation();
		int xcord = point.getX();
		int ycord =point.getY();
		System.out.println(xcord);
		System.out.println(ycord);
		Assert.assertEquals(xcord, 325);
		Assert.assertEquals(ycord, 113);
		Actions act=new Actions(driver);	
      act.dragAndDropBy(Rectangle,x, y).build().perform();		
      Thread.sleep(3000);
     
		WebElement SaveBtn=driver.findElement(By.xpath("//button[@class='nav-link btn send-btn']"));
		SaveBtn.click();
		Thread.sleep(3000);
		WebElement BackBtn = driver.findElement(By.xpath("//button[@class='nav-link btn back-btn']"));
		BackBtn.click();
		Assert.assertAll();
	}
	@Test(priority=3)
	public void RectangleRepositionVerification() throws InterruptedException {
		driver.get("http://beta1.freshproposals.net/home/sections/editSection/6594/true");
		Thread.sleep(5000);
		WebElement Rectangle = driver.findElement(By.xpath("//div[@id='page1-fpShape121920191581873']"));
		 Point point1=Rectangle.getLocation();
	        int xcord1 = point1.getX();
			int ycord1 =point1.getY();
			//System.out.println(xcord1);
			//System.out.println(ycord1);
			Assert.assertEquals(xcord1, 718);
			Assert.assertEquals(ycord1, 443);
			Assert.assertAll();

	}
	@Test(priority=4)
	public void RectangleRepositionReset() throws InterruptedException {
		Thread.sleep(5000);

		 driver.get("http://beta1.freshproposals.net/home/sections/editSection/6594");
			Thread.sleep(5000);

		WebElement Rectangle = driver.findElement(By.xpath("//div[@id='page1-fpShape121920191581873']"));
		Rectangle.click();
		Thread.sleep(5000);
		Point point=Rectangle.getLocation();
		int xcord = point.getX();
		int ycord =point.getY();
		//System.out.println(xcord);
		//System.out.println(ycord);
		Assert.assertEquals(xcord, 605);
		Assert.assertEquals(ycord, 443);
		Actions act=new Actions(driver);	
      act.dragAndDropBy(Rectangle,-x, -y).build().perform();		
      Thread.sleep(3000);
     
		WebElement SaveBtn=driver.findElement(By.xpath("//button[@class='nav-link btn send-btn']"));
		SaveBtn.click();
		Thread.sleep(4000);
		WebElement BackBtn = driver.findElement(By.xpath("//button[@class='nav-link btn back-btn']"));
		BackBtn.click();
		Assert.assertAll();
		
	}
	
	
	
@AfterClass
public void teardown() {
	driver.quit();
}
	



}
