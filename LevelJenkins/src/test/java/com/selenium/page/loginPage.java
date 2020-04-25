package com.selenium.page;


import java.util.List;

import org.openqa.selenium.WebElement;

import com.selenium.base.DriverBase;
import com.selenium.util.getByLocator;

public class loginPage extends BasePage{
	public loginPage(DriverBase driver) {
		super(driver);
	}
	
	/**
	 * ��ȡע����ת����
	 */
	public WebElement getLoginToRegisterElement() {
		return element(getByLocator.getByLocator("registerLink"));
	}
	
	/**
	 * ��ȡ�û��������
	 */
	public WebElement getUserElement() {
		return element(getByLocator.getByLocator("userInput"));
	}
	
	/**
	 * ��ȡ���������
	 */
	public WebElement getPasswordElement() {
		return element(getByLocator.getByLocator("passwordInput"));
	}
	
	/**
	 * ��ȡ��¼��ť
	 */
	public WebElement getLoginButtonElement() {
		return element(getByLocator.getByLocator("loginButton"));
	}
	
	/**
	 * ��ȡ��ѡ��
	 */
	public WebElement getKeepLoginBoxElement() {
		return element(getByLocator.getByLocator("keepLoginBox"));
	}
	
	/**
	 * �û��������������ʾ��Ϣ
	 */
	public WebElement getAlertdangerElement() {
		return element(getByLocator.getByLocator("alertDanger"));
	}
	
	/**
	 * ��ȡ�û��������������
	 */
	public List<WebElement> getDangerClassElements(){
		return elements(getByLocator.getByLocator("classDanger"));
	}
}
