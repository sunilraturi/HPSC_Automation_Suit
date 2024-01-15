package com.hpsc.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver Driver;

	// Initalizing the Page object
	public HomePage(WebDriver driver) {
		this.Driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]//div[@data-index='1']//div[@class='banner-img']//*[contains(text(),'to be retired')]")
	WebElement bannerName;

	@FindBy(id = "global-toggle")
	WebElement countryDropDown;

	@FindBy(xpath = "//*[@href='/tools']")
	WebElement toolLink;

	public String getHomePageBannerTitle() {
		return bannerName.getText();
	}

	public boolean isCountryDropDownVisible() {
		return countryDropDown.isDisplayed();
	}

	public ToolsPage clickOnToolsLink() {
		toolLink.click();
		return new ToolsPage(Driver);
	}
}
