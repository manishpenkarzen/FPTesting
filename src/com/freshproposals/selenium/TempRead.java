package com.freshproposals.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshproposals.selenium.Common_Methods;

public class TempRead  extends Common_Methods {
	WebDriver driver;
	String unm;
	String pwd;
	 SoftAssert Assert= new SoftAssert();

	 @BeforeClass
	  public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", "E:\\FreshPraposal\\Freshproposals_Testing\\Freshproposals_Testing\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			driver.get("http://beta1.freshproposals.com");
		}
	 @Test(dataProvider = "User2", priority = 0)
	 public void SetUnmPwd(String unm, String pwd) {
      login(unm, pwd, driver);
	}
	 @Test(priority=1)
	 public void ReadTemplate() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1110");
		 //Page1
		 //In Height and Width there is a difference of 2px due to locator
		WebElement Page1Image1= driver.findElement(By.xpath("//div[@id='page1-fpImage1127201910451838mainDivTransformSafeStyle']"));
		boolean flag=Page1Image1.isDisplayed();
		Assert.assertTrue(flag);
		Point point = Page1Image1.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();
		
		Assert.assertEquals(xcord, 277);
		Assert.assertEquals(ycord, 52);
		
		int width=Page1Image1.getSize().getWidth();
		int height=Page1Image1.getSize().getHeight();
		
		Assert.assertEquals(width, 800);
		Assert.assertEquals(height, 1145);

		WebElement Page1Text1=driver.findElement(By.xpath("//div[@id='page1-fpText1127201910461165mainDivTransformSafeStyle']"));
		boolean flag1=Page1Text1.isDisplayed();
		Assert.assertTrue(flag1);
		Point point1 = Page1Text1.getLocation();
		int xcord1 = point1.getX();
		int ycord1 = point1.getY();
		
		Assert.assertEquals(xcord1, 536);
		Assert.assertEquals(ycord1, 299);
		
		int width1 =Page1Text1.getSize().getWidth();
		int height1=Page1Text1.getSize().getHeight();

		Assert.assertEquals(width1, 468);
		Assert.assertEquals(height1, 194);
		
		WebElement Page1Text2=driver.findElement(By.xpath("//div[@id='page1-fpText1127201910484153mainDivTransformSafeStyle']"));
		boolean flag2=Page1Text2.isDisplayed();
		Assert.assertTrue(flag2);
		Point point2 = Page1Text2.getLocation();
		int xcord2 = point2.getX();
		int ycord2 = point2.getY();
		
		Assert.assertEquals(xcord2, 285);
		Assert.assertEquals(ycord2, 694);
		
		int width2=Page1Text2.getSize().getWidth();
		int height2=Page1Text2.getSize().getHeight();

		Assert.assertEquals(width2, 204);
		Assert.assertEquals(height2, 93);
				
		WebElement Page1Text3=driver.findElement(By.xpath("//div[@id='page1-fpText1127201910492512mainDivTransformSafeStyle']"));
		boolean flag3=Page1Text3.isDisplayed();
		Assert.assertTrue(flag3);
		Point point3 = Page1Text3.getLocation();
		int xcord3 = point3.getX();
		int ycord3 = point3.getY();

		Assert.assertEquals(xcord3, 589);
		Assert.assertEquals(ycord3, 686);
		
		int width3=Page1Text3.getSize().getWidth();
		int height3=Page1Text3.getSize().getHeight();
		Assert.assertEquals(width3, 204);
		Assert.assertEquals(height3, 93);


		
		WebElement Page1Text4=driver.findElement(By.xpath("//div[@id='page1-fpText112720191050242mainDivTransformSafeStyle']"));
		boolean flag4=Page1Text4.isDisplayed();
		Assert.assertTrue(flag4);
		Point point4 = Page1Text4.getLocation();
		int xcord4 = point4.getX();
		int ycord4 = point4.getY();
		
		Assert.assertEquals(xcord4, 867);
		Assert.assertEquals(ycord4, 693);
		//Height and Width
		int width4=Page1Text4.getSize().getWidth();
		int height4=Page1Text4.getSize().getHeight();
		
		Assert.assertEquals(width4, 204);
		Assert.assertEquals(height4, 93);

		Assert.assertAll();
		
	 }
	@Test(priority=2)
	public void ReadTemplateCoverLetter() throws InterruptedException {
		WebElement section2=driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
		section2.click();
		Thread.sleep(10000);
		WebElement Page2Image1=driver.findElement(By.xpath("//div[@id='page1-fpImage1127201910542654mainDivTransformSafeStyle']"));
		boolean flag=Page2Image1.isDisplayed();
		Assert.assertTrue(flag);
		Point point = Page2Image1.getLocation();
		
		int xcord = point.getX();
		int ycord = point.getY();

		Assert.assertEquals(xcord, 280);
		Assert.assertEquals(ycord, 1130);
		
		int width=Page2Image1.getSize().getWidth();
		int height=Page2Image1.getSize().getHeight();
		
		Assert.assertEquals(width, 796);
		Assert.assertEquals(height, 337);
		
		WebElement Page2Text1=driver.findElement(By.xpath("//div[@id='page1-fpText1127201910553539mainDivTransformSafeStyle']"));
		boolean flag1 =Page2Text1.isDisplayed();
		Assert.assertTrue(flag1);
		Point point1 = Page2Text1.getLocation();
		int xcord1 = point1.getX();
		Assert.assertEquals(xcord1, 443);
		int ycord1 = point1.getY();
		Assert.assertEquals(ycord1, 1467);
		int width1=Page2Text1.getSize().getWidth();
		int height1=Page2Text1.getSize().getHeight();
		Assert.assertEquals(width1, 633);
		Assert.assertEquals(height1, 869);
		
		WebElement Page2Text2=driver.findElement(By.xpath("//div[@id='page1-fpText1127201910573814mainDivTransformSafeStyle']"));
		boolean flag2 =Page2Text2.isDisplayed();
		Assert.assertTrue(flag2);
		Point point2 = Page2Text2.getLocation();
		int xcord2 = point2.getX();
		Assert.assertEquals(xcord2, 256);
		int ycord2 = point2.getY();
		Assert.assertEquals(ycord2, 1431);
		int width2 =Page2Text2.getSize().getWidth();
		int height2=Page2Text2.getSize().getHeight();
		Assert.assertEquals(width2, 185);
		Assert.assertEquals(height2, 870);
		Assert.assertAll();
		
		}
		@Test(priority=3,enabled=false)
		public void ReadTemplateExecutiveSummary() throws InterruptedException {
			WebElement Section3 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[3]"));
			Section3.click();
			Thread.sleep(10000);
			WebElement Page3Image1=driver.findElement(By.xpath("//div[@id='page1-fpImage112720191163971mainDivTransformSafeStyle']"));
			boolean flag=Page3Image1.isDisplayed();
			Assert.assertTrue(flag);
			
			Point point = Page3Image1.getLocation();
			int xcord = point.getX();
			int ycord = point.getY();
			
			Assert.assertEquals(xcord, 277);
			Assert.assertEquals(ycord, 38);
			
			int width=Page3Image1.getSize().getWidth();
			int height=Page3Image1.getSize().getHeight();
			
			Assert.assertEquals(width, 798);
			Assert.assertEquals(height, 344);
			
			
			WebElement Page3Text1=driver.findElement(By.xpath("//div[@id='page1-fpText112720191183948mainDivTransformSafeStyle']"));
			boolean flag1=Page3Text1.isDisplayed();
			Assert.assertTrue(flag1);
			Point point1 = Page3Text1.getLocation();
			int xcord1 = point1.getX();
			int ycord1 = point1.getY();
			
			Assert.assertEquals(xcord1, 449);
			Assert.assertEquals(ycord1, 334);
			
			int width1=Page3Text1.getSize().getWidth();
			int height1=Page3Text1.getSize().getHeight();
			
			Assert.assertEquals(width1, 638);
			Assert.assertEquals(height1, 839);
			
			
			
			WebElement Page3Text2=driver.findElement(By.xpath("//div[@id='page1-fpText112720191127145mainDivTransformSafeStyle']"));
			boolean flag2=Page3Text2.isDisplayed();
			Assert.assertTrue(flag2);
			Point point2=Page3Text2.getLocation();
			int xcord2 = point2.getX();
			int ycord2=point2.getY();
			
			Assert.assertEquals(xcord2, 264);
			Assert.assertEquals(ycord2, 372);
			
			int width2=Page3Text2.getSize().getWidth();
			int height2=Page3Text2.getSize().getHeight();
			
			Assert.assertEquals(width2, 185);
			Assert.assertEquals(height2, 870);
			
			Assert.assertAll();
		}
