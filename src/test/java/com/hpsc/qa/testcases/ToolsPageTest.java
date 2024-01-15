package com.hpsc.qa.testcases;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hpsc.qa.base.MainBase;
import com.hpsc.qa.base.TestBase;
import com.hpsc.qa.pages.HomePage;
import com.hpsc.qa.pages.LoginPage;
import com.hpsc.qa.pages.ToolsPage;

@SpringBootTest
@ContextConfiguration(classes = { MainBase.class })
public class ToolsPageTest extends TestBase {

	@Test(priority = 1)
	public void WorkspaceButtonTest() {
		HomePage homePage = new HomePage(driver);
//		HomePage homePage = loginPage.login(userName, password);
		ToolsPage toolsPage = homePage.clickOnToolsLink();
		Assert.assertEquals(toolsPage.isWorkspaceButtonVisible(), true,
				"Workspace button is not present: Values don't match in assertion condition");
	}

	@Test(priority = 2)
	public void collapseViewTest() {
		HomePage homePage = new HomePage(driver);
//		HomePage homePage = loginPage.login(userName, password);
		ToolsPage toolsPage = homePage.clickOnToolsLink();
		Assert.assertEquals(toolsPage.isCollapseViewVisible(), true,
				"Collapse view is not present: Values don't match in assertion condition");
	}
}
