package com.freshproposals.selenium;


import java.awt.AWTException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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

import com.freshproposals.selenium.Common_Methods;

public class RepeaterAll extends Common_Methods {
	WebDriver driver;
	WebDriverWait wait;
	String unm;
	String pwd;
	
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
	 	
	 	@Test(priority=1)
	 	public void Repeater() throws InterruptedException {
	 		Thread.sleep(10000);
	 		driver.get("https://beta.freshproposals.net/home/templates/editTemplate/923");

	 		WebElement RHSMenuArrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tool-list-collapse ng-star-inserted']")));
	 		RHSMenuArrow.click();
	 		WebElement RepeaterMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tool-list-item']//p[contains(text(),'Repeater')]")));
	 		RepeaterMenu.click();
	 		
	 		Thread.sleep(3000);
	 		WebElement Text = driver.findElement(By.xpath("//app-edit-section[2]//div[@class='section-preview-mobile']//div[3]//div[@class='resizers']//div[@class='Quote highlight fr-box']//div[@class='fr-wrapper show-placeholder']//div[@class='fr-element fr-view']"));
	 		Text.click();
	 		Text.sendKeys("FreshProposals");
	 		//"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
//	 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[starts-with(@id,'paragraphStyle')]"))).click();
//	 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='fr-command fpHeading2']"))).click();
	 		Thread.sleep(3000);
	 		
//	 		String TextFontSize = Text2.getCssValue("fpHeading2-varfont-size");
//	 		System.out.println(TextFontSize);
//	 		Assert.assertEquals(TextFontSize, "18px");
//	 		TextFontSize.click();
//	 		Thread.sleep(2000);
//	 		WebElement P4 = driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]"));
//	 		
//	 		P4.click();
//	 		Thread.sleep(2000);
//	 		WebElement heading1 = driver.findElement(By.xpath("//a[@class='fr-command fpHeading1']"));
//	 		heading1.click();
//	 		 Thread.sleep(2000);
//	 		WebElement TextFontSize2 = driver.findElement(By.xpath("//div[@id='froalapage1-fpText121220199585999']//p[@class='fpHeading1'][contains(text(),'Freshproposals')]"));
//	 		 String fontsize2 =TextFontSize2.getCssValue("font-size");
//	 		 Assert.assertEquals(fontsize2, "36px");
//	 		// WebElement RepeterShape =driver.findElement(By.id("page1-fpShape121220191011694"));
//	 		//RepeterShape.click();
//	 		
//	 		
	 	}
	 	
	 	@Test(priority =2)
	 	public void ImageResize() throws InterruptedException {
	 		WebElement RepeaterImage = driver.findElement(By.xpath("//app-edit-section[2]//app-fpimage[@class='ng-star-inserted']/div[1]//div[@class='ui-draggable ui-draggable-handle rectangle repeater']//div[@class='rectangle resize-drag ui-resizable ui-resizable-autohide']//div[@class='resizers']//img "));
	 		RepeaterImage.click();
	 		WebElement width = wait.until(ExpectedConditions.elementToBeClickable(By.name("width11")));
	 		width.clear();
	 		width.sendKeys("235");
//	 		WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='page1-fpImage121220191005127']//div[@id='nwgrip']"));
//	 		resize( shapeResize, 150, 75);
//				int Width = RepeaterImage.getSize().getWidth();
//				int Height = RepeaterImage.getSize().getHeight();  
//				//System.out.println("Image Width"+Width);
//				//System.out.println("Image Height"+Height);
//				Assert.assertEquals(Width, 127);     
//				Assert.assertEquals(Height, 110);
	 		Thread.sleep(3000);
	 	}
	 	
	 	@Test(priority = 3)
	 	public void shapeResize() throws InterruptedException {
	 		WebElement RepeaterShape = driver.findElement(By.xpath("//app-edit-section[2]//app-fpshape[@class='ng-star-inserted']//div[1]//div[@class='ui-draggable ui-draggable-handle rectangle repeater']//div[1]//div[@class='resizers']//div[@class='ng-star-inserted']//div[1]"));
	 		RepeaterShape.click();
	 		WebElement width = wait.until(ExpectedConditions.elementToBeClickable(By.name("textWidth11")));
	 		width.clear();
	 		width.sendKeys("415");
	 		Thread.sleep(3000);

	 	}
	 	
