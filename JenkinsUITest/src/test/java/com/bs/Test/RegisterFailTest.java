
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

public class RegisterFailTest {
	WebDriver driver;

	/**
	 * web�Զ�����ʼ���������������������λ�ã�������������
	 * 
	 * @return
	 */
	@BeforeClass
	@Step("��ʼ��")
	public void initDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9000/jenkins/signup");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
//	public void test002_register() throws Exception  {
//		//׼������
//		ChromeDriver driver = init();
//		//ע��ʧ��
//		registerNull(driver);
//		//���ٹ���
//		finish(driver);
//	}

	/**
	 * ʵ��ע��ģ����Զ���
	 * 
	 * @param driver
	 * @throws Exception
	 */
	@Test(description = "ע���û���Ϊ��")
	@Description("ע�������Ϊ�ղ�������")
	public void test002_registerNull() throws Exception {
		// ��λ�������˺Ű�ť
		WebElement registerButton = driver.findElement(By.className("submit-button"));
		// ������ע����Ϣֱ�ӵ��ע�ᰴť����
		registerButton.isEnabled();
		registerButton.click();
		// �ж�UI״̬
		List<WebElement> inputHeader = driver.findElements(By.className("inputHeader"));
		for (WebElement iH : inputHeader) {
//			System.out.println(iH.getText());
			String dangermsg = iH.getText();
			if (dangermsg.equals("�û��� - \"\" is prohibited as a username for security reasons.")) {
				System.out.println("�û���Ϊ��UI��ʾ����");
			} else if (dangermsg.equals("ȫ�� - \"\" is prohibited as a full name for security reasons.")) {
				System.out.println("ȫ������Ϊ��UI��ʾ����");
			} else if (dangermsg.equals("���� - Invalid e-mail address")) {
				System.out.println("��������Ϊ��UI��ʾ����");
			} else if (dangermsg.contains("���� - Password is required")) {
				System.out.println("��������Ϊ��UI��ʾ����");
			}
		}
	}

	@Test(dependsOnMethods = "test002_registerNull")
	@Description("ע����������������")
	public void test003_registerError() throws Exception {
		driver.get("http://localhost:9000/jenkins/signup");
		// ��λ���û���
		WebElement registerUsername = driver.findElement(By.id("username"));
		// ��λ�������˺Ű�ť
		WebElement registerButton = driver.findElement(By.name("Submit"));
		// ���������û���aaa
		registerUsername.sendKeys("aaa");
		// ȫ�ƺ�����û���κ��ַ��ֳ����ƣ�����ֻҪ��@������������
		// ���ע�ᰴťʱ�ж�
		registerButton.click();
		// �ж�UI״̬
		WebElement UserIsTaken = driver.findElement(By.xpath("//*[@id='main-panel']/div[1]/div/label"));
		Assert.assertNotSame(UserIsTaken.getText(), "�û��� - User name is already taken", "�û����Ѵ���UI����");
	}

	@Test(dependsOnMethods = "test002_registerNull")
	@Description("ע����������ǿ�Ȳ�������")
	public void test003_registerPasswordStrength() throws Exception {
		driver.get("http://localhost:9000/jenkins/signup");
		// ��λ������
		WebElement registerPassword = driver.findElement(By.id("password1"));
		WebElement pwStrength = driver.findElement(By.id("passwordStrength"));
		// ǿ��Ϊ����
		registerPassword.sendKeys("123");
		String text0 = pwStrength.getText();
		if (text0.equals("����")) {
			System.out.println("���������ǿ��Ϊ����UI��ʾ����");
		}
		// ǿ��Ϊ��
		registerPassword.clear();
		registerPassword.sendKeys("123456");
		String text1 = pwStrength.getText();
		if (text1.equals("��")) {
			System.out.println("���������ǿ��Ϊ��UI��ʾ����");
		}
		// ǿ��Ϊ����
		registerPassword.clear();
		registerPassword.sendKeys("123456asdzx");
		String text2 = pwStrength.getText();
		if (text2.equals("����")) {
			System.out.println("���������ǿ��Ϊ����UI��ʾ����");
		}
		// ǿ��Ϊǿ
		registerPassword.clear();
		registerPassword.sendKeys("123456asdx!@!");
		String text3 = pwStrength.getText();
		if (text3.equals("ǿ")) {
			System.out.println("���������ǿ��ΪǿUI��ʾ����");
		}
	}

	/**
	 * web�Զ���������,��Ϣ5���к��˳����������
	 * 
	 * @param driver
	 */
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