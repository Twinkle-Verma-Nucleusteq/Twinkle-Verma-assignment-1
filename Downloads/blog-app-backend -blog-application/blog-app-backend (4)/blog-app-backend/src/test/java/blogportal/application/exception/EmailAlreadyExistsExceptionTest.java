package blogportal.application.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailAlreadyExistsExceptionTest {

    @Test
    public void testConstructor() {
        String email = "test@example.com";
        String expectedErrorMessage = "Email already exists: " + email;
        EmailAlreadyExistsException exception = new EmailAlreadyExistsException(email);

        assertEquals(expectedErrorMessage, exception.getMessage());
    }
}
