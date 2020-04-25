package com.lemon.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestJenkins {
	public static void main(String[] args) throws Exception {
		//准备工作
		ChromeDriver driver = init();
		//注册
//		register(driver);
		//登录
		//访问登录页面
		login(driver);
		//新增项目
//		addItem(driver);
		//删除项目
		//访问项目首页
//		deleteItem(driver);
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
		driver.findElement(By.partialLinkText("删除 Project")).click();
		Thread.sleep(1*1000);
		//确认弹出框按钮
		driver.switchTo().alert().accept();
	}
	
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
