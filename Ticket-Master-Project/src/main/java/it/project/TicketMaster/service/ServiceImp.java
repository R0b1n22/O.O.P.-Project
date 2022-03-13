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
	Long num[];
	ApiReader file;
	
	//BUILDER()
	public ServiceImp(String param) throws FileNotFoundException, IOException, ParseException
	{
		this.file = new ApiReader(url + api_key + param,false);
		returnMonthlyEvents(param);
		calculator(file.getNum());
		mediaCalculator(num);
		mediaCalculator2(num);
	}
	
	public void calculator(Long num)
	{
		out.put("events", num);
	}

	
	public void mediaCalculator(Long[] num)
	{
		Long sum = (long) 0;
		Double Media = 0.00;
		for(int i = 0 ; i < 12; i++)
		{
			sum += num.get(i);
		}
		Media = (double) (sum/12);
		out.put("monthlyAverage", Media);
	}
	
	
	public void mediaCalculator2(Long[] num)
	{
		JSONObject obj1 = new JSONObject();
		Long lastData = (long) 0;
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
		obj1.put("month",months[month]);
		obj1.put("eventsNumber",lastData);
		out.put("monthWithMoreEvents", obj1);
	}
	
	
	public void returnMonthlyEvents(String param) throws FileNotFoundException, IOException, ParseException 
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
			this.file = new ApiReader (url + api_key + param + mese,false);
    			file.Parser();
    			num.add(file.getNum());
    		
    		}
		out.put("num",num);
	}
	
	public JSONObject getStats()
	{
		return out;
	}
	
}

