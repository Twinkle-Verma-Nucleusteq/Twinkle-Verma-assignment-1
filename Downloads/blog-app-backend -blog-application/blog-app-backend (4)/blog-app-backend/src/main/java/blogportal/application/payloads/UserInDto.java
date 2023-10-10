package blogportal.application.payloads;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import blogportal.application.Role;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Represents the input data for creating a user.
 */
@Document
public class UserInDto {

  /**
   * Minimum length for the user's first name.
   */
  private static final int MIN_FIRST_NAME_LENGTH = 3;

  /**
   * Maximum length for the user's first name.
   */
  private static final int MAX_FIRST_NAME_LENGTH = 50;

  /**
   * Minimum length for the user's last name.
   */
  private static final int MIN_LAST_NAME_LENGTH = 3;

  /**
   * Maximum length for the user's last name.
   */
  private static final int MAX_LAST_NAME_LENGTH = 50;

  /**
   * Minimum length for the user's username.
   */
  private static final int MIN_USERNAME_LENGTH = 4;

  /**
   * Maximum length for the user's username.
   */
  private static final int MAX_USERNAME_LENGTH = 20;

  /**
   * Minimum length for the user's password.
   */
  private static final int MIN_PASSWORD_LENGTH = 6;

  /**
   * Maximum length for the user's password.
   */
  private static final int MAX_PASSWORD_LENGTH = 20;

  /**
   * Minimum length for the user's designation.
   */
  private static final int MIN_DESIGNATION_LENGTH = 2;

  /**
   * Maximum length for the user's designation.
   */
  private static final int MAX_DESIGNATION_LENGTH = 50;

  /**
   * Regular expression pattern for validating the user's gender.
   */
  private static final String GENDER_PATTERN = "^(Male|Female)$";
  /**
   * The unique identifier for the user.
   */
  private String id;

  /**
   * The user's first name.
   */
  @NotEmpty(message = "First name cannot be empty")
  @Size(min = MIN_FIRST_NAME_LENGTH, max = MAX_FIRST_NAME_LENGTH, message = "First name must be between 2 and 50 characters")
  private String firstname;

  /**
   * The user's last name.
   */
  @NotEmpty(message = "Last name cannot be empty")
  @Size(min = MIN_LAST_NAME_LENGTH, max = MAX_LAST_NAME_LENGTH, message = "Last name must be between 2 and 50 characters")
  private String lastname;

  /**
   * The user's username.
   */
  @NotEmpty(message = "Username cannot be empty")
  @Size(min = MIN_USERNAME_LENGTH, max = MAX_USERNAME_LENGTH, message = "Username must be between 4 and 20 characters")
  //@Pattern(regexp = "^[A-Za-z0-9]*$", message = "Username can only contain letters and numbers")
  @Indexed(unique = true)
  private String username;

  /**
   * The user's email address.
   */
  @Email(message = "Invalid email format")
  @NotEmpty(message = "Email cannot be empty")
  @Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com*$", message = "Email should be valid ")
  @Indexed(unique = true)
  private String email;

  /**
   * The user's password.
   */
  @NotEmpty(message = "Password cannot be empty")
  @Size(min = MIN_PASSWORD_LENGTH, max = MAX_PASSWORD_LENGTH, message = "Password must be between 6 and 20 characters")
  private String password;

  /**
   * The user's designation.
   */
  @NotEmpty(message = "Designation cannot be empty")
  @Size(min = MIN_DESIGNATION_LENGTH, max = MAX_DESIGNATION_LENGTH, message = "Designation must be between 2 and 50 characters")
  private String designation;

  /**
   * The user's gender.
   */
  @NotEmpty(message = "Gender cannot be empty")
  @Pattern(regexp = GENDER_PATTERN, message = "Invalid gender value")
  private String gender;

  /**
   * The user's role.
   */
  private Role role;

  /**
   * The user's mobile number.
   */
 // @NotEmpty(message = "Mobile number cannot be empty")
  private String mobileNumber;

  // Getter and setter methods (not shown for brevity)
  /**
   * Default constructor for UserInDto.
   */
  public UserInDto() {
  }

  /**
   * Constructs a new UserInDto with the specified information.
   *
   * @param id           The unique identifier for the user.
   * @param firstname    The user's first name.
   * @param lastname     The user's last name.
   * @param username     The user's username.
   * @param email        The user's email address.
   * @param password     The user's password.
   * @param designation  The user's designation.
   * @param gender       The user's gender ("Male" or "Female").
   * @param role         The user's role (e.g., ADMIN or EMPLOYEE).
   * @param mobileNumber The user's mobile number.
   */
  public UserInDto(String id, String firstname, String lastname, String username, String email, String password,
      String designation, String gender, Role role, String mobileNumber) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.email = email;
    this.password = password;
    this.designation = designation;
    this.gender = gender;
    this.role = role;
    this.mobileNumber = mobileNumber;
  }

  /**
   * Get the unique identifier for the user.
   *
   * @return The unique identifier.
   */
  public String getId() {
    return id;
  }

  /**
   * Set the unique identifier for the user.
   *
   * @param id The unique identifier to set.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get the user's first name.
   *
   * @return The first name.
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * Set the user's first name.
   *
   * @param firstname The first name to set.
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * Get the user's last name.
   *
   * @return The last name.
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * Set the user's last name.
   *
   * @param lastname The last name to set.
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * Get the user's username.
   *
   * @return The username.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set the user's username.
   *
   * @param username The username to set.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Get the user's email address.
   *
   * @return The email address.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the user's email address.
   *
   * @param email The email address to set.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get the user's password.
   *
   * @return The password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set the user's password.
   *
   * @param password The password to set.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get the user's designation.
   *
   * @return The designation.
   */
  public String getDesignation() {
    return designation;
  }

  /**
   * Set the user's designation.
   *
   * @param designation The designation to set.
   */
  public void setDesignation(String designation) {
    this.designation = designation;
  }

  /**
   * Get the user's gender.
   *
   * @return The gender.
   */
  public String getGender() {
    return gender;
  }

  /**
   * Set the user's gender.
   *
   * @param gender The gender to set.
   */
  public void setGender(String gender) {
    this.gender = gender;
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
   * Get the user's mobile number.
   *
   * @return The mobile number.
   */
  public String getMobileNumber() {
    return mobileNumber;

  }

  /**
   * Sets the mobile number for the user.
   *
   * @param mobileNumber The mobile number to set for the user.
   */
  public void setMobileNumber(String mobileNumber) {
      this.mobileNumber = mobileNumber;
  }

}
