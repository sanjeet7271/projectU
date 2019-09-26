package com.projectU.pages;

import org.testng.Assert;

import com.projectU.utility.selenium.SeleniumFramework;

public class homewithoutlogin implements SeleniumFramework {

	public void verify_Current_URL() {
		String url = driver.getCurrentUrl();
		int urlLength = driver.getTitle().length();
		logger.info("Title of the page is : " + url);
		logger.info("Length of the title is : " + urlLength);
		Assert.assertEquals(url, "https://www.freecrm.com/index.html", "URL is not matching with actual one");
	}

	public void verify_Current_Title() {
		String title = driver.getTitle();
		int titleLength = driver.getTitle().length();
		logger.info("Title of the page is : " + title);
		logger.info("Length of the title is : " + titleLength);
	}

}
