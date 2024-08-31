package com.example.Solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@AllArgsConstructor
@Setter
@Getter
class Audi {
    String name;
    public Audi() {
        System.out.println("car instance created");
    }
}

@RestController
@RequestMapping("/car")
class Car {
    @Autowired
    private Audi audi;

    public Car() {
        System.out.println("Car is created");
    }

    @GetMapping("/set")
    public String setName(@RequestParam String value) {
        audi.setName(value);
        return "Name set to: " + value;
    }
    @GetMapping("/get")
    public String getName() {
        return "Current Name: " + (audi.getName() != null ? audi.getName() : "No name set");
    }
}

@SpringBootApplication
public class SolutionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SolutionApplication.class, args);
    }
}
