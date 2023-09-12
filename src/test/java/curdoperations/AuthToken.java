package curdoperations;

import io.restassured.path.json.JsonPath;
import pojoclasses.CredentialPojo;
import utils.BaseMethod;
import utils.JsonPathMethod;

/*
 * Generate token in this method.
 * */
public class AuthToken extends BaseMethod {
	public static String generateToken(){
//		End point of Base URI
		String endpoint = "/auth";
//		calling POJO class 
		CredentialPojo credential = new CredentialPojo(username,password);

//		Execute operation for generate token.
		response = 
				httpsrequest.
					header("Content-Type","application/json").body(credential).
				when().
					post(endpoint).
				then().
					log().body().extract().response();
//		Retrieve token from response body.
		JsonPath token = JsonPathMethod.rawToJson(response);
		
		mytoken = token.get("token");
//		return token.
		return mytoken;
	}
}
