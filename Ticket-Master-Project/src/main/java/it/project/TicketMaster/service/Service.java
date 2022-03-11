package it.project.TicketMaster.service;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import it.project.TicketMaster.model.Event;

@Component
public interface Service {

	public abstract void calculator(Vector<Event>events);
	public abstract void mediaCalculator(Vector<Long> num);	
	public abstract void mediaCalculator2(Vector<Long> num);
	public abstract JSONObject getStats();
}
