package com.bs.jenkins;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

//继承与testng自带的类
public class TestngListenerScreenshot extends TestListenerAdapter{
	//重写方法，除了onTestFailure，其它只需要复写
	@Override
	public void onTestSuccess(ITestResult tr) {
	    super.onTestSuccess(tr);
	}
	@Override
	public void onTestFailure(ITestResult tr) {
	    super.onTestFailure(tr);
	    takeScreenShot(tr);
	}
	
	//建一个方法传递driver
	private void takeScreenShot(ITestResult tr) {
		//tr对象传进去获取整个实例，强制转为基类，调用基类的截图方法
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
