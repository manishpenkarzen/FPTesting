package com.freshproposals.selenium;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContentTable extends Common_Methods {
	WebDriver driver;
	WebDriverWait wait;
	String unm;
	String pwd;
	Actions act;
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\FreshPraposal\\Freshproposals_Testing\\Freshproposals_Testing\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);   
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(95, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(95,TimeUnit.SECONDS);
		openURL(driver);

	}
	
	@Test(dataProvider = "User1", priority = 0)
	 public void SetUnmPwd(String unm, String pwd) {
     login(unm, pwd, driver);
	}
	 
	@Test(priority = 1)
	  public void openExistingData() throws InterruptedException {
		  Thread.sleep(10000);
		  createProposal(driver,wait);
		  proposalName(driver,wait);
		  client(driver,wait);
		  scrollWindow(driver);
		  calender(driver,wait);
		  existingDataProposal1(driver,wait);
		  WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='search section']")));
		  search.click();
		  search.sendKeys("Content_Table_Automation");
		  existingDaraProposal2(driver,wait);
		  Thread.sleep(5000);

	 }
	
	@Test(priority = 2)
	public void ct() throws InterruptedException {
		driver.findElement(By.xpath("//thead/tr[1]/td[1]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead/tr[1]/td[1]"))).sendKeys("PHASE");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead/tr[1]/td[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead/tr[1]/td[2]"))).sendKeys("ACTIVITIES");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead/tr[1]/td[3]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead/tr[1]/td[3]"))).sendKeys("DURATION");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead/tr[1]/td[4]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead/tr[1]/td[4]"))).sendKeys("Contact");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[1]"))).sendKeys("1");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[2]"))).sendKeys("Setup and use SEO Audit tools such as Google Analytics, AHREF, etc and preparation of audit report");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[3]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[3]"))).sendKeys("3 Weeks");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[4]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[4]"))).sendKeys("9098761234");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tfoot/tr[1]/td[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tfoot/tr[1]/td[1]"))).sendKeys("F1");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tfoot/tr[1]/td[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tfoot/tr[1]/td[2]"))).sendKeys("F2");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tfoot/tr[1]/td[3]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tfoot/tr[1]/td[3]"))).sendKeys("F3");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tfoot/tr[1]/td[4]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tfoot/tr[1]/td[4]"))).sendKeys("F4");


//		act = new Actions(driver);
//		act.sendKeys(Keys.TAB).build().perform();
//		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[2]//td[1]"))).sendKeys("Analyzing SEO Audit Findings");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[2]//td[2]"))).sendKeys("Use finding from the SEO Audit report and identify activities of SEO campaign to be taken up on priority. Also sequencing, repeating of those activities.");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[2]//td[3]"))).sendKeys("1 Week");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[2]//td[4]"))).sendKeys("Contact");
		
