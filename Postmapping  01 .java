package com.example.Solution;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class Car {

    @PostMapping("/run")
    public void run(@RequestBody String msg) {
        System.out.println("Good Morning "+msg);
    }
}
