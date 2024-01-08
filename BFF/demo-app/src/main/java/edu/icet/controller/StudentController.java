package edu.icet.controller;

import edu.icet.dto.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


public interface StudentController {
    @GetMapping("student/list")
    List<Student> getStudentList() throws InterruptedException;

    @GetMapping("student/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId);

//    @PostMapping("student/add")
//    public void addStudent(@RequestBody Student student) throws InterruptedException;
    @PutMapping("student/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long studentId);

    @DeleteMapping("student/{id}")
    public void deleteStudentById(@PathVariable("id") Long studentId);
}
