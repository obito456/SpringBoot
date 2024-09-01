package com.example.Solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
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
    private int price;
}

@Service
@AllArgsConstructor
class HorseRiding {
    private Horse horse;

    public void details() {
        System.out.println("Horse breed: " + horse.getBreed());
        System.out.println("Horse color: " + horse.getColor());
        System.out.println("Horse color: " + horse.getPrice());
    }
}

@Configuration
class Appconfig{
    @Bean
    public Horse horse1() {
        return new Horse("Arabian", "White",100);
    }
    @Bean
    public Horse horse2() {
        return new Horse("Freisian", "Black",200);
    }
}

@SpringBootApplication
public class SolutionApplication {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(SolutionApplication.class, args);
        HorseRiding horseride = ctx.getBean("horse2",HorseRiding.class);
        horseride.details();
    }
}
