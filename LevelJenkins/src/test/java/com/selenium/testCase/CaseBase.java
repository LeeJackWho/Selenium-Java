package com.selenium.testCase;

import com.selenium.base.DriverBase;

/**
 * ����driver�����еĲ����඼�̳�caseBase�࣬�õ�driver
 * */

public class CaseBase {
	public DriverBase InitDriver(String browser) { //��ʼ��driver,ѡ��driver
		return new DriverBase(browser);
	}
}
