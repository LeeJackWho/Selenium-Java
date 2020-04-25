package com.lemon.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class AddItemTest {

	@Test(description = "������Ŀ")
	@Description("������Ŀ22222222222222")
	public void test() throws Exception  {
		//׼������
		ChromeDriver driver = init();
		//��¼
		login(driver);
		//������Ŀ
		addItem(driver);
		//���ٹ���
		finish(driver);
	}
	
	@Step("������Ŀ")
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
	
	@Step("��¼")
	public static void login(ChromeDriver driver) {
		driver.get("http://111.229.164.84:9527/jenkins");
		//��λ�û���
		driver.findElement(By.id("j_username")).sendKeys("lemon04");
		//��λ����
		driver.findElement(By.name("j_password")).sendKeys("123456");
		//�Ƿ񱣳ֵ�¼
		driver.findElement(By.className("Checkbox-text")).click();
		
		//��λ��¼��ť
		driver.findElement(By.name("Submit")).click();
	}
	
	/**
	 * web�Զ���������,��Ϣ5���к��˳����������
	 * @param driver
	 */
	@Step("�ر����������")
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
	@Step("��ʼ��")
	public static ChromeDriver init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		return driver;
	}
}
