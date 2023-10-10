package blogportal.application.services.impl;
import blogportal.application.Status;
import blogportal.application.Technology;
import blogportal.application.entity.Post;
import blogportal.application.entity.User;
import blogportal.application.Role;
import blogportal.application.entity.UserReview;
import blogportal.application.exception.ResourceNotFoundException;
import blogportal.application.exception.UnauthorizedAccessException;
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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service implementation for managing blog posts.
 */
@Service
public class PostServiceImpl implements PostService {
  /**
   * Repository for managing user data.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * Repository for managing blog post data.
   */
  @Autowired
  private PostRepository postRepository;

  /**
   * Service for managing user-related operations.
   */
  @Autowired
  private UserServiceimpl userServiceimpl;

  /**
   * Repository for managing user review data.
   */
  @Autowired
  private UserReviewRepository userReviewRepository;

  /**
   * Mapper for mapping between DTOs and entities.
   */
  @Autowired
  private ModelMapper modelMapper;
  /**
   * Utility functions related to the blog portal.
   */
  private BlogportalCommonFunctions blogportalCommonFunctions = new BlogportalCommonFunctions();

  /**
   * Creates a new blog post.
   *
   * @param postInDTO The input DTO containing blog post details.
   * @param userId    The unique identifier of the user creating the post.
   * @return The newly created blog post as a PostOutDto.
   * @throws ResourceNotFoundException If the user with the given userId is not
   *                                   found.
   */
  @Override
  public PostOutDto createPost(PostInDto postInDTO, String userId) {
    Post post = new Post();
    post.setTitle(postInDTO.getTitle());
    post.setContent(postInDTO.getContent());

    Optional<User> respUser = userRepository.findById(userId);

    try {
      post.setDesignation(respUser.get().getDesignation());
      post.setFullname(respUser.get().getFirstname() + respUser.get().getLastname());
      post.setUserId(respUser.get().getId());
    } catch (Exception ex) {
      throw new ResourceNotFoundException("user", "userId", userId);
    }

    post.setStatus(Status.PENDING);
    post.setTechnology(postInDTO.getTechnology());
    post.setCreatedDate(new Date());
    post = postRepository.save(post);
    return convertToDTO(post);
  }

  /**
   * Retrieves a list of all approved blog posts based on the provided criteria.
   *
   * @param postDTO The input DTO containing search criteria.
   * @return A list of approved blog posts as PostListOutDto objects.
   */
  @Override
  public List<PostListOutDto> getAllApprovedPosts(PostInDto postDTO) {
    if (postDTO.getTitle().equals("") && postDTO.getTechnology().equals(Technology.ALL)) {
      System.out.println(postRepository.findAllByStatusApproved().size());
      return postRepository.findAllByStatusApproved().stream()
          .map(p -> convertToDTOListWithUserId(p, postDTO.getUserId())).collect(Collectors.toList());
    } else if (postDTO.getTechnology().equals(Technology.ALL)) {
      return postRepository.findByTitleStatusApproved(postDTO.getTitle(), Status.APPROVED).stream()
          .map(p -> convertToDTOListWithUserId(p, postDTO.getUserId())).collect(Collectors.toList());
    } else if (postDTO.getTitle().equals("")) {
      return postRepository.findByTechnologyStatusApproved(postDTO.getTechnology().name(), Status.APPROVED).stream()
          .map(p -> convertToDTOListWithUserId(p, postDTO.getUserId())).collect(Collectors.toList());
    } else {
      return postRepository.findAllByStatusApprovedNTitleNTechnology(postDTO.getTechnology().name(), postDTO.getTitle())
          .stream().map(p -> convertToDTOListWithUserId(p, postDTO.getUserId())).collect(Collectors.toList());
    }

  }

