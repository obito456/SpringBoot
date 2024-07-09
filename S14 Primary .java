package com.example.vijay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VijayApplication {
	public static void main(String[] args) {
		var ctx=SpringApplication.run(VijayApplication.class, args);
		Myservice myservice=ctx.getBean(Myservice.class);
		System.out.println(myservice.tellstory());
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
import org.springframework.context.annotation.Primary;

@Configuration
public class Appconfig {
    @Bean
    public Firstclass myfirstclass(){
		return new Firstclass("vijaykumar");
    }
    @Bean
    public Firstclass mysecondlass(){
		return new Firstclass("vipparthi");
    }
    @Bean
    @Primary
    public Firstclass mythirdlass(){
		return new Firstclass("boom boom");
	}   
}

package com.example.vijay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Myservice {
    @Autowired
    private Firstclass firstobj;
    public String tellstory(){
        return "story is "+firstobj.greets();
    }
}
