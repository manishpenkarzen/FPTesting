package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshproposals.selenium.Common_Methods;

public class FontPropertiesInProposal extends Common_Methods{
	SoftAssert softAssertion= new SoftAssert();
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
	 @Test(dataProvider = "User2", priority = 0)
	 public void SetUnmPwd(String unm, String pwd) {
      login(unm, pwd, driver);
	}
	 @Test(priority=1)
	 public void FontPropertiesHeading1() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1882;editor=true");
			Thread.sleep(5000);

		 WebElement textonpageH1 = driver.findElement(By.xpath("//p[contains(text(),'Heading1')]"));
		 String Actualfont =textonpageH1.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="36px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH1.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#034e5d";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH1.getCssValue("font-style");
	  		 String expectedStyle ="normal";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH1.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=driver.findElement(By.xpath("//p[contains(text(),'Heading1')]")).getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Nunito";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =driver.findElement(By.xpath("//p[contains(text(),'Heading1')]")).getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="400";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
	 }
	 @Test(priority=2)
	 public void Heading1PropertiesInPreview() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/viewproposal/1882/preview/proposals");
			Thread.sleep(5000);

		 WebElement textonpageH1 = driver.findElement(By.xpath("//p[contains(text(),'Heading1')]"));
		 String Actualfont =textonpageH1.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="36px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH1.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#034e5d";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH1.getCssValue("font-style");
	  		 String expectedStyle ="normal";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH1.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=driver.findElement(By.xpath("//p[contains(text(),'Heading1')]")).getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Nunito";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =driver.findElement(By.xpath("//p[contains(text(),'Heading1')]")).getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="400";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
		 
	 }
	 @Test(priority=3)
	 public void FontPropertiesHeading2() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1882;editor=true");
			Thread.sleep(5000);

		 WebElement textonpageH2 = driver.findElement(By.xpath("//p[contains(text(),'Heading2')]"));
		 String Actualfont =textonpageH2.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="28px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH2.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#00422d";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH2.getCssValue("font-style");
	  		 String expectedStyle ="normal";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH2.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=textonpageH2.getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Montserrat";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =textonpageH2.getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="700";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
		 
	 }
	 @Test(priority=4)
	 public void FontPropertiesHeading2Preview() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/viewproposal/1882/preview/proposals");
			Thread.sleep(5000);

		 WebElement textonpageH2 = driver.findElement(By.xpath("//p[contains(text(),'Heading2')]"));
		 String Actualfont =textonpageH2.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="28px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH2.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#00422d";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH2.getCssValue("font-style");
	  		 String expectedStyle ="normal";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH2.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=textonpageH2.getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Montserrat";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =textonpageH2.getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="700";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
		 
	 }
	 @Test(priority=5)
	 public void Heading3Properties() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1882;editor=true");
			Thread.sleep(5000);

		 WebElement textonpageH2 = driver.findElement(By.xpath("//p[contains(text(),'Heading3')]"));
		 String Actualfont =textonpageH2.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="20px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH2.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#616463";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH2.getCssValue("font-style");
	  		 String expectedStyle ="normal";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH2.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=textonpageH2.getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Lato";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =textonpageH2.getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="400";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
		 
		 
	 }
	 @Test(priority=6)
	 public void Heading3PropertiesInPreview() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/viewproposal/1882/preview/proposals");
			Thread.sleep(5000);

		 WebElement textonpageH2 = driver.findElement(By.xpath("//p[contains(text(),'Heading3')]"));
		 String Actualfont =textonpageH2.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="20px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH2.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#616463";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH2.getCssValue("font-style");
	  		 String expectedStyle ="normal";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH2.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=textonpageH2.getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Lato";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =textonpageH2.getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="400";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
		 
		 
	 }
	 @Test(priority=7)
	 public void Heading4FontProperties() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1882;editor=true");
			Thread.sleep(5000);

		 WebElement textonpageH2 = driver.findElement(By.xpath("//p[contains(text(),'Heading4')]"));
		 String Actualfont =textonpageH2.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="16px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH2.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#c93c62";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH2.getCssValue("font-style");
	  		 String expectedStyle ="normal";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH2.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=textonpageH2.getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Poppins";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =textonpageH2.getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="400";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
		 
	 }
	 @Test(priority=8)
	 public void Heading4FontPropertiesInPreview() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/viewproposal/1882/preview/proposals");
			Thread.sleep(5000);

		 WebElement textonpageH2 = driver.findElement(By.xpath("//p[contains(text(),'Heading4')]"));
		 String Actualfont =textonpageH2.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="16px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH2.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#c93c62";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH2.getCssValue("font-style");
	  		 String expectedStyle ="normal";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH2.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=textonpageH2.getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Poppins";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =textonpageH2.getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="400";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
		 
	 }
	 @Test(priority=9)
	 public void FontBodyProperties() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1882;editor=true");
			Thread.sleep(5000);

		 WebElement textonpageH2 = driver.findElement(By.xpath("//p[contains(text(),'Body')]"));
		 String Actualfont =textonpageH2.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="14px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH2.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#000000";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH2.getCssValue("font-style");
	  		 String expectedStyle ="normal";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH2.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=textonpageH2.getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Roboto";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =textonpageH2.getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="400";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
		 
		 
	 }
	 @Test(priority=10)
	 public void FontBodyPropertiesInPreview() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/viewproposal/1882/preview/proposals");
			Thread.sleep(5000);

		 WebElement textonpageH2 = driver.findElement(By.xpath("//p[contains(text(),'Body')]"));
		 String Actualfont =textonpageH2.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="14px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH2.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#000000";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH2.getCssValue("font-style");
	  		 String expectedStyle ="normal";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH2.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=textonpageH2.getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Roboto";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =textonpageH2.getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="400";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
		 
	 }
	 @Test(priority=11)
	 public void FontQuoteProperties() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/proposals/editProposal;proposalId=1882;editor=true");
			Thread.sleep(5000);

		 WebElement textonpageH2 = driver.findElement(By.xpath("//p[contains(text(),'Quote')]"));
		 String Actualfont =textonpageH2.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="14px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH2.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#000000";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH2.getCssValue("font-style");
	  		 String expectedStyle ="italic";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH2.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=textonpageH2.getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Montserrat";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =textonpageH2.getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="700";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
		 
		 
		 
	 }
	 @Test(priority=12)
	 public void FontQuotePropertiesInPreview() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/viewproposal/1882/preview/proposals");
			Thread.sleep(5000);

		 WebElement textonpageH2 = driver.findElement(By.xpath("//p[contains(text(),'Quote')]"));
		 String Actualfont =textonpageH2.getCssValue("font-size");
			//System.out.println("Font Size of the text is"+font);
			String expected ="14px";
			softAssertion.assertEquals(Actualfont,expected);	
			String color =textonpageH2.getCssValue("color");
	  		//System.out.println(color);
	  		String expectedcolor ="#000000";
	  		String actual = Color.fromString(color).asHex();
	  		//System.out.println("Font color is ="+hex);
	  		softAssertion.assertEquals(actual,expectedcolor);
	  		String actualstyle = textonpageH2.getCssValue("font-style");
	  		 String expectedStyle ="italic";
	  		softAssertion.assertEquals(expectedStyle,actualstyle);
	  		 String ActualAlign=textonpageH2.getCssValue("text-align");
	   		// System.out.println("Alignment of the text is="+Align);
	   		 String expectedAlign ="left";
	   		softAssertion.assertEquals(expectedAlign,ActualAlign);
	   	 String ActualFontfamily=textonpageH2.getCssValue("font-family");
	  		// System.out.println("Font family is="+family);
	  	  String expectedFontFamily ="Montserrat";
	  		softAssertion.assertEquals(expectedFontFamily,ActualFontfamily);
	  		 String ActualFontWeight =textonpageH2.getCssValue("font-weight");
	  		 //System.out.println("Weight of the font is="+Weight);
	  	  String expectedFontWeight ="700";
	  		softAssertion.assertEquals(ActualFontWeight,expectedFontWeight);
	  		softAssertion.assertAll();
		 
	 }
	 @AfterClass
	  public void closeBrowser() {
		  driver.quit();
	  }

}



