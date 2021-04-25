package com.qa.tests;

import java.lang.reflect.Method;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.base.Base;
import com.qa.base.BaseTest;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.utils.TestUtils;

public class HomePageTest extends TestBase{

	HomePage homePage;
	TestUtils testUtils;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void beforeMethod(Method m) throws JSONException, Exception {
		//initialization();
		homePage = new HomePage();
		testUtils = new TestUtils();
		System.out.println("\n" + "Starting Test:  " + m.getName() + "\n");
	}

	@AfterMethod
	public void afterMethod(Method m) {
		//driver.quit();
		System.out.println("\n" + "Ending Test:  " + m.getName() + "\n");
	}

	@Test
	public void valdiateStartTestingBtnOnHomePage() throws InterruptedException {
		boolean flag = homePage.isStartFreeTestingBtn();
		Assert.assertTrue(flag);
	}

	
}
