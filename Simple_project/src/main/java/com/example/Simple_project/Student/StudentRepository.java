package com.example.Simple_project.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Repository is the convention name for the Data Acces Layer
/*But why do we declare it as an interface?
Because we can later use all the methods of JPARepository in
the service layer without having to implement them (magic)
* */
//JpaRepository<T,ID>Student: Type we want to work with. Long cuz its the id
@Repository //cuz its responsible for data access
public interface StudentRepository extends JpaRepository<Student, Long> {

    //@Query("SELECT stdnt FROM Student stdnt WHERE stdnt.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
