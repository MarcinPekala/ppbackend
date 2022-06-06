package com.app.ppbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PpbackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(PpbackendApplication.class, args);
    }

}
