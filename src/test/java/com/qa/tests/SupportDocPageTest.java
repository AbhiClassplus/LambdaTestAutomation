package com.qa.tests;

import java.lang.reflect.Method;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.SupportDocPage;
import com.qa.utils.TestUtils;

public class SupportDocPageTest extends TestBase {

	HomePage homePage;
	SupportDocPage supportDocPage;
	TestUtils testUtils;

	public SupportDocPageTest() {
		super();
	}

	@BeforeMethod
	public void beforeMethod(Method m) throws JSONException, Exception {
		//initialization();
		homePage = new HomePage();
		supportDocPage = new SupportDocPage();
		testUtils = new TestUtils();
		System.out.println("\n" + "Starting Test:  " + m.getName() + "\n");
	}

	@AfterMethod
	public void afterMethod(Method m) {
		//driver.quit();
		System.out.println("\n" + "Ending Test:  " + m.getName() + "\n");
	}

	@Test
	public void validateIntegrationDocUrl() throws Exception {
		homePage.scrollDownTillCICDToolsTxt();
		supportDocPage = homePage.pressLearMoreTxt();
		Thread.sleep(5000);
		String actualUrl = supportDocPage.getUrl();
		String expectedUrl = "https://www.lambdatest.com/support/docs/integrations-with-ci-cd-tools/";
		Assert.assertEquals(actualUrl, expectedUrl);
		supportDocPage.navigateBack();
	}

	
}
