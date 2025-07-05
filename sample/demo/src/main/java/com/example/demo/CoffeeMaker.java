package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CoffeeMaker {
    @Autowired
    @Qualifier("dripCoffeeMachine")
    private CoffeeMachine coffeeMachine;

    @PostConstruct
    public void makeCoffee() {
        System.out.println(coffeeMachine.brew());
    }
}
