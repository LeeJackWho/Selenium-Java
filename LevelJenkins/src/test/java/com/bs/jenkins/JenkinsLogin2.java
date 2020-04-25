package com.bs.jenkins;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 * 登录脚本重构与封装
 * 重构就是通过调整程序代码，但并不改变程序功能特征
 * 达到改善软件质量、性能，使程序设计模式和架构更趋合理，更容被理解，提高软件扩展性和维护性
 * 为什么进行重构？1.改进软件设计 2.更容易理解 3.提高效率
 * 使用了TestNG
 * 增加失败截图方法，通过监听事件实现失败自动截图
 * TestngListenerScreenshot类重写失败截图方法
 * 继承于baseDriver调用driver
 * 把截图方法放到基类，在TestngListenerScreenshot类进行调用
 * */
@Listeners({TestngListenerScreenshot.class})
public class JenkinsLogin2 extends baseDriver{
//	public WebDriver driver;
	
	//初始化driver
	//使用TestNG
	@Test
	public void InitDriver() {
		//配置环境变量，driver参数
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		//打开登录测试地址
		driver.get("http://localhost:9000/jenkins/login");
		//浏览器最大化
		driver.manage().window().maximize();
	}
	
	//登录脚本编写
	@Test(dependsOnMethods= {"InitDriver"})
	public void loginScript() throws Exception {
		//定位输入框并定义对象
		//this表示调用当前对象，读取配置文件element.properties进行页面元素的管理
		WebElement loginUser = this.element(this.byStr("userInput"));
		//检测输入框状态是否显示
		loginUser.isDisplayed();
		WebElement loginPassword = this.element(this.byStr("passwordInput"));
		loginPassword.isDisplayed();
		WebElement loginButton = this.element(this.byStr("loginButton"));
		loginButton.isDisplayed();
		//登录操作
		loginUser.sendKeys("aaa");
		loginPassword.sendKeys("aaaaa");
		loginButton.click();
		//等待加载3秒
		Thread.sleep(3000);
		//在登录成功页面获取状态
		WebElement header = this.element(this.byStr("header"));
		header.isDisplayed();
		//获取登录成功的用户信息
		String UserInfo = header.getText();
		//判断用户登录成功
		if(UserInfo.equals("李四")) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	}
	
	//quit释放内容
	@Test(dependsOnMethods= {"loginScript"})
	public void QuitDriver() {
		driver.quit();
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
	
}
