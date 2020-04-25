package com.mianshui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 public class LoginPage {
     
     
     //用户名输入框
     @FindBy(className="dlemail")
     private WebElement uName;
     //密码输入框
     @FindBy(className="dlpwd")
     private WebElement pwd;
     //登录按钮
     @FindBy(id="dologin")
     private WebElement loginButton;
     //继续登录按钮
     @FindBy(className="u-btn")
     private WebElement continueLogin;
     
     //输入用户名
     public void  inputUsername(String userName){
         System.out.println(userName);
         uName.clear();
         uName.sendKeys(userName);
         
    }
     //输入密码
     public void inputPwd(String passWord){
         pwd.clear();
         pwd.sendKeys(passWord);
     }
     //单击登录
     public void clickLoginButton(String string){
         loginButton.click();
     }
     //单击继续登录
     public void continueLogin(String string){
         continueLogin.click();
     }
 }