package edu.icet.controller;

import edu.icet.dto.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


public interface StudentController {
    @GetMapping("student/list")
    List<Student> getStudentList() throws InterruptedException;

    @GetMapping("student/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId);

    @PostMapping("student/add")
    public Student addStudent(@RequestBody Student student) throws InterruptedException;

//    @PatchMapping("student/{id}")
//    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long studentId);

    @DeleteMapping("student/{id}")
    public Map deleteStudentById(@PathVariable("id") Long studentId);
    //--path variable

}
