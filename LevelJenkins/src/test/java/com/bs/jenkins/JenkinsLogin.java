package com.bs.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JenkinsLogin {
	public WebDriver driver;
	//��ʼ��driver
	public void InitDriver() {
		//���û���������driver����
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		//�򿪵�¼���Ե�ַ
		driver.get("http://localhost:9000/jenkins/login");
		//��������
		driver.manage().window().maximize();
	}
	public void QuitDriver() {
		driver.quit();
	}
	
	//��¼�ű���д
	public void loginScript() throws Exception {
		//��λ����򲢶������
		WebElement loginUser = driver.findElement(By.id("j_username"));
		//��������״̬�Ƿ���ʾ
		loginUser.isDisplayed();
		WebElement loginPassword = driver.findElement(By.name("j_password"));
		loginPassword.isDisplayed();
		WebElement loginButton = driver.findElement(By.name("Submit"));
		loginButton.isDisplayed();
		//��¼����
		loginUser.sendKeys("aaa");
		loginPassword.sendKeys("aaaaa");
		loginButton.click();
		//�ȴ�����3��
		Thread.sleep(3000);
		//�ڵ�¼�ɹ�ҳ���ȡ״̬
		WebElement header = driver.findElement(By.className("model-link"));
		header.isDisplayed();
		//��ȡ��¼�ɹ����û���Ϣ
		String UserInfo = header.getText();
//		System.out.println(UserInfo);
		//�ж��û���¼�ɹ�
		if(UserInfo.equals("����")) {
			System.out.println("��¼�ɹ�");
		}else {
			System.out.println("��¼ʧ��");
		}
	}
	public static void main(String[] args) throws Exception {
		//ʵ����JenkinsLogin��
		JenkinsLogin login = new JenkinsLogin();
		//���ó�ʼ��driver
		login.InitDriver();
		//���е�¼�ű�
		login.loginScript();
		//�ر���������ֹ�ڴ�ռ��
		login.QuitDriver();
	}
	
}
