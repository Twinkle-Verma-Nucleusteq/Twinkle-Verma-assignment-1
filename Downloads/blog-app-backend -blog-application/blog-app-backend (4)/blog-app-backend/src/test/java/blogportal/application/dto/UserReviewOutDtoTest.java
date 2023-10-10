package blogportal.application.dto;

import org.junit.jupiter.api.Test;

import blogportal.application.payloads.UserReviewOutDto;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class UserReviewOutDtoTest {

    @Test
    public void testGetterAndSetterMethods() {
        // Create a UserReviewOutDto instance
        UserReviewOutDto userReviewOutDto = new UserReviewOutDto();

        // Mock some data for testing
        List<String> likeUserName = mock(List.class);
        List<String> disLikeUserName = mock(List.class);
        Map<String, List<String>> comment = mock(Map.class);

        // Test the setter methods
        userReviewOutDto.setUserId("TestUser");
        userReviewOutDto.setPostId("TestPost");
        userReviewOutDto.setLike(10);
        userReviewOutDto.setDislike(5);
        userReviewOutDto.setLikeUserName(likeUserName);
        userReviewOutDto.setDisLikeUserName(disLikeUserName);
        userReviewOutDto.setComment(comment);

        // Test the getter methods
        assertEquals("TestUser", userReviewOutDto.getUserId());
        assertEquals("TestPost", userReviewOutDto.getPostId());
        assertEquals(10, userReviewOutDto.getLike());
        assertEquals(5, userReviewOutDto.getDislike());
        assertEquals(likeUserName, userReviewOutDto.getLikeUserName());
        assertEquals(disLikeUserName, userReviewOutDto.getDisLikeUserName());
        assertEquals(comment, userReviewOutDto.getComment());
    }

    @Test
    public void testParameterizedConstructor() {
        // Mock some data for testing
        List<String> likeUserName = mock(List.class);
        List<String> disLikeUserName = mock(List.class);
        Map<String, List<String>> comment = mock(Map.class);

        // Create a UserReviewOutDto instance using the parameterized constructor
        UserReviewOutDto userReviewOutDto = new UserReviewOutDto("TestUser", "TestPost", 10, 5, likeUserName, disLikeUserName, comment);

        // Test the getter methods
        assertEquals("TestUser", userReviewOutDto.getUserId());
        assertEquals("TestPost", userReviewOutDto.getPostId());
        assertEquals(10, userReviewOutDto.getLike());
        assertEquals(5, userReviewOutDto.getDislike());
        assertEquals(likeUserName, userReviewOutDto.getLikeUserName());
        assertEquals(disLikeUserName, userReviewOutDto.getDisLikeUserName());
        assertEquals(comment, userReviewOutDto.getComment());
    }
}
