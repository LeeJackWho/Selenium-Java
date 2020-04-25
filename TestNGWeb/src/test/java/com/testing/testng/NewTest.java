package com.testing.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  //testng中的parameters参数化
  @Parameters({"driverpath","url"})
  public void f(String driverpath,String url) {
	  //System.setProperty("webdriver.chrome.driver", "\\src\\test\\resources\\chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", driverpath);
	  WebDriver driver = new ChromeDriver();
	  //driver.get("http://localhost:9000/jenkins/login");
	  driver.get(url);
  }
}
