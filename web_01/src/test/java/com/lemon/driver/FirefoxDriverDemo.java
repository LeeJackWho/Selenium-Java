package com.lemon.driver;

import org.openqa.selenium.firefox.FirefoxDriver;;
//�����ҵ��ǿ������������Բ���ʹ���Զ���
public class FirefoxDriverDemo {
	public static void main(String[] args) throws Exception {
		//�Ҳ������λ�ã�����Cannot find firefox binary in PATH. Make sure firefox is installed.
		//���������Ĭ�ϰ�װλ�ã���������exe�ļ���λ��
		System.setProperty("webdriver.firefox.bin","E:\\Firefox Developer Edition\\firefox.exe");
		//���߳���Firefox������λ�ã����������У�
		System.setProperty("webdriver.geckodriver.driver", "src/test/resources/geckodriver.exe");
		//����һ��Firefox����
		FirefoxDriver driver = new FirefoxDriver();
		//ͨ����������
		driver.get("https://lemon.ke.qq.com/?tuin=788454e9");
		//�ȴ�
		Thread.sleep(5*1000);
		//�ر�����
		driver.quit();
	}

}
