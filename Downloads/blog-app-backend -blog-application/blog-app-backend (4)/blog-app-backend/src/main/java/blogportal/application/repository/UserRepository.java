package blogportal.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.validation.annotation.Validated;
import blogportal.application.entity.User;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing users in the database.
 */
@Validated
public interface UserRepository extends MongoRepository<User, String> {

  /**
   * Check if a user with the specified email exists in the database.
   *
   * @param email The email to check.
   * @return `true` if a user with the email exists, `false` otherwise.
   * 
   *         This method is used to determine whether a user with a given email
   *         address already exists in the database. It helps ensure that there
   *         are no duplicate email addresses for users.
   */
  boolean existsByEmail(@NotBlank @Email String email);

  /**
   * Find users by their email and password.
   *
   * @param email    The email of the user.
   * @param password The password of the user.
   * @return A list of users matching the provided email and password.
   * 
   *         This method is used for authentication purposes. It allows searching
   *         for users by their email and password to verify their credentials
   *         during login.
   */
  List<User> findByEmailAndPassword(@NotBlank @Email String email, @NotBlank String password);

  /**
   * Find a user by their email.
   *
   * @param email The email of the user to find.
   * @return An `Optional` containing the user if found, or an empty `Optional` if
   *         not found.
   * 
   *         This method is used to retrieve a user by their email address. It
   *         returns an `Optional` to handle cases where the user may or may not
   *         exist in the database.
   */
  Optional<User> findByEmail(@NotBlank @Email String email);

  /**
   * Save a user entity to the database.
   *
   * @param user The user entity to save.
   * @return The saved user entity.
   * 
   *         This method is used to persist (save) a user entity to the database.
   *         It ensures that user data is stored in the database for later
   *         retrieval and management.
   */
  @Override
  <S extends User> S save(@Valid S user);
}
