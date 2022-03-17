package it.project.TicketMaster.exceptions;

public class EmptyStringException extends Exception {

	
	private static final long serialVersionUID = 1L;
	String mex;
	
	/**
	 * @param mex represents the error message.
	 */
	
	public EmptyStringException(String mex) {
		super();
		this.mex=mex;
	}
	
	/**
	 * Returns an error message passed to the constructor when an empty string is entered.
	 * @return String which contains the error message that is printed.
	 */
	
	public String getMex() {
		return mex;
	}
}

