package blogportal.application.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import blogportal.application.Role;
import blogportal.application.entity.User;
import blogportal.application.payloads.UserInDto;

import static org.assertj.core.api.Assertions.*;

public class UserdDtotest {
  private UserInDto userDto;

  @BeforeEach
  public void setUp() {
    userDto = new UserInDto();
  }

  @Test
  public void testSetAndGetFirstname() {
    userDto.setFirstname("John");
    assertThat(userDto.getFirstname()).isEqualTo("John");
  }

  @Test
  public void testSetAndGetLastname() {
    userDto.setLastname("Doe");
    assertThat(userDto.getLastname()).isEqualTo("Doe");
  }

  @Test
  public void testSetAndGetUsername() {
    userDto.setUsername("johndoe");
    assertThat(userDto.getUsername()).isEqualTo("johndoe");
  }

  @Test
  public void testSetAndGetEmail() {
    userDto.setEmail("john@example.com");
    assertThat(userDto.getEmail()).isEqualTo("john@example.com");
  }

  @Test
  public void testSetAndGetPassword() {
    userDto.setPassword("password123");
    assertThat(userDto.getPassword()).isEqualTo("password123");
  }

  @Test
  public void testSetAndGetDesignation() {
    userDto.setDesignation("Developer");
    assertThat(userDto.getDesignation()).isEqualTo("Developer");
  }

  @Test
  public void testSetAndGetGender() {
    userDto.setGender("male");
    assertThat(userDto.getGender()).isEqualTo("male");
  }

  @Test
  public void testBuild() {

    UserInDto userDto = new UserInDto("9", "johnson", "sharma", "geet", "johni@nucleusteq.com", "Geet@24730",
        "engineer", null, null,null);
    assertThat(userDto.getFirstname()).isEqualTo("johnson");
    assertThat(userDto.getLastname()).isEqualTo("sharma");
    assertThat(userDto.getUsername()).isEqualTo("geet");
    assertThat(userDto.getEmail()).isEqualTo("johni@nucleusteq.com");
    assertThat(userDto.getPassword()).isEqualTo("Geet@24730");
    assertThat(userDto.getDesignation()).isEqualTo("engineer");
    assertThat(userDto.getGender()).isEqualTo(null);
  }
}
