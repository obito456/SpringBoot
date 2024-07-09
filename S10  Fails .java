package com.vijay.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {
	public static void main(String[] args) {
		var ctx=SpringApplication.run(ExampleApplication.class, args);
		MyFirstClass myFirstClass=ctx.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.sayHello() );
	}
}

package com.vijay.example;

public class MyFirstClass {
    private String myVar;
    public MyFirstClass (String myVar) {
        this.myVar = myVar;
    }
    public String sayHello(){
        return "Hello from the MyFirstClass ==> myVar = " + myVar;
    }
}

package com.vijay.example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean("fir")
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("vijay");
    }
    @Bean("sec")
    public MySecondClass mySecondBean(){
        return new MySecondClass("kumar");
    }
}

package com.vijay.example;
import  org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private MyFirstClass myFirstClass;

    public String tellAStory(){
        return "the dependency is saying :"+ myFirstClass.sayHello();
    }
}
