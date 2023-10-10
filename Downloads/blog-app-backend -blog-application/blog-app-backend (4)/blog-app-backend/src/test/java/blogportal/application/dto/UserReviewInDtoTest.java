package blogportal.application.dto;

import org.junit.jupiter.api.Test;

import blogportal.application.payloads.UserReviewInDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserReviewInDtoTest {

    @Test
    public void testGetterAndSetterMethods() {
        // Create a UserReviewInDto instance
        UserReviewInDto userReviewInDto = new UserReviewInDto();

        // Mock some data for testing
        String userId = "user123";
        String postId = "post456";
        boolean like = true;
        boolean dislike = false;
        boolean report = true;
        String comment = "This is a test comment";

        // Test the setter methods
        userReviewInDto.setUserId(userId);
        userReviewInDto.setPostId(postId);
        userReviewInDto.setLike(like);
        userReviewInDto.setDislike(dislike);
        userReviewInDto.setReport(report);
        userReviewInDto.setComment(comment);

        // Test the getter methods
        assertEquals(userId, userReviewInDto.getUserId());
        assertEquals(postId, userReviewInDto.getPostId());
        assertEquals(like, userReviewInDto.isLike());
        assertEquals(dislike, userReviewInDto.isDislike());
        assertEquals(report, userReviewInDto.isReport());
        assertEquals(comment, userReviewInDto.getComment());
    }

    @Test
    public void testParameterizedConstructor() {
        // Mock some data for testing
        String userId = "user123";
        String postId = "post456";
        boolean like = true;
        boolean dislike = false;
        boolean report = true;
        String comment = "This is a test comment";

        // Create a UserReviewInDto instance using the parameterized constructor
        UserReviewInDto userReviewInDto = new UserReviewInDto(userId, postId, like, dislike, report, comment);

        // Test the getter methods
        assertEquals(userId, userReviewInDto.getUserId());
        assertEquals(postId, userReviewInDto.getPostId());
        assertEquals(like, userReviewInDto.isLike());
        assertEquals(dislike, userReviewInDto.isDislike());
        assertEquals(report, userReviewInDto.isReport());
        assertEquals(comment, userReviewInDto.getComment());
    }
}
