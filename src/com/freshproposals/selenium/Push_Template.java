	package com.freshproposals.selenium;
	
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	import com.paulhammant.ngwebdriver.NgWebDriver;
	
	public class Push_Template extends Common_Methods {
		WebDriver driver;
		String unm;
		String pwd;
		
		String Template_SectionName = "Welcome Note";
		String Section_Name;
		
		
		
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
	  public void createTemplate() throws InterruptedException {
		  Thread.sleep(10000);
		  driver.findElement(By.id("linkTemplates")).click();
		  driver.findElement(By.id("searchTemplates")).sendKeys("Coworking Space Proposal");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//img[@src='../../../assets/edit-tool-list.svg']")).click();
		  Thread.sleep(15000);

	}

	  @Test(priority = 2)
	  public void selectPushSection() throws InterruptedException {
		  driver.findElement(By.xpath("//a[contains(text(),'Welcome Note')]")).click();
		  Thread.sleep(5000);
	  }
	  
	  @Test(priority = 3)
	  public void push() {
		  driver.findElement(By.xpath("//button[contains(text(),'Save to library')]")).click();
	  }
	  
	  @Test(priority = 4)
	  public void back() throws InterruptedException {
		  back(driver);
	  }
	  
	  @Test(priority = 5)
	  public void contentLibrary() throws InterruptedException {
		  driver.findElement(By.id("linkContentLib")).click();
		  Thread.sleep(7000);
		  driver.findElement(By.xpath("//img[@src='../../../assets/edit-tool-list.svg']")).click();
	 }
	  
	  @Test(priority = 6)
	  public void sectionName() throws InterruptedException {
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//img[@src='../../../../../assets/edit-tool-list.svg']")).click();
		  Thread.sleep(1000);
		  WebElement get_Section_Name = driver.findElement(By.name("sectionNametxt"));
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  Section_Name = (String) executor.executeScript("return arguments[0].value", get_Section_Name);  
		  System.out.println(Section_Name);
	  }
	
	  
	  @Test(priority = 7)
	  public void Assert() throws InterruptedException {
		  Thread.sleep(2000);
		  Assert.assertEquals(Section_Name, Template_SectionName);
		  
	  }
	  
	  @AfterClass
	  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
		
	  }
	
	}
