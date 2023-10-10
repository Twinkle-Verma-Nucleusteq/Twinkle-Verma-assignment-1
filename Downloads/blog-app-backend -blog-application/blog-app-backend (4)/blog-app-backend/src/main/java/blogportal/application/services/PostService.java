package blogportal.application.services;

import java.util.List;

import java.util.Map;
import org.springframework.stereotype.Service;
import blogportal.application.Status;
import blogportal.application.payloads.PostInDto;
import blogportal.application.payloads.PostListOutDto;
import blogportal.application.payloads.PostOutDto;
import blogportal.application.payloads.UserReviewInDto;
import blogportal.application.payloads.UserReviewOutDto;

/**
 * Service interface for managing blog posts.
 */
@Service
public interface PostService {
  /**
   * Creates a new blog post based on the provided data.
   *
   * @param postDTO The input data for creating the blog post.
   * @param userId  The ID of the user creating the post.
   * @return The created blog post as a PostOutDto.
   */
  PostOutDto createPost(PostInDto postDTO, String userId);

  /**
   * Get a list of all blog posts.
   *
   * @param postDTO The criteria for filtering the blog posts.
   * @return A list of all blog posts as PostListOutDto objects.
   */
  List<PostListOutDto> getAllPosts(PostInDto postDTO);

  /**
   * Get a blog post by its ID.
   *
   * @param postId The ID of the blog post.
   * @return The blog post as a PostOutDto.
   */
  PostOutDto getPostById(String postId);

  /**
   * Update an existing blog post.
   *
   * @param postId  The ID of the blog post to update.
   * @param postDTO The updated data for the blog post.
   * @return The updated blog post as a PostOutDto.
   */
  PostOutDto updatePost(String postId, PostInDto postDTO);

  /**
   * Delete a blog post by its ID.
   *
   * @param postId The ID of the blog post to delete.
   */
  void deletePost(String postId);

  /**
   * Get a list of unreviewed blog posts.
   *
   * @param postDTO The input criteria for filtering unreviewed posts.
   * @return A list of unreviewed blog posts as PostOutDto objects.
   */
  List<PostListOutDto> getUnreviewedPosts(PostInDto postDTO);


  /**
   * Review a blog post and set its approval status.
   *
   * @param postId The ID of the blog post to review.
   * @param userId
   * @param status The status to set (APPROVED or REJECTED).
   * @return The reviewed blog post as a PostOutDto.
   */
  PostOutDto reviewPost(String postId, String userId, Status status);
  /**
   * Count the number of 'dislike' reactions for a specific post.
   *
   * @param userReviewInDto The input data for counting 'dislike' reactions.
   * @return The count of 'dislike' reactions as a UserReviewOutDto.
   */
  UserReviewOutDto postCountDisLikeByPost(UserReviewInDto userReviewInDto);

  /**
   * Count the number of 'like' reactions for a specific post.
   *
   * @param userReviewInDto The input data for counting 'like' reactions.
   * @return The count of 'like' reactions as a UserReviewOutDto.
   */
  UserReviewOutDto postCountLikeByPost(UserReviewInDto userReviewInDto);

  /**
   * Get comments for a specific post.
   *
   * @param userReviewInDto The input data for retrieving comments.
   * @return A map of comments by user as a UserReviewOutDto.
   */
  Map<String, List<String>> postCommentByPost(UserReviewInDto userReviewInDto);

  /**
   * Report a blog post by a user.
   *
   * @param postId The ID of the blog post to report.
   * @param userId The ID of the reporting user.
   * @return A map indicating the status of the report as a key-value pair.
   */
  Map<String, Long> postUserReportBlog(String postId, String userId);

  /**
   * Get the report status of a blog post by a user.
   *
   * @param postId The ID of the blog post to check.
   * @return A map indicating whether the user has reported the blog post as a
   *         key-value pair.
   */
  Map<String, Boolean> getUserReportBlog(String postId);

  /**
   * Get a list of all reported blog posts.
   *
   * @return A list of all reported blog posts as PostOutDto objects.
   */
  List<PostOutDto> getAllReportBlog();

  /**
   * Ignore a user's report for a blog post.
   *
   * @param userReviewInDto The input data for ignoring a user's report.
   * @return A map indicating the result of ignoring the user's report as a
   *         key-value pair.
   */
  Map<String, String> postIgnoreUserReportBlog(UserReviewInDto userReviewInDto);

  /**
   * Retrieves a list of all approved blog posts based on the provided criteria.
   *
   * @param postDTO The criteria for filtering the blog posts.
   * @return A list of approved blog posts that match the criteria.
   */
  List<PostListOutDto> getAllApprovedPosts(PostInDto postDTO);

}
