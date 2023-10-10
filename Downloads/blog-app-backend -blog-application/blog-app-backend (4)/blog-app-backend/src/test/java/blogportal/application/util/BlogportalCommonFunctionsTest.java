package blogportal.application.util;

import blogportal.application.entity.Post;
import blogportal.application.entity.User;
import blogportal.application.entity.UserReview;
import blogportal.application.repository.UserReviewRepository;
import blogportal.application.utils.BlogportalCommonFunctions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class BlogportalCommonFunctionsTest {
	@Mock
	UserReviewRepository userReviewRepository;
	
	@InjectMocks
	BlogportalCommonFunctions commonFunctions;
    @Test
    public void testGetLikeDislikeCountReport() {
        // Create a mock UserReviewRepository
        UserReviewRepository userReviewRepository = Mockito.mock(UserReviewRepository.class);

        // Create a list of dummy reviews for testing
        List<UserReview> reviews = new ArrayList<>();
        reviews.add(new UserReview("1", new Post(),new User(), true, false, false,(List<String>)(new ArrayList<String>())));
        reviews.add(new UserReview("2", new Post(),new User(), true, false, false,(List<String>)(new ArrayList<String>())));
        reviews.add(new UserReview("3", new Post(),new User(), false, true, false,(List<String>)(new ArrayList<String>())));

        // Mock the behavior of the repository's methods
        Mockito.when(userReviewRepository.findByPostIdAndLike("post1")).thenReturn(reviews.stream().filter(p->p.isLike()).collect(Collectors.toList()));
        Mockito.when(userReviewRepository.findByPostIdAndDislike("post1")).thenReturn(reviews.stream().filter(p->p.isDislike()).collect(Collectors.toList()));
        Mockito.when(userReviewRepository.findAllPostIdAndReport("post1")).thenReturn(reviews.stream().filter(p->p.isReport()).collect(Collectors.toList()));



        assert(commonFunctions.getLikeDislikeCountReport("like", "post1", userReviewRepository) == 2);
        assert(commonFunctions.getLikeDislikeCountReport("dislike", "post1", userReviewRepository) == 1);
        assert(commonFunctions.getLikeDislikeCountReport("report", "post1", userReviewRepository) == 0);
    }

    @Test
    public void testGetLikeDislikeUsersList() {
        // Create a mock UserReviewRepository
        UserReviewRepository userReviewRepository = Mockito.mock(UserReviewRepository.class);

        // Create a list of dummy reviews for testing
        List<UserReview> reviews = new ArrayList<>();
        User user1=new User();
        user1.setUsername("abc");
        User user2=new User();
        user2.setUsername("def");
        User user3=new User();
        user3.setUsername("ghi");
        reviews.add(new UserReview("1", new Post(),user1, true, false, false,(List<String>)(new ArrayList<String>())));
        reviews.add(new UserReview("2", new Post(),user2, true, false, false,(List<String>)(new ArrayList<String>())));
        reviews.add(new UserReview("3", new Post(),user3, false, true, false,(List<String>)(new ArrayList<String>())));


        // Mock the behavior of the repository's methods
        Mockito.when(userReviewRepository.findByPostIdAndLike("post1")).thenReturn(reviews.stream().filter(p->p.isLike()).collect(Collectors.toList()));
        Mockito.when(userReviewRepository.findByPostIdAndDislike("post1")).thenReturn(reviews.stream().filter(p->p.isDislike()).collect(Collectors.toList()));

        // Test the getLikeDislikeUsersList method
        List<String> likeUsersList = commonFunctions.getLikeDislikeUsersList("like", "post1", userReviewRepository);
        List<String> dislikeUsersList = commonFunctions.getLikeDislikeUsersList("dislike", "post1", userReviewRepository);

        assert(likeUsersList.size() == 2);
        assert(likeUsersList.contains("abc"));
        assert(likeUsersList.contains("def"));

        assert(dislikeUsersList.size() == 1);
        assert(dislikeUsersList.contains("ghi"));
    }

    // You can similarly write tests for other methods like verifyPassword, encodePassword, and isLike.
}
