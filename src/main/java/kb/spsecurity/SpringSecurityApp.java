package kb.spsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaRepositories(basePackages = {"kb.spsecurity.auth.repository"})
//@EntityScan(basePackages = "kb.spsecurity.auth.model")
@SpringBootApplication
public class SpringSecurityApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApp.class, args);
    }
}