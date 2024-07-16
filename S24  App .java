package com.example.vijay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VijayApplication {
	public static void main(String[] args) {
		var app=new SpringApplication(VijayApplication.class);
		var ctx=app.run(args);
		Myservice myservice=ctx.getBean(Myservice.class);
		System.out.println(myservice.tellstory());
		System.out.println(myservice.getcustomProperty());
		System.out.println(myservice.getcustomPropertyInt());
	}
}
