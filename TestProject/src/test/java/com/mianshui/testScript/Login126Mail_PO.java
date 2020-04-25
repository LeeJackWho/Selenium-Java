package com.mianshui.testScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mianshui.page.LoginPage;
import com.mianshui.util.ExcelUtil;
/*
 * ��λ���Ͳ��Դ�����룺��װ��page����
 * ������������Դ�����룺��ȡexcel�ļ�
 */
public class Login126Mail_PO {
    public static WebDriver driver;
    @Test
    public static void login126Mail() throws Exception {
        //��������·��
        String     excelPath= "E:\\�������\\��ҵ���\\eclipse-jee-2019-03-R-win32-x86_64\\eclipse\\eclipse-workspace\\TestProject\\src\\test\\java\\com\\mianshui\\data\\126MailLoginCase.xlsx";
        //��ȡ����sheetҳ
        ExcelUtil.setExcelFile(excelPath, "login");        
        //�������
        String BrowserName=ExcelUtil.getCellData(1, 4);
        if (BrowserName.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
        }else if (BrowserName.equalsIgnoreCase("chrome")) {
            driver=new ChromeDriver();
        }
        
        //������ַ
        driver.get(ExcelUtil.getCellData(2, 4));
        //�л�frame
        driver.switchTo().frame("x-URS-iframe");
        
        //��ʼ��pageҳ��(ע�⣺Ҫ���ڴ������֮��)
        LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
        //�����˻�
        loginPage.inputUsername(ExcelUtil.getCellData(3, 4));
        //��������
        loginPage.inputPwd(ExcelUtil.getCellData(4, 4));
        //������¼
        loginPage.clickLoginButton(null);
        //����������¼
        Thread.sleep(3000);
        loginPage.continueLogin(null);
        //���Ե�¼�Ƿ�ɹ�
//        Thread.sleep(2000);
//        Assert.assertEquals(mainPage.getEmailAdd(), ExcelUtil.getCellData(3, 4)+"@126.com");
    }
    
    @BeforeMethod
    public static void  beforeMethod(){
        
    }
    
    @AfterMethod
    public static void  afterMethod(){
        driver.quit();
    }
}