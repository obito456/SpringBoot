package com.example.Solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
class Horse {
    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void getOSVersion(){
        System.out.println("OS Version: " +System.getProperty("os.version"));
    } 
}

@SpringBootApplication
public class SolutionApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SolutionApplication.class, args);
        Horse horse = ctx.getBean(Horse.class);
        horse.getOSVersion();
    }
}
