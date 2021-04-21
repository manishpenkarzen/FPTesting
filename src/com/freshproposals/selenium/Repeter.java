package com.freshproposals.selenium;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Repeter extends Common_Methods{
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
	 @Test(priority=1)
	 public void verifyRepeter() throws InterruptedException {
		Thread.sleep(10000);
		driver.get("https://beta.freshproposals.net/home/proposals/editProposal;proposalId=1657;editor=true");
		String text =driver.findElement(By.xpath("//div[@id='froalapage1-FPText910202016563099']//span[contains(text(),'FreshProposals')]")).getCssValue("font-size");
		System.out.println(text);
		Assert.assertEquals(text, "28px");
		
		WebElement repeter = driver.findElement(By.xpath("//p[@class='repeater-element']//img"));
		repeter.click();
		WebElement box1=driver.findElement(By.xpath("//div[@id='froalapage1-fpText126201914515090']//span[contains(text(),'Freshproposals')]"));
		String fontsizeinrepeter=box1.getCssValue("font-size");
		Assert.assertEquals(fontsizeinrepeter, "28px");
		box1.click();
		Thread.sleep(2000);
		WebElement P4 = driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]"));
		
		P4.click();
		Thread.sleep(2000);

	WebElement heading1 = driver.findElement(By.xpath("//a[@class='fr-command fpHeading1']"));
	heading1.click();
	 Thread.sleep(2000);
	//div[@id='section_section6289']//div[@class='fr-wrapper']//span[1]

	WebElement text2 = driver.findElement(By.xpath("//div[@id='section_section6289']//div[@class='fr-wrapper']//span[1]"));
	 String section1font =text2.getCssValue("font-size");
	 Assert.assertEquals(section1font, "36px");
	 driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]")).click();
	 Thread.sleep(2000);

	 driver.findElement(By.xpath("//div[@class='exit-styling-mode btn next-btn']")).click();
	 Thread.sleep(2000);

	 String text1 =driver.findElement(By.xpath("//div[@class='fr-element fr-view']//span[contains(text(),'Freshproposals')]")).getCssValue("font-size");
	 Assert.assertEquals(text1, "36px");
		 Thread.sleep(2000);
		 WebElement section2 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
		 section2.click();
		 WebElement page2text = driver.findElement(By.xpath("//div[@id='section_section6289']//div[@class='fr-wrapper']//span[1]"));
		 String section2font =page2text.getCssValue("font-size");
		 Assert.assertEquals(section2font, "36px");
		 Thread.sleep(3000);
		 WebElement section3 = driver.findElement(By.xpath("//div[@id='content']//li[3]"));
		 section3.click();
		 WebElement page3text = driver.findElement(By.xpath("//div[@id='froalapage1-fpText126201914515074']//span[contains(text(),'Freshproposals')]"));
		String section3font = page3text.getCssValue("font-size");
		//System.out.println(section3font);
		Assert.assertEquals(section3font,"36px");
		Thread.sleep(3000);
		WebElement section1 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[1]"));
		section1.click();
		WebElement info = driver.findElement(By.xpath("//div[@class='fixed-sidebar col-lg-2 offset-lg-10 p-0 right-zero']//li[1]//a[1]"));
		//driver.navigate().refresh();
		//Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(info);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", info);
		WebElement sidepannel = driver.findElement(By.xpath("//div[@class='card-body p-0']"));
		sidepannel.click();
		// Actions actions = new Actions(driver);
		 actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		 Thread.sleep(5000);
		//repeter.click();
		driver.findElement(By.xpath("//p[@class='repeater-element']//img")).click();
		//box1.click();
		 Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='froalapage1-fpText126201914515090']//span[contains(text(),'Freshproposals')]")).click();
		//P4.click();
		 Thread.sleep(2000);

		 driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]")).click();
		 Thread.sleep(2000);

		 WebElement heading2=driver.findElement(By.xpath("//a[@class='fr-command fpHeading2']"));
		 heading2.click();
		 Thread.sleep(3000);

		 driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[@class='exit-styling-mode btn next-btn']")).click();
		 
		Thread.sleep(5000);
		 	//driver.quit();
	 }
	 @Test(priority=2)
	 public void generateproposalfromtemplate() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1201");
		 WebElement generateProposalBtn = driver.findElement(By.xpath("//button[@class='btn add-sect-btn']"));
		 generateProposalBtn.click();
		 Thread.sleep(3000);
		 //driver.findElement(By.name("name")).sendKeys("selenium");
		//WebElement ProposalName =driver.findElement(By.xpath("//input[@formcontrolname='name']"));
		 driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("seleniumProposals");
		 driver.findElement(By.xpath("//button[@class='btn save-btn']")).click();
		 //ProposalName.sendKeys("seleniumproposalfromtemplate");
		 Thread.sleep(3000);
		 WebElement SubmitBtn = driver.findElement(By.xpath("//button[@class='btn save-btn']"));
		 SubmitBtn.click();
		 Thread.sleep(3000);
		 WebElement ClientBtn = driver.findElement(By.xpath("//button[@class='btn btn-link pl-2']"));
		 ClientBtn.click();
		 WebElement checkbox = driver.findElement(By.xpath("//body//div[@class='col-lg-10 offset-lg-1']//div[@class='col-lg-10 offset-lg-1']//div[1]//div[2]//label[1]//span[1]"));
		 checkbox.click();
		 Thread.sleep(3000);
		 Actions actions = new Actions(driver);
		 actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		 Thread.sleep(3000);
		 WebElement calender = driver.findElement(By.xpath("//div[@class='wizard-details-primary']//div[1]//div[1]//div[1]//button[1]//img[1]"));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", calender);
		 Thread.sleep(3000);
		 WebElement date = driver.findElement(By.xpath("//div[contains(text(),'21')]"));
		 	date.click();
		 WebElement nextBtn = driver.findElement(By.xpath("//a[@class='btn save-btn-wizard mt-3']"));
		 nextBtn.click();
		 Thread.sleep(5000);
		 String text1 =driver.findElement(By.xpath("//div[@class='fr-element fr-view']//span[contains(text(),'Freshproposals')]")).getCssValue("font-size");
		 Assert.assertEquals(text1, "28px");
			 Thread.sleep(2000);
			 WebElement section2 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
			 section2.click();
			 WebElement page2text = driver.findElement(By.xpath("//div[@id='section_section6289']//div[@class='fr-wrapper']//span[1]"));
			 String section2font =page2text.getCssValue("font-size");
			 Assert.assertEquals(section2font, "28px");
			 Thread.sleep(3000);
			 WebElement section3 = driver.findElement(By.xpath("//div[@id='content']//li[3]"));
			 section3.click();
			 WebElement page3text = driver.findElement(By.xpath("//div[@id='froalapage1-fpText126201914515074']//span[contains(text(),'Freshproposals')]"));
			String section3font = page3text.getCssValue("font-size");
			//System.out.println(section3font);
			Assert.assertEquals(section3font,"28px");
			Thread.sleep(3000);
	 		}
	 	@Test(priority=3)
	 	public void pushsectionfromTemplateforRepeter() throws InterruptedException {
	 		driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1201");
	 		Thread.sleep(3000);
	 		 WebElement section1 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[1]"));
			 section1.click();
			 WebElement PushBtn = driver.findElement(By.xpath("//button[@class='btn back-btn mr-2 mt-2']"));
			 PushBtn.click();
			 Thread.sleep(5000);
			 WebElement BackBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
			 BackBtn.click();
			 Thread.sleep(5000);
			 WebElement ContentLib = driver.findElement(By.xpath("//span[contains(text(),'CONTENT LIBRARY')]"));
			 ContentLib.click();
			 Thread.sleep(10000);
	 		WebElement section = driver.findElement(By.xpath("//div[2]//div[1]//div[2]//p[2]//img[1]"));
	 		section.click();
	 		
	 	}
	 
	 	 @AfterClass
		  public void closeBrowser() throws InterruptedException {
			  Thread.sleep(3000);
			  driver.close();
		  }
}
