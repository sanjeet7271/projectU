package com.projectU.testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.projectU.framework.constants.FrameworkConstant;
import com.projectU.pages.Pages;
import com.projectU.utility.selenium.SeleniumFramework;

public class freecrm implements SeleniumFramework, Pages{
	@Test(description = "Navigation to Home Page")
	public void GlobalInitialization() throws IOException {
		String url=FrameworkConstant.GLOBALCONFIG.get("URL");
		driver.get(url);
		System.out.println(url);
	}

}
