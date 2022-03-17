package it.project.TicketMaster;

import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class testConnection {

	static String api_key = "7elxdku9GGG5k8j0Xm8KWdANDgecHMV0";
	static URL url;
	static HttpURLConnection connection;
	static StringBuilder response;
	static int code;
	
	/**
	 * 
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		try {
			url = new URL("https://app.ticketmaster.com/discovery/v2/events?apikey=" + api_key);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		response = new StringBuilder();
		
		try {
			
	        connection = (HttpURLConnection)url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.connect();

	        code = connection.getResponseCode();
	        System.out.println("Response code of the object is " + code);

		}catch(Exception e) {System.err.println(e);}
		
	}

	/**
	 * 
	 * @throws Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		connection = null;
		assertNull(connection);
	}

	/**
	 * 
	 * @throws IOException
	 */
	@Test
	void testApi() throws IOException {
		if (code==200)
		{
		    System.out.println("OK");
		}
	}

}

