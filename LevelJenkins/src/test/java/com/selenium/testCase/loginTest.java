package com.selenium.testCase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.selenium.base.DriverBase;
import com.selenium.business.loginPro;

public class loginTest extends CaseBase{
	public DriverBase driver;
	public loginPro loginpro;
	public loginTest() {
		this.driver = InitDriver("Chrome");
		loginpro = new loginPro(driver);
	}
	@Test
	public void getLoinHome() {
		driver.get("http://localhost:9000/jenkins/login");
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods= {"getLoinHome"})
	public void testLogin() {
			loginpro.loginEmpty();
			loginpro.login("aaa", "aaaaa");
	}
	
	@Test(dependsOnMethods= {"testLogin"})
	public void quitDriver() {
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
