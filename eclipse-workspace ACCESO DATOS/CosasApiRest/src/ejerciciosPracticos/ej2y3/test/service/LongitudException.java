package ejerciciosPracticos.ej2y3.test.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LongitudException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5256183742914556913L;

	public LongitudException() {
	}

	public LongitudException(String message) {
		super(message);
	}

	public LongitudException(Throwable cause) {
		super(cause);
	}

	public LongitudException(String message, Throwable cause) {
		super(message, cause);
	}

	public LongitudException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
