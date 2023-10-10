package blogportal.application.services.impl;

import org.junit.jupiter.api.BeforeEach;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import blogportal.application.Status;
import blogportal.application.Technology;
import blogportal.application.entity.Post;
import blogportal.application.entity.User;
import blogportal.application.Role;
import blogportal.application.entity.UserReview;
import blogportal.application.exception.ResourceNotFoundException;
import blogportal.application.payloads.PostInDto;
import blogportal.application.payloads.PostListOutDto;
import blogportal.application.payloads.PostOutDto;
import blogportal.application.payloads.UserReviewInDto;
import blogportal.application.payloads.UserReviewOutDto;
import blogportal.application.repository.PostRepository;
import blogportal.application.repository.UserRepository;
import blogportal.application.repository.UserReviewRepository;
import blogportal.application.services.PostService;
import blogportal.application.utils.BlogportalCommonFunctions;
import nonapi.io.github.classgraph.concurrency.SingletonMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
  @Mock
  private PostRepository postRepository;
  @Mock
  private UserRepository userRepository;
  @Mock
  private UserReviewRepository userReviewRepository;
  @Mock
  private MongoTemplate mongoTemplate;
  @Mock
  private BlogportalCommonFunctions blogportalCommonFunctions;

  @InjectMocks
  private PostServiceImpl postService;

  @Test
  public void testCreatePost() {

    PostInDto postInDto = new PostInDto();
    postInDto.setTitle("Sample Title");
    postInDto.setContent("Sample Content");
    postInDto.setUserId("User123");

    Post postEntity = new Post();
    postEntity.setId("1");
    postEntity.setTitle("Sample Title");
    postEntity.setContent("Sample Content");
    postEntity.setUserId("User123");

    User user = new User("6483935432", "john", "sharma", "john123", "john@123", "kopi@24730", "engineer", "male",
        Role.EMPLOYEE, null);

    when(userRepository.findById(any(String.class))).thenReturn(Optional.of(user));
    when(postRepository.save(any(Post.class))).thenReturn(postEntity);

    PostOutDto postOutDto = postService.createPost(postInDto, "1");

    assertEquals("Sample Title", postOutDto.getTitle());
    assertEquals("Sample Content", postOutDto.getContent());
    assertEquals("User123", postOutDto.getUserId());
  }

  @Test
  public void testGetAllApprovedPostsByTitleAndTechnology() {
    // Create a sample PostInDto
    PostInDto postDTO = new PostInDto();
    postDTO.setTitle("Sample Title");
    postDTO.setTechnology(Technology.BLOCKCHAIN);

    // Create a list of sample Post entities
    List<Post> postList = new ArrayList<>();
    // Add Post entities to postList (mocking the repository behavior)
    when(postRepository.findAllByStatusApprovedNTitleNTechnology(postDTO.getTechnology().name(), postDTO.getTitle()))
        .thenReturn(postList);

    // Call the getAllApprovedPosts method
    List<PostListOutDto> result = postService.getAllApprovedPosts(postDTO);

    // Assert that the result is an empty list
    assertTrue(result.isEmpty());

    // Verify that the repository method was called with the correct arguments
    verify(postRepository, times(1)).findAllByStatusApprovedNTitleNTechnology(postDTO.getTechnology().name(),
        postDTO.getTitle());
  }

  @Test
  public void testGetPostByIdExisting() {
    Post postEntity = new Post();
    postEntity.setId("1");
    postEntity.setTitle("Sample Title");
    postEntity.setContent("Sample Content");

    when(postRepository.findById("1")).thenReturn(Optional.of(postEntity));

    PostOutDto postOutDto = postService.getPostById("1");

    assertEquals("Sample Title", postOutDto.getTitle());
    assertEquals("Sample Content", postOutDto.getContent());
  }

  @Test
    public void testGetPostByIdNonExisting() {
        when(postRepository.findById("2")).thenReturn(Optional.empty());

        try {
            PostOutDto updatedPostOutDto = postService.getPostById("2");
            fail("Id should not be present");
            }
            catch(ResourceNotFoundException rnfe) {
            	
            }
    }

  @Test
  public void testUpdatePostExisting() {
    Post postEntity = new Post();
    postEntity.setId("1");
    postEntity.setTitle("Sample Title");
    postEntity.setContent("Sample Content");

    PostInDto updatedPostInDto = new PostInDto();
    updatedPostInDto.setTitle("Updated Title");
    updatedPostInDto.setContent("Updated Content");

    when(postRepository.findById("1")).thenReturn(Optional.of(postEntity));

    when(postRepository.save(postEntity)).thenReturn(postEntity);

    PostOutDto updatedPostOutDto = postService.updatePost("1", updatedPostInDto);

    assertEquals("Updated Title", updatedPostOutDto.getTitle());
    assertEquals("Updated Content", updatedPostOutDto.getContent());
  }

  @Test
  public void testUpdatePostNonExisting() {
    PostInDto updatedPostInDto = new PostInDto();
    updatedPostInDto.setTitle("Updated Title");
    updatedPostInDto.setContent("Updated Content");

    when(postRepository.findById("2")).thenReturn(Optional.empty());
    try {
      PostOutDto updatedPostOutDto = postService.updatePost("2", updatedPostInDto);
      fail("Id should not be present");
    } catch (ResourceNotFoundException rnfe) {

    }

  }

  @Test
  public void testReviewPostExisting() {
    Post postEntity = new Post();
    postEntity.setId("1");
    postEntity.setTitle("Sample Title");
    postEntity.setContent("Sample Content");
    postEntity.setStatus(Status.PENDING);

    User user = new User("6483935432", "john", "sharma", "john123", "john@123", "kopi@24730", "engineer", "male",
        Role.ADMIN, null);

    when(postRepository.findById("1")).thenReturn(Optional.of(postEntity));
    when(userRepository.findById("4")).thenReturn(Optional.of(user));

    when(postRepository.save(postEntity)).thenReturn(postEntity);

    PostOutDto reviewedPostOutDto = postService.reviewPost("1", "4", Status.PENDING);

    assertEquals("Sample Title", reviewedPostOutDto.getTitle());
    assertEquals("Sample Content", reviewedPostOutDto.getContent());
    assertEquals(Status.PENDING, postEntity.getStatus());
  }

  @Test
  public void testPostIgnoreUserReportBlog_AdminRole() {

    UserReviewInDto userReviewInDto = new UserReviewInDto();
    userReviewInDto.setPostId("123");
    userReviewInDto.setUserId("adminUserId");

    User adminUser = new User();
    adminUser.setId("adminUserId");
    adminUser.setRole(Role.ADMIN);
    when(userRepository.findById("adminUserId")).thenReturn(Optional.of(adminUser));

    List<UserReview> userReviews = new ArrayList<>();
    UserReview userReview = new UserReview();
    Post post = new Post();
    post.setId("123");
    userReview.setPost(post);
    userReview.setReport(true);
    userReviews.add(userReview);
    when(userReviewRepository.findByPostId("123")).thenReturn(userReviews);

    Map<String, String> result = postService.postIgnoreUserReportBlog(userReviewInDto);

    assertNotNull(result);
    assertEquals(1, result.size());
    assertTrue(result.containsKey("123"));
    assertEquals("ignored", result.get("123"));
  }

  @Test
  public void testGetAllCommentsForPost() {
    // Create a sample postId
    String postId = "123";

    // Create sample UserReviews
    UserReview userReview1 = new UserReview();
    userReview1.setUser(
        new User("9", "johnson", "sharma", "geet", "johni@nucleusteq.com", "Geet@24730", "engineer", null, null, null));
    List<String> comment = new ArrayList<String>();
    comment.add("Comment 1");
    comment.add("Comment 2");

    userReview1.setComment(comment);

    UserReview userReview2 = new UserReview();
    userReview2.setUser(new User("9", "johnson2", "sharma", "geetiiii", "john88i@nucleusteq.com", "Geet@24730",
        "engineer", null, null, null));
    userReview2.setComment(new ArrayList<>()); // No comments for this user

    List<UserReview> userReviewList = new ArrayList<UserReview>();
    userReviewList.add(userReview1);
    userReviewList.add(userReview2);

    // Mock the behavior of userReviewRepository.findByPostId(postId)
    when(userReviewRepository.findByPostId(postId)).thenReturn(userReviewList);

    // Call the getAllCommentsForPost method
    Map<String, List<String>> comments = postService.getAllCommentsForPost(postId);

    // Verify the result
    assertNotNull(comments);
    assertEquals(1, comments.size());
    assertTrue(comments.containsKey("geet"));
  }

  @Test
  public void testGetUnreviewedPostsByTitleAndTechnology() {
    // Create a sample PostInDto
    PostInDto postDTO = new PostInDto();
    postDTO.setTitle("Sample Title");
    postDTO.setTechnology(Technology.BLOCKCHAIN);

    // Create a list of sample Post entities
    List<Post> postList = new ArrayList<>();
    // Add Post entities to postList (mocking the repository behavior)
    when(postRepository.findAllByStatusUnreviewedNTitleNTechnology(postDTO.getTechnology().name(), postDTO.getTitle()))
        .thenReturn(postList);

    // Call the getUnreviewedPosts method
    List<PostListOutDto> result = postService.getUnreviewedPosts(postDTO);

    // Assert that the result is an empty list
    assertTrue(result.isEmpty());

    // Verify that the repository method was called with the correct arguments
    verify(postRepository, times(1)).findAllByStatusUnreviewedNTitleNTechnology(postDTO.getTechnology().name(),
        postDTO.getTitle());
  }

  @Test
  public void testDeletePost() {
    // Define a sample postId
    String postId = "1";

    // Mock the behavior of postRepository.deleteById
    doNothing().when(postRepository).deleteById(postId);

    // Call the deletePost method
    postService.deletePost(postId);

    // Verify that postRepository.deleteById was called with the correct argument
    verify(postRepository, times(1)).deleteById(postId);
  }
  // Getallreports

  @Test
  public void testGetAllReportBlog() {
    // Create sample UserReviews with the report flag set to true
    UserReview userReview1 = new UserReview();
    userReview1.setReport(true);
    userReview1.setPost(new Post());

    UserReview userReview2 = new UserReview();
    userReview2.setReport(true);
    userReview2.setPost(new Post());

    // Create a list of sample UserReviews
    List<UserReview> userReviewList = new ArrayList<UserReview>();
    userReviewList.add(userReview1);
    userReviewList.add(userReview2);

    // Mock the behavior of userReviewRepository.findByReportTrue()
    when(userReviewRepository.findByReportTrue()).thenReturn(userReviewList);

    // Call the getAllReportBlog method
    List<PostOutDto> posts = postService.getAllReportBlog();

    // Verify the result
    assertNotNull(posts);
    assertEquals(2, posts.size());
    // Add additional assertions based on the expected behavior
  }

  @Test
  public void testGetUserReportBlogWithReports() {
    // Define a postId for testing
    String postId = "123";

    // Mock the behavior of blogportalCommonFunctions.getLikeDislikeCountReport
    when(blogportalCommonFunctions.getLikeDislikeCountReport("report", postId, userReviewRepository))
        .thenReturn((long) 5); // Assuming there are 5 reports

    // Call the getUserReportBlog method
    Map<String, Boolean> result = postService.getUserReportBlog(postId);

    // Verify the result
    assertNotNull(result);
    assertTrue(result.containsKey("reportedByUser"));
    assertTrue(result.get("reportedByUser"));

    // Verify that blogportalCommonFunctions.getLikeDislikeCountReport was called
    // with the correct arguments
    verify(blogportalCommonFunctions, times(1)).getLikeDislikeCountReport("report", postId, userReviewRepository);
  }

  @Test
  public void testGetUserReportBlogWithoutReports() {
    // Define a postId for testing
    String postId = "123";

    // Mock the behavior of blogportalCommonFunctions.getLikeDislikeCountReport
    when(blogportalCommonFunctions.getLikeDislikeCountReport("report", postId, userReviewRepository))
        .thenReturn((long) 0); // Assuming there are 0 reports

    // Call the getUserReportBlog method
    Map<String, Boolean> result = postService.getUserReportBlog(postId);

    // Verify the result
    assertNotNull(result);
    assertTrue(result.containsKey("reportedByUser"));
    assertFalse(result.get("reportedByUser"));

    // Verify that blogportalCommonFunctions.getLikeDislikeCountReport was called
    // with the correct arguments
    verify(blogportalCommonFunctions, times(1)).getLikeDislikeCountReport("report", postId, userReviewRepository);
  }

  @Test
  public void testGetAllPostsByUserId() {
    // Create a sample PostInDto
    PostInDto postDTO = new PostInDto();
    postDTO.setUserId("User123");
    postDTO.setTitle("");
    postDTO.setTechnology(Technology.ALL);
    postDTO.setStatus(Status.STATUS);

    // Create sample posts and mock the repository behavior
    List<Post> posts = new ArrayList<>();
    posts.add(new Post());
    when(postRepository.findAllByUserId(postDTO.getUserId())).thenReturn(posts);

    // Call the getAllPosts method
    List<PostListOutDto> result = postService.getAllPosts(postDTO);

    // Verify the result
    assertEquals(1, result.size());
    // Add additional assertions based on the expected behavior
  }

  @Test
  public void testGetAllPostsDefaultCriteria() {
      // Create a sample PostInDto with default criteria
      PostInDto postDTO = new PostInDto();
      postDTO.setUserId("User123");
      postDTO.setTitle("");
      postDTO.setTechnology(Technology.ALL);
      postDTO.setStatus(Status.STATUS);

      // Create sample posts and mock the repository behavior
      List<Post> posts = new ArrayList<>();
      // Add one or more posts that match the criteria
      Post matchingPost = new Post();
      matchingPost.setUserId("User123");
      // Set other properties as per default criteria
      posts.add(matchingPost);

      // Mock the repository method to return the posts
      when(postRepository.findAllByUserId(postDTO.getUserId())).thenReturn(posts);

      // Call the getAllPosts method
      List<PostListOutDto> result = postService.getAllPosts(postDTO);

      // Verify the result
      assertEquals(1, result.size());
      PostListOutDto firstPost = result.get(0);

      // Add assertions to verify the content of the returned post
      assertEquals(matchingPost.getTitle(), firstPost.getTitle());
      assertEquals(matchingPost.getContent(), firstPost.getContent());
      assertEquals(matchingPost.getUserId(), firstPost.getUserId());
      // Add additional assertions based on the expected behavior
  }


  @Test
  public void testGetAllPostsByStatusAndTechnology() {
    // Create a sample PostInDto
    PostInDto postDTO = new PostInDto();
    // Set relevant properties in postDTO
    postDTO.setUserId("User123");
    postDTO.setTitle("");
    postDTO.setTechnology(Technology.BLOCKCHAIN);
    postDTO.setStatus(Status.PENDING);

    // Create sample posts and mock the repository behavior
    List<Post> posts = new ArrayList<>();
    // Add one or more posts that match the criteria
    Post matchingPost = new Post();
    matchingPost.setTechnology(Technology.BLOCKCHAIN);
    matchingPost.setStatus(Status.PENDING);
    matchingPost.setUserId("User123");
    posts.add(matchingPost);

    // Mock the repository method to return the posts
    when(postRepository.findByTechnologNStatusNUserId(postDTO.getTechnology().name(), postDTO.getStatus().toString(),
        postDTO.getUserId())).thenReturn(posts);

    // Call the getAllPosts method
    List<PostListOutDto> result = postService.getAllPosts(postDTO);

    // Verify the result
    assertEquals(1, result.size());
    PostListOutDto firstPost = result.get(0);

    // Add assertions to verify the content of the returned post
    assertEquals(matchingPost.getTitle(), firstPost.getTitle());
    assertEquals(matchingPost.getContent(), firstPost.getContent());
    assertEquals(matchingPost.getUserId(), firstPost.getUserId());
    // Add additional assertions based on the expected behavior
  }

  // Add similar test methods for other branches like testGetAllPostsByTitle,
  // testGetAllPostsByTechnology, etc.

  // Test case for the default behavior
  @Test
  public void testGetAllPostsDefault() {
    // Create a sample PostInDto with default values
    PostInDto postDTO = new PostInDto();
    // Set relevant properties in postDTO
    postDTO.setUserId("User123");
    postDTO.setTitle("");
    postDTO.setTechnology(Technology.ALL);
    postDTO.setStatus(Status.STATUS);

    // Create sample posts and mock the repository behavior
    List<Post> posts = new ArrayList<>();
    // Add one or more posts that match the criteria
    Post matchingPost = new Post();
    matchingPost.setUserId("User123");
    posts.add(matchingPost);

    // Mock the repository method to return the posts
    when(postRepository.findAllByUserId(postDTO.getUserId())).thenReturn(posts);

    // Call the getAllPosts method
    List<PostListOutDto> result = postService.getAllPosts(postDTO);

    // Verify the result
    assertEquals(1, result.size());
    PostListOutDto firstPost = result.get(0);

    // Add assertions to verify the content of the returned post
    assertEquals(matchingPost.getTitle(), firstPost.getTitle());
    assertEquals(matchingPost.getContent(), firstPost.getContent());
    assertEquals(matchingPost.getUserId(), firstPost.getUserId());
    // Add additional assertions based on the expected behavior
  }

  @Test
  public void testGetAllPostsByStatus() {
    // Create a sample PostInDto
    PostInDto postDTO = new PostInDto();
    postDTO.setUserId("User123");
    postDTO.setTitle("");
    postDTO.setTechnology(Technology.ALL);
    postDTO.setStatus(Status.PENDING);

    // Create sample posts and mock the repository behavior
    List<Post> posts = new ArrayList<>();
    posts.add(new Post());
    when(postRepository.findByStatusNUserId(postDTO.getStatus().toString(), postDTO.getUserId())).thenReturn(posts);

    // Call the getAllPosts method
    List<PostListOutDto> result = postService.getAllPosts(postDTO);

    // Verify the result
    assertEquals(1, result.size());
    // Add additional assertions based on the expected behavior
  }

  @Test
  public void testGetAllPostsByTechnology() {
    // Create a sample PostInDto
    PostInDto postDTO = new PostInDto();
    postDTO.setUserId("User123");
    postDTO.setTitle("");
    postDTO.setTechnology(Technology.BLOCKCHAIN);
    postDTO.setStatus(Status.STATUS);

    // Create sample posts and mock the repository behavior
    List<Post> posts = new ArrayList<>();
    posts.add(new Post());
    when(postRepository.findByTechnologNUserId(postDTO.getTechnology().name(), postDTO.getUserId())).thenReturn(posts);

    // Call the getAllPosts method
    List<PostListOutDto> result = postService.getAllPosts(postDTO);

    // Verify the result
    assertEquals(1, result.size());
    // Add additional assertions based on the expected behavior
  }
  @Test
  public void testGetAllPostsByTitle() {
      // Create a sample PostInDto
      PostInDto postDTO = new PostInDto();
      postDTO.setUserId("User123");
      postDTO.setTitle("Sample Title");
      postDTO.setTechnology(Technology.ALL);
      postDTO.setStatus(Status.STATUS);

      // Create sample posts and mock the repository behavior
      List<Post> posts = new ArrayList<>();
      posts.add(new Post());
      when(postRepository.findByTitleNUserId(postDTO.getTitle(), postDTO.getUserId()))
              .thenReturn(posts);

      // Call the getAllPosts method
      List<PostListOutDto> result = postService.getAllPosts(postDTO);

      // Verify the result
      assertEquals(1, result.size());
      // Add additional assertions based on the expected behavior
  }

  @Test
  public void testGetUnreviewedPostsWithTitleAndTechnology() {
      // Create a sample PostInDto with title and technology specified
      PostInDto postDTO = new PostInDto();
      postDTO.setTitle("Sample Title");
      postDTO.setTechnology(Technology.JAVA);
      postDTO.setUserId("User123");

      // Create sample posts and mock the repository behavior
      List<Post> posts = new ArrayList<>();
      posts.add(new Post());
      when(postRepository.findAllByStatusUnreviewedNTitleNTechnology(
              postDTO.getTechnology().name(), postDTO.getTitle()))
              .thenReturn(posts);

      // Call the getUnreviewedPosts method
      List<PostListOutDto> result = postService.getUnreviewedPosts(postDTO);

      // Verify the result
      assertEquals(1, result.size());
  }

  @Test
  public void testGetUnreviewedPostsWithTitle() {
      // Create a sample PostInDto with title specified
      PostInDto postDTO = new PostInDto();
      postDTO.setTitle("Sample Title");
      postDTO.setTechnology(Technology.ALL);
      postDTO.setUserId("User123");

      // Create sample posts and mock the repository behavior
      List<Post> posts = new ArrayList<>();
      posts.add(new Post());
      when(postRepository.findByTitleStatusUnreviewed(postDTO.getTitle()))
              .thenReturn(posts);

      // Call the getUnreviewedPosts method
      List<PostListOutDto> result = postService.getUnreviewedPosts(postDTO);

      // Verify the result
      assertEquals(1, result.size());
  }

  @Test
  public void testGetUnreviewedPostsWithTechnology() {
      // Create a sample PostInDto with technology specified
      PostInDto postDTO = new PostInDto();
      postDTO.setTitle("");
      postDTO.setTechnology(Technology.JAVA);
      postDTO.setUserId("User123");

      // Create sample posts and mock the repository behavior
      List<Post> posts = new ArrayList<>();
      posts.add(new Post());
      when(postRepository.findByTechnologyStatusUnreviewed(postDTO.getTechnology().name()))
              .thenReturn(posts);

      // Call the getUnreviewedPosts method
      List<PostListOutDto> result = postService.getUnreviewedPosts(postDTO);

      // Verify the result
      assertEquals(1, result.size());
  }

  @Test
  public void testGetUnreviewedPostsWithoutTitleAndTechnology() {
      // Create a sample PostInDto without title and technology specified
      PostInDto postDTO = new PostInDto();
      postDTO.setTitle("");
      postDTO.setTechnology(Technology.ALL);
      postDTO.setUserId("User123");

      // Create sample posts and mock the repository behavior
      List<Post> posts = new ArrayList<>();
      posts.add(new Post());
      when(postRepository.findAllByStatusUnreviewed()).thenReturn(posts);

      // Call the getUnreviewedPosts method
      List<PostListOutDto> result = postService.getUnreviewedPosts(postDTO);

      // Verify the result
      assertEquals(1, result.size());
  }

}
