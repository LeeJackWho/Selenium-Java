package com.lemon.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegisterTest {

	@Test
	public void test() throws Exception  {
		//׼������
		ChromeDriver driver = init();
		//ע��
		register(driver);
		//���ٹ���
		finish(driver);
	}
	
	/**
	 * ʵ��ע��ģ����Զ���
	 * @param driver
	 * @throws Exception
	 */
	public static void register(ChromeDriver driver) throws Exception {
		//ע��
		//����ע��ҳ��
		driver.get("http://111.229.164.84:9527/jenkins/signup");
		//��λ���û���
		driver.findElement(By.id("username")).sendKeys("lemon04");
		//��λ��ȫ��
		driver.findElement(By.id("fullname")).sendKeys("С����");
		//��λ������
		driver.findElement(By.id("email")).sendKeys("lemon02@QQ.COM");
		//��λ������
		driver.findElement(By.id("password1")).sendKeys("123456");
		//��λ�������˺Ű�ť
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(2*1000);
		//ע��ɹ�֮�󣬶�λע����ť
		driver.findElement(By.partialLinkText("ע��")).click();
	}
	
	/**
	 * web�Զ���������,��Ϣ5���к��˳����������
	 * @param driver
	 */
	public static void finish(ChromeDriver driver) {
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	/**
	 * web�Զ�����ʼ���������������������λ�ã�������������
	 * @return
	 */
	public static ChromeDriver init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		return driver;
	}
	
}
