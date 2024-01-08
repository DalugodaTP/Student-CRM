package edu.icet.controller.impl;

import edu.icet.controller.StudentController;
import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import edu.icet.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class StudentControllerImpl implements StudentController {
    //--Create an instance of the service layer
    @Qualifier("studentServiceImpl")
    @Autowired
    StudentService service;


    //--get API
    @Override
    public List<Student> getStudentList() throws InterruptedException {
        Thread.sleep(2000);
        //--call for the method from that layer to get student list
        List<Student> studentList = service.getStudentList();
        //--return it through the link to the web browser
        return studentList;
    }

    @Override
    public Student getStudentById(Long studentId) {
        return service.getStudentById(studentId);
    }

//    public void addStudent(Student student) throws InterruptedException {
//        Thread.sleep(2000);
//        service.addStudent(student);
//    }

    @Override
    public Student updateStudent(Student student, Long studentId) {
        return service.updateStudent(student, studentId);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        service.deleteStudentById(studentId);
    }
}
