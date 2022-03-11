package it.project.TicketMaster.service;

import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
import it.project.TicketMaster.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import org.json.simple.*;

@Service
public abstract class ServiceImp implements it.project.TicketMaster.service.Service{

	private static JSONObject out = new JSONObject();
	//private Vector<Event>events;
	
	//BUILDER()
	public ServiceImp() 
	{
		super();
	}
	
	@Override
	public void calculator(Vector<Event>events)
	{
		out.put("Events", events.size());
	}

	@Override
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
		
	@Override
	public JSONObject getStats()
	{
		return out;
	}
}