//		@Test(priority=4)
//		public void ReadTemplateAboutUs() throws InterruptedException {
//			WebElement section4=driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[4]"));
//			section4.click();
//			Thread.sleep(10000);
//			WebElement Page4Image1=driver.findElement(By.xpath("//div[@id='page1-fpImage1127201911141441']//img"));
//			boolean flag=Page4Image1.isDisplayed();
//			Assert.assertTrue(flag);
//			Point point=Page4Image1.getLocation();
//			int xcord=point.getX();
//			int ycord =point.getY();
//			
//			Assert.assertEquals(xcord, 276);
//			Assert.assertEquals(ycord, 34);
//			
//			int width=Page4Image1.getSize().getWidth();
//			int height=Page4Image1.getSize().getHeight();
//			
//			Assert.assertEquals(width, 803);
//			Assert.assertEquals(height, 336);
//			
//			WebElement Page4Shape1=driver.findElement(By.xpath("//div[@id='page1-fpShape1127201914561942mainDivTransformSafeStyle']"));
//			Point point1 =Page4Shape1.getLocation();
//			int xcord1=point1.getX();
//			int ycord1 =point1.getY();
//			
//			Assert.assertEquals(xcord1, 271);
//			Assert.assertEquals(ycord1, 365);
//			
//			int width1=Page4Shape1.getSize().getWidth();
//			int height1=Page4Shape1.getSize().getHeight();
//			
//			Assert.assertEquals(width1, 161);
//			Assert.assertEquals(height1, 792);
//			
//			
//			
//			WebElement Page4Text1=driver.findElement(By.xpath("//div[@id='page1-fpText1127201911144539mainDivTransformSafeStyle']"));
//			Point point2=Page4Text1.getLocation();
//			
//			int xcord2=point2.getX();
//			int ycord2=point2.getY();
//			
//			Assert.assertEquals(xcord2, 340);
//			Assert.assertEquals(ycord2, 106);
//			
//			int width2=Page4Text1.getSize().getWidth();
//			int height2=Page4Text1.getSize().getHeight();
//			
//			Assert.assertEquals(width2, 688);
//			Assert.assertEquals(height2, 156);
//			
//			WebElement Page4Text2 =driver.findElement(By.xpath("//div[@id='page1-fpText1127201911162750mainDivTransformSafeStyle']"));
//			Point point3 =Page4Text2.getLocation();
//			int xcord3 =point3.getX();
//			int ycord3=point3.getY();
//			
//			Assert.assertEquals(xcord3, 432);
//			Assert.assertEquals(ycord3, 346);
//			
//			int width3=Page4Text2.getSize().getWidth();
//			int height3=Page4Text2.getSize().getHeight();
//			
//			Assert.assertEquals(width3, 639);
//			Assert.assertEquals(height3, 649);
//		}
//		@Test(priority=5)
//		public void ReadTemplateProjectActivity() throws InterruptedException {
//			WebElement Section5 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[5]"));
//			Section5.click();
//			Thread.sleep(10000);
//			WebElement Page5Shape1=driver.findElement(By.xpath("//div[@id='page1-fpShape1127201915513020mainDivTransformSafeStyle']"));
//			boolean flag=Page5Shape1.isDisplayed();
//			Point point = Page5Shape1.getLocation();
//			int xcord = point.getX();
//			int ycord = point.getY();
//			Assert.assertTrue(flag);
//			Assert.assertEquals(xcord, 469);
//			Assert.assertEquals(ycord, 90);
//			
//			int width=Page5Shape1.getSize().getWidth();
//			int height=Page5Shape1.getSize().getHeight();
//			
//			Assert.assertEquals(width, 402);
//			Assert.assertEquals(height, 302);
//			
//			WebElement Feetable=driver.findElement(By.xpath("//div[@class='fees-table fees-table-updated']"));
//			boolean flag1=Feetable.isDisplayed();
//			Assert.assertTrue(flag1);
//			
//			Point point1=Feetable.getLocation();
//			int xcord1= point1.getX();
//			int ycord1 = point1.getY();
//			
//			Assert.assertEquals(xcord1, 320);
//			Assert.assertEquals(ycord1, 428);
//			
//			
//			int width1=Feetable.getSize().getWidth();
//			int height1=Feetable.getSize().getHeight();
//			
//			//System.out.println(width1);
//		//	System.out.println(height1);
//			Assert.assertEquals(width1, 714);
//			Assert.assertEquals(height1,162);
//			
//			
//			
//			
//			WebElement ContentTable=driver.findElement(By.xpath("//div[@class='content-table']"));
//			boolean flag2=ContentTable.isDisplayed();
//			Assert.assertTrue(flag2);
//			Point point2=ContentTable.getLocation();
//			int xcord2= point2.getX();
//			int ycord2 = point2.getY();
//			
//			
//			Assert.assertEquals(xcord2, 329);
//			Assert.assertEquals(ycord2, 740);
//			
//			
//			int width2=ContentTable.getSize().getWidth();
//			int height2=ContentTable.getSize().getHeight();
//			//System.out.println(width2);
//			//System.out.println(height2);
//			Assert.assertEquals(width2, 714);
//			Assert.assertEquals(height2,122);
//			
//			
//			
//			WebElement Sign=driver.findElement(By.xpath("//div[@id='page1-fpSign1127201915555622mainDivTransformSafeStyle']"));
//			boolean flag3=Sign.isDisplayed();
//			Assert.assertTrue(flag3);
//			Point point3=Sign.getLocation();
//			int xcord3= point3.getX();
//			int ycord3 = point3.getY();
//			Assert.assertEquals(xcord3, 492);
//			Assert.assertEquals(ycord3, 957);
//			
//			int width3=Sign.getSize().getWidth();
//			int height3=Sign.getSize().getHeight();
//			
//			Assert.assertEquals(width3, 1202);
//			Assert.assertEquals(height3, 22);
//			
//			
//			
//			
//			WebElement line=driver.findElement(By.xpath("//div[@id='page1-fpShape112720191553482']"));
//			boolean flag4=line.isDisplayed();
//			Assert.assertTrue(flag4);
//			Point point4=line.getLocation();
//			int xcord4= point4.getX();
//			Assert.assertEquals(xcord4, 1034);
//			int ycord4 = point4.getY();
//			Assert.assertEquals(ycord4, 38);
//			int width4 =line.getSize().getWidth();
//			int height4 =line.getSize().getHeight();
//			
//			Assert.assertEquals(width4, 1202);
//			Assert.assertEquals(height4, 22);
//			
//			
//			
//		}
//		 @Test(priority=6)
//		 public void ReadTemplatePreview() throws InterruptedException {
//			 driver.get("http://beta1.freshproposals.net/home/templates/editTemplate/1110/true");
//			 Thread.sleep(10000);
//			 WebElement Page1Image1= driver.findElement(By.xpath("//div[@id='page1-fpImage1127201910451838mainDivTransformSafeStyle']"));
//				boolean flag=Page1Image1.isDisplayed();
//				Assert.assertTrue(flag);
//				Point point = Page1Image1.getLocation();
//				int xcord = point.getX();
//				int ycord = point.getY();
//				
//				Assert.assertEquals(xcord, 273);
//				Assert.assertEquals(ycord, 72);
//				
//				int width=Page1Image1.getSize().getWidth();
//				int height=Page1Image1.getSize().getHeight();
//				
//				Assert.assertEquals(width, 802);
//				Assert.assertEquals(height, 1147);
//
//				WebElement Page1Text1=driver.findElement(By.xpath("//div[@id='page1-fpText1127201910461165mainDivTransformSafeStyle']"));
//				boolean flag1=Page1Text1.isDisplayed();
//				Assert.assertTrue(flag1);
//				Point point1 = Page1Text1.getLocation();
//				int xcord1 = point1.getX();
//				int ycord1 = point1.getY();
//				
//				Assert.assertEquals(xcord1, 532);
//				Assert.assertEquals(ycord1, 319);
//				
//				int width1 =Page1Text1.getSize().getWidth();
//				int height1=Page1Text1.getSize().getHeight();
//
//				Assert.assertEquals(width1, 468);
//				Assert.assertEquals(height1, 194);
//				
//				WebElement Page1Text2=driver.findElement(By.xpath("//div[@id='page1-fpText1127201910484153mainDivTransformSafeStyle']"));
//				boolean flag2=Page1Text2.isDisplayed();
//				Assert.assertTrue(flag2);
//				Point point2 = Page1Text2.getLocation();
//				int xcord2 = point2.getX();
//				int ycord2 = point2.getY();
//				
//				Assert.assertEquals(xcord2, 282);
//				Assert.assertEquals(ycord2, 714);
//				
//				int width2=Page1Text2.getSize().getWidth();
//				int height2=Page1Text2.getSize().getHeight();
//
//				Assert.assertEquals(width2, 204);
//				Assert.assertEquals(height2, 95);
//						
//				WebElement Page1Text3=driver.findElement(By.xpath("//div[@id='page1-fpText1127201910492512mainDivTransformSafeStyle']"));
//				boolean flag3=Page1Text3.isDisplayed();
//				Assert.assertTrue(flag3);
//				Point point3 = Page1Text3.getLocation();
//				int xcord3 = point3.getX();
//				int ycord3 = point3.getY();
//
//				Assert.assertEquals(xcord3, 584);
//				Assert.assertEquals(ycord3, 706);
//				
//				int width3=Page1Text3.getSize().getWidth();
//				int height3=Page1Text3.getSize().getHeight();
//				Assert.assertEquals(width3, 204);
//				Assert.assertEquals(height3, 95);
//
//
//				
//				WebElement Page1Text4=driver.findElement(By.xpath("//div[@id='page1-fpText112720191050242mainDivTransformSafeStyle']"));
//				boolean flag4=Page1Text4.isDisplayed();
//				Assert.assertTrue(flag4);
//				Point point4 = Page1Text4.getLocation();
//				int xcord4 = point4.getX();
//				int ycord4 = point4.getY();
//				
//				Assert.assertEquals(xcord4, 863);
//				Assert.assertEquals(ycord4, 713);
//				//Height and Width
//				int width4=Page1Text4.getSize().getWidth();
//				int height4=Page1Text4.getSize().getHeight();
//				
//				Assert.assertEquals(width4, 204);
//				Assert.assertEquals(height4, 95);
//
//				
//		 }
//		 @Test(priority=7)
//			public void ReadTemplateCoverLetterPreview() throws InterruptedException {
//			 WebElement section2=driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[2]"));
//				section2.click();
//				Thread.sleep(10000);
//				WebElement Page2Image1=driver.findElement(By.xpath("//div[@id='page1-fpImage1127201910542654mainDivTransformSafeStyle']"));
//				boolean flag=Page2Image1.isDisplayed();
//				Assert.assertTrue(flag);
//				Point point = Page2Image1.getLocation();
//				
//				int xcord = point.getX();
//				int ycord = point.getY();
//
//				Assert.assertEquals(xcord, 276);
//				Assert.assertEquals(ycord, -2);
//				
//				int width=Page2Image1.getSize().getWidth();
//				int height=Page2Image1.getSize().getHeight();
//				
//				Assert.assertEquals(width, 798);
//				Assert.assertEquals(height, 339);
//				
//				WebElement Page2Text1=driver.findElement(By.xpath("//div[@id='page1-fpText1127201910553539mainDivTransformSafeStyle']"));
//				boolean flag1 =Page2Text1.isDisplayed();
//				Assert.assertTrue(flag1);
//				Point point1 = Page2Text1.getLocation();
//				int xcord1 = point1.getX();
//				Assert.assertEquals(xcord1, 439);
//				int ycord1 = point1.getY();
//				Assert.assertEquals(ycord1, 334);
//				int width1=Page2Text1.getSize().getWidth();
//				int height1=Page2Text1.getSize().getHeight();
//				Assert.assertEquals(width1, 633);
//				Assert.assertEquals(height1, 869);
//				
//				WebElement Page2Text2=driver.findElement(By.xpath("//div[@id='page1-fpText1127201910573814mainDivTransformSafeStyle']"));
//				boolean flag2 =Page2Text2.isDisplayed();
//				Assert.assertTrue(flag2);
//				Point point2 = Page2Text2.getLocation();
//				int xcord2 = point2.getX();
//				Assert.assertEquals(xcord2, 439);
//				int ycord2 = point2.getY();
//				Assert.assertEquals(ycord2, 334);
//				int width2 =Page2Text2.getSize().getWidth();
//				int height2=Page2Text2.getSize().getHeight();
//				Assert.assertEquals(width2, 185);
//				Assert.assertEquals(height2, 870);
//				
//				}
//		 @Test(priority=8)
//			public void ReadTemplateExecutiveSummaryPreview() throws InterruptedException {
//			 WebElement Section3 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[3]"));
//				Section3.click();
//				Thread.sleep(10000);
//				WebElement Page3Image1=driver.findElement(By.xpath("//div[@id='page1-fpImage112720191163971mainDivTransformSafeStyle']"));
//				boolean flag=Page3Image1.isDisplayed();
//				Assert.assertTrue(flag);
//				
//				Point point = Page3Image1.getLocation();
//				int xcord = point.getX();
//				int ycord = point.getY();
//				
//				Assert.assertEquals(xcord, 277);
//				Assert.assertEquals(ycord, 38);
//				
//				int width=Page3Image1.getSize().getWidth();
//				int height=Page3Image1.getSize().getHeight();
//				
//				Assert.assertEquals(width, 798);
//				Assert.assertEquals(height, 344);
//				
//				
//				WebElement Page3Text1=driver.findElement(By.xpath("//div[@id='page1-fpText112720191183948mainDivTransformSafeStyle']"));
//				boolean flag1=Page3Text1.isDisplayed();
//				Assert.assertTrue(flag1);
//				Point point1 = Page3Text1.getLocation();
//				int xcord1 = point1.getX();
//				int ycord1 = point1.getY();
//				
//				Assert.assertEquals(xcord1, 449);
//				Assert.assertEquals(ycord1, 334);
//				
//				int width1=Page3Text1.getSize().getWidth();
//				int height1=Page3Text1.getSize().getHeight();
//				
//				Assert.assertEquals(width1, 638);
//				Assert.assertEquals(height1, 839);
//				
//				
//				
//				WebElement Page3Text2=driver.findElement(By.xpath("//div[@id='page1-fpText112720191127145mainDivTransformSafeStyle']"));
//				boolean flag2=Page3Text2.isDisplayed();
//				Assert.assertTrue(flag2);
//				Point point2=Page3Text2.getLocation();
//				int xcord2 = point2.getX();
//				int ycord2=point2.getY();
//				
//				Assert.assertEquals(xcord2, 264);
//				Assert.assertEquals(ycord2, 372);
//				
//				int width2=Page3Text2.getSize().getWidth();
//				int height2=Page3Text2.getSize().getHeight();
//				
//				Assert.assertEquals(width2, 185);
//				Assert.assertEquals(height2, 870);
//			}
//			@Test(priority=9)
//			public void ReadTemplateAboutUsPreview() throws InterruptedException {
//				WebElement section4=driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[4]"));
//				section4.click();
//				Thread.sleep(10000);
//				WebElement Page4Image1=driver.findElement(By.xpath("//div[@id='page1-fpImage1127201911141441']//img"));
//				boolean flag=Page4Image1.isDisplayed();
//				Assert.assertTrue(flag);
//				Point point=Page4Image1.getLocation();
//				int xcord=point.getX();
//				int ycord =point.getY();
//				
//				Assert.assertEquals(xcord, 276);
//				Assert.assertEquals(ycord, 34);
//				
//				int width=Page4Image1.getSize().getWidth();
//				int height=Page4Image1.getSize().getHeight();
//				
//				Assert.assertEquals(width, 803);
//				Assert.assertEquals(height, 336);
//				
//				WebElement Page4Shape1=driver.findElement(By.xpath("//div[@id='page1-fpShape1127201914561942mainDivTransformSafeStyle']"));
//				Point point1 =Page4Shape1.getLocation();
//				int xcord1=point1.getX();
//				int ycord1 =point1.getY();
//				
//				Assert.assertEquals(xcord1, 271);
//				Assert.assertEquals(ycord1, 365);
//				
//				int width1=Page4Shape1.getSize().getWidth();
//				int height1=Page4Shape1.getSize().getHeight();
//				
//				Assert.assertEquals(width1, 161);
//				Assert.assertEquals(height1, 792);
//				
//				
//				
//				WebElement Page4Text1=driver.findElement(By.xpath("//div[@id='page1-fpText1127201911144539mainDivTransformSafeStyle']"));
//				Point point2=Page4Text1.getLocation();
//				
//				int xcord2=point2.getX();
//				int ycord2=point2.getY();
//				
//				Assert.assertEquals(xcord2, 340);
//				Assert.assertEquals(ycord2, 106);
//				
//				int width2=Page4Text1.getSize().getWidth();
//				int height2=Page4Text1.getSize().getHeight();
//				
//				Assert.assertEquals(width2, 688);
//				Assert.assertEquals(height2, 156);
//				
//				WebElement Page4Text2 =driver.findElement(By.xpath("//div[@id='page1-fpText1127201911162750mainDivTransformSafeStyle']"));
//				Point point3 =Page4Text2.getLocation();
//				int xcord3 =point3.getX();
//				int ycord3=point3.getY();
//				
//				Assert.assertEquals(xcord3, 432);
//				Assert.assertEquals(ycord3, 346);
//				
//				int width3=Page4Text2.getSize().getWidth();
//				int height3=Page4Text2.getSize().getHeight();
//				
//				Assert.assertEquals(width3, 639);
//				Assert.assertEquals(height3, 649);
//				
//			}
//			@Test(priority=10)
//			public void ReadTemplateProjectActivityPreview() throws InterruptedException {
//				WebElement Section5 = driver.findElement(By.xpath("//div[@class='col-lg-2 p-0 fixed-sidebar']//li[5]"));
//				Section5.click();
//				Thread.sleep(10000);
//				WebElement Page5Shape1=driver.findElement(By.xpath("//div[@id='page1-fpShape1127201915513020mainDivTransformSafeStyle']"));
//				boolean flag=Page5Shape1.isDisplayed();
//				Point point = Page5Shape1.getLocation();
//				int xcord = point.getX();
//				int ycord = point.getY();
//				Assert.assertTrue(flag);
//				Assert.assertEquals(xcord, 469);
//				Assert.assertEquals(ycord, 90);
//				
//				int width=Page5Shape1.getSize().getWidth();
//				int height=Page5Shape1.getSize().getHeight();
//				
//				Assert.assertEquals(width, 402);
//				Assert.assertEquals(height, 302);
//				
//				WebElement Feetable=driver.findElement(By.xpath("//div[@class='fees-table fees-table-updated']"));
//				boolean flag1=Feetable.isDisplayed();
//				Assert.assertTrue(flag1);
//				
//				Point point1=Feetable.getLocation();
//				int xcord1= point1.getX();
//				int ycord1 = point1.getY();
//				
//				Assert.assertEquals(xcord1, 320);
//				Assert.assertEquals(ycord1, 428);
//				
//				
//				int width1=Feetable.getSize().getWidth();
//				int height1=Feetable.getSize().getHeight();
//				Assert.assertEquals(width1, 714);
//				Assert.assertEquals(height1,162);
//				
//				WebElement ContentTable=driver.findElement(By.xpath("//div[@class='content-table']"));
//				boolean flag2=ContentTable.isDisplayed();
//				Assert.assertTrue(flag2);
//				Point point2=ContentTable.getLocation();
//				int xcord2= point2.getX();
//				Assert.assertEquals(xcord2, 329);
//				int ycord2 = point2.getY();
//				Assert.assertEquals(ycord2, 740);
//				
//				int width2=ContentTable.getSize().getWidth();
//				int height2=ContentTable.getSize().getHeight();
//				//System.out.println(width2);
//				//System.out.println(height2);
//				Assert.assertEquals(width2, 714);
//				Assert.assertEquals(height2,122);
//				
//				WebElement Sign=driver.findElement(By.xpath("//div[@id='page1-fpSign1127201915555622mainDivTransformSafeStyle']"));
//				boolean flag3=Sign.isDisplayed();
//				Assert.assertTrue(flag3);
//				Point point3=Sign.getLocation();
//				int xcord3= point3.getX();
//				int ycord3 = point3.getY();
//				Assert.assertEquals(xcord3, 492);
//				Assert.assertEquals(ycord3, 957);
//				
//				int width3=Sign.getSize().getWidth();
//				int height3=Sign.getSize().getHeight();
//				
//				Assert.assertEquals(width3, 1202);
//				Assert.assertEquals(height3, 22);
//				
//				WebElement line=driver.findElement(By.xpath("//div[@id='page1-fpShape112720191553482']"));
//				boolean flag4=line.isDisplayed();
//				Assert.assertTrue(flag4);
//				Point point4=line.getLocation();
//				int xcord4= point4.getX();
//				Assert.assertEquals(xcord4, 1034);
//				int ycord4 = point4.getY();
//				Assert.assertEquals(ycord4, 38);
//				int width4 =line.getSize().getWidth();
//				int height4 =line.getSize().getHeight();
//				
//				Assert.assertEquals(width4, 1202);
//				Assert.assertEquals(height4, 22);
//				
//				
//				
//			}
//		 
//		
		
		
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}
}
