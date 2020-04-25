package com.lemon.laction;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 使用selenium原生api定位元素
 * @author LJH
 *
 */
public class NativeAPI {

	public static void main(String[] args) throws Exception {
		//配置浏览器驱动
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		//创建驱动
		ChromeDriver driver = new ChromeDriver();
		//调用驱动访问网址
		driver.get("http://111.229.164.84:9527/jenkins");
		//定位元素
		/*
		 * By.id				通过id属性定位元素
		 * By.name				通过name属性定位元素
		 * By.tagName			通过标签名定位元素
		 * By.className			通过class属性定位元素
		 * By.linkText			通过连接文本HTML中的a标签等值定位元素
		 * By.partialLinkText	通过连接文本模糊定位元素
		 * 
		 * findElement和findElements区别
		 * findElement页面从上往下找到第一个元素并返回
		 * findElements获取页面所有相同的属性的元素，返回一个集合对象，集合顺序也是从上往下
		 * 
		 * 常见错误
		 * 1、优先使用原生api，如果元素有id属性优先使用id定位
		 * 2、遇见异常
		 * 		a、元素不可见或不可互动
		 * 			org.openqa.selenium.ElementNotInteractableException:element not interactable
		 * 			org.openqa.selenium.ElementNotInteractableException:Element is not visible
		 * 		b、定位常见异常，找不到元素
		 * 			org.openqa.selenium.NoSuchElementException:no such element:Unable to locate element:
		*/
		//驱动通过id找到元素，并且为该发送内容。
//		driver.findElement(By.id("j_username")).sendKeys("lemon");
//		driver.findElement(By.name("j_password")).sendKeys("123456");
//		driver.findElement(By.tagName("input")).sendKeys("abc");
//		List<WebElement> list = driver.findElements(By.tagName("input"));
		//遍历=从头到尾获取元素   1 2 3 4
//		for (WebElement e : list) {
//			System.out.println(e.getAttribute("type"));
//		}
		//驱动通过class找到元素，并且点击该元素
//		driver.findElement(By.className("submit-button")).click();
		
//		driver.findElement(By.linkText("创建一个用户账号")).click();
//		
//		Thread.sleep(2*1000);
//		
//		driver.findElement(By.partialLinkText("请登")).click();
		
		//type为hidden或disable能够定位不能操作
		driver.findElement(By.name("from2222")).sendKeys("123456");
		
		//手动停止3秒
		Thread.sleep(3*1000);
		//关闭驱动
		driver.quit();
	}

}
