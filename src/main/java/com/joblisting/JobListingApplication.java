package com.joblisting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class JobListingApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobListingApplication.class, args);
    }
}