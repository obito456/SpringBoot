package com.example.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VijayApplication {

    public static void main(String[] args) {
        var ctx=SpringApplication.run(VijayApplication.class, args);
		Car car1=ctx.getBean(Car.class);
		car1.display();
    }
}

package com.example.vijay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Car {
    private String name;
    public void display(){
        System.out.println("car name : "+name);
    }
}

package com.example.vijay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Car car1(){
        return new Car("Ferrari");
    }
}
