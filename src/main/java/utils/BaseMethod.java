package utils;

import dataprocess.DataProcessClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseMethod extends DataProcessClass {
//	Some important variables.
	protected static RequestSpecification httpsrequest;
	protected static Response response;
	protected static String mytoken = null;
	
// set up methods.
	public static void setupInfo() {
		RestAssured.baseURI = properties.getProperty("baseurl");
		httpsrequest = RestAssured.given();
	}

}
