package extentreport;

public class ExtentLogger {
	
//	Contractor
	private ExtentLogger() {}
//	Pass Status.
	public static void pass(String massage) {
		ExtentManager.getExtentTest().pass(massage);
	}
//	Failed status.
	public static void fail(String massage){
		ExtentManager.getExtentTest().fail(massage);
		
		
	}
//	Skip status.
	public static void skip(String massage) {
		ExtentManager.getExtentTest().skip(massage);
	}
	
}
