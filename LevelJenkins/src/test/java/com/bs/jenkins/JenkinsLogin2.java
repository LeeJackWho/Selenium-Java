package com.bs.jenkins;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 * ��¼�ű��ع����װ
 * �ع�����ͨ������������룬�������ı����������
 * �ﵽ����������������ܣ�ʹ�������ģʽ�ͼܹ������������ݱ���⣬��������չ�Ժ�ά����
 * Ϊʲô�����ع���1.�Ľ������� 2.��������� 3.���Ч��
 * ʹ����TestNG
 * ����ʧ�ܽ�ͼ������ͨ�������¼�ʵ��ʧ���Զ���ͼ
 * TestngListenerScreenshot����дʧ�ܽ�ͼ����
 * �̳���baseDriver����driver
 * �ѽ�ͼ�����ŵ����࣬��TestngListenerScreenshot����е���
 * */
@Listeners({TestngListenerScreenshot.class})
public class JenkinsLogin2 extends baseDriver{
//	public WebDriver driver;
	
	//��ʼ��driver
	//ʹ��TestNG
	@Test
	public void InitDriver() {
		//���û���������driver����
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		//�򿪵�¼���Ե�ַ
		driver.get("http://localhost:9000/jenkins/login");
		//��������
		driver.manage().window().maximize();
	}
	
	//��¼�ű���д
	@Test(dependsOnMethods= {"InitDriver"})
	public void loginScript() throws Exception {
		//��λ����򲢶������
		//this��ʾ���õ�ǰ���󣬶�ȡ�����ļ�element.properties����ҳ��Ԫ�صĹ���
		WebElement loginUser = this.element(this.byStr("userInput"));
		//��������״̬�Ƿ���ʾ
		loginUser.isDisplayed();
		WebElement loginPassword = this.element(this.byStr("passwordInput"));
		loginPassword.isDisplayed();
		WebElement loginButton = this.element(this.byStr("loginButton"));
		loginButton.isDisplayed();
		//��¼����
		loginUser.sendKeys("aaa");
		loginPassword.sendKeys("aaaaa");
		loginButton.click();
		//�ȴ�����3��
		Thread.sleep(3000);
		//�ڵ�¼�ɹ�ҳ���ȡ״̬
		WebElement header = this.element(this.byStr("header"));
		header.isDisplayed();
		//��ȡ��¼�ɹ����û���Ϣ
		String UserInfo = header.getText();
		//�ж��û���¼�ɹ�
		if(UserInfo.equals("����")) {
			System.out.println("��¼�ɹ�");
		}else {
			System.out.println("��¼ʧ��");
		}
	}
	
	//quit�ͷ�����
	@Test(dependsOnMethods= {"loginScript"})
	public void QuitDriver() {
		driver.quit();
	}
	
	/**
	 * ��װBy by �����������ֱ�Ϊ��λ��ʽ�Ͷ�λֵ�ı��������Ӿ��пɶ���
	 * */
	public By byStr(String keyName) {
		//��ȡ�ⲿ�ļ�
		ProUtil properties = new ProUtil("element.properties");
		String locator = properties.getPro(keyName);
		//ʹ��split�������ա�>���ָ����Ƭ
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		if(locatorType.equals("id")) {
			return By.id(locatorValue);
		}else if(locatorType.equals("name")) {
			return By.name(locatorValue);
		}else if(locatorType.equals("className")) {
			return By.className(locatorValue);
		}else if(locatorType.equals("linkText")) {
			return By.linkText(locatorValue);
		}else if(locatorType.equals("partialLinkText")) {
			return By.partialLinkText(locatorValue);
		}else if(locatorType.equals("tagName")) {
			return By.tagName(locatorValue);
		}else if(locatorType.equals("xpath")) {
			return By.xpath(locatorValue);
		}else if(locatorType.equals("cssSelector")) {
			return By.cssSelector(locatorValue);
		}else{
			return null;
		}
	}
	
	/**
	 * ��װfindElement
	 * */
	public WebElement element(By by) {
		WebElement ele = driver.findElement(by);
		return ele;
	}
	
}
