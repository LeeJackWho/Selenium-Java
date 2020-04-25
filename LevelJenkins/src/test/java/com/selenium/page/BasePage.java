package com.selenium.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.base.DriverBase;

public class BasePage {
	//��DriverBase�е�driver
	public DriverBase driver;
	//���췽����ʵ����DriverBase��driver����()
	public BasePage(DriverBase driver) {
		this.driver = driver;
	}
	
	/**
	 * ��λElement
	 * @param By by
	 */
	public WebElement element(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}
	
	/**
	 * ��λElement
	 * @param By by
	 */
	public List<WebElement> elements(By by){
		List<WebElement> elements = driver.findElements(by);
        return elements;
	}
	
	/**
	 * ��װ���
	 */
	public void click(WebElement element) {
		if(element!=null) {
			element.click();
		}else {
			System.out.println("Ԫ��û�ж�λ�������ʧ��");
		}
	}
	
	/**
	 * ��װ����
	 */
	public void sendKeys(WebElement element,String value) {
		if(element!=null) {
			element.sendKeys(value);
		}else {
			System.out.println(element + "Ԫ��û�ж�λ��������ʧ��" + value);
		}
	}
	
	/**
	 * ��װ��������
	 */
	public void clear(WebElement element) {
		if(element!=null) {
			element.clear();
		}else {
			System.out.println("Ԫ���޷���λ�����޷����");
		}
	}
	
	/**
	 * �ж�Ԫ���Ƿ���ʾ
	 */
	public boolean assertElementIs(WebElement element) {
		return element.isDisplayed();
	}
	
	/**
	 * �ж�Ԫ���Ƿ�ѡ�У������������ж�
	 */
	public boolean assertElementIsSelected(WebElement element) {
		return element.isSelected();
	}
	
	/**
	 * �ж�Ԫ���Ƿ���Ч������CheckBox�ж�
	 */
	public boolean assertElementIsEnabled(WebElement element) {
		return element.isEnabled();
	}
}
