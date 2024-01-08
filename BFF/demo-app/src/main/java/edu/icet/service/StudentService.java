package edu.icet.service;

import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public interface StudentService {
    public List<Student> getStudentList();

    public Student getStudentById(Long studentId);

//    public StudentEntity addStudent(@RequestBody Student student);

    //--update operation
    public Student updateStudent(Student student, Long studentId);

    //--delete operation
    public void deleteStudentById(Long studentId);

}