  /**
   * Retrieve a blog post by its unique identifier.
   *
   * @param postId The unique identifier of the blog post.
   * @return The blog post as a PostOutDto object.
   * @throws ResourceNotFoundException If the blog post with the specified ID is
   *                                   not found.
   */
  @Override
  public PostOutDto getPostById(String postId) {
    Optional<Post> postOptional = postRepository.findById(postId);
    if (postOptional.isPresent()) {
      return convertToDTO(postOptional.get());
    } else {
      throw new ResourceNotFoundException("post", "postId", postId);
    }
  }
  /**
   * Update an existing blog post by its unique identifier.
   *
   * @param postId    The unique identifier of the blog post to be updated.
   * @param postInDTO The updated blog post data as a PostInDto object.
   * @return The updated blog post as a PostOutDto object.
   * @throws ResourceNotFoundException If the blog post with the specified ID is
   *                                   not found.
   */
  @Override
  public PostOutDto updatePost(String postId, PostInDto postInDTO) {
    Optional<Post> postOptional = postRepository.findById(postId);
    if (postOptional.isPresent()) {
      Post post = postOptional.get();
      post.setTitle(postInDTO.getTitle());
      post.setContent(postInDTO.getContent());
      post.setTechnology(postInDTO.getTechnology());
      post.setCreatedDate(new Date());
      post.setFullname(postInDTO.getFullName());
      post.setStatus(postInDTO.getStatus());
      post.setDesignation(postInDTO.getDesignation());
      post = postRepository.save(post);
      return convertToDTO(post);
    } else {
      throw new ResourceNotFoundException("post", "postId", postId);
    }
  }

  /**
   * Get a list of blog posts based on the provided search criteria.
   *
   * @param postDTO The search criteria as a PostInDto object.
   * @return A list of blog posts that match the search criteria as PostListOutDto
   *         objects.
   */
  @Override
  public List<PostListOutDto> getAllPosts(PostInDto postDTO) {

    if (postDTO.getTitle().equals("") && postDTO.getTechnology().equals(Technology.ALL)
        && postDTO.getStatus().equals(Status.STATUS)) {
      return postRepository.findAllByUserId(postDTO.getUserId()).stream()
          .map(p -> convertToDTOListWithUserId(p, postDTO.getUserId())).collect(Collectors.toList());
    } else if (postDTO.getTitle().equals("") && postDTO.getTechnology().equals(Technology.ALL)) {
      return postRepository.findByStatusNUserId(postDTO.getStatus().toString(), postDTO.getUserId()).stream()
          .map(this::convertToDTOList).collect(Collectors.toList());
    } else if (postDTO.getTitle().equals("") && postDTO.getStatus().equals(Status.STATUS)) {
      return postRepository.findByTechnologNUserId(postDTO.getTechnology().name(), postDTO.getUserId()).stream()
          .map(this::convertToDTOList).collect(Collectors.toList());
    } else if (postDTO.getStatus().equals(Status.STATUS) && postDTO.getTechnology().equals(Technology.ALL)) {
      return postRepository.findByTitleNUserId(postDTO.getTitle(), postDTO.getUserId()).stream()
          .map(this::convertToDTOList).collect(Collectors.toList());
    } else if (postDTO.getTechnology().equals(Technology.ALL)) {
      return postRepository
          .findByTitlenStatusNUserId(postDTO.getTitle(), postDTO.getStatus().toString(), postDTO.getUserId()).stream()
          .map(this::convertToDTOList).collect(Collectors.toList());
    } else if (postDTO.getStatus().equals(Status.STATUS)) {
      return postRepository
          .findByTitlenTechnologyNUserId(postDTO.getTitle(), postDTO.getTechnology().name(), postDTO.getUserId())
          .stream().map(this::convertToDTOList).collect(Collectors.toList());
    } else if (postDTO.getTitle().equals("")) {
      return postRepository.findByTechnologNStatusNUserId(postDTO.getTechnology().name(),
          postDTO.getStatus().toString(), postDTO.getUserId()).stream().map(this::convertToDTOList)
          .collect(Collectors.toList());
    } else {
      return postRepository
          .findByTitlenTechnologNStatusNUserId(postDTO.getTitle(), postDTO.getTechnology().name(),
              postDTO.getStatus().toString(), postDTO.getUserId())
          .stream().map(this::convertToDTOList).collect(Collectors.toList());
    }
  }

