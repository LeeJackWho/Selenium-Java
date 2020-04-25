package com.selenium.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.selenium.study.TestfanTests;
import com.selenium.study.Utils;

//import io.qameta.allure.Allure;
//import io.qameta.allure.Attachment;
//import io.qameta.allure.Feature;
//import io.qameta.allure.Step;


//@Feature("testfan≤‚ ‘”√¿˝")
public class TestfanTestCases {
	WebDriver driver;
	TestfanTests testfan;
	//List<String> repositories_names=new ArrayList<String>();
	@BeforeClass
	public void initDriver() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ask.testfan.cn/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		testfan=new TestfanTests(driver);
	}
	@BeforeMethod
	public void homepage() {
		//driver.get("http://ask.testfan.cn/");
	}
	@Test
	//@Attachment
	public void test001_login() throws Exception {
		try {
			testfan.login();
			Boolean flag=Utils.elementIsExist(driver, By.cssSelector("#unread_messages"));
			Assert.assertTrue(flag);
		} catch (Exception |Error e) {
			// TODO: handle exception
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("images/testfanloginfailure.png"));
			Reporter.log("<a href=../images/testfanloginfailure.png target=_blank> ß∞‹ΩÿÕº</a>", true);  
			Reporter.log("<img src=../images/testfanloginfailure.png style=width:30px;height:30px img/>", true);
			Assert.fail(e.getMessage());
		}
		
	}
	@Test(dependsOnMethods = "test001_login")
	//@Attachment
	public void test002_changePersonInfo() throws Exception {
		
		try {
			testfan.changePersonInfo();
		} catch (Exception |Error e) {
			// TODO: handle exception
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("images/changefailure.png"));
			Reporter.log("<a href=../images/changefailure.png target=_blank> ß∞‹ΩÿÕº</a>", true);  
			Reporter.log("<img src=../images/changefailure.png style=width:30px;height:30px img/>", true);
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(dependsOnMethods = "test001_login")
	//@Attachment
	public void test003_comment() throws Exception {
		//byte[] screenshotAs = null;
		try {
			testfan.comment();
		} catch (Exception |Error e) {
//			// TODO: handle exception
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("images/commentfailure.png"));
//			screenshotAs= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
////			Reporter.log("<a href=../images/commentfailure.png target=_blank> ß∞‹ΩÿÕº</a>", true);  
////			Reporter.log("<img src=../images/commentfailure.png style=width:30px;height:30px img/>", true);
//			Allure.addAttachment(" ß∞‹ΩÿÕº", "image/png", new FileInputStream(new File("images/commentfailure.png")),".png");
			Assert.fail(e.getMessage());
		}
		//return screenshotAs;
	}
	@AfterClass
	public void quit() {
		driver.quit();
	}

}
