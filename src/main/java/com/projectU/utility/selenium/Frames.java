package com.projectU.utility.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * 
 * @author sanjeet.pandit
 *
 */
public class Frames implements SeleniumFramework{

	private static Frames instance = null;

	protected Frames() {

	}

	public static Frames getInstance() {
		if (null == instance) {
			instance = new Frames();
		}
		return instance;
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void setDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	// Switch to Home Page
	public void switchDefaultToFrame(By elementLocator) {
		driver.switchTo().defaultContent();
		if (seleniumUtils.frameToBeAvailableAndSwitchToIt(elementLocator)) {
			driver.switchTo().frame(driver.findElement(elementLocator));
		} else {
			Assert.fail("Frame locator not found");
		}
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 **/
	// Switch to frame using WebElement
	public void switchToFrame(By elementLocator) {
		if (seleniumUtils.frameToBeAvailableAndSwitchToIt(elementLocator)) {
			driver.switchTo().frame(driver.findElement(elementLocator));
		} else {
			Assert.fail("Frame locator not found");
		}
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 **/
	// Switch to frame using Frame Index
	public void switchToFrame(int frameIndex) {
		if (seleniumUtils.frameToBeAvailableAndSwitchToIt(frameIndex)) {
			driver.switchTo().frame(frameIndex);
		} else {
			Assert.fail("Frame locator not found");
		}
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 **/
	// Switch to frame using Frame Name
	public void switchToFrame(String frameName) {
		if (seleniumUtils.frameToBeAvailableAndSwitchToIt(frameName)) {
			driver.switchTo().frame(frameName);
		} else {
			Assert.fail("Frame locator not found");
		}
	}
}
