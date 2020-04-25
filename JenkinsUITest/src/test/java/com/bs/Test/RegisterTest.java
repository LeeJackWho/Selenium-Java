package com.bs.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class RegisterTest {

	@Test(description = "ע���û�")
	@Description("�ɹ�ע���������")
	public void test001_register() throws Exception  {
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
	@Step("ע��")
	public static void register(ChromeDriver driver) throws Exception {
		//ע��
		//����ע��ҳ��
		driver.get("http://localhost:9000/jenkins/signup");
		//��λ���û���
		WebElement registerUsername = driver.findElement(By.id("username"));
		//��λ��ȫ��
		WebElement registerFullname = driver.findElement(By.id("fullname"));
		//��λ������
		WebElement registerEmail = driver.findElement(By.id("email"));
		//��λ������
		WebElement registerPassword = driver.findElement(By.id("password1"));
		//��λ�������˺Ű�ť
		WebElement registerButton = driver.findElement(By.name("Submit"));
		//���UI״̬�Ƿ���ʾ
		registerUsername.isDisplayed();
		registerFullname.isDisplayed();
		registerEmail.isDisplayed();
		registerPassword.isDisplayed();
		registerButton.isEnabled();
		//ע�����
		registerUsername.sendKeys("lemon04");
		registerFullname.sendKeys("С����");
		registerEmail.sendKeys("lemon02@QQ.COM");
		registerPassword.sendKeys("123456");
		registerButton.click();
		// ��ע��ɹ����Զ���¼
		WebElement header = driver.findElement(By.className("model-link"));
		header.isDisplayed();
		// ��ȡ��¼�ɹ����û���Ϣ
		String UserInfo = header.getText();
		//�ж��Ƿ�ע��ɹ�
		if (UserInfo.equals("С����")) {
			System.out.println("ע��ɹ�");
		} else {
			System.out.println("ע��ʧ��");
		}
		Thread.sleep(2*1000);
		//ע��ɹ�֮�󣬶�λע����ť
		WebElement Logout = driver.findElement(By.partialLinkText("ע��"));
		Logout.click();
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}
