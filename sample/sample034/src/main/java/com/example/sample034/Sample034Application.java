package com.example.sample034;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Sample034Application {

	public static void main(String[] args) {
		SpringApplication.run(Sample034Application.class, args);
	}

}
