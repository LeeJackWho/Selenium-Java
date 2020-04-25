package com.bs.jenkins;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterTest {
	public static WebDriver driver;
	
	@Test
    public void jenkins_register() {
		ChromeDriver driver = init();
        //��Ϊ����FindBy����Ԫ�أ�������Ҫ����support���е�PageFactory����ҳ��Ԫ�س�ʼ��
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        //url��ת
        driver.get("http://localhost:9000/jenkins/signup");
        //�������
        driver.manage().window().maximize();
        registerPage.login_click();
    }

    @Test
    public void f2() {
        Assert.assertEquals("b", "b");
    }
    
    @AfterMethod
    public void quit(){
        driver.quit();
    }
    
    public static ChromeDriver init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		return driver;
	}
}
