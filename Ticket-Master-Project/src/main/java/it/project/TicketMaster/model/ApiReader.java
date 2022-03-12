package it.project.TicketMaster.model;

public class ApiReader {
//ATTRIBUTES
	private String url;
	private JSONObject jsonR;
	private Vector<Event> eventi = new Vector<Event>();
//BUILDER	
	public ApiMenager (String url, boolean flag) throws FileNotFoundException, IOException, ParseException {
		this.url = url;
		this.parser();
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
	public Vector<Event> getter () {
		String id = null;
		JSONObject event;
		JSONObject embedded = (JSONObject) jsonR.get("_embedded");
		JSONArray events = (JSONArray) embedded.get("events");
		for (int i = 0; i < events.size(); i++) {  
		    event = ((JSONObject) events.get(i));
		    Event e = new Event ((String) event.get("id"));
		    e.setName((String) event.get("name"));
		    e.setUrl((String) event.get("url"));
		    JSONObject obj = (JSONObject) event.get("dates");
		    obj = (JSONObject) obj.get("start");
		    e.setDate((String) obj.get("localDate"));
		    e.setHour((String) obj.get("localTime"));
		    JSONArray arr = (JSONArray) event.get("classifications");
		    obj = (JSONObject) arr.get(0);
		    obj = (JSONObject) obj.get("genre");
		    e.setGenre((String) obj.get("name"));
		    obj = (JSONObject) event.get("_embedded");
		    arr = (JSONArray) obj.get("venues");
		    obj = (JSONObject) arr.get(0);
		    e.setVenue((String) obj.get("name"));
		    JSONObject app = obj;
		    obj = (JSONObject) obj.get("city");
		    e.setCity((String) obj.get("name"));
		    obj = (JSONObject) app.get("state");
		    e.setState((String) obj.get("name"));
		    obj = (JSONObject) app.get("country");
		    e.setCountry((String) obj.get("name"));
		    eventi.add(e);    
		}
		return eventi;
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