  /**
   * Delete a blog post by its ID.
   *
   * @param postId The ID of the blog post to delete.
   */
  @Override
  public void deletePost(String postId) {
    postRepository.deleteById(postId);
  }

  /**
   * Get a list of unreviewed blog posts.
   *
   * @return A list of unreviewed blog posts as PostListOutDto objects.
   */
  @Override
  public List<PostListOutDto> getUnreviewedPosts(PostInDto postDTO) {
    if (postDTO.getTitle().equals("") && postDTO.getTechnology().equals(Technology.ALL)) {
      return postRepository.findAllByStatusUnreviewed().stream()
          .map(p -> convertToDTOListWithUserId(p, postDTO.getUserId())).collect(Collectors.toList());
    } else if (postDTO.getTechnology().equals(Technology.ALL)) {
      return postRepository.findByTitleStatusUnreviewed(postDTO.getTitle()).stream()
          .map(p -> convertToDTOListWithUserId(p, postDTO.getUserId())).collect(Collectors.toList());
    } else if (postDTO.getTitle().equals("")) {
      return postRepository.findByTechnologyStatusUnreviewed(postDTO.getTechnology().name()).stream()
          .map(p -> convertToDTOListWithUserId(p, postDTO.getUserId())).collect(Collectors.toList());
    } else {
      return postRepository
          .findAllByStatusUnreviewedNTitleNTechnology(postDTO.getTechnology().name(), postDTO.getTitle()).stream()
          .map(p -> convertToDTOListWithUserId(p, postDTO.getUserId())).collect(Collectors.toList());
    }
  }

  /**
   * Review a blog post and update its status.
   *
   * @param postId  The ID of the blog post to review.
   * @param userId  The ID of the user performing the review (admin).
   * @param approve The new status to set for the blog post (e.g., APPROVED or
   *                REJECTED).
   * @return The updated blog post as a PostOutDto.
   * @throws ResourceNotFoundException If the user is not found or is not an
   *                                   admin, or if the post is not found.
   */
  @Override
  public PostOutDto reviewPost(String postId, String userId, Status approve) {
    Optional<User> userOptional = userRepository.findById(userId);
    if (!userOptional.isPresent() || !userOptional.get().getRole().equals(Role.ADMIN)) {
      // Handle the case where the user is not found or is not an admin
      throw new ResourceNotFoundException("user", "userId", userId);
    }

    Optional<Post> postOptional = postRepository.findById(postId);
    if (postOptional.isPresent()) {
      Post post = postOptional.get();
      post.setStatus(approve);
      post = postRepository.save(post);
      return convertToDTO(post);
    } else {
      // Handle the case where the post is not found
      throw new ResourceNotFoundException("post", "postId", postId);
    }
  }

  /**
   * Like or unlike a blog post and update related user reviews.
   *
   * @param userReviewInDto The UserReviewInDto containing the post and user
   *                        information.
   * @return The UserReviewOutDto with updated like and dislike counts and user
   *         lists.
   */
  @Override
  public UserReviewOutDto postCountLikeByPost(UserReviewInDto userReviewInDto) {
    String postId = userReviewInDto.getPostId();
    String userId = userReviewInDto.getUserId();
    UserReview userReview = null;

    Optional<UserReview> existingReview = userReviewRepository.findByPostIdAndUserId(postId, userId);
    if (existingReview.isPresent()) {
      userReview = existingReview.get();
      // Update the fields as needed
    } else {
      userReview = new UserReview();
      userReview.setUser(modelMapper.map(userServiceimpl.getUserById(userId), User.class));
      userReview.setPost(postRepository.findById(postId).get());
    }

    userReview.setLike(!userReview.isLike());
    userReview.setDislike(false);
    UserReview user = userReviewRepository.save(userReview);

    UserReviewOutDto userReviewOutDto = new UserReviewOutDto(userId, postId,
        blogportalCommonFunctions.getLikeDislikeCountReport("like", postId, userReviewRepository),
        blogportalCommonFunctions.getLikeDislikeCountReport("dislike", postId, userReviewRepository),
        blogportalCommonFunctions.getLikeDislikeUsersList("like", postId, userReviewRepository),
        blogportalCommonFunctions.getLikeDislikeUsersList("dislike", postId, userReviewRepository),
        getAllCommentsForPost(postId));

    return userReviewOutDto;
  }

