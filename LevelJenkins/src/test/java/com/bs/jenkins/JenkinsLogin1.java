package com.bs.jenkins;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 登录脚本重构与封装
 * 重构就是通过调整程序代码，但并不改变程序功能特征
 * 达到改善软件质量、性能，使程序设计模式和架构更趋合理，更容被理解，提高软件扩展性和维护性
 * 为什么进行重构？1.改进软件设计 2.更容易理解 3.提高效率
 * 封装了By和findElement的方法，并使用读取外部文件对页面元素代码与操作代码分离
 * 使用HashMap参数化方法失败，只能通过main方法传参进行单个账号参数化
 * */
public class JenkinsLogin1 {
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
	public void loginScript(String username,String password) throws Exception {
		//直接调用初始化driver
		this.InitDriver();
		//定义变量即参数化
//		String userBy = "id";
//		String userElement = "j_username";
//		String passwordBy = "name";
//		String passwordElement = "j_password";
//		String loginbuttonBy = "name";
//		String loginbuttonElement = "Submit";
//		String headerBy = "className";
//		String headerElement = "model-link";
		
		//定位输入框并定义对象
		//WebElement loginUser = driver.findElement(By.id(userElement));
		//this表示调用当前对象，读取配置文件element.properties进行页面元素的管理
		WebElement loginUser = this.element(this.byStr("userInput"));
		//检测输入框状态是否显示
		loginUser.isDisplayed();
		//WebElement loginPassword = driver.findElement(By.name(passwordElement));
		WebElement loginPassword = this.element(this.byStr("passwordInput"));
		loginPassword.isDisplayed();
		//WebElement loginButton = driver.findElement(By.name(loginbuttonElement));
		WebElement loginButton = this.element(this.byStr("loginButton"));
		loginButton.isDisplayed();
		//登录操作
		loginUser.sendKeys(username);
		loginPassword.sendKeys(password);
		loginButton.click();
		//等待加载3秒
		Thread.sleep(3000);
		//在登录成功页面获取状态
		//WebElement header = driver.findElement(By.className(headerElement));
		WebElement header = this.element(this.byStr("header"));
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
	
	/**
	 * 封装By by 传两个参数分别为定位方式和定位值的变量，更加具有可读性
	 * */
	public By byStr(String keyName) {
		//读取外部文件
		ProUtil properties = new ProUtil("element.properties");
		String locator = properties.getPro(keyName);
		//使用split方法按照“>”分割符切片
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		if(locatorType.equals("id")) {
			return By.id(locatorValue);
		}else if(locatorType.equals("name")) {
			return By.name(locatorValue);
		}else if(locatorType.equals("className")) {
			return By.className(locatorValue);
		}else if(locatorType.equals("linkText")) {
			return By.linkText(locatorValue);
		}else if(locatorType.equals("partialLinkText")) {
			return By.partialLinkText(locatorValue);
		}else if(locatorType.equals("tagName")) {
			return By.tagName(locatorValue);
		}else if(locatorType.equals("xpath")) {
			return By.xpath(locatorValue);
		}else if(locatorType.equals("cssSelector")) {
			return By.cssSelector(locatorValue);
		}else{
			return null;
		}
	}
	
	/**
	 * 封装findElement
	 * */
	public WebElement element(By by) {
		WebElement ele = driver.findElement(by);
		return ele;
	}
	
	public static void main(String[] args) throws Exception {
		//实例化JenkinsLogin类
		JenkinsLogin1 login = new JenkinsLogin1();
		//运行登录脚本
		login.loginScript("aaa","aaaaa");
		/**
		 * 使用HashMap参数化
		 * key-value
		 * */
//		HashMap<String,String> user = new HashMap<String,String>();
//		//已注册正常登录
//		user.put("aaa", "aaaaa");
//		//密码错误
//		user.put("aaa", "aa");
//		//迭代器读取两组值
//		Iterator us = user.entrySet().iterator();
//		while(us.hasNext()) {
//			Map.Entry entry = (Map.Entry) us.next();
//			String username = entry.getKey().toString();
//			String password = entry.getValue().toString();
//			System.out.println(username+"密码："+password);
//			login.loginScript(username, password);
//		}
		//关闭驱动，防止内存占用
		login.QuitDriver();
	}
}
