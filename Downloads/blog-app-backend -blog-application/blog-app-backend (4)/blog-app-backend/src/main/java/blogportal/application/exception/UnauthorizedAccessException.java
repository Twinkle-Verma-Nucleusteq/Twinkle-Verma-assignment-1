package blogportal.application.exception;
/**
 * Exception thrown when unauthorized access is detected.
 */
public class UnauthorizedAccessException extends RuntimeException {

  /**
   * Constructs a new UnauthorizedAccessException with the specified message.
   *
   * @param message The detail message explaining the unauthorized access.
   */
  public UnauthorizedAccessException(String message) {
      super(message);
  }
}
