package blogportal.application.payloads;

import java.util.List;
import java.util.Map;

/**
 * Represents the output data for a user review.
 */
public class UserReviewOutDto {
    /**
     * The ID of the user submitting the review.
     */
    private String userId;

    /**
     * The ID of the post being reviewed.
     */
    private String postId;

    /**
     * The number of likes for the review.
     */
    private long like;

    /**
     * The number of dislikes for the review.
     */
    private long dislike;

    /**
     * The usernames of users who liked the review.
     */
    private List<String> likeUserName;

    /**
     * The usernames of users who disliked the review.
     */
    private List<String> disLikeUserName;

    /**
     * A map containing comments on the review.
     */
    private Map<String, List<String>> comment;

    /**
     * Default constructor for UserReviewOutDto.
     */
    public UserReviewOutDto() {
    }

    /**
     * Constructs a new UserReviewOutDto object with the provided information.
     *
     * @param userId          The ID of the user submitting the review.
     * @param postId          The ID of the post being reviewed.
     * @param like            The number of likes for the review.
     * @param dislike         The number of dislikes for the review.
     * @param likeUserName    The usernames of users who liked the review.
     * @param disLikeUserName The usernames of users who disliked the review.
     * @param comment         A map containing comments on the review.
     */
    public UserReviewOutDto(String userId, String postId, long like, long dislike, List<String> likeUserName,
                            List<String> disLikeUserName, Map<String, List<String>> comment) {
        this.userId = userId;
        this.postId = postId;
        this.like = like;
        this.dislike = dislike;
        this.likeUserName = likeUserName;
        this.disLikeUserName = disLikeUserName;
        this.comment = comment;
    }

    /**
     * Gets the ID of the user submitting the review.
     *
     * @return The ID of the user.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user submitting the review.
     *
     * @param userId The ID of the user.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the ID of the post being reviewed.
     *
     * @return The ID of the post.
     */
    public String getPostId() {
        return postId;
    }

    /**
     * Sets the ID of the post being reviewed.
     *
     * @param postId The ID of the post.
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * Gets the number of likes for the review.
     *
     * @return The number of likes.
     */
    public long getLike() {
        return like;
    }

    /**
     * Sets the number of likes for the review.
     *
     * @param like The number of likes.
     */
    public void setLike(long like) {
        this.like = like;
    }

    /**
     * Gets the number of dislikes for the review.
     *
     * @return The number of dislikes.
     */
    public long getDislike() {
        return dislike;
    }

    /**
     * Sets the number of dislikes for the review.
     *
     * @param dislike The number of dislikes.
     */
    public void setDislike(long dislike) {
        this.dislike = dislike;
    }

    /**
     * Gets the usernames of users who liked the review.
     *
     * @return The usernames of users who liked the review.
     */
    public List<String> getLikeUserName() {
        return likeUserName;
    }

    /**
     * Sets the usernames of users who liked the review.
     *
     * @param likeUserName The usernames of users who liked the review.
     */
    public void setLikeUserName(List<String> likeUserName) {
        this.likeUserName = likeUserName;
    }

    /**
     * Gets the usernames of users who disliked the review.
     *
     * @return The usernames of users who disliked the review.
     */
    public List<String> getDisLikeUserName() {
        return disLikeUserName;
    }

    /**
     * Sets the usernames of users who disliked the review.
     *
     * @param disLikeUserName The usernames of users who disliked the review.
     */
    public void setDisLikeUserName(List<String> disLikeUserName) {
        this.disLikeUserName = disLikeUserName;
    }

    /**
     * Gets the comments on the review.
     *
     * @return A map containing comments on the review.
     */
    public Map<String, List<String>> getComment() {
        return comment;
    }

    /**
     * Sets the comments on the review.
     *
     * @param comment A map containing comments on the review.
     */
    public void setComment(Map<String, List<String>> comment) {
        this.comment = comment;
    }
}