	 	@Test(priority = 4)
	 	public void signatureResize() throws InterruptedException {
	 		WebElement RepeaterSignature = driver.findElement(By.xpath("//app-edit-section[2]//app-fpsignature[@class='ng-star-inserted']//div[1]//div[@class='ui-draggable ui-draggable-handle repeater']//div[@class='signature-sec ng-star-inserted']"));
	 		RepeaterSignature.click();
	 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-link collapsed ng-star-inserted']"))).click();
	 		WebElement height = wait.until(ExpectedConditions.elementToBeClickable(By.name("height11")));
	 		height.clear();
	 		height.sendKeys("90");
//	 		WebElement width = wait.until(ExpectedConditions.elementToBeClickable(By.name("textWidth11")));
//	 		width.clear();
//	 		width.sendKeys("415");
	 		Thread.sleep(3000);

	 	}
	 	
	 	@Test(priority = 5)
	 	public void addNewPage() throws InterruptedException, AWTException {
	 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='exit-styling-mode btn next-btn']"))).click();
	 		//Thread.sleep(2000);
	 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[2]//div[4]//div[1]//div[1]//div[2]"))).click();
	 		Thread.sleep(3000);
	 		
	 	}
	 	
	 	@Test(priority = 6)
	 	public void verifyTextBoxInPreview() throws InterruptedException {
	 		String expected_text = "FreshProposals";
	 		preview(driver);
//	 		WebElement Text = driver.findElement(By.xpath("//app-edit-section[2]//app-fptext//div[@class='rectangle rectangle-readonly repeater lock']//div[@class='rectangle-readonly']//div[@class='resizers']//div[@class='Quote highlight']//p[contains(text(),'FreshProposals')]"));
//	 		//WebElement Text22 = driver.findElement(By.xpath("//app-edit-section[2]//app-fptext//div[@class='rectangle rectangle-readonly repeater lock']//div[@class='rectangle-readonly']//div[@class='resizers']//div[@class='Quote highlight']"));
//
//	 		String actual_text_firstpage = Text.getText();
//	 		//String text2 =Text22.getAttribute("--fpHeading2-varfont-size");
//	 		//String text3 =Text22.getCssValue("--fpHeading2-varfont-size");
//	 		//--fpHeading2-varfont-size
//	 		System.out.println("Text in First Page: "+actual_text_firstpage);
	 		//System.out.println(text2);
	 		//System.out.println(text3);
	 		
	 		//second page
//	 		WebElement scrollPage = driver.findElement(By.xpath("//a[@id='listsectionPage_5151page2']//img[@name='defaultpage']"));
//	 		JavascriptExecutor jse = (JavascriptExecutor)driver;
//			jse.executeScript("arguments[0].click()", scrollPage);
			
//	 		String actual_text_secondpage = Text.getText();
//	 		System.out.println("Text in Second Page: "+actual_text_secondpage);
//	 		
//	 		Assert.assertEquals(actual_text_firstpage, expected_text);
//	 		Assert.assertEquals(actual_text_secondpage, expected_text);
	 		System.out.println("Text of TextBox");
	 		List<WebElement> texts = driver.findElements(By.xpath("//app-edit-section[2]//app-fptext//div[@class='rectangle rectangle-readonly repeater lock']//div[@class='rectangle-readonly']//div[@class='resizers']//div[@class='Quote highlight']//p[contains(text(),'FreshProposals')]"));
	 		for(WebElement text : texts)
	 		{
	 			String actual_text = text.getText();
	 			System.out.println(actual_text);
	 			Assert.assertEquals(actual_text, expected_text);
	 		}


	 	}
	 	
	 	@Test(priority = 7)
	 	public void pageNoVar() throws InterruptedException {
	 		System.out.println("Page No (Variables)");
	 		WebElement pagenovar1 = driver.findElement(By.xpath("//span[contains(text(),'1')]"));
	 		String actual_page_no_var_text = pagenovar1.getText();
	 		System.out.println("First Page No: "+actual_page_no_var_text);
	 		
	 		WebElement pagenovar2 = driver.findElement(By.xpath("//span[contains(text(),'2')]"));
	 		String actual_page_no_var_text2 = pagenovar2.getText();
	 		System.out.println("Second Page No: "+actual_page_no_var_text2);
	 		
//	 		List<WebElement> spans = driver.findElements(By.tagName("span"));
//	 		for (WebElement span : spans)
//	 		{
//	 		    String text = span.getText();
//	 		    System.out.println(text);
//	 		}
	 		
	 	}
	 	
	 	@Test(priority = 8)
	 	public void verifyImageInPreview() throws InterruptedException {
	 		String expected_width = "235px";
	 		System.out.println("Image Width");
	 		List<WebElement> widths = driver.findElements(By.xpath("//app-edit-section[2]//app-fpimage[@class='ng-star-inserted']/div[1]//div[@class='rectangle rectangle-readonly repeater lock']//div[1]//div[@class='resizers']//img "));
	 		for(WebElement width : widths)
	 		{
	 			String actual_width = width.getCssValue("width");
	 			System.out.println(actual_width);
	 			Assert.assertEquals(actual_width, expected_width);
	 		}
	 		//WebElement width = driver.findElement(By.xpath("//app-edit-section[2]//app-fpimage[@class='ng-star-inserted']/div[1]//div[@class='rectangle rectangle-readonly repeater lock']//div[1]//div[@class='resizers']//img "));
//	 		String actual_width = width.getCssValue("width");
//	 		System.out.println(actual_width);
	 		
	 	}
	 	
	 	@Test(priority = 9)
	 	public void verifyShapeInPreview() throws InterruptedException {
	 		String expected_width = "415px";
	 		System.out.println("Shape Width");
	 		List<WebElement> widths = driver.findElements(By.xpath("//app-edit-section[2]//app-fpshape[@class='ng-star-inserted']//div[1]//div[@class='rectangle rectangle-readonly repeater lock']//div[@class='resizers']//div[@class='ng-star-inserted']"));
	 		for(WebElement width : widths)
	 		{
	 			String actual_width = width.getCssValue("width");
	 			System.out.println(actual_width);
	 			Assert.assertEquals(actual_width, expected_width);
	 		}
	 		
	 	}
	 	
	 	@Test(priority = 10)
	 	public void verifySignatureInPreview() throws InterruptedException {
	 		String expected_height = "90px";
	 		System.out.println("Signature height");
	 		List<WebElement> heights = driver.findElements(By.xpath("//app-edit-section[2]//app-fpsignature[@class='ng-star-inserted']//div[1]//div[@class='rectangle-readonly repeater lock']//div[@class='signature-sec ng-star-inserted']"));
	 		for(WebElement height : heights)
	 		{
	 			String actual_height = height.getCssValue("height");
	 			System.out.println(actual_height);
	 			Assert.assertEquals(actual_height, expected_height);
	 		}
	 		
	 	}
	 	
	 	
	 	@Test(priority =2, enabled = false)
	 	public void RepeaterShape() throws InterruptedException {
				Thread.sleep(5000);

	 		 //WebElement RepeterShape =driver.findElement(By.xpath("//div[@id='page2-FPShape123020191263849']"));
	 		//div[@id='section91120201328957-page1-fpShape911202013464042']//div[@class='resizers']
	 		WebElement RepeterShape =driver.findElement(By.xpath("//body/app-root/app-home[@class='ng-star-inserted']/div[@class='wrapper']/div[@id='content']/div[@class='apply-hidden styling-mode-effect']/app-edit-template[@class='ng-star-inserted']/div[@class='editor-box template-editor']/div[@class='row template-mobile-view']/div[@class='col-lg-8 offset-lg-2 edit-template-margin']/div[@id='scrollContainer']/div[@id='contentToConvert']/app-edit-section[@class='ng-star-inserted']/div[@class='section-preview-mobile']/div/div[@class='section-editor-box']/div[@id='scrollContainer']/div[@class='page-scalemargin-']/div[@id='section_section914202018452956']/div[@id='section914202018452956']/app-sections-page[@class='ng-star-inserted']/a[@name='page1']/div[@class='page-wrapper']/div[@class='page effect8']/div[@id='sectionPage_5151page1']/app-fpshape[@class='ng-star-inserted']/div[@class='text-element shape-element']/div[@id='page1-FPShape914202018452970mainDivTransformSafeStyle']/div[@id='page1-FPShape914202018452970']/div[@class='resizers']/div[1]/div[1]"));

		 		RepeterShape.click();
 				Thread.sleep(5000);
// 				  Actions builder = new Actions(driver);
// 			        builder.moveToElement(RepeterShape).build().perform();
//		 		WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='page2-fpShape121220191011694']//div[@id='segrip']"));
// 				resize( shapeResize, 150, 75);
// 				int Width = RepeterShape.getSize().getWidth();
// 				int Height = RepeterShape.getSize().getHeight();  
// 				//System.out.println(Width);
// 				//System.out.println(Height);
// 				Assert.assertEquals(Width, 270);     
// 				Assert.assertEquals(Height, 186);
// 				Thread.sleep(5000);
	 		
	 	}
	 	
	 
	 	
