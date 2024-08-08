package com.example.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VijayApplication {

    public static void main(String[] args) {
        var ctx=SpringApplication.run(VijayApplication.class, args);
        Driver driver =ctx.getBean(Driver.class);
        driver.report();
    }
}

package com.example.vijay;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    @Qualifier("white")
    public Car car1(){
        return new Car("white audi");
    }
    @Bean
    @Qualifier("black")
    public Car car2(){
        return new Car("black audi");
    }
}

package com.example.vijay;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Car {
    public String name;
}

package com.example.vijay;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Driver {
    public Car car;

    public Driver(@Qualifier("black") Car car){
        this.car=car;
    }

    public void report(){
        System.out.println("your "+car.name+" is parked");
    }
}
