package com.freshproposals.selenium;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
import org.testng.internal.thread.TestNGThreadFactory;

public class Sanity_2 extends Common_Methods {
	
	String environment="Beta"; //Beta , Live
	
	int cnt_Signup_Current_Beta = 13; //increment this by 1 manually 
	int cnt_Signup_Current_Live = 1; //increment this by 1 manually
	
	String signup_Beta = "JimmyWatsonFirst1+"+cnt_Signup_Current_Beta+"@gmail.com";
	String signup_Live = "JimmyWatsonLive1+"+cnt_Signup_Current_Live+"@gmail.com";	
	
	String login_Beta = "JimmyWatsonFirst1@gmail.com";
	String login_Live = "JimmyWatsonLive1@gmail.com";
	
	String url_Beta="https://beta.freshproposals.net";
	String url_Live="https://live.freshproposals.com";
	
	String gmail_Login_Id = "";
	String gmail_Login_Password = "Manish123$";	
			
	WebDriver driver;
	WebDriverWait wait;
	String fname = "SEL";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	

		
	String gmail_Signup_Id = "";
	
		
//	
	String proposal_link="";
	String proposal_number_generated="";
	String summary_link="";
	String link_suffix="";
	
	
	//analytic variable
	String time;
	String view;
	String average;
	String lastview;
	String g_time;
	String g_view;
	String g_average;
	String g_lastview;
	int g_conversion_time;
	int conversion_time;
	int total_time_lastViewed; //total_time
	int expected_total_time;
	int g_view_int;
	int view_int; 
	int total_view;
	int total_average_time;
	int expected_total_average_time;	
	
	int seconds_proposal_seen_code = 76;// manually calculated from method AttendProposal
	int seconds_proposal_seen_analytics;

	
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
		if(environment=="Live")
		{			
			//driver.get("https://app.freshproposals.com/login");
			driver.get(url_Live);
			gmail_Signup_Id = signup_Live;
			gmail_Login_Id = login_Live;
		}
		else {
			driver.get(url_Beta);
			gmail_Signup_Id = signup_Beta;
			gmail_Login_Id = login_Beta;
		}
				
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
		 
		 
		 //https://www.guru99.com/find-element-selenium.html
		 if(environment=="Live")
		 {
			 List<WebElement> elements_subject = driver.findElements(By.xpath("//span[contains(text(),'Activate your Fresh Proposals account')]"));
			 System.out.println("Count of email subject node: "+elements_subject.size());
			 elements_subject.get(1).click();
			 
			 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'[FP-Beta] Activate your account on FreshProposals')]")));//.click());
			 
			 Thread.sleep(5000);
			 String confirm_account_url  = driver.findElement(By.xpath("//a[contains(text(),'https://live.freshproposals.')]")).getAttribute("href");
			 System.out.println(confirm_account_url);
			 
			 driver.get(confirm_account_url);			 
		 }
		 else
		 {
			 List<WebElement> elements_subject = driver.findElements(By.xpath("//span[contains(text(),'[FP-Beta] Activate your account on FreshProposals')]"));
			 System.out.println("Count of email subject node: "+elements_subject.size());
			 elements_subject.get(1).click();
			 
			 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'[FP-Beta] Activate your account on FreshProposals')]")));//.click());
			 
			 Thread.sleep(5000);
			 String confirm_account_url  = driver.findElement(By.xpath("//a[contains(text(),'https://beta.freshproposals.')]")).getAttribute("href");
			 System.out.println(confirm_account_url);
			 
			 driver.get(confirm_account_url);			 
		 }

		 
		 

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
		 
		 Thread.sleep(1000);
		 //Select number = new Select(driver.findElement(By.id("NoOfProposals")));
		 
		 //number.selectByVisibleText("50+");
		 
		 WebElement NoOfProposals_ = driver.findElement(By.id("NoOfProposals"));
		 NoOfProposals_.click();
		 
		 Point img_location = NoOfProposals_.getLocation();
		 int editor_x = img_location.getX();
		 int editor_y = img_location.getY();
		 System.out.println("DropDown NoOfProposals X: "+editor_x);
		 System.out.println("DropDown NoOfProposals Y: "+editor_y);
		 
		 Actions action = new Actions(driver);
		 action.moveByOffset(editor_x+50,editor_y+50).perform();
		 Thread.sleep(1000);
		 action.click();
		 
		 //NoOfProposals_.sendKeys(Keys.ARROW_DOWN);
		 //Thread.sleep(4000);
		 //NoOfProposals_.sendKeys(Keys.ARROW_DOWN);
		 //Thread.sleep(4000);
		 //NoOfProposals_.sendKeys(Keys.ENTER);
		 
		 //driver.findElement(By.id("NoOfProposals_hidden")).sendKeys("50+");
		 driver.findElement(By.id("NoOfProposals")).click();
		 
		 
		 Thread.sleep(1000);
		 
		 
		 //code for Industry
		 driver.findElement(By.id("Industry")).click();
		 
		 Thread.sleep(1000);
		 //Select number = new Select(driver.findElement(By.id("NoOfProposals")));
		 
		 //number.selectByVisibleText("50+");
		 
		 WebElement Industry_ = driver.findElement(By.id("Industry"));
		 Industry_.sendKeys(Keys.ARROW_DOWN);
		 Thread.sleep(1000);
		 Industry_.sendKeys(Keys.ENTER);
		 
		 //driver.findElement(By.id("NoOfProposals_hidden")).sendKeys("50+");
		 driver.findElement(By.id("Industry")).click();
		 
		 
		 Thread.sleep(15000);
		 
		 
