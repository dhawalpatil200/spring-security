package com.dhawal.security.controllers;

import com.dhawal.security.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Dhawal", 45),
            new Student(2, "Deven", 50)
    ));

    @GetMapping("/student")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
