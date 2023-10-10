package blogportal.application.dto;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import blogportal.application.Role;
import blogportal.application.payloads.LoginDto;

public class LoginDtoTest {

  @Mock
  private LoginDto loginDtoMock;

  @Test
  public void testLogin() {
    loginDtoMock = mock(LoginDto.class);

    when(loginDtoMock.getEmail()).thenReturn("test@example.com");
    when(loginDtoMock.getPassword()).thenReturn("password123");
    assertEquals(loginDtoMock.getEmail(), "test@example.com");
    assertEquals(loginDtoMock.getPassword(), "password123");
  }
  @Test
  public void testLoginDtoGettersAndSetters() {

      // Create a LoginDto object with the mockRole
      LoginDto loginDto = new LoginDto(Role.EMPLOYEE);

      // Set values using setters
      loginDto.setEmail("test@example.com");
      loginDto.setPassword("password");

      // Verify that getters return the expected values
      assertEquals(Role.EMPLOYEE, loginDto.getRole());
      assertEquals("test@example.com", loginDto.getEmail());
      assertEquals("password", loginDto.getPassword());
      
      // Set values using setters
      loginDto=new LoginDto("test2@example.com","password1");

      assertEquals("test2@example.com", loginDto.getEmail());
      assertEquals("password1", loginDto.getPassword());
      
  }
}
