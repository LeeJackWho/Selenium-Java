package com.selenium.study;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PassCookie {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		//绕过cookie登录
		driver.get("");
		//先登录通过F12查看已登录的cookie信息
		Cookie cookie1 = new Cookie("iwp_Session","asfasva");
		Cookie cookie2 = new Cookie("iwp_user_login","ascscasc");
		
		driver.manage().addCookie(cookie1);
		driver.manage().addCookie(cookie2);
		//访问登录后才能查看的界面查看效果
		driver.get("");
	}
}
