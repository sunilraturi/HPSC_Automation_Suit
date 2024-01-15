package com.hpsc.qa.testcases;

import org.apache.log4j.LogManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.hpsc.qa.base.MainBase;
import com.hpsc.qa.base.TestBase;
import com.hpsc.qa.pages.LoginPage;

@SpringBootTest
@ContextConfiguration(classes = { MainBase.class })
public class LoginPageTest extends TestBase {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		log = LogManager.getLogger(LoginPageTest.class);
		log.info("Validating the Login page title");
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertEquals(loginPage.getLoginPageTitle(), "HP Sales Central");
	}

//	@Test(priority = 1)
//	public void logintest() {
//		log = LogManager.getLogger(LoginPageTest.class);
//		log.info(" Validating the Login page with correct username and password");
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.login(userName, password);
//	}

	@Test(priority = 2)
	public void inValidLogintest() {
		log.info(" Validating the Login page with no values");
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertEquals(loginPage.isInValidLoginMessageVisible(), true);
	}
}
