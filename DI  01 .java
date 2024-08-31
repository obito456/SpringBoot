package com.example.Solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

class Car {
    public void drive(String name) {
        System.out.println(" I will to travel on "+ name);
    }
}

class Person {
    private Car car;

    public Person(Car car) {
        this.car=car;
	}

    public void favourite(String name) {
        car.drive(name);
    }
}

@SpringBootApplication
public class SolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolutionApplication.class, args);
		Car car1=new Car();
		Person person=new Person(car1);
		person.favourite("Ferrari");
	}
}
