package com.common.utils;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;

public class BrowserUtils {

	public static WebDriver driver;
	public String BROWSER=System.getProperty("browser");

	@BeforeSuite
	public void setUpDriver() {
		try {
			if(BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Log.startTestCase("Chrome driver initiallized and test case started");
			}else if (BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Log.startTestCase("Firefox driver initiallized and test case started");
			}else if(BROWSER.equalsIgnoreCase("opera")) {
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Log.startTestCase("Opera driver initiallized and test case started");
			}else {
				Log.error("Driver not found for specified browser");
			}
		}catch (WebDriverManagerException e) {
			Log.error("Unable to setup WebDriverManager due to: " +e.getMessage());
		}
	}

	@AfterSuite
	public void tearDown() {
		if(driver != null) {
			driver.quit();
			Log.endTestCase("Driver quit successfully");
		}
	}

	public void launchUrl() {
		driver.get("https://c6.avaamo.com/web_channels/444588bc-92fe-477f-87c1-88a92946346a/demo.html?theme=avm-messenger&banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up");
	}

	public void webDriverWait(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Log.info("WebElement "+ele+" is displayed on the page");
		}catch (WebDriverException e) {
			Log.error("Unable to get web element wait due to :"+e.getMessage());
		}
	}

}
