package blogportal.application.payloads;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import blogportal.application.Status;
import blogportal.application.Technology;
/**
 * Represents the output data for a blog post.
 */
public class PostListOutDto {

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
     * Indicates whether the user liked the blog post.
     */
    private boolean like;

    /**
     * Indicates whether the user disliked the blog post.
     */
    private boolean dislike;

    /**
     * Indicates whether the blog post was reported.
     */
    private boolean report;

    /**
     * The count of likes on the blog post.
     */
    private long likeCount;

    /**
     * The count of dislikes on the blog post.
     */
    private long dislikeCount;

    /**
     * The count of reports on the blog post.
     */
    private long reportCount;

    /**
     * The comments on the blog post.
     */
    private Map<String, List<String>> comments;

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

    /**
     * Indicates whether the user liked the blog post.
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
     * Indicates whether the user disliked the blog post.
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
     * Indicates whether the blog post was reported.
     *
     * @return `true` if the blog post was reported, otherwise `false`.
     */
    public boolean isReport() {
        return report;
    }

    /**
     * Set whether the blog post was reported.
     *
     * @param report `true` if the blog post was reported, otherwise `false`.
     */
    public void setReport(boolean report) {
        this.report = report;
    }

    /**
     * Get the count of likes on the blog post.
     *
     * @return The count of likes.
     */
    public long getLikeCount() {
        return likeCount;
    }

    /**
     * Set the count of likes on the blog post.
     *
     * @param likeCount The count of likes to set.
     */
    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * Get the count of dislikes on the blog post.
     *
     * @return The count of dislikes.
     */
    public long getDislikeCount() {
        return dislikeCount;
    }

    /**
     * Set the count of dislikes on the blog post.
     *
     * @param dislikeCount The count of dislikes to set.
     */
    public void setDislikeCount(long dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    /**
     * Get the count of reports on the blog post.
     *
     * @return The count of reports.
     */
    public long getReportCount() {
        return reportCount;
    }

    /**
     * Set the count of reports on the blog post.
     *
     * @param reportCount The count of reports to set.
     */
    public void setReportCount(long reportCount) {
        this.reportCount = reportCount;
    }

    /**
     * Get the comments on the blog post.
     *
     * @return A map of comments where the key is the author's name and the value is a list of comments.
     */
    public Map<String, List<String>> getComments() {
        return comments;
    }

    /**
     * Set the comments on the blog post.
     *
     * @param comments A map of comments where the key is the author's name and the value is a list of comments.
     */
    public void setComments(Map<String, List<String>> comments) {
        this.comments = comments;
    }
}

