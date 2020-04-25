package com.bs.jenkins;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseDriver {
	WebDriver driver;
	//放到构造方法driver初始化
	public void baseDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	/**
	 * 截图
	 */
	public void takeScreenShot() {
		//获取系统时间
		long data = System.currentTimeMillis();
		//长整型转为String类型
		String path = String.valueOf(data);
		//获取项目系统路径
		String curPath = System.getProperty("user.dir");
		//命名路径=系统路径+图片路径
		String screenPaht = curPath +"/"+ path;
		//以时间格式命名图片
		path = path+".png";
		//截图操作为File类型，放在内存
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//设置截图放置路径
		try {
			FileUtils.copyFile(screen,new File(screenPaht));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
