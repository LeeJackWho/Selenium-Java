package com.selenium.study;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTests {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		//��ѡhttps://www.w3school.com.cn/tiy/t.asp?f=html_input_checkbox
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_input_checkbox");
		driver.switchTo().frame("iframeResult");
		//ѡ��ûѡ�е�
		List<WebElement> checkBoxes = driver.findElements(By.name("vehicle"));
		for(WebElement w:checkBoxes) {
			if(!w.isSelected()) {
				w.click();
			}else {
				System.out.println(w.getText());
			}
		}
		//ֻѡ��һ��
		checkBoxes.get(0).click();
		System.out.println(driver.findElement(By.tagName("form")).getText());
		
		driver.quit();
	}

}
