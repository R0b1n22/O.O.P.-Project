package it.project.TicketMaster;

import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//import java.net.http.HttpClient;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class test {

	 
	@Before
	public void setUp() throws Exception {
		String api_key = "7elxdku9GGG5k8j0Xm8KWdANDgecHMV0";
		URL url = new URL("https://app.ticketmaster.com/discovery/v2/events?apikey=" + api_key);
		
		try {
			 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			 InputStream inputStream = null;
			 BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			 StringBuilder response = new StringBuilder();
			 String currentLine;
			 
			 int responseCode = connection.getResponseCode();
			    
			    if (responseCode == 200) {
			        inputStream = connection.getInputStream();
			    } else {
			        inputStream = connection.getErrorStream();
			    }
	
			    while ((currentLine = in.readLine()) != null) 
			        response.append(currentLine);
	
			    in.close();
		    
			}catch(Exception e) {System.err.println(e);}
		 		
	}
	
	@After
	public void tearDown() throws Exception{
		connection = null;
		assertNull(connection);
	}
	
	@Test
	void contextLoads() {
     return response.toString();
	}
}
