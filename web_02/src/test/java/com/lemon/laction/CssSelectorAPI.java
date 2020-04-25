package com.lemon.laction;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ʹ��cssSelector��λԪ�أ�ƫǰ�˶�λ��ʽ
 * ��ǰ����Ա�򽻵����������
 * 
 * @author LJH
 *
 */
public class CssSelectorAPI {
	public static void main(String[] args) throws Exception {
		// �������������
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// ��������
		ChromeDriver driver = new ChromeDriver();
		// ��������������ַ
		driver.get("http://111.229.164.84:9527/jenkins");
		
		/*
		 * #id					idѡ����
		 * .class				classNameѡ����
		 * element				��ǩԪ��ѡ����
		 * [attribute]			Ԫ������ѡ����
		 * [attribute=value]	Ԫ�����Ծ���ѡ����
		*/
		
		//cssselector id��λ
		driver.findElement(By.cssSelector("#j_username")).sendKeys("lemon");
		//cssselector ���Զ�λ
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("123456");
		//cssselector class��λ
		driver.findElement(By.cssSelector(".submit-button")).click();
		
		// �ֶ�ֹͣ5��
		Thread.sleep(5 * 1000);
		// �ر�����
		driver.quit();
	}
}