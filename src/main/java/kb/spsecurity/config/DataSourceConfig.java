package kb.spsecurity.config;

import kb.spsecurity.config.properties.DataBaseProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private final DataBaseProperties dataBaseProperties;

    public DataSourceConfig(DataBaseProperties dataBaseProperties) {
        this.dataBaseProperties = dataBaseProperties;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataBaseProperties.getUrl());
        dataSource.setUsername(dataBaseProperties.getUsername());
        dataSource.setPassword(dataBaseProperties.getPassword());
        dataSource.setDriverClassName(dataBaseProperties.getDriverClassName());
        return dataSource;
    }

}
