package com.selenium.testcases;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//
//import io.qameta.allure.Feature;
//@Feature("github测试用例")
public class GithubTestCases {
	
	WebDriver driver;
	List<String> repositories_names=new ArrayList<String>();
	@BeforeClass
	public void initDriver() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test001_login() throws Exception {
		try {
			driver.findElement(By.id("login_field")).sendKeys("shamotest");
			driver.findElement(By.id("password")).sendKeys("ABC28798qaz");
			driver.findElement(By.name("commit")).click();
			Thread.sleep(5000);
//			if(driver.getPageSource().contains("Learn Git and GitHub without any code")) {
//				System.out.println("登录成功");
//			}else {
//				System.out.println("登录失败");
//			}
			Assert.assertEquals(driver.getPageSource().contains("Learn Git and GitHub without any code"), true);
		} catch (Exception |Error e) {
			// TODO: handle exception
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("images/githubloginfailure.png"));
//			Reporter.log("<a href=../images/testfanloginfailure.png target=_blank>失败截图</a>", true);  
//			Reporter.log("<img src=../images/testfanloginfailure.png style=width:30px;height:30px img/>", true);
			Assert.fail(e.getMessage());
		}

	}
	
	@Test(dependsOnMethods = "test001_login")
	public void test002_create() throws Exception {

		
		//先获取现有的
		driver.get("https://github.com/shamotest?tab=repositories");
		List<WebElement> repositories = driver.findElements(By.cssSelector("a[itemprop='name codeRepository']"));
		//List<String> repositories_names=new ArrayList<String>();
		for(WebElement w: repositories) {
			repositories_names.add(w.getText().trim());
		}
		
		
		driver.findElement(By.className("octicon-plus")).click();
		driver.findElement(By.partialLinkText("New repository")).click();
		
		//随机生成一个响应库名称
		
		String name="";
		int i=100;
		while(i>0) {
			int j=(int) (Math.random()*100);
			name="testabc"+j;
			if(repositories_names.contains(name)) {
				i--;
			}else {
				break;
			}
		}
		
		driver.findElement(By.id("repository_name")).sendKeys(name);
		driver.findElement(By.cssSelector(".btn.btn-primary.first-in-line")).click();
		String url="https://github.com/shamotest/"+name;
		Thread.sleep(5000);
		String currentUrl=driver.getCurrentUrl();
//		if(url.equals(currentUrl)) {
//			System.out.println("创建成功");
//		}else {
//			System.out.println("创建失败");
//		}
		Assert.assertEquals(url.equals(currentUrl), true);
	}
	@Test(dependsOnMethods = "test001_login")
	public void test003_change() throws Exception {
		driver.get("https://github.com/");
		driver.findElement(By.className("dashboard-underlined-link")).click();
		driver.findElement(By.partialLinkText("Settings")).click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("aaa")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new_name")));
		driver.findElement(By.name("new_name")).clear();
		
		int k=(int) (Math.random()*repositories_names.size());
		
		driver.findElement(By.name("new_name")).sendKeys(repositories_names.get(k));
		WebElement error=driver.findElement(By.className("error"));
		String text=error.getText();
		if(text.equals("The repository "+repositories_names.get(k)+" already exists on this account")) {
			System.out.println("重复验证提示正确");
		}else {
			System.out.println("重复验证提示失败");
		}
		
		String name="";
		int i=100;
		while(i>0) {
			int j=(int) (Math.random()*100);
			name="testabc"+j;
			if(repositories_names.contains(name)) {
				i--;
			}else {
				break;
			}
		}
		
		driver.findElement(By.name("new_name")).sendKeys(name);
		driver.findElement(By.className("flex-self-end")).click();
		Thread.sleep(3000);
		String title=driver.getTitle();
//		if(title.equals("shamotest/"+name)) {
//			System.out.println("修改正确");
//		}else {
//			System.out.println("修改失败");
//		}
		Assert.assertEquals(title.equals("shamotest/"+name), true);
	}
	
	
	@AfterClass
	public void quit() {
		driver.quit();
	}

}
