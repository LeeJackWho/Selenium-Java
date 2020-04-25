package com.lemon.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DeleteItemTest {

	@Test
	public void test() throws Exception  {
		//准备工作
		ChromeDriver driver = init();
		//登录
		login(driver);
		//新增项目
		deleteItem(driver);
		//销毁工作
		finish(driver);
	}
	
	public static void deleteItem(ChromeDriver driver) throws Exception {
		//访问项目首页
		driver.get("http://111.229.164.84:9527/jenkins");
		//把鼠标移动到项目成名上。
		//创建鼠标键盘对象
		Actions action = new Actions(driver);
		//移动鼠标到web项目元素上
		action.moveToElement(driver.findElement(By.linkText("web项目"))).perform();
		//点击倒三角形
		driver.findElement(By.id("menuSelector")).click();
		//定位删除项目按钮
		Thread.sleep(1*1000);
		driver.findElement(By.partialLinkText("删除 Project")).click();
		Thread.sleep(1*1000);
		//确认弹出框按钮
		driver.switchTo().alert().accept();
	}
	
	public static void login(ChromeDriver driver) {
		driver.get("http://111.229.164.84:9527/jenkins");
		//定位用户名
		driver.findElement(By.id("j_username")).sendKeys("lemon04");
		//定位密码
		driver.findElement(By.name("j_password")).sendKeys("123456");
		
		driver.findElement(By.className("Checkbox-text")).click();
		
		//定位登录按钮
		driver.findElement(By.name("Submit")).click();
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
