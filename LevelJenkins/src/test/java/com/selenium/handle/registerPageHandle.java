package com.selenium.handle;

import com.selenium.base.DriverBase;
import com.selenium.page.registerPage;

public class registerPageHandle {
	public DriverBase driver;
	//ʵ����������ȫ�ֱ���
	public registerPage rp;
	public registerPageHandle(DriverBase driver) {
		this.driver = driver;
		//��ʼ��loginPage
		rp = new registerPage(driver);
	}
	
	/**
	 * �����¼����
	 */
	public void clickRegisterToLogin() {
		rp.click(rp.getRegisterToLoginElement());
	}
	
	/**
	 * �����û���
	 */
	public void sendKeysUser(String registerusername) {
		rp.sendKeys(rp.getRegisterUsernameElement(), registerusername);
	}
	
	/**
	 * ����û���
	 */
	public void clearUsername() {
		rp.clear(rp.getRegisterUsernameElement());
	}
	
	/**
	 * ����ȫ��
	 */
	public void sendKeysFullname(String registerfullname) {
		rp.sendKeys(rp.getRegisterFullnameElement(), registerfullname);
	}
	
	/**
	 * ���ȫ�������
	 */
	public void clearFullname() {
		rp.clear(rp.getRegisterFullnameElement());
	}
	
	/**
	 * ��������
	 */
	public void sendKeysEmail(String registeremail) {
		rp.sendKeys(rp.getRegisterEmailElement(), registeremail);
	}
	
	/**
	 * ������������
	 */
	public void clearEmail() {
		rp.clear(rp.getRegisterEmailElement());
	}
	
	/**
	 * ��������
	 */
	public void sendKeysPassword(String registerpassword) {
		rp.sendKeys(rp.getRegisterPasswordElement(), registerpassword);
	}
	
	/**
	 * ������������
	 */
	public void clearPassword() {
		rp.clear(rp.getRegisterPasswordElement());
	}
	
	/**
	 * ��������˺�
	 */
	public void clickRegisterButton() {
		rp.click(rp.getRegisterButtonElement());
	}
	
	/**
	 * �����ʾ����
	 */
	public void clickShowPassword() {
		rp.click(rp.getShowPasswordElement());
	}
	
	/**
	 * �ж��Ƿ��ǵ�¼ҳ��
	 * @return 
	 */
	public boolean assertRegisterPage() {
		return rp.assertElementIs(rp.getRegisterButtonElement());
	}
}
