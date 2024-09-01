package com.example.Solution;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
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
}

@Repository
interface HorseRepository extends JpaRepository<Horse, Long> {
}

@Service
@AllArgsConstructor
class HorseService {
    private final HorseRepository horseRepository;

    public List<Horse> getAllHorses() {
        return horseRepository.findAll();
    }

    public Horse saveHorse(Horse horse) {
        return horseRepository.save(horse);
    }

    public void printHorseDetails(Long id) {
        Horse horse = horseRepository.findById(id).orElse(null);
        if (horse != null) {
            System.out.println("Horse breed: " + horse.getBreed());
            System.out.println("Horse color: " + horse.getColor());
        } else {
            System.out.println("Horse not found.");
        }
    }
}

@SpringBootApplication
public class SolutionApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(SolutionApplication.class, args);
        HorseService horseService = ctx.getBean(HorseService.class);
        Horse newHorse = new Horse(null, "Arabian", "black");
        horseService.saveHorse(newHorse);
        horseService.printHorseDetails(newHorse.getId());
    }
}
