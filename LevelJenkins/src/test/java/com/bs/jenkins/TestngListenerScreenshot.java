package com.bs.jenkins;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

//�̳���testng�Դ�����
public class TestngListenerScreenshot extends TestListenerAdapter{
	//��д����������onTestFailure������ֻ��Ҫ��д
	@Override
	public void onTestSuccess(ITestResult tr) {
	    super.onTestSuccess(tr);
	}
	@Override
	public void onTestFailure(ITestResult tr) {
	    super.onTestFailure(tr);
	    takeScreenShot(tr);
	}
	
	//��һ����������driver
	private void takeScreenShot(ITestResult tr) {
		//tr���󴫽�ȥ��ȡ����ʵ����ǿ��תΪ���࣬���û���Ľ�ͼ����
		baseDriver b = (baseDriver)tr.getInstance();
		b.takeScreenShot();
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
	    super.onTestSkipped(tr);
	}
	@Override
	public void onTestStart(ITestResult result) {
		super.onTestStart(result);
	}
	@Override
	public void onStart(ITestContext testContext) {
		super.onStart(testContext);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
	}
}
