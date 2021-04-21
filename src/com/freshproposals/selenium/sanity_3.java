package com.freshproposals.selenium;

import java.util.List;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JToggleButton.ToggleButtonModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.thread.TestNGThreadFactory;

public class sanity_3 extends Common_Methods {
	String environment="Beta"; //Beta , Live
	
	int cnt_Signup_Current_Beta = 9; //increment this by 1 manually 
	int cnt_Signup_Current_Live = 1; //increment this by 1 manually
	
	String signup_Beta = "JimmyWatsonFirst1+"+cnt_Signup_Current_Beta+"@gmail.com";
	String signup_Live = "JimmyWatsonLive1+"+cnt_Signup_Current_Live+"@gmail.com";	
	
	//String login_Beta = "JimmyWatsonFirst1@gmail.com";
	//String login_Live = "JimmyWatsonLive1@gmail.com";
	
	String url_Beta="https://beta.freshproposals.net";
	String url_Live="https://live.freshproposals.com";
	
//	String gmail_Login_Id = "";
	String gmail_Login_Password = "Manish123$";	
			
	WebDriver driver;
	WebDriverWait wait;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());  
	String url = "";

		
	String gmail_Signup_Id = "";
	
		
//	
	String proposal_link="";
	String proposal_number_generated="";
	String summary_link="";
	String link_suffix="";
	
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\FreshPraposal\\Freshproposals_Testing\\Freshproposals_Testing\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		
		}
	
	@Test()
	public void Login() throws InterruptedException
	{
		if(environment=="Live")
		{			
			//driver.get("https://app.freshproposals.com/login");
			driver.get(url_Live);
			Thread.sleep(3000);
			gmail_Signup_Id = signup_Live;
			driver.findElement(By.id("email")).sendKeys( signup_Live); //gmail_Login_Id //shahnawaz@zenincloud.com
			//gmail_Login_Id = login_Live;
		}
		else {
			driver.get(url_Beta);
			Thread.sleep(3000);
			gmail_Signup_Id = signup_Beta;
			driver.findElement(By.id("email")).sendKeys( signup_Beta); //gmail_Login_Id //shahnawaz@zenincloud.com
			//gmail_Login_Id = login_Beta;
		}
			
	 				 	
		 driver.findElement(By.id("passwordTXT")).sendKeys(gmail_Login_Password); //Shahnawaz@123
	   	 driver.findElement(By.xpath("//button[@type='submit']")).click();		
	   	 Thread.sleep(15000);
	   	
	}
	
	@Test(priority = 1)
	public void CreateTemplate() throws InterruptedException
	{
		driver.findElement(By.id("linkTemplates")).click();
		//Thread.sleep(3000);
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("linkTemplates"))).click();
		driver.findElement(By.id("linkCreateTemp")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys(fname+" Sanity3_Proposal "+timestamp);
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 Thread.sleep(5000);
		
		
		
		
		 
//		 //***********************Break 1
//		//For repeat test enable this : manage url here
//		url = "https://dm6.freshproposals.net/home/templates/editTemplate/30481";		
//		driver.get(url);
//		//***********************Break 1
	}
	



	
	@Test(priority = 4 , enabled = true)
	public void CreateSection_TextBox_Test() throws InterruptedException
	{
		WebElement element1= driver.findElement(By.id("cdk-drop-list-1"));
		List<WebElement> li_sections = element1.findElements(By.xpath(".//li"));
		//System.out.println("li_sections:"+current_sections.getText());
		WebElement current_section =  (WebElement) li_sections.toArray()[li_sections.size()-1];
		System.out.println("current_sections: "+current_section.getText());
		WebElement button3dot = current_section.findElement(By.id("dropdownBasic1"));
		System.out.println("button3dot size: "+button3dot.getSize());
		button3dot.click();
		Thread.sleep(3000);
		
		WebElement rename = current_section.findElement(By.xpath("div[3]/div[2]/button[1]"));  //button[contains(text(),'Rename']
		System.out.println("rename: "+rename.getText());
		rename.click();
		Thread.sleep(3000);
		WebElement txtsectionname =  current_section.findElement(By.xpath("div[2]/input"));//.id("sectionNametxt")
		System.out.println("txtsectionname: "+txtsectionname.getTagName());
		txtsectionname.clear();
		txtsectionname.sendKeys("TextBox_Test");		
		
//		System.out.println("other way to clear ");
//		txtsectionname.sendKeys(Keys.CONTROL+ "a");
//		txtsectionname.sendKeys(Keys.DELETE);
//		txtsectionname.sendKeys("TextBox_Test");
		
		WebElement renameOk =  current_section.findElement(By.xpath("div[2]/div"));//.id("sectionNametxt")
		System.out.println("renameOk: "+renameOk.getTagName());
		renameOk.click();
		Thread.sleep(3000);
		
		//create textbox		  
		driver.findElement(By.id("Text")).click();
		
		
		
		
		
		
	}	
	
	  public void clear_textbox()
	  {
		  WebElement textbox_div = driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));  
		  Actions actions = new Actions(driver);
		  textbox_div.click();
		    actions.keyDown(textbox_div,Keys.CONTROL);
		    actions.sendKeys(Keys.chord("a"));
		    
		    actions.keyUp(Keys.CONTROL);
		    
		    actions.sendKeys(Keys.DELETE);
		    
		    Action action = actions.build();
		    
		    action.perform();

	  }
	  
	  public void GoToEndOfParagraph()
	  {
		  WebElement textbox_div = driver.findElement(By.xpath("//div[@class='fr-element fr-view']")); 
		  
		  Actions actions = new Actions(driver);
		  textbox_div.click();
		    actions.keyDown(textbox_div,Keys.CONTROL);
		    actions.sendKeys(Keys.ARROW_DOWN);
		    actions.keyUp(Keys.CONTROL);		    		   		    
		    Action action = actions.build();		    
		    action.perform();
	  }	  
	  
	  public void GoToEndOfParagraph_Search(String searchText)
	  {
//		  WebElement textbox_div = driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));  
//		  textbox_div.click();
		  WebElement last_para = driver.findElement(By.xpath("//*[contains(text(),'"+searchText+"')]"));
		  Actions actions = new Actions(driver);
		  last_para.click();
		    actions.keyDown(last_para,Keys.CONTROL);
		    actions.sendKeys(Keys.ARROW_DOWN);
		    actions.keyUp(Keys.CONTROL);		    		   		 
		    Action action = actions.build();		    
		    action.perform();
		    
		    
//		    Actions actions2 = new Actions(driver);
//		    textbox_div.click();
//		    actions2.keyDown(textbox_div,Keys.CONTROL);
//		    actions2.sendKeys(Keys.ARROW_DOWN);
//		    actions2.keyUp(Keys.CONTROL);		    		   		    
//		    Action action2 = actions2.build();		    
//		    action2.perform();
//		    
//		    Actions actions3 = new Actions(driver);
//		    textbox_div.click();
//		    actions3.keyDown(textbox_div,Keys.CONTROL);
//		    actions3.sendKeys(Keys.ARROW_DOWN);
//		    actions3.keyUp(Keys.CONTROL);		    		   		    
//		    Action action3 = actions3.build();		    
//		    action3.perform();
	  }	
	  

	  
	  
	  
	  @Test(priority = 5,enabled = true)
	  public void bold() throws InterruptedException, AWTException {
		  
		  
		  clear_textbox();
		Thread.sleep(2000);
		    Thread.sleep(1000);
		    WebElement textbox_div = driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));
		    textbox_div.click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).sendKeys("I am BOLD");
		    Thread.sleep(2000);
		    
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_SHIFT);
//		    Thread.sleep(000);
		    
