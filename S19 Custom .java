package com.example.vijay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VijayApplication {
	public static void main(String[] args) {
		var ctx=SpringApplication.run(VijayApplication.class, args);
		Myservice myservice=ctx.getBean(Myservice.class);
		System.out.println(myservice.tellstory());
		System.out.println(myservice.getJavaVersion());
    System.out.println(myservice.readProp());
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

@Configuration
public class Appconfig {
    @Bean("bean1")
    public Firstclass myfirstclass(){
		return new Firstclass("vijaykumar");
    }
    @Bean
    public Firstclass mysecondclass(){
		return new Firstclass("vipparthi");
    }
    @Bean
    public Firstclass mythirdlass(){
		return new Firstclass("boom boom");
	}   
}

package com.example.vijay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class Myservice {
    private Firstclass firstobj;
    private Environment environment;
    @Autowired
    public void injectdep(@Qualifier("bean1") Firstclass firstobj){
        this.firstobj=firstobj;
    }
    public String tellstory(){
        return "story is "+firstobj.greets();
    }
    public String getJavaVersion(){
        return environment.getProperty("java.version");
    } 
    public String readProp(){
        return environment.getProperty("spring.application.name");
    }
    @Autowired
    public void setEnvironment(Environment environment){
        this.environment=environment;
    }
}
