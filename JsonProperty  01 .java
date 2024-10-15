package com.example.Solution;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @JsonProperty("cn")
    String customerName;
    @JsonProperty("fd")
    String Food;
    @JsonProperty("qt")
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
