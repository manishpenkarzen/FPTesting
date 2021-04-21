	package com.freshproposals.selenium;
	
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
	import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;
	
	public class AddVariablesandVerify extends Common_Methods{
		
	WebDriver driver;
	WebDriverWait wait;
	String unm;
	String pwd;
	SoftAssert softAssertion= new SoftAssert();
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	String a;
	String[] expectedonpage1 = new String[] {"www.info.com","India","Kalyani Nagar , Nagar Road","Tester","9878678789","shahnawaz@zenincloud.com","S N Industies","Shahnawaz Nathani","Pune" ,"Maharashtra",};	
	
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
		public void addData() throws InterruptedException {
			createProposal(driver,wait);
			proposalName(driver,wait);
			client(driver,wait);
			scrollWindow(driver);
			calender(driver,wait);
//			existingDataProposal1(driver, wait);
//			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='search section']")));
//		    search.click();
//		    search.sendKeys("Six_Variables_Automation");
//		    existingDaraProposal2(driver,wait);
//		    Thread.sleep(5000);
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='edit-field-btn ng-star-inserted']"))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.name("name"))).click();
//
//			String expected_proposal_name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='hideControl']"))).getAttribute("value");
//			System.out.println(expected_proposal_name);

		    Thread.sleep(5000);

		    
			driver.findElement(By.xpath("//li[@id='Text']")).click();
		}
		
		@Test(priority = 2, enabled = false)
		public void AddsixVariablesandVerify() throws InterruptedException, AWTException {
			//String expected_result = "S N Industies";
			//Actions act = new Actions(driver);
			WebElement tb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resizers']")));
			tb.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-link collapsed ng-star-inserted']"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[2]//li[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[2]//li[2]")).click();
			
			Thread.sleep(3000);
			//WebElement search_variable = driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[1]//input[1]"));
			WebElement search_variable = driver.findElement(By.xpath("//ul[@id='collapseVariable']/div[1]/div/div[3]/input"));
			search_variable.click();
			Thread.sleep(1000);
			
			search_variable.sendKeys("client");
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[3]//li[1]")).click();
			driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[2]//div[2]//div//li[1]")).click();
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[3]//li[5]")).click();
			driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[2]//div[2]//div//li[5]")).click();
			
			Thread.sleep(3000);
			search_variable.click();
			Thread.sleep(1000);
			search_variable.clear();
			Thread.sleep(1000);
			search_variable.sendKeys("proposal");
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[4]//li[1]")).click();
			driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[2]//div[3]//div//li[1]")).click();
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[4]//li[4]")).click();
			driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[2]//div[3]//div//li[1]")).click();
			save(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSendMail"))).click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='../../../assets/link-icon-blue.svg']"))).click();
			String copy_text = driver.findElement(By.xpath("//div[@class='card-body ng-star-inserted']//input")).getAttribute("value");
		    System.out.println(copy_text);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='../../../assets/cancel-round.svg']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/app-root[1]/app-home[1]/div[1]/div[6]/div[1]/app-email[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]"))).sendKeys("Business Proposal For You");
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/app-root[1]/app-home[1]/div[1]/div[6]/div[1]/app-email[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]")))
		    .sendKeys("{ProposalLinkButton}\r\n" + 
		        		"{MySignature}");

		     wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Send"))).click();
		    Thread.sleep(2000);
		    //new window
		    ((JavascriptExecutor)driver).executeScript("window.open()");
		    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    driver.get(copy_text);
		    Thread.sleep(2000);

			String expected_var_value1 = "S N Industies";
			WebElement variable1 = driver.findElement(By.xpath("//span[@id='MyCompanyName']"));
			String actaul_var_value1 = variable1.getText();
			System.out.println(actaul_var_value1);
			Assert.assertEquals(actaul_var_value1, expected_var_value1);
			
			String expected_var_value2 = "Shahnawaz Nathani";
			WebElement variable2 = driver.findElement(By.xpath("//span[@id='MyUserName']"));
			String actaul_var_value2 = variable2.getText();
			System.out.println(actaul_var_value2);
			Assert.assertEquals(actaul_var_value2, expected_var_value2);
			
			String expected_var_value3 = "Automation PVT LTD";
			WebElement variable3 = driver.findElement(By.xpath("//span[@id='ClientCompanyName']"));
			String actaul_var_value3 = variable3.getText();
			System.out.println(actaul_var_value3);
			Assert.assertEquals(actaul_var_value3, expected_var_value3);
			
			String expected_var_value4 = "Alexa";
			WebElement variable4 = driver.findElement(By.xpath("//span[@id='ClientFirstName']"));
			String actaul_var_value4 = variable4.getText();
			System.out.println(actaul_var_value4);
			Assert.assertEquals(actaul_var_value4, expected_var_value4);
			
			String expected_var_value5 = "Shahnawaz Nathani";
			WebElement variable5 = driver.findElement(By.xpath("//span[@id='ProposalName']"));
			String actaul_var_value5 = variable5.getText();
			System.out.println(actaul_var_value5);
			Assert.assertEquals(actaul_var_value5, expected_var_value5);
			
			//String expected_var_value6 = "Shahnawaz Nathani";
			//WebElement variable6 = driver.findElement(By.xpath("//span[@id='ProposalSubmittedDate']"));
			//String actaul_var_value6 = variable6.getText();
			//System.out.println(actaul_var_value6);
			//Assert.assertEquals(actaul_var_value6, expected_var_value6);
			//app-fptext//div[@class='resizers']//div[@class='Quote highlight']//p"));
											
			
				
			}
			
			
