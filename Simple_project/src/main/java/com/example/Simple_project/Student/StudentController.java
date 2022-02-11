package com.example.Simple_project.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;
/*API layer*/
/*
*This class will contain all of the resources of our API*/
@RestController // this makes this class to serve rest end points
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;
    /*So, how do we tell that this studentService should be
    * injected in the constructor down below?
    * */

    /*@Autowired: anything that we pass to the constructor will be injected (will be magically instantiated for us)
    and then injected into the constructor.
    But now we have also to tell that the class StudentService needs to be instantiated,
    it has to be a spring bean (we could use Component annotation but to be more specific we use @Service)*/
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService; //This needs to be instantiated
        // we should avoid stuff like = new StudentService(). We can use dependency injection instead
    }

    @GetMapping /*in order for this method to be served as a restful end point, we need to add @getmapping*/
    public List<Student> getStudents() {
        //We no longer gonna use this, we should call the getStudents() Method using the Service layer
        /*return List.of(
                new Student(
                        10L,
                        "john@gmail.com",
                        "john",
                        LocalDate.of(1999, Month.JUNE, 7),
                        Period.between((LocalDate.of(1999, Month.JUNE, 7)),LocalDate.now()).getYears())
        );*/
        return studentService.getStudents();
    }
}