//		    Actions action = new Actions(driver);
//		    action.keyDown(Keys.SHIFT).keyDown(Keys.ARROW_LEFT).perform();
//		    action.doubleClick(driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p"))).build().perform();
		    		    
		    
		    Actions actions = new Actions(driver);
		    actions.keyDown(textbox_div,Keys.CONTROL);
		    actions.sendKeys(Keys.chord("a"));
		    actions.keyUp(Keys.CONTROL);
		    
		    Action action = actions.build();
		    
		    action.perform();
		    
		    driver.findElement(By.id("bold-1")).click();
		    Thread.sleep(1000);		 
		    
		    
		    save(driver);
		    preview(driver);
		    
		    WebElement strong_iambold = driver.findElement(By.xpath("//*[contains(text(),'I am BOLD')]"));
		    String expected_tagname = "strong";
		    String actual_tagname = strong_iambold.getTagName();		    	
		    Assert.assertEquals(expected_tagname, actual_tagname);
		    System.out.println("Bold test Result (TagName):- "+actual_tagname+" : "+expected_tagname);
		    
		    Thread.sleep(3000);
		    		    
		    back(driver);
		    clear_textbox();
		    
		    
	    }	  
	  
	  @Test(priority = 6,enabled = true)
	  public void click_reflect_h1() throws InterruptedException {
		  
		 		  
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Testing on Paragraph Style");
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nI am Heading 1");
		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormatExtended-1')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Heading 1")).click();
//			String actual_heading1 = driver.findElement(By.linkText("Heading 1")).getAttribute("title");
//		    String expected_heading1 = "Heading 1";
//		    Assert.assertEquals(actual_heading1, expected_heading1);
			
//			String actual_heading1_class = driver.findElement(By.xpath("//*[contains(text(),'I am Heading 1')]")).getAttribute("class");
//		    String expected_heading1_class = "fpHeading1";
//		    Assert.assertEquals(actual_heading1_class, expected_heading1_class);			
//		    System.out.println("H1 test Result (ClassName):- "+actual_heading1_class+" : "+expected_heading1_class);
		    
	  	}	 
	  
	  @Test(priority = 7,enabled = true)
	  public void click_reflect_h2() throws InterruptedException, AWTException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nI am Heading 2");
		  Thread.sleep(1000);
		    driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormatExtended-1')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("Heading 2")).click();
//		  String actual_heading2 = driver.findElement(By.linkText("Heading 2")).getAttribute("title");
//		  String expected_heading2 = "Heading 2";
//		  Assert.assertEquals(actual_heading2, expected_heading2);
		  
//			String actual_heading2_class = driver.findElement(By.xpath("//*[contains(text(),'I am Heading 2')]")).getAttribute("class");
//		    String expected_heading2_class = "fpHeading2";
//		    Assert.assertEquals(actual_heading2_class, expected_heading2_class);		  
//		    System.out.println("H2 test Result (ClassName):- "+actual_heading2_class+" : "+expected_heading2_class);
	
		   }
	  
	  @Test(priority = 8,enabled = true)
	  public void click_reflect_h3() throws InterruptedException, AWTException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nI am Heading 3");
		  Thread.sleep(1000);
		    driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormatExtended-1')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("Heading 3")).click();
//		  String actual_heading3 = driver.findElement(By.linkText("Heading 3")).getAttribute("title");
//		  String expected_heading3 = "Heading 3";
//		  Assert.assertEquals(actual_heading3, expected_heading3);
		  
//			String actual_heading3_class = driver.findElement(By.xpath("//*[contains(text(),'I am Heading 3')]")).getAttribute("class");
//		    String expected_heading3_class = "fpHeading3";
//		    Assert.assertEquals(actual_heading3_class, expected_heading3_class);		  
//		    System.out.println("H3 test Result (ClassName):- "+actual_heading3_class+" : "+expected_heading3_class);
		
		    }
	  
	  @Test(priority = 9,enabled = true)
	  public void click_reflect_h4() throws InterruptedException, AWTException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nI am Heading 4");
		  Thread.sleep(1000);
		    driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormatExtended-1')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("Heading 4")).click();
//		  String actual_heading4 = driver.findElement(By.linkText("Heading 4")).getAttribute("title");
//		  String expected_heading4 = "Heading 4";
//		  Assert.assertEquals(actual_heading4, expected_heading4);
		  
//			String actual_heading4_class = driver.findElement(By.xpath("//*[contains(text(),'I am Heading 4')]")).getAttribute("class");
//		    String expected_heading4_class = "fpHeading4";
//		    Assert.assertEquals(actual_heading4_class, expected_heading4_class);		  
//		    System.out.println("H4 test Result (ClassName):- "+actual_heading4_class+" : "+expected_heading4_class);
	
		   }
	  
	  @Test(priority = 10,enabled = true)
	  public void click_reflect_body() throws InterruptedException, AWTException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nI am Body");
		  Thread.sleep(1000);
		    driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormatExtended-1')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("Body")).click();
//		  String actual_body = driver.findElement(By.linkText("Body")).getAttribute("title");
//		  String expected_body = "Body";
//		  Assert.assertEquals(actual_body, expected_body);
		  
