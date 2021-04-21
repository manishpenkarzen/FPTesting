package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshproposals.selenium.Common_Methods;

public class RectangleandLinePropertiesInTemplate extends Common_Methods{
	SoftAssert softAssertion= new SoftAssert();

	WebDriver driver;
	String unm;
	String pwd;

	String width ="491";
	String height ="567";

	
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
	
//	 @Test(priority =4)
//	 public void ChangeRectangleWidthandHeight() throws InterruptedException {
//		driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1250");
//		Thread.sleep(3000);
//		WebElement Shape = driver.findElement(By.id("page1-fpShape1213201912522970"));
//		Thread.sleep(2000);
//		Shape.click();
//		WebElement RectangleShapeWidth = driver.findElement(By.xpath("//input[@name='textWidth11']"));
//		RectangleShapeWidth.clear();
//		Thread.sleep(2000);
//		RectangleShapeWidth.sendKeys(width);
//		WebElement RectangleShapeHeight = driver.findElement(By.xpath("//input[@name='height11']"));
//		RectangleShapeHeight.clear();
//		Thread.sleep(2000);
//		RectangleShapeHeight.sendKeys(height);
//		Actions dragger = new Actions(driver);
//		WebElement draggablePartOfScrollbar = driver.findElement(By.name("opacity"));
//		int numberOfPixelsToDragTheScrollbarDown = -45;
//		
//		dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
//		Thread.sleep(5000);
//		
//		WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
//		 SaveBtn.click();
//			Thread.sleep(3000);
//
//		this.VerifyHeightandWidth();
//	 }
//	 public void VerifyHeightandWidth() throws InterruptedException {
//		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1250");
//			Thread.sleep(3000);
//			WebElement Shape = driver.findElement(By.id("page1-fpShape1213201912522970"));
//			Thread.sleep(2000);
//			Shape.click();
//			int  width1=Shape.getSize().getWidth();
//			int height1=Shape.getSize().getHeight();
//			softAssertion.assertEquals(width1,491);
//			softAssertion.assertEquals(height1,567);	 
//		 this.ResetHeightandWidth();
//		 
//		 softAssertion.assertAll();
//	 }
//	 public void ResetHeightandWidth() throws InterruptedException {
//			Thread.sleep(3000);
//			WebElement Shape = driver.findElement(By.id("page1-fpShape1213201912522970"));
//			Thread.sleep(2000);
//			Shape.click();
//			WebElement RectangleShapeWidth = driver.findElement(By.xpath("//input[@name='textWidth11']"));
//			RectangleShapeWidth.clear();
//			Thread.sleep(2000);
//			RectangleShapeWidth.sendKeys("250");
//			WebElement RectangleShapeHeight = driver.findElement(By.xpath("//input[@name='height11']"));
//			RectangleShapeHeight.clear();
//			Thread.sleep(1000);
//			RectangleShapeHeight.sendKeys("400");
//			Thread.sleep(1000);
//			Actions dragger = new Actions(driver);
//			WebElement draggablePartOfScrollbar = driver.findElement(By.name("opacity"));
//			int numberOfPixelsToDragTheScrollbarDown = 100;
//			dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(numberOfPixelsToDragTheScrollbarDown,0).release().perform();
//			Thread.sleep(5000);
//			WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
//			SaveBtn.click();
//			Thread.sleep(5000);
//			
//			driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1250");
//			Thread.sleep(3000);
//			WebElement RectangleShape = driver.findElement(By.id("page1-fpShape1213201912522970"));
//			Thread.sleep(2000);
//		  int width=RectangleShape.getSize().getWidth();
//		  int height=RectangleShape.getSize().getHeight();
//		  softAssertion.assertEquals(width, 250);
//		  softAssertion.assertEquals(height, 400);
//		 
//	 }
	 @Test(priority=3)
	 public void LineProperties() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1250");
		Thread.sleep(3000);
		WebElement Section2 = driver.findElement(By.xpath("//a[contains(text(),'Section2Line')]"));
		Section2.click();
		Thread.sleep(2000);
		WebElement Line = driver.findElement(By.xpath("//div[@id='page1-fpShape1214201914374145']"));
		Line.click();
		Thread.sleep(2000);
		WebElement Length = driver.findElement(By.xpath("//input[@name='textWidth11']"));
		Length.clear();
		Thread.sleep(2000);
		Length.sendKeys("367");
		Thread.sleep(2000);

