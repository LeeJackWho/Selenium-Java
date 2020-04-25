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

public class LoginFailTest {
	WebDriver driver;
	
	@BeforeClass
	@Step("初始化")
	public void initDriver() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9000/jenkins/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(description = "失败用户登录")
	@Description("登录用户或密码错误测试用例")
	public void test002_login() throws Exception {
		//访问登录页面
		driver.get("http://localhost:9000/jenkins/login");
		//输入错误的用户名或密码
		//不输入直接点击“登录”按钮
		WebElement loginButton = driver.findElement(By.className("submit-button"));
		loginButton.click();
		//检测是否会弹出“用户名或密码错误”提示
		WebElement dangerAlert = driver.findElement(By.className("alert"));
		Assert.assertEquals(dangerAlert.getText(), "用户名或密码错误");
		//检测用户名和密码输入框class是否变为danger属性
		List<WebElement> Inputs = driver.findElements(By.className("danger"));
		for(WebElement i:Inputs) {
			i.isDisplayed();
			System.out.println("className属性为danger的输入框：" + i.getAttribute("placeholder"));
		}
	}
	
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
