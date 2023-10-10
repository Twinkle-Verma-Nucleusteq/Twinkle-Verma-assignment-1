package blogportal.application.exception;

/**
 * Custom exception to indicate that an email address already exists in the system.
 */
public class EmailAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new EmailAlreadyExistsException with the specified email.
     *
     * @param email The email address that already exists.
     */
    public EmailAlreadyExistsException(String email) {
        super("Email already exists: " + email);
    }
}
