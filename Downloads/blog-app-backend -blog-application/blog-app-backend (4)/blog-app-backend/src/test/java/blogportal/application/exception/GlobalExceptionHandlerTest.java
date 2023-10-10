package blogportal.application.exception;

import blogportal.application.exception.GlobalExceptionHandler;
import blogportal.application.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.mockito.Mockito.*;

public class GlobalExceptionHandlerTest {

    @Test
    public void testHandleResourceNotFoundException() {
        // Create a mock of ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException("User", "id", 123);

        // Create a mock of WebRequest
        WebRequest webRequest = mock(WebRequest.class);
        when(webRequest.getDescription(anyBoolean())).thenReturn("Description of the request");

        // Create an instance of GlobalExceptionHandler
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

        // Call the handleResourceNotFoundException method
        ResponseEntity<Object> responseEntity = exceptionHandler.handleResourceNotFoundException(exception, webRequest);

        // Verify that the response entity has the expected status code (NOT_FOUND)
        assert(responseEntity.getStatusCode() == HttpStatus.NOT_FOUND);

        // Verify that the response entity contains the expected error details
        ErrorDetails errorDetails = (ErrorDetails) responseEntity.getBody();
        assert(errorDetails != null);
//        assert(errorDetails.getStatus() == HttpStatus.NOT_FOUND);
        assert(errorDetails.getMessage().equals("User not found with id: '123'"));
        assert(errorDetails.getDescription().equals("Description of the request"));
    }
}
