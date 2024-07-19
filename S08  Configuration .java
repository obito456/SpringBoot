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
}

package com.vijay.example;

public class MyFirstClass {

    private String name="vijay";	
    public String sayHello(){
        return "Hello from the MyFirstClass "+name;
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
