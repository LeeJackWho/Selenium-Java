package com.selenium.page;


import java.util.List;

import org.openqa.selenium.WebElement;

import com.selenium.base.DriverBase;
import com.selenium.util.getByLocator;

public class loginPage extends BasePage{
	public loginPage(DriverBase driver) {
		super(driver);
	}
	
	/**
	 * 获取注册跳转链接
	 */
	public WebElement getLoginToRegisterElement() {
		return element(getByLocator.getByLocator("registerLink"));
	}
	
	/**
	 * 获取用户名输入框
	 */
	public WebElement getUserElement() {
		return element(getByLocator.getByLocator("userInput"));
	}
	
	/**
	 * 获取密码输入框
	 */
	public WebElement getPasswordElement() {
		return element(getByLocator.getByLocator("passwordInput"));
	}
	
	/**
	 * 获取登录按钮
	 */
	public WebElement getLoginButtonElement() {
		return element(getByLocator.getByLocator("loginButton"));
	}
	
	/**
	 * 获取单选框
	 */
	public WebElement getKeepLoginBoxElement() {
		return element(getByLocator.getByLocator("keepLoginBox"));
	}
	
	/**
	 * 用户名或密码错误提示信息
	 */
	public WebElement getAlertdangerElement() {
		return element(getByLocator.getByLocator("alertDanger"));
	}
	
	/**
	 * 获取用户名或密码错误红框
	 */
	public List<WebElement> getDangerClassElements(){
		return elements(getByLocator.getByLocator("classDanger"));
	}
}
