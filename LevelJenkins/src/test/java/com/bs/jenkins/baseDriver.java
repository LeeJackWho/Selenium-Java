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
	//�ŵ����췽��driver��ʼ��
	public void baseDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	/**
	 * ��ͼ
	 */
	public void takeScreenShot() {
		//��ȡϵͳʱ��
		long data = System.currentTimeMillis();
		//������תΪString����
		String path = String.valueOf(data);
		//��ȡ��Ŀϵͳ·��
		String curPath = System.getProperty("user.dir");
		//����·��=ϵͳ·��+ͼƬ·��
		String screenPaht = curPath +"/"+ path;
		//��ʱ���ʽ����ͼƬ
		path = path+".png";
		//��ͼ����ΪFile���ͣ������ڴ�
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//���ý�ͼ����·��
		try {
			FileUtils.copyFile(screen,new File(screenPaht));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
