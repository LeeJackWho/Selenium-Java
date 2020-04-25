package com.lemon.driver;

import org.openqa.selenium.firefox.FirefoxDriver;;
//由于我的是开发版火狐，所以不能使用自动化
public class FirefoxDriverDemo {
	public static void main(String[] args) throws Exception {
		//找不到火狐位置，报错：Cannot find firefox binary in PATH. Make sure firefox is installed.
		//若火狐不是默认安装位置，设置启动exe文件的位置
		System.setProperty("webdriver.firefox.bin","E:\\Firefox Developer Edition\\firefox.exe");
		//告诉程序Firefox驱动包位置（环境变量中）
		System.setProperty("webdriver.geckodriver.driver", "src/test/resources/geckodriver.exe");
		//创建一个Firefox驱动
		FirefoxDriver driver = new FirefoxDriver();
		//通过驱动访问
		driver.get("https://lemon.ke.qq.com/?tuin=788454e9");
		//等待
		Thread.sleep(5*1000);
		//关闭驱动
		driver.quit();
	}

}
