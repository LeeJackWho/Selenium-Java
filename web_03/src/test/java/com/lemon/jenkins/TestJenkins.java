package com.lemon.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestJenkins {
	public static void main(String[] args) throws Exception {
		//׼������
		ChromeDriver driver = init();
		//ע��
//		register(driver);
		//��¼
		//���ʵ�¼ҳ��
		login(driver);
		//������Ŀ
//		addItem(driver);
		//ɾ����Ŀ
		//������Ŀ��ҳ
//		deleteItem(driver);
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
		driver.findElement(By.partialLinkText("ɾ�� Project")).click();
		Thread.sleep(1*1000);
		//ȷ�ϵ�����ť
		driver.switchTo().alert().accept();
	}
	
	public static void addItem(ChromeDriver driver) throws Exception {
		//������ҳ
		driver.get("http://111.229.164.84:9527/jenkins");
		//���������Ŀ��ť
		driver.findElement(By.linkText("�½�Item")).click();
		Thread.sleep(2*1000);
		//��λ������Ŀ
		driver.get("http://111.229.164.84:9527/jenkins/view/all/newJob");
		//����һ����������
		driver.findElement(By.id("name")).sendKeys("web��Ŀ");
		//ѡ����Ŀ����
		driver.findElement(By.className("hudson_model_FreeStyleProject")).click();
		//���ȷ�ϰ�ť
		driver.findElement(By.id("ok-button")).click();
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
