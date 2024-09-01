package com.example.Solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String breed;
    private String color;
}

interface HorseRepository extends JpaRepository<Horse, Long> {

}

@Service
class HorseService {
    @Autowired
    private HorseRepository horseRepository;

    public List<Horse> getAllHorses() {
        return horseRepository.findAll();
    }
}

@Controller
@RequestMapping("/horses")
class HorseController {
    
    @Autowired
    private HorseService horseService;
    
    @GetMapping
    public String showHorses(Model model) {
        List<Horse> horses = horseService.getAllHorses();
        model.addAttribute("horses", horses);
        return "horses"; 
    }
}

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error"; 
    }
}

@SpringBootApplication
public class SolutionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SolutionApplication.class, args);
    }
}

// <!DOCTYPE html>
// <html xmlns:th="http://www.thymeleaf.org">
// <head>
//     <title>Horses</title>
// </head>
// <body>
//     <h1>List of Horses</h1>
//     <ul>
//         <li th:each="horse : ${horses}">
//             <span th:text="${horse.breed}"></span> - <span th:text="${horse.color}"></span>
//         </li>
//     </ul>
// </body>
// </html>

// <html>
// <body>
//     <h1>Something went wrong!</h1>
//     <p>Please try again later or contact support.</p>
// </body>
// </html>
