package com.lemon.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class AddItemTest {

	@Test(description = "增加项目")
	@Description("增加项目22222222222222")
	public void test() throws Exception  {
		//准备工作
		ChromeDriver driver = init();
		//登录
		login(driver);
		//新增项目
		addItem(driver);
		//销毁工作
		finish(driver);
	}
	
	@Step("增加项目")
	public static void addItem(ChromeDriver driver) throws Exception {
		//访问首页
		driver.get("http://111.229.164.84:9527/jenkins");
		//点击新增项目按钮
		driver.findElement(By.linkText("新建Item")).click();
		Thread.sleep(2*1000);
		//定位创建项目
		driver.get("http://111.229.164.84:9527/jenkins/view/all/newJob");
		//输入一个任务名称
		driver.findElement(By.id("name")).sendKeys("web项目");
		//选择项目类型
		driver.findElement(By.className("hudson_model_FreeStyleProject")).click();
		//点击确认按钮
		driver.findElement(By.id("ok-button")).click();
	}
	
	@Step("登录")
	public static void login(ChromeDriver driver) {
		driver.get("http://111.229.164.84:9527/jenkins");
		//定位用户名
		driver.findElement(By.id("j_username")).sendKeys("lemon04");
		//定位密码
		driver.findElement(By.name("j_password")).sendKeys("123456");
		//是否保持登录
		driver.findElement(By.className("Checkbox-text")).click();
		
		//定位登录按钮
		driver.findElement(By.name("Submit")).click();
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
		return driver;
	}
}
