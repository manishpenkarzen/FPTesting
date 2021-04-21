	package com.freshproposals.selenium;
	
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	
	public class Common_Methods {
		//checkk
		String fname = "SEL";
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
		//analytics var
		String time;
		String view;
		String average;
		String lastview;
		
		WebDriverWait wait;
		
		//signature var
		String signature_width = "300";
		String signature_height = "70";
		String signature_border_width = "10";
		String signature_border_style = "inset";
		String signature_corner = "30";
		String signature_rotate = "5";
		String signature_padding_top = "10";
		String signature_padding_left = "10";
		String signature_padding_bottom = "70";
		String signature_padding_right = "10";
		
		String[] collapse = {"//div[@id='static-", "1", "2", "3", "-header']", "//button[@class='btn collapsiable-card-arrow collapsed']", "0"};
		String[] horizontal_length = {"boxshadowHarizontal"};
		
		
		
		
		@DataProvider
		  public Object[][] User1(){
			
			Object[][] credentials = {
					  { "shahnawaz@zenincloud.com",
					    "Shahnawaz@123"},
			  };
			
			return credentials;
		  }
		  
		  @DataProvider
		  public Object[][] User2(){
			
			
			Object[][] credentials = {
					  {"shanu@zenincloud.com",
					    "Shanu@123"},
			  };
			
			return credentials;
		  }
		  
		  @DataProvider
		  public Object[][] User3(){
			
			
			Object[][] credentials = {
					  {"manishpenkar.fp102@gmail.com",
					    "Manish123$"},
			  };
			
			return credentials;
		  }		  
		  
	public void login(String unm, String pwd, WebDriver driver) {
	    driver.findElement(By.id("email")).sendKeys(unm);
		driver.findElement(By.id("passwordTXT")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
		  
	public void openURL(WebDriver driver) {
		//driver.get("http://beta1.freshproposals.net");
	    driver.get("https://beta.freshproposals.net");
	    //driver.get("http://live.freshproposals.com");
	    //driver.get("https://app.freshproposals.com/");
	}
	
	
	public void quitBrowser(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	public void robot_Scroll(WebDriver driver) throws AWTException {
		Robot robot = new Robot();

        // Scroll Down using Robot class
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	
	public void setSystemProperties() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Selenium\\chromedriver.exe");
	
	}
	
	 public void systemTemplate(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("linkTemplates"))).click();
		 Thread.sleep(5000);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'System')]"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("searchTemplates"))).sendKeys("Coworking Space Proposal");
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//img[@src='../../../assets/edit-tool-list.svg']")).click();
		 Thread.sleep(20000);
	 }
	
	public void createProposal(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.id("linkProposals")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='../../assets/add-section-icon.png']"))).click();

	}
		  
		  
	public void generateProposalButton(WebDriver driver,WebDriverWait wait) {
		//driver.findElement(By.xpath("//button[contains(text(), 'Generate Proposal' )]")).click();
		  //driver.findElement(By.id("onboardingGenProposal")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.id("onboardingGenProposal"))).click();
	}
		  
		 
	public void proposalName(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		//Thread.sleep(3000);
		  wait.until(ExpectedConditions.elementToBeClickable(By.name("name"))).sendKeys(fname+" Proposal "+timestamp);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
	}
		  
		  
	public void client(WebDriver driver,WebDriverWait wait) throws InterruptedException  {
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search By Name']"))).sendKeys("Automation PVT LTD");
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-lg-12']//div[1]//div[2]//label[1]//span[1]"))).click();
	}
		 
		  
	public void scrollWindow(WebDriver driver) throws InterruptedException  {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	
	public void calender(WebDriver driver,WebDriverWait wait) throws InterruptedException  {
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='../../../assets/calendar.png']"))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ngb-dp-arrow right']//button[@class='btn btn-link ngb-dp-arrow-btn']"))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'15')]"))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn send-btn']"))).click();
	}
	
	
	public void sendNextButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("btnSendMail")).click();
	}
		
	
	public void createTemplate(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.id("linkTemplates")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='../../assets/add-section-icon.png']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("name"))).sendKeys(fname+" Template "+timestamp);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

	}
	
	public void createProposalsM(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='../../assets/add-section-icon.png']"))).click();
		 driver.findElement(By.name("name")).sendKeys(fname+" Sanity1_Proposal "+timestamp);
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search By Name']"))).sendKeys("Proposals Max");
		 Thread.sleep(5000);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
			
		 driver.findElement(By.xpath("//div[@class='col-lg-12']//div[1]//div[2]//label[1]//span[1]")).click();
		 driver.findElement(By.xpath("//img[@src='../../../assets/calendar.png']")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ngb-dp-arrow right']//button[@class='btn btn-link ngb-dp-arrow-btn']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'15')]"))).click();
		
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn send-btn']"))).click();
	}
	
	 public void resize(WebElement elementToResize, int xOffset, int yOffset, WebDriver driver) {
			try {
				if (elementToResize.isDisplayed()) {
					Actions action = new Actions(driver);
					action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
				} else {
					System.out.println("Element was not displayed to drag");
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Element with " + elementToResize + "is not attached to the page document "	+ e.getStackTrace());
			} catch (NoSuchElementException e) {
				System.out.println("Element " + elementToResize + " was not found in DOM " + e.getStackTrace());
			} catch (Exception e) {
				System.out.println("Unable to resize" + elementToResize + " - "	+ e.getStackTrace());
			}
		  }
			  
			 
	
	//template
	public void contentLibrary(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		//plus btn
		//driver.findElement(By.xpath("//button[@class='btn add-sect-btn template-add-sec ng-star-inserted']")).click();
		driver.findElement(By.id("onboardingAddSection")).click();
		Thread.sleep(5000);
		//search
		driver.findElement(By.xpath("//input[@placeholder='search section']")).sendKeys("Design");
		Thread.sleep(3000);
		//use this
		driver.findElement(By.xpath("//img[@class='img=fluid']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@class='img-fluid close-section-library']")).click();
	} 
	
	public void PcontentLibrary(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		//plus btn
		driver.findElement(By.xpath("//button[@class='btn add-sect-btn proposal-add-sec']")).click();
		Thread.sleep(5000);
		//search
		driver.findElement(By.xpath("//input[@placeholder='search section']")).sendKeys("Design");
		Thread.sleep(3000);
		//use this
		driver.findElement(By.xpath("//img[@class='img=fluid']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@class='img-fluid close-section-library']")).click();
	} 
	
	public void existingDataTemplate1(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("onboardingAddSection"))).click();		
	}
	
	public void existingDataTemplate2(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='btn btn-outline-light use-this-icon']")).click();			
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='img-fluid close-section-library']"))).click();			
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("New Secti"))).click();			
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='nav-item example-box active']//button[@id='dropdownBasic1']//img"))).click();			
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Delete')]"))).click();			
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn save-btn ng-star-inserted']"))).click();			
	}
	
	public void existingDataProposal1(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn add-sect-btn proposal-add-sec']"))).click();			
	}
	
	public void existingDaraProposal2(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn btn-outline-light use-this-icon']")).click();			
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='img-fluid close-section-library']"))).click();			
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("New Secti"))).click();			
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='cdk-drag nav-item example-box ng-star-inserted active']//button[@id='dropdownBasic1']"))).click();			
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Delete')]"))).click();			
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn save-btn ng-star-inserted']"))).click();
	}
	
	public void sendEmail(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Selenium Subject");
		  driver.findElement(By.xpath("//div[@class='fr-box fr-basic fr-top']//div[@class='fr-element fr-view']"))
		  .sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
					+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
					+ " when an unknown printer took a galley of type and scrambled it to make a type specimen book."
					+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
					+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
		  Thread.sleep(2000);
		  //send btn
		  driver.findElement(By.linkText("Send")).click();
		  Thread.sleep(5000);
	}
	
	
	public void analyticsCopyLink(WebDriver driver) throws InterruptedException {
		//link
		Thread.sleep(7000);
	    driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
	    Thread.sleep(3000);
	    //get coy text
	    String copy_text = driver.findElement(By.xpath("//div[@class='card-body ng-star-inserted']//input")).getAttribute("value");
	    System.out.println(copy_text);
	    Thread.sleep(2000);
	    //new window
	    ((JavascriptExecutor)driver).executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.get(copy_text);
	    //section
	    Thread.sleep(30000);
		driver.findElement(By.xpath("//a[contains(text(),'Welcome Note')]")).click();
	    Thread.sleep(30000);
	    driver.findElement(By.xpath("//a[contains(text(),'Why Co-working?')]")).click();
	    Thread.sleep(30000);
	    driver.findElement(By.xpath("//a[contains(text(),'Why Us')]")).click();
	    Thread.sleep(30000);
	    driver.findElement(By.xpath("//a[contains(text(),'Our Co-working Solutions')]")).click();
	    Thread.sleep(30000);
	    driver.findElement(By.xpath("//a[contains(text(),'Our Co-working Solutions')]")).click();
	    Thread.sleep(30000);
	    driver.close();
		driver.switchTo().window(tabs.get(0));
	}
	
	public void AttendProposal(WebDriver driver, String proposal_link) throws InterruptedException {
		//link
		Thread.sleep(3000);
	    //driver.findElement(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']")).click();
	    //Thread.sleep(3000);
	    //get coy text
	    //String copy_text = driver.findElement(By.xpath("//div[@class='card-body ng-star-inserted']//input")).getAttribute("value");
	    //System.out.println(copy_text);
		
	    //Thread.sleep(2000);
	    //new window
	    ((JavascriptExecutor)driver).executeScript("window.open()");
	    //https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.get(proposal_link);
	    //section
	    Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Welcome Note')]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//a[contains(text(),'Why Co-working?')]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//a[contains(text(),'Why Us')]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//a[contains(text(),'Our Co-working Solutions')]")).click();
	    Thread.sleep(5000);
	    //driver.findElement(By.xpath("//a[contains(text(),'Our Co-working Solutions')]")).click();
	    //Thread.sleep(2000);
	    
	    //code to accept proposal
	    	    	  
	   	 //Thread.sleep(5000);
	   	 driver.findElement(By.xpath("//button[@class='btn tool-list-save ng-star-inserted']")).click();  //Accept proposal button
	   	Thread.sleep(3000);
	   	driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div/div[2]/div[1]/div/input")).sendKeys("John Smith");// Client Name
	   	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-modal-window/div/div/div/div[2]/div[1]/div/input"))).sendKeys("John Smith");// Client Name
	   	Thread.sleep(1000);
	   	driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div/div[2]/div[2]/div/input")).sendKeys("Manager"); // Client Designation.click();
	   	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-modal-window/div/div/div/div[2]/div[2]/div/input"))).sendKeys("Manager"); // Client Designation
	   	Thread.sleep(1000);
	   	driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div/div[2]/div[4]/input")).click();// Checkbox - I Agree
	   	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-modal-window/div/div/div/div[2]/div[4]/input"))).click(); // Checkbox - I Agree
	   	Thread.sleep(1000);
	   	driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div/div[2]/div[5]/button")).click(); // Popup Submit button
	   	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-modal-window/div/div/div/div[2]/div[5]/button"))).click(); // Popup Submit button
	   	
	   	
	   	Thread.sleep(5000);
	   	
	   	driver.findElement(By.xpath("//*[@id=\"scrollContainer\"]/div[3]/img")).click(); // download PDF
	   	//driver.findElement(By.xpath("/html/body/app-root/app-home/div/div[6]/div/app-view-proposal/div[2]/div/div[5]/div/div[3]")).click(); // download PDF
	   	
	   	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"scrollContainer\"]/div[3]/img"))).click(); // download PDF
	  
	   	Thread.sleep(40000);
	   	//Thread.sleep(10000);	    
	    
	    driver.close();
		driver.switchTo().window(tabs.get(0));
		
	}
	
	
	public void getSummaryData(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		time =  driver.findElement(By.xpath("//div[@class='proposal-analytics-timespent']//div[1]")).getText();
		System.out.println("A TOTAL TIME SPENT VIEWING " +  time);
		//times viewed (quick change)
		view = driver.findElement(By.xpath("//div[@class='proposal-analytics-box-timespent']//div[2]//div[2] ")).getText();
		System.out.println("A TIMES VIEWED " + view);
		//average time
		average = driver.findElement(By.xpath("//div[@class='proposal-analytics-timespent']//div[3]")).getText();
		System.out.println("A AVERAGE TIME VIEWING " + average);				
		//time since last view
		lastview = driver.findElement(By.xpath("//div[@class='proposal-analytics-timespent']//div[4]")).getText();
		System.out.println("A TIME SINCE LAST VIEWED " + lastview);
	
	}
	
	public void save(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		Thread.sleep(3000);
	}
	
	public void back(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
	    Thread.sleep(6000);
	}
	
	public void preview(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Preview')]")).click();
		Thread.sleep(3000);
	}
	
	//Signature Properties
	
	public void signatureWidth(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.name("textWidth11")).clear();
	    driver.findElement(By.name("textWidth11")).sendKeys(signature_width);
	    String actual_width = driver.findElement(By.name("textWidth11")).getAttribute("value");
	    Assert.assertEquals(actual_width, signature_width);
	}
	
	public void signatureHeight(WebDriver driver) throws InterruptedException {
	    Thread.sleep(1000);
	    driver.findElement(By.name("height11")).clear();
	    driver.findElement(By.name("height11")).sendKeys(signature_height);
	    String actual_height = driver.findElement(By.name("height11")).getAttribute("value");
	    Assert.assertEquals(actual_height, signature_height);
	}
	
	public void signatureReflectWidth(WebDriver driver) {
		 driver.findElement(By.id("page1-fpSign115201911423648")).click();
		  String actual_reflect_width = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("width");
		  String expected_reflect_width = signature_width+"px";
		  System.out.println("Awidth "+actual_reflect_width);
		  System.out.println("Ereflect width "+expected_reflect_width);
		  Assert.assertEquals(actual_reflect_width, expected_reflect_width);
	}
	
	public void signatureReflectHeight(WebDriver driver) throws InterruptedException {
	driver.findElement(By.id("page1-fpSign115201911423648")).click();
	  String actual_reflect_height = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("height");
	  System.out.println("Aheight "+actual_reflect_height);
	  String expected_reflect_height = signature_height+"px";
	  System.out.println("Ereflect height "+expected_reflect_height);
		  Assert.assertEquals(actual_reflect_height, expected_reflect_height);
	}
	
	public void signatureResetHeightWidth(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		  driver.findElement(By.id("page1-fpSign115201911423648")).click();
	  driver.findElement(By.name("textWidth11")).clear();
	  driver.findElement(By.name("textWidth11")).sendKeys("250");
	  
	  Thread.sleep(1000);
	  driver.findElement(By.name("height11")).clear();
	  driver.findElement(By.name("height11")).sendKeys("75");
	}
	
	public void signatureCorner(WebDriver driver) throws InterruptedException {
		//corner
		  Thread.sleep(1000);
		  driver.findElement(By.name("corners")).clear();
		  driver.findElement(By.name("corners")).sendKeys(signature_corner);
		  String actual_corner = driver.findElement(By.name("corners")).getAttribute("value");
		  Assert.assertEquals(actual_corner, signature_corner);
	}
	
	public void signatureRotate(WebDriver driver) throws InterruptedException {
		 Thread.sleep(1000);
		  driver.findElement(By.name("rotate")).clear();
		  driver.findElement(By.name("rotate")).sendKeys(signature_rotate);
		  String actual_rotate = driver.findElement(By.name("rotate")).getAttribute("value");
		  System.out.println(actual_rotate);
		  Assert.assertEquals(actual_rotate, signature_rotate); 
	}
	
	public void signatureColor(WebDriver driver) throws InterruptedException {
		 //color   
		  Thread.sleep(1000);
		  //driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-signature-properties[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]\n")).click();
		  driver.findElement(By.xpath("//span[@class='e-btn-icon e-icons e-caret']")).click();
		  Thread.sleep(1000);
		  //WebElement r1 = driver.findElement(By.xpath("//div[@class='e-handle e-handle-first']"));
		  //resize(r1, 75,75);
		  driver.findElement(By.xpath("//input[@class='e-hex']")).clear();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@class='e-hex']")).sendKeys("#000000");
		  Thread.sleep(2000);
		  //driver.findElement(By.className("e-hsv-color")).click();
		  driver.findElement(By.xpath("//span[@class='e-handler']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[@class='e-btn e-css e-flat e-primary e-small e-apply']")).click();
		  Thread.sleep(1000);
		  //System.out.println(driver.findElement(By.className("e-hsv-color")).getText());
	}
	
	public void signatureBorderWidth(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		  //border width
		  driver.findElement(By.name("border")).click();
		  Thread.sleep(1000);
	
		  driver.findElement(By.name("borderWidth")).clear();
		  driver.findElement(By.name("borderWidth")).sendKeys(signature_border_width);
		  String actual_border_width = driver.findElement(By.name("borderWidth")).getAttribute("value");
		  Assert.assertEquals(actual_border_width, signature_border_width);
		  Thread.sleep(1000);
	}
	
	public void signatureBorderStyle(WebDriver driver) throws InterruptedException {
		//border style
		  Select select = new Select(driver.findElement(By.name("borderStyle")));
		  select.selectByIndex(6);
		  String actual_border_style = select.getFirstSelectedOption().getText();
		  System.out.println(actual_border_style);
		  Assert.assertEquals(actual_border_style, signature_border_style);
		  Thread.sleep(1000);
	}
	
	public void signaturePaddingTtop(WebDriver driver) throws InterruptedException, AWTException {
		  //padding
		  driver.findElement(By.name("padding")).click();
		  Thread.sleep(1000);
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	
		  driver.findElement(By.name("paddingTop")).clear();
		  driver.findElement(By.name("paddingTop")).sendKeys(signature_padding_top);
		  String actual_padding_top = driver.findElement(By.name("paddingTop")).getAttribute("value");
		  Assert.assertEquals(actual_padding_top, signature_padding_top);
	}
	
	public void signaturePaddingLleft(WebDriver driver) throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.name("paddingLeft")).clear();
		  driver.findElement(By.name("paddingLeft")).sendKeys(signature_padding_left);
		  String actual_padding_left = driver.findElement(By.name("paddingLeft")).getAttribute("value");
		  Assert.assertEquals(actual_padding_left, signature_padding_left);
	}
	
	public void signaturePadingBottom(WebDriver driver) throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.name("paddingBottom")).clear();
		  driver.findElement(By.name("paddingBottom")).sendKeys(signature_padding_bottom);
		  String actual_padding_bottom = driver.findElement(By.name("paddingBottom")).getAttribute("value");
		  Assert.assertEquals(actual_padding_bottom, signature_padding_bottom);
	}
	
	public void signaturePaddingRight(WebDriver driver) throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.name("paddingRight")).clear();
		  driver.findElement(By.name("paddingRight")).sendKeys(signature_padding_right);
		  String actual_padding_right = driver.findElement(By.name("paddingRight")).getAttribute("value");
		  Assert.assertEquals(actual_padding_right, signature_padding_right);
	}
	
	public void signatureSignee(WebDriver driver) throws InterruptedException {
		  //signee
		  Select select1 = new Select(driver.findElement(By.name("signee")));
		  select1.selectByValue("0: Object");
		  String actual_signee = select1.getFirstSelectedOption().getText();
		  String expeted_signee = "Rahul Sharma";
		  Assert.assertEquals(actual_signee, expeted_signee);
		  //check
		  Thread.sleep(1000);
	}
	
	public void signatureResize(WebDriver driver, WebElement elementToResize, int xOffset, int yOffset) {
			try {
				if (elementToResize.isDisplayed()) {
					Actions action = new Actions(driver);
					action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
				} else {
					System.out.println("Element was not displayed to drag");
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Element with " + elementToResize + "is not attached to the page document "	+ e.getStackTrace());
			} catch (NoSuchElementException e) {
				System.out.println("Element " + elementToResize + " was not found in DOM " + e.getStackTrace());
			} catch (Exception e) {
				System.out.println("Unable to resize" + elementToResize + " - "	+ e.getStackTrace());
			}
			
		}
	
	public void signatureReflectCorner(WebDriver driver) {
		  driver.findElement(By.id("page1-fpSign115201911423648")).click();
		  String actual_reflect_corner = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("border-radius");
		  String expected_reflect_corner = signature_corner+"px";
		  System.out.println("Acorner "+actual_reflect_corner);
		  System.out.println("Ereflect corner "+expected_reflect_corner);
		  Assert.assertEquals(actual_reflect_corner, expected_reflect_corner);
		  
	}
	
	//@Test(priority = 20)
	//public void reflect_roate() {
	//	  driver.findElement(By.id("page1-fpSign115201911423648")).click();
	//	  String actual_reflect_rotate = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("transform");
	//	  String expected_reflect_rotate = rotate+"px";
	//	  System.out.println("Arotate "+actual_reflect_rotate);
	//	  System.out.println("Ereflect rotate "+expected_reflect_rotate);
	//	  Assert.assertEquals(actual_reflect_rotate, expected_reflect_rotate);
	//	  
	//}
	
	public void signatureReflectBorderWidth(WebDriver driver) throws InterruptedException {
		  driver.findElement(By.id("page1-fpSign115201911423648")).click();
		  String actual_reflect_border_width = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("border-width");
		  System.out.println("A = "+actual_reflect_border_width);
		  String expected_reflect_border_width = signature_border_width+"px";
		  System.out.println("E "+expected_reflect_border_width);
		  Assert.assertEquals(actual_reflect_border_width, expected_reflect_border_width);
		  Thread.sleep(5000);
		  
	}
	
	public void signatureReflectBorderStyle(WebDriver driver) throws InterruptedException {
		  driver.findElement(By.id("page1-fpSign115201911423648")).click();
		  String actual_reflect_border_style = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("border-style");
		  System.out.println("A = "+actual_reflect_border_style);
		  String expected_reflect_border_style = signature_border_style;
		  System.out.println("E "+expected_reflect_border_style);
		  Assert.assertEquals(actual_reflect_border_style, expected_reflect_border_style);
		  Thread.sleep(5000);
		  
	}
	
	public void signatureReflectPadding(WebDriver driver) throws InterruptedException {
		  driver.findElement(By.id("page1-fpSign115201911423648")).click();
		  String actual_reflect_padding_top = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("padding-top");
		  String actual_reflect_padding_left = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("padding-left");
		  String actual_reflect_padding_bottom = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("padding-bottom");
		  String actual_reflect_padding_right = driver.findElement(By.id("page1-fpSign115201911423648")).getCssValue("padding-right");
		  System.out.println("reflect_top = "+actual_reflect_padding_top);
		  System.out.println("reflect_left = "+actual_reflect_padding_left);
		  System.out.println("reflect_bottom = "+actual_reflect_padding_bottom);
		  System.out.println("reflect_right = "+actual_reflect_padding_right);
		  String expected_reflect_padding_top = signature_padding_top+"px";
		  String expected_reflect_padding_left = signature_padding_left+"px";
		  String expected_reflect_padding_bottom = signature_padding_bottom+"px";
		  String expected_reflect_padding_right = signature_padding_right+"px";
		  
		  Assert.assertEquals(actual_reflect_padding_top, expected_reflect_padding_top);
		  Assert.assertEquals(actual_reflect_padding_left, expected_reflect_padding_left);
		  Assert.assertEquals(actual_reflect_padding_bottom, expected_reflect_padding_bottom);
		  Assert.assertEquals(actual_reflect_padding_right, expected_reflect_padding_right);
		  Thread.sleep(5000);
		  
	}
	
	public void signatureResetAll(WebDriver driver) throws InterruptedException, AWTException {
	       Thread.sleep(1000);
		   driver.findElement(By.id("page1-fpSign115201911423648")).click();
		   
		  Thread.sleep(1000);
		  driver.findElement(By.name("corners")).clear();
		  driver.findElement(By.name("corners")).sendKeys("0");
		  
		  Thread.sleep(1000);
		  driver.findElement(By.name("rotate")).clear();
		  driver.findElement(By.name("rotate")).sendKeys("0");
		  
		  //color
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//span[@class='e-btn-icon e-icons e-caret']")).click();
		  Thread.sleep(1000);
		  //WebElement r1 = driver.findElement(By.xpath("//div[@class='e-handle e-handle-first']"));
		  //resize(r1, 75,75);
		  driver.findElement(By.xpath("//input[@class='e-hex']")).clear();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@class='e-hex']")).sendKeys("#ffffff");
		  Thread.sleep(2000);
		  //driver.findElement(By.className("e-hsv-color")).click();
		  driver.findElement(By.xpath("//span[@class='e-handler']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[@class='e-btn e-css e-flat e-primary e-small e-apply']")).click();
		  Thread.sleep(1000);
	
		  Thread.sleep(1000);
		  driver.findElement(By.name("borderWidth")).clear();
		  driver.findElement(By.name("borderWidth")).sendKeys("0");
		  
		  Thread.sleep(1000);
		  Select select = new Select(driver.findElement(By.name("borderStyle")));
		  select.selectByIndex(2);
		  Thread.sleep(3000);
		  driver.findElement(By.name("border")).click();
	
	      Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		  
		  Thread.sleep(1000);
		  driver.findElement(By.name("paddingTop")).clear();
		  driver.findElement(By.name("paddingTop")).sendKeys("0");
		  Thread.sleep(1000);
		  driver.findElement(By.name("paddingLeft")).clear();
		  driver.findElement(By.name("paddingLeft")).sendKeys("0");
		  Thread.sleep(1000);
		  driver.findElement(By.name("paddingBottom")).clear();
		  driver.findElement(By.name("paddingBottom")).sendKeys("0");
		  Thread.sleep(1000);
		  driver.findElement(By.name("paddingRight")).clear();
		  driver.findElement(By.name("paddingRight")).sendKeys("0");
		  
		  driver.findElement(By.name("padding")).click();
		  
		  Thread.sleep(1000);
	//	  driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-signature-properties[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]\n")).click();
	//	  Thread.sleep(1000);
	//	  WebElement r1 = driver.findElement(By.xpath("//div[@class='e-hue-slider e-control e-slider e-lib']//div[@class='e-slider-track']"));
	//	  resize(r1, 75,75);
	//	  Thread.sleep(1000);
	//	  driver.findElement(By.xpath("//span[@class='e-handler']")).click();
	//	  Thread.sleep(1000);
	//	  driver.findElement(By.xpath("//button[@title='Apply']")).click();
	//	  Thread.sleep(1000);
		  
		 
		  
		  driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  
	}
	
//	public void CollapsedCommonPath() {
//		String collapse1 = "//button[@class='btn collapsiable-card-arrow collapsed']";
//		String collapse2 = "//div[@id='static-";
//		String collapse3 = "-header']";
//		String no0 = "1";
//		String no1 = "2";
//		String no2 = "3";
//		String no3 = "4";
//	}
	
		
	
	
	
	
	
	
	
	
		  
		  
		  
		  
	}
	
