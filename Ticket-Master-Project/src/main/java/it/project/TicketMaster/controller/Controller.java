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

	
	 @GetMapping(value="/events") 
	 public ResponseEntity<Vector<Events>>getEvents() throws FileNotFoundException, IOException, ParseException{ 
		 file.jsonParser(); 
		 return new ResponseEntity<>(file.getter(), HttpStatus.OK); 
	 }
	 


	@GetMapping(value="/cityEvents")
	public ResponseEntity<Vector<Events>> getCityEvents(@RequestParam String city) throws IOException, ParseException{
		ApiReader file1 = new ApiReader("https://app.ticketmaster.com/discovery/v2/events?apikey=" + api_key + "&locale=*&city=" + city + "&countryCode=CA");
		file1.jsonParser();
		return new ResponseEntity<> (file.getter(), HttpStatus.OK);
	}

	//@GetMapping(value="/stats")

}
