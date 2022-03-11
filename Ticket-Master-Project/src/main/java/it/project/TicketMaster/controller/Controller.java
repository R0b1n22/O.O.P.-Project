package it.project.TicketMaster.controller;

import org.springframework.web.bind.annotation.*;

import it.project.TicketMaster.exceptions.CityNotFoundException;
import it.project.TicketMaster.exceptions.EmptyStringException;
import it.project.TicketMaster.exceptions.WrongParamException;
import it.project.TicketMaster.model.ApiReader;
import it.project.TicketMaster.model.Event;
import it.project.TicketMaster.service.ServiceImp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class Controller {

	private String api_key = "7elxdku9GGG5k8j0Xm8KWdANDgecHMV0";
	private String url = "https://app.ticketmaster.com/discovery/v2/events?apikey=";

	@Autowired
	//Service service;
	//Vector<Event> events; 

	
	 @RequestMapping(value = "/events", method = RequestMethod.GET)
	 public ResponseEntity<Vector<Event>> getEvents() throws FileNotFoundException, IOException, ParseException,EmptyStringException{
	        ResponseEntity<Vector<Event>> response;
	        try {
	        	ApiReader file = new ApiReader(url + api_key + "&locale=*&countryCode=CA");
	        	JSONObject vector = new JSONObject();
	        	file.Parser();
	        	vector = file.publicher(file.getter());
	                response = new ResponseEntity<>(HttpStatus.OK);        
	        } catch(Exception e) {
	        	response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        return response;
	    }

	 

	@RequestMapping(value = "/cityEvents", method = RequestMethod.GET)
    	public ResponseEntity<Vector<Event>>getCityEvents(@RequestParam("city") String city) throws CityNotFoundException, EmptyStringException, WrongParamException, IOException, ParseException{
       	       ResponseEntity<Vector<Event>> response;
		try {
			ApiReader file = new ApiReader(url + api_key + "&city=" + city + "&countryCode=CA");
			JSONObject vector = new JSONObject();
			file.Parser();
			vector = file.publicher(file.getter());
		    response = new ResponseEntity<Vector<Event>>(HttpStatus.OK);        
		} catch(Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
   	 }


	@RequestMapping(value = "/StateStats", method = RequestMethod.GET)
    public ResponseEntity<JSONObject>getStateStats(@RequestParam("stateCode") String stateCode) throws FileNotFoundException, IOException, ParseException,EmptyStringException{
        ResponseEntity<JSONObject> response;
        try {
        	Vector<Long> num = new Vector<Long> ();
    		String mese;
    		
    		for (int i = 1; i <= 12; i++) {
    			switch (i) {
    				case 2: mese = "&startDateTime=2022-02-01T00:00:00Z&endDateTime=2022-02-28T23:59:59Z"; break;
    				case 4, 6, 9: mese = "&startDateTime=2022-0"+i+"-01T00:00:00Z&endDateTime=2022-0"+i+"-30T23:59:59Z"; break;
    				case 10: mese = "&startDateTime=2022-10-01T00:00:00Z&endDateTime=2022-10-31T23:59:59Z"; break;
    				case 11: mese = "&startDateTime=2022-11-01T00:00:00Z&endDateTime=2022-11-30T23:59:59Z"; break;
    				case 12: mese = "&startDateTime=2022-12-01T00:00:00Z&endDateTime=2022-12-31T23:59:59Z"; break;
    				default: mese = "&startDateTime=2022-0"+i+"-01T00:00:00Z&endDateTime=2022-0"+i+"-31T23:59:59Z";
    			}
    		ApiReader file = new ApiReader (url + "&stateCode=" + stateCode + mese);
    		file.Parser();
    		num.add(file.getNum());
    		}
    		
        	response = new ResponseEntity<JSONObject>(service.getStats(),HttpStatus.OK);        
        } catch(Exception e) {
        	response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    } 
	
	@RequestMapping(value = "/CityStats", method = RequestMethod.GET)
	    public ResponseEntity<JSONObject>getCityStats(@RequestParam("city") String city) throws FileNotFoundException, IOException, ParseException,EmptyStringException{
		ResponseEntity<JSONObject> response;

		try {
			Vector<Long> num = new Vector<Long> ();
			String mese;

			for (int i = 1; i <= 12; i++) {
				switch (i) {
					case 2: mese = "&startDateTime=2022-02-01T00:00:00Z&endDateTime=2022-02-28T23:59:59Z"; break;
					case 4, 6, 9: mese = "&startDateTime=2022-0"+i+"-01T00:00:00Z&endDateTime=2022-0"+i+"-30T23:59:59Z"; break;
					case 10: mese = "&startDateTime=2022-10-01T00:00:00Z&endDateTime=2022-10-31T23:59:59Z"; break;
					case 11: mese = "&startDateTime=2022-11-01T00:00:00Z&endDateTime=2022-11-30T23:59:59Z"; break;
					case 12: mese = "&startDateTime=2022-12-01T00:00:00Z&endDateTime=2022-12-31T23:59:59Z"; break;
					default: mese = "&startDateTime=2022-0"+i+"-01T00:00:00Z&endDateTime=2022-0"+i+"-31T23:59:59Z";
				}
			ApiReader file = new ApiReader (url + "&city=" + city + mese);
			file.Parser();
			num.add(file.getNum());
			}

			response = new ResponseEntity<JSONObject>(service.getStats(),HttpStatus.OK);
		} catch(Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	    }


}
