package com.lemon.driver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriver {
	
	public static void main(String[] args) throws Exception {
		//告诉程序IE驱动包所在位置（1.设置到环境变量中2.手动配置驱动灵活点）
		System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
		
		//IE常见问题一：IE开启了保护模式，报错：Protected Mode settings are not the same for all zones
		//方法一：关闭保护模式。打开IE浏览器->工具->安全->全部勾选启用保护模式
		//方法二：忽略保护模式
		//设置驱动配置
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//忽略保护模式
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//IE常见问题二：IE浏览器缩放设置
		//方法一：手动设置缩放100%
		//方法二：忽略缩放设置
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		/*问题三：window丢失问题（不一定出现）。报错信息：unable to find element with id -- kw
		 * 解决方法：
		 * capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://lemon.ke.qq.com/?tuin=788454e9");
		 * */
		
		//按照capabilities手动配置创建一个IE驱动
		InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
		//通过IE驱动访问网址
		driver.get("https://lemon.ke.qq.com/?tuin=788454e9");
		//人为让程序等待几秒
		Thread.sleep(3*1000);
		//关闭驱动
		driver.quit();
	}

}
