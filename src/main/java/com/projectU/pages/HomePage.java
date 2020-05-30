package com.projectU.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.projectU.utility.selenium.SeleniumFramework;


/**
 * 
 * @author sanjeetpandit
 *
 */
public class HomePage implements SeleniumFramework {
	
	private static Logger logger = Logger.getLogger(HomePage.class);
	//Actions action = new Actions(selenium);
	/**
	 * Xpaths
	 */
	String hoverXpath = "//a[@class='sf-with-ul']";
	String tShirtXpth = "//a[contains(text(),'T-shirts')]";
	String productsXpath = "//ul[contains(@class,'product_list grid row')]";

	String firstProductXpath = "//div[@class='right-block']//h5//a[@class='product-name']";
	String searchBoxXpath = "//input[@class='search_query form-control ac_input']";
	String searchButtonXpath = "//button[@class='btn btn-default button-search']";
	String productBoxXpath = "//ul[contains(@class,'product_list grid row')]";

	//CommonUtilty common = new CommonUtilty();
	
	String firstProduct="Faded Short Sleeve T-shirts";
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * @param driver
	 * @return title of the page
	 * @throws InterruptedException
	 */
	public String verifyHomePageTitle(){
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}

	/**
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */

	public void hoverOnWomenLink() throws InterruptedException {
		if (element.waitForElement(By.xpath(String.format(hoverXpath, "Women")))) {
				element.hoverCurser(By.xpath(hoverXpath));
		
			}
		logger.info("--Successfully Navigated to New Payee Page.--");
	}
	public void findTShirtlinkAndHover() {
		if(element.waitForElement(By.xpath(String.format(tShirtXpth, "T-shirts")))) {
			element.hoverCurser(By.xpath(tShirtXpth));
		}
	}
	
	public void clickOnTShirtLink() {
		if(element.waitForElement(By.xpath(String.format(tShirtXpth, "T-shirts")))) {
			element.click(By.xpath(String.format(tShirtXpth, "T-shirts")),"T-shirts");
		}
	}
	
	public String findFirstproductSearch() {
		String productName = null;
		if(element.waitForElement(By.xpath(String.format(firstProductXpath, "T-shirts")))) {
			productName=element.getText(By.xpath(firstProductXpath));
			System.out.println(productName);
			Assert.assertEquals(productName, firstProduct,"alert is not same as expected.");
		}
		return productName;
	}
	
	public void productSearch(String productName) {
		if(element.waitForElement(By.xpath(String.format(searchBoxXpath, "1st Product name")))) {
			element.sendKeys(By.xpath(String.format(searchBoxXpath, "1st Product name")), productName);
			System.out.println(productName);
			Assert.assertEquals(productName, firstProduct,"alert is not same as expected.");
		}
	}
	
	public void clickOnSearchButton() {
		if(element.waitForElement(By.xpath(String.format(searchButtonXpath, "click on search button")))) {
			element.click(By.xpath(String.format(searchButtonXpath, "Search button")),"Search button");
		}
	}

}
