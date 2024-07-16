package com.example.vijay;
import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VijayApplication {
	public static void main(String[] args) {
		var app=new SpringApplication(VijayApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
		var ctx=app.run(args);
		Myservice myservice=ctx.getBean(Myservice.class);
		System.out.println(myservice.tellstory());
		System.out.println(myservice.getcustomProperty());
		System.out.println(myservice.getcustomPropertyInt());
	}
}

package com.example.vijay;

public class Firstclass {
    private String name;
    public Firstclass(String name){
        this.name=name;
    }
    public String greets(){
        return "hi hello bye "+name;
    } 
}

package com.example.vijay;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Appconfig {
    @Bean("bean1")
    @Profile("dev")
    public Firstclass myfirstclass(){
		return new Firstclass("vijaykumar");
    }
    @Bean
    @Profile("test")
    public Firstclass mysecondclass(){
		return new Firstclass("vipparthi");
    }
    @Bean
    public Firstclass mythirdlass(){
		return new Firstclass("boom boom");
	}   
}

package com.example.vijay;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Myservice {
    private final Firstclass firstclass;

    @Value("${spring.application.name}")
    private String customProperty;

    @Value("${spring.int.name}")
    private Integer customPropertyInt;

    public Myservice(@Qualifier("bean1")Firstclass firstclass){
        this.firstclass=firstclass;
    }
    public String tellstory(){
        return "story is "+firstclass.greets();
    }
    public String getcustomProperty(){
        return customProperty;
    }
    public Integer getcustomPropertyInt(){
        return customPropertyInt;
    }
}
