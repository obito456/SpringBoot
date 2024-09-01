package com.example.Solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Horse {
    private String breed;
    private String color;
}

@SpringBootApplication
public class SolutionApplication {

    @Bean
    public Horse horse1() {
        return new Horse("Arabian", "White");
    }

    public static void main(String[] args) {
        var ctx = SpringApplication.run(SolutionApplication.class, args);
        Horse horse = ctx.getBean("horse1",Horse.class);
        System.out.println("Horse breed: " + horse.getBreed());
        System.out.println("Horse color: " + horse.getColor());
    }
}