//	 		JavascriptExecutor jse = (JavascriptExecutor)driver;
//
//			jse.executeScript("window.scrollBy(0,2000)");
//
//			driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[3]//li[1]")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//ul[@id='collapseVariable']//div[3]//li[5]")).click();
			

		
		
		@Test(priority = 2,enabled = true)
		public void AddvariablesOnFirstPage() throws InterruptedException, AWTException {
			Actions act = new Actions(driver);
			WebElement tb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resizers']")));
			tb.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-link collapsed ng-star-inserted']"))).click();
			Thread.sleep(5000);
			
			List<WebElement> variables = driver.findElements(By.xpath("//ul[@id='collapseVariable']//div[2]//li"));
			int numofvariables = variables.size();
			System.out.println(numofvariables);
			for(int i=0;i<numofvariables;i++) { //
				variables.get(i).click();
				//act.doubleClick(tb).perform();
				//act.sendKeys("hi").perform();
				tb.click();
				
				act.sendKeys(Keys.ENTER).perform();

				Thread.sleep(500);
			}	
//			save(driver);
//			preview(driver);
				
			}
		
//			
//			WebElement SaveBtn = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
//			SaveBtn.click();
//			Thread.sleep(3000);
//	//		WebElement CopyPage= driver.findElement(By.xpath("//div[@id='section_section8453']//div[3]//img[1]"));
//	//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//	//		executor.executeScript("arguments[0].click();", CopyPage);
//	//	//	CopyPage.click();
//	//		Thread.sleep(3000);
//	//		SaveBtn.click();
//	//		Thread.sleep(3000);
//	
//			}
		@Test(priority=2,enabled = false)
		public void VerifyVariablesInPreview() throws InterruptedException, AWTException {
			//Thread.sleep(10000);
			//driver.get("https://beta.freshproposals.net/home/viewproposal/1788/preview/proposals;InEditProposal=true");
			Thread.sleep(5000);
			List<WebElement> variables = driver.findElements(By.xpath("//app-fptext//div[@class='resizers']//div[@class='Quote highlight']//p"));
			for(WebElement var : variables) {									
				 a =var.getText();
				System.out.println(a);
			}
			//Assert.assertEquals(a, expectedonpage1);
			
//			int var= variables.size();
//			for(int j=0;j<var;j++) {
//				System.out.println(variables.get(j).getText());
//				String Actual =variables.get(j).getText();
//				softAssertion.assertEquals(Actual, expectedonpage1[j]);
			}
			
			//softAssertion.assertAll();
			
		//}
		
		@Test(priority = 3,enabled = true)
		public void addNewPage() throws InterruptedException {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='cdk-drag nav-item example-box ng-star-inserted active']//div[@class='add-section']"))).click();
			Thread.sleep(3000);
			//WebElement scrollPage = driver.findElement(By.xpath("//div[@class='card-body']//div[2]//a//img[@name='defaultpage']"));
			WebElement scrollPage = driver.findElement(By.xpath("//div[@id='collapseExample']/div/div/div[2]//a//img[@name='defaultpage']"));
	 		JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", scrollPage);
			
		}
		
		@Test(priority = 4,enabled = false)
		public void AddvariablesOnSecondPage() throws InterruptedException, AWTException {
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//li[@id='Text']")).click();		
			Actions act = new Actions(driver);
			WebElement tb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='page2']//div[@class='resizers']")));
			tb.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-link collapsed ng-star-inserted']")));//.click();
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", tb);
			Thread.sleep(5000);
			robot_Scroll(driver);
			List<WebElement> variables = driver.findElements(By.xpath("//ul[@id='collapseVariable']//div[3]//li"));
			int numofvariables = variables.size();
			System.out.println(numofvariables);
			for(int i=0;i<numofvariables;i++) {
				variables.get(i).click();
				//act.doubleClick(tb).perform();
				//act.sendKeys("hi").perform();
				tb.click();
				
				act.sendKeys(Keys.ENTER).perform();

				Thread.sleep(500);
			}	
		}
//		@Test(priority=3)
//		public void DeleteAllVariableFromBox() throws AWTException, InterruptedException {
//			driver.get("http://beta1.freshproposals.net/home/proposals/editProposal/2289");
//			Thread.sleep(3000);
//			WebElement nextBtn = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
//			JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click();", nextBtn);
//			Thread.sleep(2000);
//			driver.findElement(By.id("page1-fpText12320201625678mainDivTransformSafeStyle")).click();
//			Thread.sleep(1000);
//			 WebElement textbox=driver.findElement(By.id("page1-fpText12320201625678mainDivTransformSafeStyle"));
//			 textbox.click();
//			Robot   rbt= new Robot();
//			rbt.keyPress(KeyEvent.VK_CONTROL);
//			rbt.keyPress(KeyEvent.VK_A);
//			rbt.keyRelease(KeyEvent.VK_CONTROL);
//			rbt.keyRelease(KeyEvent.VK_A);
//			rbt.keyPress(KeyEvent.VK_CONTROL);
//			rbt.keyPress(KeyEvent.VK_DELETE);
//			rbt.keyRelease(KeyEvent.VK_CONTROL);
//			rbt.keyRelease(KeyEvent.VK_DELETE);
//			Thread.sleep(3000);
//			WebElement SaveBtn = driver.findElement(By.xpath("//li[@class='nav-item']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
//			SaveBtn.click();
//			Thread.sleep(3000);
//		}
	
		 
		@AfterClass
		  public void closeBrowser() throws InterruptedException {
			  quitBrowser(driver);
		  }
	
	}
