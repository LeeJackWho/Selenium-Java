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
		
		//��ק
		driver.get("https://www.jqueryui.org.cn/demo/5621.html");
		//��������
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//h3[text()='Դ����']")).click();
		//��ȡԪ�����ԣ�css��λĬ�ϵ�һ��
		List<WebElement> items = driver.findElements(By.cssSelector(".ui-state-default"));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		//ִ���ϷŲ���
		action.dragAndDrop(items.get(0), items.get(1)).perform();
		//����ִ�ж����ק
		for(int i=0;i<6;i++) {
			Thread.sleep(1000);
			System.out.println(items.get(0).getText());
			action.dragAndDropBy(items.get(0), 0, 50);
		}
		//�㼶��λ��ֻ��ק��һ��
		WebElement ul = driver.findElement(By.id("sortable"));
		WebElement item1 = ul.findElement(By.className("ui-state-default"));
		Actions action1 = new Actions(driver);
		action1.dragAndDropBy(item1, 0, 50);
		
		driver.quit();
	}

}
