package ceufct.exception;

public class UsuariosServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5763012481766264470L;

	public UsuariosServiceException() {
	}

	public UsuariosServiceException(String message) {
		super(message);
	}

	public UsuariosServiceException(Throwable cause) {
		super(cause);
	}

	public UsuariosServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuariosServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
