package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	private WebDriver driver;

	@BeforeSuite
	public void setUp() {
		// System.setProperty("webdriver.chrome.driver", "path to chrome driver");
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

	}

	@BeforeTest
	public void createWebDriverInstance() throws InterruptedException {
		driver.get("https://www.lambdatest.com/selenium-automation"); // https://freecrm.co.in/

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);// globally

		
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,4000)");
		 * 
		 * Thread.sleep(5000);
		 * 
		 * Actions builder = new Actions(driver); WebElement menuOption =
		 * driver.findElement(By.xpath("//div[normalize-space()='CI/CD Tools']"));
		 * WebElement clickElement = driver.findElement(By.xpath(
		 * "//a[contains(@href,'https://www.lambdatest.com/support/docs/integrations-with-ci-cd-tools/')]"
		 * )); builder.moveToElement(menuOption).click(clickElement); builder.perform();
		 * 
		 * Thread.sleep(3000);
		 * //driver.findElement(By.cssSelector("h1[class='pages-titel']")).click();
		 * 
		 * //scroll down the page js.executeScript("window.scrollBy(0,5000)");
		 * 
		 * Thread.sleep(3000);
		 * 
		 * //scroll up the page js.executeScript("window.scrollBy(0,-5000)");
		 * 
		 * Thread.sleep(3000);
		 * 
		 * driver.navigate().back(); Thread.sleep(3000);
		 * 
		 * 
		 * driver.findElement(By.cssSelector("a[class='nav-link dropdown-toggle']")).
		 * click(); driver.findElement(By.xpath(
		 * "//a[@class='dropdown-item'][normalize-space()='Newsletter']")).click();
		 */


	}

	@AfterClass
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
