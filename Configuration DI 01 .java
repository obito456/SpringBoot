package com.example.Solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Horse{
	String color;
	String breed;
}
@Component
@NoArgsConstructor
class Cart {
	@Autowired
    private Horse horse1;
	@Autowired
	private Horse horse2;

    public void move() {
        System.out.println("The cart is being pulled by " + horse1.breed+" and "+horse2.breed);
    }
}
@Configuration
class AppConfig {
    @Bean
    public Horse horse1() {
        return new Horse("white", "arabian");
    }

    @Bean
    public Horse horse2() {
        return new Horse("black", "friesian");
    }
}

@SpringBootApplication
public class SolutionApplication {
	public static void main(String[] args) {
		var ctx = SpringApplication.run(SolutionApplication.class, args);
		Cart cart=ctx.getBean(Cart.class);
		cart.move();
	}
}
