package listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import extentreport.ExtentLogger;
import extentreport.ExtentReport;
import utils.BaseMethod;

public class TestListeners implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed.");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped.");
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
			ExtentLogger.fail(result.getMethod().getMethodName()+" is Failed.");
	}

	@Override
	public void onStart(ITestContext context) {
		BaseMethod.setupInfo();
		ExtentReport.initReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.flushReport();
	}

}
