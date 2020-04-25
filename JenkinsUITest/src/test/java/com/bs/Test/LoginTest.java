package com.bs.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class LoginTest {
	WebDriver driver;
	
	/**
	 * web�Զ�����ʼ���������������������λ�ã�������������
	 * 
	 * @return
	 */
//	@Step("��ʼ��")
//	public static ChromeDriver init() {
//		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
//		return driver;
//	}
	@BeforeClass
	@Step("��ʼ��")
	public void initDriver() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9000/jenkins/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//	@Test(description = "�û���¼")
//	@Description("�ɹ���¼��������")
//	public void test001_login() throws Exception {
//		// ׼������
//		ChromeDriver driver = init();
//		// ��¼
//		login(driver);
//		// ���ٹ���
//		finish(driver);
//	}

	/**
	 * ʵ�ֵ�¼ģ����Զ���
	 * 
	 * @param driver
	 * @throws Exception
	 */
	// ��¼�ű���д
	//�������û���������
	@Parameters({"loginusername","loginpassword"})
	@Test(description = "�û���¼")
	@Description("�ɹ���¼��������")
	public void test001_login(String loginusername,String loginpassword) throws Exception {
		//���ʵ�¼ҳ��
//		driver.get("http://localhost:9000/jenkins/login");
		// ��λ����򲢶������
		WebElement loginUser = driver.findElement(By.id("j_username"));
		// ���UI״̬�Ƿ���ʾ
		loginUser.isDisplayed();
		WebElement loginPassword = driver.findElement(By.name("j_password"));
		loginPassword.isDisplayed();
		WebElement loginButton = driver.findElement(By.name("Submit"));
		loginButton.isEnabled();
		// ��¼����
		loginUser.sendKeys(loginusername);
		loginPassword.sendKeys(loginpassword);
		loginButton.click();
		// �ȴ�����3��
		Thread.sleep(3000);
		// �ڵ�¼�ɹ�ҳ���ȡ״̬
		WebElement header = driver.findElement(By.className("model-link"));
		header.isDisplayed();
		// ��ȡ��¼�ɹ����û���Ϣ
		String UserInfo = header.getText();
//		System.out.println(UserInfo);
		// �ж��û���¼�ɹ�
		if (UserInfo.equals("����")) {
			System.out.println("��¼�ɹ�\n");
		} else {
			System.out.println("��¼ʧ��\\n");
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