package com.lilysilk.page;

import org.apache.poi.util.SuppressForbidden;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 定位语句与测试代码封装
 * */
public class LoginPage {

        //登录页面
        @FindBy(className="touXiang")
        private WebElement uloginPage;
        //用户名输入框
        @FindBy(xpath="//div[@class='userLogin']/div[1]/input[@id='email']")
        private WebElement uName;
        //密码输入框
        @FindBy(xpath="//div[@class='userLogin']/div[2]/input[@id='password']")
        private WebElement uPwd;
        //登录按钮
        @FindBy(id="loginButton")
        private WebElement loginBtn;

        //点击跳转登录页面
        public void goLoginPage() {
            uloginPage.click();
        }
        //输入用户名
        public void loginName(String username) {
            System.out.println(username);
            uName.clear();
            uName.sendKeys(username);
        }
        //输入密码
        public void loginPwd(String password) {
            System.out.println(password);
            uPwd.clear();
            uPwd.sendKeys(password);
        }
        //点击登录
        public void loginBtn() {
            loginBtn.click();
        }
}