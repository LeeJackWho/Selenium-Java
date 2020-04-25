/**
 * @Description:ע��ҳ�棬����λ�Ͳ������̳�BasePage
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
	
	//���¼����
	@FindBy(xpath="/html/body/div/div/div/div/a")
    private WebElement logina_Element;
	
	//�û��������
    @FindBy(id="username")
    private WebElement username_Element;
    
    //ȫ�������
    @FindBy(name="fullname")
    private WebElement fullname_Element;
    
    //���������
    @FindBy(id="email")
    private WebElement email_Element;
    
    //��ʾ����ѡ���
    @FindBy(xpath="//*[@id='main-panel']/div[4]/div[1]/div/label/div[1]")
    private WebElement showpw_Element;
    
    //���������
    @FindBy(id="password1")
    private WebElement password1_Element;
    
    //�����˺Ű�ť
    @FindBy(name="Submit")
    private WebElement su_Element;
    
    //��¼��ת
    public void login_click() {
    	this.click(logina_Element);
    }
    
    //�����û���
    public void username_sendkeys(String s){
        this.sendkeys(username_Element, s);
    }
    
    //����ȫ��
    public void fullname_sendkeys(String s){
        this.sendkeys(fullname_Element, s);
    }
    
    //��������
    public void email_sendkeys(String s){
        this.sendkeys(email_Element, s);
    }
    
    //����ؼ���
    public void password1_sendkeys(String s){
        this.sendkeys(password1_Element, s);
    }
    
    //�����ʾ
    public void showpw_click() {
        this.click(showpw_Element);
    }
    
    //����������˺š���ť
    public void su_click() {
        this.click(su_Element);
    }
    
}
