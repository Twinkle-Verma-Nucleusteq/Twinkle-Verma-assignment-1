package blogportal.application.services.impl;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import blogportal.application.Role;
import blogportal.application.entity.User;
import blogportal.application.exception.CustomAuthenticationException;
import blogportal.application.exception.EmailAlreadyExistsException;
import blogportal.application.exception.ResourceNotFoundException;
import blogportal.application.payloads.LoginDto;
import blogportal.application.payloads.LoginOutDto;
import blogportal.application.payloads.UserInDto;
import blogportal.application.payloads.UserOutDto;
import blogportal.application.repository.UserRepository;
import blogportal.application.services.UserService;
import blogportal.application.utils.BlogportalCommonFunctions;

/**
 * Implementation of the UserService interface for managing user-related
 * operations.
 */
@Service
public class UserServiceimpl implements UserService {
  /**
   * Repository for managing user-related operations in the database.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * A utility for mapping between different data structures using configuration
   * settings.
   */
  @Autowired
  private ModelMapper modelMapper;

  /**
   * An instance of the BlogportalCommonFunctions utility class for common
   * functions and operations.
   */
  private BlogportalCommonFunctions blogportalCommonFunctions = new BlogportalCommonFunctions();

  /**
   * Indicates that a method declaration is intended to override a method
   * declaration in a superclass. It helps ensure that the method is correctly
   * overridden and provides clarity in the code.
   */
  @Override

  public UserOutDto createUser(UserInDto userdto) throws UnsupportedEncodingException {
    System.out.println("Inside Create User");
    System.out.println(userRepository.existsByEmail(userdto.getEmail()));

    if (!userRepository.existsByEmail(userdto.getEmail())) {

      if (userdto.getRole() == null) {
        userdto.setRole(Role.EMPLOYEE);
      }
      User user = this.modelMapper.map(userdto, User.class);
      User adduser = this.userRepository.save(user);
      return this.modelMapper.map(adduser, UserOutDto.class);
    } else {
      throw new EmailAlreadyExistsException(userdto.getEmail());
    }
  }

  /**
   * Indicates that a method declaration is intended to override a method
   * declaration in a superclass. It helps ensure that the method is correctly
   * overridden and provides clarity in the code.
   */
  @Override
  public Map<Object, HttpStatus> login(LoginDto loginDto) {
    // Retrieve email and password from the LoginDto
    String email = loginDto.getEmail();
    String password = loginDto.getPassword();
//          Role role=loginDto.getRole();
    // Find the user in the database by email
    User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));

    try {
      if (blogportalCommonFunctions.verifyPassword(password, user.getPassword())) {
        // Password is correct, create a LoginOutDto with user details
        LoginOutDto loginOutDto = new LoginOutDto();
        loginOutDto.setUserId(String.valueOf(user.getId()));
        loginOutDto.setUsername(user.getUsername());
        loginOutDto.setRole(user.getRole());
        loginOutDto.setLoggedIn(true);

        if (loginOutDto != null && loginOutDto.isLoggedIn()) {
          return Collections.singletonMap(loginOutDto, HttpStatus.ACCEPTED);
        } else {
          throw new CustomAuthenticationException("Invalid Credentials");
        }
      } else {
        // Password is incorrect, you can handle this as needed
        throw new ResourceNotFoundException("User", "password", "Incorrect password");
      }
    } catch (CustomAuthenticationException e) {
      // Handle the custom exception and include its message in the response
      return Collections.singletonMap(e.getMessage(), HttpStatus.UNAUTHORIZED);
    } catch (Exception e) {
      e.printStackTrace();
      // Handle other exceptions if necessary and return an appropriate response
      return Collections.singletonMap("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * Indicates that a method declaration is intended to override a method
   * declaration in a superclass. It helps ensure that the method is correctly
   * overridden and provides clarity in the code.
   */
  @Override
  public UserOutDto updateUser(UserInDto userInDto, String userId) {
    User user = this.userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

    user.setFirstname(userInDto.getFirstname());
    user.setLastname(userInDto.getLastname());
    user.setEmail(userInDto.getEmail());
    user.setUsername(userInDto.getUsername());
    user.setPassword(userInDto.getPassword());
    user.setDesignation(userInDto.getDesignation());
    user.setGender(userInDto.getGender());
    user.setMobileNumber(userInDto.getMobileNumber());
    user.setRole(userInDto.getRole());
    User updatedUser = this.userRepository.save(user);
    return modelMapper.map(updatedUser, UserOutDto.class);
  }

  /**
   * Retrieves a user by their unique ID.
   *
   * @param userId The ID of the user to retrieve.
   * @return The UserOutDto object representing the retrieved user.
   * @throws ResourceNotFoundException If no user with the given ID is found.
   */
  public UserOutDto getUserById(String userId) {
    Optional<User> respUser = this.userRepository.findById(userId);

    if (!respUser.isPresent()) {
      throw new ResourceNotFoundException("user", "userId", userId);
    }

    User user = respUser.get();
    return modelMapper.map(user, UserOutDto.class);
  }

  /**
   * Indicates that a method declaration is intended to override a method
   * declaration in a superclass. It helps ensure that the method is correctly
   * overridden and provides clarity in the code.
   */
  @Override
  public List<UserOutDto> getAllUsers() {
    List<User> users = this.userRepository.findAll();
    List<UserOutDto> dtos = new ArrayList<UserOutDto>();
    for (User u : users) {
      UserOutDto dto = new UserOutDto();
      modelMapper.map(u, dto);
      dtos.add(dto);
    }
    return dtos;
  }

  /**
   * Indicates that a method declaration is intended to override a method
   * declaration in a superclass. It helps ensure that the method is correctly
   * overridden and provides clarity in the code.
   */
  @Override
  public void deleteUser(String userId) {

    userRepository.deleteById(userId);
  }

  /**
   * Perform user login.
   *
   * @param logindto The login information provided by the user.
   * @return A LoginOutDto object representing the result of the login operation.
   */
  @Override
  public LoginOutDto loginService(LoginDto logindto) {
    return null;
  }

}