		int width=Line.getSize().getWidth();
		System.out.println(width);
		WebElement RotateBox = driver.findElement(By.xpath("//input[@name='rotate']"));
		RotateBox.clear();
		Thread.sleep(2000);
		RotateBox.sendKeys("321");
		Thread.sleep(2000);
		WebElement LineBorderWidth = driver.findElement(By.xpath("//input[@name='borderWidth']"));
		LineBorderWidth.clear();
		Thread.sleep(2000);
		LineBorderWidth.sendKeys("20");
		Thread.sleep(2000);
		Select dropdown = new Select(driver.findElement(By.name("borderStyle")));
		dropdown.selectByIndex(4);
		Thread.sleep(1000);
		WebElement LineBorder = driver.findElement(By.xpath("//div[@id='section_section6499']//div[9]//div[1]"));
			//String LineBorderStyle=LineBorder.getCssValue("border-top");
			//System.out.println("LineBorderStyle"+LineBorderStyle);
			//WebElement LineBorder = driver.findElement(By.xpath("//div[@id='section_section6499']//div[9]//div[1]"));
			
		WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		SaveBtn.click();
		Thread.sleep(3000);
		this.verifyLineProperties();
		this.ResetLineProperties();
	 }
	 public void verifyLineProperties() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1250");
			Thread.sleep(3000);
		 WebElement Section2 = driver.findElement(By.xpath("//a[contains(text(),'Section2Line')]"));
			Section2.click();
			Thread.sleep(2000);
			WebElement Line = driver.findElement(By.xpath("//div[@id='page1-fpShape1214201914374145']"));
			Line.click();
			Thread.sleep(2000);
			//WebElement Length = driver.findElement(By.xpath("//input[@name='textWidth11']"));
			int width=Line.getSize().getWidth();
			softAssertion.assertEquals(width, 367);
			String Rotation = Line.getCssValue("transform");
			softAssertion.assertEquals(Rotation,"matrix(0.777146, -0.62932, 0.62932, 0.777146, 0, 0)");
			//System.out.println(Rotation);
			int Height=Line.getSize().getHeight();
			softAssertion.assertEquals(Height, 20);
			WebElement LineBorder = driver.findElement(By.xpath("//div[@id='page1-fpShape1214201914374145mainDivTransformSafeStyle']/div[@id='page1-fpShape1214201914374145']/div[@class='resizers']/div[1]/div[1]"));
			String LineBorderStyle=LineBorder.getCssValue("border-top-style");
			//System.out.println("LineBorderStyle"+LineBorderStyle);
			softAssertion.assertEquals(LineBorderStyle, "groove");
