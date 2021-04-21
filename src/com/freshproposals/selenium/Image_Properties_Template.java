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
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	public class Image_Properties_Template extends Common_Methods {
		WebDriver driver;
		WebDriverWait wait;
		String unm;
		String pwd;
		
		String width_value = "420";
		String rotate_value = "5";
//		String border_width = "10";
//		String border_style = "inset";
		String padding_top_value = "30";
		String padding_left_value = "30";
		String padding_bottom_value = "30";
		String padding_right_value = "30";
		String horizontal_value = "100";
		String vertical_value = "100";
		String blur_radius_value = "100";
		String spread_radius_value = "100";

//		
		
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
	  public void openExistingData() throws InterruptedException {
		 Thread.sleep(10000);
		 createTemplate(driver, wait);
		 existingDataTemplate1(driver, wait);
		 WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='search section']")));
		 search.click();
		 search.sendKeys("Image_Properties_Automation");
		 existingDataTemplate2(driver, wait);
		 Thread.sleep(5000);

	 }
	  
	  @Test(priority = 2)
	  public void width(){
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resizers']//img"))).click();
		  WebElement width = wait.until(ExpectedConditions.elementToBeClickable(By.name("width11")));
		  width.clear();
		  width.sendKeys(width_value);
		  String actual_width = driver.findElement(By.name("width11")).getAttribute("value");
		  String expected_width = width_value;
		  Assert.assertEquals(actual_width, expected_width);
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
		  WebElement blur_radius = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='boxshadowBlurIn']")));
		  blur_radius.clear();
		  blur_radius.sendKeys(blur_radius_value);
	 }
	  
	  @Test(priority = 15)
	  public void spread_radius() {
		  WebElement spread_radius = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='boxshadowSpreadIn']")));
		  spread_radius.clear();
		  spread_radius.sendKeys(spread_radius_value);
	 }
	  
	 
	  @Test(priority = 20)
	  public void padding_click() throws InterruptedException {
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(collapse[0] + collapse[3] + collapse[4] + collapse[5]))).click();
	  }
	  
	  @Test(priority = 21)
	  public void padding_top(){
		  WebElement padding_top = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingTop")));
		  padding_top.clear();
		  padding_top.sendKeys(padding_top_value);
		  padding_top.getAttribute("value");
	  }   
	  
	  @Test(priority = 22)
	  public void padding_bottom(){
		  WebElement padding_bottom = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingBottom")));
		  padding_bottom.clear();
		  padding_bottom.sendKeys(padding_top_value);
		  padding_bottom.getAttribute("value");
		  System.out.println(padding_bottom);
	  }   
	  
	  @Test(priority = 23)
	  public void padding_Left(){
		  WebElement padding_Left = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingLeft")));
		  padding_Left.clear();
		  padding_Left.sendKeys(padding_left_value);
		  padding_Left.getAttribute("value");
	  }   
	  
	  @Test(priority = 24)
	  public void padding_right(){
		  WebElement padding_right = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingRight")));
		  padding_right.clear();
		  padding_right.sendKeys(padding_right_value);
		  padding_right.getAttribute("value");
	  }   
	 
	  
//	  @Test(priority = 25)
//	  public void greyscale() throws InterruptedException, AWTException {
//		  //grayscale
//		  robot_Scroll(driver);
//		  WebElement greyscale = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn collapsiable-card-arrow collapsed")));
//		  greyscale.click();
//		  resize(greyscale,50,50, driver);
//		  String v =greyscale.getAttribute("value");
//		  System.out.println(v);
//		 }
	  
	  @Test(priority = 26)
	  public void flip() {
		  wait.until(ExpectedConditions.elementToBeClickable(By.name("flip1"))).click();
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
			  String actual_reflect_width = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("width");
			  String expected_reflect_width = width_value+"px";
			  System.out.println("Rwidth "+actual_reflect_width);
			  System.out.println("reflect width "+expected_reflect_width);
			  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
		  }
		  
		  @Test(priority = 36)
		  public void reflect_shadow() throws InterruptedException, AWTException {
			  String actual_reflect_shadow = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("box-shadow");
			  System.out.println("Rshadow "+actual_reflect_shadow);
			  String expected_reflect_shadow = "rgb(29, 201, 183) 100px 100px 100px 100px";
			  System.out.println("reflect shadow "+expected_reflect_shadow);
			  Assert.assertEquals(actual_reflect_shadow, expected_reflect_shadow);
		  }
	
		  @Test(priority = 37)
		  public void reflect_padding_top() throws InterruptedException, AWTException {
			  String actual_reflect_padding_top = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("padding-top");
			  System.out.println("Rpaddingtop "+actual_reflect_padding_top);
			  String expected_reflect_padding_top = padding_top_value+"px";;
			  System.out.println("reflect shadow "+expected_reflect_padding_top);
			  Assert.assertEquals(actual_reflect_padding_top, expected_reflect_padding_top);
		  }
		  
		  @Test(priority = 38)
		  public void reflect_padding_bottom() throws InterruptedException, AWTException {
			  String actual_reflect_padding_bottom = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("padding-bottom");
			  System.out.println("Rpaddingbottom "+actual_reflect_padding_bottom);
			  String expected_reflect_padding_bottom = padding_bottom_value+"px";;
			  System.out.println("reflect shadow "+expected_reflect_padding_bottom);
			  Assert.assertEquals(actual_reflect_padding_bottom,expected_reflect_padding_bottom);
		  }
		  
		  @Test(priority = 39)
		  public void reflect_padding_left() throws InterruptedException, AWTException {
			  String actual_reflect_padding_left = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("padding-left");
			  System.out.println("Rpaddingleft "+actual_reflect_padding_left);
			  String expected_reflect_padding_left = padding_left_value+"px";;
			  System.out.println("reflect shadow "+actual_reflect_padding_left);
			  Assert.assertEquals(actual_reflect_padding_left, expected_reflect_padding_left);
		  }
		  
		  @Test(priority = 40)
		  public void reflect_padding_right() throws InterruptedException, AWTException {
			  String actual_reflect_padding_right = driver.findElement(By.xpath("//div[@class='resizers']//img")).getCssValue("padding-right");
			  System.out.println("Rpaddingright "+actual_reflect_padding_right);
			  String expected_reflect_padding_right = padding_right_value+"px";;
			  System.out.println("reflect shadow "+expected_reflect_padding_right);
			  Assert.assertEquals(actual_reflect_padding_right, expected_reflect_padding_right);
		  }
		  
	
	  @AfterClass
	  public void closeBrowser() throws InterruptedException {
	  quitBrowser(driver);
	}
	  
	  
	}
