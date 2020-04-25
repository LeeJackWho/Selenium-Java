package com.bs.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class LinkTest {
	@Test(description = "链接测试")
	@Description("链接测试测试用例")
	public void linkTest() throws Exception{
		//准备工作
		ChromeDriver driver = init();
		//链接操作
		Link(driver);
		//销毁工作
		finish(driver);
	}
	
	@Step("链接操作")
	public static void Link(ChromeDriver driver) throws Exception {
		driver.get("http://localhost:9000/jenkins/");
		WebElement AddItemLink = driver.findElement(By.className("task-link"));
		AddItemLink.click();
		String ExpectAddItemUrl = "http://localhost:9000/jenkins/view/all/newJob";
		String currentUrl = driver.getCurrentUrl();
		//判断新建Item的链接是否跳转正确
		Assert.assertEquals(ExpectAddItemUrl.equals(currentUrl), true);
		//登录页面的注册跳转链接
		driver.get("http://localhost:9000/jenkins/login");
		WebElement RegisterLink = driver.findElement(By.linkText("创建一个用户账号"));
		RegisterLink.click();
		String ExpectRegisterUrl = "http://localhost:9000/jenkins/signup";
		String currentUrl1 = driver.getCurrentUrl();
		//判断注册的链接是否跳转正确
		Assert.assertEquals(ExpectRegisterUrl.equals(currentUrl1), true);
		//注册页面的登录链接
		WebElement LoginLink = driver.findElement(By.linkText("请登录"));
		LoginLink.click();
		String ExpectLoginUrl = "http://localhost:9000/jenkins/login";
		String currentUrl2 = driver.getCurrentUrl();
		//判断注册的链接是否跳转正确
		Assert.assertEquals(ExpectLoginUrl.equals(currentUrl2), true);
	}
	
	/**
	 * web自动结束方法,休息5秒中后退出浏览器驱动
	 * @param driver
	 */
	@Step("关闭浏览器驱动")
	public static void finish(ChromeDriver driver) {
		try {
			Thread.sleep(3*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	/**
	 * web自动化初始化方法，设置浏览器驱动位置，创建驱动对象
	 * @return
	 */
	@Step("初始化")
	public static ChromeDriver init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
