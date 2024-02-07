package ceu.dam.ad.examen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class AccessDatabaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4895692956967867176L;

	public AccessDatabaseException() {
	}

	public AccessDatabaseException(String message) {
		super(message);
	}

	public AccessDatabaseException(Throwable cause) {
		super(cause);
	}

	public AccessDatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessDatabaseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
