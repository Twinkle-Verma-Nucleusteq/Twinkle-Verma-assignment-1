package blogportal.application.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomAuthenticationExceptionTest {

    @Test
    public void testConstructor() {
        String errorMessage = "Authentication failed";
        CustomAuthenticationException exception = new CustomAuthenticationException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }
}