  /**
   * Dislike or remove dislike from a blog post and update related user reviews.
   *
   * @param userReviewInDto The UserReviewInDto containing the post and user
   *                        information.
   * @return The UserReviewOutDto with updated like and dislike counts and user
   *         lists.
   */
  @Override
  public UserReviewOutDto postCountDisLikeByPost(UserReviewInDto userReviewInDto) {
    String postId = userReviewInDto.getPostId();
    String userId = userReviewInDto.getUserId();
    UserReview userReview = null;

    Optional<UserReview> existingReview = userReviewRepository.findByPostIdAndUserId(postId, userId);
    if (existingReview.isPresent()) {
      userReview = existingReview.get();
      // Update the fields as needed
    } else {
      userReview = new UserReview();
      userReview.setUser(modelMapper.map(userServiceimpl.getUserById(userId), User.class));
      userReview.setPost(postRepository.findById(postId).get());
    }

    userReview.setDislike(!userReview.isDislike());
    userReview.setLike(false);
    userReviewRepository.save(userReview);

    UserReviewOutDto userReviewOutDto = new UserReviewOutDto(userId, postId,
        blogportalCommonFunctions.getLikeDislikeCountReport("like", postId, userReviewRepository),
        blogportalCommonFunctions.getLikeDislikeCountReport("dislike", postId, userReviewRepository),
        blogportalCommonFunctions.getLikeDislikeUsersList("like", postId, userReviewRepository),
        blogportalCommonFunctions.getLikeDislikeUsersList("dislike", postId, userReviewRepository),
        getAllCommentsForPost(postId));

    return userReviewOutDto;
  }

  /**
   * Comment on a post and retrieve all comments for the post.
   *
   * @param userReviewInDto The UserReviewInDto containing post, user, and comment
   *                        information.
   * @return A map of comments for the post where keys are usernames and values
   *         are lists of comments.
   */
  @Override
  public Map<String, List<String>> postCommentByPost(UserReviewInDto userReviewInDto) {
    String postId = userReviewInDto.getPostId();
    String userId = userReviewInDto.getUserId();
    String comment = userReviewInDto.getComment();

    UserReview userReview;

    Optional<UserReview> existingReview = userReviewRepository.findByPostIdAndUserId(postId, userId);
    if (existingReview.isPresent()) {
      userReview = existingReview.get();
    } else {
      userReview = new UserReview();
      userReview.setUser(modelMapper.map(userServiceimpl.getUserById(userId), User.class));
      userReview.setPost(postRepository.findById(postId).orElse(null));
    }

    if (comment != null && !comment.isEmpty()) {
      List<String> availableComments = userReview.getComment();
      if (availableComments == null) {
        availableComments = new ArrayList<>();
      }
      availableComments.add(comment);
      userReview.setComment(availableComments);
    }

    userReviewRepository.save(userReview);
    return getAllCommentsForPost(postId);
  }

