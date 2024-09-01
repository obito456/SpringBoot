package com.example.Solution;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String breed;
    private String color;

    public void ride() {
        System.out.println(breed + " is riding fast");
    }
}

@AllArgsConstructor
@Service
class Cart {
    private final Horse horse;

    public void send() {
        horse.ride();
    }
}

@Configuration
class Appconfig {
    @Bean
    @Profile("fresian")
    public Horse horse1() {
        return new Horse(null, "Fresian", "black");
    }
    @Bean
    @Profile("mustang")
    public Horse horse2() {
        return new Horse(null, "Mustang", "brown");
    }
}

@SpringBootApplication
public class SolutionApplication {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(SolutionApplication.class, args);
        Cart cart = ctx.getBean(Cart.class);
        cart.send();
    }
}
