package com.selenium.page;

import org.openqa.selenium.WebElement;

import com.selenium.base.DriverBase;
import com.selenium.util.getByLocator;

public class newJobPage extends BasePage{
	public newJobPage(DriverBase driver) {
		super(driver);
	}
	
	/**
	 * 获取任务名称输入框
	 */
	public WebElement jobNameElement() {
		return element(getByLocator.getByLocator("jobName"));
	}
	
	/**
	 * 获取Freestyleproject选项
	 */
	public WebElement freestyleProjectElement() {
		return element(getByLocator.getByLocator("freestyleProject"));
	}
	
	/**
	 * 获取流水线选项
	 */
	public WebElement workFlowElement() {
		return element(getByLocator.getByLocator("workFlow"));
	}
	
	/**
	 * 获取构建一个多配制项目选项
	 */
	public WebElement matrixProjectElement() {
		return element(getByLocator.getByLocator("matrixProject"));
	}
	
	/**
	 * 获取GitHub组织选项
	 */
	public WebElement GitHubSCMNavigatorElement() {
		return element(getByLocator.getByLocator("GitHubSCMNavigator"));
	}
	
	/**
	 * 获取多分支流水线选项
	 */
	public WebElement WorkflowMultiBranchProjectElement() {
		return element(getByLocator.getByLocator("WorkflowMultiBranchProject"));
	}
	
	/**
	 * 获取文件夹选项
	 */
	public WebElement FolderElement() {
		return element(getByLocator.getByLocator("Folder"));
	}
	
	/**
	 * 获取输入自动完成输入框
	 */
	public WebElement autoFinishElement() {
		return element(getByLocator.getByLocator("autoFinish"));
	}
	
	/**
	 * 获取确定按钮
	 */
	public WebElement OkElement() {
		return element(getByLocator.getByLocator("Ok"));
	}
}
