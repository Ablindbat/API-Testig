package extentreport;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {
	private static ExtentReports extent ;

//	Extent report engine.
	public static void initReport() {
		if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReport/index.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Rest Assured Test Report.");
		extent.attachReporter(spark);	
		}
	}
//	Creating test.
	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extent.createTest(testcasename));
		
	}
//	flush report.
	public static void flushReport() {
		if(Objects.nonNull(extent)) {
		extent.flush();
		}
	}

}
