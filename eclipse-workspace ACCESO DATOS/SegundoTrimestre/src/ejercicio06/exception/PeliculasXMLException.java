package ejercicio06.exception;

public class PeliculasXMLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3753553721215394006L;

	public PeliculasXMLException() {
	}

	public PeliculasXMLException(String message) {
		super(message);
	}

	public PeliculasXMLException(Throwable cause) {
		super(cause);
	}

	public PeliculasXMLException(String message, Throwable cause) {
		super(message, cause);
	}

	public PeliculasXMLException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
