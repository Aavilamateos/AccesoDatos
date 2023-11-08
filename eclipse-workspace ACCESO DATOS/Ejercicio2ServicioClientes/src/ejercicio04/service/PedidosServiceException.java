package ejercicio04.service;

public class PedidosServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4702195682296688494L;

	public PedidosServiceException() {
	}

	public PedidosServiceException(String message) {
		super(message);
	}

	public PedidosServiceException(Throwable cause) {
		super(cause);
	}

	public PedidosServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PedidosServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
