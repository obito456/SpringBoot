package com.example.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class VijayApplication {

    public static void main(String[] args) {
        var ctx=SpringApplication.run(VijayApplication.class, args);
		Car car1=ctx.getBean(Car.class);
		car1.display();
    }
}

package com.example.vijay;

import org.springframework.stereotype.Component;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
@Component
public class Car {
    @Value("${car.name}")
    private String name;
    public void display(){
        System.out.println("car name : "+name);
    }
}

car.name=BMW
