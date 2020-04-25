package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionKeyWords {
    public static WebDriver driver=null;
//    启动浏览器并最大化
    public static void OpenBrowser (String OR){
        System.setProperty("webdriver.chrome.driver", ".//server//chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
//    打开开源中国网址
    public static void Navigate (String OR){
        driver.get(Contants.url);
    }
//    点击登录
    public static void Login_Click (String OR){
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
    }
//    输入用户名
    public static void Input_Name (String OR){
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).clear();
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).sendKeys(Contants.userName);
    }
//    输入密码
    public static void Input_Password (String OR){
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).sendKeys(Contants.userPassword);
    }
//    点击登录按钮
    public static void Login_Button (String OR){
        driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
    }
    //    点击退出按钮
    public static void Logout_Click (String OR){
        try {
            Thread.sleep(300);
            driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//    关闭浏览器
    public static void CloseBrowser (String OR){
        driver.quit();
    }
}
