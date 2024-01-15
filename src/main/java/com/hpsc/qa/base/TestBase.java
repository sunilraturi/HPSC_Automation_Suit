package com.hpsc.qa.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import com.hpsc.qa.pages.LoginPage;
import com.hpsc.qa.util.TestUtil;

@Component
public class TestBase extends AbstractTestNGSpringContextTests {
	protected Logger log;

	@Value("${app.env}")
	private String env;

	@Value("${app.userName}")
	protected String userName;

	@Value("${app.password}")
	protected String password;

	@Autowired
	protected WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		log = LogManager.getLogger(TestBase.class);
		log.info("Launching the browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICT_WAIT));
		driver.get(env);
	}
	
	@BeforeMethod
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
	}

	@AfterMethod
	public void nevigateBackToHomepage() {
		log = LogManager.getLogger(TestBase.class);
		log.info("Going back to Homepage");
		driver.get(env);
		
	}
	
	@AfterSuite
	public void tearDown() {
		log = LogManager.getLogger(TestBase.class);
		log.info("Closing the browser");
		driver.close();
	}
}
