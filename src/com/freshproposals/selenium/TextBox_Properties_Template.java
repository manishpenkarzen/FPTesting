package com.freshproposals.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.cert.PKIXRevocationChecker.Option;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBox_Properties_Template extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	String width_value = "650";
	String height_value = "500";
	String rotate_value = "2";
//	String opacity ="64";
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
	
	WebDriverWait wait;
	
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
  	public void openWtriteTemplate() throws InterruptedException {
		  Thread.sleep(15000);
		  wait.until(ExpectedConditions.elementToBeClickable(By.id("linkTemplates"))).click();
		  
		  
			driver.findElement(By.xpath("//img[@src='../../assets/add-section-icon.png']")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("name")).sendKeys(fname+" Template "+timestamp);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='onboardingAddSection']"))).click();			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='search section']"))).click();			

			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='search section']")));
			search.sendKeys("TextBox_Properties_Automation_C_L");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='btn btn-outline-light use-this-icon']")).click();			

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='img-fluid close-section-library']"))).click();			
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("New Secti"))).click();			

			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='nav-item example-box active']//button[@id='dropdownBasic1']//img"))).click();			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Delete')]"))).click();			
			Thread.sleep(3000);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn save-btn ng-star-inserted']"))).click();			

//		  Actions action = new Actions(driver);
//		  WebElement source = driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));
//		  WebElement des = driver.findElement(By.xpath("//div[starts-with(@id,'sectionPage_')]"));
//		  action.clickAndHold(source).moveToElement(des, -50, -50).release().build().perform();
		  Thread.sleep(5000);

		  //driver.get("https://beta.freshproposals.net/home/templates/editTemplate/836");
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='fr-element fr-view']"))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='fr-element fr-view']")))
		  .sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's"
		  		+ " standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make"
		  		+ " a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, "
		  		+ "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing "
		  		+ "Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions "
		  		+ "of Lorem Ipsum.");

  }
	  
	  @Test(priority = 2)
	  public void width() {
		  WebElement width = driver.findElement(By.xpath("//div[@class='row']//div[1]//div[1]//ejs-numerictextbox[1]//span[1]//input[1]"));
		  wait.until(ExpectedConditions.elementToBeClickable(width)).clear();
		  wait.until(ExpectedConditions.elementToBeClickable(width)).sendKeys(width_value);
	      String actual_width = width.getAttribute("value");
	      Assert.assertEquals(actual_width, width_value);
 }
	  
	  @Test(priority = 3)
      public void height() {
		  WebElement height = driver.findElement(By.xpath("//div[@id='config-panel-one']//div[2]//div[1]//ejs-numerictextbox[1]//span[1]//input[1]"));
		  wait.until(ExpectedConditions.elementToBeClickable(height)).clear();
		  wait.until(ExpectedConditions.elementToBeClickable(height)).sendKeys(height_value);
		  String actual_height = height.getAttribute("value");
		  Assert.assertEquals(actual_height,height_value);
	  }
	  
	  @Test(priority = 4)
      public void rotate() throws InterruptedException {
		  WebElement rotate = driver.findElement(By.xpath("//div[@class='show-sidebar-right sidebar-editor-right']//div[3]//div[1]//ejs-numerictextbox[1]//span[1]//input[1]"));
		  wait.until(ExpectedConditions.elementToBeClickable(rotate)).clear();
		  wait.until(ExpectedConditions.elementToBeClickable(rotate)).sendKeys(rotate_value);
		  String actual_rotate = rotate.getAttribute("value");
	      Assert.assertEquals(actual_rotate,rotate_value);
	  }
