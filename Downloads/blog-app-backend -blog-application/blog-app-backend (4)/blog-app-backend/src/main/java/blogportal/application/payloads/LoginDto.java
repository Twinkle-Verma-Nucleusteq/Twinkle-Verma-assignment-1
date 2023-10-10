package blogportal.application.payloads;
import blogportal.application.Role;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * A Data Transfer Object (DTO) representing user login information.
 */
public class LoginDto {

  /**
   * The maximum allowed length for a user password.
   */
  private static final int PASSWORD_MAX_LENGTH = 20;

  /**
   * The minimum allowed length for a user password.
   */
  private static final int PASSWORD_MIN_LENGTH = 6;


  /**
   * The user's email address.
   */
  @Email(message = "Invalid email format")
  @NotNull(message = "Email cannot be empty")
  private String email;

  /**
   * The user's role.
   */
  private Role role;

  /**
   * The user's password.
   */
  private String password;

  /**
   * Constructs a new LoginDto with the specified role.
   *
   * @param role The user's role.
   */
  public LoginDto(Role role) {
    this.role = role;
  }

  /**
   * Get the user's role.
   *
   * @return The user's role.
   */
  public Role getRole() {
    return role;
  }

  /**
   * Set the user's role.
   *
   * @param role The user's role.
   */
  public void setRole(Role role) {
    this.role = role;
  }

  /**
   * Get the user's email address.
   *
   * @return The user's email address.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the user's email address.
   *
   * @param email The user's email address.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get the user's password.
   *
   * @return The user's password.
   */
  public String getPassword() {
    return password;
  }
  /**
   * Set the user's password.
   *
   * @param password The user's password.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Constructs a new LoginDto with the specified email and password.
   *
   * @param email    The user's email address.
   * @param password The user's password.
   */
  public LoginDto(@Email(message = "Invalid email format") @NotNull(message = "Email cannot be empty") String email,
      @NotNull(message = "Password cannot be empty")
      @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH,
      message = "Password must be between 6 and 20 characters") String password) {
    this.email = email;
    this.password = password;
}

}
