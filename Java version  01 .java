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

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    } 

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}

@SpringBootApplication
public class SolutionApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SolutionApplication.class, args);
        Horse horse = ctx.getBean(Horse.class);
        System.out.println("Java version: " + horse.getJavaVersion());
    }
}
