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
	 * 定位element
	 * */
//	public WebElement findElement(By by) {
//		return driver.findElement(by);
//	}
	
	/**
	 * 封装点击
	 * */
	public void click(WebElement element) {
		if(element != null) {
			element.click();
		}else {
			System.out.println("cannot find the element, failed to click");
		}
 
	}
	
	/**
	 * 封装输入
	 * */
	public void input(WebElement element, String value) {
		if(element != null) {
			element.sendKeys(value);
		}else {
			System.out.println("cannot find the element, failed to input value");
		}
	}
	/**
	 * 封装元素是否存在
	 * */
	public boolean IsDisplayed(WebElement element) {
		return element.isDisplayed();
	}
 
}
