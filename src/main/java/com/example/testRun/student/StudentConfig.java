package com.example.testRun.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student jane = new Student(
                    "Jane",
                    "Harry"
            );

            Student alex = new Student(
                    "Alex",
                    "James"
            );

            repository.saveAll(
                    List.of(jane, alex)
            );
        };
    }
}
