package com.testing.testng;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class UsuallyDataDrivenTest {
  @Test(dataProvider = "dp")
  public void f(String user, String pw,String expectedRes) {
	  System.setProperty("webdriver.chrome.driver", "\\src\\test\\resources\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("");
	  driver.findElement(By.id("")).sendKeys(user);
	  driver.findElement(By.id("")).sendKeys(pw);
	  String result = driver.findElement(By.xpath("")).getText();
	  assertEquals(result, expectedRes);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "a", "b","success"},
      new Object[] { "c", "d","fail"},
    };
  }
}
