package com.selenium.testCase;

import com.selenium.base.DriverBase;

/**
 * 生成driver，所有的测试类都继承caseBase类，拿到driver
 * */

public class CaseBase {
	public DriverBase InitDriver(String browser) { //初始化driver,选择driver
		return new DriverBase(browser);
	}
}
