package com.hpsc.qa.testcases;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hpsc.qa.base.MainBase;
import com.hpsc.qa.base.TestBase;
import com.hpsc.qa.pages.HomePage;
import com.hpsc.qa.pages.LoginPage;

@SpringBootTest
@ContextConfiguration(classes = { MainBase.class })
public class HomePageTest extends TestBase {

	@Test(priority = 1)
	public void pageBannerTitleTest() {
		HomePage homePage = new HomePage(driver);
//		HomePage homePage = loginPage.login(userName, password);
		Assert.assertEquals(homePage.getHomePageBannerTitle(), "HP Sales Central to be retired March 1, 2023",
				"Homepage Banner is not present: Values don't match in assertion condition");
	}

	@Test(priority = 2)
	public void countryDropDownTest() {
		HomePage homePage = new HomePage(driver);
//		HomePage homePage = loginPage.login(userName, password);
		Assert.assertEquals(homePage.isCountryDropDownVisible(), true,
				"Country dropdown is not present: Values don't match in assertion condition");
	}

	@Test(priority = 3)
	public void verifyToolsLinkTest() {
		HomePage homePage = new HomePage(driver);
//		HomePage homePage = loginPage.login(userName, password);
		homePage.clickOnToolsLink();

	}
}
