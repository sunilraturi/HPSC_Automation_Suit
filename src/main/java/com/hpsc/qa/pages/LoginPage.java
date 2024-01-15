package com.hpsc.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver Driver;

	// Initializing the Page object
	public LoginPage(WebDriver driver) {
		this.Driver = driver;
		PageFactory.initElements(driver, this);
	}

//Page Factory
	@FindBy(id = "onetrust-accept-btn-handler")
	WebElement loginPopup;

	@FindBy(xpath = "//button[contains(text(),'SIGN IN')]")
	WebElement signinButton;

	@FindBy(id = "username")
	WebElement hpscUserNameTextBox;

	@FindBy(id = "user-name-form-submit")
	WebElement nextButton;

	@FindBy(id = "password")
	WebElement hpidPasswordTextBox;

	@FindBy(id = "username")
	@CacheLookup
	WebElement hpidUsernameTextBox;

	@FindBy(xpath = "//input[@value='Log on']")
	WebElement hpidLogonButton;

	@FindBy(xpath = "//span[@class='caption text' and text()= 'Enter your username or email address' ]")
	WebElement invaidSignInTextMessage;

	// Actions
	public String getLoginPageTitle() {
		return Driver.getTitle();
	}

	public void login(String username, String password) {
		loginPopup.click();
		signinButton.click();
		hpscUserNameTextBox.sendKeys(username);
		nextButton.click();
		hpidPasswordTextBox.sendKeys(password);
		hpidUsernameTextBox.sendKeys(username);
		hpidLogonButton.click();
//		return new HomePage(Driver);
	}

	public boolean isInValidLoginMessageVisible() {
		loginPopup.click();
		signinButton.click();
		nextButton.click();
		return invaidSignInTextMessage.isDisplayed();
	}

}
