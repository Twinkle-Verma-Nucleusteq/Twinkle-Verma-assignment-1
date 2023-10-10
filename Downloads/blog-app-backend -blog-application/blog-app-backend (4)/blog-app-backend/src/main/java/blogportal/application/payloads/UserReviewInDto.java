package blogportal.application.payloads;
/**
 * Represents the input data for creating or updating a user review on a blog post.
 */
public class UserReviewInDto {
    /**
     * The unique identifier of the user providing the review.
     */
    private String userId;

    /**
     * The unique identifier of the blog post being reviewed.
     */
    private String postId;

    /**
     * Indicates whether the user likes the blog post.
     */
    private boolean like;

    /**
     * Indicates whether the user dislikes the blog post.
     */
    private boolean dislike;

    /**
     * Indicates whether the user is reporting the blog post.
     */
    private boolean report;

    /**
     * Additional comments or feedback provided by the user in the review.
     */
    private String comment;

    /**
     * Default constructor for UserReviewInDto.
     */
    public UserReviewInDto() {
    }

    /**
     * Constructs a new UserReviewInDto with the provided information.
     *
     * @param userId   The unique identifier of the user providing the review.
     * @param postId   The unique identifier of the blog post being reviewed.
     * @param like     Indicates whether the user likes the blog post.
     * @param dislike  Indicates whether the user dislikes the blog post.
     * @param report   Indicates whether the user is reporting the blog post.
     * @param comment  Additional comments or feedback provided by the user in the review.
     */
    public UserReviewInDto(String userId, String postId, boolean like, boolean dislike, boolean report, String comment) {
        this.userId = userId;
        this.postId = postId;
        this.like = like;
        this.dislike = dislike;
        this.report = report;
        this.comment = comment;
    }

    /**
     * Returns a string representation of the UserReviewInDto object.
     *
     * @return A string containing the values of userId, postId, like, dislike, report, and comment.
     */
    @Override
    public String toString() {
      return "UserReviewInDto [userId=" + userId + ", postId=" + postId + ", like=" + like + ", dislike=" + dislike
          + ", report=" + report + ", comment=" + comment + "]";
    }

    /**
     * Get the unique identifier of the user providing the review.
     *
     * @return The user's ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Set the unique identifier of the user providing the review.
     *
     * @param userId The user's ID.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Get the unique identifier of the blog post being reviewed.
     *
     * @return The blog post's ID.
     */
    public String getPostId() {
        return postId;
    }

    /**
     * Set the unique identifier of the blog post being reviewed.
     *
     * @param postId The blog post's ID.
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * Check if the user likes the blog post.
     *
     * @return `true` if the user likes the blog post, otherwise `false`.
     */
    public boolean isLike() {
        return like;
    }

    /**
     * Set whether the user likes the blog post.
     *
     * @param like `true` if the user likes the blog post, otherwise `false`.
     */
    public void setLike(boolean like) {
        this.like = like;
    }

    /**
     * Check if the user dislikes the blog post.
     *
     * @return `true` if the user dislikes the blog post, otherwise `false`.
     */
    public boolean isDislike() {
        return dislike;
    }

    /**
     * Set whether the user dislikes the blog post.
     *
     * @param dislike `true` if the user dislikes the blog post, otherwise `false`.
     */
    public void setDislike(boolean dislike) {
        this.dislike = dislike;
    }

    /**
     * Check if the user is reporting the blog post.
     *
     * @return `true` if the user is reporting the blog post, otherwise `false`.
     */
    public boolean isReport() {
        return report;
    }

    /**
     * Set whether the user is reporting the blog post.
     *
     * @param report `true` if the user is reporting the blog post, otherwise `false`.
     */
    public void setReport(boolean report) {
        this.report = report;
    }

    /**
     * Get additional comments or feedback provided by the user in the review.
     *
     * @return The user's comments.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set additional comments or feedback provided by the user in the review.
     *
     * @param comment The user's comments.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
