package com.po.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.po.page.loginPage;
import com.po.util.ExcelUtil;


public class loginTest {
	public static WebDriver driver;
    @Test
    public void loginlily() throws Exception{
        //�����������·��
        String excelPath="E:\\�������\\��ҵ���\\eclipse-jee-2019-03-R-win32-x86_64\\eclipse\\eclipse-workspace\\testProjectPo\\src\\test\\java\\com\\po\\data\\logindata.xlsx";
        //��ȡ��������sheetҳ
        ExcelUtil.setExcelFile(excelPath,"login");
        //�������
        String BrowserName=ExcelUtil.getCellData(1,4);
        //�޸����������
          ChromeOptions op=new ChromeOptions();
          op.addArguments("--lang=en-US");
        //equals�Ƚ�ʱ,Ҫ�Ƚϴ�Сд�Ƿ���ͬ,equalsIgnoreCase,�����˴�Сд,ignore���Ǻ��Ե���˼
        if(BrowserName.equalsIgnoreCase("chrome")){
            //��ʼ�������ʵ��
            driver=new ChromeDriver(op);
        }else {
            System.out.println("��������");
        }
        //��������
        driver.manage().window().maximize();
        //����ַ
        driver.get(ExcelUtil.getCellData(2, 4));
        //��ʼ��pageҳ��(ע�⣺Ҫ���ڴ������֮��)
        loginPage loginPage=PageFactory.initElements(driver, loginPage.class);

        loginPage.loginName("112233@qq.com");
        loginPage.loginPwd("112233@qq.com");
        loginPage.loginBtn();
    }
        @BeforeMethod
        public static void  beforeMethod(){
        }

         @AfterMethod
        public static void  afterMethod(){
           driver.quit();
      }

}