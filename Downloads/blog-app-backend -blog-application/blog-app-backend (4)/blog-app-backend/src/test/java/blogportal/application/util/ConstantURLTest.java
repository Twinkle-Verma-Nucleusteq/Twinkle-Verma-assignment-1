package blogportal.application.util;

import org.junit.jupiter.api.Test;

import blogportal.application.utils.ConstantURL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantURLTest {

    @Test
    public void testBlogUrlConstant() {
        // Verify that the BLOG_URL constant has the expected value
        assertEquals("/posts", ConstantURL.BLOG_URL);
    }

    @Test
    public void testUserUrlConstant() {
        // Verify that the USER_URL constant has the expected value
        assertEquals("/users", ConstantURL.USER_URL);
    }
}