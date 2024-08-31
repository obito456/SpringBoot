package com.example.Solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Horse{
	String color;
	String breed;
}
@Component
@AllArgsConstructor
class Cart {
    private final Horse horse1;
	private final Horse horse2;

    public void move() {
        System.out.println("The cart is being pulled by " + horse1.breed+" and "+horse2.breed);
    }
}

@SpringBootApplication
public class SolutionApplication {
	public static void main(String[] args) {
		var ctx = SpringApplication.run(SolutionApplication.class, args);
		Horse horse1=new Horse("white","arabian");
		Horse horse2=new Horse("black","friesian");
		Cart cart=new Cart(horse1,horse2);
		cart.move();
	}
}
