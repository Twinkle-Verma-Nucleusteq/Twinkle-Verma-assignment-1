package blogportal.application;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * Main class for starting the blogportal application.
 */
@SpringBootApplication
public class Blogportal {
  /**
   * The main method to start the Spring Boot application.
   *
   * @param args The command line arguments passed to the application.
   */
  public static void main(String[] args) {
    SpringApplication.run(Blogportal.class, args);
  }  /**
   * Configures and provides a ModelMapper bean for the application.
   *
   * @return A ModelMapper instance used for object mapping.
   */
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
