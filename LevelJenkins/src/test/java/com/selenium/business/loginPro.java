package com.selenium.business;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.selenium.base.DriverBase;
import com.selenium.handle.loginPageHandle;

public class loginPro {
	public loginPageHandle lph;
	public loginPro(DriverBase driver) {
		lph = new loginPageHandle(driver);
	}
	
	//登录流程
	public void login(String username,String userpassword) {
		if(lph.assertLoginPage()) {
			lph.clearUser();
			lph.clearPassword();
			lph.sendKeysUser(username);
			lph.sendKeysPassword(userpassword);
			lph.clickLoginButton();
		}else {
			System.out.println("页面不存在或状态不正确");
		}
	}
	
	//登录输入框为空流程
	public void loginEmpty() {
		if(lph.assertLoginPage()) {
			lph.clearUser();
			lph.clearPassword();
			lph.clickLoginButton();
			lph.assertDangerDisplay();
		}else {
			System.out.println("页面不存在或状态不正确");
	}
	}
}
