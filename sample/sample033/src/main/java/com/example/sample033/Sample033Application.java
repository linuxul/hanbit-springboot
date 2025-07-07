package com.example.sample033;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.sample033.mapper")
public class Sample033Application {

	public static void main(String[] args) {
		SpringApplication.run(Sample033Application.class, args);
	}

}
