/**
 * 
 */
package com.projectU.utility.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * @author sanjeet.pandit
 *
 */
public class Dropdown implements SeleniumFramework{

	private static Dropdown instance = null; 
	private List<WebElement> optionsList;

	protected Dropdown() {

	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public static Dropdown getInstance() {
		if (null == instance) {
			instance = new Dropdown();
		}
		return instance;
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public List<WebElement> getAllOptions(By elementLocator) {
		if (element.waitForElement(elementLocator)) {
			Select options = new Select(driver.findElement(elementLocator));
			optionsList = options.getOptions();
			logger.debug("Dropdown locator found..." + elementLocator);
			return optionsList;
		} else {
			logger.error(" Dropdown Element locator not found..." + elementLocator);
		}
		return optionsList;
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void selectByValue(By elementLocator, String value) {
		if (element.waitForElement(elementLocator)) {
			WebElement ele=driver.findElement(elementLocator);
			Select option = new Select(ele);
			option.selectByValue(value);
			logger.debug("Element locator found..." + elementLocator);
		} else {
			logger.error(" Dropdown Element locator not found..." + elementLocator);
		}
	}
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void selectByVisibleText(By elementLocator, String value) {
		if (element.waitForElement(elementLocator)) {
			WebElement ele=driver.findElement(elementLocator);
			Select option = new Select(ele);
			option.selectByVisibleText(value);
			logger.debug("Element locator found..." + elementLocator);
		} else {
			logger.error(" Dropdown Element locator not found..." + elementLocator);
		}
	}
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void selectByIndex(By elementLocator, int value) {
		if (element.waitForElement(elementLocator)) {
			WebElement ele=driver.findElement(elementLocator);
			Select option = new Select(ele);
			option.selectByIndex(value);
			logger.debug("Element locator found..." + elementLocator);
		} else {
			logger.error(" Dropdown Element locator not found..." + elementLocator);
		}
	}


	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void selectValueFromList(By elementLocator, String value) {
		if (element.waitForElement(elementLocator)) {
			Select options = new Select(driver.findElement(elementLocator));
			optionsList = options.getOptions();
			outerloop: for (WebElement option : optionsList) {
				if (option.getText().trim().equalsIgnoreCase(value)) {
					option.click();
					break outerloop;
				}
			}
			logger.debug("Element locator found..." + elementLocator);
		} else {
			logger.error(" Dropdown Element locator not found..." + elementLocator);
		}
	}
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void SelectDate(By elementLocator,String value){
		if (element.waitForElement(elementLocator)) {
			List<WebElement> allDates=driver.findElements(elementLocator);
			outerloop:for(WebElement ele:allDates)
			{
				String date=ele.getText();
				if(date.equalsIgnoreCase(value))
				{
					ele.click();
					System.out.println(date);
					break outerloop;
				}
				
			}
			logger.debug("Element locator found..." + elementLocator);
		} else {
			logger.error(" Dropdown Element locator not found..." + elementLocator);
		}
	}
}
