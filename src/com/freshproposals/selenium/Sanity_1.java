package com.freshproposals.selenium;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sanity_1 {
	WebDriver driver;
	WebDriverWait wait;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	final String gmail_Login_Id = "JimmyWatsonFirst1@gmail.com";
	final String gmail_Login_Password = "Manish123$";
	
	int cnt_Signup_Current = 2; //increament this by 1 manually 
	//cnt_Signup_Current= cnt_Signup_Current + 1;
	String gmail_Signup_Id = "JimmyWatsonFirst1+"+cnt_Signup_Current+"@gmail.com";

	
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
		driver.get("https://beta.freshproposals.net");
		//driver.get("https://live.freshproposals.com");
	}
	
	@Test(priority = 1, enabled = true)
	public void signUp() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Back To Login")));
        
        driver.findElement(By.id("email")).sendKeys(gmail_Signup_Id);//iamalexajonathan+125@gmail.com
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    boolean s =driver.findElement(By.xpath("//button[@class='btn back-btn']")).isEnabled();
	    System.out.println(s);
	}
	
	 @Test(enabled = false)
	 public void mailLogin() throws InterruptedException {
		 driver.get("https://mail.google.com/mail/u/0/#inbox");
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("RainLoopEmail"))).sendKeys("shahnawaz@freshproposals.site");
		 //driver.findElement(By.id("RainLoopEmail")).sendKeys("shahnawaz@freshproposals.site");
		 driver.findElement(By.id("RainLoopPassword")).sendKeys("Welcome@020");
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 Thread.sleep(5000);
		 //driver.findElement(By.linkText("Confirm your email")).click();
		 String copy_text = driver.findElement(By.xpath("//a[contains(text(),'https:')]")).getAttribute("value");
		 System.out.println(copy_text);
		 Thread.sleep(3000);
		 driver.get(copy_text);
	 }
		 
	@Test(priority = 3,enabled = true)
	public void gmailLogin() throws InterruptedException {
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("identifier"))).sendKeys(gmail_Login_Id);//iamalexajonathan@gmail.com
        String actual_name = driver.findElement(By.name("identifier")).getAttribute("value");
        String expected_name = gmail_Login_Id;
        Assert.assertEquals(actual_name, expected_name); 
        
		 driver.findElement(By.id("identifierNext")).click();
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys(gmail_Login_Password); //Alexajonathan@123
		 String actual_password = driver.findElement(By.name("password")).getAttribute("value");
		 String expected_password = gmail_Login_Password; //Alexajonathan@123
		 Assert.assertEquals(actual_password, expected_password);
		 
		 driver.findElement(By.id("passwordNext")).click(); 
		 
		 Thread.sleep(10000);
		
         //String copy_text = driver.findElement(By.xpath("//a[contains(text(),'https:')]")).getAttribute("href");
		 //System.out.println(copy_text);
		 //Thread.sleep(3000);
		 //driver.get(copy_text);
		 
		 //Manish Code below
		 System.out.println("manish-a");
		 
		 //https://www.guru99.com/find-element-selenium.html
		 List<WebElement> elements_subject = driver.findElements(By.xpath("//span[contains(text(),'[FP-Beta] Activate your account on FreshProposals')]"));
		 System.out.println("Count of email subject node: "+elements_subject.size());
		 elements_subject.get(1).click();
		 
		 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'[FP-Beta] Activate your account on FreshProposals')]")));//.click());
		 System.out.println("manish-b");
		 Thread.sleep(5000);
		 String confirm_account_url  = driver.findElement(By.xpath("//a[contains(text(),'https://beta.freshproposals.')]")).getAttribute("href");
		 System.out.println(confirm_account_url);
		 
		 driver.get(confirm_account_url);
		 System.out.println("manish-c");
		 

	}
      
	 
	 
	 @Test(priority = 3,enabled = true) //false
	 public void signUpForm() throws InterruptedException {
		 Thread.sleep(5000);
		  //driver.get("https://beta.freshproposals.net/auth/signup/Confirm/merana.amrahulkhannahai@gmail.com/cc758381-8b3c-4e57-97fc-1cda8a76ee7f");
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("FName"))).sendKeys("Jimmy");//Rahul
		  
		 driver.findElement(By.id("Name")).sendKeys("Watson"); //Khanna
		 
		 driver.findElement(By.id("Company Name1")).sendKeys("DM");
		 
		 driver.findElement(By.id("ContactNumber")).sendKeys("9819484815");
		 
		 driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		 
		 //driver.findElement(By.id("SubDomainURL")).sendKeys("www.dm.com");
		 
		 driver.findElement(By.id("Password")).sendKeys("Manish123$");
		 Thread.sleep(1000);
		 
		 //code for NoOfProposals
		 //driver.findElement(By.id("NoOfProposals")).click();
		 System.out.println("manish-d");
		 Thread.sleep(1000);
		 //Select number = new Select(driver.findElement(By.id("NoOfProposals")));
		 
		 //number.selectByVisibleText("50+");
		 
		 WebElement NoOfProposals_ = driver.findElement(By.id("NoOfProposals"));
		 NoOfProposals_.click();
		 
		 Point img_location = NoOfProposals_.getLocation();
		 int editor_x = img_location.getX();
		 int editor_y = img_location.getY();
		 System.out.println("NoOfProposals X "+editor_x);
		 System.out.println("NoOfProposals Y "+editor_y);
		 
		 Actions action = new Actions(driver);
		 action.moveByOffset(editor_x+50,editor_y+50).perform();
		 Thread.sleep(1000);
		 action.click();
		 
		 //NoOfProposals_.sendKeys(Keys.ARROW_DOWN);
		 //Thread.sleep(4000);
		 //NoOfProposals_.sendKeys(Keys.ARROW_DOWN);
		 //Thread.sleep(4000);
		 //NoOfProposals_.sendKeys(Keys.ENTER);
		 System.out.println("manish-e");
		 //driver.findElement(By.id("NoOfProposals_hidden")).sendKeys("50+");
		 driver.findElement(By.id("NoOfProposals")).click();
		 System.out.println("manish-f");
		 
		 Thread.sleep(1000);
		 
		 
		 //code for Industry
		 driver.findElement(By.id("Industry")).click();
		 System.out.println("manish-g");
		 Thread.sleep(1000);
		 //Select number = new Select(driver.findElement(By.id("NoOfProposals")));
		 
		 //number.selectByVisibleText("50+");
		 
		 WebElement Industry_ = driver.findElement(By.id("Industry"));
		 Industry_.sendKeys(Keys.ARROW_DOWN);
		 Thread.sleep(1000);
		 Industry_.sendKeys(Keys.ENTER);
		 System.out.println("manish-h");
		 //driver.findElement(By.id("NoOfProposals_hidden")).sendKeys("50+");
		 driver.findElement(By.id("Industry")).click();
		 
		 
		 Thread.sleep(6000);
		 
		 
