package com.example.sample041;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Sample041Application {

	public static void main(String[] args) {
		SpringApplication.run(Sample041Application.class, args);
	}

}
