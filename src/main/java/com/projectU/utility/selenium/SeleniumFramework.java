package com.projectU.utility.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.projectU.framework.BrowserProcessID;
import com.projectU.framework.DateUtility;
import com.projectU.framework.Driver;
import com.projectU.framework.FolderUtility;
import com.projectU.framework.PropertiesFiles;
import com.projectU.utility.reports.Highlight;
import com.projectU.utility.reports.Report;
import com.projectU.utility.reports.ScreenShot;

/**
 * 
 * @author sanjeet.pandit
 * Description :  Definition of classes.
 */
public interface SeleniumFramework {
	public static Logger logger = Logger.getLogger(SeleniumFramework.class);
	WebDriver driver = Driver.getInstance().getSelenium();
	AlertBox alertBox = new AlertBox();
	Elements element = new Elements();
	Frames frames = new Frames();
	Timer timer = new Timer();
	HandleWindows windows = new HandleWindows();
	JavascriptExecute javascriptExecute = new JavascriptExecute();
	Dropdown dropdown = new Dropdown();
	Lists list = new Lists();
	Report report = new Report();
	Utility utility = new Utility();
	BrowserProcessID seleniumutility=new BrowserProcessID();
	DateUtility dateUtility = new DateUtility();
	ScreenShot screenShot=new ScreenShot();
	Highlight highlights = new Highlight();
	SeleniumUtils seleniumUtils = new SeleniumUtils();
	FolderUtility folderUtility = new FolderUtility();
	BrowserProcessID browserutility = new BrowserProcessID();
	PropertiesFiles prop = new PropertiesFiles();
	BrokenLinks brokenLinks=new BrokenLinks();
	
	
}
