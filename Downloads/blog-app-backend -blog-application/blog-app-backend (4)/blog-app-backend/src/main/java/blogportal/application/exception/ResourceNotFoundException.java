package blogportal.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class to handle resource not found errors with a specific HTTP status.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
  /**
   * Name of the resource that was not found.
   */
  private String resourceName;

  /**
   * Name of the field associated with the resource.
   */
  private String fieldName;

  /**
   * Value of the field that caused the resource not to be found.
   */
  private Object fieldValue;

    /**
     * Constructs a new ResourceNotFoundException with the specified resource name, field name, and field value.
     *
     * @param resourceName The name of the resource that was not found.
     * @param fieldName    The name of the field associated with the resource.
     * @param fieldValue   The value of the field that caused the resource not to be found.
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    /**
     * Gets the field value that caused the resource not to be found.
     *
     * @return The field value.
     */
    public Object getFieldValue() {
        return fieldValue;
    }

    /**
     * Gets the name of the resource that was not found.
     *
     * @return The resource name.
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * Gets the name of the field associated with the resource.
     *
     * @return The field name.
     */
    public String getFieldName() {
        return fieldName;
    }
}
