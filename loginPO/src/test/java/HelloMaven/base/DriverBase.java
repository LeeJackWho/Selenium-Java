package HelloMaven.base;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
 
public class DriverBase {
	public WebDriver driver;
	public DriverBase(String browser){
		SelectDriver selectdriver= new SelectDriver();
		this.driver = selectdriver.DriverSelect(browser);
	}
	
	public void stopDriver() {
		System.out.println("stop the driver");
		driver.close();
	}
	
	/**
	 * ¶¨Î»element,·â×°
	 * */
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}
	public void get(String url) {
		driver.get(url);
	}
}
