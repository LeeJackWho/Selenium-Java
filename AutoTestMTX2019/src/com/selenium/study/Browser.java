package com.selenium.study;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	public static void main(String[] args) {
		//Chrome
		System.setProperty("webdriver.chrome.driver", "E:\\�������\\��ҵ���\\eclipse-jee-2019-03-R-win32-x86_64\\eclipse\\eclipse-workspace\\AutoTestMTX2019\\libs\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.bin", "chrome��bin·��");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		
		//IE
		System.setProperty("webdriver.ie.driver", "E:\\�������\\��ҵ���\\eclipse-jee-2019-03-R-win32-x86_64\\eclipse\\eclipse-workspace\\AutoTestMTX2019\\libs\\IEDriverServer.exe");
		WebDriver iedriver = new InternetExplorerDriver();
		
		//Firefox
		System.setProperty("webdriver.gecko.driver","E:\\�������\\��ҵ���\\eclipse-jee-2019-03-R-win32-x86_64\\eclipse\\eclipse-workspace\\AutoTestMTX2019\\libs\\geckodriver.exe");
		// firefox�汾>48����û�а�װ��Ĭ��λ�ã���Ҫָ����װ·��
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		WebDriver firefoxdriver = new FirefoxDriver();
		
		//Edge��Ϊwin7��win10
		
		driver.quit();
	}

	
}
