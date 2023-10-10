package blogportal.application.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorDetailsTest {

    @Test
    public void testGettersAndSetters() {
        // Create sample data
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = "Bad request";
        String description = "The request was invalid.";

        // Create an ErrorDetails instance
        ErrorDetails errorDetails = new ErrorDetails(status, message, description);
        errorDetails.setError(status.getReasonPhrase());
        errorDetails.setMessage(message);
        errorDetails.setStatus(status.value());
        errorDetails.setDescription(description );
        

        // Test getters
        assertEquals(status.value(), errorDetails.getStatus());
        assertEquals(status.getReasonPhrase(), errorDetails.getError());
        assertEquals(message, errorDetails.getMessage());
        assertEquals(description, errorDetails.getDescription());

        // Modify some values using setters
        Date timestamp = new Date();
        String path = "/api/some-resource";
        String message2 = "Additional message";

        errorDetails.setTimestamp(timestamp);
        errorDetails.setPath(path);
        errorDetails.setMessage2(message2);

        // Test getters again
        assertEquals(timestamp, errorDetails.getTimestamp());
        assertEquals(path, errorDetails.getPath());
        assertEquals(message2, errorDetails.getMessage2());
    }
}

