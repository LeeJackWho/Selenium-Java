package com.lemon.laction;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ʹ��XPath��λԪ��  XML HTML�Ĳ㼶��ϵ��λ
 * 
 * @author LJH
 *
 */
public class XPathAPI {
	public static void main(String[] args) throws Exception {
		// �������������
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// ��������
		ChromeDriver driver = new ChromeDriver();
		// ��������������ַ
		driver.get("http://111.229.164.84:9527/jenkins");
		
		//	html	ѡȡHTML�������ӽڵ�
		//	/html	��HTML���ڵ�ѡȡ������·����
		//	//input	ѡȡ����input��ǩ�������������ǵ�λ��
		//	//*		ѡȡ�ĵ�������Ԫ��
		//	@id		ѡȡ����id����
		/*	
		 * 	������
		 * 	contains(args1,args2)������ĳ���ֶ�
		 * 		args1��λ�Ķ���
		 * 		args2����������
		 * 	text()����ȡ��ǩ֮����ı�����
		*/
		//���Զ�λ��/html[1]/body[1]/div[1]/form[1]/div[2]/input[1]
		//��Զ�λ��//input[@id='j_username']
		
		//XPATH ���Զ�λ
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys("lemon");
		//XPATH ��Զ�λ
		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("123456");
		
		// �ֶ�ֹͣ5��
		Thread.sleep(5 * 1000);
		// �ر�����
		driver.quit();
	}
}
