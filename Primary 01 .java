package com.example.Solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Primary
    @Bean
    public Horse horse1() {
        return new Horse("Arabian", "White");
    }

    @Bean
    public Horse horse2() {
        return new Horse("Freisian", "Black");
    }

    public static void main(String[] args) {
        var ctx = SpringApplication.run(SolutionApplication.class, args);
        Horse horse = ctx.getBean(Horse.class);
        System.out.println("Horse breed: " + horse.getBreed());
        System.out.println("Horse color: " + horse.getColor());
    }
}
