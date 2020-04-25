package com.selenium.handle;

import com.selenium.base.DriverBase;
import com.selenium.page.registerPage;

public class registerPageHandle {
	public DriverBase driver;
	//实例化，声明全局变量
	public registerPage rp;
	public registerPageHandle(DriverBase driver) {
		this.driver = driver;
		//初始化loginPage
		rp = new registerPage(driver);
	}
	
	/**
	 * 点击登录链接
	 */
	public void clickRegisterToLogin() {
		rp.click(rp.getRegisterToLoginElement());
	}
	
	/**
	 * 输入用户名
	 */
	public void sendKeysUser(String registerusername) {
		rp.sendKeys(rp.getRegisterUsernameElement(), registerusername);
	}
	
	/**
	 * 清空用户名
	 */
	public void clearUsername() {
		rp.clear(rp.getRegisterUsernameElement());
	}
	
	/**
	 * 输入全称
	 */
	public void sendKeysFullname(String registerfullname) {
		rp.sendKeys(rp.getRegisterFullnameElement(), registerfullname);
	}
	
	/**
	 * 清空全称输入框
	 */
	public void clearFullname() {
		rp.clear(rp.getRegisterFullnameElement());
	}
	
	/**
	 * 输入邮箱
	 */
	public void sendKeysEmail(String registeremail) {
		rp.sendKeys(rp.getRegisterEmailElement(), registeremail);
	}
	
	/**
	 * 清空邮箱输入框
	 */
	public void clearEmail() {
		rp.clear(rp.getRegisterEmailElement());
	}
	
	/**
	 * 输入密码
	 */
	public void sendKeysPassword(String registerpassword) {
		rp.sendKeys(rp.getRegisterPasswordElement(), registerpassword);
	}
	
	/**
	 * 清空密码输入框
	 */
	public void clearPassword() {
		rp.clear(rp.getRegisterPasswordElement());
	}
	
	/**
	 * 点击创建账号
	 */
	public void clickRegisterButton() {
		rp.click(rp.getRegisterButtonElement());
	}
	
	/**
	 * 点击显示密码
	 */
	public void clickShowPassword() {
		rp.click(rp.getShowPasswordElement());
	}
	
	/**
	 * 判断是否是登录页面
	 * @return 
	 */
	public boolean assertRegisterPage() {
		return rp.assertElementIs(rp.getRegisterButtonElement());
	}
}
