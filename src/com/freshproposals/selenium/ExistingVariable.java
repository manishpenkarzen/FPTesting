package com.freshproposals.selenium;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExistingVariable extends Common_Methods{
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
	  public void verifyVeriable() {
		  String[] expected = new String[] {"Freshproposal","nikeeta3011@gmail.com","8888888888","Mrs.dont","Fresh proposals.com","Nikeeta","Shelar1","nikeeta@zenincloud.com","SeleniumVariableTesting"};

		  driver.get("http://beta1.freshproposals.net/home/viewproposal/1259/preview/proposals");
		  List<WebElement> var=driver.findElements(By.xpath("//div[@id='froalapage1-fpText1119201917471418']//p"));
		  int variables=var.size();
		  
		  System.out.println("There are total "+variables+" Elements");
		  for(int i=0;i<variables;i++) {
			  String actual=var.get(i).getText();
				System.out.println( var.get(i).getText());
			//	Assert.assertEquals(actual, expected[i]);
			 
			  
		  }
		
		  
	  }
	@AfterClass
	public void teardown() {
		  driver.quit();
		  
	}
	
	
	
}
