package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    @Autowired
    ObjectMapper mapper;

    public List<Student> getStudentList() {

        List<Student> list = new ArrayList<>();
        Iterable<StudentEntity> studentList = studentRepository.findAll();

        Iterator<StudentEntity> iterator = studentList.iterator();

        while(iterator.hasNext()){
            StudentEntity entity = iterator.next();
            Student student = mapper.convertValue(entity, Student.class);
            list.add(student);
        }

        return list;

    }

    public StudentEntity addStudent(@RequestBody Student student) {
        //Model to Entity Conversion
        StudentEntity entity =
                mapper.convertValue(student, StudentEntity.class);

        //Saving Data
        return studentRepository.save(entity);
    }
}