//		 Select industry = new Select(driver.findElement(By.id("Industry")));
//		 industry.selectByVisibleText("IT Services");
		 
		 driver.findElement(By.id("Accept")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn next-btn float-right']"))).click();
		 System.out.println("manish-i");
		 Thread.sleep(5000);
	 }
	 
	 @Test(priority = 4)
	 public void systemTemplate() throws InterruptedException {
		 
		 //driver.get("https://beta.freshproposals.net");
		 
		 //driver.findElement(By.id("email")).sendKeys(gmail_Login_Id); //shahnawaz@zenincloud.com
		 //driver.findElement(By.id("passwordTXT")).sendKeys(gmail_Login_Password); //Shahnawaz@123
	   	 //driver.findElement(By.xpath("//button[@type='submit']")).click();
		 Thread.sleep(10000);
			
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("linkTemplates"))).click();
		 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'System')]"))).click();
		 driver.findElement(By.id("searchTemplates")).sendKeys("Coworking Space Proposal");
		 Thread.sleep(5000);
		 //driver.findElement(By.xpath("//img[@src='../../assets/edit-section-icon.png']")).click();
		 //driver.findElement(By.xpath("//img[@src='../../../assets/edit-tool-list.svg']")).click();
		 driver.findElement(By.xpath("//a[@ngbtooltip='Edit']")).click();
		 
		 Thread.sleep(20000);
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("onboardingGenProposal"))).click();
		 driver.findElement(By.name("name")).sendKeys(fname+" Sanity1_Proposal "+timestamp);
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 WebElement plusbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='btn add-client-btn ng-star-inserted']")));
		 plusbtn.click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='Name']"))).sendKeys("John Sanity test");
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='WebSiteUrl']"))).sendKeys("www.DM.com");
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='AddressLine1']"))).sendKeys("Kalyani Nagar");
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='AddressLine2']"))).sendKeys("Nagar Road");
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='City']"))).sendKeys("Pune");
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='State']"))).sendKeys("Maharashtra");
		 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='Country']"))).sendKeys("India");  //send manually
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='Zip']"))).sendKeys("416745");
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='OfficeMobileNo']"))).sendKeys("9878126789");
		 
		 Thread.sleep(5000);// sleep to select Country Dropdown manually
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='FirstName']"))).sendKeys("John");
		 driver.findElement(By.xpath("//input[@formcontrolname='LastName']")).sendKeys("S");
		 driver.findElement(By.xpath("//input[@formcontrolname='Email']")).sendKeys("manishpenkar.zen@gmail.com");
		 driver.findElement(By.xpath("//input[@formcontrolname='MobileNo']")).sendKeys("9819484825");
		 driver.findElement(By.id("btn-save")).click();
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search By Name']"))).sendKeys("John Sanity test");
		 Thread.sleep(5000);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
			
		 driver.findElement(By.xpath("//div[@class='col-lg-12']//div[1]//div[2]//label[1]//span[1]")).click();
		 driver.findElement(By.xpath("//img[@src='../../../assets/calendar.png']")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ngb-dp-arrow right']//button[@class='btn btn-link ngb-dp-arrow-btn']"))).click();
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'15')]"))).click();
		
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn send-btn']"))).click();
		 Thread.sleep(15000);
