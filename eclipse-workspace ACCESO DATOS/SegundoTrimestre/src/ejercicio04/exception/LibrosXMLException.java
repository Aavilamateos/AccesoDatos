package ejercicio04.exception;

public class LibrosXMLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -305649904609772187L;

	public LibrosXMLException() {
	}

	public LibrosXMLException(String message) {
		super(message);
	}

	public LibrosXMLException(Throwable cause) {
		super(cause);
	}

	public LibrosXMLException(String message, Throwable cause) {
		super(message, cause);
	}

	public LibrosXMLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
