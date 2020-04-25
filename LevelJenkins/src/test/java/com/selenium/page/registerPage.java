package com.selenium.page;

import org.openqa.selenium.WebElement;

import com.selenium.base.DriverBase;
import com.selenium.util.getByLocator;

public class registerPage extends BasePage{
	public registerPage(DriverBase driver) {
		super(driver);
	}
	
	/**
	 * ��ȡ��¼��ת����
	 */
	public WebElement getRegisterToLoginElement() {
		return element(getByLocator.getByLocator("loginLink"));
	}
	
	/**
	 * ��ȡ�û��������
	 */
	public WebElement getRegisterUsernameElement() {
		return element(getByLocator.getByLocator("registerUsername"));
	}
	
	/**
	 * ��ȡȫ�������
	 */
	public WebElement getRegisterFullnameElement() {
		return element(getByLocator.getByLocator("registerFullname"));
	}
	
	/**
	 * ��ȡ���������
	 */
	public WebElement getRegisterEmailElement() {
		return element(getByLocator.getByLocator("registerEmail"));
	}
	
	/**
	 * ��ȡ���������
	 */
	public WebElement getRegisterPasswordElement() {
		return element(getByLocator.getByLocator("registerPassword"));
	}
	
	/**
	 * ��ȡ��ʾ���뵥ѡ��
	 */
	public WebElement getShowPasswordElement() {
		return element(getByLocator.getByLocator("showPassword"));
	}
	
	/**
	 * ��ȡ�����˺Ű�ť
	 */
	public WebElement getRegisterButtonElement() {
		return element(getByLocator.getByLocator("registerButton"));
	}
}
