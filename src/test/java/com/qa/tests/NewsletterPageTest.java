package com.qa.tests;

import java.lang.reflect.Method;

import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.NewsletterPage;
import com.qa.pages.SupportDocPage;
import com.qa.utils.TestUtils;

public class NewsletterPageTest extends TestBase {

	HomePage homePage;
	SupportDocPage supportDocPage;
	NewsletterPage newsletterPage;
	TestUtils testUtils;

	public NewsletterPageTest() {
		super();
	}

	@BeforeMethod
	public void beforeMethod(Method m) throws JSONException, Exception {
		//initialization();
		homePage = new HomePage();
		supportDocPage = new SupportDocPage();
		newsletterPage = new NewsletterPage();
		testUtils = new TestUtils();
		System.out.println("\n" + "Starting Test:  " + m.getName() + "\n");
	}

	@AfterMethod
	public void afterMethod(Method m) {
		//driver.quit();
		System.out.println("\n" + "Ending Test:  " + m.getName() + "\n");
	}

	@Test
	public void validateLetMeReadItFirstLink() throws Exception {
		homePage.clickNewsLetterOption();
		boolean flag = newsletterPage.isLetsReadItFirstLinkDisplayed();
		Assert.assertTrue(flag);
	}

}
