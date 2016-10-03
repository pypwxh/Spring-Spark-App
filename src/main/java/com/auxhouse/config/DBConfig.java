package com.auxhouse.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 * Created by harikrishnan on 10/1/16.
 */
@PropertySource("classpath:application.properties")
@Configuration
public class DBConfig {

    @Value("${mysql.url}")
    private String mysqlURL;

    @Value("${mysql.username}")
    private String mysqlusername;

    @Value("${mysql.password}")
    private String mysqlpassword;

    @Value("${mysql.driver-class-name}")
    private String mysqldriver;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(mysqldriver);
        dataSource.setPassword(mysqlpassword);
        dataSource.setUrl(mysqlURL);
        dataSource.setUsername(mysqlusername);
        return dataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
