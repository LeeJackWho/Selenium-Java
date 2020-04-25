package com.lemon.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DeleteItemTest {

	@Test
	public void test() throws Exception  {
		//׼������
		ChromeDriver driver = init();
		//��¼
		login(driver);
		//������Ŀ
		deleteItem(driver);
		//���ٹ���
		finish(driver);
	}
	
	public static void deleteItem(ChromeDriver driver) throws Exception {
		//������Ŀ��ҳ
		driver.get("http://111.229.164.84:9527/jenkins");
		//������ƶ�����Ŀ�����ϡ�
		//���������̶���
		Actions action = new Actions(driver);
		//�ƶ���굽web��ĿԪ����
		action.moveToElement(driver.findElement(By.linkText("web��Ŀ"))).perform();
		//�����������
		driver.findElement(By.id("menuSelector")).click();
		//��λɾ����Ŀ��ť
		Thread.sleep(1*1000);
		driver.findElement(By.partialLinkText("ɾ�� Project")).click();
		Thread.sleep(1*1000);
		//ȷ�ϵ�����ť
		driver.switchTo().alert().accept();
	}
	
	public static void login(ChromeDriver driver) {
		driver.get("http://111.229.164.84:9527/jenkins");
		//��λ�û���
		driver.findElement(By.id("j_username")).sendKeys("lemon04");
		//��λ����
		driver.findElement(By.name("j_password")).sendKeys("123456");
		
		driver.findElement(By.className("Checkbox-text")).click();
		
		//��λ��¼��ť
		driver.findElement(By.name("Submit")).click();
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
