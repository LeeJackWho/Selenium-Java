package com.selenium.study;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PassCookie {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		//�ƹ�cookie��¼
		driver.get("");
		//�ȵ�¼ͨ��F12�鿴�ѵ�¼��cookie��Ϣ
		Cookie cookie1 = new Cookie("iwp_Session","asfasva");
		Cookie cookie2 = new Cookie("iwp_user_login","ascscasc");
		
		driver.manage().addCookie(cookie1);
		driver.manage().addCookie(cookie2);
		//���ʵ�¼����ܲ鿴�Ľ���鿴Ч��
		driver.get("");
	}
}
