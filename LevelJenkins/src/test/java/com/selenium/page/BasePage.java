package com.selenium.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.base.DriverBase;

public class BasePage {
	//拿DriverBase中的driver
	public DriverBase driver;
	//构造方法，实例化DriverBase的driver传进()
	public BasePage(DriverBase driver) {
		this.driver = driver;
	}
	
	/**
	 * 定位Element
	 * @param By by
	 */
	public WebElement element(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}
	
	/**
	 * 定位Element
	 * @param By by
	 */
	public List<WebElement> elements(By by){
		List<WebElement> elements = driver.findElements(by);
        return elements;
	}
	
	/**
	 * 封装点击
	 */
	public void click(WebElement element) {
		if(element!=null) {
			element.click();
		}else {
			System.out.println("元素没有定位到，点击失败");
		}
	}
	
	/**
	 * 封装输入
	 */
	public void sendKeys(WebElement element,String value) {
		if(element!=null) {
			element.sendKeys(value);
		}else {
			System.out.println(element + "元素没有定位到，输入失败" + value);
		}
	}
	
	/**
	 * 封装清空输入框
	 */
	public void clear(WebElement element) {
		if(element!=null) {
			element.clear();
		}else {
			System.out.println("元素无法定位到，无法清空");
		}
	}
	
	/**
	 * 判断元素是否显示
	 */
	public boolean assertElementIs(WebElement element) {
		return element.isDisplayed();
	}
	
	/**
	 * 判断元素是否选中，用于下拉框判断
	 */
	public boolean assertElementIsSelected(WebElement element) {
		return element.isSelected();
	}
	
	/**
	 * 判断元素是否有效，用于CheckBox判断
	 */
	public boolean assertElementIsEnabled(WebElement element) {
		return element.isEnabled();
	}
}
