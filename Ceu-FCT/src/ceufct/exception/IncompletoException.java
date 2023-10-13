package ceufct.exception;

public class IncompletoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7589046510111000522L;

	public IncompletoException() {
	}

	public IncompletoException(String message) {
		super(message);
	}

	public IncompletoException(Throwable cause) {
		super(cause);
	}

	public IncompletoException(String message, Throwable cause) {
		super(message, cause);
	}

	public IncompletoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
