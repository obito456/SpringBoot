package com.example.Solution;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class Car {

    @GetMapping("/run")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void run() {
        System.out.println("Car is running");
    }
}
