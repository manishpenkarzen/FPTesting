package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Collapse_Controls extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	double x_100;
	double y_100;
	double x1_100;
	double y1_100;
	double x2_100;
	double y2_100;
	
	
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
  
  @Test(enabled = false)
  public void createtemplate() throws InterruptedException {
		driver.findElement(By.linkText("TEMPLATES")).click();
		Thread.sleep(3000);
		//template name
		driver.findElement(By.linkText("Create your Template")).click();
		driver.findElement(By.name("name")).sendKeys(fname+" SLTemp "+timestamp);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  
  @Test(priority = 1)
  public void grid() throws InterruptedException {
	  Thread.sleep(5000);
	  //driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/759");
	  driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1151;editor=true");
	  //arrow
	  Thread.sleep(2000);
	  driver.findElement(By.id("previewcontrolsimg")).click();
	  //grid
	  //Thread.sleep(1000);
	  //driver.findElement(By.xpath("//ejs-switch[@id='grid']//span[@class='e-switch-handle']")).click();
      //full screen
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//span[@class='e-switch-handle']")).click();
	  //preview
	  //Thread.sleep(1000);
	  //driver.findElement(By.xpath("//ejs-switch[@id='preview']//span[@class='e-switch-handle']")).click();
	 
  }
  
  @Test(priority = 2)
  public void grid_100() throws InterruptedException {
	  
	  //x and y position
	  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
	  x1_100 = img_location.getX();
	  y1_100 = img_location.getY();
	  System.out.println("X1_100 "+x1_100);
	  System.out.println("Y1_100 "+y1_100);
	  
	  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
	  x2_100 = txt_location.getX();
	  y2_100 = txt_location.getY();
	  System.out.println("X2_100 "+x2_100);
	  System.out.println("Y2_100 "+y2_100);
	 
	  
	  x_100 = x1_100-x2_100;
	  y_100 = y1_100-y2_100;
	 
	  System.out.println("100%");
	  System.out.println("Editor X_100 (x1_100-x2_100) "+x_100);
	  System.out.println("Editor Y_100 (y1_100-y2_100) "+y_100);
	  
	 }
  
  @Test(priority = 3)
  public void grid150() throws InterruptedException {
	  
	  //percentages
	  Thread.sleep(2000);
	  Select select = new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
	  select.selectByValue("1.5");
	  String actual150 = select.getFirstSelectedOption().getText();
	  String expected150 = "150%";
	  Assert.assertEquals(actual150,expected150);	
	  
	  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
	  double x1_150 = img_location.getX();
	  double y1_150 = img_location.getY();
	  System.out.println("X1_150 "+x1_150);
	  System.out.println("Y1_150 "+y1_150);
	  
	  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
	  double x2_150 = txt_location.getX();
	  double y2_150 = txt_location.getY();
	  System.out.println("X2_150 "+x2_150);
	  System.out.println("Y2_150 "+y2_150);
	 
	  double x_150 = x1_150-x2_150;
	  double y_150 = y1_150-y2_150;
	 
	  System.out.println("150%");
	   
	  System.out.println("Editor X_150 (x1_150-x2_150) "+x_150);
	  System.out.println("Editor Y_150 (y1_150-y2_150) "+y_150);
	  
	 //formula
	  double f_150 =  y_100 * 1.5;
	  System.out.println(f_150);
	  
	  Assert.assertEquals(y_150, f_150);
	  
 }
  
  @Test(priority = 4)
  public void grid140() throws InterruptedException {
	  
	  Thread.sleep(1000);
	  Select select = new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
	  select.selectByValue("1.4");
	  String actual140 = select.getFirstSelectedOption().getText();
	  String expected140 = "140%";
	  Assert.assertEquals(actual140,expected140);
	  
	  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
	  double x1_140 = img_location.getX();
	  double y1_140 = img_location.getY();
	  System.out.println("X1_140 "+x1_140);
	  System.out.println("Y1_140 "+y1_140);
	  
	  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
	  double x2_140 = txt_location.getX();
	  double y2_140 = txt_location.getY();
	  System.out.println("X2_140 "+x2_140);
	  System.out.println("Y2_140 "+y2_140);
	 
	  double x_140 = x1_140-x2_140;
	  double y_140 = y1_140-y2_140;
	 
	  System.out.println("140%");
	  System.out.println("Editor X_140 (x1_140-x2_140) "+x_140);
	  System.out.println("Editor Y_140 (y1_140-y2_140) "+y_140);
	  
	  //formula
	   double f_140 = y_100 * 1.4;
	  System.out.println(f_140);
	  
	  if(y_100<(f_140+1) && (y_100>(f_140-1)) || (y_100==f_140)) {
		  Assert.assertEquals(y_140, f_140);

	  }
	  
  }
  
  @Test(priority = 5)
  public void grid130() throws InterruptedException {
	  Select select = new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
	  Thread.sleep(1000); 
	  select.selectByValue("1.3");
	  String actual130 = select.getFirstSelectedOption().getText();
	  String expected130 = "130%";
	  Assert.assertEquals(actual130,expected130);
	  
	  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
	  double x1_130 = img_location.getX();
	  double y1_130 = img_location.getY();
	  System.out.println("X1 "+x1_130);
	  System.out.println("Y1 "+y1_130);
	  
	  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
	  double x2_130 = txt_location.getX();
	  double y2_130 = txt_location.getY();
	  System.out.println("X2 "+x2_130);
	  System.out.println("Y2 "+y2_130);
	 
	  
	  double x_130 = x1_130-x2_130;
	  double y_130 = y1_130-y2_130;
	 
	  System.out.println("130%");
	  System.out.println("Editor X_130 (x1_130-x2_130) "+x_130);
	  System.out.println("Editor Y_130 (y1_130-y2_130) "+y_130);
	  
	//formula
	  double f_130 =y_100 * 1.3;
	  System.out.println(f_130);
	  
	  if(y_100<(f_130+1) && (y_100>(f_130-1)) || (y_100==f_130)) {
		  Assert.assertEquals(y_130, f_130);
   }
	  
}
  
  @Test(priority = 6)
  public void grid120() throws InterruptedException {
	  
	  Thread.sleep(1000);
	  Select select = new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
	  select.selectByValue("1.2");
	  String actual120 = select.getFirstSelectedOption().getText();
	  String expected120 = "120%";
	  Assert.assertEquals(actual120,expected120);
	  
	  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
	  double x1_120 = img_location.getX();
	  double y1_120 = img_location.getY();
	  System.out.println("X1_120 "+x1_120);
	  System.out.println("Y1_120 "+y1_120);
	  
	  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
	  double x2_120 = txt_location.getX();
	  double y2_120 = txt_location.getY();
	  System.out.println("X2_120 "+x2_120);
	  System.out.println("Y2_120 "+y2_120);
	 
	  
	  double x_120 = x1_120-x2_120;
	  double y_120 = y1_120-y2_120;
	 
	  System.out.println("120%");
	  System.out.println("Editor X_120 (x1_120-x2_120) "+x_120);
	  System.out.println("Editor Y_120 (y1_120-y2_120) "+y_120);
	  
	//formula
	  double f_120 = y_100 * 1.2;
	  System.out.println(f_120);
	  
	  if(y_100<(f_120+1) && (y_100>(f_120-1)) || (y_100==f_120)) {
		  Assert.assertEquals(y_120, f_120);
   }
	  
	  }

   @Test(priority = 7)
  public void grid110() throws InterruptedException {
	  
	  Thread.sleep(1000);
	  Select select = new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
	  select.selectByValue("1.1");
	  String actual110 = select.getFirstSelectedOption().getText();
	  String expected110 = "110%";
	  Assert.assertEquals(actual110,expected110);
	 
	  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
	  double x1_110 = img_location.getX();
	  double y1_110 = img_location.getY();
	  System.out.println("X1_110 "+x1_110);
	  System.out.println("Y1_110 "+y1_110);
	  
	  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
	  double x2_110 = txt_location.getX();
	  double y2_110 = txt_location.getY();
	  System.out.println("X2_110 "+x2_110);
	  System.out.println("Y2_110 "+y2_110);
	 
	  
	  double x_110 = x1_110-x2_110;
	  double y_110 = y1_110-y2_110;
	 
	  System.out.println("110%");
	  System.out.println("Editor X_110 (x1_110-x2_110) "+x_110);
	  System.out.println("Editor Y_110 (y1_110-y2_110) "+y_110);
	  
	//formula
	  double f_110 = y_100 * 1.1;
	  System.out.println(f_110);
	  
	  if(y_100<(f_110+1) && (y_100>(f_110-1)) || (y_100==f_110)) {
		  Assert.assertEquals(y_110, f_110);
   }
	  
  }
	  
   @Test(priority = 8)
   public void Rgrid100() throws InterruptedException {
	   
	  Thread.sleep(1000);
	  Select select = new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
	  select.selectByValue("1");
	  String actual100 = select.getFirstSelectedOption().getText();
	  String expected100 = "100%";
	  Assert.assertEquals(actual100,expected100);
	 
	  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
	  double x1_100 = img_location.getX();
	  double y1_100 = img_location.getY();
	  System.out.println("X1_100 "+x1_100);
	  System.out.println("Y1_100 "+y1_100);
	  
	  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
	  double x2_100 = txt_location.getX();
	  double y2_100 = txt_location.getY();
	  System.out.println("X2_100 "+x2_100);
	  System.out.println("Y2_100 "+y2_100);
	 
	  
	  double x_100 = x1_100-x2_100;
	  double y_100 = y1_100-y2_100;
	 
	  System.out.println("100%");
	  System.out.println("Editor X_100 (x1_100-x2_100) "+x_100);
	  System.out.println("Editor Y_100 (y1_100-y2_100) "+y_100);
	  
	//formula
	  double f_100 = y_100 * 1.0;
	  System.out.println(f_100);
	  
	  if(y_100<(f_100+1) && (y_100>(f_100-1)) || (y_100==f_100)) {
		  Assert.assertEquals(y_100, f_100);
   }
	  
}
   
   @Test(priority = 9)
   public void grid80() throws InterruptedException {
	 
		  Thread.sleep(1000);
		  Select select = new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
		  select.selectByValue(".8");
		  String actual80 = select.getFirstSelectedOption().getText();
		  String expected80 = "80%";
		  Assert.assertEquals(actual80,expected80);
		  
		  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
		  double x1_80 = img_location.getX();
		  double y1_80 = img_location.getY();
		  System.out.println("X1_80 "+x1_80);
		  System.out.println("Y1_80 "+y1_80);
		  
		  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
		  double x2_80 = txt_location.getX();
		  double y2_80 = txt_location.getY();
		  System.out.println("X2_80 "+x2_80);
		  System.out.println("Y2_80 "+y2_80);
		 
		  
		  double x_80 = x1_80-x2_80;
		  double y_80 = y1_80-y2_80;
		 
		  System.out.println("80%");
		  System.out.println("Editor X_80 (x1_80-x2_80) "+x_80);
		  System.out.println("Editor Y_80 (y1_80-y2_80) "+y_80);
		  
		//formula
		  double f_80 = y_80 * 0.8;
		  System.out.println(f_80);
		  
		  if(y_100<(f_80+1) && (y_100>(f_80-1)) || (y_100==f_80)) {
			  Assert.assertEquals(y_100, f_80);
	   }

   }
   
   @Test(priority = 10)
   public void grid60() throws InterruptedException {
	   
		  Thread.sleep(1000);
		  Select select = new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
		  select.selectByValue(".6");
		  String actual60 = select.getFirstSelectedOption().getText();
		  String expected60 = "60%";
		  Assert.assertEquals(actual60,expected60);
		  
		  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
		  double x1_60 = img_location.getX();
		  double y1_60 = img_location.getY();
		  System.out.println("X1_60 "+x1_60);
		  System.out.println("Y1_60 "+y1_60);
		  
		  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
		  double x2_60 = txt_location.getX();
		  double y2_60 = txt_location.getY();
		  System.out.println("X2_60 "+x2_60);
		  System.out.println("Y2_60 "+y2_60);
		 
		  
		  double x_60 = x1_60-x2_60;
		  double y_60 = y1_60-y2_60;
		 
		  System.out.println("60%");
		  System.out.println("Editor X_60 (x1_60-x2_60) "+x_60);
		  System.out.println("Editor Y_60 (y1_60-y2_60) "+y_60);
		  
		//formula
		  double f_60 = y_60 * 0.6;
		  System.out.println(f_60);
		  
		  if(y_100<(f_60+1) && (y_100>(f_60-1)) || (y_100==f_60)) {
			  Assert.assertEquals(y_100, f_60);
	   }

   }
   
   @Test(priority = 11)
   public void grid40() throws InterruptedException {
	   
		  Thread.sleep(1000);
		  Select select = new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
		  select.selectByValue(".4");
		  String actual40 = select.getFirstSelectedOption().getText();
		  String expected40 = "40%";
		  Assert.assertEquals(actual40,expected40);
		  
		  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
		  double x1_40 = img_location.getX();
		  double y1_40 = img_location.getY();
		  System.out.println("X1_40 "+x1_40);
		  System.out.println("Y1_40 "+y1_40);
		  
		  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
		  double x2_40 = txt_location.getX();
		  double y2_40 = txt_location.getY();
		  System.out.println("X2_40 "+x2_40);
		  System.out.println("Y2_40 "+y2_40);
		 
		  
		  double x_40 = x1_40-x2_40;
		  double y_40 = y1_40-y2_40;
		 
		  System.out.println("40%");
		  System.out.println("Editor X_40 (x1_40-x2_40) "+x_40);
		  System.out.println("Editor Y_40 (y1_40-y2_40) "+y_40);
		  
		//formula
		  double f_40 = y_40 * 0.4;
		  System.out.println(f_40);
		  
		  if(y_100<(f_40+1) && (y_100>(f_40-1)) || (y_100==f_40)) {
			  Assert.assertEquals(y_100, f_40);
	   }
		
   }
   
   @Test(priority = 12)
   public void grid20() throws InterruptedException {
	   
		  Thread.sleep(1000);
		  Select select = new Select(driver.findElement(By.xpath("//div[@class='editor-header-width-drop']//select")));
		  select.selectByValue(".2");
		  String actual20 = select.getFirstSelectedOption().getText();
		  String expected20 = "20%";
		  Assert.assertEquals(actual20,expected20);
		  
		  Point img_location = driver.findElement(By.xpath("//div[@id='page1-fpImage1111201915423534']//div[@class='resizers']")).getLocation();
		  double x1_20 = img_location.getX();
		  double y1_20 = img_location.getY();
		  System.out.println("X1_20 "+x1_20);
		  System.out.println("Y1_20 "+y1_20);
		  
		  Point txt_location = driver.findElement(By.id("froalapage1-fpText1111201915105128")).getLocation();
		  double x2_20 = txt_location.getX();
		  double y2_20 = txt_location.getY();
		  System.out.println("X2_20 "+x2_20);
		  System.out.println("Y2_20 "+y2_20);
		 
		  
		  double x_20 = x1_20-x2_20;
		  double y_20 = y1_20-y2_20;
		 
		  System.out.println("20%");
		  System.out.println("Editor X_20 (x1_20-x2_20) "+x_20);
		  System.out.println("Editor Y_20 (y1_20-y2_20) "+y_20);
		  
		//formula
		  double f_20 = y_20 * 0.2;
		  System.out.println(f_20);
		  
		  if(y_100<(f_20+1) && (y_100>(f_20-1)) || (y_100==f_20)) {
			  Assert.assertEquals(y_100, f_20);
	   }
	
   }
	  
	  
  
	  
//	  Thread.sleep(1000);
//	  select.selectByValue("1");
//	  String Ractual100 = select.getFirstSelectedOption().getText();
//	  String Rexpected100 = "100%";
//	  Assert.assertEquals(Ractual100,Rexpected100);
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//ejs-switch[@id='fullscreen']//span[@class='e-switch-handle e-switch-active']")).click();
//	  }
//
//
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
	
  }

