package blogportal.application.controller;
import blogportal.application.Status;
import blogportal.application.payloads.PostInDto;
import blogportal.application.payloads.PostListOutDto;
import blogportal.application.payloads.PostOutDto;
import blogportal.application.payloads.UserReviewInDto;
import blogportal.application.payloads.UserReviewOutDto;
import blogportal.application.services.PostService;
import blogportal.application.utils.ConstantURL;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;
import java.util.Map;
/**
 * Controller for managing blog posts.
 */
@RestController
@RequestMapping(ConstantURL.BLOG_URL)
@CrossOrigin("*")
public class PostController {
  /**
   * Logger.
   */
  private static final Logger LOG = LogManager.getLogger(PostController.class);

  /**
   * The PostService instance responsible for managing blog post-related
   * operations.
   */
  @Autowired
  private PostService postService;

  /**
   * Create new post.
   *
   * @param postDTO
   * @param userId
   * @return A PostOutDto representing the newly created blog post.
   */
  @PostMapping("/create/{userId}")
  public PostOutDto createPost(@Valid @RequestBody PostInDto postDTO, @PathVariable("userId") String userId) {
    LOG.info("Creating a new post by user ID: {}", postDTO.toString());
    return postService.createPost(postDTO, userId);
  }

  /**
   * Get all posts.
   *
   * @param postDTO The input DTO containing criteria for fetching posts.
   * @return A list of all posts as PostOutDTOs.
   */
  @PostMapping("/employee-my-blog")
  public List<PostListOutDto> getAllPosts(@RequestBody PostInDto postDTO) {
    LOG.info("Fetching all posts");
    return postService.getAllPosts(postDTO);
  }

  /**
   * Get all approved posts.
   *
   * @param postDTO The input DTO containing criteria for fetching posts.
   * @return A list of approved posts as PostOutDTOs.
   */
  @PostMapping("/employee-dashboard")
  public List<PostListOutDto> getAllApprovedPosts(@RequestBody PostInDto postDTO) {

    return postService.getAllApprovedPosts(postDTO);
  }

  /**
   * Get a post by its ID.
   *
   * @param postId The ID of the post.
   * @return The post as a PostOutDto.
   */
  @GetMapping("/{postId}")
  public PostOutDto getPostById(@Valid @PathVariable String postId) {
    LOG.info("Fetching post by ID: {}", postId);
    return postService.getPostById(postId);
  }

  /**
   * Update an existing post.
   *
   * @param updatePostId The ID of the post to update.
   * @param postDTO      The updated post data.
   * @return The updated post as a PostOutDTO.
   */
  @PutMapping("/{updatePostId}")
  public PostOutDto updatePost(@Valid @PathVariable String updatePostId, @RequestBody PostInDto postDTO) {
    LOG.info("Updating post by ID: {}", updatePostId);
    return postService.updatePost(updatePostId, postDTO);
  }

  /**
   * Delete a post by its ID.
   *
   * @param deletepostId The ID of the post to delete.
   */
  @DeleteMapping("/delete/{postId}")
  public void deletePost(@PathVariable("postId") String deletepostId) {
    LOG.info("Deleting post by ID: {}", deletepostId);
    postService.deletePost(deletepostId);
  }

  /**
   * Get all unreviewed posts.
   *
   * @param postDTO The input DTO containing filter criteria.
   * @return A list of unreviewed posts as PostOutDTOs.
   */
  @PostMapping("/unReviewed")
  public List<PostListOutDto> getUnreviewedPosts(@RequestBody PostInDto postDTO) {
      LOG.info("Fetching unreviewed posts");
      return postService.getUnreviewedPosts(postDTO);
  }


  /**
   * Review a post and set its approval status.
   *
   * @param postId The ID of the post to review.
   * @param userId The ID of the user reviewing the post.
   * @param status True to approve, false to reject.
   * @return The reviewed post as a PostOutDTO.
   */
  @PutMapping("/{postId}/{userId}/review")
  public PostOutDto reviewPost(@PathVariable String postId, @PathVariable String userId, @RequestParam Status status) {
    LOG.info("Reviewing post with ID: {} (Approve: {})", postId, status);
    return postService.reviewPost(postId, userId, status);
  }

  /**
   * Like a post by user ID and post ID.
   *
   * @param userReviewInDto The user review data including user ID and post ID.
   * @return UserReviewOutDto with updated like information.
   */
  @PutMapping("/likes")
  public UserReviewOutDto postLikeById(@RequestBody UserReviewInDto userReviewInDto) {
    return postService.postCountLikeByPost(userReviewInDto);
  }

  /**
   * Dislike a post by user ID and post ID.
   *
   * @param userReviewInDto The user review data including user ID and post ID.
   * @return UserReviewOutDto with updated dislike information.
   */
  @PutMapping("/dislikes")
  public UserReviewOutDto postDisLikeById(@RequestBody UserReviewInDto userReviewInDto) {
    return postService.postCountDisLikeByPost(userReviewInDto);
  }

  /**
   * Post comments on a post by user ID and post ID.
   *
   * @param userReviewInDto The user review data including user ID, post ID, and
   *                        comments.
   * @return Map containing comments on the post.
   */
  @PutMapping("/comments")
  public Map<String, List<String>> postCommentsById(@RequestBody UserReviewInDto userReviewInDto) {
   //System.out.println(userReviewInDto.toString());
    return postService.postCommentByPost(userReviewInDto);
  }

  /**
   * Report a post by user ID and post ID.
   *
   * @param userReviewInDto The user review data including user ID and post ID.
   * @return Map containing the report status.
   */
  @PutMapping("/report-blog")
  public Map<String, Long> postReportById(@RequestBody UserReviewInDto userReviewInDto) {
    return postService.postUserReportBlog(userReviewInDto.getPostId(), userReviewInDto.getUserId());
  }

  /**
   * Get the report status of a post by post ID for an admin.
   *
   * @param postId The ID of the post.
   * @return Map containing the report status.
   */
  @GetMapping("/get-reported-blog/{postId}")
  public Map<String, Boolean> getReportByIdAdmin(@PathVariable String postId) {
    return postService.getUserReportBlog(postId);
  }

  /**
   * Ignores a report for a specific blog post by the admin.
   *
   * @param userReviewInDto The UserReviewInDto containing the review details.
   * @return A Map with a status message indicating the result of the operation.
   */
  @PutMapping("/report-blog-ignore")
  public Map<String, String> ignoreReportByIdAdmin(@RequestBody UserReviewInDto userReviewInDto) {
    return postService.postIgnoreUserReportBlog(userReviewInDto);
  }

  /**
   * Retrieves a list of all reported blog posts.
   *
   * @return A List of PostOutDto representing the reported blog posts.
   */
  @GetMapping("/get-all-reported-blog")
  public List<PostOutDto> allReportBlog() {
    return postService.getAllReportBlog();
  }
}
