package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader{
	//Fetching Property file.
		protected static File file = new File("./Payload/payload.properties");
		protected static FileInputStream fiStream = null;
		protected static Properties properties = new Properties();
		
		//handling exception.
		static {
			try {
			fiStream = new FileInputStream(file);
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				properties.load(fiStream);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
}
