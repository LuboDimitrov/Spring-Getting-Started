package com.example.Simple_project.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

                            //DEFINITIONS
    /*In software engineering, dependency injection is a technique in which an object receives other objects that it depends on, called dependencies
    *Typically, the receiving object is called a client and the passed-in ('injected') object is called a service
    *The code that passes the service to the client is called the injector.
    *Instead of the client specifying which service it will use, the injector tells the client what service to use
    *The 'injection' refers to the passing of a dependency (a service) into the client that uses it.*/
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService; //This needs to be instantiated
        // we should avoid stuff like = new StudentService(). We can use dependency injection instead
    }
    //GET
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
    //POST
    @PostMapping //to add new resource (that is, in our case store new students)
    //RequestBody: we take the body (json) of the request and then map it into a student
    public void addStudent(@RequestBody Student student) throws StudentAlreadyExistsException {
        studentService.addStudent(student);
    }

    //DELETE
    //to delete we need to do this: DELETE localhost:8080/api/v1/student/1 <-path variable
    @DeleteMapping(path = "{studentId}") // path = /api/v1/student/{studentId}
    public void removeStudent(@PathVariable("studentId") Long id) throws StudentDoesntExist {
        studentService.removeStudent(id);
    }

    //PUT
    //put is used to update
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) throws StudentDoesntExist {
        studentService.updateStudent(id, name, email);

    }
}
