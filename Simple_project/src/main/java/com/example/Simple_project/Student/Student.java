package com.example.Simple_project.Student;

import javax.persistence.*; //important pq si canviam de hibernate a un altre porveidor tot se quedará igual.
import java.time.LocalDate;
import java.time.Period;

//import from java.persistance and not from org.springframework.data.annotation
@Entity //for hibernate
@Table //for the table in our DB

//With all the @s we ve mapped our class into a table in our DB
public class Student {
    /*Every JPA entity is required to have a field which maps to primary key of the database table.
    Such field must be annotated with @Id.*/
    @Id //com que esta per damunt de Long id, pues s id sera sa primary key
    /*This annotation controls how database sequence or table is mapped.*/
    /*Esta anotación se define por lo general a nivel de clase, y
    es utilizada para indicarle a JPA que secuencia debe de utilizar para insertar en la base de datos.*/
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            /*'allocationSize' doesn't mean that the entities ids will increase by this value but
            it is a number after which the database query will be made again to get the next database sequence value.*/
            allocationSize = 1 //The default increment value is 1.
    )
    /*A sequence in PostgreSQL is a user-defined schema-bound object that
     generates a sequence of integers based on a specified specification.*/


    @GeneratedValue(
            /*With this strategy, underlying persistence provider must use a database sequence
            to get the next unique primary key for the entities.*/
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    //Attributes
    private Long id;
    private String email;
    private String name;
    private LocalDate dob;
    @Transient //this way we dont store the age in our DB
    private Integer age;

    //Null constructor
    public Student() {
    }

    public Student(Long id, String email, String name, LocalDate dob) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.dob = dob;
    }

    //Without the ID because the DB will generate it for us
    public Student(String email, String name, LocalDate dob) {
        this.email = email;
        this.name = name;
        this.dob = dob;
    }

    //Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}

//Shitft + Down to extend selection s