  /**
   * Get all comments for a specific post.
   *
   * @param postId The ID of the post to retrieve comments for.
   * @return A map of comments for the post where keys are usernames and values are lists of comments.
   */
  public Map<String, List<String>> getAllCommentsForPost(String postId) {

    List<UserReview> userReviews = userReviewRepository.findByPostId(postId);

    Map<String, List<String>> comments = new HashMap<String, List<String>>();
    for (UserReview postReview : userReviews) {
      if (postReview.getComment() == null) {
        continue;
      }
      if (postReview.getComment().size() != 0) {
        comments.put(postReview.getUser().getUsername(), postReview.getComment());
      }
    }
    return comments;
  }


  /**
   * Report a blog post and retrieve the count of reports on the post.
   *
   * @param postId The ID of the post to report.
   * @param userId The ID of the user reporting the post.
   * @return A map containing the count of reports on the post.
   */
  @Override
  public Map<String, Long> postUserReportBlog(String postId, String userId) {
    UserReview userReview = null;
    Optional<UserReview> existingReview = userReviewRepository.findByPostIdAndUserId(postId, userId);
    if (existingReview.isPresent()) {
      userReview = existingReview.get();
      // Update the fields as needed
    } else {
      userReview = new UserReview();
      userReview.setUser(modelMapper.map(userServiceimpl.getUserById(userId), User.class));
      userReview.setPost(postRepository.findById(postId).get());
    }
    userReview.setReport(true);
    userReviewRepository.save(userReview);
    Map<String, Long> result = new HashMap<>();
    result.put("reportedCountsOnPost",
        blogportalCommonFunctions.getLikeDislikeCountReport("report", postId, userReviewRepository));
    return result;
  }

  /**
   * Get the report status of a blog post by a user.
   *
   * @param postId The ID of the post to check for user reports.
   * @return A map containing a boolean indicating whether the user reported the
   *         post.
   */
  @Override
  public Map<String, Boolean> getUserReportBlog(String postId) {
    Map<String, Boolean> result = new HashMap<>();
    result.put("reportedByUser",
        blogportalCommonFunctions.getLikeDislikeCountReport("report", postId, userReviewRepository) != 0);
    return result;
  }

  /**
   * Get a list of all reported blog posts.
   *
   * @return A list of reported blog posts in PostOutDto format.
   */
  @Override
  public List<PostOutDto> getAllReportBlog() {

    List<UserReview> userReviews = userReviewRepository.findByReportTrue();
    List<PostOutDto> posts = userReviews.stream().map(userReview -> convertToDTO(userReview.getPost()))
        .filter(postOutdto -> postOutdto != null).collect(Collectors.toList());
    return posts;
  }

  /**
   * Ignore or clear reports on a user-reported blog post by an admin.
   *
   * @param userReviewInDto The UserReviewInDto containing post and user
   *                        information.
   * @return A map indicating that the post's reports have been ignored.
   * @throws ResourceNotFoundException   If the user is not found.
   * @throws UnauthorizedAccessException If the user is not an admin.
   */
  @Override
  public Map<String, String> postIgnoreUserReportBlog(UserReviewInDto userReviewInDto) {
    String postId = userReviewInDto.getPostId();
    String userId = userReviewInDto.getUserId();
    Optional<User> userOptional = userRepository.findById(userId);

    if (!userOptional.isPresent()) {
      // Handle the case where the user is not found
      throw new ResourceNotFoundException("user", "userId", userId);
    }

    List<UserReview> userReviews = userReviewRepository.findByPostId(postId);

    if (userOptional.get().getRole().equals(Role.ADMIN)) {
      for (UserReview userReview : userReviews) {
        userReview.setReport(false);
        userReviewRepository.save(userReview);
      }
      return Collections.singletonMap(postId, "ignored");
    } else {
      // Handle the case where the user is not an admin
      throw new UnauthorizedAccessException("You are not authorized to perform this action.");
    }
  }

