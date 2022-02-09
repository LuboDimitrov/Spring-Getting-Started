package com.example.Simple_project;

import com.example.Simple_project.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;

@SpringBootApplication
/*
* RestController annotation is applied to a class to mark it as a request handler,
* and Spring will do the building and provide the RESTful web service at runtime
*
* Endpoints are a more specific or peculiar version of a Controller.
* Rather than rely on a view (such as JSP) to render model data in HTML,
* an endpoint simply returns the data to be written directly to the body of the response(Similar to doing @ResponseBody in Controller).
*/

public class SimpleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleProjectApplication.class, args);
	}



}
