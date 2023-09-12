package dataprocess;

import utils.PropertiesFileReader;

public class DataProcessClass extends PropertiesFileReader {

		protected static String id = null;
		
//		Credential data fetch from properties file.
		protected static String username = properties.getProperty("username");
		protected static String password = properties.getProperty("password");
	
//	Create Booking data Fetching variables.
		protected static String firstname = properties.getProperty("firstname");
		protected static String lastname = properties.getProperty("lastname");
		protected static int totalprice = Integer.parseInt(properties.getProperty("totalprice"));
		protected static boolean depositpaid =Boolean.parseBoolean(properties.getProperty("depositpaid"));
		protected static String checkin = properties.getProperty("checkin");
		protected static String checkout = properties.getProperty("checkout");
		protected static String additionalneeds = properties.getProperty("additionalneeds");

//	Update Booking Data details fetching variables.
		protected static String updatefirstname = properties.getProperty("updatefirstname");
		protected static String updatelastname = properties.getProperty("updatelastname");
		protected static int updatetotalprice = Integer.parseInt(properties.getProperty("updatetotalprice"));
		protected static boolean updatedepositpaid =Boolean.parseBoolean(properties.getProperty("updatedepositpaid"));
		protected static String updatecheckin = properties.getProperty("updatecheckin");
		protected static String updatecheckout = properties.getProperty("updatecheckout");
		protected static String updateadditionalneeds = properties.getProperty("updateadditionalneeds");

		
}
