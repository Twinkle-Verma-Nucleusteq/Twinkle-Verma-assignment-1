package blogportal.application.dto;

import org.junit.jupiter.api.Test;

import blogportal.application.Status;
import blogportal.application.Technology;
import blogportal.application.payloads.PostListOutDto;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostListOutDtoTest {

    @Test
    public void testGettersAndSetters() {
        // Create sample data
        String id = "1";
        String title = "Sample Title";
        String content = "Sample Content";
        String userId = "user123";
        Date createdDate = new Date();
        String fullname = "John Doe";
        String designation = "Author";
        Technology technology = Technology.JAVA;
        Status status = Status.PENDING;
        boolean like = true;
        boolean dislike = false;
        boolean report = false;
        long likeCount = 100;
        long dislikeCount = 10;
        long reportCount = 5;
        Map<String, List<String>> comments = new HashMap<>();
        comments.put("User1", Arrays.asList("Comment1", "Comment2"));
        comments.put("User2", Arrays.asList("Comment3", "Comment4"));

        // Create a PostListOutDto instance
        PostListOutDto postDto = new PostListOutDto();
        postDto.setId(id);
        postDto.setTitle(title);
        postDto.setContent(content);
        postDto.setUserId(userId);
        postDto.setCreatedDate(createdDate);
        postDto.setFullname(fullname);
        postDto.setDesignation(designation);
        postDto.setTechnology(technology);
        postDto.setStatus(status);
        postDto.setLike(like);
        postDto.setDislike(dislike);
        postDto.setReport(report);
        postDto.setLikeCount(likeCount);
        postDto.setDislikeCount(dislikeCount);
        postDto.setReportCount(reportCount);
        postDto.setComments(comments);

        // Test getters
        assertEquals(id, postDto.getId());
        assertEquals(title, postDto.getTitle());
        assertEquals(content, postDto.getContent());
        assertEquals(userId, postDto.getUserId());
        assertEquals(createdDate, postDto.getCreatedDate());
        assertEquals(fullname, postDto.getFullname());
        assertEquals(designation, postDto.getDesignation());
        assertEquals(technology, postDto.getTechnology());
        assertEquals(status, postDto.getStatus());
        assertEquals(like, postDto.isLike());
        assertEquals(dislike, postDto.isDislike());
        assertEquals(report, postDto.isReport());
        assertEquals(likeCount, postDto.getLikeCount());
        assertEquals(dislikeCount, postDto.getDislikeCount());
        assertEquals(reportCount, postDto.getReportCount());
        assertEquals(comments, postDto.getComments());
    }
}
