package com.selenium.study;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestfanTests {
	WebDriver driver;
	public TestfanTests(WebDriver driver) {
		this.driver=driver;
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://ask.testfan.cn/");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	//第三方登录
	public void login() {
		driver.findElement(By.linkText("登录")).click();
		driver.findElement(By.cssSelector(".btn.btn-default.btn-sm.btn-sn-qq")).click();
		driver.switchTo().frame(0);//使用索引切换frame
		
		//先定位iframe元素
//		WebElement iframe163 = driver.findElement(By.cssSelector("iframe[frameborder='0']"));
//		driver.switchTo().frame(iframe163);
//		
//		driver.switchTo().defaultContent();//回到初始的frame
		
		driver.findElement(By.cssSelector("#img_out_2879897713")).click();
		//判断是否登录成功，调用Utils类中的elementIsExist方法判断元素是否存在
		if(Utils.elementIsExist(driver, By.cssSelector("#unread_messages"))) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	}
	
	//修改个人资料
	public void changePersonInfo() {
		driver.findElement(By.cssSelector(".dropdown.user-avatar")).click();
		driver.findElement(By.linkText("账号设置")).click();
		driver.findElement(By.cssSelector("input[name='name']")).clear();
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("沙陌大神");
		
		//选性别
		List<WebElement> genders = driver.findElements(By.cssSelector("input[name='gender']"));
		for(WebElement w:genders) {
			if(!w.isSelected()) {
				w.click();
				break;
			}
		}
		
		//使用js开取消输入框的点击绑定事件，然后再输入
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("$('#birthday').unbind();");
		
		//生日
		WebElement birthday = driver.findElement(By.cssSelector("#birthday"));
		birthday.clear();
		birthday.sendKeys("1993-10-23");
		
		//先选省份
		
		
		Select province=new Select(driver.findElement(By.cssSelector("#province")));
		int i=(int) (Math.random()*province.getOptions().size())-1;
		//province.selectByVisibleText("山西");
		province.selectByIndex(i);
		String provinceName=province.getFirstSelectedOption().getText();
		
		
		
		//选城市
		Select city=new Select(driver.findElement(By.cssSelector("#city")));
		int j=(int) (Math.random()*city.getOptions().size())-1;
		//province.selectByVisibleText("山西");
		city.selectByIndex(j);
		String cityName=province.getFirstSelectedOption().getText();
		//city.selectByVisibleText("晋城");
		
		//点击提交
		driver.findElement(By.cssSelector(".btn.btn-xl.btn-primary.profile-sub")).click();
		
		Select province1=new Select(driver.findElement(By.cssSelector("#province")));
		System.out.println(province1.getFirstSelectedOption().getText());
	}
	//评论
	public void comment() {
		String currentHandle=driver.getWindowHandle();//当前handle
		driver.findElement(By.linkText("如何用appium设置设备的网络状态")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String s:windowHandles) {
			if(!s.equals(currentHandle)) {
				driver.switchTo().window(s);
				break;
			}
		}
		
		driver.findElement(By.cssSelector("#comment-article-content-3")).sendKeys("这篇文章已经过时");
		driver.findElement(By.cssSelector("#article-comment-3-btn")).click();
		
		//验证
		List<WebElement> comments = driver.findElements(By.cssSelector(".content>p"));
		String text=comments.get(comments.size()-1).getText();
		if("这篇文章已经过时".equals(text)) {
			System.out.println("评论成功");
		}else {
			System.out.println("评论失败");
		}
	}
	
	public static void main(String[] args) {
//		TestfanTests testfan=new TestfanTests();
//		testfan.login();
//		//testfan.changePersonInfo();
//		testfan.comment();
	}
}
