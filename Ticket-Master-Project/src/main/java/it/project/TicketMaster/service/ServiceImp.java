package it.project.TicketMaster.service;

import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
import it.project.TicketMaster.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import org.json.simple.*;
import org.json.simple.parser.ParseException;

@Service
public class ServiceImp {

	private static JSONObject out = new JSONObject();
	private String api_key = "7elxdku9GGG5k8j0Xm8KWdANDgecHMV0";
	private String url = "https://app.ticketmaster.com/discovery/v2/events?apikey=";
	Vector<Long> num = new Vector<Long> ();
	ApiReader file;
	
	//BUILDERS()
	public ServiceImp(ApiReader file) throws FileNotFoundException, IOException, ParseException 
	{
		this.file = file;
		calculator(file.getNum());
		mediaCalculator(this.returnMonthlyEvents());
		mediaCalculator2(this.returnMonthlyEvents());
	}
	
	public ServiceImp(ApiReader file, String city) throws FileNotFoundException, IOException, ParseException
	{
		this.file = file;
		calculator(file.getNum());
		mediaCalculator(this.returnCityEvents(city));
		mediaCalculator2(this.returnCityEvents(city));
	}
	
	public void calculator(Long num)
	{
		out.put("Events", num);
	}

	
	public void mediaCalculator(Vector<Long> num)
	{
		Long sum = null;
		Double Media = null;
		for(int i = 0 ; i < 12; i++)
		{
			sum += num.get(i);
		}
		Media = (double) (sum/12);
		out.put("Monthly average: ", Media);
	}
	
	
	public void mediaCalculator2(Vector<Long> num)
	{
		JSONObject obj1 = new JSONObject();
		Long lastData = null;
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Dicember"};
		int month = 0;
		
		for(int i = 0 ; i < 12; i++)
		{
			if(num.get(i)>lastData)
			{
				lastData = num.get(i);
				month = i;
			}
		}
		obj1.put(months[month], lastData);
		out.put("Month with more events: ", obj1);
	}
	
	
	public Vector<Long> returnMonthlyEvents() throws FileNotFoundException, IOException, ParseException 
	{
		String mese;
		
		for (int i = 1; i <= 12; i++) 
		{
			switch (i) {
				case 2: mese = "&startDateTime=2022-02-01T00:00:00Z&endDateTime=2022-02-28T23:59:59Z"; break;
				case 4, 6, 9: mese = "&startDateTime=2022-0"+i+"-01T00:00:00Z&endDateTime=2022-0"+i+"-30T23:59:59Z"; break;
				case 10: mese = "&startDateTime=2022-10-01T00:00:00Z&endDateTime=2022-10-31T23:59:59Z"; break;
				case 11: mese = "&startDateTime=2022-11-01T00:00:00Z&endDateTime=2022-11-30T23:59:59Z"; break;
				case 12: mese = "&startDateTime=2022-12-01T00:00:00Z&endDateTime=2022-12-31T23:59:59Z"; break;
				default: mese = "&startDateTime=2022-0"+i+"-01T00:00:00Z&endDateTime=2022-0"+i+"-31T23:59:59Z";
			}
			ApiReader file = new ApiReader (url + api_key + "&countryCode=CA" + mese);
    		file.Parser();
    		
    		for(int j = 1; j <= 12; j++)
    		{
    			num.add(file.getNum());
    		}
    	}
		return num;
	}
	
	
	public Vector<Long> returnCityEvents(String city) throws FileNotFoundException, IOException, ParseException 
	{
		String mese;
		
		for (int i = 1; i <= 12; i++) 
		{
			switch (i) {
				case 2: mese = "&startDateTime=2022-02-01T00:00:00Z&endDateTime=2022-02-28T23:59:59Z"; break;
				case 4, 6, 9: mese = "&startDateTime=2022-0"+i+"-01T00:00:00Z&endDateTime=2022-0"+i+"-30T23:59:59Z"; break;
				case 10: mese = "&startDateTime=2022-10-01T00:00:00Z&endDateTime=2022-10-31T23:59:59Z"; break;
				case 11: mese = "&startDateTime=2022-11-01T00:00:00Z&endDateTime=2022-11-30T23:59:59Z"; break;
				case 12: mese = "&startDateTime=2022-12-01T00:00:00Z&endDateTime=2022-12-31T23:59:59Z"; break;
				default: mese = "&startDateTime=2022-0"+i+"-01T00:00:00Z&endDateTime=2022-0"+i+"-31T23:59:59Z";
			}
			ApiReader file = new ApiReader (url + api_key + "&city=" + city + mese);
    		file.Parser();
    		
    		for(int j = 1; j <= 12; j++)
    		{
    			num.add(file.getNum());
    		}
    	}
		return num;
	}
	
	
	public JSONObject getStats()
	{
		return out;
	}
	
}

