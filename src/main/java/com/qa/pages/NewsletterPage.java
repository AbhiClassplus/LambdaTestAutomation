package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class NewsletterPage extends TestBase {

	// Object Reporsitory
	@FindBy(css = "a[class='nav-link dropdown-toggle']")
	private WebElement resources;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Newsletter']")
	private WebElement newsletterOption;
	
	@FindBy(className = "pagelink")
	private WebElement pageLink;

	// Initializing the Page Objects:
	public NewsletterPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean isLetsReadItFirstLinkDisplayed() {
		return pageLink.isDisplayed();
		
	}
	
	
	
	
	
	
}
