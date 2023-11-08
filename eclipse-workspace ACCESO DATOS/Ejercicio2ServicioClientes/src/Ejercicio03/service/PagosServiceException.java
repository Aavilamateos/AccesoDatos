package Ejercicio03.service;

public class PagosServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1243644529232922807L;

	public PagosServiceException() {
	}

	public PagosServiceException(String message) {
		super(message);
	}

	public PagosServiceException(Throwable cause) {
		super(cause);
	}

	public PagosServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PagosServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
