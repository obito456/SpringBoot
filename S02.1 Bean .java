package com.example.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VijayApplication {

    public static void main(String[] args) {
        var ctx=SpringApplication.run(VijayApplication.class, args);
		Car car1=ctx.getBean(Car.class);
		car1.display();
    }

	@Bean
	public Car car1(){
		return new Car("BWM");
	}
}

package com.example.vijay;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Car {
    String name;
    public void display(){
        System.out.println("car name : "+name);
    }
}
