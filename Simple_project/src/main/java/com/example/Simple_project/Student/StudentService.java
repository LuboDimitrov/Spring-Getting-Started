package com.example.Simple_project.Student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;

/*Class that will serve as Business logic for managing students
 * So service layer is mainly responsible for business logic*/
@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        10L,
                        "john@gmail.com",
                        "john",
                        LocalDate.of(1999, Month.JUNE, 7),
                        Period.between((LocalDate.of(1999, Month.JUNE, 7)),LocalDate.now()).getYears())
        );
    }
}
