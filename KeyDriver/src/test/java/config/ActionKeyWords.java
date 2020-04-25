package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionKeyWords {
    public static WebDriver driver=null;
//    ��������������
    public static void OpenBrowser (String OR){
        System.setProperty("webdriver.chrome.driver", ".//server//chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
//    �򿪿�Դ�й���ַ
    public static void Navigate (String OR){
        driver.get(Contants.url);
    }
//    �����¼
    public static void Login_Click (String OR){
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
    }
//    �����û���
    public static void Input_Name (String OR){
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).clear();
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).sendKeys(Contants.userName);
    }
//    ��������
    public static void Input_Password (String OR){
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).sendKeys(Contants.userPassword);
    }
//    �����¼��ť
    public static void Login_Button (String OR){
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
    }
    //    ����˳���ť
    public static void Logout_Click (String OR){
        try {
            Thread.sleep(300);
            driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//    �ر������
    public static void CloseBrowser (String OR){
        driver.quit();
    }
}
