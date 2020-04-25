package com.selenium.testCase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.selenium.base.DriverBase;
import com.selenium.business.registerPro;

public class registerTest extends CaseBase{
	public DriverBase driver;
	public registerPro rp;
	public registerTest() {
		this.driver = InitDriver("Chrome");
		rp = new registerPro(driver);
	}
	@Test
	public void getRegisterHome() {
		driver.get("http://localhost:9000/jenkins/signup");
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods= {"getRegisterHome"})
	public void testRegister() {
			rp.register("11111", "11111", "11111@", "11111");
	}
	
	@Test(dependsOnMethods= {"testRegister"})
	public void quitDriver() {
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
