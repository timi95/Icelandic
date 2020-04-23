package Iceland.Tech.Test.iceland;

import Iceland.Tech.Test.iceland.StorageProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties(StorageProperties.class)
public class IcelandApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcelandApplication.class, args);
	}

}
