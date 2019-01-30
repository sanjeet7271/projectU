package com.projectU.utility.listeners;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.projectU.framework.constants.FrameworkConstant;
import com.projectU.framework.constants.ReportConstant;
import com.projectU.framework.constants.SeleniumConstant;
import com.projectU.framework.constants.TestcaseConstant;
import com.projectU.utility.selenium.SeleniumFramework;

/**
 * 
 * @author Sanjeet.Pandit
 *
 */
public class DotTestListener implements ITestListener,SeleniumFramework {

	private static Logger logger = Logger.getLogger(DotTestListener.class);
	private String appendScreenshot = "";
	public void onFinish(ITestContext arg0) {
		int numTestSuccess = arg0.getPassedTests().size();
		int numTestFailed = arg0.getFailedTests().size();
		System.out.println("No of Pass Test cases :-" + numTestSuccess);
		System.out.println("No of Failed Test cases :-" + numTestFailed);
		ReportConstant.EXTENT.flush();
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		ITestNGMethod[] test = arg0.getAllTestMethods();
		System.out.println(test);
		System.out.println("on test start");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {

		TestcaseConstant.TESTCASE_ENDTIME = dateUtility.getCurrentTime();
		//ReportConstant.STEP.log(Status.FAIL," " + screen.takeSnapShot());
		/*if (ReportConstant.HTML_REPORT.equalsIgnoreCase("Yes")) {
			ReportConstant.STEP.log(Status.FAIL,screen.takeSnapShot());
		}*/
		String screenShotPath = "";
		logger.info("Step : " + TestcaseConstant.STEP_COUNTER + " : ");
		if (SeleniumConstant.SCREEN_SHOT.equalsIgnoreCase("Yes")) {
			screenShotPath = screenShot.takeSnapShot();
			appendScreenshot = "<td>" + "<a href=\"" + FrameworkConstant.SCREENSHOT_LOCATION + File.separator
					+ screenShotPath + "\">   Screenshot</a></td>";
			if (ReportConstant.HTML_REPORT.equalsIgnoreCase("Yes")) {
				ReportConstant.STEP.log(Status.FAIL, "Test case failed here " + appendScreenshot);
			}
		} 
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		ReportConstant.STEP.log(Status.SKIP, arg0.getMethod().getMethodName() + "Test Case is skipped");
	}

	/**
	 * 
	 * @author Sanjeet.Pandit
	 *
	 */
	public void onTestStart(ITestResult arg0) {
		ReportConstant.STEP = ReportConstant.EXTENT.createTest(arg0.getMethod().getDescription());
		logger.debug("Initialise Step Counter to 0.");
	}

	/**
	 * 
	 * @author Sanjeet.Pandit
	 *
	 */
	public void onTestSuccess(ITestResult arg0) {
		TestcaseConstant.TESTCASE_ENDTIME = dateUtility.getCurrentTime();
	}
}
