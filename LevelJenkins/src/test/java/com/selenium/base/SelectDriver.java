package com.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelectDriver {
	//�ж������ѡ��driver
	public WebDriver driverName(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			//���û���������driver����
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			return new ChromeDriver();
		}else {
			//��ʹ�õĻ��Ϊ�����߰汾����else��IE
//			System.setProperty("webdriver.firefox.driver", "F:\\Java\\FireFoxdriver\\geckodriver.exe");
//                 ʹ��3.����ֵwebdriver.firefox.marionette
			//return new FirefoxDriver();
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			//������������
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//���Ա���ģʽ
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//������������
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			return new InternetExplorerDriver(capabilities);
		}
	}
}
