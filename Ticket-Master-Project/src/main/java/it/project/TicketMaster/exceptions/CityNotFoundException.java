package it.project.TicketMaster.exceptions;

public class CityNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	String mex;
	
	/**
	 * @param mex represents the error message.
	 */
	
	public CityNotFoundException(String mex) {
		super();
		this.mex = mex;
	}
	
	/**
	 * Returns an error message passed by the constructor when the city name was not found.
	 * @return String that contains the error message that is printed.
	 */
	
	public String getMex() {
		return mex;
	}

}
