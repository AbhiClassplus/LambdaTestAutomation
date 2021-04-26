package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class HomePage extends TestBase {

	// Object Reporsitory

	@FindBy(xpath = "//a[contains(@href,'https://www.lambdatest.com/support/docs/integrations-with-ci-cd-tools/')]")
	private WebElement learnMorelInk;

	@FindBy(xpath = "//div[normalize-space()='CI/CD Tools']")
	private WebElement CICDToolsTxt;

	@FindBy(css = "a[onclick='onStartTesting()']")
	private WebElement startFreeTestingBtn;
	
	@FindBy(css = "a[class='nav-link dropdown-toggle']")
	private WebElement resources;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Newsletter']")
	private WebElement newsletterOption;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void scrollDownTillCICDToolsTxt() throws InterruptedException {
		scrollDown();
	}

	public SupportDocPage pressLearMoreTxt() {
		hoverOverElement(CICDToolsTxt, learnMorelInk);
		return new SupportDocPage();
	}

	public boolean isStartFreeTestingBtn() {
		return startFreeTestingBtn.isDisplayed();
	}
	
	public void pressResourcesFromMenu() {
		click(resources);
	}
	
	public NewsletterPage pressNewsletterOption() {
		click(newsletterOption);
		return new NewsletterPage();
	}
	
	public void clickNewsLetterOption(){
		Actions action = new Actions(driver);
		action.moveToElement(resources).build().perform();
		newsletterOption.click();
		
	}

}