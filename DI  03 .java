package com.example.Solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
class Food {
	String name;
    public void fav(String name) {
        System.out.println("My favourite food is "+name);
    }
}
@Component
class Person {
    private Food food;

	@Autowired
    public Person(Food food) {
        this.food=food;
    }
	public void info(String name) {
       food.fav(name);
    }
}

@SpringBootApplication
public class SolutionApplication {
	public static void main(String[] args) {
		var ctx=SpringApplication.run(SolutionApplication.class, args);
		Person vijay=ctx.getBean(Person.class);
		vijay.info("Chicken biriyani");
	}
}
