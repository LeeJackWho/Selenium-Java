package com.selenium.study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utils {
	//Ԫ���Ƿ����
		public static Boolean elementIsExist(WebDriver driver,By by) {
			//Ĭ��Ԫ�ز�����
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
