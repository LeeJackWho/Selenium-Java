package com.po.page;

import org.apache.poi.util.SuppressForbidden;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * ��λ�������Դ����װ
 * */
public class loginPage {

	//�û��������
		@FindBy(id="j_username")
	    private WebElement username_Element;
		//���������
		@FindBy(name="j_password")
	    private WebElement password_Element;
		//��¼��ť
		@FindBy(name="Submit")
	    private WebElement submit_Element;
		//�����û���
		public void loginName(String username) {
            System.out.println(username);
            username_Element.clear();
            username_Element.sendKeys(username);
        }
		//��������
		public void loginPwd(String password) {
            System.out.println(password);
            password_Element.clear();
            password_Element.sendKeys(password);
        }
		//�����¼��ť
		public void loginBtn() {
			submit_Element.click();
        }
}
