package com.bs.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JenkinsLogin {
	public WebDriver driver;
	//初始化driver
	public void InitDriver() {
		//配置环境变量，driver参数
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		//打开登录测试地址
		driver.get("http://localhost:9000/jenkins/login");
		//浏览器最大化
		driver.manage().window().maximize();
	}
	public void QuitDriver() {
		driver.quit();
	}
	
	//登录脚本编写
	public void loginScript() throws Exception {
		//定位输入框并定义对象
		WebElement loginUser = driver.findElement(By.id("j_username"));
		//检测输入框状态是否显示
		loginUser.isDisplayed();
		WebElement loginPassword = driver.findElement(By.name("j_password"));
		loginPassword.isDisplayed();
		WebElement loginButton = driver.findElement(By.name("Submit"));
		loginButton.isDisplayed();
		//登录操作
		loginUser.sendKeys("aaa");
		loginPassword.sendKeys("aaaaa");
		loginButton.click();
		//等待加载3秒
		Thread.sleep(3000);
		//在登录成功页面获取状态
		WebElement header = driver.findElement(By.className("model-link"));
		header.isDisplayed();
		//获取登录成功的用户信息
		String UserInfo = header.getText();
//		System.out.println(UserInfo);
		//判断用户登录成功
		if(UserInfo.equals("李四")) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	}
	public static void main(String[] args) throws Exception {
		//实例化JenkinsLogin类
		JenkinsLogin login = new JenkinsLogin();
		//调用初始化driver
		login.InitDriver();
		//运行登录脚本
		login.loginScript();
		//关闭驱动，防止内存占用
		login.QuitDriver();
	}
	
}
