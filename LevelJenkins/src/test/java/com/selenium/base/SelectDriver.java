package com.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelectDriver {
	//判断浏览器选择driver
	public WebDriver driverName(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			//配置环境变量，driver参数
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			return new ChromeDriver();
		}else {
			//我使用的火狐为开发者版本所以else用IE
//			System.setProperty("webdriver.firefox.driver", "F:\\Java\\FireFoxdriver\\geckodriver.exe");
//                 使用3.几的值webdriver.firefox.marionette
			//return new FirefoxDriver();
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			//设置驱动配置
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//忽略保护模式
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//忽略缩放设置
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			return new InternetExplorerDriver(capabilities);
		}
	}
}
