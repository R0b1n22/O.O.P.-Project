package it.project.TicketMaster.exceptions;

public class WrongParamException extends Exception{


	private static final long serialVersionUID = 1L;
	String mex;
	
	/**
	 * @param mex represents the error message.
	 */
	
	public WrongParamException(String mex) {
		super();
		this.mex = mex;
	}
	
	/**
	 * Returns an error message passed to the constructor when an illegal string is entered as a parameter.
	 * @return String which contains the error message that is printed.
	 */
	
	public String getMex() {
		return mex;
	}
}
