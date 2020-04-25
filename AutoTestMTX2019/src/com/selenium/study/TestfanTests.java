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
	//��������¼
	public void login() {
		driver.findElement(By.linkText("��¼")).click();
		driver.findElement(By.cssSelector(".btn.btn-default.btn-sm.btn-sn-qq")).click();
		driver.switchTo().frame(0);//ʹ�������л�frame
		
		//�ȶ�λiframeԪ��
//		WebElement iframe163 = driver.findElement(By.cssSelector("iframe[frameborder='0']"));
//		driver.switchTo().frame(iframe163);
//		
//		driver.switchTo().defaultContent();//�ص���ʼ��frame
		
		driver.findElement(By.cssSelector("#img_out_2879897713")).click();
		//�ж��Ƿ��¼�ɹ�������Utils���е�elementIsExist�����ж�Ԫ���Ƿ����
		if(Utils.elementIsExist(driver, By.cssSelector("#unread_messages"))) {
			System.out.println("��¼�ɹ�");
		}else {
			System.out.println("��¼ʧ��");
		}
	}
	
	//�޸ĸ�������
	public void changePersonInfo() {
		driver.findElement(By.cssSelector(".dropdown.user-avatar")).click();
		driver.findElement(By.linkText("�˺�����")).click();
		driver.findElement(By.cssSelector("input[name='name']")).clear();
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("ɳİ����");
		
		//ѡ�Ա�
		List<WebElement> genders = driver.findElements(By.cssSelector("input[name='gender']"));
		for(WebElement w:genders) {
			if(!w.isSelected()) {
				w.click();
				break;
			}
		}
		
		//ʹ��js��ȡ�������ĵ�����¼���Ȼ��������
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("$('#birthday').unbind();");
		
		//����
		WebElement birthday = driver.findElement(By.cssSelector("#birthday"));
		birthday.clear();
		birthday.sendKeys("1993-10-23");
		
		//��ѡʡ��
		
		
		Select province=new Select(driver.findElement(By.cssSelector("#province")));
		int i=(int) (Math.random()*province.getOptions().size())-1;
		//province.selectByVisibleText("ɽ��");
		province.selectByIndex(i);
		String provinceName=province.getFirstSelectedOption().getText();
		
		
		
		//ѡ����
		Select city=new Select(driver.findElement(By.cssSelector("#city")));
		int j=(int) (Math.random()*city.getOptions().size())-1;
		//province.selectByVisibleText("ɽ��");
		city.selectByIndex(j);
		String cityName=province.getFirstSelectedOption().getText();
		//city.selectByVisibleText("����");
		
		//����ύ
		driver.findElement(By.cssSelector(".btn.btn-xl.btn-primary.profile-sub")).click();
		
		Select province1=new Select(driver.findElement(By.cssSelector("#province")));
		System.out.println(province1.getFirstSelectedOption().getText());
	}
	//����
	public void comment() {
		String currentHandle=driver.getWindowHandle();//��ǰhandle
		driver.findElement(By.linkText("�����appium�����豸������״̬")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String s:windowHandles) {
			if(!s.equals(currentHandle)) {
				driver.switchTo().window(s);
				break;
			}
		}
		
		driver.findElement(By.cssSelector("#comment-article-content-3")).sendKeys("��ƪ�����Ѿ���ʱ");
		driver.findElement(By.cssSelector("#article-comment-3-btn")).click();
		
		//��֤
		List<WebElement> comments = driver.findElements(By.cssSelector(".content>p"));
		String text=comments.get(comments.size()-1).getText();
		if("��ƪ�����Ѿ���ʱ".equals(text)) {
			System.out.println("���۳ɹ�");
		}else {
			System.out.println("����ʧ��");
		}
	}
	
	public static void main(String[] args) {
//		TestfanTests testfan=new TestfanTests();
//		testfan.login();
//		//testfan.changePersonInfo();
//		testfan.comment();
	}
}
