package blogportal.application.entity;

import org.junit.jupiter.api.Test;

import blogportal.application.Role;

import static org.junit.jupiter.api.Assertions.*;

public class UserEntityTest {

    @Test
    public void testEqualsAndHashCode() {
        // Create two User objects with the same values
        User user1 = new User("1", "John", "Doe", "johndoe", "john@example.com", "password", "Author", "Male", Role.ADMIN, "12345");
        User user2 = new User("1", "John", "Doe", "johndoe", "john@example.com", "password", "Author", "Male", Role.ADMIN, "12345");

        // Assert that the objects are equal and have the same hash code
        assertTrue(user1.equals(user2));
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testNotEquals() {
        // Create two User objects with different values
        User user1 = new User("1", "John", "Doe", "johndoe", "john@example.com", "password", "Author", "Male", Role.EMPLOYEE, "12345");
        User user2 = new User("2", "Jane", "Doe", "janedoe", "jane@example.com", "password123", "Editor", "Female", Role.ADMIN, "54321");

        // Assert that the objects are not equal
        assertFalse(user1.equals(user2));
    }

    @Test
    public void testToString() {
        // Create a User object
        User user = new User("1", "John", "Doe", "johndoe", "john@example.com", "password", "Author", "Male", Role.ADMIN, "12345");

        // Assert that the toString method produces the expected output
        assertEquals("User [id=1, firstname=John, lastname=Doe, username=johndoe, email=john@example.com, password=password, designation=Author, gender=Male, role=ADMIN]", user.toString());
    }
}
