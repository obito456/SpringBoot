package com.example.Solution;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class  Car{

    @PostMapping("/add/{carName}")
    public void run(@PathVariable String carName) {
        System.out.println("Your car name is "+carName);
    }
}
