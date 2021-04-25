package com.qa.pages;

import com.qa.base.TestBase;

public class SupportDocPage extends TestBase {

	//Actions
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void navigateBack() {
		driver.navigate().back();
	}
}
