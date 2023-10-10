package blogportal.application.entity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import blogportal.application.Role;
import blogportal.application.Status;
import blogportal.application.Technology;
import java.util.Arrays;
import java.util.List;
public class UserReviewTest {
    @Test
    public void testConstructorAndGetters() {
        Post post = new Post("1", "Sample Post", "Content", null, "1", Technology.JAVA, null, "Fullname", "Designation", Status.APPROVED);
        User user = new User("2", "John", "Doe", "johndoe", "john@example.com", "password", "Author", "Male", Role.EMPLOYEE, "12345");
        List<String> comments = Arrays.asList("Comment 1", "Comment 2");
        UserReview userReview = new UserReview("1", post, user, true, false, true, comments);
        assertEquals("1", userReview.getId());
        assertEquals(post, userReview.getPost());
        assertEquals(user, userReview.getUser());
        assertTrue(userReview.isLike());
        assertFalse(userReview.isDislike());
        assertTrue(userReview.isReport());
        assertEquals(comments, userReview.getComment());
    }

    @Test
    public void testSetters() {
        UserReview userReview = new UserReview();
        Post post = new Post("1", "Sample Post", "Content", null, "1", Technology.JAVA, null, "Fullname", "Designation", Status.APPROVED);
        User user = new User("2", "John", "Doe", "johndoe", "john@example.com", "password", "Author", "Male", Role.EMPLOYEE, "12345");
        List<String> comments = Arrays.asList("Comment 1", "Comment 2");

        userReview.setId("1");
        userReview.setPost(post);
        userReview.setUser(user);
        userReview.setLike(true);
        userReview.setDislike(false);
        userReview.setReport(true);
        userReview.setComment(comments);

        assertEquals("1", userReview.getId());
        assertEquals(post, userReview.getPost());
        assertEquals(user, userReview.getUser());
        assertTrue(userReview.isLike());
        assertFalse(userReview.isDislike());
        assertTrue(userReview.isReport());
        assertEquals(comments, userReview.getComment());
    }

    @Test
    public void testToString() {
        Post post = new Post("1", "Sample Post", "Content", null, "1", Technology.REACT_JS, null, "Fullname", "Designation", Status.APPROVED);
        User user = new User("2", "John", "Doe", "johndoe", "john@example.com", "password", "Author", "Male", Role.ADMIN, "12345");
        List<String> comments = Arrays.asList("Comment 1", "Comment 2");

        UserReview userReview = new UserReview("1", post, user, true, false, true, comments);

        String expectedString = "UserReview{id='1', post=Post{id='1', title='Sample Post', content='Content', user=null, userId='1', technology=REACT_JS, createdDate=null, fullname='Fullname', designation='Designation', status=APPROVED}, user=User [id=2, firstname=John, lastname=Doe, username=johndoe, email=john@example.com, password=password, designation=Author, gender=Male, role=ADMIN], like=true, dislike=false, report=true, comment=[Comment 1, Comment 2]}";
        assertEquals(expectedString, userReview.toString());
    }

    
}
