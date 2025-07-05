package com.example.demo2;

import org.springframework.stereotype.Component;

@Component
public class Pi {

    @PrintExecuteTime
    double calculate(int points) {
        int circle = 0;
        for (long i = 0; i < points; i++) {
            double x = Math.random() * 2 - 1;
            double y = Math.random() * 2 - 1;

            if (x * x + y * y <= 1) {
                circle++;
            }
        }

        return 4.0 * circle / points;
    }
}
