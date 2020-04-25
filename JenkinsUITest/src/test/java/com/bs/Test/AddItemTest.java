package com.bs.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class AddItemTest {

	@Test(description = "������Ŀ")
	@Description("�ɹ�������Ŀ��������")
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
		driver.get("http://localhost:9000/jenkins/");
		//���������Ŀ��ť
		WebElement addItemButton = driver.findElement(By.linkText("�½�Item"));
		addItemButton.isDisplayed();
		addItemButton.click();
		Thread.sleep(2*1000);
		//��λ������Ŀ
		driver.get("http://localhost:9000/jenkins/view/all/newJob");
		//����һ����������
		WebElement itemNameInput = driver.findElement(By.id("name"));
		itemNameInput.isDisplayed();
		itemNameInput.sendKeys("web��Ŀ");
		//ѡ����Ŀ����
		WebElement addItemType = driver.findElement(By.className("hudson_model_FreeStyleProject"));
		addItemType.isDisplayed();
		addItemType.click();
		//���ȷ�ϰ�ť
		WebElement addItemOk = driver.findElement(By.id("ok-button"));
		addItemOk.isEnabled();
		addItemOk.click();
		//������水ť
		WebElement addItemSave = driver.findElement(By.id("yui-gen26-button"));
		addItemSave.isEnabled();
		addItemSave.click();
		//�ж��Ƿ񴴽���Ŀ�ɹ�
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("web��Ŀ [Jenkins]")) {
			System.out.println("�����ɹ�");
		}else {
			System.out.println("����ʧ��");
		}
	}
	
	@Step("��¼")
	public static void login(ChromeDriver driver) {
		driver.get("http://localhost:9000/jenkins/login");
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
