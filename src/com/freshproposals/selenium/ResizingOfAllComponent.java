package com.freshproposals.selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshproposals.selenium.Common_Methods;

public class ResizingOfAllComponent extends Common_Methods{
	WebDriver driver;
	String unm;
	String pwd;
	SoftAssert softAssertion= new SoftAssert();

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
	 @Test(priority=0)
	 public void GetUrl() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1267");

	 }
	 @Test(priority=1)
	 public void ResizeTextComponent() throws InterruptedException {
		 WebElement textblock =driver.findElement(By.id("page1-fpText1218201910165868"));
		 textblock.click();
			int WidthBefore = textblock.getSize().getWidth();
			int HeightBefore = textblock.getSize().getHeight();     
			softAssertion.assertEquals(WidthBefore,50);
		 	softAssertion.assertEquals(HeightBefore, 50);
		 	softAssertion.assertAll();
	 }
	 @Test(priority=2)
	 	public void resizetext() throws InterruptedException {
		 WebElement textblock =driver.findElement(By.id("page1-fpText1218201910165868"));
		 textblock.click();
			WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='segrip']"));
			resize( shapeResize, 250, 400);
			WebElement savebtn =  driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			savebtn.click();
			Thread.sleep(4000);
			WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav ng-star-inserted']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
			BackBtn.click();
			Thread.sleep(4000);
		 
	 }
	 @Test(priority=3)
	 public void Resizetextverification() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1267");
		Thread.sleep(5000);
		 WebElement textblock =driver.findElement(By.id("page1-fpText1218201910165868"));
		 textblock.click();
		 int Width = textblock.getSize().getWidth();
		 int Height = textblock.getSize().getHeight();  
		 softAssertion.assertEquals(Width,300);
		 softAssertion.assertEquals(Height,450);
		 softAssertion.assertAll();
	 }
	 
	 @Test(priority=4)
		public void Resizeback() throws InterruptedException {
			 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1267");
			 WebElement textblock =driver.findElement(By.id("page1-fpText1218201910165868"));
			  Actions action = new Actions(driver);
				int WidthBefore = textblock.getSize().getWidth();
				int HeightBefore = textblock.getSize().getHeight();        
				softAssertion.assertEquals(WidthBefore,300);
				 softAssertion.assertEquals(HeightBefore,450);
				action.moveToElement(textblock).perform();
				textblock.click();
				WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='segrip']"));
				resize( shapeResize, -250, -400);
				Thread.sleep(2000);
				WebElement savebtn =  driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
				savebtn.click();
				Thread.sleep(5000);
				int Width = textblock.getSize().getWidth();
				int Height = textblock.getSize().getHeight();   
				softAssertion.assertEquals(Width,50);
				softAssertion.assertEquals(Height,50);
				WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav ng-star-inserted']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
				BackBtn.click();
				Thread.sleep(2000);
				
			
		}
	
		 	@Test(priority=5)
	 	public void ResizeImage() throws InterruptedException {
				 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1267");

	 		WebElement SectionClick = driver.findElement(By.xpath("//a[contains(text(),'SeleniumImageResizeSection')]"));
	 		SectionClick.click();
	 		Thread.sleep(2000);
	 		WebElement Image = driver.findElement(By.xpath("//div[@id='page1-fpImage12182019115918']//img"));
	 		Image.click();
	 		Thread.sleep(2000);
	 		WebElement ImageResize = driver.findElement(By.xpath("//div[@id='page1-fpImage12182019115918']//div[@id='sgrip']"));
	 		resize( ImageResize,0 , 222);
	 		Thread.sleep(5000);
	 		WebElement savebtn =  driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			savebtn.click();
			Thread.sleep(3000);
			WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav ng-star-inserted']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
			BackBtn.click();
			Thread.sleep(5000);
	 			
	 	}
	 	@Test(priority=6)
	 	public void ResizeImageVerification() throws InterruptedException {
			 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1267");
			Thread.sleep(5000);
	 		WebElement SectionClick = driver.findElement(By.xpath("//a[contains(text(),'SeleniumImageResizeSection')]"));
	 		SectionClick.click();
	 		Thread.sleep(3000);
	 		WebElement Image = driver.findElement(By.xpath("//div[@id='page1-fpImage12182019115918']//img"));
	 		Image.click();
	 		Thread.sleep(2000);
	 		int WidthBefore = Image.getSize().getWidth();
			int HeightBefore = Image.getSize().getHeight();  
			//System.out.println(WidthBefore);
			//System.out.println(HeightBefore);
			softAssertion.assertEquals(WidthBefore,225);
		 	softAssertion.assertEquals(HeightBefore, 372);
		 	softAssertion.assertAll();
	 	}
	 	@Test(priority=7)
	 	public void ResizeImage2() throws InterruptedException {
	 		WebElement SectionClick = driver.findElement(By.xpath("//a[contains(text(),'SeleniumImageResizeSection')]"));
	 		SectionClick.click();
	 		Thread.sleep(2000);
	 		WebElement Image = driver.findElement(By.xpath("//div[@id='page1-fpImage12182019115918']//img"));
	 		Image.click();
	 		Thread.sleep(2000);
	 		WebElement ImageResizeTopCorner = driver.findElement(By.xpath("//div[@id='page1-fpImage12182019115918']//div[@id='nwgrip']"));
			resize( ImageResizeTopCorner,37 , 96);
			Thread.sleep(2000);
	 		WebElement savebtn =  driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			savebtn.click();
			Thread.sleep(5000);
			WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav ng-star-inserted']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
			BackBtn.click();
			Thread.sleep(5000);
	 		
	 	}
	 	@Test(priority=8)
	 	public void ResizeImage2Verification() throws InterruptedException {
			 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1267");
			Thread.sleep(3000);
	 		WebElement SectionClick = driver.findElement(By.xpath("//a[contains(text(),'SeleniumImageResizeSection')]"));
	 		SectionClick.click();
	 		Thread.sleep(2000);
	 		WebElement Image = driver.findElement(By.xpath("//div[@id='page1-fpImage12182019115918']//img"));
	 		Image.click();
	 		Thread.sleep(2000);
	 		int WidthBefore = Image.getSize().getWidth();
			int HeightBefore = Image.getSize().getHeight();  
			//System.out.println(WidthBefore);
			//System.out.println(HeightBefore);
			softAssertion.assertEquals(WidthBefore,188);
			softAssertion.assertEquals(HeightBefore, 276);
			softAssertion.assertAll();
	 	}
	 	@Test(priority=9)
	 	public void ImageReResize() throws InterruptedException {
	 		WebElement SectionClick = driver.findElement(By.xpath("//a[contains(text(),'SeleniumImageResizeSection')]"));
	 		SectionClick.click();
	 		Thread.sleep(2000);
	 		WebElement Image = driver.findElement(By.xpath("//div[@id='page1-fpImage12182019115918']//img"));
	 		Image.click();
	 		Thread.sleep(2000);
	 		WebElement ImageResize = driver.findElement(By.xpath("//div[@id='page1-fpImage12182019115918']//div[@id='sgrip']"));
	 		resize( ImageResize,0 , -222);
	 		Thread.sleep(5000);
	 		WebElement savebtn =  driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			savebtn.click();
			Thread.sleep(3000);
		
	 		Image.click();

	 		WebElement ImageResizeTopCorner = driver.findElement(By.xpath("//div[@id='page1-fpImage12182019115918']//div[@id='nwgrip']"));
			resize( ImageResizeTopCorner,-37 , -96);
			Thread.sleep(5000);
			savebtn.click();
			
			int WidthBefore = Image.getSize().getWidth();
			int HeightBefore = Image.getSize().getHeight();  
//			System.out.println(WidthBefore);
//			System.out.println(HeightBefore);
			softAssertion.assertEquals(WidthBefore,225);
		 	softAssertion.assertEquals(HeightBefore, 150);
		 	softAssertion.assertAll();
			
			Thread.sleep(5000);
	 	}
	 	@Test(priority=10)
	 	public void RectangleResize() throws InterruptedException {
	 		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1267");
	 		 Thread.sleep(5000);
	 	WebElement Section3 = driver.findElement(By.xpath("//a[contains(text(),'SeleniumRectangleResizeSection')]"));
	 	Section3.click();
	 	Thread.sleep(2000);
 		WebElement Rectangle = driver.findElement(By.xpath("//div[@id='page1-fpShape1218201912114789']//div[@oncontextmenu]"));
 		Rectangle.click();
 		int WidthBefore = Rectangle.getSize().getWidth();
		int HeightBefore = Rectangle.getSize().getHeight();  
		//System.out.println(WidthBefore);
		//System.out.println(HeightBefore);
		softAssertion.assertEquals(WidthBefore,171);
	 	softAssertion.assertEquals(HeightBefore, 50);
 		Thread.sleep(2000);
 		WebElement RectResize = driver.findElement(By.xpath("//div[@id='page1-fpShape1218201912114789']//div[@id='segrip']"));
 		resize( RectResize,113, 353);
 		Thread.sleep(3000);
 		WebElement savebtn =  driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		savebtn.click();
		Thread.sleep(3000);
		WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav ng-star-inserted']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
		//BackBtn.click();
		Thread.sleep(3000);
		BackBtn.click();
		Thread.sleep(5000);
		softAssertion.assertAll();
		
	 	}
	 	@Test(priority=11)
	 	public void Rect1Verify() throws InterruptedException {
	 		//driver.findElement(By.xpath("//div[2]//div[1]//div[2]//a[1]//img[1]")).click();
	 		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1267");

			Thread.sleep(5000);
			WebElement Rectangle = driver.findElement(By.xpath("//div[@id='page1-fpShape1218201912114789']//div[@oncontextmenu]"));
	 		Rectangle.click();
	 		int WidthAfterResizing = Rectangle.getSize().getWidth();
			int HeightAfterResizing = Rectangle.getSize().getHeight();  
			//System.out.println(WidthAfterResizing);
			//System.out.println(HeightAfterResizing);
			softAssertion.assertEquals(WidthAfterResizing,284);
		 	softAssertion.assertEquals(HeightAfterResizing,403);
	 		Thread.sleep(3000);
			softAssertion.assertAll();

	 		
	 	}
	 	
	 	
	 	@Test(priority=12)
	 	public void Rect2() throws InterruptedException {
	 		Thread.sleep(5000);
	 		WebElement Section3 = driver.findElement(By.xpath("//a[contains(text(),'SeleniumRectangleResizeSection')]"));
		 	Section3.click();
		 	Thread.sleep(2000);
	 		WebElement Rectangle = driver.findElement(By.xpath("//div[@id='page1-fpShape1218201912114789']//div[@oncontextmenu]"));
	 		Rectangle.click();
			Thread.sleep(2000);
	 		WebElement RectResize2 = driver.findElement(By.xpath("//div[@id='page1-fpShape1218201912114789']//div[@id='wgrip']"));
	 		resize( RectResize2,121,0);
	 		Thread.sleep(1000);
	 		WebElement savebtn =  driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav ng-star-inserted']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
			savebtn.click();
	 		Thread.sleep(5000);
	 		BackBtn.click();
	 		Thread.sleep(5000);

	 		
	 	}
	 	@Test(priority=13)
	 	public void RectangleResizeVerification() throws InterruptedException {
	 		//driver.findElement(By.xpath("//div[2]//div[1]//div[2]//a[1]//img[1]")).click();
	 		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1267");

			Thread.sleep(3000);
			WebElement Rectangle = driver.findElement(By.xpath("//div[@id='page1-fpShape1218201912114789']//div[@oncontextmenu]"));
	 		Rectangle.click();
	 		int WidthAfterResizing = Rectangle.getSize().getWidth();
			int HeightAfterResizing = Rectangle.getSize().getHeight();  
			System.out.println(WidthAfterResizing);
			System.out.println(HeightAfterResizing);
			softAssertion.assertEquals(WidthAfterResizing,163);
		 	softAssertion.assertEquals(HeightAfterResizing,403);
	 		Thread.sleep(3000);
			softAssertion.assertAll();

	 	}
	 	
	 	@Test(priority=14)
	 	public void RectangleReResize() throws InterruptedException {
	 		WebElement Section3 = driver.findElement(By.xpath("//a[contains(text(),'SeleniumRectangleResizeSection')]"));
		 	Section3.click();
		 	Thread.sleep(5000);
	 		WebElement Rectangle = driver.findElement(By.xpath("//div[@id='page1-fpShape1218201912114789']//div[@oncontextmenu]"));
	 		Rectangle.click();
	 		int WidthBefore = Rectangle.getSize().getWidth();
			int HeightBefore = Rectangle.getSize().getHeight();  
			//System.out.println(WidthBefore);
			//System.out.println(HeightBefore);
			softAssertion.assertEquals(WidthBefore,163);
		 	softAssertion.assertEquals(HeightBefore,403);
	 		Thread.sleep(2000);
	 		WebElement RectResize = driver.findElement(By.xpath("//div[@id='page1-fpShape1218201912114789']//div[@id='segrip']"));
	 		resize( RectResize,-113, -353);
	 		Thread.sleep(3000);
	 		WebElement savebtn =  driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			savebtn.click();
			Thread.sleep(3000);
			int WidthAfterResizing = Rectangle.getSize().getWidth();
			int HeightAfterResizing = Rectangle.getSize().getHeight();  
			//System.out.println(WidthAfterResizing);
			//System.out.println(HeightAfterResizing);
			softAssertion.assertEquals(WidthAfterResizing,50);
		 	softAssertion.assertEquals(HeightAfterResizing,50);
			//Thread.sleep(3000);
			Rectangle.click();
			Thread.sleep(2000);
	 		WebElement RectResize2 = driver.findElement(By.xpath("//div[@id='page1-fpShape1218201912114789']//div[@id='wgrip']"));
	 		resize( RectResize2,-121,0);
	 		Thread.sleep(3000);
			savebtn.click();
	 		Thread.sleep(3000);	
			int WidthAfterReresizing = Rectangle.getSize().getWidth();
			int HeightAfterReresizing = Rectangle.getSize().getHeight();  
			//System.out.println(WidthAfterReresizing);
			//System.out.println(HeightAfterReresizing);
			softAssertion.assertEquals(WidthAfterReresizing,171);
		 	softAssertion.assertEquals(HeightAfterReresizing,50);
			Thread.sleep(3000);
			softAssertion.assertAll();

	 	}
		public void resize(WebElement shapeResize, int xOffset, int yOffset) {
			try {
				if (shapeResize.isDisplayed()) {
					Actions action = new Actions(driver);
					action.clickAndHold(shapeResize).moveByOffset(xOffset, yOffset).release().build().perform();
				} else {
					System.out.println("Element was not displayed to drag");
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Element with " + shapeResize + "is not attached to the page document "	+ e.getStackTrace());
			} catch (NoSuchElementException e) {
				System.out.println("Element " + shapeResize + " was not found in DOM " + e.getStackTrace());
			} catch (Exception e) {
				System.out.println("Unable to resize" + shapeResize+ " - "	+ e.getStackTrace());
			}
		}
		@AfterClass
		public void teardown() {
			driver.quit();
		}
}
