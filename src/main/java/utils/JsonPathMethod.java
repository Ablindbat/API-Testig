package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathMethod {
	
	//returns response in JSON format
		public static JsonPath rawToJson(Response res) {
			String respone = (res).asString();
			JsonPath jsonpath = new JsonPath(respone);
			return jsonpath;
			}

}
