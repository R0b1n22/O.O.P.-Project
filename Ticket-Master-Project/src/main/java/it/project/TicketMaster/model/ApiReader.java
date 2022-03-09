package it.project.TicketMaster.model;

public class ApiReader {
 
  private String url;
	private JSONObject jsonR;
	private Vector<Event> eventi = new Vector<Event>();
	
	public ApiReader (String url) throws FileNotFoundException, IOException, ParseException {
		this.url = url;
	}
}
