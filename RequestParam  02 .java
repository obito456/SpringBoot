package com.example.Solution;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class  Car{

    @GetMapping("/get")
    public void run(@RequestParam("cn") String carName,@RequestParam("cc") String carColor) {
        System.out.println("Your car name is "+carName+" and color is "+carColor);
    }
}
