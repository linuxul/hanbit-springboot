package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

//		CoffeeMaker coffeeMaker = new CoffeeMaker();
////		coffeeMaker.setCoffeeMaker(new DripCoffeeMachine());
//		coffeeMaker.setCoffeeMaker(new EspressoMachine());
//		coffeeMaker.makeCoffee();
	}

}
