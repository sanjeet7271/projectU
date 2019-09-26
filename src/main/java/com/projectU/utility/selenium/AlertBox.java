
package com.projectU.utility.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * 
 * @author Sanjeet.Pandit
 *
 */
public class AlertBox implements SeleniumFramework{

	private static AlertBox instance = null;
	private Alert simpleAlert;

	protected AlertBox() {

	}

	/**
	 * 
	 * @author Sanjeet.Pandit
	 *
	 */
	public static AlertBox getInstance() {
		if (null == instance) {
			instance = new AlertBox();
		}
		return instance;
	}

	/**
	 * 
	 * @author Sanjeet.Pandit
	 *
	 */
	public void acceptAlert() {
		simpleAlert = driver.switchTo().alert();
		if (seleniumUtils.alertIsPresent()) {
			simpleAlert.accept();
		} else {
			Assert.fail("");
		}

	}

	/**
	 * 
	 * @author Sanjeet.Pandit
	 *
	 */
	public void cancelAlert() {
		simpleAlert = driver.switchTo().alert();
		if (seleniumUtils.alertIsPresent()) {
			simpleAlert.dismiss();
		} else {
			Assert.fail("");
		}

	}

	/**
	 * 
	 * @author Sanjeet.Pandit
	 *
	 */
	public String getAlertTextClose() {
		simpleAlert = driver.switchTo().alert();
		String altertText = "";
		if (seleniumUtils.alertIsPresent()) {
			altertText = simpleAlert.getText();
			simpleAlert.dismiss();
		} else {
			Assert.fail("");
		}
		return altertText;
	}

	/**
	 * 
	 * @author Sanjeet.Pandit
	 *
	 */
	public String sendTextIntoAlert(By elementLocator, String value) {
		simpleAlert = driver.switchTo().alert();
		if (seleniumUtils.alertIsPresent()) {
			driver.findElement(elementLocator).sendKeys(value);
			simpleAlert.dismiss();
		} else {
			Assert.fail("");
		}
		return null;
	}
}
