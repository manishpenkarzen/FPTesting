package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBox_Top_Properties extends Common_Methods {
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
  public void top_Properties() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.get("http://beta.freshproposals.net/home/proposals/editProposal;proposalId=1178;editor=true"); //beta1
	  Thread.sleep(1000);
	  //textbox click 
	  driver.findElement(By.xpath("//div[@id='froalapage1-fpText1114201911184033']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'bold')]")).click();
	  
	  driver.findElement(By.xpath("//button[starts-with(@id,'underline')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("Freshproposals");
	  
	  String actual_text = driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).getText();
	  System.out.println(actual_text);
	  String expected_text = "Freshproposals";
	  Assert.assertEquals(actual_text, expected_text);
	  
	  String actual_bold = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//strong")).getCssValue("font-weight");
	  System.out.println(actual_bold);
	  String expected_bold = "700";
	  Assert.assertEquals(actual_bold, expected_bold);
	  
	  String actual_underline = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("text-decoration");
	  System.out.println(actual_underline);
	  String expected_underline = "underline solid rgb(51, 51, 51)";
	  Assert.assertEquals(actual_underline, expected_underline);
	  
	  
	  }
  
  @Test(priority = 2)
  public void fontsize36() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@id='fontSize-1']//*[@class='fr-svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("36")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("I am 36");
	  String actual_font_size = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//span")).getCssValue("font-size");
	  System.out.println(actual_font_size);
	  String expected_font_size = "36px";
	  Assert.assertEquals(actual_font_size, expected_font_size);
	  
	 }
  
  @Test(priority = 3)
  public void Save_36() throws InterruptedException {
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1178;editor=true");
	  
 }
  
  @Test(priority = 4)
  public void delete_all36() throws InterruptedException {
	  driver.findElement(By.xpath("//div[@id='froalapage1-fpText1114201911184033']")).click();
	  Thread.sleep(1000);
	 // driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).clear();
  }
  
  @Test(priority = 5)
  public void fontsize60() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@id='froalapage1-fpText1114201911184033']")).click();
	  driver.findElement(By.xpath("//button[@id='fontSize-1']//*[@class='fr-svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("60")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("I am 60");
	  String actual_font_size = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//span")).getCssValue("font-size");
	  System.out.println(actual_font_size);
	  String expected_font_size = "60px";
	  Assert.assertEquals(actual_font_size, expected_font_size);
	  
	 }
  
   @Test(priority = 6)
  public void Save_60() throws InterruptedException {
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1178;editor=true");
	  
 }
  
  @Test(priority = 7)
  public void delete_all60() throws InterruptedException {
	  driver.findElement(By.xpath("//div[@id='froalapage1-fpText1114201911184033']")).click();
	  Thread.sleep(1000);
	 // driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).clear();
  }
  
  @Test(priority = 8)
  public void fontsize96() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@id='froalapage1-fpText1114201911184033']")).click();
	  driver.findElement(By.xpath("//button[@id='fontSize-1']//*[@class='fr-svg']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("96")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("I am 96");
	  String actual_font_size = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//span")).getCssValue("font-size");
	  System.out.println(actual_font_size);
	  String expected_font_size = "96px";
	  Assert.assertEquals(actual_font_size, expected_font_size);
	  
	 }
  
  @Test(priority = 9)
  public void Save_96() throws InterruptedException {
	  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	  Thread.sleep(3000);
	  driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1178;editor=true");
	  
 }
  
  @Test(priority = 10)
  public void delete_all96() throws InterruptedException {
	  driver.findElement(By.xpath("//div[@id='froalapage1-fpText1114201911184033']")).click();
	  Thread.sleep(1000);
	 // driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).clear();
  }
  
  
  
  
//  @Test(priority = 2)
//  public void click_reflect_h1() throws InterruptedException {
//	  Thread.sleep(1000);
//	  //paragraph button
//	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Heading 1")).click();
//	  String actual_heading1 = driver.findElement(By.linkText("Heading 1")).getAttribute("title");
//	  String expected_heading1 = "Heading 1";
//	  Assert.assertEquals(actual_heading1, expected_heading1);
//	  
//	  //reflect
//	  String actual_reflect_h1 = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("font-size");
//	  System.out.println(actual_reflect_h1);
//	  String expected_reflect_h1 = "36px";
//	  Assert.assertEquals(actual_reflect_h1, expected_reflect_h1);
//  }	
//  
//  @Test(priority = 3)
//  public void click_reflect_h2() throws InterruptedException {
//	  Thread.sleep(1000);
//	  //paragraph button
//	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Heading 2")).click();
//	  String actual_heading2 = driver.findElement(By.linkText("Heading 2")).getAttribute("title");
//	  String expected_heading2 = "Heading 2";
//	  Assert.assertEquals(actual_heading2, expected_heading2);
//	  
//	//reflect
//	  String actual_reflect_h2 = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("font-size");
//	  System.out.println(actual_reflect_h2);
//	  String expected_reflect_h2 = "28px";
//	  Assert.assertEquals(actual_reflect_h2, expected_reflect_h2);
//  }
//  
//  @Test(priority = 4)
//  public void click_reflect_h3() throws InterruptedException {
//	  Thread.sleep(1000);
//	  //paragraph button
//	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Heading 3")).click();
//	  String actual_heading3 = driver.findElement(By.linkText("Heading 3")).getAttribute("title");
//	  String expected_heading3 = "Heading 3";
//	  Assert.assertEquals(actual_heading3, expected_heading3);
//	  
//	//reflect
//	  String actual_reflect_h3 = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("font-size");
//	  System.out.println(actual_reflect_h3);
//	  String expected_reflect_h3 = "20px";
//	  Assert.assertEquals(actual_reflect_h3, expected_reflect_h3);
//  }
//  
//  @Test(priority = 5)
//  public void click_reflect_h4() throws InterruptedException {
//	  Thread.sleep(1000);
//	  //paragraph button
//	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Heading 4")).click();
//	  String actual_heading4 = driver.findElement(By.linkText("Heading 4")).getAttribute("title");
//	  String expected_heading4 = "Heading 4";
//	  Assert.assertEquals(actual_heading4, expected_heading4);
//	  
//	//reflect
//	  String actual_reflect_h4 = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("font-size");
//	  System.out.println(actual_reflect_h4);
//	  String expected_reflect_h4 = "16px";
//	  Assert.assertEquals(actual_reflect_h4, expected_reflect_h4);
//  }
//  
//  @Test(priority = 6)
//  public void click_reflect_body() throws InterruptedException {
//	  Thread.sleep(1000);
//	  //paragraph button
//	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Body")).click();
//	  String actual_body = driver.findElement(By.linkText("Body")).getAttribute("title");
//	  String expected_body = "Body";
//	  Assert.assertEquals(actual_body, expected_body);
//	  
//	//reflect
//	  String actual_reflect_body = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("font-size");
//	  System.out.println(actual_reflect_body);
//	  String expected_reflect_body = "14px";
//	  Assert.assertEquals(actual_reflect_body, expected_reflect_body);
//  }
//  
//  @Test(priority = 7)
//  public void click_reflect_quote() throws InterruptedException {
//	  Thread.sleep(1000);
//	  //paragraph button
//	  driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Quote")).click();
//	  String actual_quote = driver.findElement(By.linkText("Quote")).getAttribute("title");
//	  String expected_quote = "Quote";
//	  Assert.assertEquals(actual_quote, expected_quote);
//	  
//	//reflect
//	  String actual_reflect_quote = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("font-size");
//	  System.out.println(actual_reflect_quote);
//	  String expected_reflect_quote = "14px";
//	  Assert.assertEquals(actual_reflect_quote, expected_reflect_quote);
//  }
	  
	 
	  
//  
//  @Test(enabled = false)
//  public void fontSize() throws InterruptedException {
//	  Thread.sleep(1000);
//	  //paragraph button
//	  driver.findElement(By.xpath("//button[starts-with(@id,'fontSize')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'72')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).click();
//	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("\n I am 72");;
//	  
////	  Thread.sleep(1000);
////	  //paragraph button
////	  driver.findElement(By.xpath("//button[starts-with(@id,'fontSize')]")).click();
////	  Thread.sleep(1000);
////	  driver.findElement(By.linkText("18")).click();
////	  Thread.sleep(1000);
////	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("\nI am 8");
//	  
//	  Thread.sleep(1000);
//	  //paragraph button
//	  driver.findElement(By.xpath("//button[starts-with(@id,'fontSize')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'18')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("\nI am 18");
//	  
//  }
//  
//  @Test(enabled = false)
//  public void textColor() throws InterruptedException {
//	  Thread.sleep(1000);
//	  //textcolor button
//	  driver.findElement(By.xpath("//button[starts-with(@id,'textColor')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("14")).click();
//	  Thread.sleep(1000);
//	  //color
//	  driver.findElement(By.xpath("")).clear();
//	 
//	  Thread.sleep(1000);
//	  //ok
//	  //driver.findElement(By.xpath("//button[@class='fr-command fr-submit']")).click();
//	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("\n FreshProposals");
//	  
//  }
//  
//  @Test(priority = 8)
//  public void click_reflect_default() throws InterruptedException {
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
//	  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
//	  		+ "a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. "
//	  		+ "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing"
//	  		+ " software like Aldus PageMaker including versions of Lorem Ipsum");
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Default")).click();
//	  String actual_default = driver.findElement(By.linkText("Default")).getAttribute("title");
//	  String expected_default = "Default";
//	  Assert.assertEquals(actual_default, expected_default);
//   
//	  String actual_line_height = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("line-height");
//	  System.out.println("default "+actual_line_height);
//	  
//  }
//  
//  @Test(priority = 9)
//  public void click_reflect_single() throws InterruptedException {
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Single")).click();
//	  String actual_single = driver.findElement(By.linkText("Single")).getAttribute("title");
//	  String expected_single = "Single";
//	  Assert.assertEquals(actual_single, expected_single);
//	  
//	  String actual_line_height = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("line-height");
//	  System.out.println("single "+actual_line_height);
//  }
//  
//  @Test(priority = 10)
//  public void click_reflect_1point15() throws InterruptedException {
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("1.15")).click();
//	  String actual_digit1 = driver.findElement(By.linkText("1.15")).getAttribute("title");
//	  String expected_digit1 = "1.15";
//	  Assert.assertEquals(actual_digit1, expected_digit1);
//	  
//	  String actual_line_height = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("line-height");
//	  System.out.println("1.15 "+actual_line_height);
//  }
//  
//  @Test(priority = 11)
//  public void click_reflect_1point5() throws InterruptedException {
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("1.5")).click();
//	  String actual_digit2 = driver.findElement(By.linkText("1.5")).getAttribute("title");
//	  String expected_digit2 = "1.5";
//	  Assert.assertEquals(actual_digit2, expected_digit2);
//	  
//	  String actual_line_height = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("line-height");
//	  System.out.println("1.5 "+actual_line_height);
//	  
//  }
//  
//  @Test(priority = 12)
//  public void click_reflect_double() throws InterruptedException {
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Double")).click();
//	  String actual_double = driver.findElement(By.linkText("Double")).getAttribute("title");
//	  String expected_double = "Double";
//	  Assert.assertEquals(actual_double, expected_double);
//	  
//	  String actual_line_height = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p//u")).getCssValue("line-height");
//	  System.out.println("double "+actual_line_height);
//  }
//  
 	  
