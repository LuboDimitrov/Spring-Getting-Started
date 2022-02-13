package com.example.Simple_project.Student;

public class StudentDoesntExist extends Exception {

    public StudentDoesntExist() {
        super("Student does not exist in the system");
    }
}