//		 Select industry = new Select(driver.findElement(By.id("Industry")));
//		 industry.selectByVisibleText("IT Services");
		 
		 driver.findElement(By.id("Accept")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn next-btn float-right']"))).click();
		 
		 Thread.sleep(5000);
	 }
	 
	 @Test(priority = 4)
	 public void systemTemplate() throws InterruptedException {
		 
//		 //***********************************************
//		 //for temporary testing activate this block, to skip sign up process set enabled = false for test above this block
//		 
//		 if(environment=="Live")
//		 {
//			 //driver.get(url_Live);
//			 driver.findElement(By.id("email")).sendKeys( signup_Live); //gmail_Login_Id //shahnawaz@zenincloud.com
//		 }
//		 else 
//		 {
//			 //driver.get(url_Beta);
//			 driver.findElement(By.id("email")).sendKeys( signup_Beta); //gmail_Login_Id //shahnawaz@zenincloud.com
//		 }
//		 		 		
//		 
//		 
//		 driver.findElement(By.id("passwordTXT")).sendKeys(gmail_Login_Password); //Shahnawaz@123
//	   	 driver.findElement(By.xpath("//button[@type='submit']")).click();
//	   	 	   	    	 	  
//	   //***********************************************
	   	 
		 Thread.sleep(5000);
		 
//		 if(environment=="Live")   //??????????????????
//		 {
//			 driver.findElement(By.xpath("//button[contains(text(),'Next')]")).sendKeys("Coworking Space Proposal");
//			 
//			 
//			 Thread.sleep(5000);
//		 }
		 
		 //btnRemoveKompassify
		 //driver.findElement(By.xpath("//*[@id='btnRemoveKompassify']")).click(); 
		 
		 try    //close the kompassify Guided tour on dashboard page , first tour
		 {
			 List<WebElement> TourPopupCloseButton =  driver.findElements(By.xpath("//div[@class='close-container']"));
			 if(TourPopupCloseButton.size()>0)
				 {
				 	TourPopupCloseButton.get(1).click();
				 }
			 
		 }
		 catch(NoSuchElementException ex)
		 {
			 System.out.println("Guided tour close button  not found (NoSuchElementException). " + " - "	+ ex.getStackTrace());
		 }
		 catch(Exception e)
		 {
			 System.out.println("Guided tour close button not found (Exception). "  + " - "	+ e.getStackTrace());
		 }
		 
		 
			
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("linkTemplates"))).click();
		 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'System')]"))).click();
		 driver.findElement(By.id("searchTemplates")).sendKeys("Coworking Space Proposal");
		 Thread.sleep(5000);
		 //driver.findElement(By.xpath("//img[@src='../../assets/edit-section-icon.png']")).click();
		 //driver.findElement(By.xpath("//img[@src='../../../assets/edit-tool-list.svg']")).click();
		 driver.findElement(By.xpath("//a[@ngbtooltip='Edit']")).click();
		 
		 Thread.sleep(10000);
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("onboardingGenProposal"))).click();
		 driver.findElement(By.name("name")).sendKeys(fname+" Sanity2_Proposal "+timestamp);
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
		 
		 Thread.sleep(7000);// sleep to select Country drop-down manually
		 
		 driver.findElement(By.xpath("//button[contains (text(),'Add')]")).click(); // Add client button  ////button[@type='submit']
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='FirstName']"))).sendKeys("John");
		 driver.findElement(By.xpath("//input[@formcontrolname='LastName']")).sendKeys("Smith");
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
		 Thread.sleep(8000);
