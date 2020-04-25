package HelloMaven.testcase;
 
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
 
import HelloMaven.base.DriverBase;
import HelloMaven.business.LoginPro;
 
public class testLogin extends caseBase{
	public DriverBase driver;
	public LoginPro Lpro;
	static Logger logger = Logger.getLogger(testLogin.class);
	public testLogin() {
		this.driver = InitialDriver("Chrome");
		this.Lpro = new LoginPro(driver);
	}
	@Test
	public void getLoginHome() {
		driver.get("http://www.imooc.com");
		driver.findElement(By.id("js-signin-btn")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(dependsOnMethods= {"getLoginHome"})
	public void Login() {
		logger.debug("first time for logging");
		Lpro.Login("13610056184", "MISSjj28*");
		
	}
	@Test(dependsOnMethods= {"Login"})
	public void stop() {
		driver.stopDriver();
	}
 
}
