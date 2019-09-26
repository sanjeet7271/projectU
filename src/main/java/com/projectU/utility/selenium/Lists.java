/**
 * 
 */
package com.projectU.utility.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author sanjeet.pandit
 *
 */
public class Lists implements SeleniumFramework{

	private static Lists instance = null;
	private List<WebElement> tableData;

	protected Lists() {

	}

	public static Lists getInstance() {
		if (null == instance) {
			instance = new Lists();
		}
		return instance;
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public List<WebElement> getTableData(By elementLocator) {
		if (element.waitForElement(elementLocator)) {
			tableData = driver.findElements(elementLocator);
			return tableData;
		}
		return tableData;

	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public List<WebElement> getOption(By elementLocator) {
		if (element.waitForElement(elementLocator)) {
			tableData = driver.findElements(elementLocator);
			return tableData;
		}
		return tableData;
	}
	//New method for print all links on web Page

}