//			String actual_body = driver.findElement(By.xpath("//*[contains(text(),'I am Body')]")).getAttribute("class");
//		    String expected_body = "fpBody";
//		    Assert.assertEquals(actual_body, expected_body);		  
//		    System.out.println("body test Result (ClassName):- "+actual_body+" : "+expected_body);
		
		   }
	  
	  @Test(priority = 11,enabled = 	true)
	  public void click_reflect_quote() throws InterruptedException, AWTException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nI am Quote");
		  Thread.sleep(1000);
		    driver.findElement(By.xpath("//button[starts-with(@id,'paragraphFormatExtended-1')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("Quote")).click();
//		  String actual_quote = driver.findElement(By.linkText("Quote")).getAttribute("title");
//		  String expected_quote = "Quote";
//		  Assert.assertEquals(actual_quote, expected_quote);
		  
		  
		    save(driver);
		    preview(driver);
		    
//		    https://stackoverflow.com/questions/32537339/getting-the-values-of-all-the-css-properties-of-a-selected-element-in-selenium
//		    WebElement we = driver.findElement(By.xpath("//*[contains(text(),'I am Heading 1')]"));
//		    JavascriptExecutor executor = (JavascriptExecutor)driver;
//		    String script = "var s = '';" +
//		                    "var o = getComputedStyle(arguments[0]);" +
//		                    "for(var i = 0; i < o.length; i++){" +
//		                    "s+=o[i] + ':' + o.getPropertyValue(o[i])+';';}" + 
//		                    "return s;";
//
//		    System.out.println(executor.executeScript(script, we));
		    
		  
		  
		//Heading 1
			String actual_heading1_class = driver.findElement(By.xpath("//*[contains(text(),'I am Heading 1')]")).getAttribute("class");
		    String expected_heading1_class = "fpHeading1";
		    Assert.assertEquals(actual_heading1_class, expected_heading1_class);			
		    System.out.println("H1 test Result (ClassName):- "+actual_heading1_class+" : "+expected_heading1_class);
		    
		    
		    
		    
		    //Heading 2
			String actual_heading2_class = driver.findElement(By.xpath("//*[contains(text(),'I am Heading 2')]")).getAttribute("class");
		    String expected_heading2_class = "fpHeading2";
		    Assert.assertEquals(actual_heading2_class, expected_heading2_class);		  
		    System.out.println("H2 test Result (ClassName):- "+actual_heading2_class+" : "+expected_heading2_class);
		    
		    
		    //Heading 3
			String actual_heading3_class = driver.findElement(By.xpath("//*[contains(text(),'I am Heading 3')]")).getAttribute("class");
		    String expected_heading3_class = "fpHeading3";
		    Assert.assertEquals(actual_heading3_class, expected_heading3_class);		  
		    System.out.println("H3 test Result (ClassName):- "+actual_heading3_class+" : "+expected_heading3_class);
		    
		    //Heading 4
			String actual_heading4_class = driver.findElement(By.xpath("//*[contains(text(),'I am Heading 4')]")).getAttribute("class");
		    String expected_heading4_class = "fpHeading4";
		    Assert.assertEquals(actual_heading4_class, expected_heading4_class);		  
		    System.out.println("H4 test Result (ClassName):- "+actual_heading4_class+" : "+expected_heading4_class);
		    
		    //Body
			String actual_body = driver.findElement(By.xpath("//*[contains(text(),'I am Body')]")).getAttribute("class");
		    String expected_body = "fpBody";
		    Assert.assertEquals(actual_body, expected_body);		  
		    System.out.println("body test Result (ClassName):- "+actual_body+" : "+expected_body);
		    
		    //Quote		  
			String actual_quote = driver.findElement(By.xpath("//*[contains(text(),'I am Quote')]")).getAttribute("class");
		    String expected_quote = "fpQuote";
		    Assert.assertEquals(actual_quote, expected_quote);
		    System.out.println("quote test Result (ClassName):- "+actual_quote+" : "+expected_quote);
		    
		    

		    Thread.sleep(3000);
		    
		    back(driver);
		   }
	  
	  @Test(priority = 12,enabled = true)
	  public void delete_all() throws InterruptedException {

		  clear_textbox();
		  //System.exit(0);
	 }
	  
	  
	  @Test(priority = 13,enabled = true)
	  public void click_reflect_default() throws InterruptedException {
		  Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
     	  Thread.sleep(1000);
    	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Testing on Line Height");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nLine Height Default :- Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
		  Thread.sleep(1000);
		  //String actual_default = driver.findElement(By.linkText("Default")).getAttribute("title");
		  driver.findElement(By.linkText("Default")).click();
		  
		  //String expected_default = "Default";
		  //Assert.assertEquals(actual_default, expected_default);
	   
		  //String actual_line_height = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).getCssValue("line-height");
		  //System.out.println("default "+actual_line_height);
		  
//		  String actual_default_line_height = driver.findElement(By.xpath("//*[contains(text(),'Line Height Default :- Lorem Ipsum is')]")).getTagName();
//		  String expected_default_line_height = "p";
//		  Assert.assertEquals(actual_default_line_height, expected_default_line_height);
//		  System.out.println("line height default test Result (TagName):- "+actual_default_line_height+" : "+expected_default_line_height);
		  
		  Thread.sleep(2000);
	  } 
	  
	  @Test(priority = 14,enabled = true)
	  public void click_reflect_single() throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  GoToEndOfParagraph();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nLine Height Single :- Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("Single")).click();
		  //String actual_single = driver.findElement(By.linkText("Single")).getAttribute("title");
		  //String expected_single = "Single";
		  //Assert.assertEquals(actual_single, expected_single);
		  
		  //String actual_line_height = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).getCssValue("line-height");
		  //System.out.println("single "+actual_line_height);
		  
		  
		  //WebElement a1 = driver.findElement(By.xpath("//*[contains(text(),'Line Height Single')]"));
		  //System.out.println("line height single --- "+a1.getTagName());
		  //System.out.println("line height single ---"+a1.getText());
//		  String actual_single_line_height = driver.findElement(By.xpath("//*[contains(text(),'Line Height Single :- Lorem Ipsum is')]")).getAttribute("style");//.getCssValue("line-height");
//		  String expected_single_line_height = "line-height: 1;";//"1";
//		  Assert.assertEquals(actual_single_line_height, expected_single_line_height);
//		  System.out.println("line height single test Result (Style):- "+actual_single_line_height+" : "+expected_single_line_height);
		  
		  Thread.sleep(2000);
	  }
	  
	  @Test(priority = 15,enabled = true)
	  public void click_reflect_1point15() throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  GoToEndOfParagraph();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nLine Height 1.15 :- Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("1.15")).click();
