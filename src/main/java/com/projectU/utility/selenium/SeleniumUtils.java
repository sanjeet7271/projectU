package com.projectU.utility.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.projectU.framework.constants.SeleniumConstant;

/**
 * 
 * @author sanjeet.pandit
 *
 */
public class SeleniumUtils  implements SeleniumFramework{
	private static Logger logger = Logger.getLogger(SeleniumUtils.class);
	private WebDriverWait wait = new WebDriverWait(driver, SeleniumConstant.DEFAULTTIMEOUT);
	private static SeleniumUtils instance = null;

	protected SeleniumUtils() {

	}

	public static SeleniumUtils getInstance() {
		if (null == instance) {
			instance = new SeleniumUtils();
		}
		return instance;
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @return
	 */
	//The presenceOfElementLocated just checks the DOM to see if it can locate an element no matter its visibility.
	
	protected boolean presenceOfElementLocated(By elementLocator) {
		logger.debug("Looking for element locator..." + elementLocator);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @param text
	 * @return
	 */
	//An expectation for checking if the given text is present in the specified element.
	protected boolean textToBePresentInElementValue(By elementLocator, String text) {
		logger.debug("Looking for element locator..." + elementLocator);
		try {
			wait.until(ExpectedConditions.textToBePresentInElementValue(elementLocator, text));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @return
	 */
	//Switch to frame using WebElement
	protected boolean frameToBeAvailableAndSwitchToIt(By elementLocator) {
		logger.debug("Looking for element locator..." + elementLocator);
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(elementLocator));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param frameIndex
	 * @return
	 */
	//Switch to frame using Frame Index
	protected boolean frameToBeAvailableAndSwitchToIt(int frameIndex) {
		logger.debug("Looking for element locator..." + frameIndex);
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
			logger.debug("Elemnt locator found..." + frameIndex);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + frameIndex);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param frameName
	 * @return
	 */
	//Switch to frame using frame Name
	protected boolean frameToBeAvailableAndSwitchToIt(String frameName) {
		logger.debug("Looking for element locator..." + frameName);
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
			logger.debug("Elemnt locator found..." + frameName);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + frameName);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @return
	 */
	//Wait until an element is no longer attached to the DOM.
	//or  If WebElement present, Expectedconditions.stalenessOf will wait until Element is deleted.
	protected boolean stalenessOf(By elementLocator) {
		wait = new WebDriverWait(driver, SeleniumConstant.DEFAULTTIMEOUT);
		logger.debug("Looking for element locator..." + elementLocator);
		try {
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(elementLocator)));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @param time
	 * @return
	 */
	
	protected boolean stalenessOfIntime(By elementLocator, int time) {
		wait = new WebDriverWait(driver, time);
		logger.debug("Looking for element locator..." + elementLocator);
		try {
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(elementLocator)));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @param text
	 * @return
	 */
	//An expectation for checking WebElement with given locator has specific text
	protected boolean textToBe(By elementLocator, String text) {
		logger.debug("Looking for element locator..." + elementLocator);
		try {
			wait.until(ExpectedConditions.textToBe(elementLocator, text));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @param noOfElement
	 * @return
	 */
	//An expectation for checking number of WebElements with given locator
	protected boolean numberOfElementsToBeMoreThan(By elementLocator, int noOfElement) {
		logger.debug("Looking for element locator..." + elementLocator);
		try {
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(elementLocator, noOfElement));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @param noOfElement
	 * @return
	 */
	//An expectation for checking number of WebElements with given locator being less than defined number
	protected boolean numberOfElementsToBeLessThan(By elementLocator, int noOfElement) {
		logger.debug("Looking for element locator..." + elementLocator);
		try {
			wait.until(ExpectedConditions.numberOfElementsToBeLessThan(elementLocator, noOfElement));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @param noOfElement
	 * @return
	 */
	//An expectation for checking number of WebElements with given locator
	protected boolean numberOfElementsToBe(By elementLocator, int noOfElement) {
		logger.debug("Looking for element locator..." + elementLocator);
		try {
			wait.until(ExpectedConditions.numberOfElementsToBe(elementLocator, noOfElement));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @return
	 */
	//
	protected boolean alertIsPresent() {
		logger.debug("Looking for element locator ");
		wait = new WebDriverWait(driver, SeleniumConstant.DEFAULTTIMEOUT);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			logger.debug("Elemnt locator found...");
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found...");
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param time
	 * @return
	 */
	protected boolean alertIsPresentinTime(int time) {
		logger.debug("Looking for element locator  for time..." + time);
		wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			logger.debug("Elemnt locator found...");
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found...");
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @return
	 */
	//An expectation for checking that an element is present on the DOM of a page and visible.
	protected boolean waitForElement(By elementLocator) {
		wait = new WebDriverWait(driver, SeleniumConstant.DEFAULTTIMEOUT);
		logger.debug("Looking for element locator..." + elementLocator);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @param time
	 * @return
	 */
	//An expectation for checking that an element is present on the DOM of a page and visible with given amount of time
	protected boolean isElementPresentinTime(By elementLocator, int time) {
		logger.debug("Looking for element locator " + elementLocator + " for time..." + time);
		wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @return
	 */
	//An expectation for checking an element is visible and enabled such that you can click it
	protected boolean elementToClickable(By elementLocator) {
		logger.debug("Looking for element locator to clickable " + elementLocator);
		wait = new WebDriverWait(driver, SeleniumConstant.DEFAULTTIMEOUT);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			return true;
		} catch (Exception e) {
			logger.error("Element is not clickable" + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @param time
	 * @return
	 */
	protected boolean isElementClickableinTime(By elementLocator, int time) {
		wait = new WebDriverWait(driver, time);
		logger.debug("Looking for element locator to clickable " + elementLocator + " for time..." + time);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @return
	 */
	//An expectation for checking that an element is either invisible or not present on the DOM.
	protected boolean waitForInvisibility(By elementLocator) {
		logger.debug("Looking for element locator to clickable " + elementLocator);
		wait = new WebDriverWait(driver, SeleniumConstant.DEFAULTTIMEOUT);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element is not clickable");
			return false;
		}

	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @param time
	 * @return
	 */
	//
	protected boolean isElementInvisibileinTime(By elementLocator, int time) {
		logger.debug("Looking for element locator " + elementLocator + " for time..." + time);
		wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
			logger.debug("Elemnt locator found..." + elementLocator);
			return true;
		} catch (Exception e) {
			logger.error("Element locator id found..." + elementLocator);
			return false;
		}

	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 */
	//Fluent wait for WebElement 
	/*protected WebElement fluentWaitForElement(final By elementLocator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(SeleniumConstant.DEFAULTTIMEOUT, TimeUnit.SECONDS);
		wait.withTimeout(2, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class); // We need to ignore this
														// exception.

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(elementLocator);
				if (element != null) {
				}
				return element;
			}
		};

		return wait.until(function);
	}
*/
	
	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @param time
	 */
	/*protected void fluentWaitInTimeForElement(final By elementLocator, int time) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(time, TimeUnit.SECONDS);
		wait.withTimeout(2, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class); // We need to ignore this
														// exception.

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(elementLocator);
				if (element != null) {
				}
				return element;
			}
		};

		wait.until(function);
	}*/

	/**
	 * @author dhiraj.bendale
	 * @param elementLocator
	 * @return
	 */
	//closing Alert
	protected boolean closeAlert(By elementLocator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @author sanjeet.pandit
	 */
	//method for Switch to Alert
	protected void switchToAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @return
	 */
	//Get all text present on locators
	protected String getText(By elementLocator) {
		if (waitForElement(elementLocator)) {
			logger.debug("Elemnt locator get text ..." + driver.findElement(elementLocator).getText());
			return driver.findElement(elementLocator).getText();
		} else {
			logger.error("Elemnt locator not found..." + elementLocator);
			return "";
		}
	}

	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @param attribute
	 * @return
	 */
	//Gets attribute present inside tag
	protected String getAttribute(By elementLocator, String attribute) {
		if (waitForElement(elementLocator)) {
			logger.debug("Elemnt locator get text ..." + driver.findElement(elementLocator).getAttribute(attribute));
			return driver.findElement(elementLocator).getAttribute(attribute);
		} else {
			logger.error("Elemnt locator not found..." + elementLocator);
			return "";
		}
	}
	
	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @return
	 */
	/**
	 * Check Visibility of Web Elements Using Various Types WebDriver Commands: IsEnable(), isSelected(), isDisplayed()
	 * */
	//isEnabled() is the method used to verify if the web element is enabled or disabled within the webpage
	protected boolean isEnabled (By elementLocator) {
		if (waitForElement(elementLocator)) {
			return driver.findElement(elementLocator).isEnabled();
		} else {
			logger.error("Elemnt locator not found..." + elementLocator);
			return false;
		}
	}
	
	
	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @return
	 */
	//isDisplyed() is the method used to verify if the web element is Display or not within the webpage
	protected boolean isDisplyed(By elementLocator) {
		if (waitForElement(elementLocator)) {
			return driver.findElement(elementLocator).isDisplayed();
		} else {
			logger.error("Elemnt locator not found..." + elementLocator);
			return false;
		}
	}
	//new added methods
	/**
	 * @author sanjeet.pandit
	 * @param elementLocator
	 * @return
	 */
	//isSelected() is the method used to verify if the web element is Display or not within the webpage
	protected boolean isSelected(By elementLocator) {
		if (waitForElement(elementLocator)) {
			return driver.findElement(elementLocator).isSelected();
		} else {
			logger.error("Elemnt locator not found..." + elementLocator);
			return false;
		}
	}
}
