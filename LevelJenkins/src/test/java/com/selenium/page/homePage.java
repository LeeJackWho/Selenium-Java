package com.selenium.page;

import org.openqa.selenium.WebElement;

import com.selenium.base.DriverBase;
import com.selenium.util.getByLocator;

public class homePage extends BasePage{
	public homePage(DriverBase driver) {
		super(driver);
	}
	
	/**
	 * ��ȡ������
	 */
	public WebElement searchElement() {
		return element(getByLocator.getByLocator("search"));
	}
	
	/**
	 * ��ȡ��ҳ��¼
	 */
	public WebElement homeToLoginElement() {
		return element(getByLocator.getByLocator("homeToLogin"));
	}
	
	/**
	 * ��ȡ��ҳע��
	 */
	public WebElement homeToRegisterElement() {
		return element(getByLocator.getByLocator("homeToRegister"));
	}
	
	/**
	 * ��ȡ�½�Item
	 */
	public WebElement newItemElement() {
		return element(getByLocator.getByLocator("newItem"));
	}
	
	/**
	 * ��ȡ�û��б�
	 */
	public WebElement userElement() {
		return element(getByLocator.getByLocator("user"));
	}
	
	/**
	 * ��ȡ������ʷ
	 */
	public WebElement historyElement() {
		return element(getByLocator.getByLocator("history"));
	}
	
	/**
	 * ��ȡƾ��
	 */
	public WebElement evidenceElement() {
		return element(getByLocator.getByLocator("evidence"));
	}
	
	/**
	 * ��ȡ����ִ��״̬
	 */
	public WebElement statusElement() {
		return element(getByLocator.getByLocator("status"));
	}
	
	/**
	 * ��ȡ�ϴι���״̬����
	 */
	public WebElement lastStatusElement() {
		return element(getByLocator.getByLocator("lastStatus"));
	}
	
	/**
	 * ��ȡ�������������
	 */
	public WebElement barometerElement() {
		return element(getByLocator.getByLocator("barometer"));
	}
	
	/**
	 * ��ȡName����
	 */
	public WebElement nameElement() {
		return element(getByLocator.getByLocator("name"));
	}
	
	/**
	 * ��ȡ�ϴγɹ�����
	 */
	public WebElement successElement() {
		return element(getByLocator.getByLocator("success"));
	}
	
	/**
	 * ��ȡ�ϴ�ʧ������
	 */
	public WebElement failElement() {
		return element(getByLocator.getByLocator("fail"));
	}
	
	/**
	 * ��ȡ�ϴγ���ʱ������
	 */
	public WebElement timeElement() {
		return element(getByLocator.getByLocator("time"));
	}
}
