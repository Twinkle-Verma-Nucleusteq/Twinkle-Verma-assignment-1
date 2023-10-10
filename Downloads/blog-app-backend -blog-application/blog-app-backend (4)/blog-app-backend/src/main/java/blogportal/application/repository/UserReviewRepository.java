package blogportal.application.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import blogportal.application.entity.UserReview;
import blogportal.application.payloads.PostListOutDto;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing user reviews in the database.
 */
public interface UserReviewRepository extends MongoRepository<UserReview, String> {
    /**
     * Find a user review by post ID and user ID.
     *
     * @param postId The ID of the post.
     * @param userId The ID of the user.
     * @return An `Optional` containing the user review if found, or an empty
     *         `Optional` if not found.
     */
    Optional<UserReview> findByPostIdAndUserId(String postId, String userId);

    /**
     * Find all user reviews for a specific post ID.
     *
     * @param postId The ID of the post.
     * @return A list of user reviews for the given post ID.
     */
    List<UserReview> findByPostId(String postId);

    /**
     * Find user reviews by post ID and where 'like' is true.
     *
     * @param postId The ID of the post.
     * @return A list of user reviews for the given post ID where 'like' is true.
     */
    @Query("{$and:[{'post.$id':ObjectId(\"?0\")}, {'like': true}]}")
    List<UserReview> findByPostIdAndLike(String postId);

    /**
     * Find user reviews by post ID and where 'dislike' is true.
     *
     * @param postId The ID of the post.
     * @return A list of user reviews for the given post ID where 'dislike' is true.
     */
    @Query("{$and:[{'post.$id':ObjectId(\"?0\")}, {'dislike': true}]}")
    List<UserReview> findByPostIdAndDislike(String postId);

    /**
     * Find all user reviews for a specific post ID where 'report' is true.
     *
     * @param postId The ID of the post.
     * @return A list of user reviews for the given post ID where 'report' is true.
     */
    @Query("{$and:[{'post.$id':ObjectId(\"?0\")}, {'report': true}]}")
    List<UserReview> findAllPostIdAndReport(String postId);

    /**
     * Find all user reviews where 'report' is true.
     *
     * @return A list of user reviews where 'report' is true.
     */
    List<UserReview> findByReportTrue();

    /**
     * Find user reviews by user ID where 'like' is true.
     *
     * @param userId The ID of the user.
     * @param postId The ID of the post.
     * @return A list of user reviews for the given user ID and post ID where 'like' is true.
     */
    @Query("{$and:[{'user.$id':ObjectId(\"?0\")},{'post.$id':ObjectId(\"?1\")}, {'like': true}]}")
    List<UserReview> findByUserIdLikeTrue(String userId, String postId);

    /**
     * Find user reviews by user ID where 'dislike' is true and return as PostListOutDto.
     *
     * @param userId The ID of the user.
     * @param postId The ID of the post.
     * @return A list of PostListOutDto for the given user ID and post ID where 'dislike' is true.
     */
    @Query("{$and:[{'user.$id':ObjectId(\"?0\")},{'post.$id':ObjectId(\"?1\")}, {'dislike': true}]}")
    List<PostListOutDto> findByUserIdDislikeTrue(String userId, String postId);

    /**
     * Find user reviews by user ID where 'report' is true and return as PostListOutDto.
     *
     * @param userId The ID of the user.
     * @param postId The ID of the post.
     * @return A list of PostListOutDto for the given user ID and post ID where 'report' is true.
     */
    @Query("{$and:[{'user.$id':ObjectId(\"?0\")},{'post.$id':ObjectId(\"?1\")}, {'report': true}]}")
    List<PostListOutDto> findByUserIdReportTrue(String userId, String postId);
}
