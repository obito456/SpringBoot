package com.vijay.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var ctx=SpringApplication.run(ExampleApplication.class, args);
		MyFirstClass myFirstClass=ctx.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.sayHello() );
	}
	
	public MyFirstClass myFirstClass(){
		return new MyFirstClass();
	}
}


package com.vijay.example;

import org.springframework.stereotype.Component;

@Component

public class MyFirstClass {

    public String sayHello(){
        return "Hello from the MyFirstClass";
    }
}
