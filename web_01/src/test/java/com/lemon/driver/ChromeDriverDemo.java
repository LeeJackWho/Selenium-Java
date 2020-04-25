package com.lemon.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {

	public static void main(String[] args) throws Exception {
		//告诉程序Chrome驱动包位置（环境变量中）
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		//创建一个Chrome驱动
		ChromeDriver driver = new ChromeDriver();
		//通过驱动访问
		driver.get("https://lemon.ke.qq.com/?tuin=788454e9");
		//等待
		Thread.sleep(5*1000);
		//关闭驱动
		driver.quit();
	}

}