//		  String actual_digit1 = driver.findElement(By.linkText("1.15")).getAttribute("title");
//		  String expected_digit1 = "1.15";
//		  Assert.assertEquals(actual_digit1, expected_digit1);
//		  
//		  String actual_line_height = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).getCssValue("line-height");
//		  System.out.println("1.15 "+actual_line_height);
		  
//		  String actual_1point15_line_height = driver.findElement(By.xpath("//*[contains(text(),'Line Height 1.15 :- Lorem Ipsum is')]")).getAttribute("style");//.getCssValue("line-height");
//		  String expected_1point15_line_height = "line-height: 1.15;";//"1.15";
//		  Assert.assertEquals(actual_1point15_line_height, expected_1point15_line_height);
//		  System.out.println("line height 1.15 test Result (Style):- "+actual_1point15_line_height+" : "+expected_1point15_line_height);
		  
		  Thread.sleep(2000);
	  }
	  
	  @Test(priority = 16,enabled = true)
	  public void click_reflect_1point5() throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  GoToEndOfParagraph();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nLine Height 1.5 :- Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("1.5")).click();
//		  String actual_digit2 = driver.findElement(By.linkText("1.5")).getAttribute("title");
//		  String expected_digit2 = "1.5";
//		  Assert.assertEquals(actual_digit2, expected_digit2);
//		  
//		  String actual_line_height = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).getCssValue("line-height");
//		  System.out.println("1.5 "+actual_line_height);
		  
//		  String actual_1point5_line_height = driver.findElement(By.xpath("//*[contains(text(),'Line Height 1.5 :- Lorem Ipsum is')]")).getAttribute("style");//.getCssValue("line-height");
//		  String expected_1point5_line_height = "line-height: 1.5;";//"1.5";
//		  Assert.assertEquals(actual_1point5_line_height, expected_1point5_line_height);
//		  System.out.println("line height 1.5 test Result (Style):- "+actual_1point5_line_height+" : "+expected_1point5_line_height);
		  
		  Thread.sleep(2000);
	  }
	  
	  @Test(priority = 17,enabled = true)
	  public void click_reflect_double() throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  //GoToEndOfParagraph();
		  
		  
		  GoToEndOfParagraph_Search("Line Height 1.5 :- Lorem Ipsum is");
		  //GoToEndOfParagraph_2AndMore();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nLine Height Double :- Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'lineHeight')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("Double")).click();
//		  String actual_double = driver.findElement(By.linkText("Double")).getAttribute("title");
//		  String expected_double = "Double";
//		  Assert.assertEquals(actual_double, expected_double);
//		  
//		  String actual_line_height = driver.findElement(By.xpath("//div[@class='fr-element fr-view']//p")).getCssValue("line-height");
//		  System.out.println("double "+actual_line_height);
		  
		  
		    save(driver);
		    preview(driver);
		  
		  //Default
		  String actual_default_line_height = driver.findElement(By.xpath("//*[contains(text(),'Line Height Default :- Lorem Ipsum is')]")).getTagName();
		  String expected_default_line_height = "p";
		  Assert.assertEquals(actual_default_line_height, expected_default_line_height);
		  System.out.println("line height default test Result (TagName):- "+actual_default_line_height+" : "+expected_default_line_height);
		  
		  //Single
		  String actual_single_line_height = driver.findElement(By.xpath("//*[contains(text(),'Line Height Single :- Lorem Ipsum is')]")).getAttribute("style");//.getCssValue("line-height");
		  String expected_single_line_height = "line-height: 1;";//"1";
		  Assert.assertEquals(actual_single_line_height, expected_single_line_height);
		  System.out.println("line height single test Result (Style):- "+actual_single_line_height+" : "+expected_single_line_height);
		 
		  
		  //1.15
		  String actual_1point15_line_height = driver.findElement(By.xpath("//*[contains(text(),'Line Height 1.15 :- Lorem Ipsum is')]")).getAttribute("style");//.getCssValue("line-height");
		  String expected_1point15_line_height = "line-height: 1.15;";//"1.15";
		  Assert.assertEquals(actual_1point15_line_height, expected_1point15_line_height);
		  System.out.println("line height 1.15 test Result (Style):- "+actual_1point15_line_height+" : "+expected_1point15_line_height);
		  
		  //1.5		 
		  String actual_1point5_line_height = driver.findElement(By.xpath("//*[contains(text(),'Line Height 1.5 :- Lorem Ipsum is')]")).getAttribute("style");//.getCssValue("line-height");
		  String expected_1point5_line_height = "line-height: 1.5;";//"1.5";
		  Assert.assertEquals(actual_1point5_line_height, expected_1point5_line_height);
		  System.out.println("line height 1.5 test Result (Style):- "+actual_1point5_line_height+" : "+expected_1point5_line_height);
		  
		  //double
		  String actual_double_line_height = driver.findElement(By.xpath("//*[contains(text(),'Line Height Double :- Lorem Ipsum is')]")).getAttribute("style");//.getCssValue("line-height");
		  String expected_double_line_height = "line-height: 2;";//"2";
		  Assert.assertEquals(actual_double_line_height, expected_double_line_height);
		  System.out.println("line height double test Result (Style):- "+actual_double_line_height+" : "+expected_double_line_height);
		  
		  back(driver);
		  
		  Thread.sleep(3000);
	  }	  
	  
	  @Test(priority = 18,enabled = true)
	  public void delete_all_2() throws InterruptedException {

		  clear_textbox();
		  
	  }
	  
	  @Test(priority = 19,enabled = true)
	  public void align_left() throws InterruptedException {
		  Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
     	  Thread.sleep(1000);
    	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Testing on Align");

		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nAlign Left :- Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);		  
		  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[@title='Align Left']")).click();
		 
		  //System.out.println(driver.findElement(By.xpath("//a[@title='Align Left']")).getCssValue("text-align"));
		  
//		  String actual_align_left = driver.findElement(By.xpath("//*[contains(text(),'Align Left :- Lorem Ipsum is')]")).getCssValue("text-align");
//		  String expected_align_left = "left";
//		  System.out.println("align left test Result (css:text-align):- "+actual_align_left+" : "+expected_align_left);
//		  Assert.assertEquals(actual_align_left, expected_align_left);	
		  
		  Thread.sleep(1000);
	  }
		
	  @Test(priority = 20,enabled = true)
	  public void align_center() throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();

		  Thread.sleep(1000);		  
		  GoToEndOfParagraph();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nAlign Center :- Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[@title='Align Center']")).click();
		  
