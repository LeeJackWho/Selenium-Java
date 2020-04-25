package com.selenium.page;

import org.openqa.selenium.WebElement;

import com.selenium.base.DriverBase;
import com.selenium.util.getByLocator;

public class registerPage extends BasePage{
	public registerPage(DriverBase driver) {
		super(driver);
	}
	
	/**
	 * 获取登录跳转链接
	 */
	public WebElement getRegisterToLoginElement() {
		return element(getByLocator.getByLocator("loginLink"));
	}
	
	/**
	 * 获取用户名输入框
	 */
	public WebElement getRegisterUsernameElement() {
		return element(getByLocator.getByLocator("registerUsername"));
	}
	
	/**
	 * 获取全称输入框
	 */
	public WebElement getRegisterFullnameElement() {
		return element(getByLocator.getByLocator("registerFullname"));
	}
	
	/**
	 * 获取邮箱输入框
	 */
	public WebElement getRegisterEmailElement() {
		return element(getByLocator.getByLocator("registerEmail"));
	}
	
	/**
	 * 获取密码输入框
	 */
	public WebElement getRegisterPasswordElement() {
		return element(getByLocator.getByLocator("registerPassword"));
	}
	
	/**
	 * 获取显示密码单选框
	 */
	public WebElement getShowPasswordElement() {
		return element(getByLocator.getByLocator("showPassword"));
	}
	
	/**
	 * 获取创建账号按钮
	 */
	public WebElement getRegisterButtonElement() {
		return element(getByLocator.getByLocator("registerButton"));
	}
}
