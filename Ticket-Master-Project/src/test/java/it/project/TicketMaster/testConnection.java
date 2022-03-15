package it.project.TicketMaster;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
	static int responseCode;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		try {
			
			url = new URL("https://app.ticketmaster.com/discovery/v2/events?apikey=" + api_key);
		} catch (MalformedURLException e1) {
			
			e1.printStackTrace();
		}
		
		response = new StringBuilder();
		
		try {
			connection = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String currentLine;
			responseCode = connection.getResponseCode();
		
		}catch(Exception e) {System.err.println(e);}
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		connection = null;
		assertNull(connection);
		in.close();
	}

	@Test
	void testApi() throws IOException {
		if(responseCode == 200)
			{
				System.out.println("200");
			}
			else
			{
				System.err.println("Error");
			}
		
			while((currentLine = in.readLine()) != null)
			{
				response.append(currentLine);				
			}
	}

}
