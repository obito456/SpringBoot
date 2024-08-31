package com.example.Solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
class Car {
    public Car() {
        System.out.println("car is created");
    }
}

@SpringBootApplication
public class SolutionApplication {
    public static void main(String[] args) {
        var ctx=SpringApplication.run(SolutionApplication.class, args);
        Car car1=ctx.getBean(Car.class);
        Car car2=ctx.getBean(Car.class);
        System.out.println("Are both cars the same? " + (car1 == car2));
    }
}
