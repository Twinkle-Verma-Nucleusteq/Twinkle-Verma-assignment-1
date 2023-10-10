package blogportal.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnauthorizedAccessExceptionTest {

    @Test
    public void testUnauthorizedAccessException() {
        // Create an instance of UnauthorizedAccessException with a custom message
        String message = "Unauthorized access detected!";
        UnauthorizedAccessException exception = new UnauthorizedAccessException(message);

        // Test that the message is correctly set
        assertEquals(message, exception.getMessage());
    }
}
