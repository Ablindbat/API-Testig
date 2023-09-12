package extentreport;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<>();
//	getter method
	public static ExtentTest getExtentTest() {
		return extenttest.get();
	}
//	setter method
	public static void setExtentTest(ExtentTest test) {
		extenttest.set(test);
	}
//	close test method.
	public void unload() {
		extenttest.remove();
	}
}
