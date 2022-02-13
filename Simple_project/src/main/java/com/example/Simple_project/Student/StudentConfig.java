package com.example.Simple_project.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;

@Configuration
public class StudentConfig {

    //we want to have a
    @Bean
    //get access to the repository by injecting it as an argument
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student John = new Student(
                    "john@gmail.com",
                    "john",
                    LocalDate.of(1999, Month.JUNE, 7)
                    //Period.between((LocalDate.of(1999, Month.JUNE, 7)),LocalDate.now()).getYears()
            );
            Student Tom = new Student(
                    "tom@gmail.com",
                    "tom",
                    LocalDate.of(1998, Month.JUNE, 6)
            );

            //To save them in our DB we do as follows:
            repository.saveAll(List.of(John, Tom));
        };
    }
}
