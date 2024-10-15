package com.example.Solution;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class  Car{

    @PostMapping("/add/{car-Name}")
    public void run(@PathVariable("car-Name") String carName) {
        System.out.println("Your car name is "+carName);
    }
}