////	  
	  @Test(priority = 5)
      public void background_color() throws InterruptedException {
		  	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='e-btn-icon e-icons e-caret']"))).click();
	    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='e-hsv-color']"))).click();
	  }
	  
	  @Test(priority = 6)
	    public void gradient() throws InterruptedException {
	    	wait.until(ExpectedConditions.elementToBeClickable(By.name("gradient"))).click();
	    }
	    
	    @Test(priority = 7)
	    public void circular() throws InterruptedException {
	    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='circularGradient']"))).click();
	    }
	    
	    @Test(priority = 8)
	    public void opacity() throws InterruptedException {
			WebElement opacity = driver.findElement(By.name("opacity"));
			resize(opacity,50,50, driver);
			
	    
//			  String actual_opacity = driver.findElement(By.name("opacity")).getAttribute("value");
//			  String expected_opacity = "64";
//			  Assert.assertEquals(actual_opacity, expected_opacity);
//			  System.out.println(actual_opacity);
	    }
	    
		@Test(priority = 9)
		public void corner_click() {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(collapse[0] + collapse[6] + collapse[4] + collapse[5] ))).click();
		}
		
		@Test(priority = 10)
		public void corner_apply() throws AWTException {
			robot_Scroll(driver);
			WebElement corner = driver.findElement(By.xpath("//mv-slider[@name='cornersApply']"));
			resize(corner, 50, 50, driver);
		}
	    
	    @Test(priority = 15)
		  public void border_click() {
			  //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='static-1-header']//button[@class='btn collapsiable-card-arrow collapsed']"))).click();
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(collapse[0] + collapse[1] + collapse[4] + collapse[5] ))).click();
		  }
		  
		  @Test(priority = 16)
	      public void border_Width() throws InterruptedException, AWTException {
			  robot_Scroll(driver);
			  String border_width_value = "5";
			  WebElement border_width = driver.findElement(By.xpath("//div[@class='row border-style-wrapper']//input[@class='ng-untouched ng-pristine ng-valid e-control e-numerictextbox e-lib e-input']"));
			  wait.until(ExpectedConditions.elementToBeClickable(border_width)).clear();
			  wait.until(ExpectedConditions.elementToBeClickable(border_width)).sendKeys(border_width_value);
			  String actual_border_width = border_width.getAttribute("value");
			  Assert.assertEquals(actual_border_width, border_width_value);
			  System.out.println(actual_border_width);
		  }
		 
		  @Test(priority = 18)
		  public void shadow_click() {
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(collapse[0] + collapse[2] + collapse[4] + collapse[5] ) )).click();
		  }
		  
		  @Test(priority = 19)
		  public void horizontal_length() throws InterruptedException, AWTException {
			  WebElement horizontal_length = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='boxshadowHarizontalIn']")));
			  horizontal_length.clear();
			  horizontal_length.sendKeys(horizontal_value);
			  robot_Scroll(driver);
		  }
		  
		  @Test(priority = 20)
		  public void vertical_length() {
			  WebElement vertical_length = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='boxshadowVerticalIn']")));
			  vertical_length.clear();
			  vertical_length.sendKeys(vertical_value);
		 }
		  
		  @Test(priority = 21)
		  public void blur_radius() {
			  WebElement blur_radius = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='boxshadowBlur']")));
			  blur_radius.clear();
			  blur_radius.sendKeys(blur_radius_value);
		 }
		  
		  @Test(priority = 22)
		  public void spread_radius() {
			  WebElement spread_radius = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='boxshadowSpread']")));
			  spread_radius.clear();
			  spread_radius.sendKeys(spread_radius_value);
		 }
		 
		  
		  @Test(priority = 24)
		  public void padding_click() throws InterruptedException {
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(collapse[0] + collapse[3] + collapse[4] + collapse[5]))).click();
		  }
		  
		  @Test(priority = 25)
		  public void padding_top(){
			  WebElement padding_top = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingTop")));
			  padding_top.clear();
			  padding_top.sendKeys(padding_top_value);
			  padding_top.getAttribute("value");
			  
		  }   
		  
		  @Test(priority = 26)
		  public void padding_bottom(){
			  WebElement padding_bottom = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingBottom")));
			  padding_bottom.clear();
			  padding_bottom.sendKeys(padding_top_value);
			  padding_bottom.getAttribute("value");
			  System.out.println(padding_bottom);
		  }   
		  
		  @Test(priority = 27)
		  public void padding_Left(){
			  WebElement padding_Left = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingLeft")));
			  padding_Left.clear();
			  padding_Left.sendKeys(padding_left_value);
			  padding_Left.getAttribute("value");
		  }   
		  
		  @Test(priority = 28)
		  public void padding_right(){
			  WebElement padding_right = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingRight")));
			  padding_right.clear();
			  padding_right.sendKeys(padding_right_value);
			  padding_right.getAttribute("value");
		  }  
		  
		  
		 @Test(priority = 32)
		 public void saveAndPreview() throws InterruptedException {
			 save(driver);
			 preview(driver);
		 }
		 
		  //reflect
		  @Test(priority = 33)
		  public void reflect_width() throws InterruptedException {
			  Thread.sleep(5000);
			  //driver.get("https://beta.freshproposals.net/home/templates/editTemplate/972/true");
			  //driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
			  String actual_reflect_width = driver.findElement(By.xpath("//div[@class='resizers']")).getCssValue("width");
			  String expected_reflect_width = width_value+"px";
			  System.out.println("Rwidth "+actual_reflect_width);
			  System.out.println("reflect width "+expected_reflect_width);
			  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
			}
		  
		  @Test(priority = 34)
		  public void reflect_height() {
			  String actual_reflect_height = driver.findElement(By.xpath("//div[@class='resizers']")).getCssValue("height");
			  System.out.println("Rheight "+actual_reflect_height);
			  String expected_reflect_height = height_value+"px";
			  System.out.println("reflect height "+expected_reflect_height);
			  Assert.assertEquals(actual_reflect_height, expected_reflect_height);
		  }
		  
		  
		  @Test(priority = 36)
		  public void reflect_shadow() throws InterruptedException, AWTException {
			  String actual_reflect_shadow = driver.findElement(By.xpath("//div[@class='resizers']")).getCssValue("box-shadow");
			  System.out.println("Rshadow "+actual_reflect_shadow);
			  String expected_reflect_shadow = "rgb(29, 201, 183) 100px 100px 100px 100px";
			  System.out.println("reflect shadow "+expected_reflect_shadow);
			  Assert.assertEquals(actual_reflect_shadow, expected_reflect_shadow);
		  }
	
		  @Test(priority = 37)
		  public void reflect_padding_top() throws InterruptedException, AWTException {
			  String actual_reflect_padding_top = driver.findElement(By.xpath("//div[@class='Quote highlight']")).getCssValue("padding-top");
			  System.out.println("Rpaddingtop "+actual_reflect_padding_top);
			  String expected_reflect_padding_top = padding_top_value+"px";;
			  System.out.println("reflect shadow "+expected_reflect_padding_top);
			  Assert.assertEquals(actual_reflect_padding_top, expected_reflect_padding_top);
		  }
		  
		  @Test(priority = 38)
		  public void reflect_padding_bottom() throws InterruptedException, AWTException {
			  String actual_reflect_padding_bottom = driver.findElement(By.xpath("//div[@class='Quote highlight']")).getCssValue("padding-bottom");
			  System.out.println("Rpaddingbottom "+actual_reflect_padding_bottom);
			  String expected_reflect_padding_bottom = padding_bottom_value+"px";;
			  System.out.println("reflect shadow "+expected_reflect_padding_bottom);
			  Assert.assertEquals(actual_reflect_padding_bottom,expected_reflect_padding_bottom);
		  }
		  
		  @Test(priority = 39)
		  public void reflect_padding_left() throws InterruptedException, AWTException {
			  String actual_reflect_padding_left = driver.findElement(By.xpath("//div[@class='Quote highlight']")).getCssValue("padding-left");
			  System.out.println("Rpaddingleft "+actual_reflect_padding_left);
			  String expected_reflect_padding_left = padding_left_value+"px";;
			  System.out.println("reflect shadow "+actual_reflect_padding_left);
			  Assert.assertEquals(actual_reflect_padding_left, expected_reflect_padding_left);
		  }
		  
		  @Test(priority = 40)
		  public void reflect_padding_right() throws InterruptedException, AWTException {
			  String actual_reflect_padding_right = driver.findElement(By.xpath("//div[@class='Quote highlight']")).getCssValue("padding-right");
			  System.out.println("Rpaddingright "+actual_reflect_padding_right);
			  String expected_reflect_padding_right = padding_right_value+"px";;
			  System.out.println("reflect shadow "+expected_reflect_padding_right);
			  Assert.assertEquals(actual_reflect_padding_right, expected_reflect_padding_right);
		  }
		  
		 
		
		 
		  
		  
		  
		 

		 
		

