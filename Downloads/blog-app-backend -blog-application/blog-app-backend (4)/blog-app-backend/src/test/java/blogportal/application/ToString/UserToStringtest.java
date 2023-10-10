package blogportal.application.ToString;
import org.junit.jupiter.api.Test;
import blogportal.application.entity.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class UserToStringtest {
	@Test
  public void testToString() {
      // Create a User object with sample data
      User user = new User();
      user.setId("1");
      user.setFirstname("ram");
      user.setLastname("doe");
      user.setUsername("ramdoe");
      user.setEmail("ram@example.com");
      user.setPassword("password");
//      user.setConfirmpassword("password");
      user.setDesignation("Developer");
      user.setGender("male");
      // Define the expected string representation
      String expected = "User [id=1, firstname=ram, lastname=doe, username=ramdoe, email=ram@example.com, password=password, designation=Developer, gender=male, role=null]";
      // Check if the toString() method returns the expected string
      assertEquals(expected, user.toString());
  }
}

