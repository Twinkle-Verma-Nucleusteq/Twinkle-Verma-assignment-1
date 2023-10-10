package blogportal.application.entity;

import org.junit.jupiter.api.Test;
import blogportal.application.Status;
import blogportal.application.Technology;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostEntityTest {

    @Test
    public void testGettersAndSetters() {
        // Create sample data
        String id = "1";
        String title = "Sample Title";
        String content = "Sample Content";
        User user = new User(); // You may need to create a User instance with appropriate data
        String userId = "user123";
        Technology technology = Technology.JAVA;
        Date createdDate = new Date();
        String fullname = "John Doe";
        String designation = "Author";
        Status status = Status.APPROVED;

        // Create a Post instance
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setUser(user);
        post.setUserId(userId);
        post.setTechnology(technology);
        post.setCreatedDate(createdDate);
        post.setFullname(fullname);
        post.setDesignation(designation);
        post.setStatus(status);

        // Test getters
        assertEquals(id, post.getId());
        assertEquals(title, post.getTitle());
        assertEquals(content, post.getContent());
        assertEquals(user, post.getUser());
        assertEquals(userId, post.getUserId());
        assertEquals(technology, post.getTechnology());
        assertEquals(createdDate, post.getCreatedDate());
        assertEquals(fullname, post.getFullname());
        assertEquals(designation, post.getDesignation());
        assertEquals(status, post.getStatus());
    }
}