//	  
//
//	  @Test(priority = 13)
//      public void padding() throws InterruptedException, AWTException {
//	  
//	  driver.findElement(By.name("padding")).click();
//	  Thread.sleep(1000);
//	  
//	  Robot robot = new Robot();
//	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//	  driver.findElement(By.name("paddingTop")).clear();
//	  driver.findElement(By.name("paddingTop")).sendKeys(padding_top);
//	  Thread.sleep(1000);
//	  driver.findElement(By.name("paddingLeft")).clear();
//	  driver.findElement(By.name("paddingLeft")).sendKeys(padding_left);
//	  Thread.sleep(1000);
//	  driver.findElement(By.name("paddingBottom")).clear();
//	  driver.findElement(By.name("paddingBottom")).sendKeys(padding_bottom);
//	  Thread.sleep(1000);
//	  driver.findElement(By.name("paddingRight")).clear();
//	  driver.findElement(By.name("paddingRight")).sendKeys(padding_right);
//	 }
//	  
////	  @Test(priority = 10)
////      public void paragraphStyle() throws InterruptedException {
////	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
////	  Thread.sleep(2000);
////	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
////	  Thread.sleep(1000);
////	  driver.findElement(By.linkText("Heading 1")).click();
////	  String actual_heading =  driver.findElement(By.linkText("Heading 1")).getAttribute("title");
////	  String expected_heading = "Heading 1";
////	  Assert.assertEquals(actual_heading,expected_heading);
////	  
////	  }
////
////	  @Test(priority = 11)
////      public void setting() throws InterruptedException {
////	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-template-properties[1]/form[1]/div[1]/div[2]/img[1]")).click();
////	  driver.findElement(By.xpath("//img[@src='../../../../../assets/setting-icon.svg']")).click();
////	  Thread.sleep(2000);
////	  //driver.findElement(By.xpath("//span[contains(text(),'TEXT SETTING')]")).click();
////	  }
////
////	  @Test(priority = 12)
////      public void font_Size() throws InterruptedException {
////	  Thread.sleep(2000);
////	  Select select = new Select(driver.findElement(By.name("fontSize")));
////	  select.selectByIndex(15);
////	  Thread.sleep(2000);
////  }
////	  
////	  @Test(priority = 13)
////      public void BIU() throws InterruptedException {
////
////	  //underline
////	  driver.findElement(By.xpath("//i[@class='fa fa-underline pt-2']")).click();
////	  //bold
////	  driver.findElement(By.xpath("//i[@class='fa fa-bold']")).click();
////	  //italic
////	  driver.findElement(By.xpath("//i[@name='fontStyle']")).click();
////	  Thread.sleep(2000);
////	  }
////	  
////	  @Test(priority = 14)
////      public void align() throws InterruptedException {
////
////	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-left.svg']")).click();
////	  Thread.sleep(2000);
////	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-right.svg']")).click();
////	  Thread.sleep(2000);
////	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-center.svg']")).click();
////	  Thread.sleep(2000);
////	  driver.findElement(By.xpath("//img[@src='../../../../../assets/align-table-justify.svg']")).click();
////	  Thread.sleep(2000);
////	  }
////	  
////	  @Test(priority = 15)
////      public void write() throws InterruptedException {
////
////	 driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys(" I am from Selenium, How are you ???");
////	  }
////	  
//	  @Test(priority = 16)
//	  public void save() throws InterruptedException {
//		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
//		  Thread.sleep(3000);
//		  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
//		  Thread.sleep(3000);
//		  driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/397");
//		  
//	 }
//	  
//	  
//	  @Test(priority = 19)
//	  public void reflect_rotate() {
//		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
//		  String actual_reflect_rotate = driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).getCssValue("rotate");
//		  System.out.println("Rrotate "+actual_reflect_rotate);
//		  String expected_reflect_rotate = rotate+"px";
//		  System.out.println("reflect rotate "+expected_reflect_rotate);
//		  Assert.assertEquals(actual_reflect_rotate, expected_reflect_rotate);
//		  
//	  }
//	  
////	  @Test(priority = 20)
////	  public void reflect_opacity() {
////		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
////		  String actual_reflect_opacity = driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).getCssValue("opacity");
////		  System.out.println(actual_reflect_opacity);
////		  String expected_reflect_opacity = opacity+"px";
////		  System.out.println("reflect opacity "+expected_reflect_opacity);
////		  Assert.assertEquals(actual_reflect_opacity, expected_reflect_opacity);
////		  
////	  }
////	
//	  @Test(priority = 21)
//	  public void reflect_border_width() throws InterruptedException {
//		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
//		  String actual_reflect_border_width = driver.findElement(By.className("resizers")).getCssValue("border-width");
//		  System.out.println("reflect_border_width = "+actual_reflect_border_width);
//		  String expected_reflect_border_width = border_width+"px";
//		  System.out.println("reflect border_width "+expected_reflect_border_width);
//		  Assert.assertEquals(actual_reflect_border_width, expected_reflect_border_width);
//		  Thread.sleep(5000);
//		  
//	  }
//	  
//	  @Test(priority = 22)
//	  public void reflect_border_style() throws InterruptedException {
//		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
//		  String actual_reflect_border_style = driver.findElement(By.className("resizers")).getCssValue("border-style");
//		  System.out.println("reflect = "+actual_reflect_border_style);
//		  String expected_reflect_border_style = border_style;
//		  System.out.println("reflect border_style "+expected_reflect_border_style);
//		  Assert.assertEquals(actual_reflect_border_style, expected_reflect_border_style);
//		  Thread.sleep(5000);
//		  
//	  }
//	  
//	  @Test(priority = 23)
//	  public void reflect_padding() throws InterruptedException {
//		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
//		  String actual_reflect_padding_top = driver.findElement(By.id("froalapage1-fpText1230201915515218")).getCssValue("padding-top");
//		  String actual_reflect_padding_left = driver.findElement(By.id("froalapage1-fpText1230201915515218")).getCssValue("padding-left");
//		  String actual_reflect_padding_bottom = driver.findElement(By.id("froalapage1-fpText1230201915515218")).getCssValue("padding-bottom");
//		  String actual_reflect_padding_right = driver.findElement(By.id("froalapage1-fpText1230201915515218")).getCssValue("padding-right");
//		  System.out.println("reflect_top = "+actual_reflect_padding_top);
//		  System.out.println("reflect_left = "+actual_reflect_padding_left);
//		  System.out.println("reflect_bottom = "+actual_reflect_padding_bottom);
//		  System.out.println("reflect_right = "+actual_reflect_padding_right);
//		  String expected_reflect_padding_top = padding_top+"px";
//		  String expected_reflect_padding_left = padding_left+"px";
//		  String expected_reflect_padding_bottom = padding_bottom+"px";
//		  String expected_reflect_padding_right = padding_right+"px";
//		  
//		  Assert.assertEquals(actual_reflect_padding_top, expected_reflect_padding_top);
//		  Assert.assertEquals(actual_reflect_padding_left, expected_reflect_padding_left);
//		  Assert.assertEquals(actual_reflect_padding_bottom, expected_reflect_padding_bottom);
//		  Assert.assertEquals(actual_reflect_padding_right, expected_reflect_padding_right);
//		  Thread.sleep(5000);
//		  
//	  }
//	
//	 
//	  @Test(priority = 24)
//	  public void Reset_All() throws InterruptedException, AWTException {
//          Thread.sleep(1000);
//		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
//	
//	     //rotate
//		  Thread.sleep(1000);	  
//		  driver.findElement(By.xpath("//body//div[@class='wrapper']//div//div[3]//div[1]//ejs-numerictextbox[1]//span[1]//input[1]")).clear();
//		  Thread.sleep(1000);
//		  driver.findElement(By.xpath("//body//div[@class='wrapper']//div//div[3]//div[1]//ejs-numerictextbox[1]//span[1]//input[1]")).sendKeys("0"); 
//		  
//		  Robot robot = new Robot();
//		  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//
//		  Thread.sleep(5000);
//		  //border width
//		  driver.findElement(By.xpath("//div[@id='config-panel-one']//div[2]//div[2]//div[1]//ejs-numerictextbox[1]//span[1]//input[1]")).clear();
//		  driver.findElement(By.xpath("//div[@id='config-panel-one']//div[2]//div[2]//div[1]//ejs-numerictextbox[1]//span[1]//input[1]")).sendKeys("0");
//		  
//		  Thread.sleep(3000);
//		  Select select = new Select(driver.findElement(By.name("borderStyle")));
//		  select.selectByIndex(2);
//		  driver.findElement(By.name("border")).click();
//		  
////		  //color
////		  Thread.sleep(1000);	  
////		  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-text-properties[1]/form[1]/div[1]/div[1]/div[1]/ngb-accordion[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
////		  Thread.sleep(1000);
////		  WebElement r1 = driver.findElement(By.xpath("//div[@class='e-hue-slider e-control e-slider e-lib']//div[@class='e-handle e-handle-first']"));
////		  resize3(r1, 5,5);
////		  Thread.sleep(1000);
////		  driver.findElement(By.className("e-hsv-color")).click();
////		  Thread.sleep(1000);
////		  driver.findElement(By.xpath("//button[@title='Apply']")).click();
//		  
//		  
//			//opacity
//			
////			 Thread.sleep(1000);
////			  WebElement r = driver.findElement(By.name("opacity"));
////		 	  resize4(r,100,100);
////		 	  
//		 	  
//		  Robot robot1 = new Robot();
//		  robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
//		  
//		 
//		  driver.findElement(By.name("paddingTop")).clear();
//		  driver.findElement(By.name("paddingTop")).sendKeys("0");
//		  Thread.sleep(1000);
//		  driver.findElement(By.name("paddingLeft")).clear();
//		  driver.findElement(By.name("paddingLeft")).sendKeys("0");
//		  Thread.sleep(1000);
//		  driver.findElement(By.name("paddingBottom")).clear();
//		  driver.findElement(By.name("paddingBottom")).sendKeys("0");
//		  Thread.sleep(1000);
//		  driver.findElement(By.name("paddingRight")).clear();
//		  driver.findElement(By.name("paddingRight")).sendKeys("0");
//		  
//		  driver.findElement(By.name("padding")).click();
//		  
//         		  
//		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
//		  
//	  }
//			  
//			  public void resize3(WebElement elementToResize, int xOffset, int yOffset) throws AWTException, InterruptedException {
//					try {
//						if (elementToResize.isDisplayed()) {
//							Actions action = new Actions(driver);
//							action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
//						} else {
//							System.out.println("Element was not displayed to drag");
//						}
//					} catch (StaleElementReferenceException e) {
//						System.out.println("Element with " + elementToResize + "is not attached to the page document "	+ e.getStackTrace());
//					} catch (NoSuchElementException e) {
//						System.out.println("Element " + elementToResize + " was not found in DOM " + e.getStackTrace());
//					} catch (Exception e) {
//						System.out.println("Unable to resize" + elementToResize + " - "	+ e.getStackTrace());
//					}
//			  }
//					
//					 public void resize4(WebElement elementToResize, int xOffset, int yOffset) {
//							try {
//								if (elementToResize.isDisplayed()) {
//									Actions action = new Actions(driver);
//									action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
//								} else {
//									System.out.println("Element was not displayed to drag");
//								}
//							} catch (StaleElementReferenceException e) {
//								System.out.println("Element with " + elementToResize + "is not attached to the page document "	+ e.getStackTrace());
//							} catch (NoSuchElementException e) {
//								System.out.println("Element " + elementToResize + " was not found in DOM " + e.getStackTrace());
//							} catch (Exception e) {
//								System.out.println("Unable to resize" + elementToResize + " - "	+ e.getStackTrace());
//							}
//					 }
//	  
//  
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
  
  
}
