package blogportal.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Global exception handler for handling custom exceptions in the Blog Portal application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles the `ResourceNotFoundException` exception and returns an appropriate response with error details.
     *
     * @param ex      The `ResourceNotFoundException` exception.
     * @param request The `WebRequest` associated with the request.
     * @return A `ResponseEntity` with error details and an HTTP status of NOT_FOUND.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
