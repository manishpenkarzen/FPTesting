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

public class Signature_Proposal extends Common_Methods {
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
  public void open_Proposal() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1109;editor=true");
	  Thread.sleep(3000);
	  driver.findElement(By.id("page1-fpSign115201911423648")).click();
	  }
  
  @Test(priority = 2)
  public void ExtendsMethods() throws InterruptedException, AWTException {
	signatureWidth(driver);
    signatureHeight(driver);
    save(driver);
	back(driver);
    driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1109;editor=true");
    signatureReflectWidth(driver);
    signatureReflectHeight(driver);
    signatureResetHeightWidth(driver);
    signatureCorner(driver);
    signatureRotate(driver);
    signatureColor(driver);
    signatureBorderWidth(driver);
    signatureBorderStyle(driver);
    signaturePaddingTtop(driver);
    signaturePaddingLleft(driver);
    signaturePadingBottom(driver);
    signaturePaddingRight(driver);
    signatureSignee(driver); 
    save(driver);
    back(driver);
    driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1109;editor=true");
    signatureReflectCorner(driver);
    signatureReflectBorderWidth(driver);
    signatureReflectBorderStyle(driver);
	signatureReflectPadding(driver);
    signatureResetAll(driver); 
    }

  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
    quitBrowser(driver);
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
  
}
