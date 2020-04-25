package com.bs.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class LinkTest {
	@Test(description = "���Ӳ���")
	@Description("���Ӳ��Բ�������")
	public void linkTest() throws Exception{
		//׼������
		ChromeDriver driver = init();
		//���Ӳ���
		Link(driver);
		//���ٹ���
		finish(driver);
	}
	
	@Step("���Ӳ���")
	public static void Link(ChromeDriver driver) throws Exception {
		driver.get("http://localhost:9000/jenkins/");
		WebElement AddItemLink = driver.findElement(By.className("task-link"));
		AddItemLink.click();
		String ExpectAddItemUrl = "http://localhost:9000/jenkins/view/all/newJob";
		String currentUrl = driver.getCurrentUrl();
		//�ж��½�Item�������Ƿ���ת��ȷ
		Assert.assertEquals(ExpectAddItemUrl.equals(currentUrl), true);
		//��¼ҳ���ע����ת����
		driver.get("http://localhost:9000/jenkins/login");
		WebElement RegisterLink = driver.findElement(By.linkText("����һ���û��˺�"));
		RegisterLink.click();
		String ExpectRegisterUrl = "http://localhost:9000/jenkins/signup";
		String currentUrl1 = driver.getCurrentUrl();
		//�ж�ע��������Ƿ���ת��ȷ
		Assert.assertEquals(ExpectRegisterUrl.equals(currentUrl1), true);
		//ע��ҳ��ĵ�¼����
		WebElement LoginLink = driver.findElement(By.linkText("���¼"));
		LoginLink.click();
		String ExpectLoginUrl = "http://localhost:9000/jenkins/login";
		String currentUrl2 = driver.getCurrentUrl();
		//�ж�ע��������Ƿ���ת��ȷ
		Assert.assertEquals(ExpectLoginUrl.equals(currentUrl2), true);
	}
	
	/**
	 * web�Զ���������,��Ϣ5���к��˳����������
	 * @param driver
	 */
	@Step("�ر����������")
	public static void finish(ChromeDriver driver) {
		try {
			Thread.sleep(3*1000);
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
