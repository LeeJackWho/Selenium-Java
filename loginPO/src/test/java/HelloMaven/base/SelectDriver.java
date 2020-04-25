package HelloMaven.base;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class SelectDriver {
	public WebDriver DriverSelect(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome", "E:\\软件测试\\毕业设计\\eclipse-jee-2019-03-R-win32-x86_64\\eclipse\\eclipse-workspace\\loginPO\\src\\test\\resources\\chromedriver.exe");
			return new ChromeDriver();
		}else {
			System.setProperty("webdriver.firefox.driver", "F:\\Java\\FireFoxdriver\\geckodriver.exe");
			return new FirefoxDriver();
		}
	}
}
