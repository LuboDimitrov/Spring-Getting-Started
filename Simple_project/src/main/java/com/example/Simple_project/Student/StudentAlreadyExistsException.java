package com.example.Simple_project.Student;

public class StudentAlreadyExistsException extends Exception {

    public StudentAlreadyExistsException () {
        super ("Student has been already registered in the system");
    }
}
