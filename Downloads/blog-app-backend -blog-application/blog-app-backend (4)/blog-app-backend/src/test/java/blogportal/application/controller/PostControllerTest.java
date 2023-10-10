package blogportal.application.controller;

import blogportal.application.controller.PostController;
import blogportal.application.entity.Post;
import blogportal.application.Status;
import blogportal.application.Technology;
import blogportal.application.payloads.PostInDto;
import blogportal.application.payloads.PostListOutDto;
import blogportal.application.payloads.PostOutDto;
import blogportal.application.payloads.UserReviewInDto;
import blogportal.application.payloads.UserReviewOutDto;
import blogportal.application.repository.PostRepository;
import blogportal.application.services.PostService;
import blogportal.application.utils.ConstantURL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {
  @Mock
  private PostService postService;
  @Mock
  private PostRepository postRepository;
  @InjectMocks
  private PostController postController;

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
  }

  @Test
  public void testCreatePost() throws Exception {
      // Prepare a sample PostInDto
      PostInDto postInDto = new PostInDto();
      postInDto.setTitle("Sample Title");
      postInDto.setContent("Sample Content");
      postInDto.setTechnology(Technology.BLOCKCHAIN);
      postInDto.setUserId("123");
      // Prepare a sample userId
      String userId = "1";

      // Prepare a sample PostOutDto that you expect to be returned by the service
      PostOutDto expectedPostOutDto = new PostOutDto();
      expectedPostOutDto.setId("1");
      expectedPostOutDto.setTitle("Sample Title");
      expectedPostOutDto.setContent("Sample Content");
      expectedPostOutDto.setUserId("123");  // Set a user ID
      expectedPostOutDto.setCreatedDate(new Date());  // Set a creation date
      expectedPostOutDto.setFullname("John Doe");  // Set a fullname
      expectedPostOutDto.setDesignation("Software Engineer");  // Set a designation
      expectedPostOutDto.setTechnology(Technology.BLOCKCHAIN);  // Set a technology
      expectedPostOutDto.setStatus(Status.STATUS);  // Set a status

//      expectedPostOut

      // Mock the behavior of the postService.createPost method
      when(postService.createPost(any(PostInDto.class), any(String.class))).thenReturn(expectedPostOutDto);

      // Perform the POST request to the endpoint
      ResultActions result = mockMvc.perform(MockMvcRequestBuilders
          .post("/posts/create/{userId}" , userId)
          .contentType(MediaType.APPLICATION_JSON)
          .content("{\"title\": \"Sample Title\", \"content\": \"Sample Content\", \"technology\": \"BLOCKCHAIN\", \"userId\": \"1\"}")

      );

      // Verify the response status and content
      result.andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Sample Title"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Sample Content"));

      // Verify that the service method was called with the correct arguments
      // You can verify this if needed
      // verify(postService, times(1)).createPost(any(PostInDto.class), eq(userId));
      // verifyNoMoreInteractions(postService);
  }



  @Test
  public void testGetAllPosts() throws Exception {
    List<PostListOutDto> samplePostList = new ArrayList<>();
    PostListOutDto postListDTO = new PostListOutDto();
    postListDTO.setTitle("Sample Title");
    postListDTO.setLike(true);
    postListDTO.setTechnology(Technology.JAVA);
    samplePostList.add(postListDTO);
    when(postService.getAllPosts(any(PostInDto.class))).thenReturn(samplePostList);

    // Perform an HTTP GET request to the endpoint
    mockMvc.perform(post("/posts/employee-my-blog").content("{}").contentType("application/json"))
        .andExpect(status().isOk()).andExpect(jsonPath("$[0].title").value("Sample Title"))
        .andExpect(jsonPath("$[0].like").value(true)).andExpect(jsonPath("$[0].technology").value("JAVA"));

  }

