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
import utils.BaseMethod;
import utils.JsonPathMethod;

@Listeners(listner.TestListeners.class)
public class CreateUpdateGetBooking extends BaseMethod {
	private static final Logger log = LogManager.getLogger(CreateUpdateGetBooking.class);
	SoftAssert softAssert = new SoftAssert();
	
	/*
	 * This method sending post request to the server with some pay load.
	 *   */
	@Test(priority = 1)
	public void createBooking(){
		log.info("****Create Booking method execution start.****");
//		End point of URI.
		String endpoint = "/booking";
		log.info("****Token generating.****");
//		calling token generating method.
		String token = AuthToken.generateToken();
		log.info("****Token generated.****");
		
//		Store header elements in hash map.
		HashMap<String, String> headers = new HashMap<String,String>();
		headers.put("cookies", token);
		headers.put("Content-Type", "application/json");
		
//		Calling POJO class 
		log.info("****Calling POJO classes.****");
		BookingDatesPojo bookingdatesobject = new BookingDatesPojo(checkin,checkout);
		BookingDataPojo bookingdatapojo  = 
				new BookingDataPojo(firstname,lastname,totalprice,depositpaid,bookingdatesobject,additionalneeds);
		log.info("****POJO classes called.****");
		
//		calling Response predefine methods.
		log.info("****Response process start.****");
		response =
				httpsrequest.
					headers(headers).body(bookingdatapojo).
				when().
					post(endpoint).
				then().
					log().all().assertThat().statusCode(200).extract().response();
		log.info("****Response process end.****");
//		Deserialization
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
		
//		TestNG soft Assertion.
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
	 * This method functionality is full updating the existing data.
	 * */
	@Test(priority = 2) 
	public void updateBooking() {
		log.info("****Update Booking method execution start.****");
//		End point of URI.
		String endpoint = "/booking/"+id;
		
//		calling token generate method.
		log.info("****Token generating.****");
		String token = AuthToken.generateToken();
		log.info("****Token generated.****");
		
//		Collecting header data using Hash map. 
		HashMap<String, String> headers = new HashMap<String,String>();
		headers.put("Cookie", "token="+token);
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		
//		calling POJO classes.
		log.info("****Calling POJO classes.****");
		BookingDatesPojo bookingdatesobject = new BookingDatesPojo(updatecheckin,updatecheckout);
		BookingDataPojo bookingdatapojo  = 
				new BookingDataPojo(updatefirstname,updatelastname,
						updatetotalprice,updatedepositpaid,bookingdatesobject,updateadditionalneeds);
		log.info("****POJO classes called.****");
		
//		Calling Response predefine methods.
		log.info("****Response process start.****");
		response =
				httpsrequest.
					headers(headers).body(bookingdatapojo).
				when().
					put(endpoint).
				then().
					log().all().assertThat().statusCode(200).extract().response();		
		log.info("****Response process end.****");
		
		log.info("****Deserialization process start.****");
		JsonPath path = JsonPathMethod.rawToJson(response);
		//Retrieving result body data
		
		String body_firstname =path.get("firstname");
		String body_lastname = path.get("lastname");
		String body_totalprice = path.get("totalprice").toString();
		String body_depositpaid = path.get("depositpaid").toString();
		String body_checkin = path.get("bookingdates.checkin");
		String body_checkout =path.get("bookingdates.checkout");
		String body_additionalneeds = path.get("additionalneeds");
		log.info("****Deserialization process ended.****");
		
//		Applying TestNG soft assertion.
		log.info("****Assertion Start.****");
		softAssert.assertEquals(updatefirstname, body_firstname);
		softAssert.assertEquals(updatelastname, body_lastname);
		softAssert.assertEquals(updatetotalprice, body_totalprice);
		softAssert.assertEquals(updatedepositpaid, body_depositpaid);
		softAssert.assertEquals(updatecheckin, body_checkin);
		softAssert.assertEquals(updatecheckout, body_checkout);
		softAssert.assertEquals(updateadditionalneeds, body_additionalneeds);
		log.info("****Assertion ended.****");
	}
	
	/*
	 * This method function is get the using a valid id.
	 * */
	@Test(priority = 3)
	public void getBooking() {
		log.info("****Get Booking method execution start.****");
		String endpoint = "/booking/"+id;
//		Calling Response predefine methods.
		log.info("****Response process start.****");
		response = 
				httpsrequest.
				when().
					get(endpoint).
				then().
					log().all().assertThat().statusCode(200).extract().response();
		log.info("****Response process end.****");
		log.info("****Deserialization process start.****");
		JsonPath path = JsonPathMethod.rawToJson(response);
		//retrieve body data
		String body_firstname =path.get("firstname");
		String body_lastname = path.get("lastname");
		String body_totalprice = path.get("totalprice").toString();
		String body_depositpaid = path.get("depositpaid").toString();
		String body_checkin = path.get("bookingdates.checkin");
		String body_checkout =path.get("bookingdates.checkout");
		String body_additionalneeds = path.get("additionalneeds");
		log.info("****Deserialization process ended.****");
		
		//Applying TestNG assertion.
		log.info("****Assertion start.****");
		softAssert.assertEquals(firstname, body_firstname);
		softAssert.assertEquals(lastname, body_lastname);
		softAssert.assertEquals(totalprice, body_totalprice);
		softAssert.assertEquals(depositpaid, body_depositpaid);
		softAssert.assertEquals(checkin, body_checkin);
		softAssert.assertEquals(checkout, body_checkout);
		softAssert.assertEquals(additionalneeds, body_additionalneeds);
		log.info("****Assertion ended.****");
	}
}