//			if(LineBorderStyle.contains("groove")) {
//				softAssertion.assertTrue(true);
//			}
		 
	 }
	 public void ResetLineProperties() throws InterruptedException {
			WebElement Line = driver.findElement(By.xpath("//div[@id='page1-fpShape1214201914374145']"));
			Line.click();
			Thread.sleep(2000);
			WebElement Length = driver.findElement(By.xpath("//input[@name='textWidth11']"));
			Length.clear();
			Thread.sleep(2000);
			Length.sendKeys("200");
			Thread.sleep(2000);

			int width=Line.getSize().getWidth();
			//System.out.println(width);
			softAssertion.assertEquals(width, 200);
			WebElement RotateBox = driver.findElement(By.xpath("//input[@name='rotate']"));
			RotateBox.clear();
			Thread.sleep(2000);
			RotateBox.sendKeys("0");
			Thread.sleep(2000);

			String Rotation = Line.getCssValue("transform");
			softAssertion.assertEquals(Rotation,"matrix(1, 0, 0, 1, 0, 0)");
			//System.out.println(Rotation);
		
			WebElement LineBorderWidth = driver.findElement(By.xpath("//input[@name='borderWidth']"));
			LineBorderWidth.clear();
			Thread.sleep(2000);
			LineBorderWidth.sendKeys("1");
			Thread.sleep(2000);
			Select dropdown = new Select(driver.findElement(By.name("borderStyle")));
			dropdown.selectByIndex(2);
			Thread.sleep(1000);
			WebElement LineBorder = driver.findElement(By.xpath("//div[@id='page1-fpShape1214201914374145mainDivTransformSafeStyle']/div[@id='page1-fpShape1214201914374145']/div[@class='resizers']/div[1]/div[1]"));
			String LineBorderStyle=LineBorder.getCssValue("border-top-style");
			//System.out.println("LineBorderStyle"+LineBorderStyle);
			softAssertion.assertEquals(LineBorderStyle, "solid");
//			if(LineBorderStyle.contains("solid")) {
//				softAssertion.assertTrue(true);
//			}
		 
			
			
		String str=	LineBorderWidth.getCssValue("border-top-width");
		//System.out.println(str);
		softAssertion.assertEquals(str, "1px");	
		WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
		SaveBtn.click();
		Thread.sleep(3000);
	 }
	 
	 @Test(priority=1)
	 public void BackgroundColorandGradient() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1250");
			Thread.sleep(3000);
			WebElement Shape = driver.findElement(By.id("page1-fpShape1213201912522970"));
			Thread.sleep(2000);
			Shape.click();
			WebElement Section3 = driver.findElement(By.xpath("//a[contains(text(),'New1')]"));
			Section3.click();
			Thread.sleep(2000);
			WebElement textbox = driver.findElement(By.xpath("v/div[@class='section-editor-box']/div[@id='scrollContainer']/div[@class='page-scalemargin-']/div[@id='section_section6857']/div[@id='section6857']/app-sections-page/a[@name='page1']/div[@class='page-wrapper']/div[@class='page effect8']/div[@id='sectionPage_6857page1']/app-fpshape/div[@class='text-element shape-element']/div[@id='page1-fpShape123020191702710mainDivTransformSafeStyle']/div[@id='page1-fpShape123020191702710']/div[@class='resizers']/div[1]/div[1]"));
			textbox.click();
			Thread.sleep(2000);
			WebElement  BackgroundColor = driver.findElement(By.xpath("//span[@class='e-btn-icon e-icons e-caret']"));
			BackgroundColor.click();
			Thread.sleep(2000);
			WebElement ColorCode = driver.findElement(By.xpath("//input[@class='e-hex']"));
			ColorCode.clear();
			ColorCode.sendKeys("#3bece0");
			Thread.sleep(2000);
			WebElement ApplyBtn = driver.findElement(By.xpath("//button[@class='e-btn e-css e-flat e-primary e-small e-apply']"));
			ApplyBtn.click();
			String BackColor = textbox.getCssValue("background").replace("none repeat scroll 0% 0% / auto padding-box border-box", "");
			System.out.println("Background color is"+BackColor);
			String actual = Color.fromString(BackColor).asHex();
			//System.out.println(actual);
			softAssertion.assertEquals(actual, "#3bece0");
				WebElement Gradient = driver.findElement(By.xpath("//div[@class='form-group form-check gradient-label']//input[@name='gradient']"));
				Gradient.click();
				Thread.sleep(2000);
			
					WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
					SaveBtn.click();
					Thread.sleep(3000);
					WebElement BackBtn =driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
					BackBtn.click();
					Thread.sleep(3000);
					this.VerifyBackgroundColorandGradient();
					this.ResetBackgroundColorandGradient();
					softAssertion.assertAll();
	 }
	 public void VerifyBackgroundColorandGradient() throws InterruptedException {
		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1250");
			Thread.sleep(3000);
			WebElement Section3 = driver.findElement(By.xpath("//a[contains(text(),'New1')]"));
			Section3.click();
			Thread.sleep(2000);
			WebElement textbox = driver.findElement(By.xpath("//body/app-root/app-home/div[@class='wrapper']/div[@id='content']/div[@class='apply-hidden styling-mode-effect']/app-edit-template/div[@class='editor-box template-editor']/div[@class='row']/div[@class='col-lg-8 offset-lg-2']/div[@id='scrollContainer']/div[@id='contentToConvert']/app-edit-section/div/div[@class='section-editor-box']/div[@id='scrollContainer']/div[@class='page-scalemargin-']/div[@id='section_section6857']/div[@id='section6857']/app-sections-page/a[@name='page1']/div[@class='page-wrapper']/div[@class='page effect8']/div[@id='sectionPage_6857page1']/app-fpshape/div[@class='text-element shape-element']/div[@id='page1-fpShape123020191702710mainDivTransformSafeStyle']/div[@id='page1-fpShape123020191702710']/div[@class='resizers']/div[1]/div[1]"));
			textbox.click();
			Thread.sleep(2000);
			String grad = textbox.getCssValue("background").replace("repeat scroll 0% 0% / auto padding-box border-box", "");
			System.out.println(grad);
			Thread.sleep(5000);
			softAssertion.assertEquals(grad, "rgba(0, 0, 0, 0) linear-gradient(rgb(59, 236, 224) 0%, rgb(32, 117, 171) 100%) ");
			Thread.sleep(5000);
	 }
	 public void ResetBackgroundColorandGradient() throws InterruptedException {
		 WebElement textbox = driver.findElement(By.xpath("//body/app-root/app-home/div[@class='wrapper']/div[@id='content']/div[@class='apply-hidden styling-mode-effect']/app-edit-template/div[@class='editor-box template-editor']/div[@class='row']/div[@class='col-lg-8 offset-lg-2']/div[@id='scrollContainer']/div[@id='contentToConvert']/app-edit-section/div/div[@class='section-editor-box']/div[@id='scrollContainer']/div[@class='page-scalemargin-']/div[@id='section_section6857']/div[@id='section6857']/app-sections-page/a[@name='page1']/div[@class='page-wrapper']/div[@class='page effect8']/div[@id='sectionPage_6857page1']/app-fpshape/div[@class='text-element shape-element']/div[@id='page1-fpShape123020191702710mainDivTransformSafeStyle']/div[@id='page1-fpShape123020191702710']/div[@class='resizers']/div[1]/div[1]"));
			textbox.click();
			Thread.sleep(2000);
			WebElement Gradient = driver.findElement(By.xpath("//div[@class='form-group form-check gradient-label']//input[@name='gradient']"));
			Gradient.click();
			Thread.sleep(5000);
			WebElement  BackgroundColor = driver.findElement(By.xpath("//span[@class='e-btn-icon e-icons e-caret']"));
			BackgroundColor.click();
			Thread.sleep(2000);
			WebElement ColorCode = driver.findElement(By.xpath("//input[@class='e-hex']"));
			ColorCode.clear();
			ColorCode.sendKeys("#86263c");
			Thread.sleep(2000);
			WebElement ApplyBtn = driver.findElement(By.xpath("//button[@class='e-btn e-css e-flat e-primary e-small e-apply']"));
			ApplyBtn.click();
			String BackColor = textbox.getCssValue("background").replace("none repeat scroll 0% 0% / auto padding-box border-box", "");
			
			String actual = Color.fromString(BackColor).asHex();
			//System.out.println(actual);
			softAssertion.assertEquals(actual, "#86263c");
			WebElement SaveBtn = driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn send-btn'][contains(text(),'Save')]"));
			SaveBtn.click();
			Thread.sleep(3000);
			WebElement BackBtn =driver.findElement(By.xpath("//ul[@class='nav']//button[@class='nav-link btn back-btn'][contains(text(),'Back')]"));
			BackBtn.click();
			Thread.sleep(3000);
	 }
	 
	 
	 
	 
	 @AfterClass
	 public void teardown() {
		 driver.quit();
	 }
	 

}
