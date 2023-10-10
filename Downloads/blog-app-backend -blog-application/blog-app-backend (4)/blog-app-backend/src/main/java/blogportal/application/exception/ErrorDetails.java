package blogportal.application.exception;

import org.springframework.http.HttpStatus;
import java.util.Date;

/**
 * Represents details of an error response in the Blog Portal application.
 */
public class ErrorDetails {
  /**
   * The timestamp when the error occurred.
   */
  private Date timestamp;

  /**
   * The HTTP status code associated with the error.
   */
  private int status;

  /**
   * The error message.
   */
  private String error;

  /**
   * An additional error message.
   */
  private String message;

  /**
   * The path where the error occurred.
   */
  private String path;

  /**
   * An additional message (message2).
   */
  private String message2;

  /**
   * The error description.
   */
  private String description;

  // Constructors and getter/setter methods...

  /**
   * Constructor for ErrorDetails.
   *
   * @param status      The HTTP status code associated with the error.
   * @param message     The error message.
   * @param description The error description.
   */
  public ErrorDetails(HttpStatus status, String message, String description) {
    this.timestamp = new Date();
    this.status = status.value();
    this.error = status.getReasonPhrase();
    this.message = message;
    this.description = description;
  }

  /**
   * Gets the timestamp when the error occurred.
   *
   * @return The timestamp as a Date object.
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the timestamp when the error occurred.
   *
   * @param timestamp The timestamp as a Date object.
   */
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Gets the HTTP status code associated with the error.
   *
   * @return The HTTP status code as an integer.
   */
  public int getStatus() {
    return status;
  }

  /**
   * Sets the HTTP status code associated with the error.
   *
   * @param status The HTTP status code as an integer.
   */
  public void setStatus(int status) {
    this.status = status;
  }

  /**
   * Gets the error message.
   *
   * @return The error message as a string.
   */
  public String getError() {
    return error;
  }

  /**
   * Sets the error message.
   *
   * @param error The error message as a string.
   */
  public void setError(String error) {
    this.error = error;
  }

  /**
   * Gets an additional error message.
   *
   * @return The additional error message as a string.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets an additional error message.
   *
   * @param message The additional error message as a string.
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Gets the path where the error occurred.
   *
   * @return The path as a string.
   */
  public String getPath() {
    return path;
  }

  /**
   * Sets the path where the error occurred.
   *
   * @param path The path as a string.
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * Gets an additional message (message2).
   *
   * @return The additional message as a string.
   */
  public String getMessage2() {
    return message2;
  }

  /**
   * Sets an additional message (message2).
   *
   * @param message2 The additional message as a string.
   */
  public void setMessage2(String message2) {
    this.message2 = message2;
  }

  /**
   * Gets the description of the error.
   *
   * @return The error description as a string.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the error.
   *
   * @param description The error description as a string.
   */
  public void setDescription(String description) {
    this.description = description;
  }
}
