package com.projectU.utility.selenium;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author sanjeet.pandit
 *
 */
public class Utility implements SeleniumFramework {

	private static Utility instance = null;
	private List<String> lists = new ArrayList<String>();

	protected Utility() {

	}

	public static Utility getInstance() {
		if (null == instance) {
			instance = new Utility();
		}
		return instance;
	}

	/**
	 * @author sanjeet.pandit
	 * @param list
	 * @param value
	 */
	public void selectOption(List<WebElement> list, String value) {
		for (WebElement element : list) {
			if (element.getText().equalsIgnoreCase(value)) {
				element.click();
				break;
			}
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param list
	 * @param value
	 * @return
	 */
	public List<String> convertWebElementToString(List<WebElement> list) {
		for (WebElement element : list) {
			lists.add(element.getText().trim());
		}
		return lists;
	}
}
