package blogportal.application.payloads;
import java.util.Date;
import blogportal.application.Status;
import blogportal.application.Technology;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents the input data for creating or updating a blog post.
 */
public class PostInDto {
    /**
     * The maximum length allowed for the title.
     */
    private static final int MAX_TITLE_LENGTH = 255;

    /**
     * The title of the blog post.
     */
    @NotNull(message = "Title cannot be null")
    @NotBlank(message = "Title cannot be blank")
    @Size(max = MAX_TITLE_LENGTH, message = "Title cannot exceed " + MAX_TITLE_LENGTH + " characters")
    private String title;
    /**
     * The content of the blog post.
     */
    @NotNull(message = "Content cannot be null")
    @NotBlank(message = "Content cannot be blank")
    private String content;

    /**
     * The technology associated with the blog post.
     */
    @NotNull(message = "Technology cannot be null")
    private Technology technology;

    /**
     * The ID of the author who created the blog post.
     */
    private String userId;

    /**
     * The date when the blog post was created.
     */
    private Date createdDate;
    /**
     * The full name of the blog post author.
     */
    private String fullName;

    /**
     * The designation of the blog post author.
     */
    private String designation;

    /**
     * The status of the blog post.
     */
    private Status status;

    /**
     * Indicates whether the blog post is liked.
     */
    private boolean like;

    /**
     * Indicates whether the blog post is disliked.
     */
    private boolean dislike;

    /**
     * Indicates whether the blog post is reported.
     */
    private boolean report;

    /**
     * The comment associated with the blog post.
     */
    private String comment;

    // Constructors

    /**
     * Default constructor for PostInDto.
     */
    public PostInDto() {
        // Default constructor
    }

    /**
     * Constructs a new PostInDto with the provided information.
     *
     * @param title       The title of the blog post.
     * @param content     The content of the blog post.
     * @param technology  The technology associated with the blog post.
     * @param userId      The user ID of the author.
     * @param createdDate The created date of the blog post.
     * @param fullName    The full name of the blog post author.
     * @param designation The designation of the blog post author.
     * @param status      The status of the blog post.
     * @param like        Indicates whether the blog post is liked.
     * @param dislike     Indicates whether the blog post is disliked.
     * @param report      Indicates whether the blog post is reported.
     * @param comment     The comment associated with the blog post.
     */
    public PostInDto(String title, String content, Technology technology, String userId, Date createdDate,
                     String fullName, String designation, Status status, boolean like, boolean dislike, boolean report,
                     String comment) {
        this.title = title;
        this.content = content;
        this.technology = technology;
        this.userId = userId;
        this.createdDate = createdDate;
        this.fullName = fullName;
        this.designation = designation;
        this.status = status;
        this.like = like;
        this.dislike = dislike;
        this.report = report;
        this.comment = comment;
    }

    // Getter and Setter Methods

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
     * @param title The title.
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
     * @param content The content.
     */
    public void setContent(String content) {
        this.content = content;
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
     * @param technology The technology.
     */
    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    /**
     * Get the user ID of the author.
     *
     * @return The user ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Set the user ID of the author.
     *
     * @param userId The user ID.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Get the created date of the blog post.
     *
     * @return The created date.
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Set the created date of the blog post.
     *
     * @param createdDate The created date.
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Get the full name of the blog post author.
     *
     * @return The full name.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Set the full name of the blog post author.
     *
     * @param fullName The full name.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Get the designation of the blog post author.
     *
     * @return The designation.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Set the designation of the blog post author.
     *
     * @param designation The designation.
     */
    public void setDesignation(String designation) {
        this.designation = designation;
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
     * @param status The status.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Check if the blog post is liked.
     *
     * @return `true` if liked, `false` otherwise.
     */
    public boolean isLike() {
        return like;
    }

    /**
     * Set whether the blog post is liked.
     *
     * @param like `true` if liked, `false` otherwise.
     */
    public void setLike(boolean like) {
        this.like = like;
    }

    /**
     * Check if the blog post is disliked.
     *
     * @return `true` if disliked, `false` otherwise.
     */
    public boolean isDislike() {
        return dislike;
    }

    /**
     * Set whether the blog post is disliked.
     *
     * @param dislike `true` if disliked, `false` otherwise.
     */
    public void setDislike(boolean dislike) {
        this.dislike = dislike;
    }

    /**
     * Check if the blog post is reported.
     *
     * @return `true` if reported, `false` otherwise.
     */
    public boolean isReport() {
        return report;
    }

    /**
     * Set whether the blog post is reported.
     *
     * @param report `true` if reported, `false` otherwise.
     */
    public void setReport(boolean report) {
        this.report = report;
    }

    /**
     * Get the comment associated with the blog post.
     *
     * @return The comment.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set the comment associated with the blog post.
     *
     * @param comment The comment.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}