//		 //signee
//		 wait.until(ExpectedConditions.elementToBeClickable(By.id("sectionLink214"))).click();
//		 Thread.sleep(5000);
		 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[5]/div[1]/app-edit-proposal[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[8]/div[4]/div[1]/div[1]/div[2]/a[1]/img[1]"))).click();

		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Terms of Services')]"))).click();  // click proposal section
		 Thread.sleep(5000);
		 
		 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='section-page active']/a"))).click();// last page of section //id("listsectionPage_45022page2")
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Terms of Services')]/../div[4]/div/div/div[2]/a"))).click();// last page of section //id("listsectionPage_45022page2")
		 Thread.sleep(5000);
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("page2-fpSign12220206292220mainDivTransformSafeStyle"))).click();
		 Thread.sleep(7000); // select Proposal Creator signature
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("page2-fpSign12220206292748mainDivTransformSafeStyle"))).click();
		 Thread.sleep(8000); // select Proposal receiver signature		 
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div/app-edit-proposal/div/div[1]/div/ul[1]/li[2]/button"))).click(); //click on Save Proposal button after assign sign 
		 Thread.sleep(4000);
		
         wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSendMail"))).click(); // this is "Next" button click to go to emailer
         
         
    	    Thread.sleep(3000);  	   
       	    proposal_link = driver.findElement(By.xpath("//div[@class='card-body ng-star-inserted']//input")).getAttribute("value");
       	    System.out.println("Proposal Link: "+proposal_link);
       	    //Thread.sleep(2000);  
         
         
        Thread.sleep(5000); 
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='email-template-client-sec InitiatingEmail']//a[@class='btn btn-email-template-apply'][contains(text(),'Apply')]"))).click();
         //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='NaN']/div/div[2]/a"))).click(); // click on apply button
         //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"NaN\"]/div/div[2]/a"))).click(); // click on apply button
         //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Apply')]"))).click(); // click on apply button
         //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='email-text-options']"))).click(); // click on apply button
         //driver.findElement(By.xpath("//a[contains(text(),'Apply')]")).click(); // click on apply button
         //System.out.println("Apply email template button clicked");
         
       	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='email-template-client-sec InitiatingEmail']"))).click(); // click on  initial email apply button
       	 
       
  	    //driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
         Thread.sleep(1000);
                                    
   	    // ??? wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']"))).click();// click on link attachment link
         //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/app-email/div/div/div[3]/div[1]/div/div[2]/p"))).click(); // click on 'see how does it look'
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/app-email/div/div/div[3]/div[1]/div/div[2]/p"))).click(); // click on 'see how does it look'
         wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Send"))).click();
        //driver.get(proposal_link);
		 
	 }
	 
	 @Test(priority = 5)
	  public void getData() throws InterruptedException {
		  Thread.sleep(10000);
		  //code for proposal_number_generated
		  //https://beta.freshproposals.net/home/viewproposal/21363/3558581f-5d2a-49a8-9cc3-5f104c5d8173
		  String tmp_proposal_link = proposal_link.replace("https://","");
		  String[] link_Parts = tmp_proposal_link.split("/");
		  proposal_number_generated = link_Parts[link_Parts.length-2];
		  System.out.println("Proposal Number: " +proposal_number_generated);
		  
		  //code for  summary link generation
		  int viewproposal_position = proposal_link.indexOf("viewproposal", 0);
		  link_suffix = proposal_link.substring(0, viewproposal_position);
		  System.out.println("link_suffix: " +link_suffix);
		  summary_link = link_suffix+"proposals/summary/"+proposal_number_generated;
		  System.out.println("summary_link: " +summary_link);
		  
		  //System.exit(0); // stop further execution
		  
		  //driver.get(summary_link); //https://beta.freshproposals.net/home/proposals/summary/20762
			//Thread.sleep(1000);
		    //driver.findElement(By.xpath("//a[@id='analyticsTab']")).click();
		    //get time
		    Thread.sleep(5000);
		    g_time =  driver.findElement(By.xpath("//div[@class='proposal-analytics-timespent']//div[1]/div[2]")).getText();
			System.out.println("B TOTAL TIME SPENT VIEWING " +  g_time);
			//times viewed
			g_view = driver.findElement(By.xpath("//div[@class='proposal-analytics-box-timespent']//div[2]/div[2]")).getText();
			System.out.println("B TIMES VIEWED " + g_view);
			//average time
			g_average = driver.findElement(By.xpath("//div[@class='proposal-analytics-timespent']//div[3]/div[2]")).getText();
			System.out.println("B AVERAGE TIME VIEWING " + g_average);				
			//time since last view
			g_lastview = driver.findElement(By.xpath("//div[@class='proposal-analytics-timespent']//div[4]/div[2]")).getText();
			System.out.println("B TIME SINCE LAST VIEWED " + g_lastview);
	  }
	 
