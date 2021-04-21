package com.freshproposals.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UpdatedVariables extends Common_Methods{
	WebDriver driver;
	String unm;
	String pwd;
	 SoftAssert softAssertion= new SoftAssert();
String [] expected = new String[] {"Freshproposal","nikeeta3011@gmail.com","9189677456","Mrs.dont","Kalyaninagar Pune,411212","Pune","Maharashtra","India","Freshproposals.com","Fresh proposals.com","Natasha","nikeeta@zenincloud.com","Kalyaninagar Pune,411212","9999999999","1234567890","1","Nikeeta Shelar","SeleniumVariable","2212","Jan 27, 2029",""};
String [] expectedAfterUpdating = new String[] {"ICT Networks","nikeeta3011@gmail.com","6123455678","title","L10/ 153 Walker St North Sydney NSW, 2060","Walker","Sydney","Australia","www.ictnetworks.com.au","CALIBREONE","SAM","megan@speakersinstitute.com","4-8 Angas Street Kent Town SA 5067","9999999999","9876543210","1","NICK Vijucic","SeleniumVariable","2212","Jan 27, 2029",""};
//String[] expectedAfterUpdating = new String[] {"ICT Networks","6123455678","title","L10/ 153 Walker St North Sydney NSW, 2060","Walker","Sydney","Australia","www.ictnetworks.com.au","CALIBREONE","SAM","Cawthrown","megan@speakersinstitute.com","4-8 Angas Street Kent Town SA 5067","SeleniumVariable","2212","","1","NICK Vijucic","nikeeta3011@gmail.com","Jan 27, 2029","9876543210"};
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
	 public void Variable() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.get("http://beta1.freshproposals.net/home/viewproposal/2212/preview/proposals");
			Thread.sleep(5000);

	List<WebElement> variable = driver.findElements(By.xpath("//div[@id='page1-fpText1212020118598']//p"));
	System.out.println(variable.size());
	int var=variable.size();
	for(int i=0;i<var;i++) {
		System.out.println(variable.get(i).getText());
		String Actual =variable.get(i).getText();
		softAssertion.assertEquals(Actual, expected[i]);
	}
	WebElement backbtn = driver.findElement(By.xpath("//button[contains(text(),'Back')]"));
	backbtn.click();
	Thread.sleep(5000);
	softAssertion.assertAll();

	 }
		@Test(priority=2)
		public void updatedUserProfile() throws InterruptedException {
			WebElement userprofile = driver.findElement(By.xpath("//img[@class='ng-star-inserted']"));
			userprofile.click();
			Thread.sleep(5000);
			WebElement userinfo = driver.findElement(By.xpath("//h6[contains(text(),'User Profile')]"));
			userinfo.click();
			Thread.sleep(5000);
			WebElement Editbtn = driver.findElement(By.xpath("//button[contains(text(),'Edit')]"));
			Editbtn.click();
			Thread.sleep(2000);
			WebElement Firstname = driver.findElement(By.xpath("//input[@formcontrolname='firstName']"));		
			Firstname.clear();
			Firstname.sendKeys("NICK");
			Thread.sleep(1000);

			WebElement LastName= driver.findElement(By.xpath("//input[@formcontrolname='LastName']"));
			LastName.click();
			LastName.clear();
			LastName.sendKeys("Vijucic");
			Thread.sleep(1000);

			WebElement contactNumber =driver.findElement(By.xpath("//input[@formcontrolname='ContactNumber']"));
			contactNumber.click();
			contactNumber.clear();
			contactNumber.sendKeys("6123455678");
			Thread.sleep(1000);

			WebElement title = driver.findElement(By.xpath("//input[@formcontrolname='Title']"));
			title.clear();
			title.sendKeys("title");
			Thread.sleep(1000);

			WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			SaveBtn.click();
			Thread.sleep(5000);
			//this.updatedProfileReset();
			
			
		}
		@Test(priority=3)
		public void UpdateCompanyProfile() throws InterruptedException {
			driver.get("http://beta1.freshproposals.net/home");
		WebElement SettingTab =	driver.findElement(By.xpath("//span[contains(text(),'SETTINGS')]"));
		SettingTab.click();
		Thread.sleep(5000);
		WebElement CompanyInfo = driver.findElement(By.xpath("//p[contains(text(),'Company Info')]"));
		CompanyInfo.click();
		Thread.sleep(2000);
		WebElement Companyname = driver.findElement(By.xpath("//input[@formcontrolname='CompanyName']"));
		Companyname.clear();
		Companyname.sendKeys("ICT Networks");
		Thread.sleep(1000);
		WebElement CompanyWebsite = driver.findElement(By.xpath("//input[@formcontrolname='WebSiteUrl']"));
		CompanyWebsite.clear();
		CompanyWebsite.sendKeys("www.ictnetworks.com.au");
		Thread.sleep(1000);
		WebElement Address1= driver.findElement(By.xpath("//input[@formcontrolname='AddressLine1']"));
		Address1.clear();
		Address1.sendKeys("L10/ 153 Walker St");
		Thread.sleep(1000);
		WebElement Address2= driver.findElement(By.xpath("//input[@formcontrolname='AddressLine2']"));
		Address2.clear();
		Address2.sendKeys("North Sydney NSW, 2060");
		Thread.sleep(2000);
		WebElement City = driver.findElement(By.xpath("//input[@formcontrolname='City']"));
		City.clear();
		City.sendKeys("Walker");
		Thread.sleep(2000);
		WebElement State = driver.findElement(By.xpath("//input[@formcontrolname='State']"));
		State.clear();
		State.sendKeys("Sydney ");
		Thread.sleep(2000);
		WebElement Country = driver.findElement(By.xpath("//input[@formcontrolname='Country']"));
		Country.clear();
		Country.sendKeys("Australia");
		Thread.sleep(2000);
		WebElement Zip = driver.findElement(By.xpath("//input[@formcontrolname='Zip']"));
		Zip.clear();
		Zip.sendKeys("2060");
		Thread.sleep(2000);
		WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		SaveBtn.click();
		Thread.sleep(3000);
		
		//this.ResetCompanyProfile();

		
		}
		@Test(priority=4)
		public void UpdateClientContact() throws InterruptedException {
			driver.get("http://beta1.freshproposals.net/home");
			WebElement ClientTab= driver.findElement(By.xpath("//span[contains(text(),'CLIENTS')]"));
			ClientTab.click();
			Thread.sleep(3000);
			WebElement UpdateClient = driver.findElement(By.xpath("//div[contains(text(),'Fresh proposals.com')]//span//img[1]"));
			UpdateClient.click();
			Thread.sleep(2000);
			WebElement CompanyName = driver.findElement(By.xpath("//input[@formcontrolname='CompanyName']"));
			CompanyName.clear();
			CompanyName.sendKeys("CALIBREONE");
			Thread.sleep(2000);

			WebElement CompanyWebsite = driver.findElement(By.xpath("//input[@formcontrolname='WebSiteUrl']"));
			CompanyWebsite.clear();
			CompanyWebsite.sendKeys("https://www.calibreone.com.au/");
			Thread.sleep(2000);

			WebElement CompanyAddress1= driver.findElement(By.xpath("//input[@formcontrolname='AddressLine1']"));
			CompanyAddress1.clear();
			CompanyAddress1.sendKeys("4-8 Angas Street");
			Thread.sleep(2000);

			WebElement CompanyAddress2 = driver.findElement(By.xpath("//input[@formcontrolname='AddressLine2']"));
			CompanyAddress2.clear();
			CompanyAddress2.sendKeys("Kent Town SA 5067");
			Thread.sleep(2000);

			WebElement ClientCity = driver.findElement(By.xpath("//input[@formcontrolname='City']"));
			ClientCity.clear();
			ClientCity.sendKeys("Calibre One (SA)");
			Thread.sleep(2000);

			WebElement ClientState = driver.findElement(By.xpath("//input[@formcontrolname='State']"));
			ClientState.clear();
			ClientState.sendKeys("Stuart Hwy");
			Thread.sleep(2000);

			WebElement ClientCountry = driver.findElement(By.xpath("//input[@formcontrolname='Country']"));
			ClientCountry.clear();
			ClientCountry.sendKeys("Australia");
			Thread.sleep(2000);

			WebElement ClientZipCode = driver.findElement(By.xpath("//input[@formcontrolname='Zip']"));
			ClientZipCode.clear();
			ClientZipCode.sendKeys("6789");
			Thread.sleep(2000);
			WebElement UpdateBtn = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
			UpdateBtn.click();
			Thread.sleep(2000);
			WebElement editContact = driver.findElement(By.xpath("//div[@class='ng-star-inserted']//div[2]//div[1]//span[1]//img[1]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", editContact);
			
			//editContact.click();
			Thread.sleep(2000);
			WebElement contactfirstname = driver.findElement(By.xpath("//input[@formcontrolname='firstName']"));
			contactfirstname.clear();
			contactfirstname.sendKeys("SAM");
			Thread.sleep(1000);
			WebElement contactLastname = driver.findElement(By.xpath("//input[@formcontrolname='lastName']"));
			contactLastname.clear();
			contactLastname.sendKeys("Cawthrown");
			Thread.sleep(1000);
			WebElement contatctEmail = driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']"));
			contatctEmail.clear();
			contatctEmail.sendKeys("megan@speakersinstitute.com");
			Thread.sleep(1000);
			WebElement ContatcMobile = driver.findElement(By.xpath("//input[@formcontrolname='contactNumber']"));
			ContatcMobile.clear();
			ContatcMobile.sendKeys("9876543210");
			Thread.sleep(1000);
			WebElement updatebtn2= driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
			updatebtn2.click();
			Thread.sleep(1000);
			driver.get("http://beta1.freshproposals.net/home/viewproposal/2212/preview/proposals");
			List<WebElement> variable = driver.findElements(By.xpath("//div[@id='page1-fpText1212020118598']//p"));
			System.out.println(variable.size());
			int var=variable.size();
			for(int i=0;i<var;i++) {
				System.out.println(variable.get(i).getText());
				//String Actual =variable.get(i).getText();
				//softAssertion.assertEquals(Actual, expectedAfterUpdating[i]);
			}
			softAssertion.assertAll();
		}
		@Test(priority=5)
		public void ResetVariable() throws InterruptedException {
			this.updatedProfileReset();
			this.ResetCompanyProfile();
			this.ResetClientContact();
			Thread.sleep(5000);
			driver.get("http://beta1.freshproposals.net/home/viewproposal/2212/preview/proposals");
			List<WebElement> variable = driver.findElements(By.xpath("//div[@id='page1-fpText1212020118598']//p"));
			System.out.println(variable.size());
			int var=variable.size();
			for(int i=0;i<var;i++) {
				System.out.println(variable.get(i).getText());
				String Actual =variable.get(i).getText();
				softAssertion.assertEquals(Actual, expected[i]);
			}
			softAssertion.assertAll();
		}
	 
	@AfterClass
	public void Teardown() {
		driver.quit();
	}
	 public void updatedProfileReset() throws InterruptedException {
		 WebElement backbtn = driver.findElement(By.xpath("//button[contains(text(),'Back')]"));
			backbtn.click();
			Thread.sleep(3000);
			WebElement userprofile = driver.findElement(By.xpath("//img[@class='ng-star-inserted']"));
			userprofile.click();
			WebElement userinfo = driver.findElement(By.xpath("//h6[contains(text(),'User Profile')]"));
			userinfo.click();
			Thread.sleep(5000);
			WebElement Editbtn = driver.findElement(By.xpath("//button[contains(text(),'Edit')]"));
			Editbtn.click();
			Thread.sleep(3000);
			WebElement Firstname = driver.findElement(By.xpath("//input[@formcontrolname='firstName']"));		
			Firstname.clear();
			Firstname.sendKeys("Nikeeta");
			Thread.sleep(1000);

			WebElement LastName= driver.findElement(By.xpath("//input[@formcontrolname='LastName']"));
			LastName.click();
			LastName.clear();
			LastName.sendKeys("Shelar");
			Thread.sleep(1000);

			WebElement contactNumber =driver.findElement(By.xpath("//input[@formcontrolname='ContactNumber']"));
			contactNumber.click();
			contactNumber.clear();
			contactNumber.sendKeys("9189677456");
			Thread.sleep(1000);

			WebElement title = driver.findElement(By.xpath("//input[@formcontrolname='Title']"));
			title.clear();
			title.sendKeys("Mrs.dont");
			Thread.sleep(1000);

			WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			SaveBtn.click();
			Thread.sleep(5000);
			
		
		}
	 public void ResetCompanyProfile() throws InterruptedException {
			driver.get("http://beta1.freshproposals.net/home");
		WebElement SettingTab =	driver.findElement(By.xpath("//span[contains(text(),'SETTINGS')]"));
		SettingTab.click();
		Thread.sleep(5000);
		WebElement CompanyInfo = driver.findElement(By.xpath("//p[contains(text(),'Company Info')]"));
		CompanyInfo.click();
		Thread.sleep(2000);
		WebElement Companyname = driver.findElement(By.xpath("//input[@formcontrolname='CompanyName']"));
		Companyname.clear();
		Companyname.sendKeys("Freshproposal");
		Thread.sleep(1000);
		WebElement CompanyWebsite = driver.findElement(By.xpath("//input[@formcontrolname='WebSiteUrl']"));
		CompanyWebsite.clear();
		CompanyWebsite.sendKeys("Freshproposals.com");
		Thread.sleep(1000);
		WebElement Address1= driver.findElement(By.xpath("//input[@formcontrolname='AddressLine1']"));
		Address1.clear();
		Address1.sendKeys("Kalyaninagar");
		Thread.sleep(1000);
		WebElement Address2= driver.findElement(By.xpath("//input[@formcontrolname='AddressLine2']"));
		Address2.clear();
		Address2.sendKeys("Pune,411212");
		Thread.sleep(1000);
		WebElement City = driver.findElement(By.xpath("//input[@formcontrolname='City']"));
		City.clear();
		City.sendKeys("Pune");
		Thread.sleep(1000);
		WebElement State = driver.findElement(By.xpath("//input[@formcontrolname='State']"));
		State.clear();
		State.sendKeys("Maharashtra");
		Thread.sleep(1000);
		WebElement Country = driver.findElement(By.xpath("//input[@formcontrolname='Country']"));
		Country.clear();
		Country.sendKeys("India");
		Thread.sleep(1000);
		WebElement Zip = driver.findElement(By.xpath("//input[@formcontrolname='Zip']"));
		Zip.clear();
		Zip.sendKeys("412216");
		Thread.sleep(1000);
		WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		SaveBtn.click();
		Thread.sleep(3000);
		
		}
		
	 public void ResetClientContact() throws InterruptedException {
			driver.get("http://beta1.freshproposals.net/home");
			WebElement ClientTab= driver.findElement(By.xpath("//span[contains(text(),'CLIENTS')]"));
			ClientTab.click();
			Thread.sleep(2000);
			WebElement UpdateClient = driver.findElement(By.xpath("//div[contains(text(),'CALIBREONE ')]//span//img[1]"));
			UpdateClient.click();
			Thread.sleep(1000);
			WebElement CompanyName = driver.findElement(By.xpath("//input[@formcontrolname='CompanyName']"));
			CompanyName.clear();
			CompanyName.sendKeys("Fresh proposals.com");
			Thread.sleep(1000);

			WebElement CompanyWebsite = driver.findElement(By.xpath("//input[@formcontrolname='WebSiteUrl']"));
			CompanyWebsite.clear();
			CompanyWebsite.sendKeys("freshproposals.com");
			Thread.sleep(1000);

			WebElement CompanyAddress1= driver.findElement(By.xpath("//input[@formcontrolname='AddressLine1']"));
			CompanyAddress1.clear();
			CompanyAddress1.sendKeys("Kalyaninagar");
			Thread.sleep(1000);

			WebElement CompanyAddress2 = driver.findElement(By.xpath("//input[@formcontrolname='AddressLine2']"));
			CompanyAddress2.clear();
			CompanyAddress2.sendKeys("Pune,411212");
			Thread.sleep(1000);

			WebElement ClientCity = driver.findElement(By.xpath("//input[@formcontrolname='City']"));
			ClientCity.clear();
			ClientCity.sendKeys("ClientCity");
			Thread.sleep(1000);

			WebElement ClientState = driver.findElement(By.xpath("//input[@formcontrolname='State']"));
			ClientState.clear();
			ClientState.sendKeys("Maharashtra");
			Thread.sleep(1000);

			WebElement ClientCountry = driver.findElement(By.xpath("//input[@formcontrolname='Country']"));
			ClientCountry.clear();
			ClientCountry.sendKeys("India");
			Thread.sleep(1000);

			WebElement ClientZipCode = driver.findElement(By.xpath("//input[@formcontrolname='Zip']"));
			ClientZipCode.clear();
			ClientZipCode.sendKeys("412216");
			Thread.sleep(1000);
			WebElement UpdateBtn = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
			UpdateBtn.click();
			Thread.sleep(1000);
			WebElement editContact = driver.findElement(By.xpath("//div[@class='ng-star-inserted']//div[2]//div[1]//span[1]//img[1]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", editContact);
			//editContact.click();
			Thread.sleep(2000);
			WebElement contactfirstname = driver.findElement(By.xpath("//input[@formcontrolname='firstName']"));
			contactfirstname.clear();
			contactfirstname.sendKeys("Natasha");
			Thread.sleep(1000);
			WebElement contactLastname = driver.findElement(By.xpath("//input[@formcontrolname='lastName']"));
			contactLastname.clear();
			contactLastname.sendKeys("Sharma");
			Thread.sleep(1000);
			WebElement contatctEmail = driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']"));
			contatctEmail.clear();
			contatctEmail.sendKeys("nikeeta@zenincloud.com");
			Thread.sleep(1000);
			WebElement ContatcMobile = driver.findElement(By.xpath("//input[@formcontrolname='contactNumber']"));
			ContatcMobile.clear();
			ContatcMobile.sendKeys("1234567890");
			Thread.sleep(1000);
			WebElement updatebtn2= driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
			updatebtn2.click();
			Thread.sleep(2000);

		}
}
