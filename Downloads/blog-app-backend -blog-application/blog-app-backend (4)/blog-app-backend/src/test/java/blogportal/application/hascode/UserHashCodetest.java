package blogportal.application.hascode;
import org.junit.jupiter.api.Test;

import blogportal.application.entity.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserHashCodetest {
  @Test
  public void testHashCode() {
    // Create two User objects with identical properties
    User user1 = new User();
    user1.setId("1");
    user1.setFirstname("ram");
    user1.setLastname("Doe");
    user1.setUsername("ramdoe");
    user1.setEmail("ram@example.com");
    user1.setPassword("password");
//        user1.setConfirmpassword("password");
    user1.setDesignation("Developer");
    user1.setGender("male");
    User user2 = new User();
    user2.setId("1");
    user2.setFirstname("ram");
    user2.setLastname("Doe");
    user2.setUsername("ramdoe");
    user2.setEmail("ram@example.com");
    user2.setPassword("password");
//        user2.setConfirmpassword("password");
    user2.setDesignation("Developer");
    user2.setGender("male");
    // Check if the hashCode() values of the two objects are equal
    assertEquals(user1.hashCode(), user2.hashCode());
  }
}
