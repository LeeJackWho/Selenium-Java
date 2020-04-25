package com.selenium.study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utils {
	//元素是否存在
		public static Boolean elementIsExist(WebDriver driver,By by) {
			//默认元素不存在
			Boolean flag=false;
			try {
				driver.findElement(by);
				flag=true;
			} catch (Exception e) {
				// TODO: handle exception
				
			}
			return flag;	
		}

}
