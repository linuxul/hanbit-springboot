package com.youtube.project.sample040;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Sample040Application {

    public static void main(String[] args) {
        SpringApplication.run(Sample040Application.class, args);
    }

}
