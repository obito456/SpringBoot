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
  
    public void selectCar(Car car) {
        this.car=car;
    }
	public void drive(String name) {
        if(car!=null){
			car.drive(name);
		}
		else{
			System.out.println("no car found!");
		}
    }
}

@SpringBootApplication
public class SolutionApplication {
	public static void main(String[] args) {
		SpringApplication.run(SolutionApplication.class, args);
		Car car1=new Car();
		Person person=new Person();
		person.selectCar(car1);
		person.drive("Benz");
	}
}