//		  String actual_align_center = driver.findElement(By.xpath("//*[contains(text(),'Align Center :- Lorem Ipsum is')]")).getCssValue("text-align");
//		  String expected_align_center = "center";
//		  System.out.println("align center test Result (css:text-align):- "+actual_align_center+" : "+expected_align_center);
//		  Assert.assertEquals(actual_align_center, expected_align_center);	
		  
		  Thread.sleep(1000);
	  }
	  
	  @Test(priority = 21,enabled = true)
	  public void align_right() throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();

		  Thread.sleep(1000);
		  GoToEndOfParagraph();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nAlign Right :- Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);		  
		  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[@title='Align Right']")).click();
		 
//		  String actual_align_right = driver.findElement(By.xpath("//*[contains(text(),'Align Right :- Lorem Ipsum is')]")).getCssValue("text-align");
//		  String expected_align_right = "right";
//		  System.out.println("align right test Result (css:text-align):- "+actual_align_right+" : "+expected_align_right);
//		  Assert.assertEquals(actual_align_right, expected_align_right);
		  
		  Thread.sleep(1000);
	  }
	  
	  @Test(priority = 22,enabled = true)
	  public void align_justify() throws InterruptedException {  
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  //GoToEndOfParagraph();
		  GoToEndOfParagraph_Search("Align Right :- Lorem Ipsum is");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("\nAlign Justify :- Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);		  
		  driver.findElement(By.xpath("//button[starts-with(@id,'align')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[@title='Align Justify']")).click();
		  
		  
		    save(driver);
		    preview(driver);
		  
		  //left
		  String actual_align_left = driver.findElement(By.xpath("//*[contains(text(),'Align Left :- Lorem Ipsum is')]")).getCssValue("text-align");
		  String expected_align_left = "left";
		  System.out.println("align left test Result (css:text-align):- "+actual_align_left+" : "+expected_align_left);
		  Assert.assertEquals(actual_align_left, expected_align_left);	
		  
		  //center
		  String actual_align_center = driver.findElement(By.xpath("//*[contains(text(),'Align Center :- Lorem Ipsum is')]")).getCssValue("text-align");
		  String expected_align_center = "center";
		  System.out.println("align center test Result (css:text-align):- "+actual_align_center+" : "+expected_align_center);
		  Assert.assertEquals(actual_align_center, expected_align_center);	
		  
		  //right
		  String actual_align_right = driver.findElement(By.xpath("//*[contains(text(),'Align Right :- Lorem Ipsum is')]")).getCssValue("text-align");
		  String expected_align_right = "right";
		  System.out.println("align right test Result (css:text-align):- "+actual_align_right+" : "+expected_align_right);
		  Assert.assertEquals(actual_align_right, expected_align_right); 
		  
		  //Justify
		  String actual_align_justify = driver.findElement(By.xpath("//*[contains(text(),'Align Justify :- Lorem Ipsum is')]")).getCssValue("text-align");
		  String expected_align_justify = "justify";
		  System.out.println("align justify test Result (css:text-align):- "+actual_align_justify+" : "+expected_align_justify);
		  Assert.assertEquals(actual_align_justify, expected_align_justify);
		  
		  Thread.sleep(3000);
		  
		  back(driver);
	  }
	  
	  @Test(priority = 23,enabled = true)
	  public void delete_all_3() throws InterruptedException {

		  clear_textbox();
		  //System.exit(0);
	  }
	  
	  @Test(priority = 24,enabled = true)
      public void orderList_default() throws InterruptedException, AWTException {
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@id='dropdown-menu-formatOLOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).click();
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Order List Default:");
		  Thread.sleep(1000);
		  Robot robot_ol1 = new Robot();
		  robot_ol1.keyPress(KeyEvent.VK_ENTER);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);		  
		  robot_ol1.keyPress(KeyEvent.VK_ENTER);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);
		  robot_ol1.keyPress(KeyEvent.VK_ENTER);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
//		  String actual_default = driver.findElement(By.xpath("//div[@id='dropdown-menu-formatOLOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).getAttribute("title");
//		  String expected_default = "Default";
//		  Assert.assertEquals(actual_default, expected_default);
		  
		    save(driver);
		    preview(driver);
		  
		  String actual_OL_default = driver.findElement(By.xpath("//*[contains(text(),'Order List Default')]/parent::*")).getTagName();
		  String expected_OL_default = "ol";		  
		  System.out.println("order list default test Result (TagName):- "+actual_OL_default+" : "+expected_OL_default);
		  Assert.assertEquals(actual_OL_default, expected_OL_default);		  
		  Thread.sleep(2000);
		  
		  back(driver);
	  }
	  
	  @Test(priority = 25,enabled = true)
	  public void delete_all_4() throws InterruptedException {

		  clear_textbox();
	  }
	  
	  @Test(priority = 26,enabled = true)
	  public void orderlist_lower_alpha() throws InterruptedException, AWTException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[contains(text(),'Lower Alpha')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Order List Lower Alpha:");
		  Thread.sleep(1000);
		  Robot robot_ol2 = new Robot();
		  robot_ol2.keyPress(KeyEvent.VK_ENTER);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);
		  
		  robot_ol2.keyPress(KeyEvent.VK_ENTER);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		  Thread.sleep(1000);
		  robot_ol2.keyPress(KeyEvent.VK_ENTER);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
//		  String actual_loweralpha = driver.findElement(By.xpath("//a[contains(text(),'Lower Alpha')]")).getAttribute("title");
//		  String expected_loweralpha = "Lower Alpha";
//		  Assert.assertEquals(actual_loweralpha, expected_loweralpha);
		  
		    save(driver);
		    preview(driver);
		  
		  String actual_OL_Lower_Alpha = driver.findElement(By.xpath("//*[contains(text(),'Order List Lower Alpha')]/parent::*")).getCssValue("list-style-type");
		  String expected_OL_Lower_Alpha = "lower-alpha";		
		  System.out.println("order list lower alpha test Result (css:list-style-type):- "+actual_OL_Lower_Alpha+" : "+expected_OL_Lower_Alpha);
		  Assert.assertEquals(actual_OL_Lower_Alpha, expected_OL_Lower_Alpha);	
		  
		  Thread.sleep(2000);
		  
		  back(driver);
	  }
	  
	  @Test(priority = 27,enabled = true)
	  public void delete_all_5() throws InterruptedException {

		  clear_textbox();
	  }
	  
	  @Test(priority = 28,enabled = false)
	  public void orderlist_lower_greek() throws InterruptedException, AWTException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Lower Greek')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Order List Lower Greek:");
	  Thread.sleep(1000);
	  Robot robot_ol3 = new Robot();
	  robot_ol3.keyPress(KeyEvent.VK_ENTER);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ol3.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ol3.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");

