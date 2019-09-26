package com.projectU.utility.selenium;

import java.util.Set;

import org.openqa.selenium.By;
/**
 * 
 * @author Dhiraj.Bendale
 *
 */
public class HandleWindows implements SeleniumFramework{

	private static HandleWindows instance = null;
	private String currentHandle = "";
	private String newWindowHandle = "";
	private String mainWindowHandle = "";

	protected HandleWindows() {
		// TODO Auto-generated constructor stub
	}

	public static HandleWindows getInstance() {
		if (null == instance) {
			instance = new HandleWindows();
		}
		return instance;
	}

	/**
	 * 
	 * @author Dhiraj.Bendale
	 *
	 */
	public void switchToWindow(By elementLocator, int timeOut) {
		currentHandle = driver.getWindowHandle();
		element.click(elementLocator);
		for (int i = 0; i < timeOut; i++) {
			Set<String> allWindowHandles = driver.getWindowHandles();
			if (allWindowHandles.size() > 1) {
				for (String allHandlers : allWindowHandles) {
					if (!allHandlers.equals(currentHandle))
						newWindowHandle = allHandlers;
				}
				driver.switchTo().window(newWindowHandle);
				break;
			} else {
				timer.pause(1);
			}
		}
		if (currentHandle == newWindowHandle) {
			throw new RuntimeException("Time out - No window found");
		}

	}

	/**
	 * 
	 * @author Dhiraj.Bendale
	 *
	 */
	public void CloseAllOpenWindow(String titleMainWindow) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			String windowTitle = driver.switchTo().window(currentWindowHandle).getTitle();
			if (windowTitle.equals(titleMainWindow)) {
				mainWindowHandle = currentWindowHandle;
			} else {
				driver.close();
			}
		}
		driver.switchTo().window(mainWindowHandle);
	}
}