//	  @Test(priority = 6, enabled = false)
//	  public void copyLink() throws InterruptedException {
//		  String proposal_link_editmode = link_suffix+"proposals/editProposal;proposalId="+proposal_number_generated+";editor=true";
//		  driver.get(proposal_link_editmode); //https://beta.freshproposals.net/home/proposals/editProposal;proposalId=20762;editor=true
//		  //next
//		  Thread.sleep(5000);
//		  
//		  //driver.findElement(By.id("btnSendMail")).click();
//		  sendNextButton(driver);
//	  }
	  
	  @Test(priority = 7)
	  public void sendButton() throws InterruptedException {
		  //analyticsCopyLink(driver);
		  
		  AttendProposal(driver, proposal_link);
		 
//			//open analytics tab
		driver.get(summary_link);
		Thread.sleep(1000);
	    //get time
	    Thread.sleep(5000);
		time =  driver.findElement(By.xpath("//div[@class='proposal-analytics-timespent']//div[1]/div[2]")).getText();
		System.out.println("A TOTAL TIME SPENT VIEWING " +  time);
		//times viewed (quick change)
		view = driver.findElement(By.xpath("//div[@class='proposal-analytics-timespent']//div[2]//div[2] ")).getText();
		System.out.println("A TIMES VIEWED " + view);
		//average time
		average = driver.findElement(By.xpath("//div[@class='proposal-analytics-timespent']//div[3]//div[2]")).getText();
		System.out.println("A AVERAGE TIME VIEWING " + average);				
		//time since last view
		lastview = driver.findElement(By.xpath("//div[@class='proposal-analytics-timespent']//div[4]//div[2]")).getText();
		System.out.println("A TIME SINCE LAST VIEWED " + lastview);


	   //compare g_time
	    char[]	g_tempArr = g_time.toCharArray();
		int g_totalChars = g_tempArr.length;
		//System.out.println("TotalChars "+g_totalChars);
		
		int g_hrsIndex = g_time.lastIndexOf("h");
		int g_minIndex = g_time.lastIndexOf("m");
		int g_secsIndex = g_time.lastIndexOf("s");

		//System.out.println("HrsIndex"+g_hrsIndex+" MinIndex"+g_minIndex+" SecsIndex : "+g_secsIndex);

		int g_secs=0;
		int g_mins=0;
		int g_hrs=0;

		if(g_hrsIndex < 0){
			{
				if(g_minIndex < 0) {
					if(g_secsIndex < 0) {
						g_secs=0;
					}else {
						g_secs=  Integer.parseInt(g_time.substring(g_minIndex+2, g_secsIndex-1));
						//System.out.println("Secs String:"+g_time.substring(g_minIndex+2, g_secsIndex-1));
						//System.out.println(" Secs: "+g_secs);
					}
				}else {
					
					if(g_secsIndex < 0) {
						g_secs=0;
					}else {
						g_secs=  Integer.parseInt(g_time.substring(g_minIndex+2, g_secsIndex-1));
						//System.out.println("Secs String:"+g_time.substring(g_minIndex+2, g_secsIndex-1));
						//System.out.println(" Secs: "+g_secs);
					}

					g_mins=  Integer.parseInt(g_time.substring(0, g_minIndex-1));
					//System.out.println(" Mins: "+g_mins);			
				}
			}
		}else {
			
			g_hrs=  Integer.parseInt(g_time.substring(0, g_hrsIndex-1));
			//System.out.println(" Hrs: "+g_hrs);
		}
			
		System.out.println("G_H: "+g_hrs+" G_M: "+g_mins+" G_S: "+g_secs);

		
		 //compare _time
	    char[]	tempArr = g_time.toCharArray();
		int totalChars = tempArr.length;
		//System.out.println("TotalChars "+totalChars);
		
		int hrsIndex = time.lastIndexOf("h");
		int minIndex = time.lastIndexOf("m");
		int secsIndex = time.lastIndexOf("s");

		//System.out.println("HrsIndex"+hrsIndex+" MinIndex"+minIndex+" SecsIndex : "+secsIndex);

		int secs=0;
		int mins=0;
		int hrs=0;

		if(hrsIndex < 0){
			{
				if(minIndex < 0) {
					if(secsIndex < 0) {
						secs=0;
					}else {
						secs=  Integer.parseInt(time.substring(minIndex+1, secsIndex-1));  //minIndex+2
						//System.out.println("Secs String:"+time.substring(minIndex+2, secsIndex-1));
						//System.out.println(" Secs: "+secs);
					}
				}else {
					
					if(secsIndex < 0) {
						secs=0;
					}else {
						secs=  Integer.parseInt(time.substring(minIndex+2, secsIndex-1)); 
						//System.out.println("Secs String:"+time.substring(minIndex+2, secsIndex-1));
						//System.out.println(" Secs: "+secs);
					}

					mins=  Integer.parseInt(time.substring(0, minIndex-1));
					//System.out.println(" Mins: "+mins);			
				}
			}
		}else {
			
			hrs=  Integer.parseInt(time.substring(0, hrsIndex-1));
			//System.out.println(" Hrs: "+hrs);
		}
			
		System.out.println("H: "+hrs+" M: "+mins+" Secs: "+secs);
		
		//get
		g_conversion_time = g_mins * 60 + g_secs;
		System.out.println(g_mins);
		System.out.println(g_secs);
		
		System.out.println("G Time = "+g_conversion_time);
		//normal 
		conversion_time = mins * 60 + secs;
		System.out.println("Time = "+conversion_time);
		
		total_time_lastViewed = conversion_time - g_conversion_time;
		System.out.println("Total Time Last Viewed = "+total_time_lastViewed); // difference in second
		
		// ???? expected_total_time = 7;
		// ???? Assert.assertEquals(total_time_lastViewed, expected_total_time);
		
		seconds_proposal_seen_analytics = total_time_lastViewed;
		
		}
	  
	  @Test(priority = 8)
	  public void Times_View() {
		  System.out.println("G View= "+g_view);
		  System.out.println("View= "+view);
		  
		  g_view_int = Integer.parseInt(g_view);
		  view_int = Integer.parseInt(view);
		  
		  
		  total_view = view_int - g_view_int;
		  System.out.println("Total View= "+total_view);
		  
		  //int expected_total_view = 1;
		  Assert.assertTrue(total_view==1);
		  
		  
	  }
	  
	  @Test(priority = 9, enabled = false)
	  public void Average_Time() {
		  	  		  
		  System.out.println("g_average: "+g_average);
		  System.out.println("average: "+average);
		  
		  total_average_time = g_conversion_time / view_int;
		  System.out.println("total_average_time: "+total_average_time);
		  
		  expected_total_average_time = total_average_time;
		  Assert.assertEquals(total_average_time, expected_total_average_time);
		  
		  }
	  
	  
	  @Test(priority= 10)
	  public void Verify_Seconds_Proposal_Seen()
	  {
		  System.out.println("seconds_proposal_seen_code: "+seconds_proposal_seen_code);
		  System.out.println("seconds_proposal_seen_analytics: "+seconds_proposal_seen_analytics);
		  
		  Assert.assertEquals(seconds_proposal_seen_code, seconds_proposal_seen_analytics);			  
	  }

	 	 
	 
	  

	 
	 
	 @AfterClass
	 public void closeBrowser() {
		 driver.quit();
	 }
}
	 

