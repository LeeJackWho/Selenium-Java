package com.lemon.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {

	public static void main(String[] args) throws Exception {
		//���߳���Chrome������λ�ã����������У�
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		//����һ��Chrome����
		ChromeDriver driver = new ChromeDriver();
		//ͨ����������
		driver.get("https://lemon.ke.qq.com/?tuin=788454e9");
		//�ȴ�
		Thread.sleep(5*1000);
		//�ر�����
		driver.quit();
	}

}
