package com.po.page;

import org.apache.poi.util.SuppressForbidden;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 定位语句与测试代码封装
 * */
public class loginPage {

	//用户名输入框
		@FindBy(id="j_username")
	    private WebElement username_Element;
		//密码输入框
		@FindBy(name="j_password")
	    private WebElement password_Element;
		//登录按钮
		@FindBy(name="Submit")
	    private WebElement submit_Element;
		//输入用户名
		public void loginName(String username) {
            System.out.println(username);
            username_Element.clear();
            username_Element.sendKeys(username);
        }
		//输入密码
		public void loginPwd(String password) {
            System.out.println(password);
            password_Element.clear();
            password_Element.sendKeys(password);
        }
		//点击登录按钮
		public void loginBtn() {
			submit_Element.click();
        }
}
