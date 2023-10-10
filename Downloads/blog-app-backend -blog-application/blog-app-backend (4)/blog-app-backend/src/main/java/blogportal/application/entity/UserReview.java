package blogportal.application.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
/**
 * Represents a user review for a blog post in the Blog Portal application.
 */
@Document(collection = "userreview")
public class UserReview {
  /**
   * The unique identifier for the user review.
   */
  @Id
  private String id;

  /**
   * The associated blog post for the review.
   */
  @DBRef
  private Post post;

  /**
   * The user who created the review.
   */
  @DBRef
  private User user;

  /**
   * Indicates if the user liked the blog post.
   */
  private boolean like;

  /**
   * Indicates if the user disliked the blog post.
   */
  private boolean dislike;

  /**
   * Indicates if the user reported the blog post.
   */
  private boolean report;

  /**
   * List of comments made by the user on the blog post.
   */
  private List<String> comment;

  /**
   * Default constructor for UserReview.
   */
  public UserReview() {
  }

  /**
   * Parameterized constructor for UserReview.
   *
   * @param id      The unique identifier for the user review.
   * @param post    The associated blog post for the review.
   * @param user    The user who created the review.
   * @param like    Indicates if the user liked the blog post.
   * @param dislike Indicates if the user disliked the blog post.
   * @param report  Indicates if the user reported the blog post.
   * @param comment List of comments made by the user on the blog post.
   */
  public UserReview(String id, Post post, User user, boolean like, boolean dislike, boolean report,
      List<String> comment) {
    this.id = id;
    this.post = post;
    this.user = user;
    this.like = like;
    this.dislike = dislike;
    this.report = report;
    this.comment = comment;
  }
  /**
   * Get the unique identifier for the user review.
   *
   * @return The user review's ID.
   */
  public String getId() {
    return id;
  }

  /**
   * Set the unique identifier for the user review.
   *
   * @param id The user review's ID.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get the associated blog post for the review.
   *
   * @return The associated blog post.
   */
  public Post getPost() {
    return post;
  }

  /**
   * Set the associated blog post for the review.
   *
   * @param post The associated blog post.
   */
  public void setPost(Post post) {
    this.post = post;
  }

  /**
   * Get the user who created the review.
   *
   * @return The user who created the review.
   */
  public User getUser() {
    return user;
  }

  /**
   * Set the user who created the review.
   *
   * @param user The user who created the review.
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * Check if the user liked the blog post.
   *
   * @return `true` if the user liked the blog post, otherwise `false`.
   */
  public boolean isLike() {
    return like;
  }

  /**
   * Set whether the user liked the blog post.
   *
   * @param like `true` if the user liked the blog post, otherwise `false`.
   */
  public void setLike(boolean like) {
    this.like = like;
  }

  /**
   * Check if the user disliked the blog post.
   *
   * @return `true` if the user disliked the blog post, otherwise `false`.
   */
  public boolean isDislike() {
    return dislike;
  }

  /**
   * Set whether the user disliked the blog post.
   *
   * @param dislike `true` if the user disliked the blog post, otherwise `false`.
   */
  public void setDislike(boolean dislike) {
    this.dislike = dislike;
  }

  /**
   * Check if the user reported the blog post.
   *
   * @return `true` if the user reported the blog post, otherwise `false`.
   */
  public boolean isReport() {
    return report;
  }

  /**
   * Set whether the user reported the blog post.
   *
   * @param report `true` if the user reported the blog post, otherwise `false`.
   */
  public void setReport(boolean report) {
    this.report = report;
  }

  /**
   * Get the list of comments made by the user on the blog post.
   *
   * @return List of comments.
   */
  public List<String> getComment() {
    return comment;
  }

  /**
   * Set the list of comments made by the user on the blog post.
   *
   * @param comment List of comments.
   */
  public void setComment(List<String> comment) {
    this.comment = comment;
  }

  /**
   * Override the `toString` method to provide a custom string representation of
   * the UserReview.
   *
   * @return A string representation of the UserReview.
   */
  @Override
  public String toString() {
    return "UserReview{" + "id='" + id + '\'' + ", post=" + post + ", user=" + user + ", like=" + like + ", dislike="
        + dislike + ", report=" + report + ", comment=" + comment + '}';
  }
}
