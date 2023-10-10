package blogportal.application.services.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import blogportal.application.entity.User;
import blogportal.application.exception.ResourceNotFoundException;
import blogportal.application.payloads.LoginDto;
import blogportal.application.payloads.LoginOutDto;
import blogportal.application.payloads.UserInDto;
import blogportal.application.payloads.UserOutDto;
import blogportal.application.repository.UserRepository;
@SpringBootTest
class UserServiceTest {

	@Mock
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserServiceimpl userService;
	
	
	private static UserInDto dto=new UserInDto("9","johnson","sharma","geet","johni@nucleusteq.com","Geet@24730","engineer",null,null,null);
    
    @BeforeEach
    public  void creatUserForEach() throws Exception{
    	userService.createUser(dto);
    }
	@Test
	public void createUsertest() throws UnsupportedEncodingException {
		UserInDto userInDto = new UserInDto();
		userInDto.setId("6483935432");
		userInDto.setFirstname("john");
		userInDto.setLastname("sharma");
		userInDto.setEmail("john@123");
		userInDto.setUsername("john123");
		userInDto.setPassword("abcdef");
		userInDto.setDesignation("engineer");
		userInDto.setGender("male");
		User user = this.modelMapper.map(userInDto, User.class);
		System.out.println(user);
		when(userRepo.save(user)).thenReturn(user);
//	assertEquals(employeeDto, this.modelMapper.map(employee, EmployeeDto.class));
		UserOutDto user1 = this.userService.createUser(userInDto);
		System.out.println(user1);
		Assertions.assertThat(user1).isNotNull();
		userService.deleteUser(userInDto.getId());
	}
	
	@Test
	public void getUserTest() {
		UserOutDto userIdDto=userService.getUserById(dto.getId());
		Assertions.assertThat(userIdDto.getId()).isEqualTo(dto.getId());
		Assertions.assertThat(userIdDto.getUsername()).isEqualTo(dto.getUsername());
		Assertions.assertThat(userIdDto.getDesignation()).isEqualTo(dto.getDesignation());
		Assertions.assertThat(userIdDto.getUsername()).isEqualTo(dto.getUsername());
	}
	@Test
	public void getUserTestEmpty() {
		
		try {
			UserOutDto userIdDto=userService.getUserById("23");
		    fail( "My method didn't throw when I expected it to" );
		} catch (ResourceNotFoundException renfe) {
		}
		
	}
	@Test
	public void getAllUserTest() {
		
		List<UserOutDto> listOfUsers=userService.getAllUsers();
		List<String> ids=listOfUsers.stream()
        .map(UserOutDto::getId) 
        .collect(Collectors.toList());
		assertTrue(ids.contains("9"));
	}
	@Test
    public void testUpdateUser() {
        // Create a sample UserInDto
        UserInDto userInDto = new UserInDto("9","johnson","sharma","geetiiii","johni@nucleusteq.com","Geet@24730","engineer",null,null,null);

        String userId = "9";

        User user = new User("9","johnson","sharma","geetiiii","johni@nucleusteq.com","Geet@24730","engineer",null,null,null);


        UserOutDto result = userService.updateUser(userInDto, userId);
        assertEquals(user.getUsername(), result.getUsername());

    }
	@Test
	public void loginUser() {
		LoginDto loginDto=new LoginDto("johni@nucleusteq.com","Geet@24730"); 
		Map<Object, HttpStatus> result=userService.login(loginDto);
		for(Object key:result.keySet()) {
			LoginOutDto loginOutDto=(LoginOutDto)key;
			assertEquals("geet", loginOutDto.getUsername());
			return;
		}
		
		
	}
	@AfterEach
    public void deleteUserForEach() throws Exception{
    	userService.deleteUser("9");
    }
	

	@Test
	public void testUpdateUserNonExistingUser() {
	    // Attempt to update a non-existing user
	    UserInDto nonExistingUserDto = new UserInDto("nonexistent", "John", "Smith", "johnsmith", "john@xyz.com", "Password123", "Engineer", null, null, null);
	    assertThrows(ResourceNotFoundException.class, () -> userService.updateUser(nonExistingUserDto, "nonexistent"));
	}

	@Test
	public void testDeleteUser() {
	    // Delete a user and verify that it no longer exists
	    userService.deleteUser("9");
	    assertThrows(ResourceNotFoundException.class, () -> userService.getUserById("9"));
	}


	@Test
	public void testLoginWithValidCredentials() {
	    // Attempt to login with valid credentials
	    LoginDto validLoginDto = new LoginDto("johni@nucleusteq.com", "Geet@24730");
	    Map<Object, HttpStatus> result = userService.login(validLoginDto);
	    for (Object key : result.keySet()) {
	        // Verify that the response contains a LoginOutDto
	        assertTrue(key instanceof LoginOutDto);
	        LoginOutDto loginOutDto = (LoginOutDto) key;
	        assertEquals("geet", loginOutDto.getUsername());
	    }
	}

}

