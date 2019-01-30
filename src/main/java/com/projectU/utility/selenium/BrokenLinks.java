package com.projectU.utility.selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.projectU.utility.selenium.SeleniumFramework;

/**
 * 
 * @author Sanjeet.Pandit
 *
 */
public class BrokenLinks implements SeleniumFramework {

	public void CheckBrokenLinks() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are present " + links.size());
		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");
			verifyLinkActive(url);

		}
	}

	/**
	 * 
	 * @author Sanjeet.Pandit
	 *
	 */
	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setRequestMethod("GET");
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(httpURLConnect.getResponseCode() + " : " + linkUrl + " - "
						+ httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(httpURLConnect.getResponseCode() + " : " + linkUrl + " - "
						+ httpURLConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author Sanjeet.Pandit
	 *
	 */
	public void SelectDate(By elementlocateor) {

		List<WebElement> allDates = driver.findElements(elementlocateor);

		for (WebElement ele : allDates) {
			String date = ele.getText();
			if (date.equalsIgnoreCase("14")) {
				ele.click();
				timer.pause(5);
				System.out.println(date);
				break;
			}

		}
	}

}