//	  String actual_lowergreek = driver.findElement(By.xpath("//a[contains(text(),'Lower Greek')]")).getAttribute("title");
//	  String expected_lowergreek = "Lower Greek";
//	  Assert.assertEquals(actual_lowergreek, expected_lowergreek);
	  
	    save(driver);
	    preview(driver);
	  
	  String actual_OL_Lower_Greek = driver.findElement(By.xpath("//*[contains(text(),'Order List Lower Greek')]/parent::*")).getCssValue("list-style-type");
	  String expected_OL_Lower_Greek = "lower-greek";
	  System.out.println("order list lower greek test Result (css:list-style-type):- "+actual_OL_Lower_Greek+" : "+expected_OL_Lower_Greek);
	  Assert.assertEquals(actual_OL_Lower_Greek, expected_OL_Lower_Greek);	
	  
	  Thread.sleep(2000);
	  
	  back(driver);
	  }
	  
	  @Test(priority = 29,enabled = false)
	  public void delete_all_6() throws InterruptedException {
		  clear_textbox();
	  }
	  
	  @Test(priority = 30,enabled = false)
	  public void orderlist_lower_roman() throws InterruptedException, AWTException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[contains(text(),'Lower Roman')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Order List Lower Roman:");
		  Thread.sleep(1000);
		  Robot robot_ol4 = new Robot();
		  robot_ol4.keyPress(KeyEvent.VK_ENTER);
		  Thread.sleep(1000);		  		  
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ol4.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ol4.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "

		  		+ "a type specimen book.");
//	  String actual_lowerroman = driver.findElement(By.xpath("//a[contains(text(),'Lower Roman')]")).getAttribute("title");
//	  String expected_lowerroman = "Lower Roman";
//	  Assert.assertEquals(actual_lowerroman, expected_lowerroman);
	  
	    save(driver);
	    preview(driver);
	  
	  String actual_OL_Lower_Roman = driver.findElement(By.xpath("//*[contains(text(),'Order List Lower Roman')]/parent::*")).getCssValue("list-style-type");
	  String expected_OL_Lower_Roman = "lower-roman";		
	  System.out.println("order list lower roman test Result (css:list-style-type):- "+actual_OL_Lower_Roman+" : "+expected_OL_Lower_Roman);
	  Assert.assertEquals(actual_OL_Lower_Roman, expected_OL_Lower_Roman);
	  
	  Thread.sleep(2000);
	  
	  back(driver);
	  }
	  
	  @Test(priority = 31,enabled = false)
	  public void delete_all_7() throws InterruptedException {
		  clear_textbox();
	  }
	
	  @Test(priority = 32,enabled = false)
	  public void orderlist_upper_alpha() throws InterruptedException, AWTException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[contains(text(),'Upper Alpha')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Order List Upper Alpha:");
		  Thread.sleep(1000);
		  Robot robot_ol5 = new Robot();
		  robot_ol5.keyPress(KeyEvent.VK_ENTER);
		  Thread.sleep(1000);		  		  
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ol5.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ol5.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
//	  String actual_upperalpha = driver.findElement(By.xpath("//a[contains(text(),'Upper Alpha')]")).getAttribute("title");
//	  String expected_upperalpha = "Upper Alpha";
//	  Assert.assertEquals(actual_upperalpha, expected_upperalpha);
	  
	    save(driver);
	    preview(driver);
	  
	  String actual_OL_Upper_Alpha = driver.findElement(By.xpath("//*[contains(text(),'Order List Upper Alpha')]/parent::*")).getCssValue("list-style-type");
	  String expected_OL_Upper_Alpha = "upper-alpha";		
	  System.out.println("order list upper alpha test Result (css:list-style-type):- "+actual_OL_Upper_Alpha+" : "+expected_OL_Upper_Alpha);
	  Assert.assertEquals(actual_OL_Upper_Alpha, expected_OL_Upper_Alpha);	  
	  
	  Thread.sleep(2000);
	  
	  back(driver);
	  }
	  
	  @Test(priority = 33,enabled = false)
	  public void delete_all_8() throws InterruptedException {;
		  clear_textbox();
	  }
	
	  
	  @Test(priority = 34,enabled = false)
	  public void orderlist_upper_roman() throws InterruptedException, AWTException {
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'formatOLOptions')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[contains(text(),'Upper Roman')]")).click();
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Order List Upper Roman:");
		  Thread.sleep(1000);
		  Robot robot_ol6 = new Robot();
		  robot_ol6.keyPress(KeyEvent.VK_ENTER);
		  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ol6.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ol6.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
//	  String actual_upperroman = driver.findElement(By.xpath("//a[contains(text(),'Upper Roman')]")).getAttribute("title");
//	  String expected_upperroman = "Upper Roman";
//	  Assert.assertEquals(actual_upperroman, expected_upperroman);
	  
	    save(driver);
	    preview(driver);
	  
	  String actual_OL_Upper_Roman = driver.findElement(By.xpath("//*[contains(text(),'Order List Upper Roman')]/parent::*")).getCssValue("list-style-type");
	  String expected_OL_Upper_Roman = "upper-roman";
	  System.out.println("order list upper roman test Result (css:list-style-type):- "+actual_OL_Upper_Roman+" : "+expected_OL_Upper_Roman);
	  Assert.assertEquals(actual_OL_Upper_Roman, expected_OL_Upper_Roman);
	  
	  Thread.sleep(2000);
	  
	  back(driver);
	  }
	  
	  @Test(priority = 35,enabled = false)
	  public void delete_all_9() throws InterruptedException {

		  clear_textbox();
		  //System.exit(0);
	  }
	  
	  @Test(priority = 36)
	  public void unorderlist_default() throws InterruptedException, AWTException {
		  
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@id='dropdown-menu-formatULOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).click();
		  //driver.findElement(By.xpath("//a[contains(text(),'Default')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Unorder List Default:");
		  Thread.sleep(1000);
		  Robot robot_ul1 = new Robot();
		  robot_ul1.keyPress(KeyEvent.VK_ENTER);
		  Thread.sleep(1000);		  		  
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);	  
	  robot_ul1.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ul1.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
