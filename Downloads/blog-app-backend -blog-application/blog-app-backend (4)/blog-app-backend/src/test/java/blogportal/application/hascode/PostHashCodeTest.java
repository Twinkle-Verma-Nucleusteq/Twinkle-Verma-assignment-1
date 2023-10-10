package blogportal.application.hascode;

import org.junit.jupiter.api.Test;

import blogportal.application.entity.Post;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostHashCodeTest {

    @Test
    public void testHashCode() {
        // Create two identical Post objects
        Post post1 = new Post();
        post1.setId("1");
        post1.setTitle("Title");
        post1.setContent("Content");

        Post post2 = new Post();
        post2.setId("1");
        post2.setTitle("Title");
        post2.setContent("Content");

        // Check that their hash codes are the same
        assertEquals(post1.hashCode(), post2.hashCode());
    }

    @Test
    public void testEquals() {
        // Create two identical Post objects
        Post post1 = new Post();
        post1.setId("1");
        post1.setTitle("Title");
        post1.setContent("Content");

        Post post2 = new Post();
        post2.setId("1");
        post2.setTitle("Title");
        post2.setContent("Content");

        // Check that they are equal
        assertTrue(post1.equals(post2));
    }

    @Test
    public void testNotEquals() {
        // Create two different Post objects
        Post post1 = new Post();
        post1.setId("1");
        post1.setTitle("Title1");
        post1.setContent("Content1");

        Post post2 = new Post();
        post2.setId("2");
        post2.setTitle("Title2");
        post2.setContent("Content2");

        // Check that they are not equal
        assertFalse(post1.equals(post2));
    }

    @Test
    public void testEqualsNull() {
        // Create a Post object
        Post post = new Post();
        post.setId("1");
        post.setTitle("Title");
        post.setContent("Content");

        // Check that it's not equal to null
        assertFalse(post.equals(null));
    }
}