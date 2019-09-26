package com.projectU.utility.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * 
 * @author sanjeet.pandit
 *
 */
public class JavascriptExecute  implements SeleniumFramework{
	
	private static JavascriptExecute instance = null;
	private JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

	protected JavascriptExecute() {

	}

	public static JavascriptExecute getInstance() {
		if (null == instance) {
			instance = new JavascriptExecute();
		}
		return instance;
	}
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */	
	public void scrollDown() {
		jsExecutor.executeScript("scroll(0,250)");
	}
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void scrollUp() {
		jsExecutor.executeScript("scroll(250,0)");
	}
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void scrollToBottom() {
		jsExecutor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.body.clientHeight));");
	}
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void click(By elementLocator) {
		clickMethod(elementLocator);
	}
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	private void clickMethod(By elementLocator) {
		try {
			if (element.isEnabled(elementLocator) && element.isDisplyed(elementLocator)) {
				jsExecutor.executeAsyncScript("arguments[0].click();",driver.findElement(elementLocator));
			}else {
				logger.info("");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 
	 * @author sanjeet.pandit
	 *
	 */
	public void scrollToElementClick(By elementLocator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView();",driver.findElement(elementLocator));
	}
}
