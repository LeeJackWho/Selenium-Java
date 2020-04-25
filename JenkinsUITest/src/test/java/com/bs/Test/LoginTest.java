package com.bs.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class LoginTest {
	WebDriver driver;
	
	/**
	 * web自动化初始化方法，设置浏览器驱动位置，创建驱动对象
	 * 
	 * @return
	 */
//	@Step("初始化")
//	public static ChromeDriver init() {
//		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
//		return driver;
//	}
	@BeforeClass
	@Step("初始化")
	public void initDriver() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9000/jenkins/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//	@Test(description = "用户登录")
//	@Description("成功登录测试用例")
//	public void test001_login() throws Exception {
//		// 准备工作
//		ChromeDriver driver = init();
//		// 登录
//		login(driver);
//		// 销毁工作
//		finish(driver);
//	}

	/**
	 * 实现登录模块的自动化
	 * 
	 * @param driver
	 * @throws Exception
	 */
	// 登录脚本编写
	//参数化用户名和密码
	@Parameters({"loginusername","loginpassword"})
	@Test(description = "用户登录")
	@Description("成功登录测试用例")
	public void test001_login(String loginusername,String loginpassword) throws Exception {
		//访问登录页面
//		driver.get("http://localhost:9000/jenkins/login");
		// 定位输入框并定义对象
		WebElement loginUser = driver.findElement(By.id("j_username"));
		// 检测UI状态是否显示
		loginUser.isDisplayed();
		WebElement loginPassword = driver.findElement(By.name("j_password"));
		loginPassword.isDisplayed();
		WebElement loginButton = driver.findElement(By.name("Submit"));
		loginButton.isEnabled();
		// 登录操作
		loginUser.sendKeys(loginusername);
		loginPassword.sendKeys(loginpassword);
		loginButton.click();
		// 等待加载3秒
		Thread.sleep(3000);
		// 在登录成功页面获取状态
		WebElement header = driver.findElement(By.className("model-link"));
		header.isDisplayed();
		// 获取登录成功的用户信息
		String UserInfo = header.getText();
//		System.out.println(UserInfo);
		// 判断用户登录成功
		if (UserInfo.equals("李四")) {
			System.out.println("登录成功\n");
		} else {
			System.out.println("登录失败\\n");
		}
	}

	/**
	 * web自动结束方法,休息5秒中后退出浏览器驱动
	 * 
	 * @param driver
	 */
	@AfterClass
	@Step("关闭浏览器驱动")
	public void finish() {
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}