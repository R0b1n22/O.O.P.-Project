package it.project.TicketMaster.model;

import org.json.simple.JSONObject;

public class Event {
//ATTRIBUTES
	private String id;
	private String name;
	private String genre;
	private String subgenre;
	private String promoter;
	private String url;
	private Long ticketsAvailable;
	private JSONObject priceRange;
	private String date;
	private String hour;
	private String country;
	private String state;
	private String city;
	private String venue;
	private JSONObject healthCheck;
	private JSONObject ageRestriction;	

	/**
	 * Constructor
	 * @param id
	 */
	public Event (String id) {
		this.id = id;
	}
//GETTERS & SETTERS
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSubgenre() {
		return subgenre;
	}

	public void setSubgenre(String subgenre) {
		this.subgenre = subgenre;
	}

	public String getPromoter() {
		return promoter;
	}

	public void setPromoter(String promoter) {
		this.promoter = promoter;
	}

	public Long getTicketsAvailable() {
		return ticketsAvailable;
	}

	public void setTicketsAvailable(Long long1) {
		this.ticketsAvailable = long1;
	}

	public JSONObject getHealthCheck() {
		return healthCheck;
	}

	public void setHealthCheck(JSONObject jsonObject) {
		this.healthCheck = jsonObject;
	}

	public JSONObject getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(JSONObject jsonObject) {
		this.ageRestriction = jsonObject;
	}

	public JSONObject getPriceRanges() {
		return priceRange;
	}

	public void setPriceRanges(JSONObject jsonObject) {
		this.priceRange = jsonObject;	
	}

}
