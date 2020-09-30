package online.testing;

import online.testing.user.security.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@EnableSwagger2
@EnableConfigurationProperties(AppProperties.class)
@SpringBootApplication
public class TestingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestingSystemApplication.class, args);
    }

}
