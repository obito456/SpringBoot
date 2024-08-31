package com.example.Solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
class Audi {
    public Audi() {
        System.out.println("Audi instance created");
    }
}

@RestController
@RequestMapping("/car")
class Car {
    public Car() {
        System.out.println("Car is created");
    }

    @Autowired
    private Audi audi;

    @GetMapping("/cars")
    public String test() {
        System.out.println("Request received");
        return "Check the console for bean creation messages";
    }
}

@SpringBootApplication
public class SolutionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SolutionApplication.class, args);
    }
}
