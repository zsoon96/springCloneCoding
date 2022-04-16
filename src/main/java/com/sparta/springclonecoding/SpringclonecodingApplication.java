package com.sparta.springclonecoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringclonecodingApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:/application.properties,"
             + "classpath:/aws.yml";


    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringclonecodingApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}