//	  String actual_default = driver.findElement(By.xpath("//div[@id='dropdown-menu-formatULOptions-1']//a[@class='fr-command'][contains(text(),'Default')]")).getAttribute("title");
//	  String expected_default = "Default";
//	  Assert.assertEquals(actual_default, expected_default);
	  
	  
	    save(driver);
	    preview(driver);
	    
	  String actual_UL_Default = driver.findElement(By.xpath("//*[contains(text(),'Unorder List Default')]/parent::*")).getTagName();
	  String expected_UL_Default = "ul";		
	  System.out.println("unorder list default test Result (TagName):- "+actual_UL_Default+" : "+expected_UL_Default);
	  Assert.assertEquals(actual_UL_Default, expected_UL_Default);	
	  	 
	  Thread.sleep(2000);
	  
	  back(driver);
	  }
	  
//	  @Test(priority = 43)
//	  public void Save_ul1() throws InterruptedException {
//		  save(driver);
//		  //back(driver);
//		  //3 back buttons found on page so added this - Manish
//		  List<WebElement> listBackButton = driver.findElements(By.xpath("//button[contains(text(),'Back')]") );
//		  if(listBackButton.size()>0)
//		  {
//			  listBackButton.get(0).click();
//		  }
//		  
//		  driver.get(url);
//		  
//	 }
	  
	  @Test(priority = 37)
	  public void delete_all_10() throws InterruptedException {

		  clear_textbox();
	  }
	  
	  @Test(priority = 38)
	  public void unorderlist_circle() throws InterruptedException, AWTException {
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[contains(text(),'Circle')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Unorder List Circle:");
		  Thread.sleep(1000);
		  Robot robot_ul2 = new Robot();
		  robot_ul2.keyPress(KeyEvent.VK_ENTER);
		  Thread.sleep(1000);		  
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ul2.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ul2.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
//	  String actual_circle = driver.findElement(By.xpath("//a[contains(text(),'Circle')]")).getAttribute("title");
//	  String expected_circle = "Circle";
//	  Assert.assertEquals(actual_circle, expected_circle);
	  
	    save(driver);
	    preview(driver);
	  
	  String actual_UL_Circle = driver.findElement(By.xpath("//*[contains(text(),'Unorder List Circle')]/parent::*")).getCssValue("list-style-type");
	  String expected_UL_Circle = "circle";	
	  System.out.println("unorder list circle test Result (css:list-style-type):- "+actual_UL_Circle+" : "+expected_UL_Circle);
	  Assert.assertEquals(actual_UL_Circle, expected_UL_Circle);
	  
	  
	  Thread.sleep(2000);
	  
	  back(driver);
	  }
	  
	  @Test(priority = 39)
	  public void delete_all_11() throws InterruptedException {

		  clear_textbox();
	  }
	  
	  @Test(priority = 40,enabled = false)
	  public void unorderlist_disc() throws InterruptedException, AWTException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[contains(text(),'Disc')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Unorder List Disc:");
		  Thread.sleep(1000);
		  Robot robot_ul3 = new Robot();
		  robot_ul3.keyPress(KeyEvent.VK_ENTER);
		  Thread.sleep(1000);		  
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ul3.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ul3.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
//	  String actual_disc = driver.findElement(By.xpath("//a[contains(text(),'Disc')]")).getAttribute("title");
//	  String expected_disc = "Disc";
//	  Assert.assertEquals(actual_disc, expected_disc);
	  
	    save(driver);
	    preview(driver);
	  
	  String actual_UL_Disc = driver.findElement(By.xpath("//*[contains(text(),'Unorder List Disc')]/parent::*")).getCssValue("list-style-type");
	  String expected_UL_Disc = "disc";	
	  System.out.println("unorder list disc test Result (css:list-style-type):- "+actual_UL_Disc+" : "+expected_UL_Disc);
	  Assert.assertEquals(actual_UL_Disc, expected_UL_Disc);
	  
	  Thread.sleep(2000);
	  
	  back(driver);
	  
	  }
	  
	  @Test(priority = 41,enabled = false)
	  public void delete_all_12() throws InterruptedException {

		  clear_textbox();
	  }
	  
	  @Test(priority = 42,enabled = false)
	  public void unorderlist_square() throws InterruptedException, AWTException {
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'formatULOptions')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[contains(text(),'Square')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Unorder List Square:");
		  Thread.sleep(1000);
		  Robot robot_ul4 = new Robot();
		  robot_ul4.keyPress(KeyEvent.VK_ENTER);
		  Thread.sleep(1000);		  
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ul4.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
	  Thread.sleep(1000);
	  robot_ul4.keyPress(KeyEvent.VK_ENTER);
	  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
		  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
		  		+ "a type specimen book.");
//	  String actual_square = driver.findElement(By.xpath("//a[contains(text(),'Square')]")).getAttribute("title");
//	  String expected_square = "Square";
//	  Assert.assertEquals(actual_square, expected_square);
	  
	    save(driver);
	    preview(driver);
	  
	  String actual_UL_Square = driver.findElement(By.xpath("//*[contains(text(),'Unorder List Square')]/parent::*")).getCssValue("list-style-type");
	  String expected_UL_Square = "square";	
	  System.out.println("unorder list square test Result (css:list-style-type):- "+actual_UL_Square+" : "+expected_UL_Square);
	  Assert.assertEquals(actual_UL_Square, expected_UL_Square);
	  
	  Thread.sleep(2000);
	  
	  back(driver);
	  }
	  
	  
	  @Test(priority = 43,enabled = false)
	  public void delete_all_13() throws InterruptedException {

		  clear_textbox();
		  //System.exit(0);
	  }
	  
	  @Test(priority = 44,enabled = true)
	  public void Indent() throws InterruptedException, AWTException 
	  {
		  Thread.sleep(3000);
		  WebElement textbox =  driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));
		  Thread.sleep(3000);
		  //.click()
		  driver.findElement(By.xpath("//button[@id='indent-1']")).click();
		  Thread.sleep(1000);
		  textbox.sendKeys("Indent :- Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
			  		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make "
			  		+ "a type specimen book.");
		    
		  save(driver);
		  preview(driver);
		  
		  String actualIndent_value =  driver.findElement(By.xpath("//*[contains(text(),'Indent :- Lorem Ipsum is simpl')]")).getAttribute("style");
		  String expectedIndent_value="margin-left: 20px;";
		  

		  System.out.println("Indent Result (style):- "+actualIndent_value+" : "+expectedIndent_value);
		  Assert.assertEquals(actualIndent_value, expectedIndent_value);
	  
		  Thread.sleep(2000);
	  
		  back(driver);
	  }
	  
	  @Test(priority = 45,enabled = true)
	  public void delete_all_14() throws InterruptedException {

		  clear_textbox();
		  //System.exit(0);
	  }
	  
	  
	  @Test(priority = 46)
	  public void insert_link() throws InterruptedException {
		  clear_textbox();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[starts-with(@id,'insertLink')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.name("href")).sendKeys("www.w3schools.com");
//		  String actual_link = driver.findElement(By.name("href")).getText();
//		  String expected_link = "www.google.com";
//		  Assert.assertEquals(actual_link, expected_link);
//		  Thread.sleep(1000);
		  driver.findElement(By.name("text")).sendKeys("w3schools");
//		  System.out.println(driver.findElement(By.name("text")).getText());
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[contains(text(),'Insert')]")).click();
		  Thread.sleep(3000);
		  
		    save(driver);
		    preview(driver);
		    
		    List<WebElement> linkArr =  driver.findElements(By.xpath("//a[contains(text(),'w3schools')]"));
		    System.out.println("Link Count: "+linkArr.size());
		    //wait.until(ExpectedConditions.elementToBeClickable(By.linkText("w3schools"))).click();
		    driver.findElement(By.xpath("//a[contains(text(),'w3schools')]")).click();
		    Thread.sleep(3000);
		    
		    driver.findElement(By.xpath("//button[@class='btn save-btn ng-star-inserted']")).click();  // Ok button for open link
		    
		    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		    
		    System.out.println("Tab count: "+tabs.size());
		    Thread.sleep(7000);
		    driver.switchTo().window(tabs.get(1));
		    driver.close();
		    driver.switchTo().window(tabs.get(0));
		    
		    Thread.sleep(2000);
		    
		    back(driver);
	  }
	  
	  @Test(priority = 47,enabled = true)
	  public void linkRename() throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		  //driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).click();
		 
		  List<WebElement> link_Edit_show = driver.findElements(By.xpath("//div[contains(@class, 'fr-popup fr-desktop fr-active')]"));
		  if(link_Edit_show.size()>0)
		  {
			  driver.findElement(By.xpath("//button[starts-with(@id,'linkEdit')]")).click();
			  Thread.sleep(1000);
			  //driver.findElement(By.name("text")).clear(); //not working clear method
			  WebElement textbox_1 = driver.findElement(By.name("text"));
			    Actions actions_ClearText = new Actions(driver);
			    actions_ClearText.keyDown(textbox_1,Keys.CONTROL);
			    actions_ClearText.sendKeys(Keys.chord("a"));
			    actions_ClearText.keyUp(Keys.CONTROL);
			    actions_ClearText.sendKeys(Keys.DELETE);
			    
			    
			    Action action_ClearText = actions_ClearText.build();
			    
			    action_ClearText.perform();
			    Thread.sleep(3000);
			  driver.findElement(By.name("text")).sendKeys("w3schools Updated");
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
			  Thread.sleep(2000);
			  
			    save(driver);
			    preview(driver);
			    
			    Thread.sleep(2000);
			    
			    back(driver);
		  }
		  Thread.sleep(1000);
		  
		  //driver.findElement(By.xpath("//a[contains(text(),'Go To Google')]")).click();
		  //Thread.sleep(2000);
