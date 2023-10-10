package blogportal.application.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import blogportal.application.payloads.UserInDto;
import blogportal.application.payloads.UserOutDto;
import blogportal.application.repository.UserRepository;
import blogportal.application.services.UserService;
import blogportal.application.services.impl.UserServiceimpl;

import static org.mockito.Mockito.*;
@SpringBootTest
public class UserControllerTest {
    @Mock
    private UserServiceimpl userService;
    @InjectMocks
    private UserController userController;
    @Autowired
    private UserController userControllerAutowired;
    
    private static UserInDto userInDto=new UserInDto("9","johnson","sharma","geet","johni@nucleusteq.com","Geet@24730","engineer",null,null,null);
    
    @BeforeEach
    public  void creatUserForEach() throws Exception{
    	ResponseEntity<UserOutDto> dto=userControllerAutowired.createUser(userInDto);
    }
    @Test
    public void testCreateUser() throws Exception
    {
      UserOutDto userDto=new UserOutDto();
      userDto.setUsername("geet");
      userDto.setId("9");
      userDto.setEmail("johni@nucleusteq.com");
      userDto.setDesignation("engineer");
      UserInDto userInDtoMock=new UserInDto();
        when(userService.createUser(userInDtoMock)).thenReturn(userDto);
       ResponseEntity<UserOutDto> dto=userController.createUser(userInDtoMock);
       Assertions.assertThat(dto.getBody()).isEqualTo(userDto);     
    }
    @Test
    public void testDeleteUserByIdMockito() throws Exception
    {
      UserInDto userDto=new UserInDto("1","john","sharma","geet","john@nucleusteq.com","Geet@24730","engineer",null,null,null);
        doNothing().when(userService).deleteUser("1");
        userService.deleteUser(userDto.getId());
        verify(userService, times(1)).deleteUser(userDto.getId());     
    }
    @Test
    public void testUpdateUserById() throws Exception
    {
    	
    	userInDto.setDesignation("computer engineer");
    	ResponseEntity<UserOutDto> updatedUserDto = userControllerAutowired.updateUser(userInDto,userInDto.getId());
    	Assertions.assertThat(updatedUserDto.getBody().getDesignation()).isEqualTo("computer engineer"); 
    }
    @AfterEach
    public void deleteUserForEach() throws Exception{
    	userControllerAutowired.deleteUser("9");
    }
}
