package com.qa.app.listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.app.driverFactory.DriverFactory;

public class ExtentReportListener extends DriverFactory implements ITestListener {

	private static final String OUTPUT_FOLDER = "./Reports/";
	private static final String FILE_NAME = "TestExecutionReport-" + System.currentTimeMillis() + ".html";

	private static ExtentReports extent = init();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	private static ExtentReports extentReports;

	private static ExtentReports init() {

		Path path = Paths.get(OUTPUT_FOLDER);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}

		extentReports = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
		reporter.config().setReportName("Open Cart Automation Test Results");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("System", "Windows");
		extentReports.setSystemInfo("Author", "Harsh Bhut");
		extentReports.setSystemInfo("Build#", "1.1");
		extentReports.setSystemInfo("Team", "QA");
		extentReports.setSystemInfo("Customer Name", "NULL");

		return extentReports;
	}

	@Override
	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String qualifiedName = result.getMethod().getQualifiedName();
		int last = qualifiedName.lastIndexOf(".");
		int mid = qualifiedName.substring(0, last).lastIndexOf(".");
		String className = qualifiedName.substring(mid + 1, last);

		System.out.println(methodName + " : " + "Started");
		ExtentTest extentTest = extent.createTest(methodName, result.getMethod().getDescription());
		extentTest.assignCategory(result.getTestContext().getSuite().getName());
		extentTest.assignCategory(className);
		test.set(extentTest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println(result.getMethod().getMethodName() + " Passed");
		String label = "<b>" + "Test Case :- " + result.getMethod().getMethodName().toUpperCase() + " Passed" + "</b>";
		Markup m = MarkupHelper.createLabel(label, ExtentColor.GREEN);
		test.get().pass(m);
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));

	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println(result.getMethod().getMethodName() + " Failed");
		String label = "<b>" + "Test Case :- " + result.getMethod().getMethodName().toUpperCase() + " Passed" + "</b>";
		Markup m = MarkupHelper.createLabel(label, ExtentColor.RED);
		test.get().fail(m);
		test.get().fail(result.getThrowable(), MediaEntityBuilder
				.createScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(), driver)).build());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		String label = "<b>" + "Test Case :- " + result.getMethod().getMethodName().toUpperCase() + " Passed" + "</b>";
		Markup m = MarkupHelper.createLabel(label, ExtentColor.ORANGE);
		test.get().skip(m);
		test.get().skip(result.getThrowable(), MediaEntityBuilder
				.createScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(), driver)).build());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("on Test Failed But within Sucess Percentage for " + result.getMethod().getMethodName());

		String logText = "<b>" + "TEST CASE: - " + result.getMethod().getMethodName().toUpperCase()
				+ " on Test Failed But within Sucess Percentage for" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		test.get().fail(m);
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		System.out.println("on Test Failed with Timeout " + result.getMethod().getMethodName());

		String logText = "<b>" + "TEST CASE: - " + result.getMethod().getMethodName().toUpperCase()
				+ " on Test Failed with Timeout" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		test.get().fail(m);
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));

	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Test Suite started!");

	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println(("Test Suite is ending!"));
		extent.flush();
		test.remove();

	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}
