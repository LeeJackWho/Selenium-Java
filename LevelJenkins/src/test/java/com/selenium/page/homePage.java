package com.selenium.page;

import org.openqa.selenium.WebElement;

import com.selenium.base.DriverBase;
import com.selenium.util.getByLocator;

public class homePage extends BasePage{
	public homePage(DriverBase driver) {
		super(driver);
	}
	
	/**
	 * 获取搜索框
	 */
	public WebElement searchElement() {
		return element(getByLocator.getByLocator("search"));
	}
	
	/**
	 * 获取首页登录
	 */
	public WebElement homeToLoginElement() {
		return element(getByLocator.getByLocator("homeToLogin"));
	}
	
	/**
	 * 获取首页注册
	 */
	public WebElement homeToRegisterElement() {
		return element(getByLocator.getByLocator("homeToRegister"));
	}
	
	/**
	 * 获取新建Item
	 */
	public WebElement newItemElement() {
		return element(getByLocator.getByLocator("newItem"));
	}
	
	/**
	 * 获取用户列表
	 */
	public WebElement userElement() {
		return element(getByLocator.getByLocator("user"));
	}
	
	/**
	 * 获取构建历史
	 */
	public WebElement historyElement() {
		return element(getByLocator.getByLocator("history"));
	}
	
	/**
	 * 获取凭据
	 */
	public WebElement evidenceElement() {
		return element(getByLocator.getByLocator("evidence"));
	}
	
	/**
	 * 获取构建执行状态
	 */
	public WebElement statusElement() {
		return element(getByLocator.getByLocator("status"));
	}
	
	/**
	 * 获取上次构建状态排序
	 */
	public WebElement lastStatusElement() {
		return element(getByLocator.getByLocator("lastStatus"));
	}
	
	/**
	 * 获取构建晴雨表排序
	 */
	public WebElement barometerElement() {
		return element(getByLocator.getByLocator("barometer"));
	}
	
	/**
	 * 获取Name排序
	 */
	public WebElement nameElement() {
		return element(getByLocator.getByLocator("name"));
	}
	
	/**
	 * 获取上次成功排序
	 */
	public WebElement successElement() {
		return element(getByLocator.getByLocator("success"));
	}
	
	/**
	 * 获取上次失败排序
	 */
	public WebElement failElement() {
		return element(getByLocator.getByLocator("fail"));
	}
	
	/**
	 * 获取上次持续时间排序
	 */
	public WebElement timeElement() {
		return element(getByLocator.getByLocator("time"));
	}
}
