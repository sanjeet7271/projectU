package com.projectU.utility.listeners;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.projectU.utility.selenium.SeleniumFramework;

public class AdditionalConditions implements SeleniumFramework{
	
    public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Boolean.valueOf(((JavascriptExecutor) driver)
                		.executeScript("return (window.angular !== undefined) &&"+
                		"(angular.element(document).injector() !== undefined) &&"+
                		"(angular.element(document).injector().get('$http')"+
                		".pendingRequests.length === 0)").toString());
            }
        };
    }
}