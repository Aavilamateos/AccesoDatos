package ceufct.exception;

public class RegistrosServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6649286897705028365L;

	public RegistrosServiceException() {
	}

	public RegistrosServiceException(String message) {
		super(message);
	}

	public RegistrosServiceException(Throwable cause) {
		super(cause);
	}

	public RegistrosServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public RegistrosServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
