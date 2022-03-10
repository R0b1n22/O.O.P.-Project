package it.project.TicketMaster.model;

public class ApiReader {
//ATTRIBUTES
	private String url;
	private JSONObject jsonR;
	private Vector<Event> eventi = new Vector<Event>();
//BUILDER	
	public ApiReader (String url) throws FileNotFoundException, IOException, ParseException {
		this.url = url;
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
}
