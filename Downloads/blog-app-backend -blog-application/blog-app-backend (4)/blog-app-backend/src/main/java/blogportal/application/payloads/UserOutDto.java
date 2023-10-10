package blogportal.application.payloads;
/**
 * Represents UserOutDto, which is used to transfer user information to clients.
 */
public class UserOutDto {

  /**
   * The username of the user.
   */
  private String username;

  /**
   * The email address of the user.
   */
  private String email;

  /**
   * The designation or role of the user.
   */
  private String designation;

  /**
   * The unique identifier of the user.
   */
  private String id;

  /**
   * Parameterized constructor for UserOutDto.
   */
  public UserOutDto() {
    this.id = id;
    this.username = username;
    this.email = email;
    this.designation = designation;
  }

  /**
   * Get the username of the user.
   *
   * @return The username.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set the username of the user.
   *
   * @param username The username.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Get the email address of the user.
   *
   * @return The email address.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the email address of the user.
   *
   * @param email The email address.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get the designation or role of the user.
   *
   * @return The designation or role.
   */
  public String getDesignation() {
    return designation;
  }

  /**
   * Set the designation or role of the user.
   *
   * @param designation The designation or role.
   */
  public void setDesignation(String designation) {
    this.designation = designation;
  }

  /**
   * Get the unique identifier of the user.
   *
   * @return The unique identifier.
   */
  public String getId() {
    return id;
  }

  /**
   * Set the unique identifier of the user.
   *
   * @param id The unique identifier.
   */
  public void setId(String id) {
    this.id = id;
  }
}
