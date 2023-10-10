package blogportal.application.payloads;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import blogportal.application.Status;
import blogportal.application.Technology;
/**
 * Represents the output data for a blog post.
 */
public class PostOutDto {

  /**
   * The unique identifier for the blog post.
   */
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
  private String userId;

  /**
   * The creation date of the blog post.
   *
   * @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
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
   * The technology associated with the blog post.
   */
  private Technology technology;

  /**
   * The status of the blog post.
   */
  private Status status;
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
   * @return The title.
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
   * @return The content.
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
   * Get the ID of the author who created the blog post.
   *
   * @return The author's ID.
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Set the ID of the author who created the blog post.
   *
   * @param userId The author's ID to set.
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * Get the creation date of the blog post.
   *
   * @return The creation date.
   */
  public Date getCreatedDate() {
    return createdDate;
  }

  /**
   * Set the creation date of the blog post.
   *
   * @param createdDate The creation date to set.
   */
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  /**
   * Get the fullname of the blog post.
   *
   * @return The fullname.
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
   * @return The designation.
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
   * Get the technology associated with the blog post.
   *
   * @return The technology.
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
   * Get the status of the blog post.
   *
   * @return The status.
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

}
