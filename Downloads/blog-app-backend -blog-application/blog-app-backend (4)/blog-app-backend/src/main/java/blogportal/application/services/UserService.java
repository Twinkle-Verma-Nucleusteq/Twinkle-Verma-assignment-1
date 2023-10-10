package blogportal.application.services;

import java.io.UnsupportedEncodingException;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import blogportal.application.payloads.LoginDto;
import blogportal.application.payloads.LoginOutDto;
import blogportal.application.payloads.UserInDto;
import blogportal.application.payloads.UserOutDto;

/**
 * The UserService interface provides methods for managing user-related
 * operations.
 */
public interface UserService {
  /**
   * Creates a new user.
   *
   * @param user The UserInDto object containing user information.
   * @return The UserInDto object of the created user.
   */
  UserOutDto createUser(UserInDto user) throws UnsupportedEncodingException;

  /**
   * Authenticates a user based on login credentials.
   *
   * @param logindto The LoginDto object containing login credentials.
   * @return The LoginOutDto object representing the authentication result.
   */
  LoginOutDto loginService(LoginDto logindto);


  /**
   * Updates an existing user's information.
   *
   * @param user   The UserInDto object containing updated user information.
   * @param userId The ID of the user to be updated.
   * @return The UserInDto object of the updated user.
   */
  UserOutDto updateUser(UserInDto user, String userId);

  /**
   * Retrieves a user by their unique ID.
   *
   * @param userId The ID of the user to retrieve.
   * @return The UserInDto object representing the retrieved user.
   */
  UserOutDto getUserById(String userId);

  /**
   * Retrieves a list of all users.
   *
   * @return A list of UserOutDto objects representing all users.
   */
  List<UserOutDto> getAllUsers();

  /**
   * Deletes a user by their unique ID.
   *
   * @param userId The ID of the user to delete.
   */
  void deleteUser(String userId);

  /**
   * Authenticates a user based on login credentials.
   *
   * @param loginDto The LoginDto object containing login credentials.
   * @return A map containing the authentication result and HTTP status.
   */
  Map<Object, HttpStatus> login(LoginDto loginDto);
}
