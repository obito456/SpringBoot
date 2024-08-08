package com.example.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VijayApplication {

    public static void main(String[] args) {
        var ctx=SpringApplication.run(VijayApplication.class, args);
        Showroom showroom =ctx.getBean(Showroom.class);
        showroom.repair();
    }
}
package com.example.vijay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Car car1(){
        return new Car("audi");
    }
}
package com.example.vijay;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Car {
    public String name;
}
package com.example.vijay;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class Showroom {
    public Car car;

    public void repair(){
        System.out.println("your car "+car.name+" is repaired");
    }
}
