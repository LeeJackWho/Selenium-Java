package com.selenium.study;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioTests {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		//单选https://www.w3school.com.cn/tiy/t.asp?f=html_input_radio
		driver.get("https://www.w3school.com.cn/tiy/t.asp?f=html_input_radio");
		driver.switchTo().frame("iframeResult");
		//选择没选中的
		List<WebElement> radios = driver.findElements(By.name("sex"));
		for(WebElement w:radios) {
			if(!w.isSelected()) {
				w.click();
			}else {
				System.out.println(w.getText());
			}
		}
	}

}
