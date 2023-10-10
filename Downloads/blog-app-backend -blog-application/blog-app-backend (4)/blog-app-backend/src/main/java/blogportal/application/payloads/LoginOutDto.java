package blogportal.application.payloads;

import blogportal.application.Role;

/**
 * A Data Transfer Object (DTO) representing login information after a user logs
 * in.
 */
public class LoginOutDto {
  /**
   * The username of the logged-in user.
   */
  private String username;

  /**
   * The unique identifier of the logged-in user.
   */
  private String userId;

  /**
   * A boolean indicating whether the user is logged in.
   */
  private boolean loggedIn;

  /**
   * The user's role.
   */
  private Role role;

  /**
   * Constructs a new LoginOutDto with the specified role.
   *
   * @param role The user's role.
   */
  public LoginOutDto(Role role) {
    this.role = role;
  }

  /**
   * Default constructor for LoginOutDto.
   */
  public LoginOutDto() {
  }

  /**
   * Constructs a new LoginOutDto with the provided information.
   *
   * @param username The username of the logged-in user.
   * @param userId   The unique identifier of the logged-in user.
   * @param loggedIn A boolean indicating whether the user is logged in.
   * @param role     The user's role.
   */
  public LoginOutDto(String username, String userId, boolean loggedIn, Role role) {
    this.username = username;
    this.userId = userId;
    this.loggedIn = loggedIn;
    this.role = role;
  }

  /**
   * Get the username of the logged-in user.
   *
   * @return The username.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set the username of the logged-in user.
   *
   * @param username The username.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Get the unique identifier of the logged-in user.
   *
   * @return The user's unique identifier.
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Set the unique identifier of the logged-in user.
   *
   * @param userId The user's unique identifier.
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * Check if the user is logged in.
   *
   * @return `true` if the user is logged in, otherwise `false`.
   */
  public boolean isLoggedIn() {
    return loggedIn;
  }

  /**
   * Set the login status of the user.
   *
   * @param loggedIn `true` if the user is logged in, otherwise `false`.
   */
  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  /**
   * Get the role of the logged-in user.
   *
   * @return The user's role.
   */
  public Role getRole() {
    return role;
  }

  /**
   * Set the role of the logged-in user.
   *
   * @param role The user's role.
   */
  public void setRole(Role role) {
    this.role = role;
  }

  /**
   * Returns a string representation of the object.
   *
   * @return A string representation of the object.
   */
  @Override
  public String toString() {
    return "LoginOutDto{" + "username='" + username + '\'' + ", userId=" + userId + ", loggedIn=" + loggedIn + '}';
  }

}
