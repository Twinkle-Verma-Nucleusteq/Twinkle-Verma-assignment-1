package blogportal.application.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import blogportal.application.Status;
import blogportal.application.entity.Post;

/**
 * Repository interface for managing blog posts in the database.
 */
public interface PostRepository extends MongoRepository<Post, String> {
  /**
   * Find all approved blog posts.
   *
   * @return A list of approved blog posts.
   */
  @Query("{status: 'APPROVED'}")
  List<Post> findAllByStatusApproved();

  /**
   * Find all unreviewed blog posts.
   *
   * @return A list of unreviewed blog posts.
   */
  @Query("{'status': {$not: {$eq: 'APPROVED'}}}")
  List<Post> findAllByStatusUnreviewed();

  /**
   * Find unreviewed blog posts by title.
   *
   * @param title The title to search for.
   * @return A list of unreviewed blog posts matching the title.
   */
  @Query("{$and:[{'title': {$regex : ?0, $options: 'i'}},{'status':{$not:{$eq: 'APPROVED'}}}]}")
  List<Post> findByTitleStatusUnreviewed(String title);

  /**
   * Find unreviewed blog posts by technology.
   *
   * @param technology The technology to filter by.
   * @return A list of unreviewed blog posts matching the technology.
   */
  @Query("{$and:[{'technology': ?0},{'status':{$not:{$eq: 'APPROVED'}}}]}")
  List<Post> findByTechnologyStatusUnreviewed(String technology);

  /**
   * Find unreviewed blog posts by title and technology.
   *
   * @param technology The technology to filter by.
   * @param title     The title to search for.
   * @return A list of unreviewed blog posts matching the title and technology.
   */
  @Query("{$and:[{'title': {$regex : ?1, $options: 'i'}},{'technology': ?0},{'status':{$not:{$eq: 'APPROVED'}}}]}")
  List<Post> findAllByStatusUnreviewedNTitleNTechnology(String technology, String title);

  /**
   * Find all blog posts containing a specified title (case-insensitive).
   *
   * @param userId The userId to search for.
   * @return A list of blog posts matching the search title.
   */
  @Query("{'userId': ?0}")
  List<Post> findAllByUserId(String userId);

  /**
   * Find all blog posts containing a specified title (case-insensitive).
   *
   * @param title The title to search for.
   * @return A list of blog posts matching the search title.
   */
  List<Post> findAllByTitleContainingIgnoreCase(String title);

  /**
   * Find all approved blog posts for a specific technology category.
   *
   * @param status     The status to filter by.
   * @param technology The technology category to filter by.
   * @return A list of approved blog posts for the given technology and status.
   */
  @Query("{$and:[{'technology': ?1},{'status': ?0}]}")
  List<Post> findAllByStatusApprovedAndTechnology(String status, String technology);

  /**
   * Find all approved blog posts for a specific technology category.
   *
   * @param title      The title to filter by.
   * @param technology The technology category to filter by.
   * @return A list of approved blog posts for the given technology and status.
   */
  @Query("{$and:[{'technology': ?0},{'title': {$regex : ?1, $options: 'i'}},{'status': 'APPROVED'}]}")
  List<Post> findAllByStatusApprovedNTitleNTechnology(String technology, String title);

  /**
   * Find all blog posts by a title using a regex pattern (case-insensitive).
   *
   * @param title The title pattern to search for.
   * @return A list of blog posts matching the title pattern.
   */
  List<Post> findByTitleRegex(String title);

  // Add other custom find methods if needed

  /**
   * Find blog posts by title and technology.
   *
   * @param title      The title to search for.
   * @param technology The technology category to filter by.
   * @param userId     The ID of the user to search for.
   * @return A list of blog posts matching the title, technology, and userId.
   */
  @Query("{$and:[{'title': {$regex : ?0, $options: 'i'}}, {'technology': ?1},{'userId': ?2}]}")
  List<Post> findByTitlenTechnologyNUserId(String title, String technology, String userId);

  /**
   * Find blog posts by title, technology, and status.
   *
   * @param title      The title to search for.
   * @param technology The technology category to filter by.
   * @param status     The status to filter by.
   * @param userId     The ID of the user to search for.
   * @return A list of blog posts matching the title, technology, status, and
   *         userId.
   */
  @Query("{$and:[{'title': {$regex : ?0, $options: 'i'}}, {'technology': ?1},{'status': ?2},{'userId': ?3}]}")
  List<Post> findByTitlenTechnologNStatusNUserId(String title, String technology, String status, String userId);

  /**
   * Find blog posts by technology and status.
   *
   * @param technology The technology category to filter by.
   * @param status     The status to filter by.
   * @param userId     The ID of the user to search for.
   * @return A list of blog posts matching the technology, status, and userId.
   */
  @Query("{$and:[{'technology': ?0},{'status': ?1},{'userId': ?2}]}")
  List<Post> findByTechnologNStatusNUserId(String technology, String status, String userId);

  /**
   * Find blog posts by title, technology, and status.
   *
   * @param title    The title to search for.
   * @param approved The status to filter by.
   * @return A list of blog posts matching the title, status, and userId.
   */
  @Query("{$and:[{'title': {$regex : ?0, $options: 'i'}},{'status': ?1}]}")
  List<Post> findByTitleStatusApproved(String title, Status approved);

  /**
   * Find blog posts by title, technology, and status.
   *
   * @param technology The technology category to filter by.
   * @param approved The status to filter by.
   * @return A list of blog posts matching the title, status, and userId.
   */
  @Query("{$and:[{'technology': ?0},{'status': ?1}]}")
  List<Post> findByTechnologyStatusApproved(String technology, Status approved);
  /**
   * Find blog posts by status.
   *
   * @param userId The ID of the user to search for.
   * @param status The status to filter by.
   * @return A list of blog posts matching the status.
   */
  @Query("{$and:[{'status': ?0},{'userId': ?1}]}")
  List<Post> findByStatusNUserId(String status, String userId);

  /**
   * Find blog posts by title and status.
   *
   * @param title  The title to search for.
   * @param status The status to filter by.
   * @param userId The ID of the user to search for.
   * @return A list of blog posts matching the title and status.
   */
  @Query("{$and:[{'title': {$regex : ?0, $options: 'i'}}, {'status': ?1},{'userId': ?2}]}")
  List<Post> findByTitlenStatusNUserId(String title, String status, String userId);

  /**
   * Find blog posts by the user ID.
   *
   * @param userId The ID of the user to filter by.
   * @return A list of blog posts created by the specified user.
   */
  List<Post> getPostByUserId(String userId);

  /**
   * Find blog posts by technology and user ID.
   *
   * @param name   The technology category to filter by.
   * @param userId The ID of the user to search for.
   * @return A list of blog posts matching the technology and user ID.
   */
  @Query("{$and:[{'technology': ?0}, {'userId': ?1}]}")
  List<Post> findByTechnologNUserId(String name, String userId);

  /**
   * Find blog posts by title and user ID using a regex pattern
   * (case-insensitive).
   *
   * @param title  The title pattern to search for.
   * @param userId The ID of the user to search for.
   * @return A list of blog posts matching the title pattern and user ID.
   */
  @Query("{$and:[{'title': {$regex : ?0, $options: 'i'}},{'userId': ?1}]}")
  List<Post> findByTitleNUserId(String title, String userId);

}
