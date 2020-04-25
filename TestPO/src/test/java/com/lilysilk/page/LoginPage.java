package com.lilysilk.page;

import org.apache.poi.util.SuppressForbidden;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * ��λ�������Դ����װ
 * */
public class LoginPage {

        //��¼ҳ��
        @FindBy(className="touXiang")
        private WebElement uloginPage;
        //�û��������
        @FindBy(xpath="//div[@class='userLogin']/div[1]/input[@id='email']")
        private WebElement uName;
        //���������
        @FindBy(xpath="//div[@class='userLogin']/div[2]/input[@id='password']")
        private WebElement uPwd;
        //��¼��ť
        @FindBy(id="loginButton")
        private WebElement loginBtn;

        //�����ת��¼ҳ��
        public void goLoginPage() {
            uloginPage.click();
        }
        //�����û���
        public void loginName(String username) {
            System.out.println(username);
            uName.clear();
            uName.sendKeys(username);
        }
        //��������
        public void loginPwd(String password) {
            System.out.println(password);
            uPwd.clear();
            uPwd.sendKeys(password);
        }
        //�����¼
        public void loginBtn() {
            loginBtn.click();
        }
}