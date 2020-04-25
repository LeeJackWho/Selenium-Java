package com.bs.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class RegisterTest {

	@Test(description = "注册用户")
	@Description("成功注册测试用例")
	public void test001_register() throws Exception  {
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
	@Step("注册")
	public static void register(ChromeDriver driver) throws Exception {
		//注册
		//访问注册页面
		driver.get("http://localhost:9000/jenkins/signup");
		//定位到用户名
		WebElement registerUsername = driver.findElement(By.id("username"));
		//定位到全称
		WebElement registerFullname = driver.findElement(By.id("fullname"));
		//定位到邮箱
		WebElement registerEmail = driver.findElement(By.id("email"));
		//定位到密码
		WebElement registerPassword = driver.findElement(By.id("password1"));
		//定位到创建账号按钮
		WebElement registerButton = driver.findElement(By.name("Submit"));
		//检测UI状态是否显示
		registerUsername.isDisplayed();
		registerFullname.isDisplayed();
		registerEmail.isDisplayed();
		registerPassword.isDisplayed();
		registerButton.isEnabled();
		//注册操作
		registerUsername.sendKeys("lemon04");
		registerFullname.sendKeys("小柠檬");
		registerEmail.sendKeys("lemon02@QQ.COM");
		registerPassword.sendKeys("123456");
		registerButton.click();
		// 在注册成功会自动登录
		WebElement header = driver.findElement(By.className("model-link"));
		header.isDisplayed();
		// 获取登录成功的用户信息
		String UserInfo = header.getText();
		//判断是否注册成功
		if (UserInfo.equals("小柠檬")) {
			System.out.println("注册成功");
		} else {
			System.out.println("注册失败");
		}
		Thread.sleep(2*1000);
		//注册成功之后，定位注销按钮
		WebElement Logout = driver.findElement(By.partialLinkText("注销"));
		Logout.click();
	}
	
	/**
	 * web自动结束方法,休息5秒中后退出浏览器驱动
	 * @param driver
	 */
	@Step("关闭浏览器驱动")
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
	@Step("初始化")
	public static ChromeDriver init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}
