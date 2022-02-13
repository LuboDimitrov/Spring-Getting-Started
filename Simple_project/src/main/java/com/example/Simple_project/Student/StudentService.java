package com.example.Simple_project.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;
import java.util.Optional;

/*Class that will serve as Business logic for managing students
 * So service layer is mainly responsible for business logic*/
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
        /*return List.of(
                new Student(
                        10L,
                        "john@gmail.com",
                        "john",
                        LocalDate.of(1999, Month.JUNE, 7),
                        Period.between((LocalDate.of(1999, Month.JUNE, 7)),LocalDate.now()).getYears())
        );*/
    }

    //In this method we could make much more complex validations
    //but lets keep things simple
    public void addStudent(Student student) throws StudentAlreadyExistsException {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new StudentAlreadyExistsException();
        }
        //store the student in our DB
        studentRepository.save(student);

        /*ADD server.error.include-message=always in the properties file
        * to see the error message in postman*/
    }

    public void removeStudent(Long ID) throws StudentDoesntExist {
        boolean exists = studentRepository.existsById(ID);
        if(!exists) throw new StudentDoesntExist();
        studentRepository.deleteById(ID);
    }

    @Transactional // this allows us to not having to write
    public void updateStudent(Long ID, String name, String email) throws StudentDoesntExist {
        Student student = studentRepository.findById(ID)
                .orElseThrow(()-> new StudentDoesntExist());

        if(name != null && !name.equals(student.getName())){
            student.setName(name);
        }

        if(email != null && !email.equals(student.getEmail()) && !studentRepository.findStudentByEmail(email).isPresent()){
            student.setEmail(email);
        }

    }
    /*
    * Maven > Project > Lifecycle > clean and then install
    */
}
