package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;


import com.qa.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	//public static WebDriver driver;
	public static Properties prop;
	static String username = "abhishek.chauhan";
    static String accesskey = "QrSpp4hWSmzA8LsRfphgGmFbetJQsoUgc4E9iBMWlgNnR4J97q";
    protected static RemoteWebDriver driver = null;
    static String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Parameters(value={"browser","version","platform"})
	@BeforeTest
	public static void initialization(String browser, String version, String platform) throws MalformedURLException {
		String browserName = browser;

		DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("user",username);
    	capabilities.setCapability("accessKey",accesskey);
    	capabilities.setCapability("build", "Parallel_Build_LambdaTest");
    	capabilities.setCapability("name", "TestNG Assignment");
    	capabilities.setCapability("console",true);
    	capabilities.setCapability("network",true);
    	capabilities.setCapability("visual",true);
    	capabilities.setCapability("timezone","UTC+05:30");
    	capabilities.setCapability("geoLocation","SG");
		
		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			capabilities.setCapability("platformName", platform);
			capabilities.setCapability("browserName", browser);
			capabilities.setCapability("browserVersion",version);
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
			driver.get(prop.getProperty("url"));

		} else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();	
			capabilities.setCapability("platformName", platform);
			capabilities.setCapability("browserName", browser);
			capabilities.setCapability("browserVersion",version);
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
			driver.get(prop.getProperty("url"));

		}
		else if (browserName.equals("Opera")) {
			//WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			capabilities.setCapability("platformName", platform);
			capabilities.setCapability("browserName", browser);
			capabilities.setCapability("browserVersion",version);
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();


		}
		else if (browserName.equals("MicrosoftEdge")) {
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			capabilities.setCapability("platformName", platform);
			capabilities.setCapability("browserName", browser);
			capabilities.setCapability("browserVersion",version);
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
			driver.get(prop.getProperty("url"));


		}
        
        
        
		/*
		 * driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		 * driver.get(prop.getProperty("url"));
		 */
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Start Free Testing']")));
	}
	
	// driver commands
			// waitForVisibilty of an element
			public void waitForVisibility(WebElement e) {
				WebDriverWait wait = new WebDriverWait(driver, TestUtils.durationInSeconds);
				wait.until(ExpectedConditions.visibilityOf(e));
			}

			public void waitForDisapperance(WebElement e) {
				WebDriverWait wait = new WebDriverWait(driver, TestUtils.durationInSeconds);
				wait.until(ExpectedConditions.invisibilityOf(e));
			}

			public void clear(WebElement e) {
				waitForVisibility(e);
				e.clear();
			}

			// click on an element
			public void click(WebElement e) {
				waitForVisibility(e);
				e.click();
			}

			// type content in editable field
			public void sendKeys(WebElement e, String text) {
				waitForVisibility(e);
				e.sendKeys(text);
			}

			// return current value of attribute
			public String getAttribute(WebElement e, String text) {
				waitForVisibility(e);
				return e.getAttribute(text);
			}

			// scroll
			public void scrollDown() throws InterruptedException {	
				  JavascriptExecutor js = (JavascriptExecutor) driver;
				  js.executeScript("window.scrollBy(0,4300)");
			}

			public void hoverOverElement(WebElement moveToElement, WebElement clickElement) {
				Actions builder = new Actions(driver);
				builder.moveToElement(moveToElement).click(clickElement);
				builder.perform();
			}
			
			@AfterTest
			public void tearDown() {
				driver.quit(); // quit the driver after executing the test
			}
}
