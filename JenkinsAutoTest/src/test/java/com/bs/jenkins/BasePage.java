/**
 * @Description: ����ҳ��Ԫ�ع����࣬��дҳ������¼���Ϊÿ��Ԫ�ؼ�����ʽ�ȴ�
 */
package com.bs.jenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
    private final int timeOut = 10;//�ȴ�ʱ��

    public BasePage(WebDriver basedriver) {
        // TODO Auto-generated constructor stub
		this.driver = basedriver;
    }
    
    /* ��дsenkeys���� */
    void sendkeys(WebElement element, String s) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));// ������ʽ�ȴ�
        element.clear();// ����������
        element.sendKeys(s);// ��������
    }

    /* ��дclick���� */
    void click(WebElement element) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));// ������ʽ�ȴ�
        element.click();
    }
}
