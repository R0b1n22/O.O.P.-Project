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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiReader {
//ATTRIBUTES
	private String url;
	private JSONObject jsonR;
	private Vector<Event> events = new Vector<Event>();
//CONSTRUCTOR	
	public ApiReader (String url, boolean doGetter, boolean statsReader) throws FileNotFoundException, IOException, ParseException {
		this.url = url;
		if (doGetter) this.getter();
		else this.jsonParser(0,statsReader);
	}
//GETTER & SETTER	
	public JSONObject getJsonobj() {
		return jsonR;
	}

	public void setJsonobj(JSONObject jsonobj) {
		this.jsonR = jsonobj;
	}
//PARSER	
	public boolean jsonParser (long page, boolean statsReader) throws FileNotFoundException, IOException, ParseException {
		URL url;
		if(statsReader) url = new URL(this.url);
		else url = new URL(this.url + "&page=" + page);
		ResponseEntity response;
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			JSONParser parser = new JSONParser();
			this.jsonR = (JSONObject) parser.parse(read);
			response= new ResponseEntity(HttpStatus.OK);
			return true;
		} catch (Exception e) {
			response = new ResponseEntity(HttpStatus.TOO_MANY_REQUESTS);
			return false;
		}
	}
//GETTER
	public Vector<Event> getter () throws FileNotFoundException, IOException, ParseException {
		String id = null;
		JSONObject error = new JSONObject();
		error.put("field", "not defined");
		JSONArray arr = new JSONArray();
		arr.add(error);
		JSONObject event = new JSONObject();
		JSONObject embedded = new JSONObject();
		JSONArray jEvents = new JSONArray();
		Long num = (long) 1;
		for (long j = 0; j < num; j++) {
			if(this.jsonParser(j, false)) {
				num = (Long) ((JSONObject) jsonR.get("page")).get("totalPages");
				embedded = (JSONObject) jsonR.get("_embedded");
				jEvents = (JSONArray) embedded.get("events");
				for (int i = 0; i < jEvents.size(); i++) {
				    event = ((JSONObject) jEvents.get(i));
				    Event e = new Event ((String) event.get("id"));
				    e.setName((String) event.get("name"));
				    e.setUrl((String) event.get("url"));
				    e.setDate((String) ((JSONObject) ((JSONObject) event.getOrDefault("dates", error)).getOrDefault("start", error)).get("localDate"));
				    e.setHour((String) ((JSONObject) ((JSONObject) event.getOrDefault("dates", error)).getOrDefault("start", error)).get("localTime"));
				    e.setGenre((String) ((JSONObject) ((JSONObject) ((JSONArray) event.getOrDefault("classifications", arr)).get(0)).getOrDefault("genre", error)).get("name"));
				    e.setSubgenre((String) ((JSONObject) ((JSONObject) ((JSONArray) event.getOrDefault("classifications", arr)).get(0)).getOrDefault("subGenre", error)).get("name"));
				    e.setPromoter((String) ((JSONObject) event.getOrDefault("promoter", error)).get("name"));
				    JSONObject obj = (JSONObject) ((JSONArray) event.getOrDefault("priceRanges", arr)).get(0);
				    obj.remove("currency");
				    obj.remove("type");
				    e.setPriceRanges(obj); 
				    e.setTicketsAvailable((Long) ((JSONObject) event.getOrDefault("accessibility", error)).get("ticketLimit"));
				    e.setAgeRestriction((JSONObject) event.getOrDefault("ageRestrictions", error));
				    e.setHealthCheck((JSONObject) ((JSONObject) event.getOrDefault("ticketing", error)).getOrDefault("healthCheck", error));
				    e.setVenue((String) ((JSONObject) ((JSONArray) ((JSONObject) event.get("_embedded")).getOrDefault("venues", arr)).get(0)).get("name"));
				    e.setCity((String) ((JSONObject) ((JSONObject) ((JSONArray) ((JSONObject) event.get("_embedded")).getOrDefault("venues", arr)).get(0)).getOrDefault("city", error)).get("name"));
				    e.setState((String) ((JSONObject) ((JSONObject) ((JSONArray) ((JSONObject) event.get("_embedded")).getOrDefault("venues", arr)).get(0)).getOrDefault("state", error)).get("name"));
				    e.setCountry((String) ((JSONObject) ((JSONObject) ((JSONArray) ((JSONObject) event.get("_embedded")).getOrDefault("venues", arr)).get(0)).getOrDefault("country", error)).get("name"));
				    events.add(e);  
				}
			} else return events;
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
		JSONObject num = new JSONObject();
		num.put("eventsDisplayed",this.events.size());
		out.add(num);
		for(Event e: this.events) {
			out.add(e);
		}
		json.put("Events", out);
		return json;
	}
}
