package com.selenium.study;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GithubTest {

	//创建对象
	WebDriver driver;
	//创建构造方法初始化Driver
	public GithubTest() {
		driver = new ChromeDriver();
		//浏览器最大化
		driver.manage().window().maximize();
		//访问网址
		driver.get("https://github.com/login");
		//隐式等待，全局查找元素
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//GitHub登录
	public void login() throws Exception {
		driver.findElement(By.id("login_field")).sendKeys("666");
		driver.findElement(By.id("password")).sendKeys("666");
		driver.findElement(By.className("commit")).click();
		Thread.sleep(5000);
		//获取整个界面源码判断是否有文字，if括号中的内容为boolean值
		if(driver.getPageSource().contains("666")) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	}
	
	//创建respostiry
		public void create() throws Exception {
			driver.findElement(By.className("octicon-plus")).click();
			//超链接即a标签部分内容进行定位
			driver.findElement(By.partialLinkText("New repository")).click();
			driver.findElement(By.id("repository_name")).sendKeys("testabc7");
			driver.findElement(By.cssSelector(".btn.btn-primary.first-in-line")).click();
			String url="https://github.com/shamotest/testabc7";
			Thread.sleep(5000);
			//获取当前url地址进行对比
			String currentUrl=driver.getCurrentUrl();
			if(url.equals(currentUrl)) {
				System.out.println("创建成功");
			}else {
				System.out.println("创建失败");
			}

		}
		
	//修改respostiry
		public void change() throws Exception {
			driver.get("https://github.com/");
			driver.findElement(By.className("dashboard-underlined-link")).click();
			driver.findElement(By.partialLinkText("Settings")).click();
			//显式等待，显式等待和隐式等待同时出现，优先显式
			WebDriverWait wait=new WebDriverWait(driver, 20);
			//等待元素出现
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("aaa")));
			//等待元素可用
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new_name")));
			//清除输入框内容
			driver.findElement(By.name("new_name")).clear();
			driver.findElement(By.name("new_name")).sendKeys("testabc6");
			WebElement error=driver.findElement(By.className("error"));
			//判断内容是否重复
			String text=error.getText();
			if(text.equals("The repository testabc6 already exists on this account")) {
				System.out.println("重复验证提示正确");
			}else {
				System.out.println("重复验证提示失败");
			}
			driver.findElement(By.name("new_name")).sendKeys("testabc8");
			driver.findElement(By.className("flex-self-end")).click();
			Thread.sleep(3000);
			//获取界面title进行断言
			String title=driver.getTitle();
			if(title.equals("shamotest/testabc8")) {
				System.out.println("修改正确");
			}else {
				System.out.println("修改失败");
			}
			
		}
		//创建main方法调用上面三个方法
		public static void main(String[] args) throws Exception {
			//创建类的实例化对象
			GithubTest github=new GithubTest();
			github.login();
			//github.create();
			github.change();
		}

}
