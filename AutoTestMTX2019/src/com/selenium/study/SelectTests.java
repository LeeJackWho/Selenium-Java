package com.selenium.study;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTests {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		
		//下拉框1.https://www.w3school.com.cn/tiy/t.asp?f=html_select
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_select");
		driver.switchTo().frame("iframeResult");
		WebElement selectEle = driver.findElement(By.tagName("Select"));
		
		Select select = new Select(selectEle);
		select.selectByVisibleText("Opel");
		Thread.sleep(2000);
		select.selectByIndex(0);
		Thread.sleep(2000);
		select.selectByValue("audi");
		Thread.sleep(2000);
		//下拉框2.https://www.w3school.com.cn/tiy/t.asp?f=html_select_multiple
		
		
		driver.quit();
	}

}
