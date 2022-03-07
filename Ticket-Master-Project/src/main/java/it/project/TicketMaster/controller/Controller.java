package it.project.TicketMaster.controller;

import org.springframework.web.bind.annotation.*;

import it.project.TicketMaster.model.ApiReader;
import it.project.TicketMaster.service.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class Controller {

	private String api_key = "7elxdku9GGG5k8j0Xm8KWdANDgecHMV0";

	@Autowired
	Service service;
	ApiReader file = new ApiReader("https://app.ticketmaster.com/discovery/v2/events?apikey=" + api_key + "&locale=*&countryCode=CA");

	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
    public ResponseEntity<Vector<Events>>getEvents() throws FileNotFoundException, IOException, ParseException,EmptyStringException{
        ResponseEntity<Vector<Events>> response;
        try {
        	file.jsonParser();
            response = new ResponseEntity<>(file.getter(), HttpStatus.OK);        
        } catch(Exception e) {
        	response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
	 

	@RequestMapping(value = "/cityEvents", method = RequestMethod.GET)
    public ResponseEntity<Vector<Events>>getCityEvents(@RequestParam("city") String city) throws CityNotFoundException, EmptyStringException, WrongParamException, IOException, ParseException{
        ResponseEntity<Vector<Events>> response;
        try {
        	ApiReader file1 = new ApiReader("https://app.ticketmaster.com/discovery/v2/events?apikey=" + api_key + "&locale=*&city=" + city + "&countryCode=CA");
        	file1.jsonParser();
        	response = new ResponseEntity<>(file.getter(), HttpStatus.OK);        
        } catch(Exception e) {
        	response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

	//@GetMapping(value="/stats")

}
