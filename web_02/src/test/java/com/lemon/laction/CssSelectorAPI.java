package com.lemon.laction;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 使用cssSelector定位元素，偏前端定位方式
 * 与前端人员打交道最好用这种
 * 
 * @author LJH
 *
 */
public class CssSelectorAPI {
	public static void main(String[] args) throws Exception {
		// 配置浏览器驱动
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// 创建驱动
		ChromeDriver driver = new ChromeDriver();
		// 调用驱动访问网址
		driver.get("http://111.229.164.84:9527/jenkins");
		
		/*
		 * #id					id选择器
		 * .class				className选择器
		 * element				标签元素选择器
		 * [attribute]			元素属性选择器
		 * [attribute=value]	元素属性具体选择器
		*/
		
		//cssselector id定位
		driver.findElement(By.cssSelector("#j_username")).sendKeys("lemon");
		//cssselector 属性定位
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("123456");
		//cssselector class定位
		driver.findElement(By.cssSelector(".submit-button")).click();
		
		// 手动停止5秒
		Thread.sleep(5 * 1000);
		// 关闭驱动
		driver.quit();
	}
}