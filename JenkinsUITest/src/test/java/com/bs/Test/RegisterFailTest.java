
package com.bs.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class RegisterFailTest {
	WebDriver driver;

	/**
	 * web自动化初始化方法，设置浏览器驱动位置，创建驱动对象
	 * 
	 * @return
	 */
	@BeforeClass
	@Step("初始化")
	public void initDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9000/jenkins/signup");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
//	public void test002_register() throws Exception  {
//		//准备工作
//		ChromeDriver driver = init();
//		//注册失败
//		registerNull(driver);
//		//销毁工作
//		finish(driver);
//	}

	/**
	 * 实现注册模块的自动化
	 * 
	 * @param driver
	 * @throws Exception
	 */
	@Test(description = "注册用户名为空")
	@Description("注册输入框为空测试用例")
	public void test002_registerNull() throws Exception {
		// 定位到创建账号按钮
		WebElement registerButton = driver.findElement(By.className("submit-button"));
		// 不输入注册信息直接点击注册按钮操作
		registerButton.isEnabled();
		registerButton.click();
		// 判断UI状态
		List<WebElement> inputHeader = driver.findElements(By.className("inputHeader"));
		for (WebElement iH : inputHeader) {
//			System.out.println(iH.getText());
			String dangermsg = iH.getText();
			if (dangermsg.equals("用户名 - \"\" is prohibited as a username for security reasons.")) {
				System.out.println("用户名为空UI显示正常");
			} else if (dangermsg.equals("全称 - \"\" is prohibited as a full name for security reasons.")) {
				System.out.println("全称输入为空UI显示正常");
			} else if (dangermsg.equals("邮箱 - Invalid e-mail address")) {
				System.out.println("邮箱输入为空UI显示正常");
			} else if (dangermsg.contains("密码 - Password is required")) {
				System.out.println("密码输入为空UI显示正常");
			}
		}
	}

	@Test(dependsOnMethods = "test002_registerNull")
	@Description("注册输入错误测试用例")
	public void test003_registerError() throws Exception {
		driver.get("http://localhost:9000/jenkins/signup");
		// 定位到用户名
		WebElement registerUsername = driver.findElement(By.id("username"));
		// 定位到创建账号按钮
		WebElement registerButton = driver.findElement(By.name("Submit"));
		// 输入已有用户名aaa
		registerUsername.sendKeys("aaa");
		// 全称和密码没有任何字符字长限制，邮箱只要有@就算正常输入
		// 点击注册按钮时判断
		registerButton.click();
		// 判断UI状态
		WebElement UserIsTaken = driver.findElement(By.xpath("//*[@id='main-panel']/div[1]/div/label"));
		Assert.assertNotSame(UserIsTaken.getText(), "用户名 - User name is already taken", "用户名已存在UI正常");
	}

	@Test(dependsOnMethods = "test002_registerNull")
	@Description("注册输入密码强度测试用例")
	public void test003_registerPasswordStrength() throws Exception {
		driver.get("http://localhost:9000/jenkins/signup");
		// 定位到密码
		WebElement registerPassword = driver.findElement(By.id("password1"));
		WebElement pwStrength = driver.findElement(By.id("passwordStrength"));
		// 强度为很弱
		registerPassword.sendKeys("123");
		String text0 = pwStrength.getText();
		if (text0.equals("很弱")) {
			System.out.println("输入的密码强度为很弱UI显示正常");
		}
		// 强度为弱
		registerPassword.clear();
		registerPassword.sendKeys("123456");
		String text1 = pwStrength.getText();
		if (text1.equals("弱")) {
			System.out.println("输入的密码强度为弱UI显示正常");
		}
		// 强度为适中
		registerPassword.clear();
		registerPassword.sendKeys("123456asdzx");
		String text2 = pwStrength.getText();
		if (text2.equals("适中")) {
			System.out.println("输入的密码强度为适中UI显示正常");
		}
		// 强度为强
		registerPassword.clear();
		registerPassword.sendKeys("123456asdx!@!");
		String text3 = pwStrength.getText();
		if (text3.equals("强")) {
			System.out.println("输入的密码强度为强UI显示正常");
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