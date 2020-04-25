package com.lemon.laction;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 使用XPath定位元素  XML HTML的层级关系定位
 * 
 * @author LJH
 *
 */
public class XPathAPI {
	public static void main(String[] args) throws Exception {
		// 配置浏览器驱动
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// 创建驱动
		ChromeDriver driver = new ChromeDriver();
		// 调用驱动访问网址
		driver.get("http://111.229.164.84:9527/jenkins");
		
		//	html	选取HTML的所有子节点
		//	/html	从HTML根节点选取（绝对路径）
		//	//input	选取所有input标签，而不考虑它们的位置
		//	//*		选取文档的所有元素
		//	@id		选取所有id属性
		/*	
		 * 	函数：
		 * 	contains(args1,args2)：包含某个字段
		 * 		args1定位的对象
		 * 		args2包含的内容
		 * 	text()：获取标签之间的文本内容
		*/
		//绝对定位：/html[1]/body[1]/div[1]/form[1]/div[2]/input[1]
		//相对定位：//input[@id='j_username']
		
		//XPATH 绝对定位
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys("lemon");
		//XPATH 相对定位
		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("123456");
		
		// 手动停止5秒
		Thread.sleep(5 * 1000);
		// 关闭驱动
		driver.quit();
	}
}
