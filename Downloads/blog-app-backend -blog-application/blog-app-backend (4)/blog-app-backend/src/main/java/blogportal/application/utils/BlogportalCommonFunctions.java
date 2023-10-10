package blogportal.application.utils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import blogportal.application.repository.UserReviewRepository;

/**
 * Common utility functions for the BlogPortal application.
 */
public class BlogportalCommonFunctions {

    /**
     * Get the count of likes, dislikes, or reports for a given post.
     *
     * @param review             The type of review (like, dislike, report).
     * @param postId             The ID of the post.
     * @param userReviewRepository The repository for user reviews.
     * @return The count of likes, dislikes, or reports.
     */
    public long getLikeDislikeCountReport(String review, String postId, UserReviewRepository userReviewRepository) {
        if (review.equals("like")) {
            return userReviewRepository.findByPostIdAndLike(postId).size();
        } else if (review.equals("dislike")) {
            return userReviewRepository.findByPostIdAndDislike(postId).size();
        } else {
            return userReviewRepository.findAllPostIdAndReport(postId).size();
        }
    }

    /**
     * Get a list of usernames who liked or disliked a post.
     *
     * @param review             The type of review (like or dislike).
     * @param postId             The ID of the post.
     * @param userReviewRepository The repository for user reviews.
     * @return A list of usernames.
     */
    public List<String> getLikeDislikeUsersList(String review, String postId, UserReviewRepository userReviewRepository) {
        List<String> userIds = new ArrayList<String>();
        if (review.equals("like")) {
            userIds = userReviewRepository.findByPostIdAndLike(postId).stream()
                    .map(userReview -> userReview.getUser().getUsername())
                    .collect(Collectors.toList());
        } else {
            userIds = userReviewRepository.findByPostIdAndDislike(postId).stream()
                    .map(userReview -> userReview.getUser().getUsername())
                    .collect(Collectors.toList());
        }
        return userIds;
    }

    /**
     * Verify if a given password matches the stored password.
     *
     * @param password  The original password.
     * @param password2 The password to compare.
     * @return True if the passwords match, false otherwise.
     */
    public boolean verifyPassword(String password, String password2) {
        return password2.equals(password);
    }

    /**
     * Encode a password using Base64 encoding.
     *
     * @param password The password to encode.
     * @return The encoded password.
     */
    public String encodePassword(String password) {
        // Encode the password using Base64
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        String encodedPassword = Base64.getEncoder().encodeToString(passwordBytes);
        return encodedPassword;
    }

    /**
     * Check if a user has liked a post.
     *
     * @param string             The user ID.
     * @param id                 The post ID.
     * @param userReviewRepository The repository for user reviews.
     * @return True if the user has liked the post, false otherwise.
     */
    public boolean isLike(String string, String id, UserReviewRepository userReviewRepository) {
        // Implement the logic for checking if a user has liked a post
        return false;
    }
}
