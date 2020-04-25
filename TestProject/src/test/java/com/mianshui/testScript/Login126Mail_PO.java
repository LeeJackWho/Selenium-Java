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
 * 定位语句和测试代码分离：封装在page类中
 * 测试数据与测试代码分离：读取excel文件
 */
public class Login126Mail_PO {
    public static WebDriver driver;
    @Test
    public static void login126Mail() throws Exception {
        //定义用例路径
        String     excelPath= "E:\\软件测试\\毕业设计\\eclipse-jee-2019-03-R-win32-x86_64\\eclipse\\eclipse-workspace\\TestProject\\src\\test\\java\\com\\mianshui\\data\\126MailLoginCase.xlsx";
        //读取用例sheet页
        ExcelUtil.setExcelFile(excelPath, "login");        
        //打开浏览器
        String BrowserName=ExcelUtil.getCellData(1, 4);
        if (BrowserName.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
        }else if (BrowserName.equalsIgnoreCase("chrome")) {
            driver=new ChromeDriver();
        }
        
        //输入网址
        driver.get(ExcelUtil.getCellData(2, 4));
        //切换frame
        driver.switchTo().frame("x-URS-iframe");
        
        //初始化page页面(注意：要放在打开浏览器之后)
        LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
        //输入账户
        loginPage.inputUsername(ExcelUtil.getCellData(3, 4));
        //输入密码
        loginPage.inputPwd(ExcelUtil.getCellData(4, 4));
        //单击登录
        loginPage.clickLoginButton(null);
        //单击继续登录
        Thread.sleep(3000);
        loginPage.continueLogin(null);
        //断言登录是否成功
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