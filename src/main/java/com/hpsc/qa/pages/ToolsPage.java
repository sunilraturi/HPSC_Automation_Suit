package com.hpsc.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolsPage {
	WebDriver Driver;

	public ToolsPage(WebDriver driver) {
		this.Driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class ='vn-icon css-mgarrm']")
	WebElement workspaceButton;

	@FindBy(xpath = "//*[@class='collapse-aside-section']//*[contains(@*, 'exp-col-button')]")
	WebElement collapseViewIcon;

	// Initalizing the Page object

	public boolean isWorkspaceButtonVisible() {
		return workspaceButton.isDisplayed();
	}

	public boolean isCollapseViewVisible() {
		return collapseViewIcon.isDisplayed();
	}
}
