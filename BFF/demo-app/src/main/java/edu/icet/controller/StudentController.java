package edu.icet.controller;

import edu.icet.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


public interface StudentController {
    @GetMapping("student/list")
    List<Student> getStudentList() throws InterruptedException;

    @PostMapping("student/add")
    public void addStudent(@RequestBody Student student) throws InterruptedException;
}
