/**
 * @Description:注册页面，对象定位和操作，继承BasePage
 */
package com.bs.jenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	//请登录链接
	@FindBy(xpath="/html/body/div/div/div/div/a")
    private WebElement logina_Element;
	
	//用户名输入框
    @FindBy(id="username")
    private WebElement username_Element;
    
    //全称输入框
    @FindBy(name="fullname")
    private WebElement fullname_Element;
    
    //邮箱输入框
    @FindBy(id="email")
    private WebElement email_Element;
    
    //显示密码选择框
    @FindBy(xpath="//*[@id='main-panel']/div[4]/div[1]/div/label/div[1]")
    private WebElement showpw_Element;
    
    //密码输入框
    @FindBy(id="password1")
    private WebElement password1_Element;
    
    //创建账号按钮
    @FindBy(name="Submit")
    private WebElement su_Element;
    
    //登录跳转
    public void login_click() {
    	this.click(logina_Element);
    }
    
    //输入用户名
    public void username_sendkeys(String s){
        this.sendkeys(username_Element, s);
    }
    
    //输入全称
    public void fullname_sendkeys(String s){
        this.sendkeys(fullname_Element, s);
    }
    
    //输入邮箱
    public void email_sendkeys(String s){
        this.sendkeys(email_Element, s);
    }
    
    //输入关键词
    public void password1_sendkeys(String s){
        this.sendkeys(password1_Element, s);
    }
    
    //点击显示
    public void showpw_click() {
        this.click(showpw_Element);
    }
    
    //点击“创建账号”按钮
    public void su_click() {
        this.click(su_Element);
    }
    
}