//	}
//  
//  @Test(priority = 6)
//  public void align() throws InterruptedException {
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[@title='Align Left']")).click();
//	  //System.out.println(driver.findElement(By.xpath("//a[@title='Align Left']")).getCssValue("text-align"));
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[@title='Align Center']")).click();
//  
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[@title='Align Right']")).click();
//  
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[@title='Align Justify']")).click();
//	  
//  }
//  
//  @Test(priority = 7)
//  public void orderList() throws InterruptedException {
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//div[@id='dropdown-menu-formatOLOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).click();
//	  String actual_default = driver.findElement(By.xpath("//div[@id='dropdown-menu-formatOLOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).getAttribute("title");
//	  String expected_default = "Default";
//	  Assert.assertEquals(actual_default, expected_default);
//	  
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Lower Alpha')]")).click();
//	  String actual_loweralpha = driver.findElement(By.xpath("//a[contains(text(),'Lower Alpha')]")).getAttribute("title");
//	  String expected_loweralpha = "Lower Alpha";
//	  Assert.assertEquals(actual_loweralpha, expected_loweralpha);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Lower Greek')]")).click();
//	  String actual_lowergreek = driver.findElement(By.xpath("//a[contains(text(),'Lower Greek')]")).getAttribute("title");
//	  String expected_lowergreek = "Lower Greek";
//	  Assert.assertEquals(actual_lowergreek, expected_lowergreek);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Lower Roman')]")).click();
//	  String actual_lowerroman = driver.findElement(By.xpath("//a[contains(text(),'Lower Roman')]")).getAttribute("title");
//	  String expected_lowerroman = "Lower Roman";
//	  Assert.assertEquals(actual_lowerroman, expected_lowerroman);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Upper Alpha')]")).click();
//	  String actual_upperalpha = driver.findElement(By.xpath("//a[contains(text(),'Upper Alpha')]")).getAttribute("title");
//	  String expected_upperalpha = "Upper Alpha";
//	  Assert.assertEquals(actual_upperalpha, expected_upperalpha);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Upper Roman')]")).click();
//	  String actual_upperroman = driver.findElement(By.xpath("//a[contains(text(),'Upper Roman')]")).getAttribute("title");
//	  String expected_upperroman = "Upper Roman";
//	  Assert.assertEquals(actual_upperroman, expected_upperroman);
//  }
//  
//  @Test(priority = 8)
//  public void unorderList() throws InterruptedException {
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//div[@id='dropdown-menu-formatULOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).click();
//	  String actual_default = driver.findElement(By.xpath("//div[@id='dropdown-menu-formatULOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).getAttribute("title");
//	  String expected_default = "Default";
//	  Assert.assertEquals(actual_default, expected_default);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Circle')]")).click();
//	  String actual_circle = driver.findElement(By.xpath("//a[contains(text(),'Circle')]")).getAttribute("title");
//	  String expected_circle = "Circle";
//	  Assert.assertEquals(actual_circle, expected_circle);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Disc')]")).click();
//	  String actual_disc = driver.findElement(By.xpath("//a[contains(text(),'Disc')]")).getAttribute("title");
//	  String expected_disc = "Disc";
//	  Assert.assertEquals(actual_disc, expected_disc);
//	  
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[contains(text(),'Square')]")).click();
//	  String actual_square = driver.findElement(By.xpath("//a[contains(text(),'Square')]")).getAttribute("title");
//	  String expected_square = "Square";
//	  Assert.assertEquals(actual_square, expected_square);
//	
//  }
//  
//  @Test(priority = 9)
//  public void insertLink() throws InterruptedException {
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'insertLink')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.name("href")).sendKeys("www.google.com");
////	  String actual_link = driver.findElement(By.name("href")).getText();
////	  String expected_link = "www.google.com";
////	  Assert.assertEquals(actual_link, expected_link);
////	  Thread.sleep(1000);
//	  driver.findElement(By.name("text")).sendKeys("Google");
////	  System.out.println(driver.findElement(By.name("text")).getText());
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[contains(text(),'Insert')]")).click();
//	  
//  }
//  
//  @Test(enabled = false)
//  public void setting() throws InterruptedException {
//	 //paragraph button
//	 driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
//     Thread.sleep(1000);
//     driver.findElement(By.linkText("Heading 1")).click();
//	 Thread.sleep(1000);
//	 driver.findElement(By.xpath("//img[@src='../../../../../assets/setting-icon.svg']")).click();
//	 Thread.sleep(1000);
//	 driver.findElement(By.xpath("//span[contains(text(),'TEXT SETTING')]")).click();
//	 Thread.sleep(1000);
//	 
//	 Select select = new Select(driver.findElement(By.name("fontSettingName")));
//	 select.selectByVisibleText("Heading 1");
//	 
//  }
//  
//  @Test(priority = 11)
//  public void linkStyle() throws InterruptedException {
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'linkStyle')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Green")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'linkStyle')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.linkText("Thick")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[starts-with(@id,'linkEdit')]")).click();
//	  Thread.sleep(1000);
//	  driver.findElement(By.name("text")).clear();
//	  driver.findElement(By.name("text")).sendKeys("Google Update");
//	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
//	  
//  }
  
 @AfterClass
  public void closeBrowser() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
}
}
