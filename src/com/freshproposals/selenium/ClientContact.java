package com.freshproposals.selenium;

import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class ClientContact extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
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
	  public void CreateNewClient() throws InterruptedException {
			Thread.sleep(10000);
			WebElement Client = driver.findElement(By.id("linkClients"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", Client);

			//Client.click();
			Thread.sleep(5000);
			WebElement Button = driver.findElement(By.xpath("//div[@class='btn add-client-btn ng-star-inserted']//img"));
			Button.click();
			driver.findElement(By.xpath("//input[@formcontrolname='Name']")).sendKeys("Freshproposals");
			driver.findElement(By.xpath("//input[@formcontrolname='WebSiteUrl']")).sendKeys("www.freshproposals.com");
			driver.findElement(By.xpath("//input[@formcontrolname='AddressLine1']")).sendKeys("Kalyaninagr");
			driver.findElement(By.xpath("//input[@formcontrolname='AddressLine2']")).sendKeys("Pune,412216");
			driver.findElement(By.xpath("//input[@formcontrolname='City']")).sendKeys("Pune");
			driver.findElement(By.xpath("//input[@formcontrolname='State']")).sendKeys("Maharashtra");
			driver.findElement(By.xpath("//input[@formcontrolname='Zip']")).sendKeys("41216");
			driver.findElement(By.xpath("//input[@formcontrolname='OfficeMobileNo']")).sendKeys("9098989802");

			
			driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
			System.out.println("New Client Created");
			Thread.sleep(5000);
			}
	@Test(priority = 2)
	public void CreatenewContact() throws InterruptedException {
			WebElement ContactFNAME =driver.findElement(By.xpath("//input[@formcontrolname='FirstName']"));
			ContactFNAME.sendKeys("Rahul");
			WebElement LastName = driver.findElement(By.xpath("//input[@formcontrolname='LastName']"));
			LastName.sendKeys("Sharma");
			WebElement Email =driver.findElement(By.xpath("//input[@formcontrolname='Email']"));
			Email.sendKeys("rahul@gmail.com");
			WebElement MobileNo=driver.findElement(By.xpath("//input[@formcontrolname='MobileNo']"));
			MobileNo.sendKeys("9900345695");
			driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
			System.out.println("New contact created");
			Thread.sleep(7000);
		}

	@Test(priority = 3)
	public void ClientUpdated() throws InterruptedException   {
			driver.findElement(By.xpath("//body/app-root[1]/app-home[1]/div[1]/div[6]/div[1]/app-clients[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Freshproposals");
			Thread.sleep(5000);
			WebElement updateContact = driver.findElement(By.xpath("//img[@src='../../assets/edit-tool-list.svg']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", updateContact);
			Thread.sleep(3000);
			WebElement Address =driver.findElement(By.xpath("//input[@formcontrolname='AddressLine1']"));
			Address.clear();
			Address.sendKeys("Kalyaninagar,opposite to Aagakhan palace");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
			System.out.println("Client updated");
			Thread.sleep(7000);
	}
	@Test(priority = 4)
	public void ContactUpdated() throws InterruptedException {
		   driver.findElement(By.xpath("//body/app-root[1]/app-home[1]/div[1]/div[6]/div[1]/app-clients[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Freshproposals");
			Thread.sleep(5000);
			WebElement updateContact =driver.findElement(By.xpath("//img[@src='../../assets/client_edit_btn.svg']"));

			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", updateContact);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']")).clear();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']")).sendKeys("mynameisrrahul@gmail.com");
			driver.findElement(By.xpath("//input[@formcontrolname='contactNumber']")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname='contactNumber']")).sendKeys("1234567892");
			Thread.sleep(3000);

			driver.findElement(By.xpath("//button[@id='btn-save']")).click();
			Thread.sleep(3000);
			System.out.println("Contact updated");
	}
	
	@Test(priority = 5)
	public void ClientDeleted() throws InterruptedException {
		 driver.findElement(By.xpath("//body/app-root[1]/app-home[1]/div[1]/div[6]/div[1]/app-clients[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Freshproposals");
		 Thread.sleep(5000);
	
		WebElement DeleteContact =driver.findElement(By.xpath("//img[@src='../../assets/trash.svg']"));

			 
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", DeleteContact);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			Thread.sleep(5000);
			System.out.println("Client deleted");
			
			}
	
	 @AfterClass
	  public void closeBrowser() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.close();
	  }
			
}

