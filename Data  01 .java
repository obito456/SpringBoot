package com.example.Solution;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    String customerName;
    String Food;
    int quantity;
}

@RestController
@RequestMapping("/zomato")
class Zomato{

    @PostMapping("/order")
    public void run(@RequestBody Order order) {
        System.out.println("You ordered "+order);
    }
}
