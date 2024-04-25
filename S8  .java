package com.vijay.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var ctx=SpringApplication.run(ExampleApplication.class, args);
		MyFirstClass myFirstClass=ctx.getBean("myFirstBean",MyFirstClass.class);
		System.out.println(myFirstClass.sayHello() );
	}

	public MyFirstClass myFirstClass(){
		return new MyFirstClass();
	}
}

package com.vijay.example;

public class MyFirstClass {

    public String sayHello(){
        return "Hello from the MyFirstClass";
    }
}

package com.vijay.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ApplicationConfig {
    @Bean
    public MyFirstClass myFirstBean(){
        return new MyFirstClass();
    }
}