  /**
   * Helper method to convert a Post entity to a PostOutDto.
   *
   * @param post The Post entity to convert.
   * @return A PostOutDto object representing the converted Post.
   */
  private PostOutDto convertToDTO(Post post) {
    if (post == null) {
      return null;
    }
    PostOutDto postOutDTO = new PostOutDto();
    postOutDTO.setId(post.getId());
    postOutDTO.setTitle(post.getTitle());
    postOutDTO.setContent(post.getContent());
    postOutDTO.setUserId(post.getUserId());
    postOutDTO.setCreatedDate(post.getCreatedDate());
    postOutDTO.setFullname(post.getFullname());
    postOutDTO.setDesignation(post.getDesignation());
    postOutDTO.setStatus(post.getStatus());
    postOutDTO.setTechnology(post.getTechnology());
    return postOutDTO;
  }

  /**
   * Helper method to convert a Post entity to a PostListOutDto with additional
   * details.
   *
   * @param post The Post entity to convert.
   * @return A PostListOutDto object representing the converted Post with
   *         additional details.
   */
  private PostListOutDto convertToDTOList(Post post) {
    PostListOutDto postListOutDTO = new PostListOutDto();
    postListOutDTO.setId(post.getId());
    postListOutDTO.setTitle(post.getTitle());
    postListOutDTO.setContent(post.getContent());
    postListOutDTO.setUserId(post.getUserId());
    postListOutDTO.setCreatedDate(post.getCreatedDate());
    postListOutDTO.setFullname(post.getFullname());
    postListOutDTO.setDesignation(post.getDesignation());
    postListOutDTO.setStatus(post.getStatus());
    postListOutDTO.setTechnology(post.getTechnology());
    postListOutDTO
        .setLikeCount(blogportalCommonFunctions.getLikeDislikeCountReport("like", post.getId(), userReviewRepository));
    postListOutDTO.setDislikeCount(
        blogportalCommonFunctions.getLikeDislikeCountReport("dislike", post.getId(), userReviewRepository));
    postListOutDTO.setComments(getAllCommentsForPost(post.getId()));
    postListOutDTO.setReportCount(
        blogportalCommonFunctions.getLikeDislikeCountReport("report", post.getId(), userReviewRepository));
    return postListOutDTO;
  }
  /**
   * Helper method to convert a Post entity to a PostListOutDto with additional
   * details for a specific user.
   *
   * @param post   The Post entity to convert.
   * @param userId The ID of the user for whom the details are being retrieved.
   * @return A PostListOutDto object representing the converted Post with
   *         additional details for the specified user.
   */
  private PostListOutDto convertToDTOListWithUserId(Post post, String userId) {
    PostListOutDto postListOutDTO = new PostListOutDto();
    postListOutDTO.setId(post.getId());
    postListOutDTO.setTitle(post.getTitle());
    postListOutDTO.setContent(post.getContent());
    postListOutDTO.setUserId(post.getUserId());
    postListOutDTO.setCreatedDate(post.getCreatedDate());
    postListOutDTO.setFullname(post.getFullname());
    postListOutDTO.setDesignation(post.getDesignation());
    postListOutDTO.setStatus(post.getStatus());
    postListOutDTO.setTechnology(post.getTechnology());
    postListOutDTO.setLike(userReviewRepository.findByUserIdLikeTrue(userId, post.getId()).size() > 0);
    postListOutDTO.setDislike(userReviewRepository.findByUserIdDislikeTrue(userId, post.getId()).size() > 0);
    postListOutDTO.setReport(userReviewRepository.findByUserIdReportTrue(userId, post.getId()).size() > 0);
    postListOutDTO
        .setLikeCount(blogportalCommonFunctions.getLikeDislikeCountReport("like", post.getId(), userReviewRepository));
    postListOutDTO.setDislikeCount(
        blogportalCommonFunctions.getLikeDislikeCountReport("dislike", post.getId(), userReviewRepository));
    postListOutDTO.setComments(getAllCommentsForPost(post.getId()));
    postListOutDTO.setReportCount(
        blogportalCommonFunctions.getLikeDislikeCountReport("report", post.getId(), userReviewRepository));
    return postListOutDTO;
  }
}