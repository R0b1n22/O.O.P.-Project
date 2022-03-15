package it.project.TicketMaster.controller;

import it.project.TicketMaster.exceptions.CityNotFoundException;
import it.project.TicketMaster.exceptions.EmptyStringException;
import it.project.TicketMaster.exceptions.WrongParamException;
import it.project.TicketMaster.model.ApiReader;
import it.project.TicketMaster.service.ServiceImp;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class Controller {

	private String api_key = "7elxdku9GGG5k8j0Xm8KWdANDgecHMV0";
	private String url = "https://app.ticketmaster.com/discovery/v2/events?apikey=";
	
 
	@Autowired
	ServiceImp service;
	
	/**
	 * 
	 * @return response, a ResponseEntity<JSONObject>
	 * @throws FileNotFoundException --> throws exception when it can't find the file
	 * @throws IOException --> Signals that an I/O exception of some sort has occurred
	 * @throws ParseException --> explains why and where the error occurs in source JSON text
	 */
	@RequestMapping(value = "/allEvents", method = RequestMethod.GET)
    	public ResponseEntity<JSONObject> getAllEvents() throws FileNotFoundException, IOException, ParseException{
        ResponseEntity<JSONObject> response;
	        try {
	        	ApiReader file = new ApiReader(url + api_key,true,false);
	            	response = new ResponseEntity<JSONObject>(file.publicher(),HttpStatus.OK);        
	        } catch(Exception e) {
	        	response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
        return response;
        }
	
	/**
	 * 
	 * @param countryCode
	 * @return response, a ResponseEntity<JSONObject>
	 * @throws FileNotFoundException --> throws exception when it can't find the file
	 * @throws IOException --> Signals that an I/O exception of some sort has occurred
	 * @throws ParseException --> explains why and where the error occurs in source JSON text
	 * @throws EmptyStringException --> Returns an error message passed to the constructor when an empty string is entered
	 * @throws WrongParamException --> Returns an error message passed to the constructor when an illegal string is entered as a parameter
	 */
	@RequestMapping(value = "/countryEvents", method = RequestMethod.GET)
    	public ResponseEntity<JSONObject> getCountryEvents(@RequestParam("countryCode") String countryCode) throws FileNotFoundException, IOException, ParseException,EmptyStringException, WrongParamException{
        ResponseEntity<JSONObject> response;
	        try {
	        	ApiReader file = new ApiReader(url + api_key + "&countryCode=" + countryCode,true,false);
	                response = new ResponseEntity<JSONObject>(file.publicher(),HttpStatus.OK);        
	        } catch(Exception e) {
	        	response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
        return response;
        }
	
	/**
	 * 
	 * @param stateCode
	 * @return response, a ResponseEntity<JSONObject>
	 * @throws EmptyStringException --> Returns an error message passed to the constructor when an empty string is entered
	 * @throws WrongParamException --> Returns an error message passed to the constructor when an illegal string is entered as a parameter
	 * @throws IOException --> Signals that an I/O exception of some sort has occurred
	 * @throws ParseException --> explains why and where the error occurs in source JSON text
	 */
	@RequestMapping(value = "/stateEvents", method = RequestMethod.GET)
	public ResponseEntity<JSONObject>getStateEvents(@RequestParam("stateCode") String stateCode) throws EmptyStringException, WrongParamException, IOException, ParseException{
	ResponseEntity<JSONObject> response;
	      try {
			ApiReader file = new ApiReader(url + api_key + "&stateCode=" + stateCode,true,false);
		    	response = new ResponseEntity<JSONObject>(file.publicher(),HttpStatus.OK);        
	       } catch(Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	       }
	 return response;
	 }
	
	/**
	 * 
	 * @param city
	 * @return response, a ResponseEntity<JSONObject>
	 * @throws CityNotFoundException --> Returns an error message passed by the constructor when the city name was not found
	 * @throws EmptyStringException --> Returns an error message passed to the constructor when an empty string is entered
	 * @throws WrongParamException --> Returns an error message passed to the constructor when an illegal string is entered as a parameter
	 * @throws IOException --> Signals that an I/O exception of some sort has occurred
	 * @throws ParseException --> explains why and where the error occurs in source JSON text
	 */
	 @RequestMapping(value = "/cityEvents", method = RequestMethod.GET)
	 public ResponseEntity<JSONObject>getCityEvents(@RequestParam("city") String city) throws CityNotFoundException, EmptyStringException, WrongParamException, IOException, ParseException{
	 ResponseEntity<JSONObject> response;
	      try {
			ApiReader file = new ApiReader(url + api_key + "&city=" + city,true,false);
		    response = new ResponseEntity<JSONObject>(file.publicher(),HttpStatus.OK);        
	       } catch(Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	       }
	 return response;
	 }

	/**
	 * 
	 * @return response, a ResponseEntity<JSONObject>
	 * @throws FileNotFoundException --> throws exception when it can't find the file
	 * @throws IOException --> Signals that an I/O exception of some sort has occurred
	 * @throws ParseException --> explains why and where the error occurs in source JSON text
	 */
	 @RequestMapping(value = "/AllStats", method = RequestMethod.GET)
	 public ResponseEntity<JSONObject>getAllStats() throws FileNotFoundException, IOException, ParseException{
	 ResponseEntity<JSONObject> response;
	     try {
		   service = new ServiceImp(""); 
		   response = new ResponseEntity<JSONObject>(service.getStats(),HttpStatus.OK);        
		} catch(Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	  return response;
	  } 
	 
	 /**
	  * 
	  * @param countryCode
	  * @return response, a ResponseEntity<JSONObject>
	  * @throws FileNotFoundException --> throws exception when it can't find the file
	  * @throws IOException --> Signals that an I/O exception of some sort has occurred
	  * @throws ParseException --> explains why and where the error occurs in source JSON text
	  * @throws EmptyStringException --> Returns an error message passed to the constructor when an empty string is entered
	  * @throws WrongParamException --> Returns an error message passed to the constructor when an illegal string is entered as a parameter
	  */
	 @RequestMapping(value = "/CountryStats", method = RequestMethod.GET)
	 public ResponseEntity<JSONObject>getCountryStats(@RequestParam("countryCode") String countryCode) throws FileNotFoundException, IOException, ParseException,EmptyStringException, WrongParamException{
	 ResponseEntity<JSONObject> response;
	     try {
		   service = new ServiceImp("&countryCode=" + countryCode); 
		   response = new ResponseEntity<JSONObject>(service.getStats(),HttpStatus.OK);        
		} catch(Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	  return response;
	  }
	 
	/**
	 * 
	 * @param stateCode
	 * @return response, a ResponseEntity<JSONObject>
	 * @throws FileNotFoundException --> throws exception when it can't find the file
	 * @throws IOException --> Signals that an I/O exception of some sort has occurred
	 * @throws ParseException --> explains why and where the error occurs in source JSON text
	 * @throws EmptyStringException --> Returns an error message passed to the constructor when an empty string is entered
	 * @throws WrongParamException --> Returns an error message passed to the constructor when an illegal string is entered as a parameter
	 */	
	 @RequestMapping(value = "/StateStats", method = RequestMethod.GET)
	 public ResponseEntity<JSONObject>getStateStats(@RequestParam("stateCode") String stateCode) throws FileNotFoundException, IOException, ParseException,EmptyStringException, WrongParamException{
	 ResponseEntity<JSONObject> response;
	     try {
		   service = new ServiceImp("&stateCode=" + stateCode);
		   response = new ResponseEntity<JSONObject>(service.getStats(),HttpStatus.OK);        
		} catch(Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	 return response;
	 }
	 
	 /**
	  * 
	  * @param city
	  * @return response, a ResponseEntity<JSONObject>
	  * @throws CityNotFoundException --> Returns an error message passed by the constructor when the city name was not found
	  * @throws FileNotFoundException --> throws exception when it can't find the file
	  * @throws IOException --> Signals that an I/O exception of some sort has occurred
	  * @throws ParseException --> explains why and where the error occurs in source JSON text
	  * @throws EmptyStringException --> Returns an error message passed to the constructor when an empty string is entered
	  */
	 @RequestMapping(value = "/CityStats", method = RequestMethod.GET)
	 public ResponseEntity<JSONObject>getCityStats(@RequestParam("city") String city) throws CityNotFoundException, FileNotFoundException, IOException, ParseException,EmptyStringException{
	 ResponseEntity<JSONObject> response;
	        try {
	        	service = new ServiceImp("&city=" + city); 
	    		response = new ResponseEntity<JSONObject>(service.getStats(),HttpStatus.OK);
	        } catch(Exception e) {
	        	response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	 return response;
	 }
	    
}


