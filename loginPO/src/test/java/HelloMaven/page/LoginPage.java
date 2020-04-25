package HelloMaven.page;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
import HelloMaven.base.DriverBase;
import HelloMaven.base.ElementProperties;
 
/**
 * 获得login页面的元素
 * */
public class LoginPage extends BasePage{   
	public LoginPage(DriverBase driver ) {
		super(driver);
	}
	
	ElementProperties EP = new ElementProperties();
	/**
	 * 获取username输入框
	 * */
	public WebElement getUserName() {
		return driver.findElement(EP.bystr("username"));
	}
	
	public WebElement getPassword() {
		
		return driver.findElement(EP.bystr("password"));
	}
	
	public WebElement LoginButton() {
		return driver.findElement(EP.bystr("loginbutton"));
	}
 
 
}
