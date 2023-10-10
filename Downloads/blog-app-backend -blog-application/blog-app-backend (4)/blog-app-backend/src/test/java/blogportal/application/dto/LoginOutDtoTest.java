package blogportal.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import blogportal.application.Role;
import blogportal.application.payloads.LoginOutDto;

import static org.mockito.Mockito.mock;

public class LoginOutDtoTest {

    @Test
    public void testGetterAndSetterMethods() {
        // Create a LoginOutDto instance
        LoginOutDto loginOutDto = new LoginOutDto();

        // Mock some data for testing
        String username = "testUser";
        String userId = "12345";
        boolean loggedIn = true;
        Role role = Role.ADMIN;

        // Test the setter methods
        loginOutDto.setUsername(username);
        loginOutDto.setUserId(userId);
        loginOutDto.setLoggedIn(loggedIn);
        loginOutDto.setRole(role);

        // Test the getter methods
        assertEquals(username, loginOutDto.getUsername());
        assertEquals(userId, loginOutDto.getUserId());
        assertEquals(loggedIn, loginOutDto.isLoggedIn());
        assertEquals(role, loginOutDto.getRole());
    }

    @Test
    public void testParameterizedConstructor() {
        // Mock some data for testing
        String username = "testUser";
        String userId = "12345";
        boolean loggedIn = true;
        Role role = Role.ADMIN;

        // Create a LoginOutDto instance using the parameterized constructor
        LoginOutDto loginOutDto = new LoginOutDto(username, userId, loggedIn, role);

        // Test the getter methods
        assertEquals(username, loginOutDto.getUsername());
        assertEquals(userId, loginOutDto.getUserId());
        assertEquals(loggedIn, loginOutDto.isLoggedIn());
        assertEquals(role, loginOutDto.getRole());
    }
}
