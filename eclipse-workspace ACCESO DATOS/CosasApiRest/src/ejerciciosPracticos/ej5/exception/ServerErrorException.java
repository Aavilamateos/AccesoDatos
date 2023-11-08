package ejerciciosPracticos.ej5.exception;

public class ServerErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6570899152334177600L;

	public ServerErrorException() {
	}

	public ServerErrorException(String message) {
		super(message);
	}

	public ServerErrorException(Throwable cause) {
		super(cause);
	}

	public ServerErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
