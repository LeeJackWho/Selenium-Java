package com.lemon.laction;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ʹ��seleniumԭ��api��λԪ��
 * @author LJH
 *
 */
public class NativeAPI {

	public static void main(String[] args) throws Exception {
		//�������������
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		//��������
		ChromeDriver driver = new ChromeDriver();
		//��������������ַ
		driver.get("http://111.229.164.84:9527/jenkins");
		//��λԪ��
		/*
		 * By.id				ͨ��id���Զ�λԪ��
		 * By.name				ͨ��name���Զ�λԪ��
		 * By.tagName			ͨ����ǩ����λԪ��
		 * By.className			ͨ��class���Զ�λԪ��
		 * By.linkText			ͨ�������ı�HTML�е�a��ǩ��ֵ��λԪ��
		 * By.partialLinkText	ͨ�������ı�ģ����λԪ��
		 * 
		 * findElement��findElements����
		 * findElementҳ����������ҵ���һ��Ԫ�ز�����
		 * findElements��ȡҳ��������ͬ�����Ե�Ԫ�أ�����һ�����϶��󣬼���˳��Ҳ�Ǵ�������
		 * 
		 * ��������
		 * 1������ʹ��ԭ��api�����Ԫ����id��������ʹ��id��λ
		 * 2�������쳣
		 * 		a��Ԫ�ز��ɼ��򲻿ɻ���
		 * 			org.openqa.selenium.ElementNotInteractableException:element not interactable
		 * 			org.openqa.selenium.ElementNotInteractableException:Element is not visible
		 * 		b����λ�����쳣���Ҳ���Ԫ��
		 * 			org.openqa.selenium.NoSuchElementException:no such element:Unable to locate element:
		*/
		//����ͨ��id�ҵ�Ԫ�أ�����Ϊ�÷������ݡ�
//		driver.findElement(By.id("j_username")).sendKeys("lemon");
//		driver.findElement(By.name("j_password")).sendKeys("123456");
//		driver.findElement(By.tagName("input")).sendKeys("abc");
//		List<WebElement> list = driver.findElements(By.tagName("input"));
		//����=��ͷ��β��ȡԪ��   1 2 3 4
//		for (WebElement e : list) {
//			System.out.println(e.getAttribute("type"));
//		}
		//����ͨ��class�ҵ�Ԫ�أ����ҵ����Ԫ��
//		driver.findElement(By.className("submit-button")).click();
		
//		driver.findElement(By.linkText("����һ���û��˺�")).click();
//		
//		Thread.sleep(2*1000);
//		
//		driver.findElement(By.partialLinkText("���")).click();
		
		//typeΪhidden��disable�ܹ���λ���ܲ���
		driver.findElement(By.name("from2222")).sendKeys("123456");
		
		//�ֶ�ֹͣ3��
		Thread.sleep(3*1000);
		//�ر�����
		driver.quit();
	}

}
