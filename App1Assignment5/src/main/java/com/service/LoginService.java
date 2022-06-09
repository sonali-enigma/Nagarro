package com.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean checkLogin(String uname, String pass) {
		
			// inline will store the JSON data streamed in string format
			String inline = "";

			try {
				URL url = new URL("http://localhost:8052/App2Assignment5/users/"+uname);
				// Parse URL into HttpURLConnection in order to open the connection in order to
				// get the JSON data
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// Set the request to GET or POST as per the requirements
				conn.setRequestMethod("GET");
				// Use the connect method to create the connection bridge
				conn.connect();
				// Get the response status of the Rest API
				int responsecode = conn.getResponseCode();
				System.out.println("Response code is: " + responsecode);

				// Iterating condition to if response code is not 200 then throw a runtime
				// exception
				// else continue the actual process of getting the JSON data
				if (responsecode != 200)
					throw new RuntimeException("HttpResponseCode: " + responsecode);
				else {
					// Scanner functionality will read the JSON data from the stream
					Scanner sc = new Scanner(url.openStream());
					while (sc.hasNext()) {
						inline += sc.nextLine();
					}
					System.out.println("\nJSON Response in String format");
					System.out.println(inline);
					// Close the stream when reading the data has been finished
					sc.close();
				}

				// JSONParser reads the data from string object and break each data into key
				// value pairs
				JSONParser parse = new JSONParser();
				// Type caste the parsed json data in json object
				JSONObject jobj = (JSONObject) parse.parse(inline);
				 
				String password=(String) jobj.get("pass");
				if(password.equals(pass))
					return true;
				// Disconnect the HttpURLConnection stream
				conn.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		

		return false;
	}
}
