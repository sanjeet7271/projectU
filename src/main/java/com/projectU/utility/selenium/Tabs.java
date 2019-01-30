package com.projectU.utility.selenium;

import java.util.List;
import org.openqa.selenium.By;

import com.projectU.utility.selenium.SeleniumFramework;

public class Tabs implements SeleniumFramework {

	private By tabs = By.xpath("//*[@id='tab2']");

	public void selectTab(String tabName) {
		utility.selectOption(list.getOption(tabs), tabName);
	}

	public List<String> getTabList(){
		return utility.convertWebElementToString(list.getOption(tabs));
	}
}
