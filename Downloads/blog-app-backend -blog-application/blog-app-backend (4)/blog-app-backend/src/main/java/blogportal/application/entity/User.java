
package blogportal.application.entity;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import blogportal.application.Role;

/**
 * Entity class representing a user in the application.
 */
@Document(collection = "user")
public class User {

  /**
   * The unique ID of the user.
   */
  @Id
  private String id;

  /**
   * The first name of the user.
   */
  private String firstname;

  /**
   * The last name of the user.
   */
  private String lastname;

  /**
   * The username of the user.
   */
  private String username;

  /**
   * The email address of the user.
   */
  private String email;

  /**
   * The password of the user.
   */
  private String password;

  /**
   * The designation of the user.
   */
  private String designation;

  /**
   * The gender of the user.
   */
  private String gender;

  /**
   * The role of the user.
   */
  private Role role;
  /**
   * The mobileNumber of the user.
   */
  private String mobileNumber;

  /**
   * Default constructor.
   */
  public User() {
  }

  /**
   * Parameterized constructor to create a user.
   *
   * @param id           The unique ID of the user.
   * @param firstname    The first name of the user.
   * @param lastname     The last name of the user.
   * @param username     The username of the user.
   * @param email        The email address of the user.
   * @param password     The password of the user.
   * @param designation  The designation of the user.
   * @param gender       The gender of the user.
   * @param role         The role of the user.
   * @param mobileNumber the role of the mobileNumber.
   */
  public User(String id, String firstname, String lastname, String username, String email, String password,
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

  // Getter and setter methods for each field

  /**
   * Get the unique ID of the user.
   *
   * @return The ID of the user.
   */
  public String getId() {
    return id;
  }

  /**
   * Set the unique ID of the user.
   *
   * @param id The ID to set.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get the first name of the user.
   *
   * @return The first name of the user.
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * Set the first name of the user.
   *
   * @param firstname The first name to set.
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * Get the last name of the user.
   *
   * @return The last name of the user.
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * Set the last name of the user.
   *
   * @param lastname The last name to set.
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * Get the username of the user.
   *
   * @return The username of the user.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set the username of the user.
   *
   * @param username The username to set.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Get the email address of the user.
   *
   * @return The email address of the user.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the email address of the user.
   *
   * @param email The email address to set.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get the password of the user.
   *
   * @return The password of the user.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set the password of the user.
   *
   * @param password The password to set.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get the designation of the user.
   *
   * @return The designation of the user.
   */
  public String getDesignation() {
    return designation;
  }

  /**
   * Set the designation of the user.
   *
   * @param designation The designation to set.
   */
  public void setDesignation(String designation) {
    this.designation = designation;
  }

  /**
   * Get the gender of the user.
   *
   * @return The gender of the user.
   */
  public String getGender() {
    return gender;
  }

  /**
   * Set the gender of the user.
   *
   * @param gender The gender to set.
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * Get the role of the user.
   *
   * @return The role of the user.
   */
  public Role getRole() {
    return role;
  }

  /**
   * Set the role of the user.
   *
   * @param role The role to set.
   */
  public void setRole(Role role) {
    this.role = role;
  }

  /**
   * Gets the mobile number of the user.
   *
   * @return The mobile number of the user.
   */
  public String getMobileNumber() {
    return mobileNumber;
  }

  /**
   * Sets the mobile number of the user.
   *
   * @param mobileNumber The mobile number to set for the user.
   */
  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  /**
   * Generate the hash code for this user based on its fields.
   *
   * @return The hash code for this user.
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, username, email, password, designation, gender, role, mobileNumber);
  }

  /**
   * Check if this user is equal to another object.
   *
   * @param obj The object to compare with this user.
   * @return True if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;

    }
    User other = (User) obj;
    return Objects.equals(id, other.id) && Objects.equals(firstname, other.firstname)
        && Objects.equals(lastname, other.lastname) && Objects.equals(username, other.username)
        && Objects.equals(email, other.email) && Objects.equals(password, other.password)
        && Objects.equals(designation, other.designation) && Objects.equals(gender, other.gender)
        && Objects.equals(mobileNumber, other.mobileNumber) && role == other.role;

  }

  /**
   * Generate a string representation of this user.
   *
   * @return A string representation of this user.
   */
  @Override
  public String toString() {
    return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
        + ", email=" + email + ", password=" + password + ", designation=" + designation + ", gender=" + gender
        + ", role=" + role + "]";
  }
}