//		 //signee
//		 wait.until(ExpectedConditions.elementToBeClickable(By.id("sectionLink214"))).click();
//		 Thread.sleep(5000);
		 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-proposal[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[8]/div[4]/div[1]/div[1]/div[2]/a[1]/img[1]"))).click();

		 wait.until(ExpectedConditions.elementToBeClickable(By.id("sectionLink45022"))).click();  // click proposal section
		 Thread.sleep(50000);
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("listsectionPage_45022page2"))).click();// last page
		 Thread.sleep(50000);
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("page2-fpSign12220206292220mainDivTransformSafeStyle"))).click();
		 Thread.sleep(5000); // select Creator signee
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("page2-fpSign12220206292748mainDivTransformSafeStyle"))).click();
		 Thread.sleep(5000); // select receiver signee		 
		 
		 
		 
         wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSendMail"))).click(); // this is "Next" button click to go to emailer
         
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='email-template-client-sec InitiatingEmail']//a[@class='btn btn-email-template-apply'][contains(text(),'Apply')]"))).click();
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"NaN\"]/div/div[2]/a"))).click(); // click on apply button
         
   	    // ??? wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']"))).click();
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/app-email/div/div/div[3]/div[1]/div/div[2]/p"))).click(); // click on 'see how does it look'
         
         
   	    //String copy_url = driver.findElement(By.xpath("//div[@class='card-body ng-star-inserted']//input")).getAttribute("value");
   	    //System.out.println(copy_url);
         
         //  ????? <a href="{bizProLink}" target="_blank"  ..>View Our Business Proposal</a>
   	    
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='../../../assets/cancel-round.svg']"))).click();
   	 //  ???? wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/app-email/div/div/div[3]/div[2]/div[2]/div/span/a"))).click();
        
        // ???? wait.until(ExpectedConditions.elementToBeClickable(By.xpath("btn btn-email-template-apply"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Send"))).click();
        // driver.get(copy_url);
		 
	 }
	 
	 @Test(priority = 5)
	 public void anaytics() throws InterruptedException {
	   	    //Thread.sleep(5000);
//	   	 ((JavascriptExecutor)driver).executeScript("window.open()");
//	     ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//	     driver.switchTo().window(tabs.get(1));
//	     driver.get(copy_text);
//	     //section
//	     Thread.sleep(60000);
//	 	driver.findElement(By.xpath("//a[contains(text(),'Second Page')]")).click();
//	     Thread.sleep(60000);
//	     driver.findElement(By.xpath("//a[contains(text(),'Third Page')]")).click();
//	     Thread.sleep(70000);
//	     driver.close();
//	 	driver.switchTo().window(tabs.get(0));
//
//	 }	 
	 }
	 @AfterClass
	 public void closeBrowser() {
		 driver.quit();
	 }
}
	 