//
  @Test
  public void testGetPostId() throws Exception {
    // Prepare a list of sample PostOutDTOs

    PostOutDto post = new PostOutDto();
    post.setId("2");
    post.setTitle("Sample Title 2");
    post.setContent("Sample Content 2");
    // Mock the service method
    when(postService.getPostById(any(String.class))).thenReturn(post);
    // Perform the GET request
    ResultActions result = mockMvc.perform(get("/posts/2").contentType(MediaType.APPLICATION_JSON));
    // Verify the response status and content
    result.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value("2")).andExpect(jsonPath("$.title").value("Sample Title 2"))
        .andExpect(jsonPath("$.content").value("Sample Content 2"));
  }

  @Test
  public void testUpdatePost() throws Exception {
    // Prepare a list of sample PostOutDTOs

    PostOutDto up_post = new PostOutDto();
    up_post.setId("2");
    up_post.setTitle("Sample Title 2");
    up_post.setContent("Sample Content 2");
    when(postService.updatePost(any(String.class), any(PostInDto.class))).thenReturn(up_post);
    // Perform the GET request
    ResultActions result = mockMvc.perform(put("/posts/2").contentType(MediaType.APPLICATION_JSON)
        .content("{ \"title\": \"Sample Title 2\", \"content\": \"Sample Content 2\" , \"technology\": \"JAVA\" }"));
    // Verify the response status and content
    result.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value("2")).andExpect(jsonPath("$.title").value("Sample Title 2"))
        .andExpect(jsonPath("$.content").value("Sample Content 2"));
  }

  @Test
  public void testReviewPost() throws Exception {
    // Prepare a sample Post object
    PostOutDto post1 = new PostOutDto();
    post1.setId("1");
    post1.setTitle("Sample Title 1");
    post1.setContent("Sample Content 1");
    post1.setStatus(Status.APPROVED);

    // Mock the repository method
    when(postService.reviewPost(any(String.class), any(String.class), any(Status.class))).thenReturn(post1);

    // Perform the POST request
    ResultActions result = mockMvc
        .perform(put("/posts/89/1/review").param("status", "APPROVED").contentType(MediaType.APPLICATION_JSON));

    // Verify the response status and content
    result.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Expect JSON
                                                                                                   // content type
        .andExpect(jsonPath("$.id").value("1")).andExpect(jsonPath("$.title").value("Sample Title 1"))
        .andExpect(jsonPath("$.content").value("Sample Content 1")).andExpect(jsonPath("$.status").value("APPROVED")); // Ensure
                                                                                                                       // true
  }

  @Test
  public void testPostLikeById() throws Exception {
    // Create a sample UserReviewInDto
    UserReviewInDto userReviewInDto = new UserReviewInDto();
    userReviewInDto.setPostId("2");
    userReviewInDto.setUserId("3");

    // Create a sample UserReviewOutDto
    UserReviewOutDto expectedUserReviewOutDto = new UserReviewOutDto();
    // Set the expected data in the UserReviewOutDto as needed

    // Mock the behavior of the postService method
    when(postService.postCountLikeByPost(any(UserReviewInDto.class))).thenReturn(expectedUserReviewOutDto);

    // Perform an HTTP PUT request to the endpoint
    mockMvc
        .perform(
            put("/posts/likes").contentType(MediaType.APPLICATION_JSON).content("{\"postId\":\"2\",\"userId\":\"3\"}")) // JSON
        .andExpect(status().isOk()) // Expecting a successful response status
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)); // JSON representation of
                                                                       // expectedUserReviewOutDto
  }

  @Test
  public void testPostDisLikeById() throws Exception {
    // Create a sample UserReviewInDto
    UserReviewInDto userReviewInDto = new UserReviewInDto();
    userReviewInDto.setPostId("2");
    userReviewInDto.setUserId("3");

    // Create a sample UserReviewOutDto
    UserReviewOutDto expectedUserReviewOutDto = new UserReviewOutDto();
    // Set the expected data in the UserReviewOutDto as needed

    // Mock the behavior of the postService method
    when(postService.postCountDisLikeByPost(any(UserReviewInDto.class))).thenReturn(expectedUserReviewOutDto);

    // Perform an HTTP PUT request to the endpoint
    mockMvc
        .perform(put("/posts/dislikes").contentType(MediaType.APPLICATION_JSON)
            .content("{\"postId\":\"2\",\"userId\":\"3\"}")) // JSON representation of UserReviewInDto
        .andExpect(status().isOk()) // Expecting a successful response status
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)); // JSON representation of
                                                                       // expectedUserReviewOutDto
  }

  @Test
  public void testPostCommentsById() throws Exception {
    // Create a sample UserReviewInDto
    UserReviewInDto userReviewInDto = new UserReviewInDto();
    userReviewInDto.setPostId("2");
    userReviewInDto.setUserId("3");
    userReviewInDto.setComment("comment");

    // Mock the behavior of the postService methodar
    when(postService.postCommentByPost(any(UserReviewInDto.class)))
        .thenReturn(Collections.singletonMap("comment", new ArrayList<String>()));

    // Perform an HTTP PUT request to the endpoint
    mockMvc
        .perform(put("/posts/comments").contentType(MediaType.APPLICATION_JSON)
            .content("{\"postId\":\"2\",\"userId\":\"3\",\"comment\":\"comment\"}")) // JSON representation of
                                                                                     // UserReviewInDto
        .andExpect(status().isOk()) // Expecting a successful response status
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)); // JSON representation of
                                                                       // expectedUserReviewOutDto
  }

  @Test
  public void testGetAllDashboardPosts() throws Exception {
    List<PostListOutDto> samplePostList = new ArrayList<>();
    PostListOutDto postListDTO = new PostListOutDto();
    postListDTO.setTitle("Sample Title");
    postListDTO.setLike(true);
    postListDTO.setTechnology(Technology.JAVA);
    samplePostList.add(postListDTO);
    when(postService.getAllApprovedPosts(any(PostInDto.class))).thenReturn(samplePostList);

    // Perform an HTTP GET request to the endpoint
    mockMvc.perform(post("/posts/employee-dashboard").content("{}").contentType("application/json"))
        .andExpect(status().isOk()).andExpect(jsonPath("$[0].title").value("Sample Title"))
        .andExpect(jsonPath("$[0].like").value(true)).andExpect(jsonPath("$[0].technology").value("JAVA"));

  }

  @Test
  public void testGetAllUnreviewedPosts() throws Exception {
    List<PostListOutDto> samplePostList = new ArrayList<>();
    PostListOutDto postListDTO = new PostListOutDto();
    postListDTO.setTitle("Sample Title");
    postListDTO.setLike(true);
    postListDTO.setStatus(Status.STATUS);
    samplePostList.add(postListDTO);
    when(postService.getUnreviewedPosts(any(PostInDto.class))).thenReturn(samplePostList);

    // Perform an HTTP GET request to the endpoint
    mockMvc.perform(post("/posts/unReviewed").content("{}").contentType("application/json")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].title").value("Sample Title")).andExpect(jsonPath("$[0].like").value(true))
        .andExpect(jsonPath("$[0].status").value("STATUS"));

  }

  @Test
  public void testGetAllReportedPosts() throws Exception {
    List<PostOutDto> samplePostList = new ArrayList<>();
    PostOutDto postListDTO = new PostOutDto();
    postListDTO.setTitle("Sample Title");
    postListDTO.setStatus(Status.STATUS);
    samplePostList.add(postListDTO);
    when(postService.getAllReportBlog()).thenReturn(samplePostList);

    // Perform an HTTP GET request to the endpoint
    mockMvc.perform(get("/posts/get-all-reported-blog").contentType("application/json")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].title").value("Sample Title")).andExpect(jsonPath("$[0].status").value("STATUS"));
  }

  @Test
  public void testGetAllIngorePosts() throws Exception {
    List<PostListOutDto> samplePostList = new ArrayList<>();
    PostListOutDto postListDTO = new PostListOutDto();
    postListDTO.setTitle("Sample Title");
    postListDTO.setLike(true);
    postListDTO.setStatus(Status.STATUS);
    samplePostList.add(postListDTO);
    when(postService.postIgnoreUserReportBlog(any(UserReviewInDto.class)))
        .thenReturn(Collections.singletonMap("123", "ignored"));

    // Perform an HTTP GET request to the endpoint
    mockMvc.perform(put("/posts/report-blog-ignore").content("{}").contentType("application/json"))
        .andExpect(status().isOk()).andExpect(jsonPath("$.123").value("ignored"));

  }
  

}
