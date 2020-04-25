package HelloMaven.page;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
import HelloMaven.base.DriverBase;
 
public class BasePage {
	public DriverBase driver;
	public BasePage(DriverBase driver) {
		this.driver = driver;
	}
	
	/**
	 * ��λelement
	 * */
//	public WebElement findElement(By by) {
//		return driver.findElement(by);
//	}
	
	/**
	 * ��װ���
	 * */
	public void click(WebElement element) {
		if(element != null) {
			element.click();
		}else {
			System.out.println("cannot find the element, failed to click");
		}
 
	}
	
	/**
	 * ��װ����
	 * */
	public void input(WebElement element, String value) {
		if(element != null) {
			element.sendKeys(value);
		}else {
			System.out.println("cannot find the element, failed to input value");
		}
	}
	/**
	 * ��װԪ���Ƿ����
	 * */
	public boolean IsDisplayed(WebElement element) {
		return element.isDisplayed();
	}
 
}
