package it.project.TicketMaster.model;
//IMPORT
import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiReader {
//ATTRIBUTES
	private String url;
	private JSONObject jsonR;
	private Vector<Event> events = new Vector<Event>();
//BUILDER	
	public ApiReader (String url, boolean flag) throws FileNotFoundException, IOException, ParseException {
		this.url = url;
		this.jsonParser();
		if (flag) this.getter();
	}
//GETTER & SETTER	
	public JSONObject getJsonobj() {
		return jsonR;
	}

	public void setJsonobj(JSONObject jsonobj) {
		this.jsonR = jsonobj;
	}
//PARSER	
	public void jsonParser () throws FileNotFoundException, IOException, ParseException {
		URL url = new URL(this.url);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		JSONParser parser = new JSONParser();
		this.jsonR = (JSONObject) parser.parse(read);
	}
//GETTER
	public Vector<Event> getter () throws FileNotFoundException, IOException, ParseException {
		String id = null;
		JSONObject error = new JSONObject();
		error.put("field", "not defined");
		JSONArray arr = new JSONArray();
		arr.add(error);
		JSONObject event;
		JSONObject embedded = (JSONObject) jsonR.get("_embedded");
		JSONArray jEvents = (JSONArray) embedded.get("events");
		for (int i = 0; i < jEvents.size(); i++) {
		    event = ((JSONObject) jEvents.get(i));
		    Event e = new Event ((String) event.get("id"));
		    e.setName((String) event.get("name"));
		    e.setUrl((String) event.get("url"));
		    e.setDate((String) ((JSONObject) ((JSONObject) event.get("dates")).get("start")).get("localDate"));
		    e.setHour((String) ((JSONObject) ((JSONObject) event.get("dates")).get("start")).get("localTime"));
		    e.setGenre((String) ((JSONObject) ((JSONObject) ((JSONArray) event.get("classifications")).get(0)).get("genre")).get("name"));
		    e.setSubgenre((String) ((JSONObject) ((JSONObject) ((JSONArray) event.get("classifications")).get(0)).get("subGenre")).get("name"));
		    e.setPromoter((String) ((JSONObject) event.getOrDefault("promoter", error)).get("name"));
		    JSONObject obj = (JSONObject) ((JSONArray) event.getOrDefault("priceRanges", arr)).get(0);
		    obj.remove("currency");
		    obj.remove("type");
		    e.setPriceRanges(obj); 
		    e.setTicketsAvailable((Long) ((JSONObject) event.getOrDefault("accessibility", error)).get("ticketLimit"));
		    e.setAgeRestriction((JSONObject) event.getOrDefault("ageRestrictions", error));
		    e.setHealthCheck((JSONObject) ((JSONObject) event.getOrDefault("ticketing", error)).getOrDefault("healthCheck", error));
		    e.setVenue((String) ((JSONObject) ((JSONArray) ((JSONObject) event.get("_embedded")).get("venues")).get(0)).get("name"));
		    e.setCity((String) ((JSONObject) ((JSONObject) ((JSONArray) ((JSONObject) event.get("_embedded")).get("venues")).get(0)).get("city")).get("name"));
		    e.setState((String) ((JSONObject) ((JSONObject) ((JSONArray) ((JSONObject) event.get("_embedded")).get("venues")).get(0)).get("state")).get("name"));
		    e.setCountry((String) ((JSONObject) ((JSONObject) ((JSONArray) ((JSONObject) event.get("_embedded")).get("venues")).get(0)).get("country")).get("name"));
		    events.add(e);  
		}
		return events;
	}
//GET TOTAL ELEMENTS
	public Long getNum () {
		Long num = (Long) ((JSONObject) jsonR.get("page")).get("totalElements");
		return num;
	}
//PUBLICHER
	public JSONObject publicher () {
		JSONArray out = new JSONArray();
		JSONObject json = new JSONObject();
		for(Event e: this.events) {
			out.add(e);
		}
		json.put("Events", out);
		return json;
	}
}
