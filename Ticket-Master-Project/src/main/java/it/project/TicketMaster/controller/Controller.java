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
	ServiceImp service;
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> getEvents() throws FileNotFoundException, IOException, ParseException,EmptyStringException{
        ResponseEntity<JSONObject> response;
	        try {
	        	ApiReader file = new ApiReader(url + api_key + "&locale=*&countryCode=CA",true);
	        	JSONObject vector = new JSONObject();
	        	file.Parser();
	        	vector = file.publicher();
	            response = new ResponseEntity<JSONObject>(vector,HttpStatus.OK);        
	        } catch(Exception e) {
	        	response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
        return response;
    }
	
	
	 @RequestMapping(value = "/cityEvents", method = RequestMethod.GET)
	 public ResponseEntity<JSONObject>getCityEvents(@RequestParam("city") String city) throws CityNotFoundException, EmptyStringException, WrongParamException, IOException, ParseException{
	      ResponseEntity<JSONObject> response;
		      try {
		        	ApiReader file = new ApiReader(url + api_key + "&city=" + city + "&countryCode=CA",true);
		        	JSONObject vector = new JSONObject();
		        	file.Parser();
		        	vector = file.publicher();
		            response = new ResponseEntity<JSONObject>(vector,HttpStatus.OK);        
		       } catch(Exception e) {
		        	response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		       }
	      return response;
	    }
	
	 
	 @RequestMapping(value = "/StateStats", method = RequestMethod.GET)
	 public ResponseEntity<JSONObject>getStateStats(@RequestParam("stateCode") String stateCode) throws FileNotFoundException, IOException, ParseException,EmptyStringException{
	     ResponseEntity<JSONObject> response;
		     try {
		           ApiReader file = new ApiReader(url + api_key,false);
		           service = new ServiceImp("&stateCode=" + stateCode);
		           response = new ResponseEntity<JSONObject>(service.getStats(),HttpStatus.OK);        
		        } catch(Exception e) {
		        	response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		        }
	     return response;
	    }
	
	
	 @RequestMapping(value = "/CountryStats", method = RequestMethod.GET)
	 public ResponseEntity<JSONObject>getCountryStats(@RequestParam("countryCode") String countryCode) throws FileNotFoundException, IOException, ParseException,EmptyStringException{
	     ResponseEntity<JSONObject> response;
		     try {
		           ApiReader file = new ApiReader(url + api_key,false);
		           service = new ServiceImp("&countryCode=" + countryCode);
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
	        	ApiReader file = new ApiReader (url + api_key,false);
	        	service = new ServiceImp("&city=" + city);
	    		response = new ResponseEntity<JSONObject>(service.getStats(),HttpStatus.OK);
	        } catch(Exception e) {
	        	response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	     return response;
	    }
	    
}

