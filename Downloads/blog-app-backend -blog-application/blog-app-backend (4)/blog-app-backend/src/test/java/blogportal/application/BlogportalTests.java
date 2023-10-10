package blogportal.application;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import blogportal.application.entity.User;
import blogportal.application.payloads.UserInDto;
import blogportal.application.repository.UserRepository;
import blogportal.application.services.impl.UserServiceimpl;

@SpringBootTest
class BlogportalTests {

  @Autowired
  private ModelMapper modelMapper;

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserServiceimpl userService;

  @Test
  public void testConvertToDto() throws Exception {
//         Mock the ModelMapper behavior
    User user = new User("6483935432", "john", "sharma", "john123", "john@123", "kopi@24730", "engineer", "male",
        Role.EMPLOYEE, null);
    user = (new Blogportal()).modelMapper().map((new Blogportal()).modelMapper().map(user, UserInDto.class),
        User.class);
//		when(userRepository.save(any())).thenReturn(user);

    // Verify the result
    assertEquals("6483935432", user.getId());
    assertEquals("john", user.getFirstname());
    assertEquals("sharma", user.getLastname());
    assertEquals("john123", user.getUsername());
    assertEquals("john@123", user.getEmail());
    assertEquals("kopi@24730", user.getPassword());
    assertEquals("engineer", user.getDesignation());
    assertEquals("male", user.getGender());
    assertEquals(Role.EMPLOYEE, user.getRole());
  }

}