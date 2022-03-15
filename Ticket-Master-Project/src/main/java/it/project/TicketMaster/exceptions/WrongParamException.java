package it.project.TicketMaster.exceptions;

public class WrongParamException extends Exception{


	private static final long serialVersionUID = 1L;
	String mex;
	
	/**
	 * @param mex rappresenta il messaggio di errore.
	 */
	
	public WrongParamException(String mex) {
		super();
		this.mex = mex;
	}
	
	/**
	 * Restituisce un messaggio di errore passato al costruttore quando viene inserita una stringa non ammessa come parametro.
	 * @return String che contiene il messaggio d'errore che viene stampato.
	 */
	
	public String getMex() {
		return mex;
	}
}
