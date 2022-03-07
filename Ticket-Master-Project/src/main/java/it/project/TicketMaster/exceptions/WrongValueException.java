package it.project.TicketMaster.exceptions;

public class WrongValueException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mex;
	/**
	 * Questo è il costruttore.
	 * @param mex rappresenta il messaggio di errore.
	 */
	public WrongValueException(String mex) {
		super();
		this.mex = mex;
	}
	
	/**
	 * Restituisce un messaggio di errore passato al costruttore quando viene inserita una stringa non ammessa per il value.
	 * @return String che contiene il messaggio d'errore che viene stampato.
	 */
	public String getMex() {
		return mex;
	}

}
