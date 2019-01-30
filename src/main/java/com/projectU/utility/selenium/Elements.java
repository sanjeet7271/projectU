package com.projectU.utility.selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.projectU.framework.constants.SeleniumConstant;
import com.projectU.utility.reports.Report;

/**
 * 
 * @author sanjeet.pandit
 *
 */
public class Elements implements SeleniumFramework{

	private static Logger logger = Logger.getLogger(Elements.class);
	private SeleniumUtils seleniumUtils = new SeleniumUtils();
	private static Elements instance = null;
	
	private Report report = new Report();

	protected Elements() {
	}

	public static Elements getInstance() {
		if (null == instance) {
			instance = new Elements();
		}
		return instance;
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public boolean waitForElement(By elementLocator) {
		return seleniumUtils.waitForElement(elementLocator);
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public boolean isElementPresentinTime(By elementLocator, int time) {
		return seleniumUtils.isElementPresentinTime(elementLocator, time);
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public boolean elementToBeClickable(By elementLocator) {
		return seleniumUtils.elementToClickable(elementLocator);
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public boolean isElementClickableinTime(By elementLocator, int time) {
		return seleniumUtils.isElementClickableinTime(elementLocator, time);
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public boolean waitForInvisibility(By elementLocator) {
		return seleniumUtils.elementToClickable(elementLocator);
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public boolean waitForInvisibility(By elementLocator, int time) {
		return seleniumUtils.isElementInvisibileinTime(elementLocator, time);
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 * 
	 */
	/*public boolean fluentWaitForElement(By elementLocator) {
		return seleniumUtils.elementToClickable(elementLocator);
	}*/
	
	@SuppressWarnings("deprecation")
	protected void fluentWaitForElement(final By elementLocator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(SeleniumConstant.DEFAULTTIMEOUT, TimeUnit.SECONDS);
		wait.withTimeout(2, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class); // We need to ignore this
														// exception.

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(elementLocator);
				if (element != null) {
					System.out.println("A new dynamic object is found.");
				}
				return element;
			}
		};

		wait.until(function);
	}


	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	/*public boolean fluentWaitinTimeForElement(By elementLocator, int time) {
		return seleniumUtils.isElementInvisibileinTime(elementLocator, time);
	}*/
	@SuppressWarnings("deprecation")
	protected void fluentWaitInTimeForElement(final By elementLocator, int time) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(time, TimeUnit.SECONDS);
		wait.withTimeout(2, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class); // We need to ignore this
														// exception.

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(elementLocator);
				if (element != null) {
					System.out.println("A new dynamic object is found.");
				}
				return element;
			}
		};

		wait.until(function);
	}
	
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public Boolean stalenessOf(By elementLocator) {
		return seleniumUtils.stalenessOf(elementLocator);
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public Boolean stalenessOfIntime(By elementLocator, int time) {
		return seleniumUtils.stalenessOfIntime(elementLocator, time);
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public String getText(By elementLocator) {
		report.log("Get text value ", "PASS", driver.findElement(elementLocator));
		return seleniumUtils.getText(elementLocator);
	}
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public String getAttribute(By elementLocator,String attribute) {
		report.log("Get text by attribute value ", "PASS", driver.findElement(elementLocator));
		return seleniumUtils.getAttribute(elementLocator,attribute);
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public boolean isEnabled(By elementLocator) {
		
		return seleniumUtils.isEnabled(elementLocator);
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public boolean isDisplyed(By elementLocator) {
		return seleniumUtils.isDisplyed(elementLocator);
	}

	
	public boolean isSelected(By elementLocator) {
		return seleniumUtils.isSelected(elementLocator);
	}
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void sendKeys(By elementLocator, String value) {
		if (waitForElement(elementLocator)) {
			seleniumUtils.elementToClickable(elementLocator);
			driver.findElement(elementLocator).clear();
			driver.findElement(elementLocator).sendKeys(value);
			report.log("Enter value ", "PASS", driver.findElement(elementLocator));
			logger.debug("Enter value " + value + " of " + elementLocator);
		}
	}
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void sendKeys(By elementLocator, String value,String message) {
		if (waitForElement(elementLocator)) {
			seleniumUtils.elementToClickable(elementLocator);
			driver.findElement(elementLocator).clear();
			driver.findElement(elementLocator).sendKeys(value);
			report.log(message, "PASS", driver.findElement(elementLocator));
			logger.debug("Enter value " + value + " of " + elementLocator);
		}
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void click(By elementLocator) {
		if (waitForElement(elementLocator)) {
			if(elementToBeClickable(elementLocator)) {
				report.log("Click on element .", "PASS", driver.findElement(elementLocator));
				driver.findElement(elementLocator).click();
			}
		}
	}

	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void click(By elementLocator,String message) {
		if (waitForElement(elementLocator)) {
			if(elementToBeClickable(elementLocator)) {
				report.log(message, "PASS", driver.findElement(elementLocator));
				driver.findElement(elementLocator).click();
			}
		}
	}
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void clear(By elementLocator) {
		if (waitForElement(elementLocator)) {
			if(elementToBeClickable(elementLocator)) {
				driver.findElement(elementLocator).clear();
			}
		}
	}
}
