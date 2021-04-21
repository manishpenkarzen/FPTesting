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

public class Rectangle_Properties_Proposal extends Common_Methods {
	SoftAssert softAssertion= new SoftAssert();

	WebDriver driver;
	WebDriverWait wait;
	String unm;
	String pwd;

	String width_value = "500";
	String height_value = "300";
	String rotate_value = "5";
//	String border_width = "10";
//	String border_style = "inset";
	String padding_top_value = "30";
	String padding_left_value = "30";
	String padding_bottom_value = "30";
	String padding_right_value = "30";
	String horizontal_value = "100";
	String vertical_value = "100";
	String blur_radius_value = "100";
	String spread_radius_value = "100";
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
		  existingDataProposal1(driver, wait);
		  WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='search section']")));
		  search.click();
		  search.sendKeys("Rectangle_Properties_Automation");
		  existingDaraProposal2(driver,wait);
		  Thread.sleep(5000);
	 }
	 
	 @Test(priority = 2)
	  public void width() {
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resizers']"))).click();
		  WebElement width = driver.findElement(By.name("textWidth11"));
		  width.clear();
		  width.sendKeys(width_value);
	      String actual_width = width.getAttribute("value");
	      Assert.assertEquals(actual_width, width_value);
}
	  
	  @Test(priority = 3)
     public void height() {
		  WebElement height = driver.findElement(By.name("height11"));
		  height.clear();
		  height.sendKeys(height_value);
		  String actual_height = height.getAttribute("value");
		  Assert.assertEquals(actual_height,height_value);
	  }
	  
	  @Test(priority = 3)
	  public void rotate() throws InterruptedException, AWTException {
		  WebElement rotate = wait.until(ExpectedConditions.elementToBeClickable(By.name("rotate")));
		  rotate.clear();
		  rotate.sendKeys(rotate_value);
		  String actual_rotate = rotate.getAttribute("value");
		  String expected_rotate = rotate_value;
		  Assert.assertEquals(actual_rotate,expected_rotate);
	 }
	  
	    @Test(priority = 4)
	    public void background_color() throws InterruptedException {
	    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='e-btn-icon e-icons e-caret']"))).click();
	    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='e-hsv-color']"))).click();
	    }
	    
	    @Test(priority = 5)
	    public void gradient() throws InterruptedException {
	    	wait.until(ExpectedConditions.elementToBeClickable(By.name("gradient"))).click();
	    }
	    
	    @Test(priority = 6)
	    public void circular() throws InterruptedException {
	    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='circularGradient']"))).click();
	    }
	    
		@Test(priority = 7)
	    public void opacity() throws InterruptedException {
			WebElement opacity = driver.findElement(By.name("opacity"));
			resize(opacity,50,50, driver);
//			  String actual_opacity = driver.findElement(By.name("opacity")).getAttribute("value");
//			  String expected_opacity = "64";
//			  Assert.assertEquals(actual_opacity, expected_opacity);
//			  System.out.println(actual_opacity);
			  
	   }

	    
	   @Test(priority = 8)
	  public void border_click() {
		  //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='static-1-header']//button[@class='btn collapsiable-card-arrow collapsed']"))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(collapse[0] + collapse[1] + collapse[4] + collapse[5] ))).click();
	  }
	  
	  @Test(priority = 9)
      public void border_Width() throws InterruptedException, AWTException {
		  robot_Scroll(driver);
		  String border_width_value = "5";
		  WebElement border_width = driver.findElement(By.name("borderWidth"));
		  wait.until(ExpectedConditions.elementToBeClickable(border_width)).clear();
		  wait.until(ExpectedConditions.elementToBeClickable(border_width)).sendKeys(border_width_value);
		  String actual_border_width = border_width.getAttribute("value");
		  Assert.assertEquals(actual_border_width, border_width_value);
		  System.out.println(actual_border_width);
	  }
	
	  
	  @Test(priority = 11)
	  public void shadow_click() {
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(collapse[0] + collapse[2] + collapse[4] + collapse[5] ) )).click();
	  }
	  
	  @Test(priority = 12)
	  public void horizontal_length() throws InterruptedException, AWTException {
		  WebElement horizontal_length = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='boxshadowHarizontal']")));
		  horizontal_length.clear();
		  horizontal_length.sendKeys(horizontal_value);
		  robot_Scroll(driver);
	  }
	  
	  @Test(priority = 13)
	  public void vertical_length() {
		  WebElement vertical_length = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='boxshadowVertical']")));
		  vertical_length.clear();
		  vertical_length.sendKeys(vertical_value);
	 }
	  
	  @Test(priority = 14)
	  public void blur_radius() {
		  WebElement blur_radius = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='boxshadowBlur']")));
		  blur_radius.clear();
		  blur_radius.sendKeys(blur_radius_value);
	 }
	  
	  @Test(priority = 15)
	  public void spread_radius() {
		  WebElement spread_radius = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='boxshadowSpread']")));
		  spread_radius.clear();
		  spread_radius.sendKeys(spread_radius_value);
	 }
	  
	  @Test(priority = 32)
		 public void saveAndPreview() throws InterruptedException {
			 save(driver);
			 preview(driver);
		 }
		 
		  
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
	  quitBrowser(driver);
	}
	 

	
	
	
	
	

}
