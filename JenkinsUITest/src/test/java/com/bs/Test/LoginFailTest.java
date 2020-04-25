package com.bs.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class LoginFailTest {
	WebDriver driver;
	
	@BeforeClass
	@Step("��ʼ��")
	public void initDriver() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9000/jenkins/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(description = "ʧ���û���¼")
	@Description("��¼�û�����������������")
	public void test002_login() throws Exception {
		//���ʵ�¼ҳ��
		driver.get("http://localhost:9000/jenkins/login");
		//���������û���������
		//������ֱ�ӵ������¼����ť
		WebElement loginButton = driver.findElement(By.className("submit-button"));
		loginButton.click();
		//����Ƿ�ᵯ�����û��������������ʾ
		WebElement dangerAlert = driver.findElement(By.className("alert"));
		Assert.assertEquals(dangerAlert.getText(), "�û������������");
		//����û��������������class�Ƿ��Ϊdanger����
		List<WebElement> Inputs = driver.findElements(By.className("danger"));
		for(WebElement i:Inputs) {
			i.isDisplayed();
			System.out.println("className����Ϊdanger�������" + i.getAttribute("placeholder"));
		}
	}
	
	@AfterClass
	@Step("�ر����������")
	public void finish() {
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
