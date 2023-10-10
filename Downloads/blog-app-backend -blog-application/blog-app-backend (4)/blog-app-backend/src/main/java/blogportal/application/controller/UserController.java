package blogportal.application.controller;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import blogportal.application.utils.ConstantURL;
import blogportal.application.payloads.LoginDto;
import blogportal.application.payloads.UserInDto;
import blogportal.application.payloads.UserOutDto;
import blogportal.application.services.UserService;
import javax.validation.Valid;

/**
 * Controller class for handling user-related operations.
 */
@RestController
@RequestMapping(ConstantURL.USER_URL)
@CrossOrigin("*")
public class UserController {
  /**
   * Logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UserController.class.getName() + ".loggerPattern");

  /**
   * UserService.
   */
  @Autowired
  private UserService userService;

  /**
   * Endpoint for creating a new user.
   *
   * @param userInDto The UserInDto object containing user information to be
   *                  created.
   * @return ResponseEntity containing the UserOutDto of the created user and HTTP
   *         status CREATED.
   * @throws UnsupportedEncodingException
   */
  @PostMapping("/create")
  public ResponseEntity<UserOutDto> createUser(@Valid @RequestBody UserInDto userInDto)
      throws UnsupportedEncodingException {
    UserOutDto createUserDto = this.userService.createUser(userInDto);
    LOG.info("User created by controller method");
    return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
  }

  /**
   * Logs in a user.
   * @param loginDto The LoginDto object containing login credentials.
   * @return The ResponseEntity containing a Map with user ID and username, and
   *         HTTP status ACCEPTED.
   */
  @PostMapping("/login")
  public ResponseEntity<?> login(@Validated @RequestBody LoginDto loginDto) {
    Map<Object, HttpStatus> loginOutDto = userService.login(loginDto);
    Object key = loginOutDto.keySet().iterator().next();
    return new ResponseEntity<>(key, loginOutDto.get(key));

  }

  /**
   * Updates an existing user.
   *
   * @param userInDto The UserInDto object containing updated user information.
   * @param userId    The ID of the user to update.
   * @return ResponseEntity containing the updated UserOutDto and HTTP status OK,
   *         or NOT_FOUND if the user is not found.
   */
  @PutMapping("/update/{userId}")
  public ResponseEntity<UserOutDto> updateUser(@Valid @RequestBody UserInDto userInDto, @PathVariable String userId) {
    UserOutDto updatedUserDto = userService.updateUser(userInDto, userId);
    if (updatedUserDto != null) {
      return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  /**
   * Retrieves all users.
   *
   * @return ResponseEntity containing a List of UserOutDto objects for all users
   *         and HTTP status OK.
   */
  @GetMapping("/all")
  public ResponseEntity<List<UserOutDto>> getAllUsers() {
    List<UserOutDto> users = userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  /**
   * Deletes a user by their ID.
   *
   * @param userId The ID of the user to delete.
   * @return ResponseEntity with HTTP status NO_CONTENT.
   */
  @DeleteMapping("/delete/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
    userService.deleteUser(userId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
