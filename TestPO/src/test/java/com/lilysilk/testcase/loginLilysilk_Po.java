package com.lilysilk.testcase;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.lilysilk.page.LoginPage;
import com.lilysilk.util.ExcelUtil;

public class loginLilysilk_Po {
    public static WebDriver driver;
    @Test
    public void loginlily() throws Exception{
        //定义测试用例路径
        String excelPath="E:\\软件测试\\毕业设计\\eclipse-jee-2019-03-R-win32-x86_64\\eclipse\\eclipse-workspace\\TestPO\\src\\test\\java\\com\\lilysilk\\data\\lilysilk.xlsx";
        //读取测试用例sheet页
        ExcelUtil.setExcelFile(excelPath,"login");
        //打开浏览器
        String BrowserName=ExcelUtil.getCellData(1,4);
        //修改浏览器语言
          ChromeOptions op=new ChromeOptions();
          op.addArguments("--lang=en-US");
        //equals比较时,要比较大小写是否相同,equalsIgnoreCase,忽略了大小写,ignore就是忽略的意思
        if(BrowserName.equalsIgnoreCase("chrome")){
            //初始化浏览器实例
            driver=new ChromeDriver(op);
        }else {
            System.out.println("error type");;
        }
        //浏览器最大化
        driver.manage().window().maximize();
        //打开网址
        driver.get(ExcelUtil.getCellData(2, 4));
        //初始化page页面(注意：要放在打开浏览器之后)
        LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);

        loginPage.goLoginPage();
        loginPage.loginName("112233@qq.com");
        loginPage.loginPwd("112233@qq.com");
        loginPage.loginBtn();
    }
        @BeforeMethod
        public static void  beforeMethod(){
        }

         @AfterMethod
        public static void  afterMethod(){
           driver.close();
      }

}