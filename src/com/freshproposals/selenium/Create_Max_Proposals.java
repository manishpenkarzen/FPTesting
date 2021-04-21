package com.freshproposals.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Create_Max_Proposals extends Common_Methods {
	WebDriver driver;
	WebDriverWait wait;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\FreshPraposal\\Freshproposals_Testing\\Freshproposals_Testing\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(95, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(95,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		
		}
	
	@Test(priority = 0)
	public void URL() {
		//driver.get("https://beta.freshproposals.net");
		driver.get("https://live.freshproposals.com");
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		 driver.findElement(By.id("email")).sendKeys("iamrossjonathan@gmail.com");
		 driver.findElement(By.id("passwordTXT")).sendKeys("Alexajonathan@123");
	   	 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 Thread.sleep(10000);
		 
	}
	
	@Test(priority = 2)
	public void createProposalsMax() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("linkProposals"))).click();
		Thread.sleep(5000);
		for(int i=0; i<16; i++) {
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='../../assets/add-section-icon.png']"))).click();
			 driver.findElement(By.name("name")).sendKeys(fname+" Sanity1_Proposal "+timestamp);
			 driver.findElement(By.xpath("//button[@type='submit']")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search By Name']"))).sendKeys("Proposals Max");
			 Thread.sleep(3000);
			 
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,1000)");
				
			 driver.findElement(By.xpath("//div[@class='col-lg-12']//div[1]//div[2]//label[1]//span[1]")).click();
			 driver.findElement(By.xpath("//img[@src='../../../assets/calendar.png']")).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ngb-dp-arrow right']//button[@class='btn btn-link ngb-dp-arrow-btn']"))).click();
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'15')]"))).click();
			
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn send-btn']"))).click();
			//createProposalsM(driver);
			back(driver);
		}
		 
	}
	
	
}
