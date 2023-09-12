package curdoperations;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import pojoclasses.BookingDataPojo;
import pojoclasses.BookingDatesPojo;
import pojoclasses.PartialUpdatePojo;
import utils.BaseMethod;
import utils.JsonPathMethod;

@Listeners(listner.TestListeners.class)
public class CreatePartialUpadteDeleteBooking extends BaseMethod {
	private static final Logger log = LogManager.getLogger(CreatePartialUpadteDeleteBooking.class);
	SoftAssert softAssert = new SoftAssert();
	
	/*
	 * This method sending post request to the server with some pay load.
	 *   */
	@Test(priority = 1)
	public void createBooking(){
		log.info("****Create Booking method execution start.****");
//		End point of URI.
		String endpoint = "/booking";
		
//		Calling token generate method.
		log.info("****Token generating.****");
		String token = AuthToken.generateToken();
		log.info("****Token generated.****");
		
//		Store header data in hashmap.
		HashMap<String, String> headers = new HashMap<String,String>();
		headers.put("cookies", token);
		headers.put("Content-Type", "application/json");
		
//		Calling POJO class 
		log.info("****Calling POJO classes.****");
		BookingDatesPojo bookingdatesobject = new BookingDatesPojo(checkin,checkout);
		BookingDataPojo bookingdatapojo  = 
				new BookingDataPojo(firstname,lastname,totalprice,depositpaid,bookingdatesobject,additionalneeds);
		log.info("****POJO classes called.****");
		
//		Response operation.
		log.info("****Response process start.****");
		response =
				httpsrequest.
					headers(headers).body(bookingdatapojo).
				when().
					post(endpoint).
				then().
					log().all().assertThat().statusCode(200).extract().response();
		log.info("****Response process end.****");
//		Deserialization.
		log.info("****Deserialization process start.****");
		JsonPath path = JsonPathMethod.rawToJson(response);
//		Retrieving data from response body.
		id  = path.getString("bookingid").toString();
		String body_firstname =path.get("booking.firstname");
		String body_lastname = path.get("booking.lastname");
		String body_totalprice = path.get("booking.totalprice").toString();
		String body_depositpaid = path.get("booking.depositpaid").toString();
		String body_checkin = path.get("booking.bookingdates.checkin");
		String body_checkout =path.get("booking.bookingdates.checkout");
		String body_additionalneeds = path.get("booking.additionalneeds");
		log.info("****Deserialization process end.****");
		
//		Assertions.
		log.info("****Assertion Start.****");
		softAssert.assertEquals(firstname, body_firstname);
		softAssert.assertEquals(lastname, body_lastname);
		softAssert.assertEquals(totalprice, body_totalprice);
		softAssert.assertEquals(depositpaid, body_depositpaid);
		softAssert.assertEquals(checkin, body_checkin);
		softAssert.assertEquals(checkout, body_checkout);
		softAssert.assertEquals(additionalneeds, body_additionalneeds);	
		log.info("****Assertion ended.****");
		log.info("****Create Booking method execution ended.****");
		
	}
	/*
	 * This method sending patch request to the server with some pay load and partially update the data.
	 *   */
	@Test(priority = 2)
	public void partialUpdateBooking() {
		log.info("****Partial Update Booking method execution start.****");
//		End point of URI.
		String endpoint = "/booking/"+id;
		
//		Calling token generate method.
		log.info("****Token generating.****");
		String token = AuthToken.generateToken();
		log.info("****Token generated.****");
		
//		Storing header data in hashmap. 
		HashMap<String, String> headers = new HashMap<String,String>();
		headers.put("Cookie", "token="+token);
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		
//		Calling POJO class
		log.info("****Calling POJO class.****");
		PartialUpdatePojo bookingdatapojo  = 
				new PartialUpdatePojo(updatefirstname,updatelastname);
		log.info("****POJO class called.****");
		
//		Response operation. 
		log.info("****Response process start.****");
		response =
				httpsrequest.
					headers(headers).body(bookingdatapojo).
				when().
					patch(endpoint).
				then().
					log().all().assertThat().statusCode(200).extract().response();
		log.info("****Response process end.****");
//		Deserialization.
		log.info("****Deserialization process start.****");
		JsonPath path = JsonPathMethod.rawToJson(response);
		
//		Retrieve response data.
		String body_firstname =path.get("booking.firstname");
		String body_lastname = path.get("booking.lastname");
		String body_checkin = path.get("booking.bookingdates.checkin");
		String body_checkout =path.get("booking.bookingdates.checkout");
		String body_additionalneeds = path.get("booking.additionalneeds");
		log.info("****Deserialization process end.****");
		
//		Assertions.
		log.info("****Assertion Start.****");
		softAssert.assertEquals(updatefirstname, body_firstname);
		softAssert.assertEquals(updatelastname, body_lastname);
		softAssert.assertEquals(checkin, body_checkin);
		softAssert.assertEquals(checkout, body_checkout);
		softAssert.assertEquals(additionalneeds, body_additionalneeds);	
		log.info("****Assertion ended.****");
		log.info("****Create Booking method execution ended.****");
		
	}
	
	/*
	 * This method sending delete request to the data from server.
	 *   */
	@Test(priority = 3)
	public void deleteBooking() {
		log.info("****Delete Booking method execution start.****");
//		End point of URI
		String endpoint = "/booking/"+id;
		
//		Calling token generate method.
		log.info("****Token generating.****");
		String token = AuthToken.generateToken();
		log.info("****Token generated.****");
		
//		Storing header data in hashmap.
		HashMap<String, String> headers = new HashMap<String,String>();
		headers.put("Cookie", "token="+token);
		headers.put("Content-Type", "application/json");
		
//		Delete Operation.
		log.info("****Response process Start.****");
		response =
				httpsrequest.
					headers(headers).
				when().
					delete(endpoint).
				then().
					log().all().assertThat().statusCode(201).extract().response();
		log.info("****Response process end.****");
		
		
	}
}
