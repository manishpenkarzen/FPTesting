package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Template_TextBox_2 extends Common_Methods{
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
		  driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1372");
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		
	  }
	
	@Test(priority = 2)
	  public void color() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-text-properties[1]/form[1]/div[1]/div[1]/div[1]/ngb-accordion[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
	    Thread.sleep(1000);
	    //driver.findElement(By.xpath("//div[@class='e-hue-slider e-control e-slider e-lib']//div[@class='e-handle e-handle-first']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.className("e-hsv-color")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@title='Apply']")).click();
	    
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	}
	
	@Test(priority = 3)
	  public void corner() throws InterruptedException {
		Thread.sleep(2000);
		//driver.findElement(By.name("corners")).click();
		WebElement r = driver.findElement(By.name("corners"));
		resize(r, -50, -50);
		
	}
	
	@Test(priority = 4)
	  public void advance() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		driver.findElement(By.name("cornersSelected")).click();
		Thread.sleep(2000);
		WebElement r = driver.findElement(By.name("cornerTopLeft"));
		WebElement r1 = driver.findElement(By.name("cornerTopRight"));
		WebElement r2 = driver.findElement(By.name("cornerBottomLeft"));
		//WebElement r3 = driver.findElement(By.name("cornerBottomRight"));
		Thread.sleep(2000);
		resize(r, 100, 100);
		resize(r1, -100, -100);
		resize(r2, -100, -100);
		//resize(r3, 50, 50);
		
	}
	
	@Test(priority = 5)
	  public void gradient() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		driver.findElement(By.name("gradient")).click();
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	    Thread.sleep(2000);
	    //circular
	    driver.findElement(By.xpath("//body/app-root/app-home/div[@class='wrapper']/div/div[@class='fixed-sidebar col-lg-2 offset-lg-10 p-0 right-zero']/div[@class='sidebar-editor-right']/div/div[@class='col-lg-12 p-0']/div[@class='pro-create']/app-text-properties/form[@name='propForm1']/div/div[@class='card text-box-prop']/div[@class='card-body properties-box setting-toollist p-0']/ngb-accordion[@class='accordion']/div[@class='card']/div[@id='config-panel-one']/div[@class='card-body']/div[@class='col-lg-12']/div[@class='row']/div[2]/div[1]/input[1]")).click();
		
	}
	
	@Test(priority = 6)
	  public void Save() throws InterruptedException {
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		  Thread.sleep(3000);
		  driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1372");
		  
	 }
	
	@Test(priority = 7)
	   public void Reset() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("froalapage1-fpText1230201916285735")).click();
		Thread.sleep(1000);
		//corner
		WebElement rc = driver.findElement(By.name("corners"));
		resize(rc, -100, -100);
		
		//advance
		
		Thread.sleep(2000);
		WebElement r = driver.findElement(By.name("cornerTopLeft"));
		WebElement r1 = driver.findElement(By.name("cornerTopRight"));
		WebElement r2 = driver.findElement(By.name("cornerBottomLeft"));
		WebElement r3 = driver.findElement(By.name("cornerBottomRight"));
		Thread.sleep(2000);
		resize(r, 10, 10);
		resize(r1, 10, 10);
		resize(r2, 10, 10);
		resize(r3, 10, 10);
		
		driver.findElement(By.name("cornersSelected")).click();
		
		//linear
		driver.findElement(By.xpath("//body/app-root/app-home/div[@class='wrapper']/div/div[@class='fixed-sidebar col-lg-2 offset-lg-10 p-0 right-zero']/div[@class='sidebar-editor-right']/div/div[@class='col-lg-12 p-0']/div[@class='pro-create']/app-text-properties/form[@name='propForm1']/div/div[@class='card text-box-prop']/div[@class='card-body properties-box setting-toollist p-0']/ngb-accordion[@class='accordion']/div[@class='card']/div[@id='config-panel-one']/div[@class='card-body']/div[@class='col-lg-12']/div[@class='row']/div[1]/div[1]/input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("gradient")).click();
		
		//color
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-text-properties[1]/form[1]/div[1]/div[1]/div[1]/ngb-accordion[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//span[@class='e-handler']")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//button[@title='Apply']")).click();
	    
	    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	    Thread.sleep(3000);
	    driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1372");
		
		
		
	}
	
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
	
	
	@AfterClass
	  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
	}
}
