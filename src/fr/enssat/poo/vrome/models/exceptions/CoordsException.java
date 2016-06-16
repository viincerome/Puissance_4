package fr.enssat.poo.vrome.models.exceptions;

public class CoordsException extends RuntimeException {
	private static final long serialVersionUID = 5267139803113442320L;

	/**
	 * Constructs a new CoordsException with default message.
	 */
	public CoordsException() {
		super();
	}

	/**
	 * Constructs a new CoordsException with specified detail message.
	 *
	 * @param message
	 */
	public CoordsException(final String message) {
		super(message);
	}
}
