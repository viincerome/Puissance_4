package fr.enssat.poo.vrome.models.exceptions;

/**
 * Created by mnantel on 21/06/16.
 */
public class PlayerLoadingException extends RuntimeException {

    private static final long serialVersionUID = 5267139803113442320L;

    /**
     * Constructs a new PlayerLoadingException with default message.
     */
    public PlayerLoadingException() {
        super();
    }

    /**
     * Constructs a new PlayerLoadingException with specified detail message.
     *
     * @param message
     */
    public PlayerLoadingException(final String message) {
        super(message);
    }
}
