package it.project.TicketMaster.exceptions;

public class EmptyStringException extends Exception {

	
	private static final long serialVersionUID = 1L;
	String mex;
	
	/**
	 * @param mex rappresenta il messaggio di errore.
	 */
	
	public EmptyStringException(String mex) {
		super();
		this.mex=mex;
	}
	
	/**
	 * Restituisce un messaggio di errore passato al costruttore quando viene inserita una stringa vuota.
	 * @return String che contiene il messaggio d'errore che viene stampato.
	 */
	
	public String getMex() {
		return mex;
	}
}

