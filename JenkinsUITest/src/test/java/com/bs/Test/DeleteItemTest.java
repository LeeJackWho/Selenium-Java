package com.bs.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class DeleteItemTest {

	@Test(description = "删除项目")
	@Description("成功删除项目测试用例")
	public void test() throws Exception  {
		//准备工作
		ChromeDriver driver = init();
		//登录
		login(driver);
		//新增项目
		deleteItem(driver);
		//销毁工作
		finish(driver);
	}
	
	public static void deleteItem(ChromeDriver driver) throws Exception {
		//访问项目首页
		driver.get("http://localhost:9000/jenkins/");
		//把鼠标移动到项目成名上。
		//创建鼠标键盘对象
		Actions action = new Actions(driver);
		//项目定位
		WebElement ItemName = driver.findElement(By.linkText("web项目"));
		ItemName.isDisplayed();
		//移动鼠标到web项目元素上
		action.moveToElement(ItemName).perform();
		//点击倒三角形
		WebElement Triangle = driver.findElement(By.id("menuSelector"));
		Triangle.isDisplayed();
		Triangle.click();
		//定位删除项目按钮
		Thread.sleep(1*1000);
		WebElement deleteItemButton = driver.findElement(By.partialLinkText("删除 Project"));
		deleteItemButton.isDisplayed();
		deleteItemButton.click();
		Thread.sleep(1*1000);
		//确认弹出框按钮
		driver.switchTo().alert().accept();
		//判断是否删除失败，没删除失败说明删除成功
		WebElement tableElement = driver.findElement(By.xpath("//*[@id='projectstatus']/tbody"));
		//将表单的所有tr放进列表，每个tr是表单的一行，逐行遍历
        List<WebElement> rows=tableElement.findElements(By.tagName("tr"));
        for (int i = 0; i < rows.size(); i++) {
            //将表单的td放进list里，每个td是表单的一列，逐列遍历
            List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
            for (int j = 2; j < cols.size();) {
                String tdText = cols.get(j).getText();
                Thread.sleep(1000);
//                System.out.println(tdText +"\t");
                j = j+7;
                //判断是否有项目名, 如果包含则删除失败
                if(tdText.equals("web项目")){
                    System.out.println("删除失败");
                }break;
            }
        }
	}
	
	public static void login(ChromeDriver driver) {
		driver.get("http://localhost:9000/jenkins/login");
		//定位用户名
		driver.findElement(By.id("j_username")).sendKeys("lemon04");
		//定位密码
		driver.findElement(By.name("j_password")).sendKeys("123456");
		//点击勾选保持登录
		driver.findElement(By.className("Checkbox-text")).click();
		//定位登录按钮
		driver.findElement(By.name("Submit")).click();
	}
	
	/**
	 * web自动结束方法,休息5秒中后退出浏览器驱动
	 * @param driver
	 */
	public static void finish(ChromeDriver driver) {
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	/**
	 * web自动化初始化方法，设置浏览器驱动位置，创建驱动对象
	 * @return
	 */
	public static ChromeDriver init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