//		  driver.findElement(By.xpath("//button[starts-with(@id,'linkStyle')]")).click();
//		  Thread.sleep(1000);
//		  driver.findElement(By.linkText("Green")).click();
//		  Thread.sleep(1000);
//		  driver.findElement(By.xpath("//button[starts-with(@id,'linkStyle')]")).click();
//		  Thread.sleep(1000);
//		  driver.findElement(By.linkText("Thick")).click();
//		  Thread.sleep(1000);

	  }
	  
	  @Test(priority = 48)
	  public void delete_all_15() throws InterruptedException {

		  clear_textbox();
	  }
	  
	  @Test(priority = 49,enabled = true)
	  public void Save_link_update() throws InterruptedException {
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		  Thread.sleep(3000);
		  driver.get(url);
		  
	 }
	  
	  
	  
		 @AfterClass
		 public void closeBrowser() {
			 driver.quit();
		 }
	  

	
//	@Test(priority=3)
//	public void TextBox_Test() throws InterruptedException
//	{
//		
//		//***********************Break 1	
////		driver.findElement(By.id("Text")).click();
////		Thread.sleep(2000);
//		//***********************Break 1	
//		clear_textbox();
//		
//		WebElement textbox_div = driver.findElement(By.xpath("//div[@class='fr-element fr-view']"));		
//		textbox_div.click();
//		Thread.sleep(2000);
//		textbox_div.sendKeys("I am BOLD.");
//	    Actions actions1 = new Actions(driver);
//	    actions1.keyDown(textbox_div,Keys.SHIFT);
//	    actions1.sendKeys(Keys.HOME);
//	    //actions1.keyUp(Keys.CONTROL);
//	    
//	    Action action1 = actions1.build();
//	    
//	    action1.perform();
//	    driver.findElement(By.id("bold-1")).click();
//	    Thread.sleep(1000);		   
//	    
//	    System.out.println("Bold selected");
//	    Thread.sleep(5000);
//	    textbox_div.click();
//		textbox_div.sendKeys(Keys.ENTER);
//		
//		 driver.findElement(By.id("bold-1")).click();
//		
//		
//		textbox_div.sendKeys("I am Heading 1.");		
//		textbox_div.sendKeys(Keys.ENTER);
//		
//		textbox_div.sendKeys("I am Heading 2.");		
//		textbox_div.sendKeys(Keys.ENTER);
//		
//		textbox_div.sendKeys("I am Heading 3.");		
//		textbox_div.sendKeys(Keys.ENTER);
//		
//		textbox_div.sendKeys("I am Heading 4.");		
//		textbox_div.sendKeys(Keys.ENTER);
//		
//		textbox_div.sendKeys("I am Body.");		
//		textbox_div.sendKeys(Keys.ENTER);
//		
//		textbox_div.sendKeys("I am Quote.");		
//		textbox_div.sendKeys(Keys.ENTER);
//		Thread.sleep(15000);
//	}
	
	
	
}
