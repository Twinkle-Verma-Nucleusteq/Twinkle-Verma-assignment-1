package blogportal.application.dto;

import org.junit.jupiter.api.Test;

import blogportal.application.Status;
import blogportal.application.Technology;
import blogportal.application.payloads.PostInDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Date;

public class PostInDtoTest {

    @Test
    public void testGetterAndSetterMethods() {
        // Create a PostInDto instance
        PostInDto postInDto = new PostInDto();

        // Use Mockito to mock the dependencies (if any)
        // For example, if Technology is an enum, you can mock it like this:
        Technology technology = Technology.ALL;

        // Test the setter methods
        postInDto.setTitle("Test Title");
        postInDto.setContent("Test Content");
        postInDto.setTechnology(technology);
        postInDto.setUserId("TestUser123");
        postInDto.setCreatedDate(new Date());
        postInDto.setFullName("Test User");
        postInDto.setDesignation("Developer");
        postInDto.setStatus(Status.APPROVED);
        postInDto.setLike(true);
        postInDto.setDislike(false);
        postInDto.setReport(true);
        postInDto.setComment("Test Comment");

        // Test the getter methods
        assertEquals("Test Title", postInDto.getTitle());
        assertEquals("Test Content", postInDto.getContent());
        assertEquals(technology, postInDto.getTechnology());
        assertEquals("TestUser123", postInDto.getUserId());
        assertNotNull(postInDto.getCreatedDate());
        assertEquals("Test User", postInDto.getFullName());
        assertEquals("Developer", postInDto.getDesignation());
        assertEquals(Status.APPROVED, postInDto.getStatus());
        assertTrue(postInDto.isLike());
        assertFalse(postInDto.isDislike());
        assertTrue(postInDto.isReport());
        assertEquals("Test Comment", postInDto.getComment());
    }
    @Test
    public static void constructor(){
    	PostInDto postInDto=new PostInDto("Test Title", "Test Title", Technology.ALL, "TestUser123", new Date(),
    			"Test User", "Developer", Status.APPROVED, true, false, true,
    			"Test Comment");
    	Technology technology = Technology.ALL;
    assertEquals("Test Title", postInDto.getTitle());
    assertEquals("Test Content", postInDto.getContent());
    assertEquals(technology, postInDto.getTechnology());
    assertEquals("TestUser123", postInDto.getUserId());
    assertNotNull(postInDto.getCreatedDate());
    assertEquals("Test User", postInDto.getFullName());
    assertEquals("Developer", postInDto.getDesignation());
    assertEquals(Status.APPROVED, postInDto.getStatus());
    assertTrue(postInDto.isLike());
    assertFalse(postInDto.isDislike());
    assertTrue(postInDto.isReport());
    assertEquals("Test Comment", postInDto.getComment());
    }
}
