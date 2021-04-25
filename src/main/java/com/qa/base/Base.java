package com.qa.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	protected WebDriver driver;



	//@Parameters({ "browserName", "OS", "browserVersion" })
	public void createWebDriverInstance() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-automation");
		driver.manage().window().maximize();
		/*
		 * ChromeOptions capabilities = new ChromeOptions();
		 * capabilities.setCapability("user", "Your Lambda Username");
		 * capabilities.setCapability("accessKey", "Your Lambda Access Key");
		 * capabilities.setCapability("build", "your build name");
		 * capabilities.setCapability("name", "your test name"); //
		 * capabilities.setCapability("platformName", OS); //
		 * capabilities.setCapability("browserName", browserName ); //
		 * capabilities.setCapability("browserVersion",browserVersion);
		 * capabilities.setCapability("console", true);
		 * capabilities.setCapability("network", true);
		 * capabilities.setCapability("visual", true);
		 * capabilities.setCapability("timezone", "UTC+05:30");
		 * capabilities.setCapability("geoLocation", "SG");
		 */
		

	}

	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.quit();
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
	public void scrollTillElement(WebElement element) throws InterruptedException {	
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,4000)");
	}

	public void hoverOverElement(WebElement moveToElement, WebElement clickElement) {
		Actions builder = new Actions(driver);
		builder.moveToElement(moveToElement).click(clickElement);
		builder.perform();
	}
}
