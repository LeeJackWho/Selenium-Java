package com.selenium.study;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragTests {

	public static void main(String[] args) throws Exception {
WebDriver driver = new ChromeDriver();
		
		//拖拽
		driver.get("https://www.jqueryui.org.cn/demo/5621.html");
		//浏览器最大化
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//h3[text()='源代码']")).click();
		//获取元素属性，css定位默认第一个
		List<WebElement> items = driver.findElements(By.cssSelector(".ui-state-default"));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		//执行拖放操作
		action.dragAndDrop(items.get(0), items.get(1)).perform();
		//遍历执行多次拖拽
		for(int i=0;i<6;i++) {
			Thread.sleep(1000);
			System.out.println(items.get(0).getText());
			action.dragAndDropBy(items.get(0), 0, 50);
		}
		//层级定位，只拖拽第一个
		WebElement ul = driver.findElement(By.id("sortable"));
		WebElement item1 = ul.findElement(By.className("ui-state-default"));
		Actions action1 = new Actions(driver);
		action1.dragAndDropBy(item1, 0, 50);
		
		driver.quit();
	}

}
