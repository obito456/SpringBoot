package com.example.Solution;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    private int classno;
}

@Repository
interface StudentRepository extends JpaRepository<Student,Integer>{

}

@RestController
@RequestMapping("/students")
class Studentcontroller{
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getallstudents(){
        return studentRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        if (!studentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        student.setId(id);
        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
        if (!studentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

@Configuration
class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/students/**").hasRole("ADMIN")
                .anyRequest().authenticated()                      
            )
            .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("vijay")
            .password("Vijayo161733$")
            .roles("USER")
            .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}

@RestController
@RequestMapping("/user")
class UserController {

    @GetMapping("/info")
    public String getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            String password = userDetails.getPassword(); 
            return "Username: " + username + ", Password: " + (password != null ? password : "N/A");
        }

        return "No authenticated user found";
    }
}

@SpringBootApplication
public class SolutionApplication {
    @Autowired
    private StudentRepository studentRepository;

    @Bean
    public Student student1(){
        Student student1=new Student(0,"ajay","male",5);
        studentRepository.save(student1);
        return student1;
    }
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SolutionApplication.class, args);
        Student student1=ctx.getBean(Student.class);
        System.out.println(student1.getName());
    }
}
