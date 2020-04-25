package com.selenium.study;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

//Alert������
		//alert����ȷ�Ϻ�ȡ������https://www.w3school.com.cn/tiy/t.asp?f=js_confirm
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=js_confirm");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("button")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.tagName("button")).click();
		alert.dismiss();
		
		//�������ĵ���https://www.w3school.com.cn/tiy/t.asp?f=js_prompt
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=js_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("button")).click();
		Alert alert1 = driver.switchTo().alert();
		alert.sendKeys("hello");
		alert.accept();
		
		//��������ĵ���https://www.w3school.com.cn/tiy/t.asp?f=js_alert_2
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=js_alert_2");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("button")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.print(alert.getText());
		alert.accept();

		driver.quit();
	}

}
