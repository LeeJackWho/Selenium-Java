package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import StartEngine.StartEngine_Excel;
import utility.Contants;
import utility.OrpUtil;

public class LoginKeyWords {
	public static WebDriver driver=null;
	
//	启动浏览器并最大化
	public static void OpenBrowser (String OR){
		
		
		try {
			System.setProperty("webdriver.chrome.driver", Contants.driverUrl);
			driver= new ChromeDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
			
		}
		
		
	}

//	打开开源中国网址
	public static void Navigate (String OR){
		driver.get(Contants.url);
	}
	
//	点击登录
	
	
	public static void Login_Click (String OR){
		try {
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	
//	输入用户名
	public static void Input_Name (String OR){
		try {
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).clear();
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).sendKeys(Contants.userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	
//	输入密码
	public static void Input_Password (String OR){
		try {
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).sendKeys(Contants.userPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	
//	点击登录按钮
	public static void Login_Button (String OR){
		try {
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}

	//	点击退出按钮
	public static void Logout_Click (String OR){
		try {
			Thread.sleep(600);
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
		
	}

//	关闭浏览器
	public static void CloseBrowser (String OR){
		driver.quit();
	}

}
