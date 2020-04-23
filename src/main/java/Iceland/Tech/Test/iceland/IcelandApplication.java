package Iceland.Tech.Test.iceland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/*
 * Test Comment
 */

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class IcelandApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcelandApplication.class, args);
	}

}