//		act.sendKeys(Keys.TAB).build().perform();
//		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[3]//td[1]"))).sendKeys("Analyzing SEO Audit Findings");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[3]//td[2]"))).sendKeys("Use finding from the SEO Audit report and identify activities of SEO campaign to be taken up on priority. Also sequencing, repeating of those activities.");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[3]//td[3]"))).sendKeys("1 Week");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[3]//td[4]"))).sendKeys("Contact");
//		
	
	}
	
	@Test(priority = 3)
	public void header() {
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Header"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/app-content-table-properties[1]/form[1]/div[1]/div[1]/div[2]/ngb-tabset[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]"))).click();
		WebElement hexcolorbg_header = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='e-hex']")));
		hexcolorbg_header.click();
		hexcolorbg_header.clear();
		hexcolorbg_header.sendKeys("#136d13");
		
		//border color
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/app-content-table-properties[1]/form[1]/div[1]/div[1]/div[2]/ngb-tabset[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]"))).click();
//		WebElement hexcolorborder_header = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='e-hex']")));
//		hexcolorborder_header.click();
//		hexcolorborder_header.clear();
//		hexcolorborder_header.sendKeys("#0f5a15");
		
		 WebElement borderSize = wait.until(ExpectedConditions.elementToBeClickable(By.name("size")));
		 borderSize.click();
		 borderSize.clear();
		 borderSize.sendKeys("10");
		 
		 WebElement padding_top = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingTop")));
		 padding_top.click();
		 padding_top.clear();
		 padding_top.sendKeys("25");
		 
		 WebElement padding_bottom = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingBottom")));
		 padding_bottom.click();
		 padding_bottom.clear();
		 padding_bottom.sendKeys("25");
		 
		 WebElement padding_left = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingLeft")));
		 padding_left.click();
		 padding_left.clear();
		 padding_left.sendKeys("25");
		 
		 WebElement padding_right = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingRight")));
		 padding_right.click();
		 padding_right.clear();
		 padding_right.sendKeys("25");
		 
	}
	
	@Test(priority = 4)
	public void body() {
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Body"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/app-content-table-properties[1]/form[1]/div[1]/div[1]/div[2]/ngb-tabset[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]"))).click();
		WebElement hexcolorbg_header = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='e-hex']")));
		hexcolorbg_header.click();
		hexcolorbg_header.clear();
		hexcolorbg_header.sendKeys("#661d54");
		
		//border color
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/app-content-table-properties[1]/form[1]/div[1]/div[1]/div[2]/ngb-tabset[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]"))).click();
//		WebElement hexcolorborder_header = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='e-hex']")));
//		hexcolorborder_header.click();
//		hexcolorborder_header.clear();
//		hexcolorborder_header.sendKeys("#0f5a15");
		
		 WebElement borderSize = wait.until(ExpectedConditions.elementToBeClickable(By.name("size")));
		 borderSize.click();
		 borderSize.clear();
		 borderSize.sendKeys("10");
		 
		 WebElement padding_top = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingTop")));
		 padding_top.click();
		 padding_top.clear();
		 padding_top.sendKeys("25");
		 
		 WebElement padding_bottom = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingBottom")));
		 padding_bottom.click();
		 padding_bottom.clear();
		 padding_bottom.sendKeys("25");
		 
		 WebElement padding_left = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingLeft")));
		 padding_left.click();
		 padding_left.clear();
		 padding_left.sendKeys("25");
		 
		 WebElement padding_right = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingRight")));
		 padding_right.click();
		 padding_right.clear();
		 padding_right.sendKeys("25");
		 
	}
	
	@Test(priority = 5)
	public void footer() {
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Footer"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/app-content-table-properties[1]/form[1]/div[1]/div[1]/div[2]/ngb-tabset[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]"))).click();
		WebElement hexcolorbg_header = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='e-hex']")));
		hexcolorbg_header.click();
		hexcolorbg_header.clear();
		hexcolorbg_header.sendKeys("#2f1897");
		
		//border color
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/app-content-table-properties[1]/form[1]/div[1]/div[1]/div[2]/ngb-tabset[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]"))).click();
//		WebElement hexcolorborder_header = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='e-hex']")));
//		hexcolorborder_header.click();
//		hexcolorborder_header.clear();
//		hexcolorborder_header.sendKeys("#0f5a15");
		
		 WebElement borderSize = wait.until(ExpectedConditions.elementToBeClickable(By.name("size")));
		 borderSize.click();
		 borderSize.clear();
		 borderSize.sendKeys("10");
		 
		 WebElement padding_top = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingTop")));
		 padding_top.click();
		 padding_top.clear();
		 padding_top.sendKeys("25");
		 
		 WebElement padding_bottom = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingBottom")));
		 padding_bottom.click();
		 padding_bottom.clear();
		 padding_bottom.sendKeys("25");
		 
		 WebElement padding_left = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingLeft")));
		 padding_left.click();
		 padding_left.clear();
		 padding_left.sendKeys("25");
		 
		 WebElement padding_right = wait.until(ExpectedConditions.elementToBeClickable(By.name("paddingRight")));
		 padding_right.click();
		 padding_right.clear();
		 padding_right.sendKeys("25");
		 
	}
	
	
	@AfterClass
	  public void closeBrowser() throws InterruptedException {
	  quitBrowser(driver);
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

