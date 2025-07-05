package com.example.demo;

import org.springframework.stereotype.Component;

@Component("dripCoffeeMachine")
public class DripCoffeeMachine implements CoffeeMachine {
    @Override
    public String brew() {
        return "Brewing coffee with Drip Coffee Machine";
    }
}
