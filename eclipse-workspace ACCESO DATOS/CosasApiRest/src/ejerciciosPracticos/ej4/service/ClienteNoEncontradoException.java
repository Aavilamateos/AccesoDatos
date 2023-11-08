package ejerciciosPracticos.ej4.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClienteNoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2960627604979648088L;

	public ClienteNoEncontradoException() {
	}

	public ClienteNoEncontradoException(String message) {
		super(message);
	}

	public ClienteNoEncontradoException(Throwable cause) {
		super(cause);
	}

	public ClienteNoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClienteNoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
