package com.bs.jenkins;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * ��¼�ű��ع����װ
 * �ع�����ͨ������������룬�������ı����������
 * �ﵽ����������������ܣ�ʹ�������ģʽ�ͼܹ������������ݱ���⣬��������չ�Ժ�ά����
 * Ϊʲô�����ع���1.�Ľ������� 2.��������� 3.���Ч��
 * ��װ��By��findElement�ķ�������ʹ�ö�ȡ�ⲿ�ļ���ҳ��Ԫ�ش���������������
 * ʹ��HashMap����������ʧ�ܣ�ֻ��ͨ��main�������ν��е����˺Ų�����
 * */
public class JenkinsLogin1 {
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
	public void loginScript(String username,String password) throws Exception {
		//ֱ�ӵ��ó�ʼ��driver
		this.InitDriver();
		//���������������
//		String userBy = "id";
//		String userElement = "j_username";
//		String passwordBy = "name";
//		String passwordElement = "j_password";
//		String loginbuttonBy = "name";
//		String loginbuttonElement = "Submit";
//		String headerBy = "className";
//		String headerElement = "model-link";
		
		//��λ����򲢶������
		//WebElement loginUser = driver.findElement(By.id(userElement));
		//this��ʾ���õ�ǰ���󣬶�ȡ�����ļ�element.properties����ҳ��Ԫ�صĹ���
		WebElement loginUser = this.element(this.byStr("userInput"));
		//��������״̬�Ƿ���ʾ
		loginUser.isDisplayed();
		//WebElement loginPassword = driver.findElement(By.name(passwordElement));
		WebElement loginPassword = this.element(this.byStr("passwordInput"));
		loginPassword.isDisplayed();
		//WebElement loginButton = driver.findElement(By.name(loginbuttonElement));
		WebElement loginButton = this.element(this.byStr("loginButton"));
		loginButton.isDisplayed();
		//��¼����
		loginUser.sendKeys(username);
		loginPassword.sendKeys(password);
		loginButton.click();
		//�ȴ�����3��
		Thread.sleep(3000);
		//�ڵ�¼�ɹ�ҳ���ȡ״̬
		//WebElement header = driver.findElement(By.className(headerElement));
		WebElement header = this.element(this.byStr("header"));
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
	
	public static void main(String[] args) throws Exception {
		//ʵ����JenkinsLogin��
		JenkinsLogin1 login = new JenkinsLogin1();
		//���е�¼�ű�
		login.loginScript("aaa","aaaaa");
		/**
		 * ʹ��HashMap������
		 * key-value
		 * */
//		HashMap<String,String> user = new HashMap<String,String>();
//		//��ע��������¼
//		user.put("aaa", "aaaaa");
//		//�������
//		user.put("aaa", "aa");
//		//��������ȡ����ֵ
//		Iterator us = user.entrySet().iterator();
//		while(us.hasNext()) {
//			Map.Entry entry = (Map.Entry) us.next();
//			String username = entry.getKey().toString();
//			String password = entry.getValue().toString();
//			System.out.println(username+"���룺"+password);
//			login.loginScript(username, password);
//		}
		//�ر���������ֹ�ڴ�ռ��
		login.QuitDriver();
	}
}