//	 	@Test(priority=4)
//	 	public void LineInRepeater() throws InterruptedException {
//	 		WebElement ShapeLine =	driver.findElement(By.xpath("//div[@id='page1-fpShape121220191042817']"));
//	 		ShapeLine.click();
//	 		WebElement Linelength = driver.findElement(By.xpath("//input[@name='textWidth11']"));
//	 		Linelength.clear();
//	 		Linelength.sendKeys("175");
//	 		int Width = ShapeLine.getSize().getWidth();
//			//System.out.println(Width);
//			
//			Assert.assertEquals(Width, 175);     
//			Thread.sleep(3000);
//			
//	 		
//	 	}
//	 	@Test(priority=5)
//	 	public void SignatureProperties() throws InterruptedException {
//	 		
//	 	WebElement Sign =driver.findElement(By.xpath("//div[@id='page1-fpSign1212201913154755']"));
//	 	Sign.click();
//	 	WebElement ApplyBorderCheckbox = driver.findElement(By.xpath("//div[7]//div[1]//input[1]"));
//	 	ApplyBorderCheckbox.click();
//	 	WebElement BorderWidth = driver.findElement(By.xpath("//input[@name='borderWidth']"));
//	 	BorderWidth.clear();
//	 	BorderWidth.sendKeys("5");
//	 	String borderwidth = 	Sign.getCssValue("border-width");	
//	 	Assert.assertEquals(borderwidth, "5px");     
//
//	 	Thread.sleep(5000);
//	 	}
//	 	@Test(priority=6)
//	 	public void TextFontVerification() throws InterruptedException {
//	 		
//	 		
//	 		WebElement SaveBtn= driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
//	 		SaveBtn.click();
//	 		Thread.sleep(5000);
//	 		WebElement ExitRepeterModeBtn = driver.findElement(By.xpath("//div[@class='exit-styling-mode btn next-btn']"));
//	 		ExitRepeterModeBtn.click();
//	 		Thread.sleep(5000);
//
//	 		WebElement Section2 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
//	 		Section2.click();
//	 		Thread.sleep(5000);
//	 		WebElement TextFontSize = driver.findElement(By.xpath("//div[@id='froalapage1-fpText1212201915294951']//p[@class='fpHeading1'][contains(text(),'Freshproposals')]"));
//	 		
//	 		String fontsize1 =TextFontSize.getCssValue("font-size");
//	 		//System.out.println(str);
//	 		Assert.assertEquals(fontsize1, "36px");
//	 		TextFontSize.click();
//	 		Thread.sleep(2000);
//	 		
//			
//			 
//	 	}
//	 	@Test(priority =7)
//	 	public void ImageVerification() throws InterruptedException {
//	 		WebElement RepeaterImage = driver.findElement(By.id("page1-fpImage121220191005127"));
//	 		int Width3 = RepeaterImage.getSize().getWidth();
//			int Height3 = RepeaterImage.getSize().getHeight();  
//			//System.out.println("Image Width"+Width);
//			//System.out.println("Image Height"+Height);
//			Assert.assertEquals(Width3, 127);     
//			Assert.assertEquals(Height3, 110);
//			Thread.sleep(3000);
//	 	}	 
//	 	@Test(priority =8)
//	 	public void RectangleVerification() throws InterruptedException {
//	 		 WebElement RepeterShape =driver.findElement(By.id("page1-fpShape1212201915294986"));
//		 		int Width = RepeterShape.getSize().getWidth();
//					int Height = RepeterShape.getSize().getHeight();  
//					//System.out.println("RepetershapeActual change width"+Width);
//					//System.out.println("RepetershapeActual change width"+Height);
//					Assert.assertEquals(Width, 270);     
//					Assert.assertEquals(Height, 186);
//					Thread.sleep(5000);
//	 	}
//	 	@Test(priority =9)
//	 	public void LineVerification() throws InterruptedException {
//	 		WebElement ShapeLine =	driver.findElement(By.xpath("//div[@id='page1-fpShape1212201915294915']"));
//	 		
//	 		
//	 		int Width2 = ShapeLine.getSize().getWidth();
//			//System.out.println(Width2);
//			
//			Assert.assertEquals(Width2, 175);     
//			Thread.sleep(3000);
//	 	
//	 	}
//	 	@Test(priority =10)
//	 	public void SignatureVerification() throws InterruptedException {
//	 		WebElement Sign =driver.findElement(By.xpath("//div[@id='page1-fpSign1212201913154755']"));
//		 	String borderwidth = 	Sign.getCssValue("border-width");	
//		 	Assert.assertEquals(borderwidth, "5px");     
//
//		 	Thread.sleep(5000);
//
//	 	}
//	 	
//	 	@Test(priority=11)
//	 	public void AddNewSectionandVerifyRepeater() throws InterruptedException {
//			SoftAssert softAssertion= new SoftAssert();
//
//	 	WebElement AddSectionButton = driver.findElement(By.xpath("//button[@class='btn add-sect-btn template-add-sec']//i[@class='fa fa-plus-circle']"));
//	 	AddSectionButton.click();
//	 	Thread.sleep(4000);
//	 	WebElement AddSection =driver.findElement(By.xpath("//div[@class='create-prop-temp-box']//img"));
//	 	AddSection.click();
//	 	Thread.sleep(2000);
//
//	 	WebElement SectionName = driver.findElement(By.name("name"));
//	 	SectionName.sendKeys("SectionAddedIntoTheRepeter");
//	 	Thread.sleep(2000);
//	 	WebElement SaveBtn = driver.findElement(By.xpath("//button[@class='btn save-btn']"));
//	 	SaveBtn.click();
//	 	Thread.sleep(4000);
//	 	WebElement ClosedSectionLibraryWindow = driver.findElement(By.xpath("//img[@class='img-fluid close-section-library']"));
//	 	ClosedSectionLibraryWindow.click(); 
//	 	Thread.sleep(4000);
//
//	 	WebElement ThridSection = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[3]"));
//	 	ThridSection.click();
//	 	Thread.sleep(4000);
//
//		WebElement TextFontSize = driver.findElement(By.xpath("//p[@class='fpHeading1'][contains(text(),'Freshproposals')]"));
//		//div[starts-with(@id,"page1-fpSign")]
// 		String fontsize1 =TextFontSize.getCssValue("font-size");
// 		//System.out.println(str);
// 		softAssertion.assertEquals(fontsize1, "36px");
// 		TextFontSize.click();
// 		Thread.sleep(2000);
// 		List <WebElement> RepeterSign =driver.findElements(By.xpath("//div[starts-with(@id,\"page1-fpSign\")]"));
// 		int size = RepeterSign.size();
// 		System.out.println("Size of the webelement"+size);
// 		for(int i=0;i<size-1;i--) {
// 			if(i==0) {
// 		
//	 	int Width = ((WebElement) RepeterSign.get(i)).getSize().getWidth();
//		int Height = ((WebElement) RepeterSign.get(i)).getSize().getHeight();  
//		//System.out.println("Width of the signature"+Width);
//		//System.out.println("Height of the signature"+Height);
//	 	softAssertion.assertEquals(Width,240);
//	 	softAssertion.assertEquals(Height, 75);
//	 	//div[starts-with(@id,"page1-fpShape1212201910")]
//	 	
//	 	List <WebElement> RepeterShapeRect =driver.findElements(By.xpath("//div[starts-with(@id,\"page1-fpShape\")]//div[@oncontextmenu]"));
// 		int size1 = RepeterShapeRect.size();
// 		System.out.println("Size of the webelement"+size1);
// 		for(int j=0;j<size1-1;j--) {
// 			if(j==0) {
// 		
//	 	int Width1 = ((WebElement) RepeterShapeRect.get(j)).getSize().getWidth();
//		int Height1 = ((WebElement) RepeterShapeRect.get(j)).getSize().getHeight();  
//		//System.out.println("Width of the Rectangle"+Width1);
//		//System.out.println("Height of the Rectangle"+Height1);
//	 	softAssertion.assertEquals(Width1,270);
//	 	softAssertion.assertEquals(Height1,186);
// 			}
// 		}
// 		//div[@id='content']//li[3] expath of section3
// 		Actions actions = new Actions(driver);
// 		WebElement target = driver.findElement(By.xpath("//div[@id='content']//li[3]"));
// 		actions.moveToElement(target).perform();
// 		Thread.sleep(5000);
// 		WebElement dotMenu = driver.findElement(By.xpath("//div[@class='d-inline-block show dropdown']//button[@id='dropdownBasic1']//img"));
// 		//dotMenu.click();
// 		actions.moveToElement(dotMenu).perform();
// 		Thread.sleep(2000);
// 		dotMenu.click();
// 		Thread.sleep(4000);
// 		WebElement DeleteBtn = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//button[@class='dropdown-item'][contains(text(),'Delete')]"));
// 		DeleteBtn.click();
// 		Thread.sleep(4000); 		
//		softAssertion.assertAll();
//	 	}
// 		}
//	 	}
//	 	@Test(priority=11)
//	 	public void GenerateAProposal() throws InterruptedException {
//			 WebElement generateProposalBtn = driver.findElement(By.xpath("//button[@class='btn add-sect-btn']"));
//			 generateProposalBtn.click();
//			 Thread.sleep(3000);
//			 
//			 driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("seleniumProposals");
//			 Thread.sleep(3000);
//			 WebElement SubmitBtn = driver.findElement(By.xpath("//button[@class='btn save-btn']"));
//			 SubmitBtn.click();
//			 Thread.sleep(3000);
//			 WebElement ClientBtn = driver.findElement(By.xpath("//button[@class='btn btn-link pl-2']"));
//			 ClientBtn.click();
//			 WebElement checkbox = driver.findElement(By.xpath("//body//div[@class='col-lg-10 offset-lg-1']//div[@class='col-lg-10 offset-lg-1']//div[1]//div[2]//label[1]//span[1]"));
//			 checkbox.click();
//			 Thread.sleep(3000);
//			 Actions actions = new Actions(driver);
//			 actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
//			 Thread.sleep(3000);
//			 WebElement calender = driver.findElement(By.xpath("//div[@class='wizard-details-primary']//div[1]//div[1]//div[1]//button[1]//img[1]"));
//			 JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click();", calender);
//			 Thread.sleep(3000);
//			 WebElement date = driver.findElement(By.xpath("//div[contains(text(),'21')]"));
//			 	date.click();
//			 WebElement nextBtn = driver.findElement(By.xpath("//a[@class='btn save-btn-wizard mt-3']"));
//			 nextBtn.click();
//			 Thread.sleep(5000);
//	 		
//	 	}
//	 	@Test(priority=12)
//	 	public void RectangleReResize() throws InterruptedException {
//	 		//driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1242");
//	 		Thread.sleep(3000);
//	 		WebElement RHSMenuArrow = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/app-template-properties[1]/form[1]/div[1]/div[2]"));
//	         RHSMenuArrow.click();
//	 		Thread.sleep(2000);
//	 		WebElement RepeterMenu = driver.findElement(By.xpath("//p[contains(text(),'Repeater')]"));
//	 		RepeterMenu.click();
//	 		 WebElement RepeterShape =driver.findElement(By.id("page1-fpShape121220191011694"));
//		 		RepeterShape.click();
//				Thread.sleep(5000);
//				Actions builder = new Actions(driver);
//			    builder.moveToElement(RepeterShape).build().perform();
//		 		WebElement  shapeResize = driver.findElement(By.xpath("//div[@id='page1-fpShape121220191011694']//div[@id='segrip']"));
//				resize( shapeResize, -150, -75);
//				int Width = RepeterShape.getSize().getWidth();
//				int Height = RepeterShape.getSize().getHeight();  
//				//System.out.println("Shape Width"+Width);
//				//System.out.println("Shape Width"+Height);
//				Assert.assertEquals(Width, 120);     
//				Assert.assertEquals(Height, 111);
//				Thread.sleep(5000);	
//	 	}
//	 	@Test(priority=13)
//	 	public void TextPropertiesReReset() throws InterruptedException {
//	 		WebElement TextFontSize = driver.findElement(By.xpath("//div[@id='froalapage1-fpText121220199585999']//p[@class='fpHeading1'][contains(text(),'Freshproposals')]"));
//	 		String fontsize1 =TextFontSize.getCssValue("font-size");
//	 		//System.out.println(str);
//	 		Assert.assertEquals(fontsize1, "36px");
//	 		TextFontSize.click();
//	 		Thread.sleep(2000);
//	 		WebElement P4 = driver.findElement(By.xpath("//button[starts-with(@id,'paragraphStyle')]"));
//	 		P4.click();
//	 		Thread.sleep(2000);
//	 		WebElement heading1 = driver.findElement(By.xpath("//a[@class='fr-command fpHeading2']"));
//	 		heading1.click();
//	 		 Thread.sleep(2000);
//	 		WebElement TextFontSize2 = driver.findElement(By.xpath("//div[@id='froalapage1-fpText121220199585999']//p[@class='fpHeading2'][contains(text(),'Freshproposals')]"));
//	 		 String fontsize2 =TextFontSize2.getCssValue("font-size");
//	 		 Assert.assertEquals(fontsize2, "28px"); 
//	 	}
//	 	@Test(priority =14)
//
//	 	public void ImageReResize() throws InterruptedException {
//	 		
//	 		WebElement RepeaterImage = driver.findElement(By.id("page1-fpImage121220191005127"));
//	 		RepeaterImage.click();
//	 		WebElement  ImageResize = driver.findElement(By.xpath("//div[@id='page1-fpImage121220191005127']//div[@id='nwgrip']"));
//	 		resize( ImageResize, -150, -75);
//				int Width1 = RepeaterImage.getSize().getWidth();
//				int Height1 = RepeaterImage.getSize().getHeight();  
//				//System.out.println("ImageAfterREResize "+Width1);
//				//System.out.println("ImageAfterREREsize"+Height1);
//				Assert.assertEquals(Width1, 279);     
//				Assert.assertEquals(Height1, 187);
//	 		Thread.sleep(5000);
//	 	}
//	 	@Test(priority =15)
//	 	public void LineReresize() throws InterruptedException {
//	 		WebElement ShapeLine =	driver.findElement(By.xpath("//div[@id='page1-fpShape121220191042817']"));
//	 		ShapeLine.click();
//	 		WebElement Linelength = driver.findElement(By.xpath("//input[@name='textWidth11']"));
//	 		Linelength.clear();
//	 		Linelength.sendKeys("200");
//	 		int Widthline = ShapeLine.getSize().getWidth();
//			//System.out.println(Widthline);
//			
//			Assert.assertEquals(Widthline, 200);     
//			Thread.sleep(5000);
//
//	 	}
//	 	@Test(priority =16)
//	 	public void SignatureReReset() throws InterruptedException {
//	 		WebElement Sign =driver.findElement(By.xpath("//div[@id='page1-fpSign1212201913154755']"));
//		 	Sign.click();
//		 	Thread.sleep(2000);
//		 	WebElement ApplyBorderCheckbox = driver.findElement(By.xpath("//div[@class='card text-box-prop']/div[@class='card-body properties-box']/div[@class='row']/div[7]/div[1]/input[1]"));
//		 	ApplyBorderCheckbox.click();
//		 	Thread.sleep(3000);
//		 	ApplyBorderCheckbox.click();
//	 	}
//	 	@Test(priority =17)
//
//	 	public void SaveChangesAfterReReset() throws InterruptedException {
//	 		WebElement SaveBtn= driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
//	 		SaveBtn.click();
//	 		Thread.sleep(3000);
//	 		WebElement ExitRepeterModeBtn = driver.findElement(By.xpath("//div[@class='exit-styling-mode btn next-btn']"));
//	 		ExitRepeterModeBtn.click();
//	 		Thread.sleep(3000);
//		 	
//	 	}
//	 	public void resize(WebElement shapeResize, int xOffset, int yOffset) {
//			try {
//				if (shapeResize.isDisplayed()) {
//					Actions action = new Actions(driver);
//					action.clickAndHold(shapeResize).moveByOffset(xOffset, yOffset).release().build().perform();
//				} else {
//					System.out.println("Element was not displayed to drag");
//				}
//			} catch (StaleElementReferenceException e) {
//				System.out.println("Element with " + shapeResize + "is not attached to the page document "	+ e.getStackTrace());
//			} catch (NoSuchElementException e) {
//				System.out.println("Element " + shapeResize + " was not found in DOM " + e.getStackTrace());
//			} catch (Exception e) {
//				System.out.println("Unable to resize" + shapeResize+ " - "	+ e.getStackTrace());
//			}
//		}
	 		 @AfterClass
	 		  public void closeBrowser() throws InterruptedException {
	 		  quitBrowser(driver);
	 		}
}
