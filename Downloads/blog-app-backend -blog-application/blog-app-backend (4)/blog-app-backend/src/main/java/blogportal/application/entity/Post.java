package blogportal.application.entity;
import java.util.Date;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import blogportal.application.Status;
import blogportal.application.Technology;

/**
 * Represents a blog post in the Blog Portal application.
 */
@Document(collection = "posts")
public class Post {
  /**
   * The unique identifier for the blog post.
   */
  @Id
  private String id;

  /**
   * The title of the blog post.
   */
  private String title;

  /**
   * The content of the blog post.
   */
  private String content;

  /**
   * The ID of the author who created the blog post.
   */
  @DBRef
  private User user;

  /**
   * The ID of the author who created the blog post.
   */
  private String userId;

  /**
   * The technology associated with the blog post for categorization.
   */
  private Technology technology;

  /**
   * Generates a hash code value for this object based on its fields.
   *
   * @return A hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(content, createdDate, designation, fullname, id, status, technology, title, user, userId);
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj The reference object with which to compare.
   * @return `true` if this object is the same as the `obj` argument; `false`
   *         otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Post other = (Post) obj;
    return Objects.equals(content, other.content) && Objects.equals(createdDate, other.createdDate)
        && Objects.equals(designation, other.designation) && Objects.equals(fullname, other.fullname)
        && Objects.equals(id, other.id) && status == other.status && technology == other.technology
        && Objects.equals(title, other.title) && Objects.equals(user, other.user)
        && Objects.equals(userId, other.userId);
  }

  /**
   * Enum representing various technology categories.
   */

  private Date createdDate;

  /**
   * The fullname of the blog post.
   */
  private String fullname;

  /**
   * The designation of the blog post.
   */
  private String designation;

  /**
   * The status of the blog post.
   */
  private Status status;

  /**
   * Default constructor.
   */
  public Post() {
  }

  /**
   * Constructor with parameters.
   *
   * @param id          The unique identifier for the blog post.
   * @param title       The title of the blog post.
   * @param content     The content of the blog post.
   * @param user        The user who created the blog post.
   * @param userId      The ID of the author who created the blog post.
   * @param technology  The technology associated with the blog post.
   * @param createdDate The date when the blog post was created.
   * @param fullname    The fullname of the blog post.
   * @param designation The designation of the blog post.
   * @param status      The status of the blog post.
   */
  public Post(String id, String title, String content, User user, String userId, Technology technology,
      Date createdDate, String fullname, String designation, Status status) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.user = user;
    this.userId = userId;
    this.technology = technology;
    this.createdDate = createdDate;
    this.fullname = fullname;
    this.designation = designation;
    this.status = status;
  }

  /**
   * Get the unique identifier for the blog post.
   *
   * @return The unique identifier.
   */
  public String getId() {
    return id;
  }

  /**
   * Set the unique identifier for the blog post.
   *
   * @param id The unique identifier to set.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get the title of the blog post.
   *
   * @return The title of the blog post.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the title of the blog post.
   *
   * @param title The title to set.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Get the content of the blog post.
   *
   * @return The content of the blog post.
   */
  public String getContent() {
    return content;
  }

  /**
   * Set the content of the blog post.
   *
   * @param content The content to set.
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Get the user who created the blog post.
   *
   * @return The user who created the blog post.
   */
  public User getUser() {
    return user;
  }

  /**
   * Set the user who created the blog post.
   *
   * @param user The user to set.
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * Get the ID of the author who created the blog post.
   *
   * @return The ID of the author.
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Set the ID of the author who created the blog post.
   *
   * @param userId The ID of the author to set.
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * Get the technology associated with the blog post.
   *
   * @return The technology associated with the blog post.
   */
  public Technology getTechnology() {
    return technology;
  }

  /**
   * Set the technology associated with the blog post.
   *
   * @param technology The technology to set.
   */
  public void setTechnology(Technology technology) {
    this.technology = technology;
  }

  /**
   * Get the date when the blog post was created.
   *
   * @return The created date.
   */
  public Date getCreatedDate() {
    return createdDate;
  }

  /**
   * Set the date when the blog post was created.
   *
   * @param createdDate The created date to set.
   */
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  /**
   * Get the fullname of the blog post.
   *
   * @return The fullname of the blog post.
   */
  public String getFullname() {
    return fullname;
  }

  /**
   * Set the fullname of the blog post.
   *
   * @param fullname The fullname to set.
   */
  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  /**
   * Get the designation of the blog post.
   *
   * @return The designation of the blog post.
   */
  public String getDesignation() {
    return designation;
  }

  /**
   * Set the designation of the blog post.
   *
   * @param designation The designation to set.
   */
  public void setDesignation(String designation) {
    this.designation = designation;
  }

  /**
   * Get the status of the blog post.
   *
   * @return The status of the blog post.
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Set the status of the blog post.
   *
   * @param status The status to set.
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  /**
   * Override the toString() method to provide a string representation of the
   * object.
   *
   * @return A string representation of the Post object.
   */
  @Override
  public String toString() {
    return "Post{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", content='" + content + '\'' + ", user=" + user
        + ", userId='" + userId + '\'' + ", technology=" + technology + ", createdDate=" + createdDate + ", fullname='"
        + fullname + '\'' + ", designation='" + designation + '\'' + ", status=" + status + '}';
  }
}
