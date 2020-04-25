package com.selenium.study;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GithubTest {

	//��������
	WebDriver driver;
	//�������췽����ʼ��Driver
	public GithubTest() {
		driver = new ChromeDriver();
		//��������
		driver.manage().window().maximize();
		//������ַ
		driver.get("https://github.com/login");
		//��ʽ�ȴ���ȫ�ֲ���Ԫ��
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//GitHub��¼
	public void login() throws Exception {
		driver.findElement(By.id("login_field")).sendKeys("666");
		driver.findElement(By.id("password")).sendKeys("666");
		driver.findElement(By.className("commit")).click();
		Thread.sleep(5000);
		//��ȡ��������Դ���ж��Ƿ������֣�if�����е�����Ϊbooleanֵ
		if(driver.getPageSource().contains("666")) {
			System.out.println("��¼�ɹ�");
		}else {
			System.out.println("��¼ʧ��");
		}
	}
	
	//����respostiry
		public void create() throws Exception {
			driver.findElement(By.className("octicon-plus")).click();
			//�����Ӽ�a��ǩ�������ݽ��ж�λ
			driver.findElement(By.partialLinkText("New repository")).click();
			driver.findElement(By.id("repository_name")).sendKeys("testabc7");
			driver.findElement(By.cssSelector(".btn.btn-primary.first-in-line")).click();
			String url="https://github.com/shamotest/testabc7";
			Thread.sleep(5000);
			//��ȡ��ǰurl��ַ���жԱ�
			String currentUrl=driver.getCurrentUrl();
			if(url.equals(currentUrl)) {
				System.out.println("�����ɹ�");
			}else {
				System.out.println("����ʧ��");
			}

		}
		
	//�޸�respostiry
		public void change() throws Exception {
			driver.get("https://github.com/");
			driver.findElement(By.className("dashboard-underlined-link")).click();
			driver.findElement(By.partialLinkText("Settings")).click();
			//��ʽ�ȴ�����ʽ�ȴ�����ʽ�ȴ�ͬʱ���֣�������ʽ
			WebDriverWait wait=new WebDriverWait(driver, 20);
			//�ȴ�Ԫ�س���
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("aaa")));
			//�ȴ�Ԫ�ؿ���
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new_name")));
			//������������
			driver.findElement(By.name("new_name")).clear();
			driver.findElement(By.name("new_name")).sendKeys("testabc6");
			WebElement error=driver.findElement(By.className("error"));
			//�ж������Ƿ��ظ�
			String text=error.getText();
			if(text.equals("The repository testabc6 already exists on this account")) {
				System.out.println("�ظ���֤��ʾ��ȷ");
			}else {
				System.out.println("�ظ���֤��ʾʧ��");
			}
			driver.findElement(By.name("new_name")).sendKeys("testabc8");
			driver.findElement(By.className("flex-self-end")).click();
			Thread.sleep(3000);
			//��ȡ����title���ж���
			String title=driver.getTitle();
			if(title.equals("shamotest/testabc8")) {
				System.out.println("�޸���ȷ");
			}else {
				System.out.println("�޸�ʧ��");
			}
			
		}
		//����main��������������������
		public static void main(String[] args) throws Exception {
			//�������ʵ��������
			GithubTest github=new GithubTest();
			github.login();
			//github.create();
			github.change();
		}

}
