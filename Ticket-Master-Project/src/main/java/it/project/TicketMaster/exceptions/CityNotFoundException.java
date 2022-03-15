package it.project.TicketMaster.exceptions;

public class CityNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	String mex;
	
	/**
	 * @param mex rappresenta il messaggio di errore.
	 */
	
	public CityNotFoundException(String mex) {
		super();
		this.mex = mex;
	}
	
	/**
	 * Restituisce un messaggio di errore passato dal costruttore quando il nome della città non è stato trovato.
	 * @return String che contiene il messaggio d'errore che viene stampato.
	 */
	
	public String getMex() {
		return mex;
	}

}
