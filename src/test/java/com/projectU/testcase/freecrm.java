package com.projectU.testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.projectU.framework.constants.FrameworkConstant;
import com.projectU.pages.Pages;
import com.projectU.utility.selenium.SeleniumFramework;

public class freecrm implements SeleniumFramework, Pages{
	
	@Test(priority=1, description = "Navigation to Home Page")
	public void GlobalInitialization() throws IOException {
		String url=FrameworkConstant.GLOBALCONFIG.get("URL");
		driver.get(url);
		logger.info(url);
	}
	@Test(priority=2, description = "Home Page verification")
	public void verify_Home_Page() {
		homewithoutlogin.verify_Current_URL();
		homewithoutlogin.verify_Current_Title();
		brokenLinks.CheckBrokenLinks();
	}
}
