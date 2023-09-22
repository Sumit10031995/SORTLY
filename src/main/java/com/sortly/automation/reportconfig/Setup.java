package com.sortly.automation.reportconfig;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sortly.automation.fileutils.PropertiesReader;
import com.sortly.automation.ui.base.BaseClass;

public class Setup extends BaseClass implements ITestListener {
	private static ExtentReports extentReports;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal();
	public ExtentTest extTest;
	final String screenshotsFilePath = PropertiesReader.getPropertyDetails("extent.reporter.screenshot.out")
			+ "Screenshot" + System.currentTimeMillis() + ".PNG";

	@Override
	public void onStart(ITestContext context) {
		extentReports = ExtentReportManager.setExtentReportConfig();
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extentReports != null)
			extentReports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extTest = extentReports.createTest(result.getMethod().getMethodName());
		extentTest.set(extTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("<<=========Test Run Successfully for method " + result.getMethod().getMethodName()
				+ "=============>>");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
				File destFile = new File(screenshotsFilePath);
				FileUtils.copyFile(srcFile, destFile);
				extentTest.get().addScreenCaptureFromPath(destFile.getAbsolutePath());
				extTest.fail(result.getMethod().getMethodName() + " IS FAIL");

			} else if (result.getStatus() == ITestResult.SKIP) {
				File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
				File destFile = new File(screenshotsFilePath);
				FileUtils.copyFile(srcFile, destFile);
				extentTest.get().addScreenCaptureFromPath(destFile.getAbsolutePath());
				extTest.fail(result.getMethod().getMethodName() + " IS SKIP");

			} else {
				extTest.pass(result.getMethod().getMethodName() + " IS PASSED");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(
				"<<=========Test Run Failed for method " + result.getMethod().getMethodName() + "=============>>");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(
				"<<=========Test Run Skipped for method " + result.getMethod().getMethodName() + "=============>>");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("<<=========Test Run Failed With Success Percentage for method "
				+ result.getMethod().getMethodName() + "=============>>");

	}

}
