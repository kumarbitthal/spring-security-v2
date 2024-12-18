package kb.spsecurity.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Getter
@Setter
public class DataBaseProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;

}
