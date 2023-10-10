package blogportal.application.exception;

/**
 * Custom exception class for authentication-related errors in the Blog Portal application.
 */
public class CustomAuthenticationException extends RuntimeException {

    /**
     * Constructs a new custom authentication exception with the specified error message.
     *
     * @param message The error message associated with the exception.
     */
    public CustomAuthenticationException(String message) {
        super(message);
    }
}
