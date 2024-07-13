package com.example.vijay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VijayApplication {
	public static void main(String[] args) {
		var ctx=SpringApplication.run(VijayApplication.class, args);
		Myservice myservice=ctx.getBean(Myservice.class);
		System.out.println(myservice.tellstory());
		System.out.println(myservice.getcustomProperty());
		System.out.println(myservice.getcustomPropertyInt());
		System.out.println(myservice.getcustomPropertyFromAnotherFile());
	  System.out.println(myservice.getcustomtwoPropertyFromAnotherFile());
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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
    @PropertySource("classpath:custom.properties"),
    @PropertySource("classpath:customtwo.properties")
})
public class Myservice {
    private final Firstclass firstclass;
    @Value("vijay")
    private String customProperty;
    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;
    @Value("${my.props}")
    private String customtwoPropertyFromAnotherFile;
    @Value("123")
    private Integer customPropertyInt;

    public Myservice(@Qualifier("bean1")Firstclass firstclass){
        this.firstclass=firstclass;
    }
    public String tellstory(){
        return "story is "+firstclass.greets();
    }
    public String getcustomPropertyFromAnotherFile(){
        return customPropertyFromAnotherFile;
    }
   public String getcustomtwoPropertyFromAnotherFile(){
        return customtwoPropertyFromAnotherFile;
    }
    public String getcustomProperty(){
        return customProperty;
    }
    public Integer getcustomPropertyInt(){
        return customPropertyInt;
    }
}
