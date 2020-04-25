package com.bs.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class DeleteItemTest {

	@Test(description = "ɾ����Ŀ")
	@Description("�ɹ�ɾ����Ŀ��������")
	public void test() throws Exception  {
		//׼������
		ChromeDriver driver = init();
		//��¼
		login(driver);
		//������Ŀ
		deleteItem(driver);
		//���ٹ���
		finish(driver);
	}
	
	public static void deleteItem(ChromeDriver driver) throws Exception {
		//������Ŀ��ҳ
		driver.get("http://localhost:9000/jenkins/");
		//������ƶ�����Ŀ�����ϡ�
		//���������̶���
		Actions action = new Actions(driver);
		//��Ŀ��λ
		WebElement ItemName = driver.findElement(By.linkText("web��Ŀ"));
		ItemName.isDisplayed();
		//�ƶ���굽web��ĿԪ����
		action.moveToElement(ItemName).perform();
		//�����������
		WebElement Triangle = driver.findElement(By.id("menuSelector"));
		Triangle.isDisplayed();
		Triangle.click();
		//��λɾ����Ŀ��ť
		Thread.sleep(1*1000);
		WebElement deleteItemButton = driver.findElement(By.partialLinkText("ɾ�� Project"));
		deleteItemButton.isDisplayed();
		deleteItemButton.click();
		Thread.sleep(1*1000);
		//ȷ�ϵ�����ť
		driver.switchTo().alert().accept();
		//�ж��Ƿ�ɾ��ʧ�ܣ�ûɾ��ʧ��˵��ɾ���ɹ�
		WebElement tableElement = driver.findElement(By.xpath("//*[@id='projectstatus']/tbody"));
		//����������tr�Ž��б�ÿ��tr�Ǳ���һ�У����б���
        List<WebElement> rows=tableElement.findElements(By.tagName("tr"));
        for (int i = 0; i < rows.size(); i++) {
            //������td�Ž�list�ÿ��td�Ǳ���һ�У����б���
            List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
            for (int j = 2; j < cols.size();) {
                String tdText = cols.get(j).getText();
                Thread.sleep(1000);
//                System.out.println(tdText +"\t");
                j = j+7;
                //�ж��Ƿ�����Ŀ��, ���������ɾ��ʧ��
                if(tdText.equals("web��Ŀ")){
                    System.out.println("ɾ��ʧ��");
                }break;
            }
        }
	}
	
	public static void login(ChromeDriver driver) {
		driver.get("http://localhost:9000/jenkins/login");
		//��λ�û���
		driver.findElement(By.id("j_username")).sendKeys("lemon04");
		//��λ����
		driver.findElement(By.name("j_password")).sendKeys("123456");
		//�����ѡ���ֵ�¼
		driver.findElement(By.className("Checkbox-text")).click();
		//��λ��¼��ť
		driver.findElement(By.name("Submit")).click();
	}
	
	/**
	 * web�Զ���������,��Ϣ5���к��˳����������
	 * @param driver
	 */
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
	public static ChromeDriver init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
