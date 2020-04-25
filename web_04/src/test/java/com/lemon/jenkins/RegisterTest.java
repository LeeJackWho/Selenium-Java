package com.lemon.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegisterTest {

	@Test
	public void test() throws Exception  {
		//准备工作
		ChromeDriver driver = init();
		//注册
		register(driver);
		//销毁工作
		finish(driver);
	}
	
	/**
	 * 实现注册模块的自动化
	 * @param driver
	 * @throws Exception
	 */
	public static void register(ChromeDriver driver) throws Exception {
		//注册
		//访问注册页面
		driver.get("http://111.229.164.84:9527/jenkins/signup");
		//定位到用户名
		driver.findElement(By.id("username")).sendKeys("lemon04");
		//定位到全称
		driver.findElement(By.id("fullname")).sendKeys("小柠檬");
		//定位到邮箱
		driver.findElement(By.id("email")).sendKeys("lemon02@QQ.COM");
		//定位到密码
		driver.findElement(By.id("password1")).sendKeys("123456");
		//定位到创建账号按钮
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(2*1000);
		//注册成功之后，定位注销按钮
		driver.findElement(By.partialLinkText("注销")).click();
	}
	
	/**
	 * web自动结束方法,休息5秒中后退出浏览器驱动
	 * @param driver
	 */
	public static void finish(ChromeDriver driver) {
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	/**
	 * web自动化初始化方法，设置浏览器驱动位置，创建驱动对象
	 * @return
	 */
	public static ChromeDriver init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		return driver;
	}
	
}
