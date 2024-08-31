package com.example.Solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
class GreetingService {
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
@RestController
class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return greetingService.greet(name);
    }
}

@SpringBootApplication
public class SolutionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SolutionApplication.class, args);
    }
}
